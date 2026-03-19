package dev.satyrn.wolfgunmusic.quilt;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.api.LootTableModifierProcessor;
import dev.satyrn.wolfgunmusic.world.entity.npc.WandererMusicDiscListing;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public final class InitEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        // Run our common setup.
        WolfgunMusicDiscs.preRegistrationSetup();

        WolfgunMusicDiscs.info("Hooking into loot tables");

        LootTableEvents.MODIFY.register(
                (id, tableBuilder, source, registries) -> LootTableModifierProcessor.modifyTables(id, tableBuilder));

        TradeOfferHelper.registerWanderingTraderOffers(1,
                itemListings -> itemListings.add(new WandererMusicDiscListing()));

        FabricLoader.getInstance().getModContainer(WolfgunMusicDiscs.MOD_ID).ifPresent(container ->
            ResourceManagerHelper.registerBuiltinResourcePack(
                ResourceLocation.fromNamespaceAndPath(WolfgunMusicDiscs.MOD_ID, "stereo_sounds"),
                container,
                ResourcePackActivationType.NORMAL
            )
        );
    }
}
