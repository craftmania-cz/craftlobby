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

public class CreativeOld implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1524.5, 18, -1222.5, -90, 0);
    private ArmorStand as, as2, as3, as4;
    private boolean maintenance;

    @Override
    public void spawn() {
        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        defaultItems();

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "creative2", "creative2", Main.getInstance());

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

        as2.setCustomName("§4§lCreative (1.12)");

        loc1.add(0, 0.3, 0);
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

    public void setPlayers(int i) {
        as3.setCustomName("§7" + i + " §8hracu");
    }

    @Override
    public void updateArmorStand(String s, int i) {
        as3.setCustomName(Main.getInstance().getASM().formatPlayers(i));
    }

    private void defaultItems() {
        ItemStack head = ItemFactory.createHead("test", "6bab871b-371a-424a-8114-85d36e6670f5", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc1N2MyNDcxN2YwMWQ0MThjZmNmNjEwNWZhMGZhZTM4NWI5Yjk5NmVkYzQzNjk4ZDY1ZmJlMzQ1ZGFhZiJ9fX0=");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 220, 20, 60);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 220, 20, 60);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 220, 20, 60);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.WATER_BUCKET);
        as.setItemInHand(item);
    }
}
