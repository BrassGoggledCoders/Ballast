package xyz.brassgoggledcoders.ballast.block;

import com.teamacronymcoders.base.IBaseMod;
import com.teamacronymcoders.base.blocks.IAmBlock;
import com.teamacronymcoders.base.blocks.IHasItemBlock;
import com.teamacronymcoders.base.client.models.IHasModel;
import com.teamacronymcoders.base.items.itemblocks.ItemBlockModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public abstract class BlockRailPowerFoundation extends BlockRailPowered implements IHasItemBlock, IHasModel, IAmBlock {
    private IBaseMod mod;
    private ItemBlock itemBlock;
    private String name;

    public BlockRailPowerFoundation(String name) {
        this.itemBlock = new ItemBlockModel<>(this);
        this.name = name;
        this.setUnlocalizedName(name);
    }

    @Override
    public IBaseMod getMod() {
        return mod;
    }

    @Override
    public void setMod(IBaseMod mod) {
        this.mod = mod;
    }

    @Override
    public ItemBlock getItemBlock() {
        return itemBlock;
    }

    @Override
    public boolean isFlexibleRail(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public List<String> getModelNames(List<String> modelNames) {
        modelNames.add(name);
        return modelNames;
    }
}
