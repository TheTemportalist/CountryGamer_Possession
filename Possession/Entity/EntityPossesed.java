package CountryGamer_Possession.Possession.Entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import CountryGamer_Possession.Possession.Client.Model.ModelPossesed;

public class EntityPossesed extends EntityCreature {
	
	public EntityLivingBase possesedEntity;
	
	public ModelPossesed model;
	
	
	public EntityPossesed(World world) {
		super(world);
		model = new ModelPossesed(this);
	}
	
	public EntityPossesed(World world, EntityLivingBase possesing){
		super(world);
		this.possesedEntity = possesing;
		model = new ModelPossesed(this);
		yOffset = -0.5F;
		setSize(0.1F, 0.1F);
		setLocationAndAngles(possesedEntity.posX, possesedEntity.posY, possesedEntity.posZ, possesedEntity.rotationYaw, possesedEntity.rotationPitch);	
	}

	protected void updateAITick(){
		super.updateAITick();
		
	}
}