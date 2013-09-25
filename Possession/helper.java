package CountryGamer_Possession.Possession;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.ResourceLocation;
import CountryGamer_Possession.Possession.Util.EnumAbility;

/**
 * 
 * @author Country_Gamer
 *
 */
public class helper { //TODO Needs more accurate Name and to be put into the correct package
	
	/*
	 * Order of calling:
	 * - get target stats
	 * - set new EntityPossess to model and skin of target
	 * -- getTargetModel & getTargetSkin
	 * -- setModel and setSkin
	 * - kill target
	 * send player to EntityPossess / spawn EntityPossess
	 * 
	 */
	
	public static Object[] getTargetStats(EntityLivingBase targetEnt) {
		float currentHealth = targetEnt.getHealth();
		float maxHealth = targetEnt.getMaxHealth();
		double attackDamage = 0;
		// TODO get the attack damage of the entity
		attackDamage = 0;
		ArrayList<EnumAbility> abilities = null;
		EnumCreatureAttribute creatureAttr = targetEnt.getCreatureAttribute();
		
		Object[] statArray = new Object[] {
				maxHealth, attackDamage, abilities, creatureAttr
			};
		return statArray;
	}
	public static ModelBase getTargetModel(EntityLivingBase targetEnt) {
		return null;
	}
	public static ResourceLocation getTargetSkin(EntityLivingBase taretEnt) {
		return null;
	}
	
}
