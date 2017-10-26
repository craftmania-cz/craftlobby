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

public class TeamBuildBattle implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1525.5, 18, -1214.5, -130, 0);
    ArmorStand as, as2, as3;

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

        ItemStack head = ItemFactory.createHead("test", "9ef87154-8d59-424a-8af6-1cab6a49353a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjNjOWVlNzJmZjI3YjUwZmYzYTk4Y2E0OTJhNTQ1MTQ5NzRjYzMwZmE4Mzk3YjI3ZWYzMWQ1OTg4N2VlM2ZiIn19fQ==");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 146, 76, 198);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 146, 76, 198);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 146, 76, 198);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.WORKBENCH);
        as.setItemInHand(item);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "buildbattle", "buildbattle", Main.getInstance());

        subtextSpawn();
        hologramSpawn();

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

        as2.setCustomName("§5§lTeam BuildBattle");

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

        as3.setCustomName("§810/2017");

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

    }
}