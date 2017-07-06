package kenijey.harshencastle.items;

import kenijey.harshencastle.HarshenCastle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class HarshenItems 
{
	public static Item harshen_soul_fragment;
	public static Item soul_harsher_sword;
	public static Item soul_harsher_pickaxe;
	public static Item item_harshen_dimensional_door;
	public static Item itium;
	
	public static void preInit()
	{
		harshen_soul_fragment = new HarshenSoulFragment();
		soul_harsher_sword = new SoulHarsherSword();
		soul_harsher_pickaxe = new SoulHarsherPickaxe();
		item_harshen_dimensional_door = new HarshenDimensionalDoor();
		itium = new Itium();
	}
	
	public static void reg()
	{
		regItem(harshen_soul_fragment, 8);
		regItem(soul_harsher_sword, 1);
		regItem(soul_harsher_pickaxe, 1);
		regItem(item_harshen_dimensional_door,16);
		regItem(itium,16);
	}
	
	public static void regRenders()
	{
		regRender(harshen_soul_fragment);
		regRender(soul_harsher_sword);
		regRender(soul_harsher_pickaxe);
		regRender(item_harshen_dimensional_door);
		regRender(itium);
	}
	
	public static void regItem(Item item, int stackSize)
	{
		item.setMaxStackSize(stackSize);
		ForgeRegistries.ITEMS.register(item);
	}
	
	
	public static void regRender(Item item)
	{
		item.setCreativeTab(HarshenCastle.harshenTab);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}