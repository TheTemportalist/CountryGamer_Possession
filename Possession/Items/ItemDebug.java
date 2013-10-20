package CountryGamer_Possession.Possession.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebug extends ItemBase {

	public ItemDebug(int id) {
		super(id);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,EntityPlayer player) {
		if( world.isRemote )return itemStack;
		
		  world.spawnEntityInWorld(new EntityPlayerMP());
		  return itemStack;
		
		/**
		player.addChatMessage("Enter Possession Mode");

		EntityLivingBase mob = null;
		double radius = 20.0D; // default 5
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.expand(radius, radius, radius));
		int count = 0;
		while(mob == null && count<entities.size()-1){
			if((EntityLivingBase) entities.get(count) instanceof EntityLivingBase){
				mob = (EntityLivingBase) entities.get(count);
			}
			count++;
		}
		if(mob != null){
			EntityPossesed possesed = new EntityPossesed(world, mob);
			mob.isDead = true;
			world.spawnEntityInWorld(possesed);
			Minecraft.getMinecraft().renderViewEntity = possesed;
		}
		return itemStack;

		/**
		  if( !player.worldObj.isRemote )

			player.addChatMessage("Enter Possession Mode");

		EntityLivingBase mob = null;
		double radius = 20.0D; // default 5
		List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(
				player, player.boundingBox.expand(radius, radius, radius));
		entLoop:
		for(Entity ent : entities) {
			if(ent instanceof EntityMob ||
					ent instanceof EntityGhast ||
					ent instanceof EntityIronGolem ||
					ent instanceof EntitySnowman) {
				mob = (EntityLivingBase) ent;
				if( !(mob instanceof EntityIronGolem) ) {
					mob.setDead();
					EntityLivingBase newMob = new EntityIronGolem(player.worldObj);
					newMob.setPosition(mob.posX, mob.posY, mob.posZ);
					if( !player.worldObj.isRemote )
						player.worldObj.spawnEntityInWorld(newMob);
					break entLoop;
				}
			}
		}

		return itemStack;
		 **/
	}


}
