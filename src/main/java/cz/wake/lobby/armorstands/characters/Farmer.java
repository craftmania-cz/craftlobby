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
import org.bukkit.util.EulerAngle;

public class Farmer implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1583.5, 17, -1225.5, 50, 0);
    ArmorStand as;

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

        ItemStack head = ItemFactory.createHead("test", "3f48319b-e944-4056-964a-88f1b3e417ab", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjVkYTViMmU4ZTRlMmQ3ZjgxZWQ4NTM1MTBmODQ4YTJlZTZhNjQ1N2E5ZjI4YmIwNzFiMTE5ODBkZTkxODUifX19");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 205, 170, 125);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 205, 170, 125);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 205, 170, 125);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.STONE_HOE);
        as.setItemInHand(item);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Farmer", "Farmer", Main.getInstance());

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
    public void serverTeleport() {

    }

    @Override
    public void remove() {
        as.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
