package kenijey.harshencastle.items;

import java.util.List;

import kenijey.harshencastle.base.BaseItemCustomInvEffect;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BloodyEarring extends BaseItemCustomInvEffect
{
	public BloodyEarring()
	{
		setUnlocalizedName("bloody_earring");
		setRegistryName("bloody_earring");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("\u00A73" + new TextComponentTranslation("earring1").getFormattedText());
		tooltip.add("\u00a73" + new TextComponentTranslation("earring2").getFormattedText());
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public Potion getPotion() {
		return Potion.getPotionFromResourceLocation("regeneration");
	}
	
}
