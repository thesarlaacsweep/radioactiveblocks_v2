package com.thesarlaacsweep.radioactiveblocks.world;

import com.thesarlaacsweep.radioactiveblocks.RadioactiveBlocks;
import com.thesarlaacsweep.radioactiveblocks.init.ModOres;
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
    public  static  void onFeatureRegistryEvent(RegistryEvent.Register<Feature<?>> event) {
        ForgeRegistries.BIOMES.forEach(biome -> {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.AMERICIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(6, 3, 3, 90)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.BERKELIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 84)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.NEPTUNIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(3, 3, 3, 36)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.PLUTONIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(6, 5, 5, 100)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.PROTACTINIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(3, 4, 4, 48)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.RADIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(3, 3, 3, 52)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.TECHNETIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(4, 4, 4, 74)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.THORIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(3, 3, 3, 44)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.requireNonNull(ModOres.URANIUM_ORE.get()).getDefaultState(), 12
            ), Placement.COUNT_RANGE, new CountRangeConfig(7, 5, 5, 100)));
        });
    }
}
