package dev.satyrn.wolfgunmusic.forge.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class OverlayLootTableModifier extends LootModifier {
    public static final Supplier<Codec<OverlayLootTableModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                            FloatProvider.CODEC.optionalFieldOf("rolls", UniformFloat.of(0.0F, 1.0F)).forGetter(o -> o.rolls))
                    .and(ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("bonusRolls", 0.25F).forGetter(o -> o.bonusRolls))
                    .and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter(o -> o.lootTable))
                    .apply(inst, OverlayLootTableModifier::new)));

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
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext ctx) {
        LootTable dungeonChestOverlay = ctx.getLootTable(this.lootTable);

        int rolls = Math.round(this.rolls.sample(ctx.getRandom())) + Mth.floor(bonusRolls * ctx.getLuck());

        for (int i = 0; i < rolls; i++) {
            generatedLoot.addAll(dungeonChestOverlay.getRandomItems(ctx));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
