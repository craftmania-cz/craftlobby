package cz.wake.lobby.armorstands.podlobby;

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

public class BedWars4v4Ranked implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("obw2"), -611.5, 111, 108.5, -24, 0);
    private ArmorStand as, as2, as3, as4;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        as.setRightArmPose(new EulerAngle(5.8, 0, 0.3));

        ItemStack head = ItemFactory.createHead("test", "c8fd735c-03d2-4dc3-a173-01b950fe875a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2EzNDVlOTFmZWNlNWYyNGFhNDdkNGZjNWQzNTMzZTlhYmJiNjcyYmQzZTg1YjhhMTc4NzE1MjU1MWE4In19fQ==");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 17, 129, 200);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 17, 129, 200);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 17, 129, 200);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.LAPIS_ORE);
        as.setItemInHand(item);

        Main.getInstance().getASM().setMetadata(as, "4v4Ranked", "4v4Ranked", Main.getInstance());

        subtextSpawn();
        hologramSpawn();

    }

    @Override
    public void hologramSpawn() {

        loc1.add(0, 0.3, 0);

        as4 = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as4.setGravity(false);
        as4.setCanPickupItems(false);
        as4.setBasePlate(false);
        as4.setVisible(false);
        as4.setCustomNameVisible(true);

        as4.setCustomName("§c§lBedWars [Ranked]");

        loc1.add(0, 0.3, 0);

        as2 = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as2.setGravity(false);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setVisible(false);
        as2.setCustomNameVisible(true);

        as2.setCustomName("§74v4");

        loc1.add(0, 0.3, 0);

    }

    @Override
    public void subtextSpawn() {

        loc1.add(0, 0.3, 0);

        as3 = (ArmorStand) Bukkit.getWorld("obw2").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as3.setGravity(false);
        as3.setCanPickupItems(false);
        as3.setBasePlate(false);
        as3.setVisible(false);
        as3.setCustomNameVisible(true);

        as3.setCustomName("§cSOON!");
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void remove() {
        as.remove();
        as2.remove();
        as4.remove();
        as3.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {
        as3.setCustomName(Main.getInstance().getASM().formatPlayers(i));
    }
}
