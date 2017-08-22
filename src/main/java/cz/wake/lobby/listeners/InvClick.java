package cz.wake.lobby.listeners;

import cz.wake.lobby.GUI.*;
import cz.wake.lobby.Main;
import cz.wake.lobby.gadgets.banners.BannerAPI;
import cz.wake.lobby.gadgets.cloaks.RankCape;
import cz.wake.lobby.gadgets.heads.HeadsAPI;
import cz.wake.lobby.gadgets.morphs.MorphAPI;
import cz.wake.lobby.gadgets.particles.*;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class InvClick implements Listener {

    private StatisticsMG statistics = new StatisticsMG();
    private Profil profil = new Profil();
    private GadgetsMenu gadgetsMenu = new GadgetsMenu();
    private ParticlesMenu pMenu = new ParticlesMenu();
    private VIPMenu vMenu = new VIPMenu();
    private GreenSparks gs = new GreenSparks();
    private FrostLord fl = new FrostLord();
    private FlameRings fr = new FlameRings();
    private SnowCloud ss = new SnowCloud();
    private RainCloud rc = new RainCloud();
    private BloodHelix bh = new BloodHelix();
    private Portal p = new Portal();
    private EnderSignal es = new EnderSignal();
    private Enchanted e = new Enchanted();
    private Love l = new Love();
    private Notes n = new Notes();
    private Clouds c = new Clouds();
    private ColoredDust cd = new ColoredDust();
    private LavaPop lp = new LavaPop();
    private MobSpell sp = new MobSpell();
    private FrozenWalk fw = new FrozenWalk();
    private Lily lil = new Lily();
    private SantaHat sh = new SantaHat();
    private CandyCane cc = new CandyCane();
    private BannerAPI bannerAPI = new BannerAPI();
    private HeadsAPI hAPI = new HeadsAPI();
    private SettingsMenu st = new SettingsMenu();
    private Stalker stalker = new Stalker();
    private MorphAPI morphAPI = new MorphAPI();

    static final Logger log = LoggerFactory.getLogger(InvClick.class);

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        try {
            //**************************** PROFILE MENU ****************************//
            if (event.getInventory().getTitle().equals(player.getName())) {
                if (event.getSlot() == 10) {
                    this.statistics.openMinigamesMenu(player);
                }
                if (event.getSlot() == 30) {
                    st.openSettingsMenu(player);
                }
                if (event.getSlot() == 32) {
                    if(Main.getInstance().fetchData().isAT(player)){
                        stalker.openStalker(player);
                    } else {
                        player.sendMessage("§cK pouzivani teto sekce musis byt v AT!");
                    }
                }
                if (event.getSlot() == 34){
                    profil.openLanguageMenu(player);
                }
                event.setCancelled(true);
                player.updateInventory();
            }
            if (event.getInventory().getTitle().equals("Nastaveni jazyka")) {
                if (event.getSlot() == 40){
                    profil.openMenu(player);
                }
                if (event.getSlot() == 36){
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§d▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eOdkaz na nas Crowdin projekt:");
                    player.sendMessage("§bhttps://crowdin.com/project/craftmaniacz");
                    player.sendMessage("");
                    player.sendMessage("§d▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
            }
            if (event.getInventory().getTitle().equals("Stalker")) {
                if (event.getSlot() == 40) {
                    stalker.openAdminStalker(player);
                }
                event.setCancelled(true);
                player.updateInventory();
            }
            //**************************** MiniGames VIP MENU ****************************//
            if (event.getInventory().getTitle().equals("§lSMS > MiniGames VIP")) {
                if (event.getSlot() == 26) {
                    this.vMenu.openMenuSMS(player);
                }
            }
            //**************************** SMS SERVERS MENU ****************************//
            if (event.getInventory().getTitle().equals("§lSMS > Vyber serveru")) {
                event.setCancelled(true);
                player.updateInventory();
                if (event.getSlot() == 26) {
                    this.vMenu.openVIPMenu(player);
                }
                if (event.getSlot() == 15) {
                    this.vMenu.openMinigamesSMS(player);
                }
                if (event.getSlot() == 11) {
                    player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_HURT, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
                    player.sendMessage("§b/vip");
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
                if (event.getSlot() == 12) {
                    player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_HURT, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
                    player.sendMessage("§b/vip");
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
                if (event.getSlot() == 13) {
                    player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_HURT, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eNakup pomoci SMS provedes na serveru pomoci:");
                    player.sendMessage("§b/vip");
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
                if (event.getSlot() == 14) {
                    player.sendMessage("§cV soucasne dobe nedostupne!");
                }

            }
            //**************************** VIP MENU ****************************//
            if (event.getInventory().getTitle().equals("§lVIP Shop")) {
                event.setCancelled(true);
                player.updateInventory();
                if (event.getSlot() == 11) {
                    player.playSound(player.getLocation(), Sound.ENTITY_COW_HURT, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eNakup pomoci SMS/Paypal/PSC provedes zde:");
                    player.sendMessage("§bhttp://store.craftmania.cz");
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
                if (event.getSlot() == 15) {
                    player.playSound(player.getLocation(), Sound.ENTITY_COW_HURT, 13.0F, 1.0F);
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.sendMessage("");
                    player.sendMessage("§eNakup pomoci SMS/Paypal/PSC provedes zde:");
                    player.sendMessage("§bhttp://store.craftmania.cz");
                    player.sendMessage("");
                    player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                    player.sendMessage("");
                    player.closeInventory();
                }
            }
            //**************************** MINIGAMES STATS ****************************//
            if (event.getInventory().getTitle().equals(player.getName())) {
                if (event.getCurrentItem().getType() == Material.AIR)
                    return;
                if (event.getSlot() == 35) {
                    this.profil.openMenu(player);
                }
                event.setCancelled(true);
                player.updateInventory();
            }
            //**************************** SERVERS MENU ****************************//
            if (event.getInventory().getTitle().equals("Vyber serveru")) {
                if (event.getSlot() == 10) {
                    sendToServer(player, "survival");
                }
                if (event.getSlot() == 11) {
                    sendToServer(player, "skyblock");
                }
                if (event.getSlot() == 12) {
                    sendToServer(player, "creative");
                }
                if (event.getSlot() == 13) {
                    sendToServer(player, "creative2");
                }
                if (event.getSlot() == 14) {
                    sendToServer(player, "prison");
                }
                if (event.getSlot() == 15) {
                    sendToServer(player, "vanilla");
                }
                if (event.getSlot() == 16) {
                    sendToServer(player, "vanillasb");
                }
                if (event.getSlot() == 21) {
                    sendToServer(player, "slobby");
                }
                if (event.getSlot() == 20) {
                    sendToServer(player, "blobby");
                }
                if (event.getSlot() == 23) {
                    sendToServer(player, "dlobby");
                }
                if (event.getSlot() == 24){
                    sendToServer(player, "dlobby");
                }
            }
            //**************************** GADGETS HLAVNI MENU ****************************//
            if (event.getInventory().getTitle().equals("Hlavni menu")) {
                if (event.getSlot() == 10) {
                    hAPI.openMainHeadsMenu(player);
                }
                if (event.getSlot() == 30) {
                    Main.getInstance().getGadgetsAPI().openInventory(player);
                }
                if (event.getSlot() == 32) {
                    morphAPI.openMenu(player);
                }
                if (event.getSlot() == 34) {
                    this.pMenu.openParticles(player);
                }
                if (event.getSlot() == 12) {
                    bannerAPI.openInventory(player);
                }
                if (event.getSlot() == 14) {
                    player.sendMessage("§cAktualne nedostupne do vydani pozdejsiho updatu!");
                }
                if (event.getSlot() == 28) {
                    Main.getInstance().getPetsAPI().openMainInv(player);
                }
                if (event.getSlot() == 16) {
                    Main.getInstance().getCloaksAPI().openCloaks(player);
                }
                if (event.getSlot() == 49) {
                    //this.np.openNakup(player);
                    player.sendMessage("§cDeaktivovano...");
                }
                event.setCancelled(true);
                player.updateInventory();
            }
            //**************************** NAKUP CRAFTBOXU MENU ****************************//
            if (event.getInventory().getTitle().equals("Nakup CraftBoxu")) {
                if (event.getSlot() == 15) {
                    this.gadgetsMenu.openGadgetsMenu(player);
                }
                if (event.getSlot() == 11) {
                    int coins = Main.getInstance().fetchData().getCraftCoins(player.getUniqueId());
                    if (!Main.getInstance().fetchData().hasData(player.getUniqueId())) { //Nema zaznam
                        if (coins >= 750) { //Coiny vic jak 750
                            Main.getInstance().setData().takeCoins(player, 750);
                            Main.getInstance().setData().createRecordBuy(player, System.currentTimeMillis() + 86400000);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mb add " + player.getName() + " 1");
                            player.sendMessage("§eZakoupil jsi si §b1x CraftBox!");
                            player.closeInventory();
                        } else {
                            player.sendMessage("§cNedostatek CraftCoinu k nakupu!");
                            player.closeInventory();
                        }
                    } else {
                        if (Main.getInstance().fetchData().getTimeToBuy(player.getUniqueId()) < System.currentTimeMillis()) {
                            if (coins >= 750) {
                                Main.getInstance().setData().takeCoins(player, 750);
                                Main.getInstance().setData().updateTimeBuy(player, System.currentTimeMillis() + 86400000);
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mb add " + player.getName() + " 1");
                                player.sendMessage("§eZakoupil jsi si §b1x CraftBox!");
                                player.closeInventory();
                            } else {
                                player.sendMessage("§cNedostatek CraftCoinu k nakupu!");
                                player.closeInventory();
                            }
                        } else {
                            player.closeInventory();
                            player.sendMessage("§cStale neubehlo 24 hodin od nakupu.");
                        }
                    }
                }
            }
            //**************************** PARTICLES MENU ****************************//
            if (event.getInventory().getTitle().equals("Particles")) {
                if (event.getSlot() == 40) {
                    deactivateParticles(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                    player.closeInventory();
                }
                if (event.getSlot() == 39) {
                    this.gadgetsMenu.openGadgetsMenu(player);
                }
                if (event.getSlot() == 10) {
                    if (player.hasPermission("craftlobby.particles.frostlord")) {
                        deactivateParticles(player);
                        fl.activateFrost(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.ICE, (byte) 0, "§a§lFrostLord");
                        Shop.open(player, "FrostLord", "craftlobby.particles.frostlord", i, 700);
                    }
                }
                if (event.getSlot() == 11) {
                    if (player.hasPermission("craftlobby.particles.flamerings")) {
                        deactivateParticles(player);
                        fr.activateFlame(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§a§lFlameRings");
                        Shop.open(player, "FlameRings", "craftlobby.particles.flamerings", i, 1000);
                    }
                }
                if (event.getSlot() == 12) {
                    if (player.hasPermission("craftlobby.particles.snowclouds")) {
                        deactivateParticles(player);
                        ss.activateSnowCloud(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§a§lSnowClouds");
                        Shop.open(player, "SnowClouds", "craftlobby.particles.snowclouds", i, 600);
                    }
                }
                if (event.getSlot() == 13) {
                    if (player.hasPermission("craftlobby.particles.rainclouds")) {
                        deactivateParticles(player);
                        rc.activateRainCloud(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§a§lRainClouds");
                        Shop.open(player, "RainClouds", "craftlobby.particles.rainclouds", i, 600);
                    }
                }
                if (event.getSlot() == 14) {
                    if (player.hasPermission("craftlobby.particles.bloodhelix")) {
                        deactivateParticles(player);
                        bh.activateHelix(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§a§lBloodhelix");
                        Shop.open(player, "Bloodhelix", "craftlobby.particles.bloodhelix", i, 2000);
                    }
                }
                if (event.getSlot() == 15) {
                    if (player.hasPermission("craftlobby.particles.greensparks")) {
                        deactivateParticles(player);
                        gs.activateGreenSparks(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.EMERALD, (byte) 0, "§a§lGreenSparks");
                        Shop.open(player, "GreenSparks", "craftlobby.particles.greensparks", i, 700);
                    }
                }
                if (event.getSlot() == 16) {
                    if (player.hasPermission("craftlobby.particles.endersignal")) {
                        deactivateParticles(player);
                        es.activateSignal(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER, (byte) 0, "§a§lEnderSignal");
                        Shop.open(player, "EnderSignal", "craftlobby.particles.endersignal", i, 1500);
                    }
                }
                if (event.getSlot() == 19) {
                    if (player.hasPermission("craftlobby.particles.enchanted")) {
                        deactivateParticles(player);
                        e.activateEnchanted(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.BOOK, (byte) 0, "§a§lEnchanted");
                        Shop.open(player, "Enchanted", "craftlobby.particles.enchanted", i, 1200);
                    }
                }
                if (event.getSlot() == 20) {
                    if (player.hasPermission("craftlobby.particles.love")) {
                        deactivateParticles(player);
                        l.activateLove(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.RED_ROSE, (byte) 0, "§a§lLove");
                        Shop.open(player, "Love", "craftlobby.particles.love", i, 500);
                    }
                }
                if (event.getSlot() == 21) {
                    if (player.hasPermission("craftlobby.particles.notes")) {
                        deactivateParticles(player);
                        n.activateNotes(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.JUKEBOX, (byte) 0, "§a§lNotes");
                        Shop.open(player, "Notes", "craftlobby.particles.notes", i, 500);
                    }
                }
                if (event.getSlot() == 22) {
                    if (player.hasPermission("craftlobby.particles.clouds")) {
                        deactivateParticles(player);
                        c.activateClouds(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.QUARTZ, (byte) 0, "§a§lClouds");
                        Shop.open(player, "Clouds", "craftlobby.particles.clouds", i, 500);
                    }
                }
                if (event.getSlot() == 23) {
                    if (player.hasPermission("craftlobby.particles.coloreddust")) {
                        deactivateParticles(player);
                        cd.activateDust(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.WOOL, (byte) 0, "§a§lColoredDust");
                        Shop.open(player, "ColoredDust", "craftlobby.particles.coloreddust", i, 700);
                    }
                }
                if (event.getSlot() == 24) {
                    if (player.hasPermission("craftlobby.particles.lavapop")) {
                        deactivateParticles(player);
                        lp.activateDust(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§a§lLavaPop");
                        Shop.open(player, "LavaPop", "craftlobby.particles.lavapop", i, 500);
                    }
                }
                if (event.getSlot() == 25) {
                    if (player.hasPermission("craftlobby.particles.portal")) {
                        deactivateParticles(player);
                        p.activatePortal(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.OBSIDIAN, (byte) 0, "§a§lPortal");
                        Shop.open(player, "Portal", "craftlobby.particles.portal", i, 500);
                    }
                }
                if (event.getSlot() == 28) {
                    if (player.hasPermission("craftlobby.particles.spell")) {
                        deactivateParticles(player);
                        sp.activateSpell(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.POTION, (byte) 0, "§a§lSpell");
                        Shop.open(player, "Spell", "craftlobby.particles.spell", i, 600);
                    }
                }
                if (event.getSlot() == 29) {
                    if (player.hasPermission("craftlobby.particles.frozenwalk")) {
                        deactivateParticles(player);
                        fw.activateFrozen(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.SNOW_BLOCK, (byte) 0, "§a§lFrozenWalk");
                        Shop.open(player, "FrozenWalk", "craftlobby.particles.frozenwalk", i, 300);
                    }
                }
                if (event.getSlot() == 30) {
                    if (player.hasPermission("craftlobby.particles.lilly")) {
                        deactivateParticles(player);
                        lil.activateSignal(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.WATER_LILY, (byte) 0, "§a§lLilly");
                        Shop.open(player, "Lilly", "craftlobby.particles.lilly", i, 1200);
                    }
                }
                if (event.getSlot() == 31) {
                    if (player.hasPermission("craftlobby.particles.santahat")) {
                        deactivateParticles(player);
                        sh.activateHat(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 1, "§a§lSantaHat");
                        Shop.open(player, "SantaHat", "craftlobby.particles.santahat", i, 1500);
                    }
                }
                if (event.getSlot() == 32) {
                    if (player.hasPermission("craftlobby.particles.candycane")) {
                        deactivateParticles(player);
                        cc.activate(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 2, "§a§lCandyCane");
                        Shop.open(player, "CandyCane", "craftlobby.particles.candycane", i, 1000);
                    }
                }
                if (event.getSlot() == 49) {
                    this.gadgetsMenu.openGadgetsMenu(player);
                }
                RankCape.deactivateCape(player);
            }
            if ((event.getSlot() == 20) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Web"))){
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na nas web:");
                player.sendMessage("§fhttps://craftmania.cz");
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 22) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Discord"))){
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na nas Discord server:");
                player.sendMessage("§fhttps://discord.gg/craftmania");
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 24) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Facebook"))){
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na nasi Facebook Page:");
                player.sendMessage("§fhttps://www.fb.com/craftmaniacz/");
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
        } catch (Exception e) {
            log.error("", e);
        }

    }

    public void sendToServer(Player player, String group, String end) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(group);
            out.writeUTF(end);

        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.getPlugin(), "PlayerBalancer", b.toByteArray());
    }


    public void sendToServer(Player player, String target) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(target);
        } catch (Exception e) {
            log.error("", e);
        }
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }

    public void deactivateParticles(Player player) {
        try {
            if (GreenSparks.greenPlayers.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) GreenSparks.greenPlayers.get(player.getName())).intValue());
                GreenSparks.greenPlayers.remove(player.getName());
                player.closeInventory();
            }
            if (BloodHelix.bh.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) BloodHelix.bh.get(player.getName())).intValue());
                BloodHelix.bh.remove(player.getName());
                player.closeInventory();
            }
            if (RainCloud.rc.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) RainCloud.rc.get(player.getName())).intValue());
                RainCloud.rc.remove(player.getName());
                player.closeInventory();
            }
            if (FrostLord.fl.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) FrostLord.fl.get(player.getName())).intValue());
                FrostLord.fl.remove(player.getName());
                player.closeInventory();
            }
            if (FlameRings.fr.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) FlameRings.fr.get(player.getName())).intValue());
                FlameRings.fr.remove(player.getName());
                player.closeInventory();
            }
            if (SnowCloud.sc.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) SnowCloud.sc.get(player.getName())).intValue());
                SnowCloud.sc.remove(player.getName());
                player.closeInventory();
            }
            if (EnderSignal.es.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) EnderSignal.es.get(player.getName())).intValue());
                EnderSignal.es.remove(player.getName());
                player.closeInventory();
            }
            if (Enchanted.e.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Enchanted.e.get(player.getName())).intValue());
                Enchanted.e.remove(player.getName());
                player.closeInventory();
            }
            if (Love.l.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Love.l.get(player.getName())).intValue());
                Love.l.remove(player.getName());
                player.closeInventory();
            }
            if (Notes.no.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Notes.no.get(player.getName())).intValue());
                Notes.no.remove(player.getName());
                player.closeInventory();
            }
            if (Clouds.c.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Clouds.c.get(player.getName())).intValue());
                Clouds.c.remove(player.getName());
                player.closeInventory();
            }
            if (ColoredDust.cd.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) ColoredDust.cd.get(player.getName())).intValue());
                ColoredDust.cd.remove(player.getName());
                player.closeInventory();
            }
            if (LavaPop.lp.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) LavaPop.lp.get(player.getName())).intValue());
                LavaPop.lp.remove(player.getName());
                player.closeInventory();
            }
            if (Portal.port.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Portal.port.get(player.getName())).intValue());
                Portal.port.remove(player.getName());
                player.closeInventory();
            }
            if (MobSpell.ms.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) MobSpell.ms.get(player.getName())).intValue());
                MobSpell.ms.remove(player.getName());
                player.closeInventory();
            }
            if (FrozenWalk.fw.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) FrozenWalk.fw.get(player.getName())).intValue());
                FrozenWalk.fw.remove(player.getName());
                player.closeInventory();
            }
            if (Lily.li.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) Lily.li.get(player.getName())).intValue());
                Lily.li.remove(player.getName());
                player.closeInventory();
            }
            if (SantaHat.sh.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) SantaHat.sh.get(player.getName())).intValue());
                SantaHat.sh.remove(player.getName());
                player.closeInventory();
            }
            if (CandyCane.cd.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(((Integer) CandyCane.cd.get(player.getName())).intValue());
                CandyCane.cd.remove(player.getName());
                player.closeInventory();
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }

}
