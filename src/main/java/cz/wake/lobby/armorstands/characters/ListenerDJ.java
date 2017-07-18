package cz.wake.lobby.armorstands.characters;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class ListenerDJ implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1542.5, 14, -1256.5, 0, 0);
    private Location loc2 = new Location(Bukkit.getWorld("omain"), 1538.5, 14, -1255.5, 0, 0);
    private ArmorStand as, as2;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);
        as2 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc2, EntityType.ARMOR_STAND);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Veverka1", "Veverka1", Main.getInstance());
        Main.getInstance().getASM().setMetadata((ArmorStand) as2, "Veverka2", "Veverka2", Main.getInstance());

        //as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        //as2.setGravity(false);
        as2.setVisible(true);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        ItemStack head = ItemFactory.createHead("test", "714f5422-5680-4854-9935-dfb1f1e1fefc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTlhM2Y2ZmQzNDIzNTM2ZTFkNDc2NDY2NGZiNTVhNDA4ZjViODFjYjgyNTFmNjUxYWQ1MWU4YWViMWFhODY3NSJ9fX0=");
        as.setHelmet(head);
        as2.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 156, 102, 31);
        as.setChestplate(chestplate);
        as2.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 156, 102, 31);
        as.setLeggings(leggins);
        as2.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 156, 102, 31);
        as.setBoots(boots);
        as2.setBoots(boots);

        new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
                if (i == 0) {
                    as.setRightArmPose(new EulerAngle(3.3, 0, 6.0));
                    as.setLeftArmPose(new EulerAngle(3.3, 0, 0.2));
                    as2.setRightArmPose(new EulerAngle(3.3, 0, 6.0));
                    as2.setLeftArmPose(new EulerAngle(3.3, 0, 0.2));
                    as.setVelocity(new Vector(0, 0.3, 0));
                    for (Entity ent : getNearbyEntities(as.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    for (Entity ent : getNearbyEntities(as2.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    i++;
                } else if (i == 1) {
                    as.setRightArmPose(new EulerAngle(3.3, 0, 5.8));
                    as.setLeftArmPose(new EulerAngle(3.3, 0, 0.4));
                    as2.setRightArmPose(new EulerAngle(3.3, 0, 5.8));
                    as2.setLeftArmPose(new EulerAngle(3.3, 0, 0.4));
                    as2.setVelocity(new Vector(0, 0.3, 0));
                    i++;
                    for (Entity ent : getNearbyEntities(as.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    for (Entity ent : getNearbyEntities(as2.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                } else if (i == 2) {
                    as.setRightArmPose(new EulerAngle(3.3, 0, 5.6));
                    as.setLeftArmPose(new EulerAngle(3.3, 0, 0.6));
                    as2.setRightArmPose(new EulerAngle(3.3, 0, 5.6));
                    as2.setLeftArmPose(new EulerAngle(3.3, 0, 0.6));
                    as.setVelocity(new Vector(0, 0.3, 0));
                    i++;
                    for (Entity ent : getNearbyEntities(as.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    for (Entity ent : getNearbyEntities(as2.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                } else if (i == 3) {
                    as.setRightArmPose(new EulerAngle(3.3, 0, 5.8));
                    as.setLeftArmPose(new EulerAngle(3.3, 0, 0.4));
                    as2.setRightArmPose(new EulerAngle(3.3, 0, 5.8));
                    as2.setLeftArmPose(new EulerAngle(3.3, 0, 0.4));
                    as2.setVelocity(new Vector(0, 0.3, 0));
                    i++;
                    for (Entity ent : getNearbyEntities(as.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    for (Entity ent : getNearbyEntities(as2.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                } else if (i == 4) {
                    as.setRightArmPose(new EulerAngle(3.3, 0, 6.0));
                    as.setLeftArmPose(new EulerAngle(3.3, 0, 0.2));
                    as2.setRightArmPose(new EulerAngle(3.3, 0, 6.0));
                    as2.setLeftArmPose(new EulerAngle(3.3, 0, 0.2));
                    for (Entity ent : getNearbyEntities(as.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    for (Entity ent : getNearbyEntities(as2.getEyeLocation().add(-.5d, -.5d, -.5d), 3d)) {
                        if (ent.isOnGround()) {
                            ent.setVelocity(new Vector(0, 0.3, 0));
                        }
                    }
                    i = 0;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 5L);

    }

    @Override
    public void hologramSpawn() {

    }

    @Override
    public void subtextSpawn() {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void remove() {
        as.remove();
        as2.remove();
    }

    public ArrayList<Entity> getNearbyEntities(Location loc, double distance) {
        ArrayList<Entity> entities = new ArrayList<>();
        for (Entity ent : loc.getWorld().getEntities()) {
            if (ent.getLocation().distance(loc) <= distance) {
                entities.add(ent);
            }
        }
        return entities;
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
