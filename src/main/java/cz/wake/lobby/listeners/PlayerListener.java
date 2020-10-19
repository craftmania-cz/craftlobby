package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerListener implements Listener {

    private Main plugin;
    static final Logger log = LoggerFactory.getLogger(PlayerListener.class);

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().isDebug() && p.hasPermission("craftlobby.admin")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().isDebug() && p.hasPermission("craftlobby.admin")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void silverfishFix(EntityChangeBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (!(e.getSpawnReason() == SpawnReason.CUSTOM) || !(e.getEntityType() == EntityType.ARMOR_STAND)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        if (e.getEntityType() == EntityType.VEX) {
            e.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onBlockForm(EntityBlockFormEvent e) {
        if (e.getEntity().getType() == EntityType.SNOWMAN) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemMove(InventoryClickEvent e) {
        Player p = (Player) e.getInventory().getHolder();
        if (Main.getInstance().isDebug() && p.hasPermission("craftlobby.admin")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        Item item = e.getItem();
        if (((item.getItemStack().getItemMeta().getDisplayName().contains("nopickup"))) && item != null) {
            e.setCancelled(true);
            e.getItem().remove();
        }
        if (((item.getItemStack().getItemMeta().getDisplayName().contains("EGG"))) && item != null) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onChange(BlockFadeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onLeaf(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        // Teleport na spawn
        if (p.getLocation().getY() <= 0) {
            if (Main.getInstance().getIdServer().equalsIgnoreCase("bedwars")) {
                p.teleport(new Location(Bukkit.getWorld("obw2"), -602.5, 111.5, 129.5, -180, 0));
            }
        }

        if (Main.rulesAcceptionPending.contains(p.getUniqueId())) {
            e.setCancelled(true);
        }
    }
}
