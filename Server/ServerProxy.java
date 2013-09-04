package mods.CountryGamer_Possession.Server;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ServerProxy {
	
	public void registerThings() {
		
	}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public void registerHandler() {
		TickRegistry.registerTickHandler(new PossessionServerTickHandler(), Side.SERVER);
		
	}
	
}
