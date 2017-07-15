package kenijey.harshencastle.items;

import java.util.List;

import kenijey.harshencastle.HarshenCastle;
import kenijey.harshencastle.enums.items.EnumBloodCollectorHandler.BloodLevels;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class BloodCollector extends Item
{		
	public BloodCollector() {
		setRegistryName("blood_collector");
		setUnlocalizedName("blood_collector");
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		if(tab.equals(HarshenCastle.harshenTab))
			items.add(new ItemStack(this, 1, 0));	
	}
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		for(int i = 0; i < BloodLevels.values().length; i ++)
			if(stack.getItemDamage() == i)
				return this.getUnlocalizedName() + "." + BloodLevels.values()[i].getName();
		return this.getUnlocalizedName() + "." + BloodLevels.ZERO.getName();
	}
	
	public boolean fill(World world, EntityPlayer player, EnumHand hand, int amount)
	{
		if(world.isRemote)
			return false;
		System.out.println("fil");
		boolean flag = false; 
		ItemStack stack = player.getHeldItem(hand);
		NBTTagCompound nbt = getNBT(stack);

		if(nbt.getInteger("Blood") + amount <= 50)
		{
			nbt.setInteger("Blood", nbt.getInteger("Blood") + amount);
			flag = true;
		}
		
		stack.setItemDamage(metaChange(nbt));
        stack.setTagCompound(nbt);
        player.setHeldItem(hand, stack);
        
		return flag;
	}
	
	public boolean remove(World world, EntityPlayer player, EnumHand hand, int amount)
	{
		if(world.isRemote)
			return false;
		ItemStack stack = player.getHeldItem(hand);
		NBTTagCompound nbt = getNBT(stack);
		if(nbt.getInteger("Blood") - amount <= 0)
			return false;
		nbt.setInteger("Blood", nbt.getInteger("Blood") - amount);
		stack.setItemDamage(metaChange(nbt));
		return true;
	}
	
	private NBTTagCompound getNBT(ItemStack stack)
	{
		NBTTagCompound nbt;
		if (stack.hasTagCompound())
	        nbt = stack.getTagCompound();
	    else
	    	nbt = new NBTTagCompound();
		
		if (!nbt.hasKey("Blood"))
			nbt.setInteger("Blood", 1);

		return nbt;
	}
	
	private int metaChange(NBTTagCompound nbt)
	{
		for(int i = 0; i < BloodLevels.values().length; i ++)
		{
			if(BloodLevels.values()[i].getAmount() <= nbt.getInteger("Blood") && (i + 1 == BloodLevels.values().length || BloodLevels.values()[i + 1].getAmount() > nbt.getInteger("Blood")))
				return i;
		}
		return 0;
	}
	
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Blood"))
			tooltip.add("Blood: " + Integer.toString(stack.getTagCompound().getInteger("Blood")) + " / 50");
		else
			tooltip.add("Blood: 0 / 50");
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
