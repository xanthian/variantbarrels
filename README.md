# Variant Barrels

## Barrels for all wood types

The `26.3_Dynamic-Fabric` branch targets Minecraft 26.3 with Fabric Loader 0.19.3 or newer,
Fabric API, and Java 25.
It creates barrels for planks supplied by installed mods and generates their textures, models,
blockstates, English names, recipes, loot tables, and tags in game.

Each generated barrel uses six planks and two matching slabs. The mod skips woods that lack a
matching slab or already have a matching barrel. The vanilla barrel serves as the spruce variant.
Resource packs can supply their own textures at the generated barrel texture IDs.

Build with `./gradlew build` or `gradlew.bat build` on Windows. The dynamic branch builds
from `src/dynamic`.


![image](https://user-images.githubusercontent.com/7688001/152662619-f63b1c49-8b6f-4b4c-9f3a-9f9e405b1f7e.png)
