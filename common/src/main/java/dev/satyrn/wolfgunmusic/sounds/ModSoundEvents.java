package dev.satyrn.wolfgunmusic.sounds;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public final class ModSoundEvents {
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_AFTER_ANOTHER;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_BETWEEN_LAYERS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_BLACK_DAWN;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_CLIFF_WHERE;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_DARK_SOUTHERN_SKY;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_DEER;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_EVERY_MORNING;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_FAR_AWAY;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_INTO_STARS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_LIGHTFORM;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_MOON_BEAMS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_MOON_RAYS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_MT_ENNUI;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_NIGHT_I;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_NIGHT_II;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_OF_PLAINS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PALE_STAR;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PASSING;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PEAKS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_THROUGHOUT;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_TROPIC;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_UNSEEN_LAND;
    static final DeferredRegister<SoundEvent> REGISTRAR = DeferredRegister.create(WolfgunMusicDiscs.MOD_ID,
            Registry.SOUND_EVENT_REGISTRY);

    static {
        MUSIC_DISC_AFTER_ANOTHER = register("music_disc_after_another");
        MUSIC_DISC_BETWEEN_LAYERS = register("music_disc_between_layers");
        MUSIC_DISC_BLACK_DAWN = register("music_disc_black_dawn");
        MUSIC_DISC_CLIFF_WHERE = register("music_disc_cliff_where");
        MUSIC_DISC_DARK_SOUTHERN_SKY = register("music_disc_dark_southern_sky");
        MUSIC_DISC_DEER = register("music_disc_deer");
        MUSIC_DISC_EVERY_MORNING = register("music_disc_every_morning");
        MUSIC_DISC_FAR_AWAY = register("music_disc_far_away");
        MUSIC_DISC_INTO_STARS = register("music_disc_into_stars");
        MUSIC_DISC_LIGHTFORM = register("music_disc_lightform");
        MUSIC_DISC_MOON_BEAMS = register("music_disc_moon_beams");
        MUSIC_DISC_MOON_RAYS = register("music_disc_moon_rays");
        MUSIC_DISC_MT_ENNUI = register("music_disc_mt_ennui");
        MUSIC_DISC_NIGHT_I = register("music_disc_night_i");
        MUSIC_DISC_NIGHT_II = register("music_disc_night_ii");
        MUSIC_DISC_OF_PLAINS = register("music_disc_of_plains");
        MUSIC_DISC_PALE_STAR = register("music_disc_pale_star");
        MUSIC_DISC_PASSING = register("music_disc_passing");
        MUSIC_DISC_PEAKS = register("music_disc_peaks");
        MUSIC_DISC_THROUGHOUT = register("music_disc_throughout");
        MUSIC_DISC_TROPIC = register("music_disc_tropic");
        MUSIC_DISC_UNSEEN_LAND = register("music_disc_unseen_land");
    }

    private ModSoundEvents() {
        NotInitializable.staticClass(ModSoundEvents.class);
    }

    static RegistrySupplier<SoundEvent> register(String key) {
        WolfgunMusicDiscs.info("Registering sound event {}:{}", WolfgunMusicDiscs.MOD_ID, key);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(WolfgunMusicDiscs.MOD_ID, key);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create key " + WolfgunMusicDiscs.MOD_ID + ":" + key);
        }
        return REGISTRAR.register(key, () -> new SoundEvent(resourceLocation));
    }

    public static void register() {
        REGISTRAR.register();
    }
}
