package CountryGamer_Possession.Possession.Entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import CountryGamer_Possession.Possession.Client.Model.ModelPossesed;

public class EntityPossesed extends EntityCreature {
	
	public EntityPlayer player;
	
	public ModelPossesed model;
	
	public EntityPossesed(World world) {
		super(world);
		model = new ModelPossesed(this);
	}
	
	public EntityPossesed(World world, EntityPlayer entityPlayer){
		super(world);
		player = entityPlayer;
		posX = player.posX;
		posY = player.posY;
		posZ = player.posZ;
	}

	protected void updateAITick(){
		super.updateAITick();
		
	}
}