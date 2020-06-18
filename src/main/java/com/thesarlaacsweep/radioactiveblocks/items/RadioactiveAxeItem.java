package com.thesarlaacsweep.radioactiveblocks.items;

import com.google.common.collect.ImmutableMap.Builder;
import com.thesarlaacsweep.radioactiveblocks.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;

public class RadioactiveAxeItem extends AxeItem {
    int enchantmentId;
    int levelOfEnchantment;
//    public static final Map<Block, Block> RADIOACTIVE_BLOCK_STRIPPING_MAP = (new Builder<Block,Block>())
//            .put(ModBlocks.RADIOACTIVE_ACACIA_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_ACACIA_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_ACACIA_LOG.get(), ModBlocks.RADIOACTIVE_STRIPPED_ACACIA_LOG.get())
//            .put(ModBlocks.RADIOACTIVE_BIRCH_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_BIRCH_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_BIRCH_LOG.get(), ModBlocks.RADIOACTIVE_STRIPPED_BIRCH_LOG.get())
//            .put(ModBlocks.RADIOACTIVE_DARK_OAK_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_DARK_OAK_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_DARK_OAK_LOG.get(), ModBlocks.RADIOACTIVE_STRIPPED_DARK_OAK_LOG.get())
//            .put(ModBlocks.RADIOACTIVE_JUNGLE_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_JUNGLE_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_JUNGLE_LOG.get(), ModBlocks.RADIOACTIVE_STRIPPED_JUNGLE_LOG.get())
//            .put(ModBlocks.RADIOACTIVE_OAK_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_OAK_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_OAK_LOG.get(), ModBlocks.RADIOACTIVE_STRIPPED_OAK_LOG.get())
//            .put(ModBlocks.RADIOACTIVE_SPRUCE_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_SPRUCE_WOOD.get())
//            .put(ModBlocks.RADIOACTIVE_SPRUCE_WOOD.get(), ModBlocks.RADIOACTIVE_STRIPPED_SPRUCE_LOG.get())
//            .build();

    public RadioactiveAxeItem(
            IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder, int enchantmentIdIn, int levelOfEnchantmentIn
    ) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.enchantmentId = enchantmentIdIn;
        this.levelOfEnchantment = levelOfEnchantmentIn;
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.addEnchantment(Objects.requireNonNull(Enchantment.getEnchantmentByID(this.enchantmentId)), this.levelOfEnchantment);
    }

//    @Override
//    public ActionResultType onItemUse(ItemUseContext context) {
//        World world = context.getWorld();
//        BlockPos blockpos = context.getPos();
//        BlockState blockstate = world.getBlockState(blockpos);
//        Block block = RADIOACTIVE_BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
//        if (block != null) {
//            PlayerEntity playerEntity = context.getPlayer();
//            world.playSound(playerEntity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
//
//            if (!world.isRemote) {
//                world.setBlockState(blockpos, block.getDefaultState().with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
//
//                if (playerEntity != null) {
//                    context.getItem().damageItem(1, playerEntity, (playerEntity1) -> {
//                        playerEntity1.sendBreakAnimation(context.getHand());
//                    });
//                }
//            }
//            return ActionResultType.SUCCESS;
//        } else {
//            return super.onItemUse(context);
//        }
//    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH));
        if (target.getClassification(false) == EntityClassification.MONSTER) {
            target.setFire(4000);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
