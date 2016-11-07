package cz.wake.lobby.gadgets;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Trampoline implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();
    private HashMap<String, ArrayList<Location>> locs = new HashMap();
    private boolean enabled = false;

    private Main plugin;

    public Trampoline(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTrampoline(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.HOPPER)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("Trampoline")) {
            return;
        }
        if (enabled) {
            player.sendMessage("§cTento gadget je jiz nekde aktivovany!");
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.trampoline")) {
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            if (canBuild(player)) {
                this.enabled = true;
                this._time.put(player, Double.valueOf(60D + 0.1D));
                buildTrampoline(player);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Trampoline.this.removeTrampoline(player.getName());
                    }
                }, 400L);
                this._cdRunnable.put(player, new BukkitRunnable() {
                    @Override
                    public void run() {
                        Trampoline.this._time.put(player, Double.valueOf(((Double) Trampoline.this._time.get(player)).doubleValue() - 0.1D));
                        if (((Double) Trampoline.this._time.get(player)).doubleValue() < 0.01D) {
                            Trampoline.this._time.remove(player);
                            Trampoline.this._cdRunnable.remove(player);
                            cancel();
                        }
                    }
                });
                ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
            } else {
                player.sendMessage(ChatColor.RED + "Nedostatek mista k vytvoreni trampoliny!");
            }

        }

    }

    public static boolean canBuild(Player p) {
        ArrayList<Location> s0 = createSquare(p.getLocation().getBlock(), 0);
        ArrayList<Location> s1 = createSquare(p.getLocation().getBlock(), 1);
        ArrayList<Location> s2 = createSquare(p.getLocation().getBlock(), 2);
        ArrayList<Location> s3 = createSquare(p.getLocation().getBlock(), 3);
        ArrayList<Location> s4 = createSquare(p.getLocation().getBlock(), 4);

        ArrayList<Location> y0 = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 0);
        ArrayList<Location> y1 = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 1);
        ArrayList<Location> y2 = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 2);
        ArrayList<Location> y3 = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 3);
        ArrayList<Location> y4 = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 4);
        for (Location l0 : s0) {
            if (!l0.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location l1 : s1) {
            if (!l1.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location l2 : s2) {
            if (!l2.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location l3 : s3) {
            if (!l3.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location l4 : s4) {
            if (!l4.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location Y0 : y0) {
            if (!Y0.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location Y1 : y1) {
            if (!Y1.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location Y2 : y2) {
            if (!Y2.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location Y3 : y3) {
            if (!Y3.getBlock().isEmpty()) {
                return false;
            }
        }
        for (Location Y4 : y4) {
            if (!Y4.getBlock().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @EventHandler
    public void onTrampoline(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((p.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType() == Material.WOOL) && (p.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getData() == 11) && (p.getLocation().add(0.0D, -1.0D, 0.0D).getBlock().hasMetadata("Trampoline"))) {
            p.setVelocity(new Vector(p.getVelocity().getX(), 2.0D, p.getVelocity().getZ()));
        }
    }

    private void buildTrampoline(Player p) {
        ArrayList<Location> locb = new ArrayList();

        Location loc1 = p.getLocation().add(2.0D, 0.0D, 2.0D);
        locb.add(loc1);
        Location loc2 = p.getLocation().add(-2.0D, 0.0D, 2.0D);
        locb.add(loc2);
        Location loc3 = p.getLocation().add(-2.0D, 0.0D, -2.0D);
        locb.add(loc3);
        Location loc4 = p.getLocation().add(2.0D, 0.0D, -2.0D);
        locb.add(loc4);

        ArrayList<Location> black = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 2);

        ArrayList<Location> blue = createSquare(p.getLocation().add(0.0D, 1.0D, 0.0D).getBlock(), 1);
        Location loc5 = p.getLocation().add(0.0D, 1.0D, 0.0D);
        locb.add(loc5);

        Location loc6 = p.getLocation().add(-3.0D, 1.0D, 0.0D);
        locb.add(loc6);
        Location loc7 = p.getLocation().add(-4.0D, 0.0D, 0.0D);
        locb.add(loc7);

        loc1.getBlock().setTypeIdAndData(Material.FENCE.getId(), (byte) 0, true);
        loc2.getBlock().setTypeIdAndData(Material.FENCE.getId(), (byte) 0, true);
        loc3.getBlock().setTypeIdAndData(Material.FENCE.getId(), (byte) 0, true);
        loc4.getBlock().setTypeIdAndData(Material.FENCE.getId(), (byte) 0, true);
        Location loc;
        for (Iterator localIterator = black.iterator(); localIterator.hasNext(); loc.getBlock().setMetadata("Trampoline", new FixedMetadataValue(plugin, "Trampoline"))) {
            loc = (Location) localIterator.next();
            loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), (byte) 15, true);
            locb.add(loc);
        }
        for (Iterator localIterator = blue.iterator(); localIterator.hasNext(); loc.getBlock().setMetadata("Trampoline", new FixedMetadataValue(plugin, "Trampoline"))) {
            loc = (Location) localIterator.next();
            loc.getBlock().setTypeIdAndData(Material.WOOL.getId(), (byte) 11, true);
            locb.add(loc);
        }
        loc5.getBlock().setTypeIdAndData(Material.WOOL.getId(), (byte) 11, true);
        loc5.getBlock().setMetadata("Trampoline", new FixedMetadataValue(plugin, "Trampoline"));

        loc6.getBlock().setTypeIdAndData(Material.WOOD_STAIRS.getId(), (byte) 0, true);
        loc7.getBlock().setTypeIdAndData(Material.WOOD_STAIRS.getId(), (byte) 0, true);

        this.locs.put(p.getName(), locb);

        p.teleport(p.getLocation().add(0.0D, 2.0D, 0.0D));
        p.setVelocity(new Vector(p.getVelocity().getX(), 2.0D, p.getVelocity().getZ()));
    }

    private void removeTrampoline(String pn) {
        ArrayList<Location> locsr = (ArrayList) this.locs.get(pn);
        for (Location loc : locsr) {
            loc.getBlock().setType(Material.AIR);
            loc.getBlock().removeMetadata("Trampoline", Main.getPlugin());
            this.enabled = false;
        }
    }

    private static ArrayList<Location> createSquare(Block center, int radius) {
        ArrayList<Location> locs = new ArrayList();
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if ((x == -radius) || (x == radius) || (z == -radius) || (z == radius)) {
                    Block block = center.getWorld().getBlockAt(center.getX() + x, center.getY(), center.getZ() + z);
                    locs.add(block.getLocation());
                }
            }
        }
        return locs;
    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
