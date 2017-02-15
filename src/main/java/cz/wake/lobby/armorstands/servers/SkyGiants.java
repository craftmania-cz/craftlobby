package cz.wake.lobby.armorstands.servers;

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

public class SkyGiants implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1525.5, 18, -1214.5, -130, 0);
    ArmorStand as, as2, as3, as4;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        as.setRightArmPose(new EulerAngle(4.5, 0.2, 0));
        as.setLeftArmPose(new EulerAngle(4.8, 0.2, 0));
        as.setLeftLegPose(new EulerAngle(5.9, 0, 0));
        as.setRightLegPose(new EulerAngle(0.1, 0, 0));
        as.setHeadPose(new EulerAngle(0, 0, 0.3));

        ItemStack head = ItemFactory.createHead("test", "a593ac46-8eb5-46f0-ab18-5a5c496a94fc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjY3YjI3ZmI3ZTI5ZWM5OGUxY2Q0YThmODQ2Njg1NmQ5ZWYzZjJlOWZiZDlhZWQ2MzExZjhhYmU1NGI2YWIyIn19fQ==");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 0, 139, 0);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 113, 113, 198);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 0, 139, 0);
        as.setBoots(boots);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "skygiants", "skygiants", Main.getInstance());

        subtextSpawn();
        hologramSpawn();
        novinka();
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

        as2.setCustomName("§2§lSkyGiants §c§lBETA");
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

        as3.setCustomName("§7Nacitani...");
    }

    public void novinka() {
        loc1.add(0, 0.3, 0);

        as4 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as4.setGravity(false);
        as4.setCanPickupItems(false);
        as4.setBasePlate(false);
        as4.setVisible(false);
        as4.setCustomNameVisible(true);

        as4.setCustomName("§e§lNOVINKA");
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
        as2.remove();
        as3.remove();
        as4.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {
        as3.setCustomName(Main.getInstance().getASM().formatPlayers(i));
    }
}
