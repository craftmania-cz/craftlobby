package cz.wake.lobby.armorstands.statistics;

import cz.wake.lobby.Main;
import net.minecraft.server.v1_10_R1.EntityArmorStand;
import net.minecraft.server.v1_10_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_10_R1.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SkyGiants {

    public static void spawn(Location loc, Player p){
        WorldServer s = ((CraftWorld)loc.getWorld()).getHandle();

        EntityArmorStand stand = new EntityArmorStand(s);
        stand.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand.setCustomName("§6Tvoje statistiky pro SkyGiants");
        stand.setCustomNameVisible(true);
        stand.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand2 = new EntityArmorStand(s);
        stand2.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand2.setCustomName("§7Vyhry: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"Victories"));
        stand2.setCustomNameVisible(true);
        stand2.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand3 = new EntityArmorStand(s);
        stand3.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand3.setCustomName("§7Zabiti: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"Kills"));
        stand3.setCustomNameVisible(true);
        stand3.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand4 = new EntityArmorStand(s);
        stand4.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand4.setCustomName("§7Smrti: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"Deaths"));
        stand4.setCustomNameVisible(true);
        stand4.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand5 = new EntityArmorStand(s);
        stand5.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand5.setCustomName("§7Zabiti bosse: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"BeastsSlain"));
        stand5.setCustomNameVisible(true);
        stand5.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand6 = new EntityArmorStand(s);
        stand6.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand6.setCustomName("§7Odehrano: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"GamesPlayed"));
        stand6.setCustomNameVisible(true);
        stand6.setInvisible(true);

        loc.add(0,-0.2,0);

        EntityArmorStand stand7 = new EntityArmorStand(s);
        stand7.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand7.setCustomName("§7Zniceno teamu: §f" + Main.getInstance().fetchData().getSkyGiantsStats(p,"Shutdowns"));
        stand7.setCustomNameVisible(true);
        stand7.setInvisible(true);


        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(stand);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);

        PacketPlayOutSpawnEntityLiving packet2 = new PacketPlayOutSpawnEntityLiving(stand2);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet2);

        PacketPlayOutSpawnEntityLiving packet3 = new PacketPlayOutSpawnEntityLiving(stand3);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet3);

        PacketPlayOutSpawnEntityLiving packet4 = new PacketPlayOutSpawnEntityLiving(stand4);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet4);

        PacketPlayOutSpawnEntityLiving packet5 = new PacketPlayOutSpawnEntityLiving(stand5);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet5);

        PacketPlayOutSpawnEntityLiving packet6 = new PacketPlayOutSpawnEntityLiving(stand6);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet6);

        PacketPlayOutSpawnEntityLiving packet7 = new PacketPlayOutSpawnEntityLiving(stand7);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet7);
    }
}
