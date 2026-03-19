package dev.satyrn.wolfgunmusic.neoforge.events;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;

@EventBusSubscriber(modid = WolfgunMusicDiscs.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ResourcePackEvents {
    private ResourcePackEvents() {}

    @SubscribeEvent
    static void onAddPackFinders(AddPackFindersEvent event) {
        event.addPackFinders(
            ResourceLocation.fromNamespaceAndPath(WolfgunMusicDiscs.MOD_ID, "resourcepacks/stereo_sounds"),
            PackType.CLIENT_RESOURCES,
            Component.translatable("pack.wolfgun_music_discs.stereo_sounds.title"),
            PackSource.BUILT_IN,
            false,
            Pack.Position.TOP
        );
    }
}
