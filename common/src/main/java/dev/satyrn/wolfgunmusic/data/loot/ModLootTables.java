package dev.satyrn.wolfgunmusic.data.loot;

import com.google.common.collect.ImmutableMap;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import javax.annotation.Nullable;
import java.util.Map;

public final class ModLootTables {

    public static final ResourceKey<LootTable> ANCIENT_CITY_MODIFIER = getLootModifier(BuiltInLootTables.ANCIENT_CITY);
    public static final ResourceKey<LootTable> SIMPLE_DUNGEON_MODIFIER = getLootModifier(BuiltInLootTables.SIMPLE_DUNGEON);
    public static final ResourceKey<LootTable> STRONGHOLD_CORRIDOR_MODIFIER = getLootModifier(BuiltInLootTables.STRONGHOLD_CORRIDOR);
    public static final ResourceKey<LootTable> WOLFGUN_MUSIC_DISCS = registerOverlay("wolfgun_music_discs");
    public static final ResourceKey<LootTable> RUNNING_MUSIC_DISCS = registerOverlay("running_music_discs");
    public static final ResourceKey<LootTable> RUNNING_II_MUSIC_DISCS = registerOverlay("running_ii_music_discs");

    public static final Map<ResourceKey<LootTable>, ResourceKey<LootTable>> MODIFIER_MAP =
            ImmutableMap.<ResourceKey<LootTable>, ResourceKey<LootTable>>builder()
                    .put(BuiltInLootTables.ANCIENT_CITY, ANCIENT_CITY_MODIFIER)
                    .put(BuiltInLootTables.SIMPLE_DUNGEON, SIMPLE_DUNGEON_MODIFIER)
                    .put(BuiltInLootTables.STRONGHOLD_CORRIDOR, STRONGHOLD_CORRIDOR_MODIFIER)
                    .put(createSourceKey("nova_structures", "chests/illager_hideout_heart_loot"),
                            getLootModifier("nova_structures", "chests/illager_hideout_heart_loot"))
                    .put(createSourceKey("nova_structures", "chests/illager_hideout_lesser_tresure"),
                            getLootModifier("nova_structures", "chests/illager_hideout_lesser_tresure"))
                    .put(createSourceKey("nova_structures", "chests/stray_fort_tresure"),
                            getLootModifier("nova_structures", "chests/stray_fort_tresure"))
                    .build();

    private ModLootTables() {
        NotInitializable.staticClass(ModLootTables.class);
    }

    public static ResourceKey<LootTable> getLootModifier(ResourceKey<?> resourceKey) {
        return getLootModifier(resourceKey.location());
    }

    public static ResourceKey<LootTable> getLootModifier(ResourceLocation modifiedLootTable) {
        return register("modifier/" + modifiedLootTable.getNamespace() + '/' + modifiedLootTable.getPath());
    }

    public static ResourceKey<LootTable> getLootModifier(String path) {
        return getLootModifier("minecraft", path);
    }

    public static ResourceKey<LootTable> getLootModifier(String namespace, String path) {
        return register("modifier/" + namespace + '/' + path);
    }

    static ResourceKey<LootTable> createSourceKey(String namespace, String path) {
        final @Nullable ResourceLocation location = ResourceLocation.tryBuild(namespace, path);
        if (location == null) {
            throw new IllegalStateException("Failed to create source key " + namespace + ":" + path);
        }
        return ResourceKey.create(Registries.LOOT_TABLE, location);
    }

    static ResourceKey<LootTable> registerOverlay(String name) {
        return register("overlay/" + name);
    }

    static ResourceKey<LootTable> register(String path) {
        WolfgunMusicDiscs.info("Registering resource location {}:{}", WolfgunMusicDiscs.MOD_ID, path);
        final @Nullable ResourceLocation location = ResourceLocation.tryBuild(WolfgunMusicDiscs.MOD_ID, path);

        if (location == null) {
            throw new IllegalStateException("Failed to register mod resource location");
        }
        return ResourceKey.create(Registries.LOOT_TABLE, location);
    }
}
