package com.thesarlaacsweep.radioactiveblocks.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.thesarlaacsweep.radioactiveblocks.RadioactiveBlocks;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class ModConfig {

    public static final String CATEGORY_CONFIG = "configurations";
    public static final String CATEGORY_EFFECTS = "effects";
    public static final String CATEGORY_ORE_SPAWN = "orespawn";
    public static final String SUBCATEGORY_ORE_SIZE = "oresize";
    public static final String SUBCATEGORY_ORE_COUNT = "orecount";
    public static final String SUBCATEGORY_ORE_MAX_HEIGHT = "oremaxheight";

    public static final int DEFAULT_ORE_SIZE = 8;
    public static final int SMALL_ORE_COUNT = 2;
    public static final int MEDIUM_ORE_COUNT = 4;
    public static final int LARGE_ORE_COUNT = 6;
    public static final int HIGH_ORE_COUNT = 8;

    public static final ForgeConfigSpec.Builder COMMON = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue has_radiation_effect;

    public static ForgeConfigSpec.IntValue americium_ore_count;
    public static ForgeConfigSpec.IntValue berkelium_ore_count;
    public static ForgeConfigSpec.IntValue neptunium_ore_count;
    public static ForgeConfigSpec.IntValue plutonium_ore_count;
    public static ForgeConfigSpec.IntValue protactinium_ore_count;
    public static ForgeConfigSpec.IntValue radium_ore_count;
    public static ForgeConfigSpec.IntValue technetium_ore_count;
    public static ForgeConfigSpec.IntValue thorium_ore_count;
    public static ForgeConfigSpec.IntValue uranium_ore_count;

    public static ForgeConfigSpec.IntValue americium_ore_size;
    public static ForgeConfigSpec.IntValue berkelium_ore_size;
    public static ForgeConfigSpec.IntValue neptunium_ore_size;
    public static ForgeConfigSpec.IntValue plutonium_ore_size;
    public static ForgeConfigSpec.IntValue protactinium_ore_size;
    public static ForgeConfigSpec.IntValue radium_ore_size;
    public static ForgeConfigSpec.IntValue technetium_ore_size;
    public static ForgeConfigSpec.IntValue thorium_ore_size;
    public static ForgeConfigSpec.IntValue uranium_ore_size;

    public static ForgeConfigSpec.IntValue americium_ore_height;
    public static ForgeConfigSpec.IntValue berkelium_ore_height;
    public static ForgeConfigSpec.IntValue neptunium_ore_height;
    public static ForgeConfigSpec.IntValue plutonium_ore_height;
    public static ForgeConfigSpec.IntValue protactinium_ore_height;
    public static ForgeConfigSpec.IntValue radium_ore_height;
    public static ForgeConfigSpec.IntValue technetium_ore_height;
    public static ForgeConfigSpec.IntValue thorium_ore_height;
    public static ForgeConfigSpec.IntValue uranium_ore_height;

    static {
        COMMON.comment("Radioactive Blocks Configuration").push(CATEGORY_CONFIG);
        COMMON.comment("Radiation Effects Setting").push(CATEGORY_EFFECTS);
        has_radiation_effect = COMMON
                .comment("Sets player, mob, tool, weapons and armor radiation effects on or off (includes: enchantment/potion effects)")
                .translation(RadioactiveBlocks.MOD_ID + ".config.has_radiation_effect")
                .define("has_radiation_effect", true);
        COMMON.pop();

        COMMON.comment("Ore Spawn Settings").push(CATEGORY_ORE_SPAWN);
        oreSizeConfig();
        oreCountConfig();
        oreMaxHeightConfig();
        COMMON.pop();

        COMMON_CONFIG = COMMON.build();
    }

    private static void oreSizeConfig() {
        COMMON.comment("Ore Size Settings").push(SUBCATEGORY_ORE_SIZE);
        americium_ore_size = COMMON
                .comment("Sets Americium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.americium_ore_size")
                .defineInRange("americium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        berkelium_ore_size = COMMON
                .comment("Sets Berkelium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.berkelium_ore_size")
                .defineInRange("berkelium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        neptunium_ore_size = COMMON
                .comment("Sets Neptunium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.neptunium_ore_size")
                .defineInRange("neptunium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        plutonium_ore_size = COMMON
                .comment("Sets Plutonium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.plutonium_ore_size")
                .defineInRange("plutonium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        protactinium_ore_size = COMMON
                .comment("Sets Protactinium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.protactinium_ore_size")
                .defineInRange("protactinium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        radium_ore_size = COMMON
                .comment("Sets Radium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.radium_ore_size")
                .defineInRange("radium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        technetium_ore_size = COMMON
                .comment("Sets Technetium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.technetium_ore_size")
                .defineInRange("technetium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        thorium_ore_size = COMMON
                .comment("Sets Thorium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.thorium_ore_size")
                .defineInRange("thorium_ore_size", DEFAULT_ORE_SIZE, 1, 20);

        uranium_ore_size = COMMON
                .comment("Sets Uranium Ore Spawn Size")
                .translation(RadioactiveBlocks.MOD_ID + ".config.uranium_ore_size")
                .defineInRange("uranium_ore_size", DEFAULT_ORE_SIZE, 1, 20);
        COMMON.pop();
    }

    private static void oreCountConfig() {
        COMMON.comment("Ore Count Settings").push(SUBCATEGORY_ORE_COUNT);
        americium_ore_count = COMMON
                .comment("Sets Americium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.americium_ore_count")
                .defineInRange("americium_ore_count", LARGE_ORE_COUNT, 1, 12);

        berkelium_ore_count = COMMON
                .comment("Sets Berkelium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.berkelium_ore_count")
                .defineInRange("berkelium_ore_count", MEDIUM_ORE_COUNT, 1, 12);

        neptunium_ore_count = COMMON
                .comment("Sets Neptunium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.neptunium_ore_count")
                .defineInRange("neptunium_ore_count", SMALL_ORE_COUNT, 1, 12);

        plutonium_ore_count = COMMON
                .comment("Sets Plutonium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.plutonium_ore_count")
                .defineInRange("plutonium_ore_count", LARGE_ORE_COUNT, 1, 12);

        protactinium_ore_count = COMMON
                .comment("Sets Protactinium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.protactinium_ore_count")
                .defineInRange("protactinium_ore_count", SMALL_ORE_COUNT, 1, 12);

        radium_ore_count = COMMON
                .comment("Sets Radium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.radium_ore_count")
                .defineInRange("radium_ore_count", SMALL_ORE_COUNT, 1, 12);

        technetium_ore_count = COMMON
                .comment("Sets Technetium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.technetium_ore_count")
                .defineInRange("technetium_ore_count", MEDIUM_ORE_COUNT, 1, 12);

        thorium_ore_count = COMMON
                .comment("Sets Thorium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.thorium_ore_count")
                .defineInRange("thorium_ore_count", SMALL_ORE_COUNT, 1, 12);

        uranium_ore_count = COMMON
                .comment("Sets Uranium Ore Spawn Count")
                .translation(RadioactiveBlocks.MOD_ID + ".config.uranium_ore_count")
                .defineInRange("uranium_ore_count", HIGH_ORE_COUNT, 1, 12);
        COMMON.pop();
    }

    private static void oreMaxHeightConfig() {
        COMMON.comment("Ore Max Height Settings (y coordinate)").push(SUBCATEGORY_ORE_MAX_HEIGHT);
        americium_ore_height = COMMON
                .comment("Sets Americium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.americium_ore_height")
                .defineInRange("americium_ore_height", 90, 5, 100);

        berkelium_ore_height = COMMON
                .comment("Sets Berkelium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.berkelium_ore_height")
                .defineInRange("berkelium_ore_height", 84, 5, 100);

        neptunium_ore_height = COMMON
                .comment("Sets Neptunium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.neptunium_ore_height")
                .defineInRange("neptunium_ore_height", 36, 5, 100);

        plutonium_ore_height = COMMON
                .comment("Sets Plutonium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.plutonium_ore_height")
                .defineInRange("plutonium_ore_height", 100, 5, 100);

        protactinium_ore_height = COMMON
                .comment("Sets Protactinium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.protactinium_ore_height")
                .defineInRange("protactinium_ore_height", 48, 5, 100);

        radium_ore_height = COMMON
                .comment("Sets Radium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.radium_ore_height")
                .defineInRange("radium_ore_height", 52, 5, 100);

        technetium_ore_height = COMMON
                .comment("Sets Technetium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.technetium_ore_height")
                .defineInRange("technetium_ore_height", 74, 5, 100);

        thorium_ore_height = COMMON
                .comment("Sets Thorium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.thorium_ore_height")
                .defineInRange("thorium_ore_height", 44, 5, 100);

        uranium_ore_height = COMMON
                .comment("Sets Uranium Ore Spawn Height")
                .translation(RadioactiveBlocks.MOD_ID + ".config.uranium_ore_height")
                .defineInRange("uranium_ore_height", 100, 5, 100);
        COMMON.pop();
    }

    public static void  loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }
}
