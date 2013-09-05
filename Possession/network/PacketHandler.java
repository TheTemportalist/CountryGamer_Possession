package CountryGamer_Possession.Possession.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import CountryGamer_Possession.Possession.network.packet.PacketPion;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{
	
	/**
	 * Handles Packet250CustomPayload packets 
	 * that are registered to any Possession Channel
	 * @param manager The NetworkManager associated with the current platform (client/server)
	 * @param packet The Packet that was received (Packet250CustomPayload)
	 * @param player The player associated with the packet
	 */

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		//
		PacketPion packetPion = PacketTypeHandler.buildPacket(packet.data);
		
		
		packetPion.execute(manager, player);
	}

}
