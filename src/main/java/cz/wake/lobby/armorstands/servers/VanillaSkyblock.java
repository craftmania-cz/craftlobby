package cz.wake.lobby.armorstands.servers;

import cz.wake.craftcore.utils.effects.ParticleEffect;
import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.util.logging.Level;

public class VanillaSkyblock implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1551.5, 18, -1211.5, 165, 0);
    private ArmorStand as, as2, as3;
    private boolean maintenance;

    @Override
    public void spawn() {

        as = (ArmorStand) Bukkit.getWorld("omain").spawnEntity(loc1, EntityType.ARMOR_STAND);

        as.setGravity(false);
        as.setVisible(true);
        as.setCanPickupItems(false);
        as.setBasePlate(false);
        as.setArms(true);

        // x - nahoru/dolu, y - rotace, z - otáčení v ose

        as.setRightArmPose(new EulerAngle(5.8, 5.5, 0.2));

        defaultItems();

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "vanilla-skyblock", "vanilla-skyblock", Main.getInstance());

        subtextSpawn();
        hologramSpawn();

        Bukkit.getLogger().log(Level.INFO, ChatColor.BLUE + "[CraftStands] " + ChatColor.YELLOW + " Vanilla-Skyblock ArmorStand uspesne spawnut!");
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

        as2.setCustomName("§6§lVanilla Skyblock");

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
        return true;
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
        if (Main.getInstance().fetchData().getMaintenance(s) == 1) {
            if (!maintenance) {
                Bukkit.getLogger().log(Level.INFO, "§b[CraftStands] §6Vanilla-Skyblock §caktivovan do rezimu udrzby!");
                maintenance = true;

                udrzbaItems();

                Location loc = new Location(Bukkit.getWorld("omain"), 1551, 17, -1212);

                Block block = loc.getBlock();
                block.setType(Material.STAINED_GLASS);
                block.setData((byte) 14);

                new BukkitRunnable() {
                    int c = 1;

                    @Override
                    public void run() {
                        if (maintenance) {
                            if (c == 1) {
                                ItemStack head = ItemFactory.createHead("test", "99054195-a890-4e86-a8ad-0e11df01bf5b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWZiNGFlY2E5NWRiMTQ3YmUyOTQ1Y2M3ZmI0Y2ExYTM5MDYxZDNlYmU5MWMxZWEzOGQzZDYzZDllYTI3NDMifX19");
                                as.setHelmet(head);
                                ParticleEffect.SMOKE_NORMAL.display(0.8f, 2f, 0.8f, 0f, 15, loc, SettingsMenu.particles);
                                c++;
                            } else if (c == 2) {
                                ItemStack head = ItemFactory.createHead("test", "143de788-96b3-46ad-916a-bc9a95d46e42", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQ3MGQwNGViYTJlZWE0OGY2Y2Y0NjRjODM1ODVlMjMxYjI5N2Q2MWU1MzBiNWZhYjA3ZGNhZGY0MDlhYjk5MSJ9fX0=");
                                as.setHelmet(head);
                                ParticleEffect.SMOKE_NORMAL.display(0.8f, 2f, 0.8f, 0f, 15, loc, SettingsMenu.particles);
                                c = 1;
                            }
                        } else {
                            cancel();
                        }

                    }
                }.runTaskTimer(Main.getInstance(), 0, 35L);
            }
        } else if (Main.getInstance().fetchData().getMaintenance(s) == 0) {
            if (maintenance) {
                //Restart na default
                Bukkit.getLogger().log(Level.INFO, "§b[CraftStands] §6Factions §adeaktivovan z rezimu udrzby!");
                maintenance = false;
                as.getEquipment().clear();

                defaultItems();

                Location loc = new Location(Bukkit.getWorld("omain"), 1551, 17, -1212);

                Block block = loc.getBlock();
                block.setType(Material.STAINED_GLASS);
                block.setData((byte) 12);

                as2.setCustomName("§6§lVanilla Skyblock");
                as3.setCustomName(Main.getInstance().getASM().formatPlayers(i));

            } else {
                as3.setCustomName(Main.getInstance().getASM().formatPlayers(i));
            }
        }
    }

    private void defaultItems() {
        ItemStack head = ItemFactory.createHead("test", "aa46fbd8-5d1c-4d90-bd99-57e64d4b892c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGJmODVhY2U5Yzk5ZjY2M2M3OTFkMGUxNGU3N2FlNjk1YTNkZDU5ZGY4N2NlNjdhOGIyZWVjOThmOGNkM2YifX19");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 255, 193, 37);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 255, 193, 37);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 255, 193, 37);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.PUMPKIN_SEEDS);
        as.setItemInHand(item);
    }

    private void udrzbaItems() {
        as.getEquipment().clear();

        as2.setCustomName("§7Udrzba");
        as3.setCustomName("§c§lVanilla Skyblock");

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 0, 0, 0);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 0, 0, 0);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 0, 0, 0);
        as.setBoots(boots);
    }
}
