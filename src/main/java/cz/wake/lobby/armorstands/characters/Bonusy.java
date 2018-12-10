package cz.wake.lobby.armorstands.characters;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.ASInterface;
import cz.wake.lobby.utils.ItemFactory;
import net.minecraft.server.v1_11_R1.EntityArmorStand;
import net.minecraft.server.v1_11_R1.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_11_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_11_R1.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Bonusy implements ASInterface {

    private Location loc1 = new Location(Bukkit.getWorld("omain"), 1540.5, 18, -1222.5, 180, 0);
    private ArmorStand as, as2, as3, as4;
    public static Random random = new Random();
    public static EntityArmorStand stand;

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
        as.setLeftArmPose(new EulerAngle(5.8, 0, 5.9));

        ItemStack head = ItemFactory.createHead("test", "22a6d531-e947-4e01-ace0-019593c9c7d3", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjk1NjUyZGRlMDRmNzQ1Zjk1NGI2OTgxMGUwMjBlYTZiOTNlYjJkMzM0YjlkYjczODBiYmZmNTJjMmIwZjQifX19");
        as.setHelmet(head);

        ItemStack chestplate = ItemFactory.createColouredLeather(Material.LEATHER_CHESTPLATE, 255, 255, 0);
        as.setChestplate(chestplate);

        ItemStack leggins = ItemFactory.createColouredLeather(Material.LEATHER_LEGGINGS, 255, 255, 0);
        as.setLeggings(leggins);

        ItemStack boots = ItemFactory.createColouredLeather(Material.LEATHER_BOOTS, 255, 255, 0);
        as.setBoots(boots);

        ItemStack item = new ItemStack(Material.GOLD_INGOT);

        new BukkitRunnable() {
            int c = 1;

            @Override
            public void run() {
                if (c == 1) {
                    as.getEquipment().setItemInOffHand(null);
                    as.setItemInHand(item);
                    //updateRewardArmorstand();
                    c++;
                } else if (c == 2) {
                    as.setItemInHand(null);
                    as.getEquipment().setItemInOffHand(item);
                    c--;
                }
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 25L);

        subtextSpawn();
        hologramSpawn();

        Main.getInstance().getASM().setMetadata((ArmorStand) as, "Bonusy", "Bonusy", Main.getInstance());
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

        as2.setCustomName("§e§lBonusy");

    }

    @Override
    public void subtextSpawn() {

        //loc1.add(0, 0.3, 0);
        loc1.add(0, 0.3, 0);

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void remove() {
        as.remove();
        as2.remove();
        as4.remove();
    }

    @Override
    public void updateArmorStand(String s, int i) {

    }

    public ArmorStand getAs() {
        return as;
    }

    public void playEffect(Player p) {
        final ArrayList localArrayList = new ArrayList();
        new BukkitRunnable() {
            int step = 0;

            @Override
            public void run() {
                this.step += 1;
                Item localItem;
                if (this.step <= 30) {
                    p.getWorld().playSound(loc1, Sound.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                    int number = randRange(0, 6);
                    switch (number) {
                        case 0:
                            localItem = p.getWorld().dropItem(loc1, ItemFactory.create(Material.GOLD_NUGGET, (byte) 0, "nopickup"));
                            localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                            localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                            localArrayList.add(localItem);
                        case 1:
                            localItem = p.getWorld().dropItem(loc1, ItemFactory.create(Material.GOLD_INGOT, (byte) 0, "nopickup"));
                            localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                            localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                            localArrayList.add(localItem);
                        default:
                            localItem = p.getWorld().dropItem(loc1, ItemFactory.create(Material.GOLD_NUGGET, (byte) 0, "nopickup"));
                            localItem.setMetadata("gadget", new FixedMetadataValue(Main.getPlugin(), Boolean.TRUE));
                            localItem.setVelocity(new Vector((random.nextDouble() - 0.5D) / 3.0D, 0.7D, (random.nextDouble() - 0.5D) / 3.0D));
                            localArrayList.add(localItem);
                    }
                } else {
                    for (Iterator localIterator = localArrayList.iterator(); localIterator.hasNext(); ) {
                        localItem = (Item) localIterator.next();
                        localItem.remove();
                    }
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 4L);
        //updateRewardArmorstand();
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

    public String getRewards(Player p) {
        int rewards = 0;
        if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_denniodmena") == 0) {
            rewards++;
        }
        if (p.hasPermission("craftlobby.vip.odmena")) {
            if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_vipodmena") == 0) {
                rewards++;
            }
        }

        if (rewards == 0) {
            return "§7Vsechny odmeny vybrany!";
        } else if (rewards == 1) {
            return "§7Mas nevyzvednutou §bodmenu!";
        } else if (rewards == 2) {
            return "§7Mas nevyzvednute §c2 odmeny!";
        }

        return "§4Chyba! Wejku oprav to :D";

    }

    public void onPlayerSpawn(Player p) {

        Location loc1 = new Location(Bukkit.getWorld("omain"), 1540.5, 18.3, -1222.5, 180, 0);

        WorldServer s = ((CraftWorld) loc1.getWorld()).getHandle();

        stand = new EntityArmorStand(s);
        stand.setLocation(loc1.getX(), loc1.getY(), loc1.getZ(), 0, 0);
        stand.setCustomName(getRewards(p));
        stand.setCustomNameVisible(true);
        stand.setInvisible(true);

        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(stand);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public void updateRewardArmorstand() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            PacketPlayOutEntityDestroy pa = new PacketPlayOutEntityDestroy(stand.getId());
            ((CraftPlayer)players).getHandle().playerConnection.sendPacket(pa); //destroying armorstand

            onPlayerSpawn(players);
        }
    }
}
