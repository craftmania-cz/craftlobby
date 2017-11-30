package cz.wake.lobby.armorstands.events;

import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class Matka implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1498.5, 17, -1259.5, 129, 0);
    private ArmorStand as;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        as.setRightArmPose(new EulerAngle(5.8, 0, 0.3));

        ItemStack head = ItemFactory.createHead("test", "cd5c5b77-d178-4c9f-9086-4161c65e9281", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTRlZDkzN2EyMmJkZTdkZWUxNGNjZmFmZDViNWYxMjg0MTdjZDhkNTFkMmE3NjVhNTk4YmViYTMyNTg4ODgifX19");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 205, 133, 63);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 205, 133, 63);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 205, 133, 63);
        as.setBoots(boots);

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
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
