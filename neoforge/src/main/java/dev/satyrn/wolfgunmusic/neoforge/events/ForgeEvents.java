package dev.satyrn.wolfgunmusic.neoforge.events;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.world.entity.npc.WandererMusicDiscListing;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

@EventBusSubscriber(modid = WolfgunMusicDiscs.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public final class ForgeEvents {
    @SubscribeEvent
    static void onWandererTrades(WandererTradesEvent event) {
        event.getRareTrades().add(new WandererMusicDiscListing());
    }
}
