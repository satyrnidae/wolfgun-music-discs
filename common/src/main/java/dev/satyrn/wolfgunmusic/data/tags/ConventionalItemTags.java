package dev.satyrn.wolfgunmusic.data.tags;

import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;

public class ConventionalItemTags {
    public static final TagKey<Item> MUSIC_DISCS = register("music_discs");

    private ConventionalItemTags() {
        NotInitializable.staticClass(ConventionalItemTags.class);
    }

    public static TagKey<Item> register(String name) {
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild("c", name);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an item tag key for " + name);
        }
        return TagKey.create(Registry.ITEM_REGISTRY, resourceLocation);
    }
}
