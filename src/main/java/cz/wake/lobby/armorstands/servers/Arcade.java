package cz.wake.lobby.armorstands.servers;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Arcade implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1524.5, 18, -1222.5, -90, 0);
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

        as.setRightArmPose(new EulerAngle(5.8, 5.7, 0.2));

        subtextSpawn();
        hologramSpawn();

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "arcade", "arcade", Main.getInstance());

        new BukkitRunnable() {
            int c = 1;

            @Override
            public void run() {
                if (c == 1) {
                    ItemStack head = ItemFactory.createHead("test", "1eafb05a-c46b-4aa0-ab45-7b080cfea3f9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVhZmQ5ODFlNGYxNTJhMjQ0NmRmNmExY2Q4MTk4MmVkMDQ1NGQzODJkNzQyNDk3OWI0YmEwOWJmZjdjMzEifX19");
                    as.setHelmet(head);

                    ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 0, 191, 255);
                    as.setChestplate(chestplate);

                    ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 0, 191, 255);
                    as.setLeggings(leggins);

                    ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 0, 191, 255);
                    as.setBoots(boots);

                    ItemStack item = new ItemStack(Material.PAINTING);
                    as.setItemInHand(item);

                    as2.setCustomName("§b§lArcade");
                    as3.setCustomName("§fDrawIt");
                    //as4.setCustomName("§70 §8hracu");

                    Location loc = new Location(Bukkit.getWorld("omain"), 1524, 17, -1223);

                    //Block block = loc.getBlock();
                    //block.setType(Material.STAINED_GLASS);
                    //block.setData((byte) 3);

                    c++;
                } else if (c == 2) {
                    ItemStack head = ItemFactory.createHead("test", "4d43444c-2455-4f6e-b2bd-924b7e5050f3", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFkYzRhNmY1M2FmYTExNjAyN2I1MWQ2ZjJlNDMzZWU3YWZhNWQ1OWIyZmZhMDQ3ODBiZTQ2NGZhNWQ2MWEifX19");
                    as.setHelmet(head);

                    ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 51, 89, 171);
                    as.setChestplate(chestplate);

                    ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 51, 89, 171);
                    as.setLeggings(leggins);

                    ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 51, 89, 171);
                    as.setBoots(boots);

                    ItemStack item = new ItemStack(Material.PRISMARINE_CRYSTALS);
                    as.setItemInHand(item);

                    as2.setCustomName("§9§lArcade");
                    as3.setCustomName("§fSpeedBuilders");
                    //as4.setCustomName("§70 §8hracu");

                    Location loc = new Location(Bukkit.getWorld("omain"), 1524, 17, -1223);

                    //Block block = loc.getBlock();
                    //block.setType(Material.STAINED_GLASS);
                    //block.setData((byte) 11);

                    c = 1;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 35L);

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

    }

    @Override
    public void subtextSpawn() {

        /*
        loc1.add(0,0.3,0);

        as4 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as4.setGravity(false);
        as4.setCanPickupItems(false);
        as4.setBasePlate(false);
        as4.setVisible(false);
        as4.setCustomNameVisible(true); */

        loc1.add(0, 0.3, 0);

        as3 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as3.setGravity(false);
        as3.setCanPickupItems(false);
        as3.setBasePlate(false);
        as3.setVisible(false);
        as3.setCustomNameVisible(true);

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
        //as4.remove();

    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
