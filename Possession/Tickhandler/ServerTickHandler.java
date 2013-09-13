package CountryGamer_Possession.Possession.Tickhandler;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		
	}
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
		if (type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((WorldServer)((EntityPlayerMP)tickData[0]).worldObj, (EntityPlayerMP)tickData[0]);
		}
		
	}
	@Override
	public EnumSet<TickType> ticks()
	{
	     return EnumSet.of(TickType.WORLD, TickType.PLAYER);
	}
	@Override
	public String getLabel() {
		return "PossessionServerTickHandler";
	}
	
	private void onPlayerTick(WorldServer world, EntityPlayerMP player){
		
	}
	
}