package cz.wake.lobby.armorstands.characters;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Bonusy implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"),1540.5, 18, -1222.5, 180, 0);
    private ArmorStand as,as2,as3,as4;

    @Override
    public void spawn() {
        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        as.setRightArmPose(new EulerAngle(5.8,0,0.3));
        as.setLeftArmPose(new EulerAngle(5.8,0,5.9));

        ItemStack head = ItemFactory.createHead("test","22a6d531-e947-4e01-ace0-019593c9c7d3","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjk1NjUyZGRlMDRmNzQ1Zjk1NGI2OTgxMGUwMjBlYTZiOTNlYjJkMzM0YjlkYjczODBiYmZmNTJjMmIwZjQifX19");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE,255,255,0);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS,255,255,0);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS,255,255,0);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.GOLD_INGOT);

        new BukkitRunnable() {
            int c = 1;

            @Override
            public void run(){
                if(c == 1){
                    as.getEquipment().setItemInOffHand(null);
                    as.setItemInHand(item);
                    c++;
                } else if (c == 2){
                    as.setItemInHand(null);
                    as.getEquipment().setItemInOffHand(item);
                    c--;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 25L);

        subtextSpawn();
        hologramSpawn();
    }

    @Override
    public void hologramSpawn() {

        loc1.add(0,0.3,0);

        as2 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as2.setGravity(false);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setVisible(false);
        as2.setCustomNameVisible(true);

        as2.setCustomName("§6§lBonusy");

    }

    @Override
    public void subtextSpawn(){

        loc1.add(0,0.3,0);

        as4 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as4.setGravity(false);
        as4.setCanPickupItems(false);
        as4.setBasePlate(false);
        as4.setVisible(false);
        as4.setCustomNameVisible(true);

        as4.setCustomName("§cJiz brzy...");

        loc1.add(0,0.3,0);

        as3 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as3.setGravity(false);
        as3.setCanPickupItems(false);
        as3.setBasePlate(false);
        as3.setVisible(false);
        as3.setCustomNameVisible(true);

        as3.setCustomName("§7Bonusy pro hrace!");
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void remove() {
        as.remove();
        as2.remove();
        as3.remove();
        as4.remove();
    }

    @Override
    public void updateArmorStand(String s, int i){

    }
}
