package cz.wake.lobby.armorstands.podlobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CrystalBox implements Listener {

    private static Location loc = new Location(Bukkit.getWorld("obw2"), -584.5, 111, 118.5);
    private static ArmorStand as, as2;

    public static void spawn(){
        Entity crystal = loc.getWorld().spawnEntity(loc,EntityType.ENDER_CRYSTAL);
        hologramSpawn();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onExplode(EntityExplodeEvent e){
        if(e instanceof EnderCrystal){
            e.setCancelled(true);
        }
    }

    private static void hologramSpawn() {

        loc.add(0, 0.2, 0);

        as = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setVisible(false);
        as.setCustomNameVisible(true);

        as.setCustomName("§8SOOON!");

        loc.add(0, 0.3, 0);

        as2 = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc, EntityType.ARMOR_STAND);

        as2.setGravity(false);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setVisible(false);
        as2.setCustomNameVisible(true);

        as2.setCustomName("§9§lCrystalBox");

    }
}
