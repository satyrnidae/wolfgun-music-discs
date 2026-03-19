package dev.satyrn.wolfgunmusic.neoforge.loot;

import com.mojang.serialization.MapCodec;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.util.NotInitializable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModLootModifiers {
    private ModLootModifiers() {
        NotInitializable.staticClass(ModLootModifiers.class);
    }

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<OverlayLootTableModifier>> DISC_DUNGEON_LOOT_MODIFIER;
    static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> REGISTRAR = DeferredRegister.create(
            NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, WolfgunMusicDiscs.MOD_ID);

    static {
        DISC_DUNGEON_LOOT_MODIFIER = REGISTRAR.register("overlay_loot_table", () -> OverlayLootTableModifier.CODEC);
    }

    public static void register(IEventBus eventBus) {
        REGISTRAR.register(eventBus);
    }
}
