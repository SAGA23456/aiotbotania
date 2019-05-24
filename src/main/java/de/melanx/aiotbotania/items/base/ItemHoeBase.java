package de.melanx.aiotbotania.items.base;

import de.melanx.aiotbotania.util.Registry;
import de.melanx.aiotbotania.util.ToolUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;

import javax.annotation.Nonnull;

import static de.melanx.aiotbotania.AIOTBotania.aiotItemGroup;

public class ItemHoeBase extends ItemHoe implements IManaUsingItem {

    private int MANA_PER_DAMAGE;
    private boolean special;
    private boolean low_tier;

    public ItemHoeBase(String name, IItemTier mat, int speed, int MANA_PER_DAMAGE, boolean special, boolean low_tier) {
        super(mat, speed, new Item.Properties().group(aiotItemGroup));
        Registry.registerItem(this, name);
        Registry.registerModel(this);

        this.MANA_PER_DAMAGE = MANA_PER_DAMAGE;
        this.special = special;
        this.low_tier = low_tier;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity player, int par4, boolean par5) {
        ToolUtil.inventoryTick(stack, world, player, MANA_PER_DAMAGE);
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, @Nonnull EntityLivingBase par3EntityLivingBase) {
        return ToolUtil.hitEntity(par1ItemStack, par3EntityLivingBase, MANA_PER_DAMAGE);
    }

    @Override
    public boolean onBlockDestroyed(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EntityLivingBase entity) {
        return ToolUtil.onBlockDestroyed(stack, world, state, pos, entity, MANA_PER_DAMAGE);
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(@Nonnull ItemUseContext ctx) {
        return ToolUtil.hoeUse(ctx, special, low_tier, MANA_PER_DAMAGE);
    }

    @Override
    public boolean usesMana(ItemStack itemStack) {
        return true;
    }
}
