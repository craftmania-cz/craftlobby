package cz.wake.lobby.armorstands.servers;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

public class Halloween implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1539.5, 18, -1222.5, 180, 0);
    private ArmorStand as, as2, as3;

    @Override
    public void spawn() {
        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        ItemStack head = ItemFactory.createHead("test", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ==");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 44, 45, 45);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 44, 45, 45);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 44, 45, 45);
        as.setBoots(boots);

        subtextSpawn();
        hologramSpawn();

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Halloween", "Halloween", Main.getInstance());
    }

    @Override
    public void hologramSpawn() {

        loc1.add(0, 0.3, 0);

        as2 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as2.setGravity(false);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setVisible(false);
        as2.setCustomNameVisible(true);

        as2.setCustomName("§6§lHalloween");

    }

    @Override
    public void subtextSpawn() {

        loc1.add(0, 0.3, 0);

        as3 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as3.setGravity(false);
        as3.setCanPickupItems(false);
        as3.setBasePlate(false);
        as3.setVisible(false);
        as3.setCustomNameVisible(true);

        as3.setCustomName("§eKlikni k hraní!");

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
    }

    @Override
    public void updateArmorStand(String s, int i) {
        as3.setCustomName("§c" + getRemainingTime());
    }

    private String getRemainingTime() {
        //final long remaining = 1540681200000L /* 26.10.2018, 17:00 */ - System.currentTimeMillis();
        //return TimeUtils.formatTime("%d dni %h hodin %m minut", (remaining/1000)/60, false);
        return "§eKlikni k hraní!";
        //return "Klikni k hrani!";
    }
}
