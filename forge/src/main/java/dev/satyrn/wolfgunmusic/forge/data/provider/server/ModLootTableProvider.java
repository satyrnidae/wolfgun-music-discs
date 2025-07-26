package dev.satyrn.wolfgunmusic.forge.data.provider.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.satyrn.wolfgunmusic.data.loot.ModLootTables;
import dev.satyrn.wolfgunmusic.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.minecraft.world.level.storage.loot.LootTable.Builder;

public final class ModLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> subProviders;


    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
        this.subProviders = ImmutableList.of(Pair.of(ChestLootModifiers::new, LootContextParamSets.CHEST));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.subProviders;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        // We don't need to validate :3
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Loot Table Provider";
    }

    static final class ChestLootModifiers implements Consumer<BiConsumer<ResourceLocation, Builder>> {
        @Override
        public void accept(BiConsumer<ResourceLocation, Builder> biConsumer) {
            biConsumer.accept(ModLootTables.WOLFGUN_MUSIC_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_AFTER_ANOTHER, ModItems.MUSIC_DISC_BETWEEN_LAYERS,
                            ModItems.MUSIC_DISC_BLACK_DAWN, ModItems.MUSIC_DISC_CLIFF_WHERE,
                            ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY, ModItems.MUSIC_DISC_DEER,
                            ModItems.MUSIC_DISC_EVERY_MORNING, ModItems.MUSIC_DISC_FAR_AWAY,
                            ModItems.MUSIC_DISC_INTO_STARS, ModItems.MUSIC_DISC_LIGHTFORM,
                            ModItems.MUSIC_DISC_MOON_BEAMS, ModItems.MUSIC_DISC_MOON_RAYS, ModItems.MUSIC_DISC_MT_ENNUI,
                            ModItems.MUSIC_DISC_NIGHT_I, ModItems.MUSIC_DISC_NIGHT_II, ModItems.MUSIC_DISC_OF_PLAINS,
                            ModItems.MUSIC_DISC_PALE_STAR, ModItems.MUSIC_DISC_PASSING, ModItems.MUSIC_DISC_PEAKS,
                            ModItems.MUSIC_DISC_THROUGHOUT, ModItems.MUSIC_DISC_TROPIC,
                            ModItems.MUSIC_DISC_UNSEEN_LAND))));
            biConsumer.accept(ModLootTables.RUNNING_MUSIC_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_EVERY_MORNING, ModItems.MUSIC_DISC_MOON_RAYS,
                            ModItems.MUSIC_DISC_AFTER_ANOTHER, ModItems.MUSIC_DISC_THROUGHOUT,
                            ModItems.MUSIC_DISC_BLACK_DAWN, ModItems.MUSIC_DISC_PASSING,
                            ModItems.MUSIC_DISC_UNSEEN_LAND, ModItems.MUSIC_DISC_MT_ENNUI, ModItems.MUSIC_DISC_PEAKS,
                            ModItems.MUSIC_DISC_FAR_AWAY, ModItems.MUSIC_DISC_INTO_STARS))));
            biConsumer.accept(ModLootTables.RUNNING_II_MUSIC_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_NIGHT_I, ModItems.MUSIC_DISC_TROPIC,
                            ModItems.MUSIC_DISC_MOON_BEAMS, ModItems.MUSIC_DISC_OF_PLAINS,
                            ModItems.MUSIC_DISC_LIGHTFORM, ModItems.MUSIC_DISC_BETWEEN_LAYERS,
                            ModItems.MUSIC_DISC_NIGHT_II, ModItems.MUSIC_DISC_CLIFF_WHERE, ModItems.MUSIC_DISC_DEER,
                            ModItems.MUSIC_DISC_PALE_STAR, ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY))));

            final LootTable.Builder allDiscsModifierTable = getModifierTable(ModLootTables.WOLFGUN_MUSIC_DISCS);
            final LootTable.Builder runningModifierTable = getModifierTable(ModLootTables.RUNNING_MUSIC_DISCS);
            final LootTable.Builder running2ModifierTable = getModifierTable(ModLootTables.RUNNING_MUSIC_DISCS);

            // Default overlays
            biConsumer.accept(ModLootTables.ANCIENT_CITY_MODIFIER, allDiscsModifierTable);
            biConsumer.accept(ModLootTables.SIMPLE_DUNGEON_MODIFIER, allDiscsModifierTable);
            biConsumer.accept(ModLootTables.STRONGHOLD_CORRIDOR_MODIFIER, allDiscsModifierTable);

            // Nova Structures (Dungeons & Taverns)
            biConsumer.accept(ModLootTables.getLootModifier("nova_structures", "chests/illager_hideout_heart_loot"),
                    running2ModifierTable);
            biConsumer.accept(ModLootTables.getLootModifier("nova_structures", "chests/illager_hideout_lesser_tresure"),
                    runningModifierTable);
            biConsumer.accept(ModLootTables.getLootModifier("nova_structures", "chests/stray_fort_tresure"),
                    allDiscsModifierTable);
        }

        private LootTable.Builder getModifierTable(ResourceLocation lootTable) {
            return LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setBonusRolls(ConstantValue.exactly(0.25F))
                            .setRolls(UniformGenerator.between(0.0F, 1.0F))
                            .add(LootTableReference.lootTableReference(lootTable)));
        }

        private LootPool.Builder poolOf(final List<Supplier<Item>> items) {
            final LootPool.Builder lootPool = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F));

            for (final Supplier<Item> item : items) {
                lootPool.add(LootItem.lootTableItem(item.get()).setWeight(1));
            }

            return lootPool;
        }
    }
}
