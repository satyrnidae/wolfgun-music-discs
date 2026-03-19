package dev.satyrn.wolfgunmusic.neoforge.data.events;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.client.ModItemModelProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.client.ModSoundDefinitionsProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.client.ModUSEnglishLanguageProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.server.ModBlockTagsProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.server.ModGlobalLootModifierProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.server.ModItemTagsProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.server.ModJukeboxSongProvider;
import dev.satyrn.wolfgunmusic.neoforge.data.provider.server.ModLootTableProvider;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = WolfgunMusicDiscs.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class DataEvents {
    private DataEvents() {
        NotInitializable.staticClass(DataEvents.class);
    }

    @SubscribeEvent
    static void onGatherData(final GatherDataEvent event) {
        final String modId = event.getModContainer().getModId();
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModSoundDefinitionsProvider(event.getGenerator().getPackOutput(), modId,
                                event.getExistingFileHelper()));
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModItemModelProvider(event.getGenerator().getPackOutput(), modId,
                                event.getExistingFileHelper()));
        event.getGenerator()
                .addProvider(event.includeClient(),
                        new ModUSEnglishLanguageProvider(event.getGenerator().getPackOutput(), modId));

        if (event.includeServer()) {
            var blockTagsProvider = new ModBlockTagsProvider(event.getGenerator().getPackOutput(),
                    event.getLookupProvider(), modId, event.getExistingFileHelper());
            event.getGenerator().addProvider(true, blockTagsProvider);
            event.getGenerator()
                    .addProvider(true, new ModItemTagsProvider(event.getGenerator().getPackOutput(),
                            event.getLookupProvider(), blockTagsProvider.contentsGetter(),
                            modId, event.getExistingFileHelper()));
            event.getGenerator()
                    .addProvider(true,
                            new ModGlobalLootModifierProvider(event.getGenerator().getPackOutput(),
                                    event.getLookupProvider()));
            event.getGenerator()
                    .addProvider(true,
                            new ModLootTableProvider(event.getGenerator().getPackOutput(),
                                    event.getLookupProvider()));
            event.getGenerator().addProvider(true,
                            new ModJukeboxSongProvider(event.getGenerator().getPackOutput(),
                                    event.getLookupProvider()));
        }
    }
}
