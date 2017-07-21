package kenijey.harshencastle;

import kenijey.harshencastle.armor.HarshenArmors;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes 
{
	public static void init()
	{
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "soul_harsher_sword"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.soul_harsher_sword),
				" h ",
				"hsh",
				" i ",
				
				's', new ItemStack(HarshenItems.harshen_soul_fragment),
				'h', new ItemStack(HarshenItems.harshen_crystal),
				'i', new ItemStack(Items.IRON_INGOT));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_soul_ingot"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.harshen_soul_ingot),
				"e e",
				"csc",
				"e e",
				
				'c', new ItemStack(HarshenItems.harshen_crystal),
				's', new ItemStack(HarshenItems.harshen_soul_fragment),
				'e', new ItemStack(Items.EMERALD));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "pontus_ring"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.pontus_ring),
				" s ",
				"gig",
				" g ",
				
				'i', new ItemStack(HarshenItems.itium),
				's', new ItemStack(HarshenItems.harshen_soul_fragment),
				'g', new ItemStack(Items.GOLD_NUGGET));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "bloody_earring"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.bloody_earring),
				" i ",
				" s ",
				" b ",
				
				'i', new ItemStack(HarshenItems.itium),
				's', new ItemStack(HarshenItems.harshen_soul_fragment),
				'b', new ItemStack(HarshenItems.blood_essence));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_jaguar_armor_helmet"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenArmors.harshen_jaguar_armor_helmet),
				"iii",
				"i i",
				"   ",
				
				'i', new ItemStack(HarshenItems.harshen_soul_ingot));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_jaguar_armor_chestplate"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenArmors.harshen_jaguar_armor_chestplate),
				"i i",
				"iii",
				"iii",
				
				'i', new ItemStack(HarshenItems.harshen_soul_ingot));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_jaguar_armor_leggings"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenArmors.harshen_jaguar_armor_leggings),
				"iii",
				"i i",
				"i i",
				
				'i', new ItemStack(HarshenItems.harshen_soul_ingot));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_jaguar_armor_boots"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenArmors.harshen_jaguar_armor_boots),
				"   ",
				"i i",
				"i i",
				
				'i', new ItemStack(HarshenItems.harshen_soul_ingot));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_dimensional_pedestal"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenBlocks.harshen_dimensional_pedestal),
				" i ",
				" i ",
				" i ",
				
				'i', new ItemStack(HarshenItems.harshen_soul_ingot));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "harshen_dimensional_dirt"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenBlocks.harshen_dimensional_dirt, 3),
				" e ",
				"ede",
				" e ",
				
				'e', new ItemStack(HarshenItems.harshen_crystal),
				'd', new ItemStack(Blocks.DIRT));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "ritual_crystal.passive"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.ritual_crystal, 1, 1),
				" l ",
				"cec",
				" l ",
				
				'e', new ItemStack(Items.ENDER_EYE),
				'c', new ItemStack(HarshenItems.harshen_crystal),
				'l', new ItemStack(HarshenItems.light_emitted_essence));
		
		GameRegistry.addShapedRecipe(new ResourceLocation("harshencastle", "pontus_gate_spawner_enhanced"), new ResourceLocation("harshen_items"),
				new ItemStack(HarshenItems.pontus_world_gate_spawner, 1, 1),
				"isi",
				"ese",
				"ini",
				
				's', new ItemStack(HarshenItems.pontus_world_gate_spawner, 1, 0),
				'n', new ItemStack(Items.NETHER_STAR),
				'e', new ItemStack(Blocks.EMERALD_BLOCK),
				'i', new ItemStack(HarshenItems.itium));
	}
}