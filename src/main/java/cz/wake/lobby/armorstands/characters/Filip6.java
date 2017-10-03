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

public class Filip6 implements ASInterface {

    private Location loc = new Location(Bukkit.getWorld("omain"), 1578.5, 16.9, -1277.5, 0, 0);
    private ArmorStand as;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc, EntityType.ARMOR_STAND);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Filip6", "Filip6", Main.getInstance());

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        as.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as.setRightArmPose(new EulerAngle(5.8, 0, 0.39));

        ItemStack head = ItemFactory.createHead("test", "c25f01ec-9fa8-4ff6-ae34-7286f8c44b27", "eyJ0aW1lc3RhbXAiOjE1MDcwNjIyODc1NjgsInByb2ZpbGVJZCI6ImMyNWYwMWVjOWZhODRmZjZhZTM0NzI4NmY4YzQ0YjI3IiwicHJvZmlsZU5hbWUiOiJGaWxpcDZfQ1oiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMxZGQwZDM4ZWYwNWVkZGU4YzcxMjU4OWQ4ZWZhMjUyN2U2ODJjZDljOThmNDEzOTg2OTMxOThiMjEzZGZiNyJ9fX0=");
        as.setHelmet(head);

        ItemStack item = ItemFactory.create(Material.GOLD_AXE, (byte) 0, "");
        as.setItemInHand(item);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 218, 218, 20);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 218, 218, 20);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 218, 218, 20);
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
