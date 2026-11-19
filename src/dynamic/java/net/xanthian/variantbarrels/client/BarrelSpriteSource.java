package net.xanthian.variantbarrels.client;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.atlas.SpriteResourceLoader;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.FrameSize;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.DynamicBarrels;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** Runs as part of atlas stitching, so generation and lifetime follow resource reloads. */
public final class BarrelSpriteSource implements SpriteSource {
    public static final MapCodec<BarrelSpriteSource> CODEC = MapCodec.unit(BarrelSpriteSource::new);
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> FACES = List.of("side", "top", "top_open", "bottom");
    private static final Identifier SPRUCE_PLANKS = Identifier.withDefaultNamespace("textures/block/spruce_planks.png");

    @Override
    public MapCodec<? extends SpriteSource> codec() {
        return CODEC;
    }

    @Override
    public void run(ResourceManager resources, Output output) {
        for (var variant : DynamicBarrels.variants()) {
            Identifier barrel = variant.id();
            for (String face : FACES) {
                Identifier sprite = Identifier.fromNamespaceAndPath(Initialise.MOD_ID,
                        "block/" + barrel.getPath() + "_" + face);
                // A pack may still supply a hand-drawn texture at the original location.
                var override = resources.getResource(TEXTURE_ID_CONVERTER.idToFile(sprite));
                if (override.isPresent()) {
                    output.add(sprite, override.get());
                } else {
                    output.add(sprite, loader -> generate(resources, loader, sprite, variant.planks(), face));
                }
            }
        }
    }

    private static SpriteContents generate(ResourceManager resources, SpriteResourceLoader loader,
                                           Identifier sprite, Identifier planksId, String face) {
        Identifier templateId = Identifier.withDefaultNamespace("textures/block/"
                + "barrel_" + face + ".png");
        try {
            Resource plankResource = PlankTextureResolver.resolve(resources, planksId);
            BufferedImage template = read(builtIn(resources, templateId));
            BufferedImage spruce = read(builtIn(resources, SPRUCE_PLANKS));
            BufferedImage planks = read(plankResource);
            BufferedImage plainPlanks = readPlainPlanks(resources, planksId);
            var animation = plankResource.metadata().getSection(AnimationMetadataSection.TYPE);
            FrameSize frame = animation.map(value -> value.calculateFrameSize(planks.getWidth(), planks.getHeight()))
                    .orElseGet(() -> new FrameSize(planks.getWidth(), planks.getHeight()));
            boolean showAccents = !face.equals("top") && !face.equals("top_open");
            BufferedImage image = BarrelTexture.compose(template, spruce, planks, plainPlanks, frame.width(), frame.height(),
                    showAccents);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            if (!ImageIO.write(image, "PNG", bytes)) {
                throw new IOException("PNG encoder unavailable");
            }
            byte[] png = bytes.toByteArray();
            Resource generated = new Resource(plankResource.source(), () -> new ByteArrayInputStream(png),
                    plankResource::metadata);
            // Let Minecraft validate and load animation and texture metadata normally.
            SpriteContents result = loader.loadSprite(sprite, generated);
            if (result != null) {
                return result;
            }
            LOGGER.warn("Could not load generated texture {}; using the vanilla barrel", sprite);
        } catch (IOException | RuntimeException exception) {
            LOGGER.warn("Could not generate texture {}; using the vanilla barrel", sprite, exception);
        }
        return resources.getResource(templateId).map(resource -> loader.loadSprite(sprite, resource)).orElse(null);
    }

    private static BufferedImage readPlainPlanks(ResourceManager resources, Identifier planks) {
        String path = planks.getPath().replaceFirst("(^|/)(mossy_|flowering_)", "$1");
        if (path.equals(planks.getPath())) {
            return null;
        }
        for (Identifier candidate : List.of(planks.withPath(path), Identifier.withDefaultNamespace(path))) {
            try {
                return read(PlankTextureResolver.resolve(resources, candidate));
            } catch (IOException | RuntimeException ignored) {
                // Try the next namespace, then let the texture generator infer the wood colour.
            }
        }
        return null;
    }

    private static Resource builtIn(ResourceManager resources, Identifier id) throws IOException {
        List<Resource> stack = resources.getResourceStack(id);
        if (stack.isEmpty()) {
            throw new IOException("Missing vanilla texture " + id);
        }
        // Resource stacks are ordered from lowest to highest pack priority.
        return stack.getFirst();
    }

    private static BufferedImage read(Resource resource) throws IOException {
        try (InputStream stream = resource.open()) {
            BufferedImage image = ImageIO.read(stream);
            if (image == null) {
                throw new IOException("Invalid image in pack " + resource.sourcePackId());
            }
            return image;
        }
    }
}
