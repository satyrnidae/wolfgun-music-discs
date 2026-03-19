package dev.satyrn.wolfgunmusic.world.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ModItems {
    public static final RegistrySupplier<Item> MUSIC_DISC_AFTER_ANOTHER;
    public static final RegistrySupplier<Item> MUSIC_DISC_BETWEEN_LAYERS;
    public static final RegistrySupplier<Item> MUSIC_DISC_BLACK_DAWN;
    public static final RegistrySupplier<Item> MUSIC_DISC_CLIFF_WHERE;
    public static final RegistrySupplier<Item> MUSIC_DISC_DARK_SOUTHERN_SKY;
    public static final RegistrySupplier<Item> MUSIC_DISC_DEER;
    public static final RegistrySupplier<Item> MUSIC_DISC_EVERY_MORNING;
    public static final RegistrySupplier<Item> MUSIC_DISC_FAR_AWAY;
    public static final RegistrySupplier<Item> MUSIC_DISC_INTO_STARS;
    public static final RegistrySupplier<Item> MUSIC_DISC_LIGHTFORM;
    public static final RegistrySupplier<Item> MUSIC_DISC_MOON_BEAMS;
    public static final RegistrySupplier<Item> MUSIC_DISC_MOON_RAYS;
    public static final RegistrySupplier<Item> MUSIC_DISC_MT_ENNUI;
    public static final RegistrySupplier<Item> MUSIC_DISC_NIGHT_I;
    public static final RegistrySupplier<Item> MUSIC_DISC_NIGHT_II;
    public static final RegistrySupplier<Item> MUSIC_DISC_OF_PLAINS;
    public static final RegistrySupplier<Item> MUSIC_DISC_PALE_STAR;
    public static final RegistrySupplier<Item> MUSIC_DISC_PASSING;
    public static final RegistrySupplier<Item> MUSIC_DISC_PEAKS;
    public static final RegistrySupplier<Item> MUSIC_DISC_THROUGHOUT;
    public static final RegistrySupplier<Item> MUSIC_DISC_TROPIC;
    public static final RegistrySupplier<Item> MUSIC_DISC_UNSEEN_LAND;

    public static final List<RegistrySupplier<Item>> ALL_DISCS;

    static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(WolfgunMusicDiscs.MOD_ID, Registries.ITEM);

    static {
        Map<String, RegistrySupplier<Item>> byId = new LinkedHashMap<>();
        for (ResourceKey<JukeboxSong> song : ModJukeboxSongs.ALL_SONGS) {
            byId.put(song.location().getPath(), registerDisc(song.location().getPath(), song));
        }

        MUSIC_DISC_AFTER_ANOTHER     = byId.get("music_disc_after_another");
        MUSIC_DISC_BETWEEN_LAYERS    = byId.get("music_disc_between_layers");
        MUSIC_DISC_BLACK_DAWN        = byId.get("music_disc_black_dawn");
        MUSIC_DISC_CLIFF_WHERE       = byId.get("music_disc_cliff_where");
        MUSIC_DISC_DARK_SOUTHERN_SKY = byId.get("music_disc_dark_southern_sky");
        MUSIC_DISC_DEER              = byId.get("music_disc_deer");
        MUSIC_DISC_EVERY_MORNING     = byId.get("music_disc_every_morning");
        MUSIC_DISC_FAR_AWAY          = byId.get("music_disc_far_away");
        MUSIC_DISC_INTO_STARS        = byId.get("music_disc_into_stars");
        MUSIC_DISC_LIGHTFORM         = byId.get("music_disc_lightform");
        MUSIC_DISC_MOON_BEAMS        = byId.get("music_disc_moon_beams");
        MUSIC_DISC_MOON_RAYS         = byId.get("music_disc_moon_rays");
        MUSIC_DISC_MT_ENNUI          = byId.get("music_disc_mt_ennui");
        MUSIC_DISC_NIGHT_I           = byId.get("music_disc_night_i");
        MUSIC_DISC_NIGHT_II          = byId.get("music_disc_night_ii");
        MUSIC_DISC_OF_PLAINS         = byId.get("music_disc_of_plains");
        MUSIC_DISC_PALE_STAR         = byId.get("music_disc_pale_star");
        MUSIC_DISC_PASSING           = byId.get("music_disc_passing");
        MUSIC_DISC_PEAKS             = byId.get("music_disc_peaks");
        MUSIC_DISC_THROUGHOUT        = byId.get("music_disc_throughout");
        MUSIC_DISC_TROPIC            = byId.get("music_disc_tropic");
        MUSIC_DISC_UNSEEN_LAND       = byId.get("music_disc_unseen_land");
        ALL_DISCS                    = List.copyOf(byId.values());
    }

    private ModItems() {
        NotInitializable.staticClass(ModItems.class);
    }

    static RegistrySupplier<Item> registerDisc(String id, ResourceKey<JukeboxSong> songKey) {
        WolfgunMusicDiscs.info("Registering music disc {}:{}", WolfgunMusicDiscs.MOD_ID, id);
        return REGISTRAR.register(id, () -> new Item(
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(songKey)));
    }

    public static void register() {
        REGISTRAR.register();
    }
}
