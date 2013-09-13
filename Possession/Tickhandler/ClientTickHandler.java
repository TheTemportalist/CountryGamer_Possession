package CountryGamer_Possession.Possession.Tickhandler;

import java.util.EnumSet;

import net.minecraft.client.renderer.entity.RenderManager;
import CountryGamer_Possession.Possession.Client.Model.ModelPossesed;
import CountryGamer_Possession.Possession.Client.Render.Entity.RenderPossesed;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {

	public RenderPossesed possessionRenderInstance;
	
	public ClientTickHandler(){
		possessionRenderInstance = new RenderPossesed(new ModelPossesed(), 0.0F);
		possessionRenderInstance.setRenderManager(RenderManager.instance);
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		return "TickHandlerClientPossession";
	}

}
