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

public class Drunkers implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1461.5, 16.9, -1255.5, 180, 0);
    private Location loc2 = new Location(Bukkit.getWorld("omain"), 1461.5, 16.9, -1260.5, 0, 0);
    private Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
    ArmorStand as, as2, as3;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);
        as2 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc2, EntityType.ARMOR_STAND);
        as3 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc3, EntityType.ARMOR_STAND);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Wiliam", "Wiliam", Main.getInstance());
        Main.getInstance().getASM().setMetadata((ArmorStand) as2, "Felix", "Felix", Main.getInstance());
        Main.getInstance().getASM().setMetadata((ArmorStand) as3, "Ludvik", "Ludvik", Main.getInstance());

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        as2.setGravity(false);
        as2.setVisible(true);
        as2.setCanPickupItems(false);
        as2.setBasePlate(false);
        as2.setArms(true);

        as3.setGravity(false);
        as3.setVisible(true);
        as3.setCanPickupItems(false);
        as3.setBasePlate(false);
        as3.setArms(true);

        //as.setRightArmPose(new EulerAngle(5.8,0,0.3));
        as.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as.setHeadPose(new EulerAngle(0, 5.8, 0));
        as.setRightArmPose(new EulerAngle(5.0, 0, 0));

        as2.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as2.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as2.setRightArmPose(new EulerAngle(5.3, 0, 0));

        as3.setLeftLegPose(new EulerAngle(5.0, 0, 5.3));
        as3.setRightLegPose(new EulerAngle(5.0, 0, 0.3));
        as3.setRightArmPose(new EulerAngle(5.0, 0, 0));
        as3.setHeadPose(new EulerAngle(0, 5.8, 0));

        ItemStack head = ItemFactory.createHead("test", "df359c64-1f66-b7ed-b690-040afb3c0c7d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2M2ODI0ZDRkNWU5NTA2MTkwYzdkY2JkNGQyODQwMTViMzk2Y2EyOTIwNDdkNmM4NjJjOTZkZGU5NGY5ZmRmIn19fQ==");
        as.setHelmet(head);

        ItemStack head2 = ItemFactory.createHead("test", "a42ca4ad-4328-4670-84b7-5e64e85829fe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQxNWIxZTQ2NDMxZGE0ZDQ4ZDEzNWRhZDBjOTljNTEyNjVkODI4MTYwYTIyNTUyYTUzNjU5OWUyNTcyIn19fQ==");
        as2.setHelmet(head2);

        ItemStack head3 = ItemFactory.createHead("test", "ffcc9a53-aff6-426a-bcdb-c4b7176980d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTE0ZWMyZmIyNGMyZjY0YWU5YmFmYTFjNjk5ZGQxZTIzYjM0Mjc4OTQ5NTI1MTY2ZDVlN2EyZDY0MWY1ZDVhIn19fQ==");
        as3.setHelmet(head3);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 205, 183, 158);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 238, 213, 183);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 205, 183, 158);
        as.setBoots(boots);

        ItemStack item = ItemFactory.createHead("test", "e3e6b7a8-4246-41c4-9663-eddc9eda2eab", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA1M2UyNjg2N2JiNTc1MzhlOTc4OTEzN2RiYmI1Mzc3NGUxOGVkYTZmZWY1MWNiMmVkZjQyNmIzNzI2NCJ9fX0=");
        as.setItemInHand(item);

        ItemStack chestplate2 = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 205, 192, 176);
        as2.setChestplate(chestplate2);

        ItemStack leggins2 = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 238, 223, 204);
        as2.setLeggings(leggins2);

        ItemStack boots2 = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 205, 192, 176);
        as2.setBoots(boots2);

        as2.setItemInHand(item);

        ItemStack chestplate3 = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 152, 245, 255);
        as3.setChestplate(chestplate3);

        ItemStack leggins3 = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 142, 229, 238);
        as3.setLeggings(leggins3);

        ItemStack boots3 = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 142, 229, 238);
        as3.setBoots(boots3);

        as3.setItemInHand(item);

        /*
        new BukkitRunnable(){

            @Override
            public void run() {
                if(!Main.getInstance().getPlayers().isEmpty()){
                    ParticleEffect.SMOKE_LARGE.display(0.2f,0.0f,0.2f,0.0f,100, as3.getLocation(), Main.players);
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(),0L,3L); */

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
        as2.remove();
        as3.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
