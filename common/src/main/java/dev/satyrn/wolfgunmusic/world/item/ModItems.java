package dev.satyrn.wolfgunmusic.world.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.data.tags.ModItemTags;
import dev.satyrn.wolfgunmusic.sounds.ModSoundEvents;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

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
    static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(WolfgunMusicDiscs.MOD_ID,
            Registry.ITEM_REGISTRY);

    static {
        int output = 0;
        MUSIC_DISC_EVERY_MORNING = registerDisc("music_disc_every_morning", ++output, ModSoundEvents.MUSIC_DISC_EVERY_MORNING, 163);
        MUSIC_DISC_MOON_RAYS = registerDisc("music_disc_moon_rays", ++output, ModSoundEvents.MUSIC_DISC_MOON_RAYS, 189);
        MUSIC_DISC_AFTER_ANOTHER = registerDisc("music_disc_after_another", ++output, ModSoundEvents.MUSIC_DISC_AFTER_ANOTHER, 158);
        MUSIC_DISC_THROUGHOUT = registerDisc("music_disc_throughout", ++output, ModSoundEvents.MUSIC_DISC_THROUGHOUT, 160);
        MUSIC_DISC_BLACK_DAWN = registerDisc("music_disc_black_dawn", ++output, ModSoundEvents.MUSIC_DISC_BLACK_DAWN, 161);
        MUSIC_DISC_PASSING = registerDisc("music_disc_passing", ++output, ModSoundEvents.MUSIC_DISC_PASSING, 138);
        MUSIC_DISC_UNSEEN_LAND = registerDisc("music_disc_unseen_land", ++output, ModSoundEvents.MUSIC_DISC_UNSEEN_LAND, 193);
        MUSIC_DISC_MT_ENNUI = registerDisc("music_disc_mt_ennui", ++output, ModSoundEvents.MUSIC_DISC_MT_ENNUI, 151);
        MUSIC_DISC_PEAKS = registerDisc("music_disc_peaks", ++output, ModSoundEvents.MUSIC_DISC_PEAKS, 174);
        MUSIC_DISC_FAR_AWAY = registerDisc("music_disc_far_away", ++output, ModSoundEvents.MUSIC_DISC_FAR_AWAY, 160);
        MUSIC_DISC_INTO_STARS = registerDisc("music_disc_into_stars", ++output, ModSoundEvents.MUSIC_DISC_INTO_STARS, 137);
        output = 0;
        MUSIC_DISC_NIGHT_I = registerDisc("music_disc_night_i", ++output, ModSoundEvents.MUSIC_DISC_NIGHT_I, 167);
        MUSIC_DISC_TROPIC = registerDisc("music_disc_tropic", ++output, ModSoundEvents.MUSIC_DISC_TROPIC, 169);
        MUSIC_DISC_MOON_BEAMS = registerDisc("music_disc_moon_beams", ++output, ModSoundEvents.MUSIC_DISC_MOON_BEAMS, 213);
        MUSIC_DISC_OF_PLAINS = registerDisc("music_disc_of_plains", ++output, ModSoundEvents.MUSIC_DISC_OF_PLAINS, 264);
        MUSIC_DISC_LIGHTFORM = registerDisc("music_disc_lightform", ++output, ModSoundEvents.MUSIC_DISC_LIGHTFORM, 200);
        MUSIC_DISC_BETWEEN_LAYERS = registerDisc("music_disc_between_layers", ++output, ModSoundEvents.MUSIC_DISC_BETWEEN_LAYERS, 212);
        MUSIC_DISC_NIGHT_II = registerDisc("music_disc_night_ii", ++output, ModSoundEvents.MUSIC_DISC_NIGHT_II, 142);
        MUSIC_DISC_CLIFF_WHERE = registerDisc("music_disc_cliff_where", ++output, ModSoundEvents.MUSIC_DISC_CLIFF_WHERE, 210);
        MUSIC_DISC_DEER = registerDisc("music_disc_deer", ++output, ModSoundEvents.MUSIC_DISC_DEER, 213);
        MUSIC_DISC_PALE_STAR = registerDisc("music_disc_pale_star", ++output, ModSoundEvents.MUSIC_DISC_PALE_STAR, 192);
        MUSIC_DISC_DARK_SOUTHERN_SKY = registerDisc("music_disc_dark_southern_sky", ++output, ModSoundEvents.MUSIC_DISC_DARK_SOUTHERN_SKY, 186);
    }

    private ModItems() {
        NotInitializable.staticClass(ModItemTags.class);
    }

    static RegistrySupplier<Item> registerDisc(String id,
                                               int output,
                                               Supplier<SoundEvent> soundEvent,
                                               int lengthInSeconds) {
        final int outputClamp = output % 15;
        WolfgunMusicDiscs.info("Registering music disc {}:{} (output: {}, length: {}:{})", WolfgunMusicDiscs.MOD_ID,
                id, outputClamp, lengthInSeconds / 60, lengthInSeconds % 60);

        return REGISTRAR.register(id, () -> new RecordItem(outputClamp, soundEvent.get(),
                new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE), lengthInSeconds));
    }

    public static void register() {
        REGISTRAR.register();
    }
}
