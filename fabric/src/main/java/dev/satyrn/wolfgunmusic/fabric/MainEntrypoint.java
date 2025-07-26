package dev.satyrn.wolfgunmusic.fabric;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.api.WanderingTradesHelper;
import dev.satyrn.wolfgunmusic.api.LootTableModifierProcessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

public final class MainEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        WolfgunMusicDiscs.preRegistrationSetup();

        WolfgunMusicDiscs.info("Hooking into loot tables");

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootTableModifierProcessor.modifyTables( lootManager, id, tableBuilder);
        }));

        LifecycleEvent.SERVER_STARTED.register(
                server -> TradeOfferHelper.registerWanderingTraderOffers(1, itemListings -> {
                    final List<VillagerTrades.ItemListing> musicDiscTrades = WanderingTradesHelper.getAllMusicDiscTrades();
                    itemListings.addAll(musicDiscTrades);
                }));
    }
}
