package CountryGamer_Possession.Possession.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import CountryGamer_Possession.Possession.Tickhandler.ClientTickHandler;
import CountryGamer_Possession.Possession.Tickhandler.ServerTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ServerProxy {

	public ClientTickHandler clientTickHandler;
	public ServerTickHandler serverTickHandler;
	
	public ArrayList<Class> compatibleEntities = new ArrayList<Class>();

	public void registerTickHandler() {
		serverTickHandler = new ServerTickHandler();
		TickRegistry.registerTickHandler(serverTickHandler, Side.SERVER);
	}

	public void rendering() {}
	
	/**
	 * Adds any entity that extends EntityLivingBase and the player Entity
	 * to the compatibleEntites array
	 */
	public void initModelList(){
		Iterator iterator = EntityList.classToStringMapping.entrySet().iterator();
		while(iterator.hasNext()){
			Entry entry = (Entry)iterator.next();
			Class clazz = (Class)entry.getKey();
			if(EntityLivingBase.class.isAssignableFrom(clazz) && !compatibleEntities.contains(clazz)){
				compatibleEntities.add(clazz);
			}
		}
		compatibleEntities.add(EntityPlayer.class);
	}
}