package kenijey.harshencastle.fluids;

import kenijey.harshencastle.HarshenCastle;
import kenijey.harshencastle.fluids.blocks.HarshenDimensionalFluidBlock;
import kenijey.harshencastle.fluids.blocks.HarshingWaterBlock;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class HarshenFluids {

	
	public static Fluid harshen_dimensional_fluid;
	public static Block harshen_dimensional_fluid_block;
	
	public static Fluid harshing_water;
	public static Block harshing_water_block;

	public static void register()
	{
		harshen_dimensional_fluid = HarshenDimensionalFluid.instance;
        FluidRegistry.addBucketForFluid(harshen_dimensional_fluid);
        harshen_dimensional_fluid_block = registerFluidBlock(harshen_dimensional_fluid, new HarshenDimensionalFluidBlock(), HarshenDimensionalFluid.name);
        
        harshing_water = HarshingWater.instance;
        FluidRegistry.addBucketForFluid(harshing_water);
        harshing_water_block = registerFluidBlock(harshing_water, new HarshingWaterBlock(), HarshingWater.name);

	}
	
	public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name)
    {
        fluidBlock.setRegistryName(new ResourceLocation(HarshenCastle.MODID, name));
        ForgeRegistries.BLOCKS.register(fluidBlock);
        HarshenCastle.proxy.registerFluidBlockRendering(fluidBlock, name);
        fluid.setBlock(fluidBlock);
        return fluidBlock;
    }

}
