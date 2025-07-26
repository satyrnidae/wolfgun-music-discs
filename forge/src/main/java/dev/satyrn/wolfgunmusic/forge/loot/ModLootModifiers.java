package dev.satyrn.wolfgunmusic.forge.loot;

import com.mojang.serialization.Codec;
import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModLootModifiers {
    private ModLootModifiers() {
        throw new AssertionError("Class should not be initialized.");
    }

    public static final RegistryObject<Codec<OverlayLootTableModifier>> DISC_DUNGEON_LOOT_MODIFIER;
    static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTRAR = DeferredRegister.create(
            ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, WolfgunMusicDiscs.MOD_ID);

    static {
        DISC_DUNGEON_LOOT_MODIFIER = REGISTRAR.register("overlay_loot_table", OverlayLootTableModifier.CODEC);;
    }

    public static void register(IEventBus eventBus) {
        REGISTRAR.register(eventBus);
    }

}
