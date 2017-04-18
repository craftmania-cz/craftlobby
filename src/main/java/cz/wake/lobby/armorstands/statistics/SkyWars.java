package cz.wake.lobby.armorstands.statistics;

import cz.wake.lobby.Main;
import net.minecraft.server.v1_10_R1.EntityArmorStand;
import net.minecraft.server.v1_10_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_10_R1.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SkyWars {

    public static void spawn(Location loc, Player p){
        WorldServer s = ((CraftWorld)loc.getWorld()).getHandle();

        EntityArmorStand stand = new EntityArmorStand(s);
        stand.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand.setCustomName("§6§lTvoje SkyWars");
        stand.setCustomNameVisible(true);
        stand.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand2 = new EntityArmorStand(s);
        stand2.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand2.setCustomName("§7Vyhry (S+I): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players", "player_name","normal_wins"));
        stand2.setCustomNameVisible(true);
        stand2.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand3 = new EntityArmorStand(s);
        stand3.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand3.setCustomName("§7Zabiti (S+I): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_kills"));
        stand3.setCustomNameVisible(true);
        stand3.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand4 = new EntityArmorStand(s);
        stand4.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand4.setCustomName("§7Smrti (S+I): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_deaths"));
        stand4.setCustomNameVisible(true);
        stand4.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand5 = new EntityArmorStand(s);
        stand5.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand5.setCustomName("§7Odehrano (S+I): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_played"));
        stand5.setCustomNameVisible(true);
        stand5.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand6 = new EntityArmorStand(s);
        stand6.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand6.setCustomName("§7Vyhry (Team): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_team_wins"));
        stand6.setCustomNameVisible(true);
        stand6.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand7 = new EntityArmorStand(s);
        stand7.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand7.setCustomName("§7Zabiti (Team): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_team_kills"));
        stand7.setCustomNameVisible(true);
        stand7.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand8 = new EntityArmorStand(s);
        stand8.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand8.setCustomName("§7Smrti (Team): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_team_deaths"));
        stand8.setCustomNameVisible(true);
        stand8.setInvisible(true);

        loc.add(0,-0.3,0);

        EntityArmorStand stand9 = new EntityArmorStand(s);
        stand9.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand9.setCustomName("§7Odehrano (Team): §f" + Main.getInstance().fetchData().getMiniGamesStats(p,"skywars_players","player_name","normal_team_played"));
        stand9.setCustomNameVisible(true);
        stand9.setInvisible(true);


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

        PacketPlayOutSpawnEntityLiving packet8 = new PacketPlayOutSpawnEntityLiving(stand8);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet8);

        PacketPlayOutSpawnEntityLiving packet9 = new PacketPlayOutSpawnEntityLiving(stand9);
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet9);
    }
}
