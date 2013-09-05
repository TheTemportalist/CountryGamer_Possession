package mods.CountryGamer_Possession.Possession;

import java.util.ArrayList;

import mods.CountryGamer_Possession.Possession.Util.EnumAbilities;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;

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
		float currentHealth = targetEnt.func_110143_aJ();
		float maxHealth = targetEnt.func_110138_aP();
		double attackDamage = 0;
		// Assuming that this should get the generic damage, which is
		// overridden on a per entity basis
		// I believe 'func_111125_b' to be able to get the value required 
		attackDamage = targetEnt.func_110140_aT().func_111150_b(
				SharedMonsterAttributes.field_111264_e).func_111125_b();
		ArrayList<EnumAbilities> abilities = null;
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
