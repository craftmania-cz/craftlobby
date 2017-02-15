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

public class Oliver implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1471.5, 17.7, -1245.5, -90, 0);
    ArmorStand as;

    @Override
    public void spawn() {
        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);
        as.setSmall(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        //as.setRightArmPose(new EulerAngle(5.8,0,0.3));
        as.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as.setHeadPose(new EulerAngle(0.2, 0, 0));

        ItemStack head = ItemFactory.createHead("test", "081df8b7-c2f7-4886-bc3b-ffbdb2bae13f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBiNDY0MWExOTg0MzUwYTliNGRmMzJkMmQzZjRhN2EzMWMzYTcyY2MwN2U4YTI4N2M2NjQ0NjMyNzk1NyJ9fX0=");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 171, 130, 255);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 171, 130, 255);
        //as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 171, 130, 255);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.STONE_HOE);
        //as.setItemInHand(item);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Child", "Child", Main.getInstance());
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
