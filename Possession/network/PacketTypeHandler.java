package mods.CountryGamer_Possession.Possession.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import mods.CountryGamer_Possession.Possession.lib.Reference;
import mods.CountryGamer_Possession.Possession.network.packet.PacketPion;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public enum PacketTypeHandler {
    ;//KEY(PacketKeyPressed.class); //TODO work on key bindings and packets

    private Class<? extends PacketPion> clazz;

    PacketTypeHandler(Class<? extends PacketPion> clazz) {

        this.clazz = clazz;
    }

    public static PacketPion buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketPion packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketPion buildPacket(PacketTypeHandler type) {

        PacketPion packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketPion packetPion) {

        byte[] data = packetPion.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel =  Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetPion.isChunkDataPacket;

        return packet250;
    }
}
