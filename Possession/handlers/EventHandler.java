package CountryGamer_Possession.Possession.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

/**
 * Possession
 *
 * EventHandler
 *
 * @author Kirlac
 * @license Apache License v2.0 (http://www.apache.org/licenses/)
 *
 */
public class EventHandler {
    /**
     * PlayerSleepInBedEvent
     * Called whenever the player sleeps in a bed.
     * 
     * @param event The sleep event that gets raised. Contains player data, coordinates etc.
     */
    @ForgeSubscribe
    public void onPlayerSleep(PlayerSleepInBedEvent event)
    {
        EntityPlayer player = (EntityPlayer)event.entityPlayer;
        if (player.isSneaking())
        {
            //Block the sleeping action by setting the event result.
            event.result = EnumStatus.OTHER_PROBLEM;
            player.addChatMessage(String.format("%s is having an out of body experience", player.username));
            
            //spawn uninhabited player using current players skin and put uninhabited player in bed
            //put player into possession mode to roam around as a spirit
        }
    }
}