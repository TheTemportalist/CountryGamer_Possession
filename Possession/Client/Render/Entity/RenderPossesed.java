package CountryGamer_Possession.Possession.Client.Render.Entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import CountryGamer_Possession.Possession.Entity.EntityPossesed;

public class RenderPossesed extends RendererLivingEntity {

	public static final ResourceLocation morphSkin = new ResourceLocation("morph", "textures/skin/morphskin.png");

	public RenderPossesed(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
	}

	@Override
    protected void passSpecialRender(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6)
    {
    }

	public void setMainModel(ModelBase base)
	{
		mainModel = base;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if(entity instanceof EntityPossesed){
			setMainModel(((EntityPossesed)entity).model);
		}
		return morphSkin;
	}
}