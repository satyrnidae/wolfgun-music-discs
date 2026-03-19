package dev.satyrn.wolfgunmusic;

import dev.architectury.registry.CreativeTabRegistry;
import dev.satyrn.wolfgunmusic.sounds.ModSoundEvents;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import dev.satyrn.wolfgunmusic.world.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class WolfgunMusicDiscs {
    public static final String MOD_ID = "wolfgun_music_discs";
    private static final Logger LOGGER = LogManager.getLogger();

    private WolfgunMusicDiscs() {
        NotInitializable.staticClass(WolfgunMusicDiscs.class);
    }

    public static void preRegistrationSetup() {
        info("Running pre-registry setup for {}", MOD_ID);
        // Write common init code here.
        ModSoundEvents.register();
        ModItems.register();

        CreativeTabRegistry.appendStack(CreativeModeTabs.TOOLS_AND_UTILITIES,
                ModItems.ALL_DISCS.stream().map(item -> () -> new ItemStack(item.get())));

        info("Pre-registry setup for {} completed successfully.", MOD_ID);
    }

    public static void info(String message, Object... params) {
        LOGGER.info(message, params);
    }
}
