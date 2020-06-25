package com.thesarlaacsweep.radioactiveblocks.events;

import com.thesarlaacsweep.radioactiveblocks.RadioactiveBlocks;
import com.thesarlaacsweep.radioactiveblocks.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RadioactiveBlocks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler {
    @SubscribeEvent
    public static void registerBlockColorHandler(final ColorHandlerEvent.Block event) {
        event.getBlockColors().register((x, reader, pos, u) -> reader != null && pos != null ?
                BiomeColors.getGrassColor(reader, pos) : GrassColors.get(0.5D, 1.0D), ModBlocks.RADIOACTIVE_LANDSCAPE_GRASS.get());
    }

    @SubscribeEvent
    public static void registerItemColorHandler(final ColorHandlerEvent.Item event) {
        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemColors = event.getItemColors();

        final IItemColor itemBlockColorHandler = (stack, tintIndex) -> {
            @SuppressWarnings("deprecation")
            final BlockState state = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(state, null, null, tintIndex);
        };
        itemColors.register(itemBlockColorHandler, ModBlocks.RADIOACTIVE_LANDSCAPE_GRASS_ITEM.get());
    }
}
