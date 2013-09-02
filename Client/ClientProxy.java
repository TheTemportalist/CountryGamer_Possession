package mods.CountryGamer_Possession.Client;

import mods.CountryGamer_Possession.Server.ServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerThings() {
		
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
}
