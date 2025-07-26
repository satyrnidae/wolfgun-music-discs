package dev.satyrn.wolfgunmusic.forge.events;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.world.entity.npc.WandererMusicDiscListing;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WolfgunMusicDiscs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEvents {
    @SubscribeEvent
    static void onWandererTrades(WandererTradesEvent event) {
        event.getRareTrades().add(new WandererMusicDiscListing());
    }
}
