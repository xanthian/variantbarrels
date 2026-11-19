package net.xanthian.variantbarrels.client;

import java.awt.Color;
import java.awt.image.BufferedImage;

/** Recolours the barrel's wood without transferring the plank texture's layout. */
final class BarrelTexture {
    private static final int HUE_BINS = 24;

    private BarrelTexture() {}

    static BufferedImage compose(BufferedImage template, BufferedImage spruce, BufferedImage planks,
                                 BufferedImage plainPlanks,
                                 int frameWidth, int frameHeight, boolean showAccents) {
        if (frameWidth <= 0 || frameHeight <= 0
                || planks.getWidth() % frameWidth != 0 || planks.getHeight() % frameHeight != 0) {
            throw new IllegalArgumentException("Plank image must contain complete animation frames");
        }
        Colour reference = average(spruce, 0, 0, spruce.getWidth(), spruce.getHeight(), new Colour(0, 0, 0));
        double referenceLight = Math.max(1, Math.max(lightness(reference.red(), reference.green(), reference.blue()),
                woodLightness(template)));
        BufferedImage result = new BufferedImage(planks.getWidth(), planks.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Colour plainWood = plainPlanks == null ? null
                : average(plainPlanks, 0, 0, plainPlanks.getWidth(), plainPlanks.getHeight(), reference);
        double accentThreshold = showAccents && plainPlanks != null ? accentThreshold(plainPlanks, plainWood) : 0;
        for (int frameY = 0; frameY < result.getHeight(); frameY += frameHeight) {
            for (int frameX = 0; frameX < result.getWidth(); frameX += frameWidth) {
                FramePalette palette = plainWood == null
                        ? palette(planks, frameX, frameY, frameWidth, frameHeight, reference)
                        : new FramePalette(reserveHighlights(plainWood), -1);
                float[] hsb = new float[3];
                for (int y = 0; y < frameHeight; y++) {
                    for (int x = 0; x < frameWidth; x++) {
                        int pixel = template.getRGB(x * template.getWidth() / frameWidth,
                                y * template.getHeight() / frameHeight);
                        int sample = planks.getRGB(frameX + x, frameY + y);
                        Colour target = showAccents && (plainWood == null
                                ? isAccent(hue(sample, hsb), palette.woodHue())
                                : accentDistance(sample, plainWood) > accentThreshold)
                                ? reserveHighlights(new Colour(sample >> 16 & 255, sample >> 8 & 255, sample & 255))
                                : palette.wood();
                        result.setRGB(frameX + x, frameY + y, recolour(pixel, referenceLight, target));
                    }
                }
            }
        }
        return result;
    }

    private static double accentThreshold(BufferedImage planks, Colour wood) {
        double grainDistance = 0;
        for (int y = 0; y < planks.getHeight(); y++) {
            for (int x = 0; x < planks.getWidth(); x++) {
                grainDistance = Math.max(grainDistance, accentDistance(planks.getRGB(x, y), wood));
            }
        }
        // Allow for ordinary colour variation in this wood's grain, including resource pack textures.
        return grainDistance + 0.01;
    }

    private static double accentDistance(int sample, Colour wood) {
        if ((sample >>> 24) < 128) {
            return 0;
        }
        int red = sample >> 16 & 255;
        int green = sample >> 8 & 255;
        int blue = sample & 255;
        double sum = Math.max(1, red + green + blue);
        double woodSum = Math.max(1, wood.red() + wood.green() + wood.blue());
        // Compare channel proportions so ordinary dark and light wood grain stays wood.
        return Math.abs(red / sum - wood.red() / woodSum)
                + Math.abs(green / sum - wood.green() / woodSum)
                + Math.abs(blue / sum - wood.blue() / woodSum);
    }

    private static int recolour(int pixel, double referenceLight, Colour target) {
        int red = pixel >> 16 & 255;
        int green = pixel >> 8 & 255;
        int blue = pixel & 255;
        // Leave the latch, metal bands, and shadow inside the open lid intact.
        if (!isWood(pixel)) {
            return pixel;
        }
        // Apply the same shade to every channel so the highlights keep the wood's hue.
        double shade = lightness(red, green, blue) / referenceLight;
        shade *= 1 + 0.12 * (shade - 1);
        double brightest = Math.max(target.red(), Math.max(target.green(), target.blue()));
        // Compress highlights progressively so pale woods retain the grain in the lid.
        if (shade > 1 && brightest > 0) {
            double headroom = 255 / brightest - 1;
            double highlight = shade - 1;
            shade = 1 + headroom * -Math.expm1(-highlight / headroom);
        }
        return 0xFF000000 | channel(target.red() * shade) << 16
                | channel(target.green() * shade) << 8 | channel(target.blue() * shade);
    }

    private static boolean isWood(int pixel) {
        int red = pixel >> 16 & 255;
        return (pixel >>> 24) == 255 && red >= 48 && red - (pixel & 255) >= 18;
    }

    private static double woodLightness(BufferedImage template) {
        double light = 0;
        int count = 0;
        for (int y = 0; y < template.getHeight(); y++) {
            for (int x = 0; x < template.getWidth(); x++) {
                int pixel = template.getRGB(x, y);
                if (isWood(pixel)) {
                    light += lightness(pixel >> 16 & 255, pixel >> 8 & 255, pixel & 255);
                    count++;
                }
            }
        }
        return count == 0 ? 0 : light / count;
    }

    private static Colour reserveHighlights(Colour colour) {
        double brightest = Math.max(colour.red(), Math.max(colour.green(), colour.blue()));
        double scale = Math.min(1, 232 / Math.max(1, brightest));
        return new Colour(colour.red() * scale, colour.green() * scale, colour.blue() * scale);
    }

    private static double lightness(double red, double green, double blue) {
        return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    }

    private static int channel(double value) {
        return Math.clamp((int) Math.round(value), 0, 255);
    }

    private static Colour average(BufferedImage image, int x, int y, int width, int height, Colour fallback) {
        return averageWood(image, x, y, width, height, fallback, -1);
    }

    private static FramePalette palette(BufferedImage image, int x, int y, int width, int height, Colour fallback) {
        int[] counts = new int[HUE_BINS];
        float[] hsb = new float[3];
        for (int row = y; row < y + height; row++) {
            for (int column = x; column < x + width; column++) {
                int hue = hue(image.getRGB(column, row), hsb);
                if (hue >= 0) {
                    counts[hue]++;
                }
            }
        }
        int woodHue = -1;
        int strongest = 0;
        for (int bin = 0; bin < HUE_BINS; bin++) {
            int weight = counts[bin] * 2 + counts[(bin + HUE_BINS - 1) % HUE_BINS]
                    + counts[(bin + 1) % HUE_BINS];
            if (weight > strongest) {
                woodHue = bin;
                strongest = weight;
            }
        }
        // A few coloured pixels on nearly neutral wood should not determine the base palette.
        if (strongest < (long) width * height / 2) {
            woodHue = -1;
        }
        return new FramePalette(reserveHighlights(averageWood(image, x, y, width, height, fallback, woodHue)), woodHue);
    }

    private static int hue(int pixel, float[] hsb) {
        int red = pixel >> 16 & 255;
        int green = pixel >> 8 & 255;
        int blue = pixel & 255;
        if ((pixel >>> 24) < 128 || Math.max(red, Math.max(green, blue)) - Math.min(red, Math.min(green, blue)) < 20) {
            return -1;
        }
        return (int) (Color.RGBtoHSB(red, green, blue, hsb)[0] * HUE_BINS) % HUE_BINS;
    }

    private static boolean isAccent(int hue, int woodHue) {
        int distance = Math.abs(hue - woodHue);
        return hue >= 0 && woodHue >= 0 && Math.min(distance, HUE_BINS - distance) >= 3;
    }

    private static Colour averageWood(BufferedImage image, int x, int y, int width, int height,
                                      Colour fallback, int woodHue) {
        long red = 0;
        long green = 0;
        long blue = 0;
        long weight = 0;
        float[] hsb = new float[3];
        for (int row = y; row < y + height; row++) {
            for (int column = x; column < x + width; column++) {
                int pixel = image.getRGB(column, row);
                if (woodHue >= 0 && isAccent(hue(pixel, hsb), woodHue)) {
                    continue;
                }
                int alpha = pixel >>> 24;
                red += (pixel >> 16 & 255) * alpha;
                green += (pixel >> 8 & 255) * alpha;
                blue += (pixel & 255) * alpha;
                weight += alpha;
            }
        }
        return weight == 0 ? fallback : new Colour((double) red / weight,
                (double) green / weight, (double) blue / weight);
    }

    private record Colour(double red, double green, double blue) {}
    private record FramePalette(Colour wood, int woodHue) {}
}
