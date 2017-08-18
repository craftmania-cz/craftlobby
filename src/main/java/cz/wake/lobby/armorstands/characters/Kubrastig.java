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

public class Kubrastig implements ASInterface {

    private Location loc = new Location(Bukkit.getWorld("omain"), 1585.5, 16.9, -1272.5, 90, 0);
    private ArmorStand as;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc, EntityType.ARMOR_STAND);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Kubrastig", "Kubrastig", Main.getInstance());

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        as.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as.setLeftArmPose(new EulerAngle(4.2, 5.5, 0));
        as.setRightArmPose(new EulerAngle(5.8, 0, 0.3));
        as.setHeadPose(new EulerAngle(0,5.9, 0));

        ItemStack head = ItemFactory.createHead("test", "15bbb72b-c547-46a7-b66f-e0399a07a1cf", "eyJ0aW1lc3RhbXAiOjE1MDMwMTA1MzcyOTUsInByb2ZpbGVJZCI6IjE1YmJiNzJiYzU0NzQ2YTdiNjZmZTAzOTlhMDdhMWNmIiwicHJvZmlsZU5hbWUiOiJLdWJyYXN0aWciLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWE2Y2MyNThiMjdjZjk3NjYzNzQ1ODE5NzI5YTFkYmMzZGIwNmJjYWZjOWFkZWQ3MmQyM2I1NmFiMDgzNDYifX19");
        as.setHelmet(head);

        ItemStack item = ItemFactory.create(Material.FISHING_ROD, (byte)0, "");
        as.setItemInHand(item);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 0, 77, 230);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 20, 20, 20);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 20, 20, 20);
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
