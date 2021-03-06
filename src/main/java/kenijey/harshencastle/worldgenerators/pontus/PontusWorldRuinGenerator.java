package kenijey.harshencastle.worldgenerators.pontus;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PontusWorldRuinGenerator extends WorldGenerator
{
	
	private final BlockPos size;
	private final ArrayList<Block> blocksAllowedToOverride = new ArrayList<Block>();
	
	public PontusWorldRuinGenerator(BlockPos size, Block... blocksAllowedToOverride) {
		super();
		this.size = size;
		for(Block block : blocksAllowedToOverride)
			this.blocksAllowedToOverride.add(block);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for(int x = 0; x <= this.size.getX(); x++)
			for(int y = 0; y <= this.size.getY(); y++)
				for(int z = 0; z <= this.size.getZ(); z++)
					if(blocksAllowedToOverride.contains(worldIn.getBlockState(position.add(x, y, z)).getBlock()) && rand.nextInt(5) == 0)
						worldIn.setBlockToAir(position.add(x, y, z));
		return true;
	}

}
