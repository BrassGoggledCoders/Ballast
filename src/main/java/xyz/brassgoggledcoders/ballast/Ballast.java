package xyz.brassgoggledcoders.ballast;

import com.teamacronymcoders.base.BaseModFoundation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(
        modid = Ballast.MOD_ID,
        name = Ballast.MOD_NAME,
        version = Ballast.VERSION
)
public class Ballast extends BaseModFoundation<Ballast> {

    public static final String MOD_ID = "ballast";
    public static final String MOD_NAME = "Ballast";
    public static final String VERSION = "1.0.0";

    @Instance(MOD_ID)
    public static Ballast INSTANCE;

    public Ballast() {
        super(MOD_ID, MOD_NAME, VERSION, null);
    }

    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public Ballast getInstance() {
        return this;
    }
}
