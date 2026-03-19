package dev.satyrn.wolfgunmusic.neoforge;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.neoforge.loot.ModLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(WolfgunMusicDiscs.MOD_ID)
public final class NeoForgeMod {
    public NeoForgeMod(final IEventBus modEventBus) {
        // Run our common setup.
        WolfgunMusicDiscs.preRegistrationSetup();

        // Register NeoForge specific APIs
        ModLootModifiers.register(modEventBus);
    }
}
