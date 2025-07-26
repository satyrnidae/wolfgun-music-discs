package dev.satyrn.wolfgunmusic.data.tags;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;

public final class ModItemTags {
    public static final TagKey<Item> WOLFGUN_MUSIC_DISCS;
    public static final TagKey<Item> RUNNING_MUSIC_DISCS;
    public static final TagKey<Item> RUNNING_II_MUSIC_DISCS;

    static {
        WOLFGUN_MUSIC_DISCS = register("wolfgun_music_discs");
        RUNNING_MUSIC_DISCS = register("running_music_discs");
        RUNNING_II_MUSIC_DISCS = register("running_ii_music_discs");
    }

    private ModItemTags() {
        throw new AssertionError("Class should not be initialized.");
    }

    public static TagKey<Item> register(String name) {
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(WolfgunMusicDiscs.MOD_ID, name);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an item tag key for " + name);
        }
        return TagKey.create(Registry.ITEM_REGISTRY, resourceLocation);
    }
}
