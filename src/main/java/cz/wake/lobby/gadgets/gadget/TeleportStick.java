package cz.wake.lobby.gadgets.gadget;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Set;

public class TeleportStick implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    private HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    private Main plugin;

    public TeleportStick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ExplosionGun(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        ItemStack item = e.getItem();
        Action action = e.getAction();
        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.STICK)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().contains("TeleportStick")) {
            return;
        }
        if (!player.hasPermission("craftlobby.gadgets.teleportstick")) {
            return;
        }
        if (SettingsMenu.activeGadgets.contains(player)){
            player.sendMessage("§cLze mit aktivni pouze jeden gadget!");
            return;
        }
        e.setCancelled(true);
        player.updateInventory();
        if ((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (Main.getInstance().getTPS() < 17) {
                player.sendMessage("§cServer je pretizeny, nelze pouzivat gadget!");
                return;
            }
            if (this._time.containsKey(player)) {
                MessagesListener.messageCooldown(player, String.valueOf(arrondi(((Double) this._time.get(player)).doubleValue(), 1)));
                return;
            }
            Location localLocation = player.getTargetBlock((Set<Material>) null, 30).getLocation();
            if (localLocation.getBlock().isEmpty()) {
                player.sendMessage("§7Musis si vybrat blok na zemi!");
                return;
            }
            if ((!getLocation(localLocation, 0.0D, 1.0D, 0.0D).getBlock().isEmpty()) || (!getLocation(localLocation, 0.0D, 2.0D, 0.0D).getBlock().isEmpty())) {
                player.sendMessage("§cNelze se teleportovat!");
                return;
            }
            this._time.put(player, Double.valueOf(5D + 0.1D));
            localLocation.setDirection(player.getLocation().getDirection());
            localLocation.add(0.0D, 1.0D, 0.0D);
            player.teleport(localLocation);
            ParticleEffect.SMOKE_LARGE.display(0.0F, 0.0F, 1.0F, 1.0F, 15, localLocation, 15.0D);
            ParticleEffect.ENCHANTMENT_TABLE.display(0.0F, 0.0F, 1.0F, 1.0F, 15, localLocation, 15.0D);
            localLocation.getWorld().playSound(localLocation, Sound.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            this._cdRunnable.put(player, new BukkitRunnable() {
                @Override
                public void run() {
                    TeleportStick.this._time.put(player, Double.valueOf(((Double) TeleportStick.this._time.get(player)).doubleValue() - 0.1D));
                    if (((Double) TeleportStick.this._time.get(player)).doubleValue() < 0.01D) {
                        TeleportStick.this._time.remove(player);
                        TeleportStick.this._cdRunnable.remove(player);
                        cancel();
                    }

                }
            });
            ((BukkitRunnable) this._cdRunnable.get(player)).runTaskTimer(plugin, 2L, 2L);
        }
    }

    public static Location getLocation(Location paramLocation, double paramDouble1, double paramDouble2, double paramDouble3) {
        return new Location(paramLocation.getWorld(), paramLocation.getX() + paramDouble1, paramLocation.getY() + paramDouble2, paramLocation.getZ() + paramDouble3);
    }

    private static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

}
