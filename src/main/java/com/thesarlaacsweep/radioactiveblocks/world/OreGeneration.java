package com.thesarlaacsweep.radioactiveblocks.world;

import com.thesarlaacsweep.radioactiveblocks.RadioactiveBlocks;
import com.thesarlaacsweep.radioactiveblocks.config.ModConfig;
import com.thesarlaacsweep.radioactiveblocks.init.ModOres;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = RadioactiveBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGeneration {
    @SubscribeEvent
    public static void onFeatureRegistryEvent(RegistryEvent.Register<Feature<?>> event) {
        ForgeRegistries.BIOMES.forEach(biome -> {

            if (biome.getCategory() == Biome.Category.OCEAN || biome.getCategory() == Biome.Category.ICY) {
                getFeature(
                        biome,
                        Objects.requireNonNull(ModOres.NEPTUNIUM_ORE.get()).getDefaultState(),
                        ModConfig.neptunium_ore_size.get(),
                        ModConfig.neptunium_ore_size.get(),
                        ModConfig.neptunium_ore_height.get()
                );
            }

            if (biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.MUSHROOM || biome.getCategory() == Biome.Category.MESA) {
                getFeature(
                        biome,
                        Objects.requireNonNull(ModOres.THORIUM_ORE.get()).getDefaultState(),
                        ModConfig.thorium_ore_size.get(),
                        ModConfig.thorium_ore_count.get(),
                        ModConfig.thorium_ore_height.get()
                );
            }

            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.AMERICIUM_ORE.get()).getDefaultState(),
                    ModConfig.americium_ore_size.get(),
                    ModConfig.americium_ore_count.get(),
                    ModConfig.americium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.BERKELIUM_ORE.get()).getDefaultState(),
                    ModConfig.berkelium_ore_size.get(),
                    ModConfig.berkelium_ore_count.get(),
                    ModConfig.berkelium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.PLUTONIUM_ORE.get()).getDefaultState(),
                    ModConfig.plutonium_ore_size.get(),
                    ModConfig.plutonium_ore_count.get(),
                    ModConfig.plutonium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.PROTACTINIUM_ORE.get()).getDefaultState(),
                    ModConfig.protactinium_ore_size.get(),
                    ModConfig.protactinium_ore_count.get(),
                    ModConfig.protactinium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.RADIUM_ORE.get()).getDefaultState(),
                    ModConfig.radium_ore_size.get(),
                    ModConfig.radium_ore_count.get(),
                    ModConfig.radium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.TECHNETIUM_ORE.get()).getDefaultState(),
                    ModConfig.technetium_ore_size.get(),
                    ModConfig.technetium_ore_count.get(),
                    ModConfig.technetium_ore_height.get()
            );
            getFeature(
                    biome,
                    Objects.requireNonNull(ModOres.URANIUM_ORE.get()).getDefaultState(),
                    ModConfig.uranium_ore_size.get(),
                    ModConfig.uranium_ore_count.get(),
                    ModConfig.uranium_ore_height.get()
            );
        });
    }

    private static void getFeature(Biome biome, BlockState state, int size, int count, int maxHeight) {
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NATURAL_STONE, state, size
        ), Placement.COUNT_RANGE, new CountRangeConfig(count, 0, 0, maxHeight)));
    }
}
