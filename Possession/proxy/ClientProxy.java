package CountryGamer_Possession.Possession.proxy;

import CountryGamer_Possession.Possession.Client.Render.Entity.RenderPossesed;
import CountryGamer_Possession.Possession.Entity.EntityPossesed;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends ServerProxy {
	
	@Override
	public void rendering(){
		RenderingRegistry.registerEntityRenderingHandler(EntityPossesed.class, new RenderPossesed());
	}
	

}
