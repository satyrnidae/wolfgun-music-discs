package dev.satyrn.wolfgunmusic.neoforge.data.provider.server;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.world.item.ModJukeboxSongs;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class ModJukeboxSongProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.JUKEBOX_SONG, ModJukeboxSongProvider::bootstrap);

    public ModJukeboxSongProvider(PackOutput output, CompletableFuture<net.minecraft.core.HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BUILDER, Set.of(WolfgunMusicDiscs.MOD_ID));
    }

    private static void bootstrap(BootstrapContext<JukeboxSong> ctx) {
        HolderGetter<SoundEvent> sounds = ctx.lookup(Registries.SOUND_EVENT);
        // RUNNING
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_EVERY_MORNING,      1, 163.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_MOON_RAYS,          2, 189.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_AFTER_ANOTHER,      3, 158.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_THROUGHOUT,         4, 160.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_BLACK_DAWN,         5, 161.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_PASSING,            6, 138.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_UNSEEN_LAND,        7, 193.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_MT_ENNUI,           8, 151.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_PEAKS,              9, 174.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_FAR_AWAY,          10, 160.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_INTO_STARS,        11, 137.0f);
        // RUNNING II
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_NIGHT_I,            1, 167.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_TROPIC,             2, 169.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_MOON_BEAMS,         3, 213.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_OF_PLAINS,          4, 264.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_LIGHTFORM,          5, 200.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_BETWEEN_LAYERS,     6, 212.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_NIGHT_II,           7, 142.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_CLIFF_WHERE,        8, 210.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_DEER,               9, 213.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_PALE_STAR,         10, 192.0f);
        register(ctx, sounds, ModJukeboxSongs.MUSIC_DISC_DARK_SOUTHERN_SKY, 11, 186.0f);
    }

    private static void register(BootstrapContext<JukeboxSong> ctx, HolderGetter<SoundEvent> sounds,
                                 ResourceKey<JukeboxSong> key, int comparatorOutput, float lengthInSeconds) {
        String id = key.location().getPath();
        ResourceKey<SoundEvent> seKey = ResourceKey.create(Registries.SOUND_EVENT, key.location());
        ctx.register(key, new JukeboxSong(
                sounds.getOrThrow(seKey),
                Component.translatable("item." + WolfgunMusicDiscs.MOD_ID + "." + id + ".desc"),
                lengthInSeconds, comparatorOutput));
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Jukebox Song Provider";
    }
}
