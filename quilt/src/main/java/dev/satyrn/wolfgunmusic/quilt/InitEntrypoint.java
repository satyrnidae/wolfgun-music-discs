package dev.satyrn.wolfgunmusic.quilt;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.api.LootTableModifierProcessor;
import dev.satyrn.wolfgunmusic.world.entity.npc.WandererMusicDiscListing;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.villager.api.TradeOfferHelper;

public final class InitEntrypoint implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        // Run our common setup.
        WolfgunMusicDiscs.preRegistrationSetup();

        WolfgunMusicDiscs.info("Hooking into loot tables");

        LootTableEvents.MODIFY.register(
                (resourceManager, lootManager, id, tableBuilder, source) -> LootTableModifierProcessor.modifyTables(
                        lootManager, id, tableBuilder));

        TradeOfferHelper.registerWanderingTraderOffers(1,
                itemListings -> itemListings.add(new WandererMusicDiscListing()));
    }
}
