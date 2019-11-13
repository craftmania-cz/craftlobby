package cz.wake.lobby.listeners;

import cz.wake.lobby.gui.Profil;
import cz.wake.lobby.gui.Servers;
import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.UtilTablist;
import org.bukkit.*;
import org.bukkit.block.Block;
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
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerListener implements Listener {

    private Main plugin;
    static final Logger log = LoggerFactory.getLogger(PlayerListener.class);

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, Double> _time = new HashMap<>();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap<>();

    Profil hlavniProfil = new Profil();
    Servers servers = new Servers();
    InvClick ic = new InvClick();
    SettingsMenu sm = new SettingsMenu();

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
        if (!(e.getSpawnReason() == SpawnReason.CUSTOM)) {
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
    public void onInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PLAYER_HEAD) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aProfil §7(Klikni pravym)"))) {
            this.hlavniProfil.openMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bVyber serveru §7(Klikni pravym)"))) {
            this.servers.openServersMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
            if (!e.getHand().equals(EquipmentSlot.HAND)) return;
            if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.INK_SAC && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §a§lVIDITELNY"))) {
                if (!this._time.containsKey(e.getPlayer())) {
                    this._time.put(e.getPlayer(), Double.valueOf(8D + 0.1D));
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BREAK, 2.0F, 2.0F);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        e.getPlayer().hidePlayer(players);
                        ItemStack disable = new ItemStack(Material.INK_SAC);
                        ItemMeta im = disable.getItemMeta();
                        im.setDisplayName("§7Hraci: §c§lNEVIDITELNY");
                        disable.setItemMeta(im);
                        e.getPlayer().getInventory().setItem(8, disable);
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
                if ((e.getPlayer().getItemInHand().getType() == Material.INK_SAC && (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §c§lNEVIDITELNY")))) {
                    if (!e.getHand().equals(EquipmentSlot.HAND)) return;
                    if (!this._time.containsKey(e.getPlayer())) {
                        this._time.put(e.getPlayer(), Double.valueOf(8D + 0.1D));
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BREAK, 2.0F, 2.0F);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            e.getPlayer().showPlayer(pl);
                            ItemStack enable = new ItemStack(Material.INK_SAC, 1, (byte) 10);
                            ItemMeta im = enable.getItemMeta();
                            im.setDisplayName("§7Hraci: §a§lVIDITELNY");
                            enable.setItemMeta(im);
                            e.getPlayer().getInventory().setItem(8, enable);
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
                    //|| (b.getType() == Material.TRAP_DOOR)
                    || (b.getType() == Material.CHEST)
                    //|| (b.getType() == Material.FENCE)
                    //|| (b.getType() == Material.FENCE_GATE)
                    || (b.getType() == Material.ACACIA_FENCE)
                    || (b.getType() == Material.ACACIA_FENCE_GATE)
                    || (b.getType() == Material.BIRCH_FENCE)
                    || (b.getType() == Material.BIRCH_FENCE_GATE)
                    || (b.getType() == Material.DARK_OAK_FENCE)
                    || (b.getType() == Material.DARK_OAK_FENCE_GATE)
                    || (b.getType() == Material.JUNGLE_FENCE)
                    || (b.getType() == Material.JUNGLE_FENCE_GATE)
                    //|| (b.getType() == Material.NETHER_FENCE)
                    || (b.getType() == Material.SPRUCE_FENCE_GATE)
                    || (b.getType() == Material.TRAPPED_CHEST)
                    || (b.getType() == Material.HOPPER)
                    || (b.getType() == Material.FLOWER_POT)) {
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

        // Deaktivace leave zprav
        e.setQuitMessage(null);

        // Odebrani settings
        sm.removePlayer(p);

        //AT
        if (Main.getInstance().at_list.contains(p)) {
            Main.getInstance().at_list.remove(p);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();

        // Odebrani settings
        sm.removePlayer(p);

        //AT
        if (Main.getInstance().at_list.contains(p)) {
            Main.getInstance().at_list.remove(p);
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

    public static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
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
    }

    private static void setupDefaultItems(final Player p) {

        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassMeta = compass.getItemMeta();

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        playerHead.setDurability((short) 3);
        SkullMeta playerHeadMeta = (SkullMeta) playerHead.getItemMeta();

        ItemStack gadgets = new ItemStack(Material.NETHER_STAR);
        ItemMeta gadgetsMeta = gadgets.getItemMeta();

        ItemStack hider = new ItemStack(Material.INK_SAC, 1, (byte) 10);
        ItemMeta hiderMeta = hider.getItemMeta();

        compassMeta.setDisplayName("§bVyber serveru §7(Klikni pravym)");
        compass.setItemMeta(compassMeta);

        playerHeadMeta.setDisplayName("§aProfil §7(Klikni pravym)");
        playerHead.setItemMeta(playerHeadMeta);

        gadgetsMeta.setDisplayName("§5Gadgets §7(Klikni pravym)");
        gadgets.setItemMeta(gadgetsMeta);

        hiderMeta.setDisplayName("§7Hraci: §a§lVIDITELNY");
        hider.setItemMeta(hiderMeta);

        ItemStack web = cz.wake.lobby.utils.ItemFactory.createHead("§aWeb", "c424243d-0421-4774-8aeb-2ddea957ed57", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5MzZkNGYwZDFiOTNmZWY3NzViMWZiZDE5MjgxYjcwYzZmODg0NzViYjVhNDFiZjM3MmMxMmYxZjhhMjIifX19");
        ItemMeta webMeta = web.getItemMeta();
        ArrayList<String> webLore = new ArrayList<>();
        webLore.add("§7Odkaz na nas web:");
        webLore.add("§fhttps://craftmania.cz");
        webLore.add("");
        webLore.add("§eKliknutim zobrazis odkaz v chatu");
        webMeta.setLore(webLore);
        web.setItemMeta(webMeta);

        ItemStack discord = ItemFactory.createHead("§9Discord", "de431cd1-ae1d-49f6-9339-a96daeacc32b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19");
        ItemMeta discordMeta = discord.getItemMeta();
        ArrayList<String> discordLore = new ArrayList<>();
        discordLore.add("§7Odkaz na nas Discord server:");
        discordLore.add("§fhttps://discord.gg/craftmania");
        discordLore.add("");
        discordLore.add("§eKliknutim zobrazis odkaz v chatu");
        discordMeta.setLore(discordLore);
        discord.setItemMeta(discordMeta);

        ItemStack facebook = ItemFactory.createHead("§bFacebook", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=");
        ItemMeta facebookMeta = facebook.getItemMeta();
        ArrayList<String> facebookLore = new ArrayList<>();
        facebookLore.add("§7Odkaz na nasi Facebook Page:");
        facebookLore.add("§fhttps://www.fb.com/craftmaniacz/");
        facebookLore.add("");
        facebookLore.add("§eKliknutim zobrazis odkaz v chatu");
        facebookMeta.setLore(facebookLore);
        facebook.setItemMeta(facebookMeta);

        ItemStack twitter = ItemFactory.createHead("§dInstagram", "5e469ecf-80a4-40ae-8d9d-7c12bd2d3a3f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjViM2YyY2ZhMDczOWM0ZTgyODMxNmYzOWY5MGIwNWJjMWY0ZWQyN2IxZTM1ODg4NTExZjU1OGQ0Njc1In19fQ==");
        ItemMeta twitterMeta = twitter.getItemMeta();
        ArrayList<String> twitterLore = new ArrayList<>();
        twitterLore.add("§7Odkaz na nas Instagram ucet:");
        twitterLore.add("§fhttps://www.instagram.com/craftmania.cz/");
        twitterLore.add("");
        twitterLore.add("§eKliknutim zobrazis odkaz v chatu");
        twitterMeta.setLore(twitterLore);
        twitter.setItemMeta(twitterMeta);

        p.getInventory().setItem(0, compass);
        p.getInventory().setItem(1, playerHead);
        p.getInventory().setItem(4, gadgets);
        p.getInventory().setItem(8, hider);

        p.getInventory().setItem(19, web);
        p.getInventory().setItem(21, discord);
        p.getInventory().setItem(23, facebook);
        p.getInventory().setItem(25, twitter);
    }

    private void setupPlayerOnJoin(final Player p) {

        // Fly na lobby
        if (p.hasPermission("craftlobby.vip.fly")) {
            if (Main.getInstance().getSQL().getSettings(p, "lobby_fly") == 1) {
                p.setAllowFlight(true);
                p.setFlying(true);
            } else {
                p.setAllowFlight(false);
                p.setFlying(false);
            }
        } else {
            p.setAllowFlight(false);
            p.setFlying(false);
        }

        // Nastaveni skryti hracu
        if (Main.getInstance().getSQL().getSettings(p, "lobby_players") == 1) {
            SettingsMenu.hiden.add(p);
            for (Player p2 : Bukkit.getOnlinePlayers()) {
                p.hidePlayer(p2);
            }
        }

        // Skryti pokud nekdo ma nastaveny skryti
        for (Player p3 : Bukkit.getOnlinePlayers()) {
            if (SettingsMenu.hiden.contains(p3)) {
                p3.hidePlayer(p);
            }
        }

        // Zobrazovani particles
        if (Main.getInstance().getSQL().getSettings(p, "lobby_particles") == 1) {
            SettingsMenu.particles.add(p);
        }

        // Lobby speed
        if (Main.getInstance().getSQL().getSettings(p, "lobby_speed") == 1) {
            p.setWalkSpeed(0.3F);
        } else {
            p.setWalkSpeed(0.2F);
        }

        // Gadgets
        if (Main.getInstance().getSQL().getSettings(p, "lobby_gadgets") == 1) {
            SettingsMenu.gadgets.add(p);
        }
    }
}
