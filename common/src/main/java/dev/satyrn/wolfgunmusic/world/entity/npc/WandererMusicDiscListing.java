package dev.satyrn.wolfgunmusic.world.entity.npc;

import com.google.common.collect.ImmutableList;
import dev.satyrn.wolfgunmusic.data.tags.ModItemTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WandererMusicDiscListing implements VillagerTrades.ItemListing {
    @Override
    public @Nullable MerchantOffer getOffer(Entity trader, RandomSource random) {
        final var moddedDiscs = ImmutableList.copyOf(BuiltInRegistries.ITEM.getTagOrEmpty(ModItemTags.WOLFGUN_MUSIC_DISCS));
        final var tradeDisc = ImmutableList.copyOf(BuiltInRegistries.ITEM.getTagOrEmpty(ModItemTags.TRADE_ITEM_DISCS));

        return new MerchantOffer(
                new ItemCost(Items.EMERALD, random.nextInt(1, 8)),
                Optional.of(new ItemCost(tradeDisc.get(random.nextInt(tradeDisc.size())).value())),
                new ItemStack(moddedDiscs.get(random.nextInt(moddedDiscs.size())).value()),
                1, 1, 0.05F);
    }
}
