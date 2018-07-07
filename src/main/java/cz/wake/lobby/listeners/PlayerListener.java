package cz.wake.lobby.listeners;

import cz.wake.lobby.gui.GadgetsMenu;
import cz.wake.lobby.gui.Profil;
import cz.wake.lobby.gui.Servers;
import cz.wake.lobby.gui.VIPMenu;
import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.characters.Bonusy;
import cz.wake.lobby.armorstands.statistics.BedWars;
import cz.wake.lobby.armorstands.statistics.Parkour;
import cz.wake.lobby.armorstands.statistics.SkyWars;
import cz.wake.lobby.gadgets.cloaks.RankCape;
import cz.wake.lobby.gadgets.pets.PetManager;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.UtilTablist;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
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
    GadgetsMenu gadgetsMenu = new GadgetsMenu();
    Servers servers = new Servers();
    VIPMenu vmenu = new VIPMenu();
    InvClick ic = new InvClick();
    SettingsMenu sm = new SettingsMenu();
    Bonusy b = new Bonusy();

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e) {
        try {
            Player p = e.getPlayer();

            //Deaktivace Join zprav
            e.setJoinMessage(null);

            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.updateInventory();

            setupDefaultItems(p);

            for (PotionEffect ep : p.getActivePotionEffects()) {
                p.removePotionEffect(ep.getType());
            }

            p.setHealth(20F);
            p.setSaturation(20F);
            p.setFoodLevel(20);
            p.setGameMode(GameMode.SURVIVAL);

            // Player settings
            Main.getInstance().getSQL().addSettingsDefault(p);
            Main.getInstance().getSQL().addDefaultCraftMoney(p);

            //Odmeny
            Main.getInstance().getSQL().createRewardsRecord(p, "lobby_denniodmena");
            Main.getInstance().getSQL().createRewardsRecord(p, "lobby_vipodmena");

            // Prefix v tablistu
            UtilTablist.setupDefaultTablist(p);

            // Setting setttings :D
            setupPlayerOnJoin(p);

            // ArmorStand statistiky
            if (Main.getInstance().getIdServer().equalsIgnoreCase("slobby")) {
                Location loc = new Location(Bukkit.getWorld("osw"), -599.5, 102.3, 116.5);
                SkyWars.spawn(loc, p);
            } else if (Main.getInstance().getIdServer().equalsIgnoreCase("blobby")) {
                Location loc = new Location(Bukkit.getWorld("obw"), -599.75, 100.6, 116.5);
                BedWars.spawn(loc, p);
            } else if (Main.getInstance().getIdServer().equalsIgnoreCase("main")) {
                Location loc = new Location(Bukkit.getWorld("omain"), 1493.5, 23.6, -1275.5);
                Parkour.spawn(loc, p);
            }

            //AT
            if (Main.getInstance().getSQL().isAT(p)) {
                Main.getInstance().at_list.add(p);
                Main.getInstance().getSQL().updateAtLastActive(p, System.currentTimeMillis());
            }

            //Profiles
            Main.getInstance().getSQL().createPlayerProfile(p);

            if (Main.getInstance().getIdServer().equalsIgnoreCase("main")) {

                // Info o odmene
                b.onPlayerSpawn(p);

                //Update MC verze
                Main.getInstance().getSQL().updatePlayerVersion(p);
                Main.getInstance().getSQL().updateForceNick(p);

                // Vanocni kalendar
                //TODO: Pouze pri vanocich
                //Main.getInstance().getSQL().addCalendarDefaultValue(p);

                p.sendMessage("");
                p.sendMessage("§c§lUPOZORNENI: §fServer se stale dodelava, a nektere funkce jsou vypnute!");
                p.sendMessage("§bDekujeme za pochopeni :)");
                p.sendMessage("");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    public void onBlockForm(EntityBlockFormEvent e){
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
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.SKULL_ITEM) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aProfil §7(Klikni pravym)"))) {
            this.hlavniProfil.openMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.EMERALD) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aVIP Shop §7(Klikni pravym)"))) {
            this.vmenu.openVIPMenu(p);
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.NETHER_STAR) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Gadgets §7(Klikni pravym)"))
                && !ParkourListener.in_parkour.contains(p)) {
            //this.gadgetsMenu.openGadgetsMenu(p);
            p.sendMessage("§c§l(!) §cGadgets jsou docasne deaktivovany!");
        }
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bVyber serveru §7(Klikni pravym)"))) {
            this.servers.openServersMenu(p);
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

        // Deaktivace particles
        ic.deactivateParticles(p);

        // Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        RankCape.deactivateCape(p);

        // Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);

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

        // Deaktivace particles
        ic.deactivateParticles(p);

        // Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        RankCape.deactivateCape(p);

        // Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);

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

    //TODO: Dodelat portal
    @EventHandler
    public void onPortal(EntityPortalEnterEvent e) {
        Entity ent = e.getEntity();
        if (ent instanceof Player) {
            Player p = ((Player) ent).getPlayer();
            if (!Main.getInstance().inPortal(p)) {
                if (Main.getInstance().getConfig().getString("server").equalsIgnoreCase("main")) {
                    Main.getInstance().addPortal(p);
                    //Main.getInstance().getServersMenu().openServersMenu(p);
                } else {
                    ic.sendToServer(p, "lobby4"); // @general-lobbies - hlavni lobby
                }
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Main.getInstance().removePortal(p);
                    }
                }.runTaskLater(Main.getInstance(), 100L);
            }
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        // Teleport na spawn
        if (p.getLocation().getY() <= 0) {
            p.performCommand("spawn");
        }
    }

    private static void setupDefaultItems(final Player p) {

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

        ItemStack web = ItemFactory.createHead("§aWeb", "c424243d-0421-4774-8aeb-2ddea957ed57", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5MzZkNGYwZDFiOTNmZWY3NzViMWZiZDE5MjgxYjcwYzZmODg0NzViYjVhNDFiZjM3MmMxMmYxZjhhMjIifX19");
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

        ItemStack twitter = ItemFactory.createHead("§bTwitter", "11fce6c7-71ad-464e-98e7-c8e579de4758", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY4NWEwYmU3NDNlOTA2N2RlOTVjZDhjNmQxYmEyMWFiMjFkMzczNzFiM2Q1OTcyMTFiYjc1ZTQzMjc5In19fQ==");
        ItemMeta twitterMeta = twitter.getItemMeta();
        ArrayList<String> twitterLore = new ArrayList<>();
        twitterLore.add("§7Odkaz na nas Twitter ucet:");
        twitterLore.add("§fhttps://twitter.com/craftmania_cz");
        twitterLore.add("");
        twitterLore.add("§eKliknutim zobrazis odkaz v chatu");
        twitterMeta.setLore(twitterLore);
        twitter.setItemMeta(twitterMeta);

        p.getInventory().setItem(0, compass);
        p.getInventory().setItem(1, playerHead);
        p.getInventory().setItem(2, shopVip);
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
