package CountryGamer_Possession.Possession.Client.Model;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * The list of Models so that we can render with them
 * (Theres no way to get the entity models through the entity's themself)
 * @author Altra
 * @credit iChun
 */
public class ModelList {

	private static final HashMap<Class, ModelInfo> modelInfoMap = new HashMap<Class, ModelInfo>();

	public static void addModelInfo(Class clazz, ModelInfo info){
		if(EntityLivingBase.class.isAssignableFrom(clazz)){
			modelInfoMap.put(clazz, info);
		}
	}

	public static ModelInfo getModelInfo(Class clazz){
		ModelInfo info = modelInfoMap.get(clazz);
		if(info == null){
			try{
				Class superClazz = clazz.getSuperclass();

				while(superClazz != Entity.class && Entity.class.isAssignableFrom(superClazz) && info == null){
					info = modelInfoMap.get(superClazz);
					superClazz = superClazz.getSuperclass();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return info;
	}

}
