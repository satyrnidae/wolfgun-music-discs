package dev.satyrn.wolfgunmusic.neoforge.data.provider.server;

import dev.satyrn.wolfgunmusic.data.tags.ConventionalItemTags;
import dev.satyrn.wolfgunmusic.data.tags.ModItemTags;
import dev.satyrn.wolfgunmusic.world.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagsProvider.TagLookup<Block>> blockTags,
                               String modId,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Mod tags
        this.tag(ModItemTags.RUNNING_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_EVERY_MORNING.get(), ModItems.MUSIC_DISC_MOON_RAYS.get(),
                        ModItems.MUSIC_DISC_AFTER_ANOTHER.get(), ModItems.MUSIC_DISC_THROUGHOUT.get(),
                        ModItems.MUSIC_DISC_BLACK_DAWN.get(), ModItems.MUSIC_DISC_PASSING.get(),
                        ModItems.MUSIC_DISC_UNSEEN_LAND.get(), ModItems.MUSIC_DISC_MT_ENNUI.get(),
                        ModItems.MUSIC_DISC_PEAKS.get(), ModItems.MUSIC_DISC_FAR_AWAY.get(),
                        ModItems.MUSIC_DISC_INTO_STARS.get());
        this.tag(ModItemTags.RUNNING_II_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_NIGHT_I.get(), ModItems.MUSIC_DISC_TROPIC.get(),
                        ModItems.MUSIC_DISC_MOON_BEAMS.get(), ModItems.MUSIC_DISC_OF_PLAINS.get(),
                        ModItems.MUSIC_DISC_LIGHTFORM.get(), ModItems.MUSIC_DISC_BETWEEN_LAYERS.get(),
                        ModItems.MUSIC_DISC_NIGHT_II.get(), ModItems.MUSIC_DISC_CLIFF_WHERE.get(),
                        ModItems.MUSIC_DISC_DEER.get(), ModItems.MUSIC_DISC_PALE_STAR.get(),
                        ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY.get());
        this.tag(ModItemTags.WOLFGUN_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_EVERY_MORNING.get(), ModItems.MUSIC_DISC_MOON_RAYS.get(),
                        ModItems.MUSIC_DISC_AFTER_ANOTHER.get(), ModItems.MUSIC_DISC_THROUGHOUT.get(),
                        ModItems.MUSIC_DISC_BLACK_DAWN.get(), ModItems.MUSIC_DISC_PASSING.get(),
                        ModItems.MUSIC_DISC_UNSEEN_LAND.get(), ModItems.MUSIC_DISC_MT_ENNUI.get(),
                        ModItems.MUSIC_DISC_PEAKS.get(), ModItems.MUSIC_DISC_FAR_AWAY.get(),
                        ModItems.MUSIC_DISC_INTO_STARS.get(), ModItems.MUSIC_DISC_NIGHT_I.get(),
                        ModItems.MUSIC_DISC_TROPIC.get(), ModItems.MUSIC_DISC_MOON_BEAMS.get(),
                        ModItems.MUSIC_DISC_OF_PLAINS.get(), ModItems.MUSIC_DISC_LIGHTFORM.get(),
                        ModItems.MUSIC_DISC_BETWEEN_LAYERS.get(), ModItems.MUSIC_DISC_NIGHT_II.get(),
                        ModItems.MUSIC_DISC_CLIFF_WHERE.get(), ModItems.MUSIC_DISC_DEER.get(),
                        ModItems.MUSIC_DISC_PALE_STAR.get(), ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY.get());
        this.tag(ModItemTags.TRADE_ITEM_DISCS)
                .add(Items.MUSIC_DISC_11, Items.MUSIC_DISC_13, Items.MUSIC_DISC_CAT,
                        Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CHIRP, Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL,
                        Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD, Items.MUSIC_DISC_WAIT,
                        Items.MUSIC_DISC_WARD);
        // Minecraft
        TagKey<Item> musicDiscsTag = TagKey.create(Registries.ITEM, ResourceLocation.withDefaultNamespace("music_discs"));
        this.tag(musicDiscsTag)
                .add(ModItems.MUSIC_DISC_EVERY_MORNING.get(), ModItems.MUSIC_DISC_MOON_RAYS.get(),
                        ModItems.MUSIC_DISC_AFTER_ANOTHER.get(), ModItems.MUSIC_DISC_THROUGHOUT.get(),
                        ModItems.MUSIC_DISC_BLACK_DAWN.get(), ModItems.MUSIC_DISC_PASSING.get(),
                        ModItems.MUSIC_DISC_UNSEEN_LAND.get(), ModItems.MUSIC_DISC_MT_ENNUI.get(),
                        ModItems.MUSIC_DISC_PEAKS.get(), ModItems.MUSIC_DISC_FAR_AWAY.get(),
                        ModItems.MUSIC_DISC_INTO_STARS.get(), ModItems.MUSIC_DISC_NIGHT_I.get(),
                        ModItems.MUSIC_DISC_TROPIC.get(), ModItems.MUSIC_DISC_MOON_BEAMS.get(),
                        ModItems.MUSIC_DISC_OF_PLAINS.get(), ModItems.MUSIC_DISC_LIGHTFORM.get(),
                        ModItems.MUSIC_DISC_BETWEEN_LAYERS.get(), ModItems.MUSIC_DISC_NIGHT_II.get(),
                        ModItems.MUSIC_DISC_CLIFF_WHERE.get(), ModItems.MUSIC_DISC_DEER.get(),
                        ModItems.MUSIC_DISC_PALE_STAR.get(), ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY.get());
        // Fabric conventional tags v2
        this.tag(ConventionalItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_EVERY_MORNING.get(), ModItems.MUSIC_DISC_MOON_RAYS.get(),
                        ModItems.MUSIC_DISC_AFTER_ANOTHER.get(), ModItems.MUSIC_DISC_THROUGHOUT.get(),
                        ModItems.MUSIC_DISC_BLACK_DAWN.get(), ModItems.MUSIC_DISC_PASSING.get(),
                        ModItems.MUSIC_DISC_UNSEEN_LAND.get(), ModItems.MUSIC_DISC_MT_ENNUI.get(),
                        ModItems.MUSIC_DISC_PEAKS.get(), ModItems.MUSIC_DISC_FAR_AWAY.get(),
                        ModItems.MUSIC_DISC_INTO_STARS.get(), ModItems.MUSIC_DISC_NIGHT_I.get(),
                        ModItems.MUSIC_DISC_TROPIC.get(), ModItems.MUSIC_DISC_MOON_BEAMS.get(),
                        ModItems.MUSIC_DISC_OF_PLAINS.get(), ModItems.MUSIC_DISC_LIGHTFORM.get(),
                        ModItems.MUSIC_DISC_BETWEEN_LAYERS.get(), ModItems.MUSIC_DISC_NIGHT_II.get(),
                        ModItems.MUSIC_DISC_CLIFF_WHERE.get(), ModItems.MUSIC_DISC_DEER.get(),
                        ModItems.MUSIC_DISC_PALE_STAR.get(), ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY.get());
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Item Tag Provider";
    }
}
