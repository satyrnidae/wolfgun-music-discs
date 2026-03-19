package dev.satyrn.wolfgunmusic.api;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.data.loot.ModLootTables;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public final class LootTableModifierProcessor {
    private LootTableModifierProcessor() {
        NotInitializable.staticClass(LootTableModifierProcessor.class);
    }

    public static void modifyTables(ResourceKey<LootTable> id, LootTable.Builder tableBuilder) {
        if (WolfgunMusicDiscs.MOD_ID.equals(id.location().getNamespace())) {
            WolfgunMusicDiscs.info("Skipping modifier check for our own loot table {}");
            return;
        }

        final ResourceKey<LootTable> dynamicModifierTable = ModLootTables.MODIFIER_MAP.get(id);

        if (dynamicModifierTable != null) {
            WolfgunMusicDiscs.info("Modifying loot table {} with modifier table {}...", id, dynamicModifierTable);
            final LootPool.Builder modifierPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .setBonusRolls(ConstantValue.exactly(0.1F))
                    .add(NestedLootTable.lootTableReference(dynamicModifierTable));
            tableBuilder.withPool(modifierPool);
        } else WolfgunMusicDiscs.info("Skipped unmodified loot table {} (no modifier found)", id);
    }
}
