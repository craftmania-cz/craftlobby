package cz.wake.lobby.armorstands.statistics;

import cz.wake.lobby.Main;
import net.minecraft.server.v1_12_R1.EntityArmorStand;
import net.minecraft.server.v1_12_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_12_R1.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Parkour {

    public static void spawn(Location loc, Player p) {
        WorldServer s = ((CraftWorld) loc.getWorld()).getHandle();

        EntityArmorStand stand = new EntityArmorStand(s);
        stand.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand.setCustomName("§b§lParkour");
        stand.setCustomNameVisible(true);
        stand.setInvisible(true);

        loc.add(0, -0.3, 0);

        EntityArmorStand stand2 = new EntityArmorStand(s);
        stand2.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0, 0);
        stand2.setCustomName("§7Tvoje nejlepsi skore: §f" + Main.getInstance().getSQL().getMiniGamesStats(p, "RPScore", "player", "score"));
        stand2.setCustomNameVisible(true);
        stand2.setInvisible(true);

        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(stand);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);

        PacketPlayOutSpawnEntityLiving packet2 = new PacketPlayOutSpawnEntityLiving(stand2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet2);
    }
}
