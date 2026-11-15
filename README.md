![image](https://www.bisecthosting.com/images/CF/Variant_Barrels/BH_VB_Title.png)
<a href="http:/www.curseforge.com/minecraft/mc-mods/variant-barrels-fabric">


## Barrels for all wood types

This Minecraft 1.21.1 branch builds one universal jar for Forge 52.1.20+ and
NeoForge 21.1.266+ (within the 1.21.1 loader series). Both require Java 21.
Install the same jar in either loader's `mods` directory.

Build with `./gradlew build` (Windows: `gradlew.bat build`). The release is
`build/libs/variantbarrels-3.2-universal.jar`. The `neoforge` subproject's jar is
only a development output; distribute the universal jar from the root project.

Barrel behaviour, registrations, and assets are shared. Small adapters in
`src/forge/java` and `neoforge/src/main/java` handle each loader's events,
registries, and inventory capabilities. Optional-mod resources contain both
loaders' conditions. Existing block and block-entity IDs are preserved.

Run `./gradlew runGameTestServer` and `./gradlew :neoforge:runGameTestServer`
to test the packaged universal jar on each loader. These tests check storage,
names, drops, recipes, tags, workstations, fuel, and automation capabilities.
Optional wood mods must themselves support the loader being used.


![image](https://user-images.githubusercontent.com/7688001/152662619-f63b1c49-8b6f-4b4c-9f3a-9f9e405b1f7e.png)
