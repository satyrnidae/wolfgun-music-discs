package dev.satyrn.wolfgunmusic.neoforge.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class OverlayLootTableModifier extends LootModifier {
    public static final MapCodec<OverlayLootTableModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
            .and(FloatProvider.CODEC.optionalFieldOf("rolls", UniformFloat.of(0.0F, 1.0F)).forGetter(o -> o.rolls))
            .and(ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("bonusRolls", 0.25F).forGetter(o -> o.bonusRolls))
            .and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter(o -> o.lootTable))
            .apply(inst, OverlayLootTableModifier::new));

    private final FloatProvider rolls;
    private final float bonusRolls;
    private final ResourceLocation lootTable;

    public OverlayLootTableModifier(final LootItemCondition[] conditionsIn, FloatProvider rolls, float bonusRolls, ResourceLocation lootTable) {
        super(conditionsIn);
        this.rolls = rolls;
        this.bonusRolls = bonusRolls;
        this.lootTable = lootTable;
    }

    @Override
    protected @Nonnull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext ctx) {
        ResourceKey<LootTable> tableKey = ResourceKey.create(Registries.LOOT_TABLE, this.lootTable);
        LootTable dungeonChestOverlay = ctx.getResolver()
                .lookup(Registries.LOOT_TABLE)
                .flatMap(getter -> getter.get(tableKey))
                .map(Holder::value)
                .orElse(LootTable.EMPTY);

        int rolls = Math.round(this.rolls.sample(ctx.getRandom())) + Mth.floor(bonusRolls * ctx.getLuck());


        for (int i = 0; i < rolls; i++) {
            dungeonChestOverlay.getRandomItems(ctx, generatedLoot::add);
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
