package cz.wake.lobby.armorstands.events;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class Santa implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1497.9, 17, -1211.5, 180, 0);
    private ArmorStand as, as2, as3, as4;

    @Override
    public void spawn() {
        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        //as.setRightArmPose(new EulerAngle(5.8, 0, 0.3));
        //as.setLeftArmPose(new EulerAngle(5.8, 0, 5.9));

        ItemStack head = ItemFactory.createHead("test", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 176, 23, 31);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 176, 23, 31);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 156, 102, 31);
        as.setBoots(boots);

        ItemStack gift = ItemFactory.createHead("null", "3e35d6a1-1336-4828-8608-685fd67443ca", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWM4NTVlNjM4NDE3Yjg2N2YwMjhhOTI0N2FmOWUwOGI3N2MzNTJlNTc2NjM2MzQwZjg2Yjc4OTAzYjgyMzhlZiJ9fX0=");
        as.setItemInHand(gift);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Kalendar", "Kalendar", Main.getInstance());

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

        as2.setCustomName("§c§lVanocni kalendar");

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

        as3.setCustomName("§7Odmeny pro kazdeho!");

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
