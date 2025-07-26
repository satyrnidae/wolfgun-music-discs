package dev.satyrn.wolfgunmusic.data.loot;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import javax.annotation.Nullable;

public final class ModLootTables {

    public static final ResourceLocation ANCIENT_CITY_MODIFIER = getLootModifier(BuiltInLootTables.ANCIENT_CITY);
    public static final ResourceLocation SIMPLE_DUNGEON_MODIFIER = getLootModifier(BuiltInLootTables.SIMPLE_DUNGEON);
    public static final ResourceLocation STRONGHOLD_CORRIDOR_MODIFIER = getLootModifier(BuiltInLootTables.STRONGHOLD_CORRIDOR);
    public static final ResourceLocation WOLFGUN_MUSIC_DISCS = registerOverlay("wolfgun_music_discs");
    public static final ResourceLocation RUNNING_MUSIC_DISCS = registerOverlay("running_music_discs");
    public static final ResourceLocation RUNNING_II_MUSIC_DISCS = registerOverlay("running_ii_music_discs");

    private ModLootTables() {
        NotInitializable.staticClass(ModLootTables.class);
    }

    public static ResourceLocation getLootModifier(ResourceLocation modifiedLootTable) {
        return register("modifier/" + modifiedLootTable.getNamespace() + '/' + modifiedLootTable.getPath());
    }

    public static ResourceLocation getLootModifier(String path) {
        return getLootModifier("minecraft", path);
    }

    public static ResourceLocation getLootModifier(String namespace, String path) {
        return register("modifier/" + namespace + '/' + path);
    }

    static ResourceLocation registerOverlay(String name) {
        return register("overlay/" + name);
    }

    static ResourceLocation register(String path) {
        WolfgunMusicDiscs.info("Registering resource location {}:{}", WolfgunMusicDiscs.MOD_ID, path);
        final @Nullable ResourceLocation location = ResourceLocation.tryBuild(WolfgunMusicDiscs.MOD_ID, path);
        if (location == null) {
            throw new IllegalStateException("Failed to register mod resource location");
        }
        return location;
    }
}
