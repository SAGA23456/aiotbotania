package de.melanx.aiotbotania.items.livingrock;

import de.melanx.aiotbotania.items.ItemTiers;
import de.melanx.aiotbotania.items.base.ItemShovelBase;
import de.melanx.aiotbotania.util.ToolUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemLivingrockShovel extends ItemShovelBase {

    private static final int MANA_PER_DAMAGE = 40;
    private static final int DAMAGE = 1;
    private static final float SPEED = -3.0F;

    public ItemLivingrockShovel() {
        super("livingrock_shovel", ItemTiers.LIVINGROCK_ITEM_TIER, DAMAGE, SPEED, MANA_PER_DAMAGE);
    }

    public EnumActionResult onItemUse(@Nonnull ItemUseContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getPos();
        EnumFacing side = ctx.getFace();

        Block block = world.getBlockState(pos).getBlock();

        if (side != EnumFacing.DOWN && world.getBlockState(pos.up()).getBlock().isAir(world.getBlockState(pos.up()), world, pos.up()) && (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT)) {
            return ToolUtil.shovelUse(ctx, MANA_PER_DAMAGE);
        }
        return EnumActionResult.PASS;
    }
}
