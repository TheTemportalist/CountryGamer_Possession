package mods.CountryGamer_Possession.Possession.proxy;

import mods.CountryGamer_Possession.Possession.Client.Render.Entity.RenderPossesed;
import mods.CountryGamer_Possession.Possession.Entity.EntityPossesed;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void rendering(){
		RenderingRegistry.registerEntityRenderingHandler(EntityPossesed.class, new RenderPossesed());
	}
	

}
