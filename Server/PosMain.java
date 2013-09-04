package mods.CountryGamer_Possession.Server;

import mods.CountryGamer_Possession.Server.Blocks.BlockBed;
import mods.CountryGamer_Possession.Server.Items.ItemDebug;
import net.minecraft.block.Block;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = PosMain.modid, name=PosMain.name, version=PosMain.modVersion)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class PosMain {
	
	public static final String modid = "CountryGamer_Possession";
	public static final String modidLower = modid.toLowerCase();
	public static final String name = "Possession Mod";
	public static final String modVersion = "1.0";
	public static final String gameVersion = "1.6.2";
	
	@Instance(PosMain.modid)
	public static PosMain instance = new PosMain();
	@SidedProxy(clientSide="mods.CountryGamer_Possession.Client.ClientProxy",
				serverSide="mods.CountryGamer_Possession.Server.ServerProxy")
	public static ServerProxy proxy;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String base_Tex = PosMain.modidLower + ":";
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Items */
	public static Item debugItem;
	public static int debugItemID;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Blocks */
	public static Block	bed;
	public static int	bedID = 2000;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Armor */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Mobs */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Other */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Achievements */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@EventHandler
	/**
	 * Before doing things with the mod. Holds Config file setup
	 * @param event
	 */
	public static void preInit(FMLPreInitializationEvent event) {
		/*
		 * Config File Setup
		 */
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		String		itemCate = "Item IDs",	blockCate = "Block IDs",
					general = config.CATEGORY_GENERAL
			;
		config.load();
		
		debugItemID	= config.get(itemCate,	"Debug Item",	1000).getInt();
		
		config.save();
		
		/*
		 * Other Things
		 */
		
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.registerThings();
		proxy.registerHandler();

		items();
		blocks();
		
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static void armor() {
		
	}
	public static void items() {
		debugItem = new ItemDebug(debugItemID).setUnlocalizedName("debugItem");
		LanguageRegistry.addName(debugItem, "Debug Item");
	}
	public static void blocks() {
		bed = new BlockBed(bedID).setUnlocalizedName("bed");
		//GameRegistry.registerBlock(bed, bed.getUnlocalizedName());
		LanguageRegistry.addName(bed, "Bed");
		bed.setCreativeTab(CreativeTabs.tabDecorations);
		//Block.blocksList[Block.bed.blockID] = bed;
	}
	
	public static void ents() {
		EntityRegistry.registerModEntity(EntityPossess.class, "Possession", 1, PosMain.instance, 80, 3, true);
		//EntityRegistry.addSpawn(EntityTutorial.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
		LanguageRegistry.instance().addStringLocalization("entity.Possession.Tutorial.name", "");
		
		
	}
	
	public static void craftSmelt() {
		
	}
	
	
}
