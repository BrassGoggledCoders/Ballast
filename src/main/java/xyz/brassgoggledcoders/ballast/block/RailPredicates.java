package xyz.brassgoggledcoders.ballast.block;

import net.minecraft.block.BlockRailBase.EnumRailDirection;

import java.util.function.Predicate;

public class RailPredicates {
    public static final Predicate<EnumRailDirection> FLAT_STRAIGHT = enumRailDirection ->
            enumRailDirection == EnumRailDirection.EAST_WEST || enumRailDirection == EnumRailDirection.NORTH_SOUTH;

    public static final Predicate<EnumRailDirection> ALL_CURVES = enumRailDirection ->
            enumRailDirection == EnumRailDirection.NORTH_WEST || enumRailDirection == EnumRailDirection.SOUTH_WEST ||
                    enumRailDirection == EnumRailDirection.NORTH_EAST || enumRailDirection == EnumRailDirection.SOUTH_EAST;
}
