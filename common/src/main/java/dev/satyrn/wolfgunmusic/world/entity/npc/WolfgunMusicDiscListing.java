package dev.satyrn.wolfgunmusic.world.entity.npc;

import com.google.common.collect.ImmutableList;
import dev.satyrn.wolfgunmusic.data.tags.ModItemTags;
import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

public class WolfgunMusicDiscListing implements VillagerTrades.ItemListing {
    @Override
    public @Nullable MerchantOffer getOffer(Entity trader, RandomSource random) {
        final var moddedDiscs = ImmutableList.copyOf(Registry.ITEM.getTagOrEmpty(ModItemTags.WOLFGUN_MUSIC_DISCS));
        final var tradeDisc = ImmutableList.of(Items.MUSIC_DISC_11, Items.MUSIC_DISC_13, Items.MUSIC_DISC_CAT,
                Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CHIRP, Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL,
                Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD, Items.MUSIC_DISC_WAIT,
                Items.MUSIC_DISC_WARD);

        return new MerchantOffer(new ItemStack(Items.EMERALD, random.nextInt(1, 8)),
                new ItemStack(tradeDisc.get(random.nextInt(tradeDisc.size()))),
                new ItemStack(moddedDiscs.get(random.nextInt(moddedDiscs.size()))), 1, 0, 0.05F);
    }
}
