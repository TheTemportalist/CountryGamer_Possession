package CountryGamer_Possession.Possession;

import CountryGamer_Possession.Possession.Entity.EntityPossesed;
import CountryGamer_Possession.Possession.Items.ItemDebug;
import CountryGamer_Possession.Possession.lib.Reference;
import CountryGamer_Possession.Possession.network.PacketHandler;
import CountryGamer_Possession.Possession.proxy.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//Using Pion as shorthand for Possession, should probably come up with a better one
@Mod(modid = Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketHandler.class)
public class PosMain {

	@Instance(Reference.MOD_ID)
	public static PosMain instance;
	
	@SidedProxy(clientSide= Reference.CLIENT_PROXY_CLASS, serverSide= Reference.SERVER_PROXY_CLASS)
	
	public static ServerProxy proxy;
	
	public static CreativeTabs tabsPion = new creativeTabPion(CreativeTabs.getNextID(), Reference.MOD_ID);

	public static final String TEXTURE_PATH = Reference.MOD_ID_LOWERCASE + ":";

	/** Items */
	public static Item debugItem;
	public int debugItemID;

	/** Blocks */

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		/*
		 * Config File Setup
		 */
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		String itemCate = "Item IDs", blockCate = "Block IDs", general = config.CATEGORY_GENERAL;
		config.load();

		debugItemID	= config.get(itemCate, "Debug Item", 1000).getInt();

		config.save();

	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.registerHandler();
		proxy.rendering();
		
		items();
		blocks();
		entitys();
		

	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	
	public void items() {
		debugItem = new ItemDebug(debugItemID).setUnlocalizedName("debugItem");
		GameRegistry.registerItem(debugItem, "debugItem");
		LanguageRegistry.addName(debugItem, "Debug Item");
	}
	public void blocks() {

	}

	public void entitys() {
		EntityRegistry.registerModEntity(EntityPossesed.class, "Possesed", 1, PosMain.instance, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization("entity," + Reference.MOD_ID + "Possesed.name", "Possesed");
	}
}
