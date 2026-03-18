package dev.satyrn.wolfgunmusic.forge.data.provider.client;

import dev.satyrn.wolfgunmusic.WolfgunMusicDiscs;
import dev.satyrn.wolfgunmusic.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public final class ModUSEnglishLanguageProvider extends LanguageProvider {
    public ModUSEnglishLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addRecord(ModItems.MUSIC_DISC_AFTER_ANOTHER);
        this.addRecord(ModItems.MUSIC_DISC_BETWEEN_LAYERS);
        this.addRecord(ModItems.MUSIC_DISC_BLACK_DAWN);
        this.addRecord(ModItems.MUSIC_DISC_CLIFF_WHERE);
        this.addRecord(ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY);
        this.addRecord(ModItems.MUSIC_DISC_DEER);
        this.addRecord(ModItems.MUSIC_DISC_EVERY_MORNING);
        this.addRecord(ModItems.MUSIC_DISC_FAR_AWAY);
        this.addRecord(ModItems.MUSIC_DISC_INTO_STARS);
        this.addRecord(ModItems.MUSIC_DISC_LIGHTFORM);
        this.addRecord(ModItems.MUSIC_DISC_MOON_BEAMS);
        this.addRecord(ModItems.MUSIC_DISC_MOON_RAYS);
        this.addRecord(ModItems.MUSIC_DISC_MT_ENNUI);
        this.addRecord(ModItems.MUSIC_DISC_NIGHT_I);
        this.addRecord(ModItems.MUSIC_DISC_NIGHT_II);
        this.addRecord(ModItems.MUSIC_DISC_OF_PLAINS);
        this.addRecord(ModItems.MUSIC_DISC_PALE_STAR);
        this.addRecord(ModItems.MUSIC_DISC_PASSING);
        this.addRecord(ModItems.MUSIC_DISC_PEAKS);
        this.addRecord(ModItems.MUSIC_DISC_THROUGHOUT);
        this.addRecord(ModItems.MUSIC_DISC_TROPIC);
        this.addRecord(ModItems.MUSIC_DISC_UNSEEN_LAND);

        this.addRecordDescription(ModItems.MUSIC_DISC_AFTER_ANOTHER, "Wolfgun - After Another");
        this.addRecordDescription(ModItems.MUSIC_DISC_BETWEEN_LAYERS, "Wolfgun - Between Layers");
        this.addRecordDescription(ModItems.MUSIC_DISC_BLACK_DAWN, "Wolfgun - Black Dawn");
        this.addRecordDescription(ModItems.MUSIC_DISC_CLIFF_WHERE, "Wolfgun - Cliff Where");
        this.addRecordDescription(ModItems.MUSIC_DISC_DARK_SOUTHERN_SKY, "Wolfgun - Dark Southern Sky");
        this.addRecordDescription(ModItems.MUSIC_DISC_DEER, "Wolfgun - Deer");
        this.addRecordDescription(ModItems.MUSIC_DISC_EVERY_MORNING, "Wolfgun - Every Morning");
        this.addRecordDescription(ModItems.MUSIC_DISC_FAR_AWAY, "Wolfgun - Far Away");
        this.addRecordDescription(ModItems.MUSIC_DISC_INTO_STARS, "Wolfgun - Into Stars");
        this.addRecordDescription(ModItems.MUSIC_DISC_LIGHTFORM, "Wolfgun - Lightform");
        this.addRecordDescription(ModItems.MUSIC_DISC_MOON_BEAMS, "Wolfgun - Moon Beams");
        this.addRecordDescription(ModItems.MUSIC_DISC_MOON_RAYS, "Wolfgun - Moon Rays");
        this.addRecordDescription(ModItems.MUSIC_DISC_MT_ENNUI, "Wolfgun - Mt. Ennui");
        this.addRecordDescription(ModItems.MUSIC_DISC_NIGHT_I, "Wolfgun - Night I");
        this.addRecordDescription(ModItems.MUSIC_DISC_NIGHT_II, "Wolfgun - Night II");
        this.addRecordDescription(ModItems.MUSIC_DISC_OF_PLAINS, "Wolfgun - Of Plains");
        this.addRecordDescription(ModItems.MUSIC_DISC_PALE_STAR, "Wolfgun - Pale Star");
        this.addRecordDescription(ModItems.MUSIC_DISC_PASSING, "Wolfgun - Passing");
        this.addRecordDescription(ModItems.MUSIC_DISC_PEAKS, "Wolfgun - Peaks");
        this.addRecordDescription(ModItems.MUSIC_DISC_THROUGHOUT, "Wolfgun - Throughout");
        this.addRecordDescription(ModItems.MUSIC_DISC_TROPIC, "Wolfgun - Tropic");
        this.addRecordDescription(ModItems.MUSIC_DISC_UNSEEN_LAND, "Wolfgun - Unseen Land");

        this.add(WolfgunMusicDiscs.MOD_ID + ".links.bandcamp", "Wolfgun's Bandcamp");
        this.add(WolfgunMusicDiscs.MOD_ID + ".links.bandcampRunning", "Download RUNNING on Bandcamp");
        this.add(WolfgunMusicDiscs.MOD_ID + ".links.bandcampRunningII", "Download RUNNING II on Bandcamp");
    }

    private void addRecord(Supplier<Item> item) {
        this.add(item.get(), "High Fidelity Sound Wave Transmission System");
    }

    private void addRecordDescription(Supplier<Item> item, String description) {
        this.add(item.get().getDescriptionId() + ".desc", description);
    }

    @Override
    public String getName() {
        return "Wolfgun Music Discs Language Provider";
    }
}
