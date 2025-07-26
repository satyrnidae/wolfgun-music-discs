package dev.satyrn.wolfgunmusic.forge.data.provider.client;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.sounds.ModSoundEvents;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import javax.annotation.Nullable;
import java.util.function.Supplier;


public final class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param generator The data generator instance provided by the event you are initializing this provider in.
     * @param modId     The mod ID of the current mod.
     * @param helper    The existing file helper provided by the event you are initializing this provider in.
     */
    public ModSoundDefinitionsProvider(DataGenerator generator, String modId, ExistingFileHelper helper) {
        super(generator, modId, helper);
    }

    @Override
    public void registerSounds() {
        this.addRecord(ModSoundEvents.MUSIC_DISC_AFTER_ANOTHER);
        this.addRecord(ModSoundEvents.MUSIC_DISC_BETWEEN_LAYERS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_BLACK_DAWN);
        this.addRecord(ModSoundEvents.MUSIC_DISC_CLIFF_WHERE);
        this.addRecord(ModSoundEvents.MUSIC_DISC_DARK_SOUTHERN_SKY);
        this.addRecord(ModSoundEvents.MUSIC_DISC_DEER);
        this.addRecord(ModSoundEvents.MUSIC_DISC_EVERY_MORNING);
        this.addRecord(ModSoundEvents.MUSIC_DISC_FAR_AWAY);
        this.addRecord(ModSoundEvents.MUSIC_DISC_INTO_STARS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_LIGHTFORM);
        this.addRecord(ModSoundEvents.MUSIC_DISC_MOON_BEAMS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_MOON_RAYS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_MT_ENNUI);
        this.addRecord(ModSoundEvents.MUSIC_DISC_NIGHT_I);
        this.addRecord(ModSoundEvents.MUSIC_DISC_NIGHT_II);
        this.addRecord(ModSoundEvents.MUSIC_DISC_OF_PLAINS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_PALE_STAR);
        this.addRecord(ModSoundEvents.MUSIC_DISC_PASSING);
        this.addRecord(ModSoundEvents.MUSIC_DISC_PEAKS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_THROUGHOUT);
        this.addRecord(ModSoundEvents.MUSIC_DISC_TROPIC);
        this.addRecord(ModSoundEvents.MUSIC_DISC_UNSEEN_LAND);
    }

    private void addRecord(Supplier<SoundEvent> soundEvent) {
        final String name = soundEvent.get().getLocation().getPath();
        WolfgunMusicDiscs.info("Adding music disc sound event for sound file {}:records/{}", WolfgunMusicDiscs.MOD_ID, name);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(WolfgunMusicDiscs.MOD_ID, "records/" + name);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an id for " + WolfgunMusicDiscs.MOD_ID + ":records/" + name);
        }
        this.add(soundEvent.get(), SoundDefinition.definition().with(SoundDefinition.Sound.sound(resourceLocation, SoundDefinition.SoundType.SOUND).stream()));
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Sound Provider";
    }
}
