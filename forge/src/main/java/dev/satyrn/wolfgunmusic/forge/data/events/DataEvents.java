package dev.satyrn.wolfgunmusic.forge.data.events;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.forge.data.provider.client.ModItemModelProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.client.ModUSEnglishLanguageProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.client.ModSoundDefinitionsProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.server.ModBlockTagsProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.server.ModItemTagsProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.server.ModGlobalLootModifierProvider;
import dev.satyrn.wolfgunmusic.forge.data.provider.server.ModLootTableProvider;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = WolfgunMusicDiscs.MOD_ID, bus = Bus.MOD)
public final class DataEvents {
    private DataEvents() {
        NotInitializable.staticClass(DataEvents.class);
    }

    @SubscribeEvent
    static void onGatherData(final GatherDataEvent event) {
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModSoundDefinitionsProvider(event.getGenerator(), event.getModContainer().getModId(),
                                event.getExistingFileHelper()));
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModItemModelProvider(event.getGenerator(), event.getModContainer().getModId(),
                                event.getExistingFileHelper()));
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModUSEnglishLanguageProvider(event.getGenerator(), event.getModContainer().getModId()));

        if (event.includeServer()) {
            var blockTagsProvider = new ModBlockTagsProvider(event.getGenerator(), event.getModContainer().getModId(),
                    event.getExistingFileHelper());
            event.getGenerator().addProvider(true, blockTagsProvider);
            event.getGenerator()
                    .addProvider(true, new ModItemTagsProvider(event.getGenerator(), blockTagsProvider,
                            event.getModContainer().getModId(), event.getExistingFileHelper()));
            // Forge loot stuff
            event.getGenerator()
                    .addProvider(true,
                            new ModGlobalLootModifierProvider(event.getGenerator(), event.getModContainer().getModId()));
            event.getGenerator()
                    .addProvider(true,
                            new ModLootTableProvider(event.getGenerator()));
        }
    }
}
