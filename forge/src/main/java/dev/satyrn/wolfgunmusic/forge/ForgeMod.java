package dev.satyrn.wolfgunmusic.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.satyrn.wolfgunmusic.forge.loot.ModLootModifiers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;

@Mod(WolfgunMusicDiscs.MOD_ID)
public final class ForgeMod {
    public ForgeMod(final FMLJavaModLoadingContext context) {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(WolfgunMusicDiscs.MOD_ID, context.getModEventBus());

        // Run our common setup.
        WolfgunMusicDiscs.preRegistrationSetup();

        // Register Forge specific APIs
        ModLootModifiers.register(context.getModEventBus());
    }
}
