package CountryGamer_Possession.Possession.proxy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import CountryGamer_Possession.Possession.PosMain;
import CountryGamer_Possession.Possession.Client.Model.ModelInfo;
import CountryGamer_Possession.Possession.Client.Model.ModelList;
import CountryGamer_Possession.Possession.Entity.EntityPossesed;
import CountryGamer_Possession.Possession.Tickhandler.ClientTickHandler;
import CountryGamer_Possession.Possession.Util.ObfHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ClientProxy extends ServerProxy {
	
	@Override
	public void rendering(){
		RenderingRegistry.registerEntityRenderingHandler(EntityPossesed.class, PosMain.proxy.clientTickHandler.possessionRenderInstance);
	}
	
	@Override
	public void registerTickHandler(){
		super.registerTickHandler();
		clientTickHandler = new ClientTickHandler();
		TickRegistry.registerTickHandler(clientTickHandler, Side.CLIENT);
	}
	
	/**
	 * 
	 */
	@Override
	public void initModelList(){
		super.initModelList();

		HashMap<Class, RendererLivingEntity> renders = new HashMap<Class, RendererLivingEntity>();
		try{
			ArrayList entityRenderers = (ArrayList)ObfuscationReflectionHelper.getPrivateValue(RenderingRegistry.class, RenderingRegistry.instance(), "entityRenderers");

			for(Object obj : entityRenderers){
				Field[] fields = obj.getClass().getDeclaredFields();
				Render render = null;
				Class clzz = null;
				for(Field f : fields)
				{
					f.setAccessible(true);
					if(f.getType() == Render.class)
					{
						render = (Render)f.get(obj);
					}
					else if(f.getType() == Class.class)
					{
						clzz = (Class)f.get(obj);
					}
				}
				if(render instanceof RendererLivingEntity && clzz != null)
				{
					renders.put(clzz, (RendererLivingEntity)render);
				}
			}
		}
		catch(Exception e)
		{
		}

		for(int i = compatibleEntities.size() - 1; i >= 0; i--)
		{
			Render rend = RenderManager.instance.getEntityClassRenderObject(compatibleEntities.get(i));
			if(rend.getClass() == RenderEntity.class)
			{
				rend = renders.get(compatibleEntities.get(i));
			}
			if(!(rend instanceof RendererLivingEntity))
			{
				compatibleEntities.remove(i);
				continue;
			}
			if(!renders.containsKey(compatibleEntities.get(i)))
			{
				renders.put(compatibleEntities.get(i), (RendererLivingEntity)rend);
			}
		}

		for(Class clz : compatibleEntities)
		{
			try
			{
				RendererLivingEntity rend = (RendererLivingEntity)renders.get(clz);
				ModelList.addModelInfo(clz, new ModelInfo(clz, rend, (ModelBase)ObfuscationReflectionHelper.getPrivateValue(RendererLivingEntity.class, rend, ObfHelper.mainModel)));
			}
			catch(Exception e)
			{
				ObfHelper.obfWarning();
				e.printStackTrace();
			}
		}
	}

}
