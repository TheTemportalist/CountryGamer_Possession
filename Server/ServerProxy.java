package mods.CountryGamer_Possession.Server;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ServerProxy {
	
	public void registerThings() {
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public void registerServerTickHandler() {
		
	}
	
}