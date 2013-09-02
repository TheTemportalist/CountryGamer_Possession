package mods.CountryGamer_Possession.Server;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
	if (type.equals(EnumSet.of(TickType.PLAYER)))
	     {
	         onPlayerTick((EntityPlayer)tickData[0]);
	     }
	}
	private void onPlayerTick(EntityPlayer player)
	{
		int sleepTicks = player.getSleepTimer();
		if(sleepTicks == 99) {
			System.out.println("about to fall asleep");
			//dostuff
		}
		
		ChunkCoordinates playerLocation;
		playerLocation = new ChunkCoordinates(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ));
		ChunkCoordinates c = playerLocation;
        int blockID = player.worldObj.getBlockId(c.posX, c.posY, c.posZ);
        boolean isInBed =
        		Block.blocksList[blockID] != null &&
        		Block.blocksList[blockID].isBed(
        				player.worldObj, c.posX, c.posY, c.posZ,
        				(EntityLivingBase)player
        			);
        
	
	}
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
	}
	@Override
	public EnumSet<TickType> ticks()
	{
	     return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}