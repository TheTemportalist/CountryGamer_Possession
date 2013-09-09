package CountryGamer_Possession.Possession.Client.Render.Entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPossesed extends RenderLiving {
	
	protected ModelBase model;
	
	private static final ResourceLocation texture = new ResourceLocation("possesion", ""); //This will be changed to the entity's texture its representing

	public RenderPossesed() {
		super(new ModelCow(), 0.3F); //This is temp, read bellow
	  //super(entitymodel, f); Need to do the copying of entity before this
		this.model = this.mainModel;
	}

	public void renderPossesed(EntityLiving entity, double par2,double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderPossesed((EntityLiving) entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	
}