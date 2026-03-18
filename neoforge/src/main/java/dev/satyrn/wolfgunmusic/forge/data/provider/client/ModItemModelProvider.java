package dev.satyrn.wolfgunmusic.forge.data.provider.client;

import dev.satyrn.wolfgunmusic.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public final class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ModItems.MUSIC_DISC_AFTER_ANOTHER.get());
        this.basicItem(ModItems.MUSIC_DISC_BETWEEN_LAYERS.get());
        this.basicItem(ModItems.MUSIC_DISC_BLACK_DAWN.get());
        this.basicItem(ModItems.MUSIC_DISC_CLIFF_WHERE.get());
        this.basicItem(ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY.get());
        this.basicItem(ModItems.MUSIC_DISC_DEER.get());
        this.basicItem(ModItems.MUSIC_DISC_EVERY_MORNING.get());
        this.basicItem(ModItems.MUSIC_DISC_FAR_AWAY.get());
        this.basicItem(ModItems.MUSIC_DISC_INTO_STARS.get());
        this.basicItem(ModItems.MUSIC_DISC_LIGHTFORM.get());
        this.basicItem(ModItems.MUSIC_DISC_MOON_BEAMS.get());
        this.basicItem(ModItems.MUSIC_DISC_MOON_RAYS.get());
        this.basicItem(ModItems.MUSIC_DISC_MT_ENNUI.get());
        this.basicItem(ModItems.MUSIC_DISC_NIGHT_I.get());
        this.basicItem(ModItems.MUSIC_DISC_NIGHT_II.get());
        this.basicItem(ModItems.MUSIC_DISC_OF_PLAINS.get());
        this.basicItem(ModItems.MUSIC_DISC_PALE_STAR.get());
        this.basicItem(ModItems.MUSIC_DISC_PASSING.get());
        this.basicItem(ModItems.MUSIC_DISC_PEAKS.get());
        this.basicItem(ModItems.MUSIC_DISC_THROUGHOUT.get());
        this.basicItem(ModItems.MUSIC_DISC_TROPIC.get());
        this.basicItem(ModItems.MUSIC_DISC_UNSEEN_LAND.get());
    }

    @Override
    public @NotNull String getName() {
        return "Wolfgun Music Discs Item Model Provider";
    }
}
