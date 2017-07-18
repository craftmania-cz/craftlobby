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

public class Pirate implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1537.5, 16, -1333.5, -150, 0);
    private ArmorStand as;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        ItemStack head = ItemFactory.createHead("test", "c97a153a-8eab-ca72-8b99-4c2bcfa20074", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODkzZGMyY2UyOTA5ZjM1MjViMmQwNGQxMTEzYmUxMjQ5MzlmYTJiN2I5ZmIxYzY4NzZhMTk3ZDE2ODJhIn19fQ==");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 81, 81, 81);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 81, 81, 81);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 81, 81, 81);
        as.setBoots(boots);

        ItemStack item = ItemFactory.createHead("test", "a37123b2-8033-48bb-942f-d7e033528004", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjFkYTM4YjFiYzc1YTM5ZTcxYzdkY2IzY2FiNzNjMjZjODI2ZjgyNmM1OWU4YTQ0MTRjMThjNDU1Y2VlOWE2MiJ9fX0=");
        //as.setItemInHand(item);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "OPirate", "OPirate", Main.getInstance());

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
