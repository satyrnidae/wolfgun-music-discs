package dev.satyrn.wolfgunmusic;

import dev.satyrn.wolfgunmusic.sounds.ModSoundEvents;
import dev.satyrn.wolfgunmusic.world.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class WolfgunMusicDiscs {
    public static final String MOD_ID = "wolfgun_music_discs";
    private static final Logger LOGGER = LogManager.getLogger();

    private WolfgunMusicDiscs() {
        throw new AssertionError("Class should not be initialized.");
    }

    public static void preRegistrationSetup() {
        info("Running pre-registry setup for {}", MOD_ID);
        // Write common init code here.
        ModSoundEvents.register();
        ModItems.register();

        info("Pre-registry setup for {} completed successfully.", MOD_ID);
    }

    public static void info(String message, Object... params) {
        LOGGER.info(message, params);
    }
}
