package dev.satyrn.wolfgunmusic.world.item;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.JukeboxSong;

import java.util.List;

public final class ModJukeboxSongs {
    // RUNNING
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_EVERY_MORNING     = createKey("music_disc_every_morning");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_MOON_RAYS         = createKey("music_disc_moon_rays");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_AFTER_ANOTHER     = createKey("music_disc_after_another");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_THROUGHOUT        = createKey("music_disc_throughout");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_BLACK_DAWN        = createKey("music_disc_black_dawn");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_PASSING           = createKey("music_disc_passing");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_UNSEEN_LAND       = createKey("music_disc_unseen_land");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_MT_ENNUI          = createKey("music_disc_mt_ennui");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_PEAKS             = createKey("music_disc_peaks");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_FAR_AWAY          = createKey("music_disc_far_away");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_INTO_STARS        = createKey("music_disc_into_stars");
    // RUNNING II
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_NIGHT_I           = createKey("music_disc_night_i");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_TROPIC            = createKey("music_disc_tropic");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_MOON_BEAMS        = createKey("music_disc_moon_beams");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_OF_PLAINS         = createKey("music_disc_of_plains");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_LIGHTFORM         = createKey("music_disc_lightform");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_BETWEEN_LAYERS    = createKey("music_disc_between_layers");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_NIGHT_II          = createKey("music_disc_night_ii");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_CLIFF_WHERE       = createKey("music_disc_cliff_where");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_DEER              = createKey("music_disc_deer");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_PALE_STAR         = createKey("music_disc_pale_star");
    public static final ResourceKey<JukeboxSong> MUSIC_DISC_DARK_SOUTHERN_SKY = createKey("music_disc_dark_southern_sky");

    public static final List<ResourceKey<JukeboxSong>> ALL_SONGS = List.of(
            MUSIC_DISC_EVERY_MORNING, MUSIC_DISC_MOON_RAYS, MUSIC_DISC_AFTER_ANOTHER, MUSIC_DISC_THROUGHOUT,
            MUSIC_DISC_BLACK_DAWN, MUSIC_DISC_PASSING, MUSIC_DISC_UNSEEN_LAND, MUSIC_DISC_MT_ENNUI,
            MUSIC_DISC_PEAKS, MUSIC_DISC_FAR_AWAY, MUSIC_DISC_INTO_STARS, MUSIC_DISC_NIGHT_I, MUSIC_DISC_TROPIC,
            MUSIC_DISC_MOON_BEAMS, MUSIC_DISC_OF_PLAINS, MUSIC_DISC_LIGHTFORM, MUSIC_DISC_BETWEEN_LAYERS,
            MUSIC_DISC_NIGHT_II, MUSIC_DISC_CLIFF_WHERE, MUSIC_DISC_DEER, MUSIC_DISC_PALE_STAR,
            MUSIC_DISC_DARK_SOUTHERN_SKY);

    private ModJukeboxSongs() {
        NotInitializable.staticClass(ModJukeboxSongs.class);
    }

    private static ResourceKey<JukeboxSong> createKey(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG,
                ResourceLocation.fromNamespaceAndPath(WolfgunMusicDiscs.MOD_ID, id));
    }
}
