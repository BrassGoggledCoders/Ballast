package xyz.brassgoggledcoders.ballast.block;

import com.teamacronymcoders.base.blocks.IHasBlockStateMapper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockRailHolding extends BlockRailPowerFoundation implements IHasBlockStateMapper {
    public static final PropertyBool NORTH_WEST = PropertyBool.create("north_west");
    public static final PropertyEnum<EnumRailDirection> SHAPE = PropertyEnum.create("shape", EnumRailDirection.class,
            RailPredicates.FLAT_STRAIGHT);

    public BlockRailHolding() {
        super("holding");
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(POWERED, false)
                .withProperty(SHAPE, EnumRailDirection.NORTH_SOUTH).withProperty(NORTH_WEST, true));
    }

    @Override
    public boolean canMakeSlopes(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, SHAPE, POWERED, NORTH_WEST);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        IBlockState blockState = this.getDefaultState();
        if (meta > 7) {
            meta = meta - 8;
            blockState = blockState.withProperty(POWERED, true);
        }
        if (meta % 2 != 0) {
            blockState = blockState.withProperty(SHAPE, EnumRailDirection.EAST_WEST);
        }
        if (meta > 1) {
            blockState = blockState.withProperty(NORTH_WEST, false);
        }

        return blockState;
    }

    @Override
    public int getMetaFromState(IBlockState blockState) {
        int facing = blockState.getValue(SHAPE) == EnumRailDirection.NORTH_SOUTH ? 0 : 1;
        facing += blockState.getValue(NORTH_WEST) ? 0 : 2;
        int powered = blockState.getValue(POWERED) ? 8 : 0;
        return facing + powered;
    }

    @Override
    public String getVariant(IBlockState blockState) {
        int facing = blockState.getValue(SHAPE) == EnumRailDirection.NORTH_SOUTH ? 0 : 1;
        facing += blockState.getValue(NORTH_WEST) ? 0 : 2;
        return "facing=" + EnumFacing.VALUES[facing + 2] + ",powered=" + blockState.getValue(POWERED).toString();
    }

    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return SHAPE;
    }
}
