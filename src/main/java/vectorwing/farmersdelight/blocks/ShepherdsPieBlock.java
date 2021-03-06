package vectorwing.farmersdelight.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class ShepherdsPieBlock extends FeastBlock
{
	protected static final VoxelShape PLATE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
	protected static final VoxelShape PIE_SHAPE = VoxelShapes.combine(PLATE_SHAPE, Block.makeCuboidShape(2.0D, 2.0D, 2.0D, 14.0D, 8.0D, 14.0D), IBooleanFunction.OR);

	public ShepherdsPieBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
		super(properties, servingItem, hasLeftovers);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return state.get(SERVINGS) == 0 ? PLATE_SHAPE : PIE_SHAPE;
	}
}
