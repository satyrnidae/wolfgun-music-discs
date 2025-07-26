package dev.satyrn.wolfgunmusic.api;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.data.loot.ModLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public final class LootTableModifierProcessor {
    private LootTableModifierProcessor() {
        throw new AssertionError("Class should not be initialized.");
    }

    public static void modifyTables(LootTables lootManager, ResourceLocation id, LootTable.Builder tableBuilder) {
        if (id.getPath().equals(WolfgunMusicDiscs.MOD_ID)) {
            WolfgunMusicDiscs.info("Skipping modifier check for our own loot table {}");
            return;
        }

        final ResourceLocation dynamicModifierTable = ModLootTables.getLootModifier(id);

        if (lootManager.get(dynamicModifierTable) != LootTable.EMPTY) {
            WolfgunMusicDiscs.info("Modifying loot table {} with modifier table {}...", id, dynamicModifierTable);
            final LootPool.Builder modifierPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .setBonusRolls(ConstantValue.exactly(0.1F))
                    .add(LootTableReference.lootTableReference(dynamicModifierTable));
            tableBuilder.withPool(modifierPool);
        } else WolfgunMusicDiscs.info("Skipped unmodified loot table {} ({} not found)", id, dynamicModifierTable);
    }
}
