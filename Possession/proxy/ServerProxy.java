package CountryGamer_Possession.Possession.proxy;

import CountryGamer_Possession.Possession.PossessionServerTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ServerProxy {

	public void registerHandler() {
		TickRegistry.registerTickHandler(new PossessionServerTickHandler(), Side.SERVER);
	}
	
	public void rendering() {}
	
}
