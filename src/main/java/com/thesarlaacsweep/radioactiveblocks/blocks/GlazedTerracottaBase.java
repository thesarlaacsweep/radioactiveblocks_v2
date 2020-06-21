package com.thesarlaacsweep.radioactiveblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class GlazedTerracottaBase extends GlazedTerracottaBlock {
    public GlazedTerracottaBase(Material materialIn, ToolType toolIn, SoundType soundTypeIn) {
        super(
                Block.Properties.create(materialIn)
                        .harvestLevel(2)
                        .hardnessAndResistance(3f, 6000f)
                        .harvestTool(toolIn)
                        .sound(soundTypeIn)
                        .lightValue(15)
        );
    }

    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, EntitySpawnPlacementRegistry.PlacementType type, @Nullable EntityType<?> entityType) {
        return false;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn.getClassification(false) == EntityClassification.MONSTER) {
            entityIn.setFire(5000);
            entityIn.attackEntityFrom(DamageSource.ON_FIRE, 3f);
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}