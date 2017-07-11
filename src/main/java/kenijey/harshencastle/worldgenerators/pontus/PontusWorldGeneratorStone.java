package kenijey.harshencastle.worldgenerators.pontus;

import java.util.Arrays;
import java.util.Random;

import kenijey.harshencastle.HarshenBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PontusWorldGeneratorStone extends WorldGenerator
{
	
	private final int numberOfBlocks = 7;
    private final IBlockState state = HarshenBlocks.harshen_dimensional_stone.getDefaultState();
    

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if(worldIn.getTopSolidOrLiquidBlock(position).getY() > 50 ||
				(worldIn.getTopSolidOrLiquidBlock(position).getY() < 30))
			return false;
		float f = rand.nextFloat() * (float)Math.PI;
        double d0 = (double)((float)(position.getX() + 8) + MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d1 = (double)((float)(position.getX() + 8) - MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0F);
        double d2 = (double)((float)(position.getZ() + 8) + MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d3 = (double)((float)(position.getZ() + 8) - MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0F);
        double d4 = (double)(position.getY() + rand.nextInt(3) - 2);
        double d5 = (double)(position.getY() + rand.nextInt(3) - 2);
        int numTime = numberOfBlocks  + rand.nextInt(23);
        for (int i = 0; i < numTime; ++i)
        {
            float f1 = (float)i / (float)numTime;
            double d6 = d0 + (d1 - d0) * (double)f1;
            double d7 = d4 + (d5 - d4) * (double)f1;
            double d8 = d2 + (d3 - d2) * (double)f1;
            double d9 = rand.nextDouble() * (double)numTime / 16.0D;
            double d10 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            double d11 = (double)(MathHelper.sin((float)Math.PI * f1) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.floor(d6 - d10 / 2.0D);
            int k = MathHelper.floor(d7 - d11 / 2.0D);
            int l = MathHelper.floor(d8 - d10 / 2.0D);
            int i1 = MathHelper.floor(d6 + d10 / 2.0D);
            int j1 = MathHelper.floor(d7 + d11 / 2.0D);
            int k1 = MathHelper.floor(d8 + d10 / 2.0D);

            for (int l1 = j; l1 <= i1; ++l1)
            {
                double d12 = ((double)l1 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D)
                {
                    for (int i2 = k; i2 <= j1; ++i2)
                    {
                        double d13 = ((double)i2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D)
                        {
                            for (int j2 = l; j2 <= k1; ++j2)
                            {
                                double d14 = ((double)j2 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
                                {
                                    BlockPos blockpos = new BlockPos(l1, i2, j2);
                                    if(Arrays.asList(HarshenBlocks.harshen_dimensional_dirt, HarshenBlocks.harshen_dimensional_rock).contains(worldIn.getBlockState(blockpos).getBlock()))
                                        worldIn.setBlockState(blockpos, this.state, 2);	

                                    
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
	}

}
