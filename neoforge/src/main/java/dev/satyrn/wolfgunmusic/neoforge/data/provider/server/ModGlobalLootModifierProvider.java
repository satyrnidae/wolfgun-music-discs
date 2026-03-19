package dev.satyrn.wolfgunmusic.neoforge.data.provider.server;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.data.loot.ModLootTables;
import dev.satyrn.wolfgunmusic.neoforge.loot.OverlayLootTableModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public final class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output,
                                         CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, WolfgunMusicDiscs.MOD_ID);
    }

    @Override
    protected void start() {
        this.addOverlay(BuiltInLootTables.SIMPLE_DUNGEON, ModLootTables.WOLFGUN_MUSIC_DISCS);
        this.addOverlay(BuiltInLootTables.STRONGHOLD_CORRIDOR, ModLootTables.WOLFGUN_MUSIC_DISCS);
        this.addOverlay(BuiltInLootTables.ANCIENT_CITY, ModLootTables.WOLFGUN_MUSIC_DISCS);

        this.addOverlay("nova_structures", "chests/illager_hideout_heart_loot", ModLootTables.RUNNING_II_MUSIC_DISCS);
        this.addOverlay("nova_structures", "chests/illager_hideout_lesser_tresure", ModLootTables.RUNNING_MUSIC_DISCS);
        this.addOverlay("nova_structures", "chests/stray_fort_tresure", ModLootTables.WOLFGUN_MUSIC_DISCS);
    }

    private void addOverlay(String namespace, String path, ResourceKey<LootTable> overlay) {
        WolfgunMusicDiscs.info("Adding global loot modifier {}:{}/{}", WolfgunMusicDiscs.MOD_ID, namespace, path);
        final @Nullable ResourceLocation lootTable = ResourceLocation.tryBuild(namespace, path);
        if (lootTable == null) {
            throw new IllegalStateException("Failed to create key " + namespace + ":" + path);
        }
        this.add(namespace + "/" + path,
                new OverlayLootTableModifier(new LootItemCondition[]{LootTableIdCondition.builder(lootTable).build()},
                        UniformFloat.of(0.0F, 1.0F), 0.25F, overlay.location()));
    }

    private void addOverlay(ResourceKey<?> resourceKey, ResourceKey<LootTable> overlay) {
        this.addOverlay(resourceKey.location(), overlay);
    }

    private void addOverlay(ResourceLocation lootTable, ResourceKey<LootTable> overlay) {
        this.addOverlay(lootTable.getNamespace(), lootTable.getPath(), overlay);
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Loot Modifier Provider";
    }
}
