package net.xanthian.variantbarrels.platform;

import java.util.Objects;

public final class Platform {
    private static PlatformBackend backend;

    private Platform() {
    }

    public static void initialize(PlatformBackend platform) {
        if (backend != null) {
            throw new IllegalStateException("Variant Barrels has already been initialized");
        }
        backend = Objects.requireNonNull(platform);
    }

    public static PlatformBackend get() {
        return Objects.requireNonNull(backend, "The mod loader must initialize Variant Barrels first");
    }
}
