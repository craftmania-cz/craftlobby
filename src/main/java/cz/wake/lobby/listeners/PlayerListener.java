package cz.wake.lobby.listeners;

import cz.wake.lobby.GUI.*;
import cz.wake.lobby.Main;
import cz.wake.lobby.cloaks.Hero;
import cz.wake.lobby.particles.FrozenWalk;
import cz.wake.lobby.pets.PetManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PlayerListener implements Listener {

    private Main plugin;

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    Menu hlavniMenu = new Menu();
    GadgetsMenu gadgetsMenu = new GadgetsMenu();
    Servers servers = new Servers();
    VIPMenu vmenu = new VIPMenu();
    InvClick ic = new InvClick();
    FrozenWalk fw = new FrozenWalk();
    Lobby lb = new Lobby();
    Hero cape = new Hero();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) {

        //Deaktivace Join zprav
        e.setJoinMessage(null);

        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();


        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.updateInventory();

        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassMeta = compass.getItemMeta();

        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM, 1);
        playerHead.setDurability((short) 3);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();

        ItemStack gadgets = new ItemStack(Material.NETHER_STAR);
        ItemMeta gadgetsMeta = gadgets.getItemMeta();

        ItemStack hider = new ItemStack(Material.INK_SACK, 1, (byte) 10);
        ItemMeta hiderMeta = hider.getItemMeta();

        ItemStack shopVip = new ItemStack(Material.EMERALD);
        ItemMeta svMeta = shopVip.getItemMeta();

        ItemStack servers = new ItemStack(Material.WATCH);
        ItemMeta serMeta = servers.getItemMeta();
        serMeta.setDisplayName("§ePrehled lobby §7(Klikni pravym)");
        servers.setItemMeta(serMeta);

        compassMeta.setDisplayName("§bVyber serveru §7(Klikni pravym)");
        compass.setItemMeta(compassMeta);

        playerHeadMeta.setDisplayName("§aProfil §7(Klikni pravym)");
        playerHead.setItemMeta(playerHeadMeta);

        svMeta.setDisplayName("§aVIP Shop §7(Klikni pravym)");
        shopVip.setItemMeta(svMeta);

        gadgetsMeta.setDisplayName("§5Gadgets §7(Klikni pravym)");
        gadgets.setItemMeta(gadgetsMeta);

        hiderMeta.setDisplayName("§7Hraci: §a§lVIDITELNY");
        hider.setItemMeta(hiderMeta);

        for (PotionEffect ep : p.getActivePotionEffects()) {
            p.removePotionEffect(ep.getType());
        }

        p.getInventory().setItem(0, compass);
        p.getInventory().setItem(1, playerHead);
        p.getInventory().setItem(2, shopVip);
        p.getInventory().setItem(4, gadgets);
        p.getInventory().setItem(7, hider);
        p.getInventory().setItem(8, servers);

        p.setFlying(false);
        p.setWalkSpeed(0.3F);
        p.setHealth(20F);
        p.setSaturation(20F);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.ADVENTURE);
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
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == SpawnReason.EGG) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent e) {
        e.setCancelled(true);
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
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.SKULL_ITEM) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aProfil §7(Klikni pravym)"))) {
            this.hlavniMenu.openMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.EMERALD) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aVIP Shop §7(Klikni pravym)"))) {
            this.vmenu.openVIPMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.NETHER_STAR) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Gadgets §7(Klikni pravym)"))
                && (Main.getInstance().getTPS() >= 17)) {
            this.gadgetsMenu.openGadgetsMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bVyber serveru §7(Klikni pravym)"))) {
            this.servers.openServersMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.WATCH) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§ePrehled lobby §7(Klikni pravym)"))) {
            this.lb.openMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.INK_SACK && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §a§lVIDITELNY"))) {
                if (!this._time.containsKey(e.getPlayer())) {
                    this._time.put(e.getPlayer(), Double.valueOf(8D + 0.1D));
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 2.0F, 2.0F);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        e.getPlayer().hidePlayer(players);
                        ItemStack disable = new ItemStack(Material.INK_SACK, 1, (byte) 1);
                        ItemMeta im = disable.getItemMeta();
                        im.setDisplayName("§7Hraci: §c§lNEVIDITELNY");
                        disable.setItemMeta(im);
                        e.getPlayer().getInventory().setItem(7, disable);
                        e.getPlayer().updateInventory();
                    }
                    e.getPlayer().sendMessage(ChatColor.RED + "Vsechny aktualni hrace jsi zneviditelnil.");
                    this._cdRunnable.put(e.getPlayer(), new BukkitRunnable() {
                        @Override
                        public void run() {
                            PlayerListener.this._time.put(e.getPlayer(), Double.valueOf(((Double) PlayerListener.this._time.get(e.getPlayer())).doubleValue() - 0.1D));
                            if (((Double) PlayerListener.this._time.get(e.getPlayer())).doubleValue() < 0.01D) {
                                PlayerListener.this._time.remove(e.getPlayer());
                                PlayerListener.this._cdRunnable.remove(e.getPlayer());
                                cancel();
                            }
                        }
                    });
                    ((BukkitRunnable) this._cdRunnable.get(e.getPlayer())).runTaskTimer(plugin, 2L, 2L);
                } else {
                    MessagesListener.messageCooldown(e.getPlayer(), String.valueOf(arrondi(((Double) this._time.get(e.getPlayer())).doubleValue(), 1)));
                    return;
                }
            } else {
                if ((e.getPlayer().getItemInHand().getType() == Material.INK_SACK && (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §c§lNEVIDITELNY")))) {
                    if (!this._time.containsKey(e.getPlayer())) {
                        this._time.put(e.getPlayer(), Double.valueOf(8D + 0.1D));
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 2.0F, 2.0F);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            e.getPlayer().showPlayer(pl);
                            ItemStack enable = new ItemStack(Material.INK_SACK, 1, (byte) 10);
                            ItemMeta im = enable.getItemMeta();
                            im.setDisplayName("§7Hraci: §a§lVIDITELNY");
                            enable.setItemMeta(im);
                            e.getPlayer().getInventory().setItem(7, enable);
                            e.getPlayer().updateInventory();
                        }
                        e.getPlayer().sendMessage(ChatColor.GREEN + "Vsechny hrace jsi zviditelnil.");
                        this._cdRunnable.put(e.getPlayer(), new BukkitRunnable() {
                            @Override
                            public void run() {
                                PlayerListener.this._time.put(e.getPlayer(), Double.valueOf(((Double) PlayerListener.this._time.get(e.getPlayer())).doubleValue() - 0.1D));
                                if (((Double) PlayerListener.this._time.get(e.getPlayer())).doubleValue() < 0.01D) {
                                    PlayerListener.this._time.remove(e.getPlayer());
                                    PlayerListener.this._cdRunnable.remove(e.getPlayer());
                                    cancel();
                                }
                            }
                        });
                        ((BukkitRunnable) this._cdRunnable.get(e.getPlayer())).runTaskTimer(plugin, 2L, 2L);
                    } else {
                        MessagesListener.messageCooldown(e.getPlayer(), String.valueOf(arrondi(((Double) this._time.get(e.getPlayer())).doubleValue(), 1)));
                        return;
                    }
                }
            }
        }
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            Block b = e.getClickedBlock();
            if ((b.getType() == Material.BEACON)
                    || (b.getType() == Material.BREWING_STAND)
                    || (b.getType() == Material.ANVIL)
                    || (b.getType() == Material.ENDER_CHEST)
                    || (b.getType() == Material.TRAP_DOOR)
                    || (b.getType() == Material.CHEST)
                    || (b.getType() == Material.FENCE)
                    || (b.getType() == Material.FENCE_GATE)
                    || (b.getType() == Material.ACACIA_FENCE)
                    || (b.getType() == Material.ACACIA_FENCE_GATE)
                    || (b.getType() == Material.BIRCH_FENCE)
                    || (b.getType() == Material.BIRCH_FENCE_GATE)
                    || (b.getType() == Material.DARK_OAK_FENCE)
                    || (b.getType() == Material.DARK_OAK_FENCE_GATE)
                    || (b.getType() == Material.JUNGLE_FENCE)
                    || (b.getType() == Material.JUNGLE_FENCE_GATE)
                    || (b.getType() == Material.NETHER_FENCE)
                    || (b.getType() == Material.SPRUCE_FENCE_GATE)
                    || (b.getType() == Material.TRAPPED_CHEST)
                    || (b.getType() == Material.HOPPER)) {
                if (Main.getInstance().isDebug()) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onLeave(final PlayerQuitEvent e) {
        Player p = e.getPlayer();

        //Deaktivace leave zprav
        e.setQuitMessage(null);

        //Deaktivace particles
        ic.deactivateParticles(p);

        //Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        Hero.deactivateCape(p);

        //Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();

        //Deaktivace particles
        ic.deactivateParticles(p);

        //Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        Hero.deactivateCape(p);

        //Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    public static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

    @EventHandler
    public void onPortal(EntityPortalEnterEvent e) {
        Player p = (Player) e.getEntity();
        if (!Main.getInstance().inPortal(p)) {
            if (Main.getInstance().getConfig().getString("server").equalsIgnoreCase("main")) {
                Main.getInstance().addPortal(p);
                //Main.getInstance().getServerMenu().openServersMenu(p);
            } else {
                ic.sendToServer(p, "lobby");
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    Main.getInstance().removePortal(p);
                }
            }.runTaskLater(Main.getInstance(), 100L);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (p.getLocation().getY() <= 10) {
            p.performCommand("spawn");
        }
    }

}
