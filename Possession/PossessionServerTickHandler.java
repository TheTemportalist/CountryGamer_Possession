package mods.CountryGamer_Possession.Possession;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PossessionServerTickHandler implements ITickHandler {
	
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
	
	private void onPlayerTick(WorldServer world, EntityPlayerMP player)
	{
		/**
		 * NOTE: Cannot access player.getSleepTimer() when running
		 * on a server.
		 * Must force by night cycle from world or force from player laying
		 * in a bed.
		 */
		int sleepTicks = 0;//player.getSleepTimer();
		
		if(sleepTicks == 50) { // sleep counted up to 110
			System.out.println("Start");
			// Start Possession
		}
		
		/*
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
        */
	
	}
	
}