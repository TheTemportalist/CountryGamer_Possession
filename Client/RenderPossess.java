package mods.CountryGamer_Possession.Client;

import mods.CountryGamer_Possession.Server.EntityPossess;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPossess extends RenderLiving {
	protected ModelBiped model;
 
	public RenderPossess (ModelBiped modelTutorial, float f) {
		super(modelTutorial, f);
		model = ((ModelBiped)mainModel);
	}

	public void renderTutorial(EntityPossess entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityPossess)par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	 
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityPossess)par1Entity, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("skins/");
	}
	
	
}