package xyz.brassgoggledcoders.ballast.block;

import com.google.common.base.Predicate;
import net.minecraft.block.BlockRailBase.EnumRailDirection;

public class RailPredicates {
    public static final Predicate<EnumRailDirection> FLAT_STRAIGHT = enumRailDirection ->
            enumRailDirection == EnumRailDirection.EAST_WEST || enumRailDirection == EnumRailDirection.NORTH_SOUTH;
}
