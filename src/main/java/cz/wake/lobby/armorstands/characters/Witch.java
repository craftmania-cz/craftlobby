package cz.wake.lobby.armorstands.characters;

import cz.craftmania.craftcore.spigot.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Witch implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1615.5, 24, -1232.5, 100, 0);
    private Location loc2 = new Location(Bukkit.getWorld("omain"), 1645.5, 21, -1173.5, 75, 0);
    private Location loc3 = new Location(Bukkit.getWorld("omain"), 1453.5, 24, -1174.5, 80, 0);
    private ArmorStand as, as2, as3;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);
        as2 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc2, EntityType.ARMOR_STAND);
        as3 = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc3, EntityType.ARMOR_STAND);

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

        ItemStack head = ItemFactory.createHead("test", "99a0d91d-1dd2-44db-bb1f-9c6d968db16b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTFmMTUwODU5MDI5MWJlZTA1NjJkMzJhZDc1NDRmNjI4YWVhZDg5ZWEzY2FhNTRkYzg3NTEyMGFjOTViMWZhIn19fQ==");
        ItemStack head2 = ItemFactory.createHead("test", "68ab540e-1ad4-4680-9fc3-b42bcf869253", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRlZGJlZTQyYmU0NzJlM2ViNzkxZTdkYmRmYWYxOGM4ZmU1OTNjNjM4YmExMzk2YzllZjY4ZjU1NWNiY2UifX19");
        as.setHelmet(head);
        as2.setHelmet(head2);
        as3.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 142, 56, 142);
        as.setChestplate(chestplate);
        as2.setChestplate(chestplate);
        as3.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 142, 56, 142);
        as.setLeggings(leggins);
        as2.setLeggings(leggins);
        as3.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 142, 56, 142);
        as.setBoots(boots);
        as2.setBoots(boots);
        as3.setBoots(boots);

        ItemStack item = new ItemStack(Material.LINGERING_POTION, (byte) 0);
        as.setItemInHand(item);
        as3.setItemInHand(item);

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Witch1", "Witch1", Main.getInstance());
        Main.getInstance().getASM().setMetadata((ArmorStand) as2, "Witch2", "Witch2", Main.getInstance());
        Main.getInstance().getASM().setMetadata((ArmorStand) as3, "Witch3", "Witch3", Main.getInstance());

        new BukkitRunnable() {

            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() >= 1) {
                    try {
                        ParticleEffect.PORTAL.display(0.3f, 0.3f, 0.3f, 0.0f, 50, as.getLocation(), SettingsMenu.particles);
                        ParticleEffect.PORTAL.display(0.3f, 0.3f, 0.3f, 0.0f, 50, as2.getLocation(), SettingsMenu.particles);
                        ParticleEffect.PORTAL.display(0.3f, 0.3f, 0.3f, 0.0f, 50, as3.getLocation(), SettingsMenu.particles);

                    } catch (Exception e) {
                        //NIC
                    }
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0L, 10L);

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
        as2.remove();
        as3.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }
}
