package com.thesarlaacsweep.radioactiveblocks;

import com.thesarlaacsweep.radioactiveblocks.config.ModConfig;
import com.thesarlaacsweep.radioactiveblocks.init.ModBlocks;
import com.thesarlaacsweep.radioactiveblocks.init.ModItems;
import com.thesarlaacsweep.radioactiveblocks.init.ModOres;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("radioactiveblocks")
public class RadioactiveBlocks {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "radioactiveblocks";

    public RadioactiveBlocks() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_CONFIG, "radioactiveblocks-common-config.toml");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModConfig.loadConfig(ModConfig.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("radioactiveblocks-common-config.toml"));

        ModOres.init();
        ModItems.init();
        ModBlocks.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("radioactive_blocks_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModOres.URANIUM_ORE.get());
        }
    };

    public static final ItemGroup TOOLS_TAB = new ItemGroup("radioactive_blocks_tools_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.URANIUM_PICKAXE.get());
        }
    };

    public static final ItemGroup COMBAT_TAB = new ItemGroup("radioactive_blocks_combat_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.URANIUM_SWORD.get());
        }
    };
}
