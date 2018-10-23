package cz.wake.lobby.listeners;

import cz.wake.lobby.gui.GadgetsMenu;
import cz.wake.lobby.gui.ParticlesMenu;
import cz.wake.lobby.Main;
import cz.wake.lobby.gadgets.banners.BannerAPI;
import cz.wake.lobby.gadgets.cloaks.RankCape;
import cz.wake.lobby.gadgets.heads.HeadsAPI;
import cz.wake.lobby.gadgets.morphs.MorphAPI;
import cz.wake.lobby.gadgets.particles.*;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class InvClick implements Listener {

    private GadgetsMenu gadgetsMenu = new GadgetsMenu();
    private ParticlesMenu pMenu = new ParticlesMenu();
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
    private MorphAPI morphAPI = new MorphAPI();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        try {
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
                    sendToServer(player, "prison");
                }
                if (event.getSlot() == 14) {
                    sendToServer(player, "vanilla");
                }
                if (event.getSlot() == 15) {
                    //sendToServer(player, "vanillasb");
                    player.sendMessage("§c§c(!) §cServer se aktualne predelava... O dalsich novinkach se brzo dozvis.");
                }
                if (event.getSlot() == 19) { //SKYWARS
                    sendToServer(player, "slobby");
                }
                if (event.getSlot() == 20) { // MURDER
                    sendToServer(player, "mlobby");
                }
                if (event.getSlot() == 21) { // BEDWARS 2
                    sendToServer(player, "bedlobby");
                }
            }
            //**************************** GADGETS HLAVNI MENU ****************************//
            if (event.getInventory().getTitle().equals("Hlavni menu")) {
                if (event.getSlot() == 10) {
                    //hAPI.openMainHeadsMenu(player);
                    player.sendMessage("§cAktualne nedostupne do vydani pozdejsiho updatu!");
                }
                if (event.getSlot() == 30) {
                    //Main.getInstance().getGadgetsAPI().openInventory(player);
                    player.sendMessage("§cAktualne nedostupne do vydani pozdejsiho updatu!");
                }
                if (event.getSlot() == 32) {
                    //morphAPI.openMenu(player);
                    player.sendMessage("§cAktualne nedostupne do vydani pozdejsiho updatu!");
                }
                if (event.getSlot() == 34) {
                    if (player.hasPermission("craftlobby.vip.particles")) {
                        this.pMenu.openParticles(player);
                    } else {
                        player.sendMessage("§cK zpristupneni efektu musis mit zakoupene VIP!");
                    }
                }
                if (event.getSlot() == 12) {
                    //bannerAPI.openInventory(player);
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
                    if (player.hasPermission("craftlobby.particles.frostlord")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        fl.activateFrost(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.ICE, (byte) 0, "§a§lFrostLord");
                        Shop.open(player, "FrostLord", "craftlobby.particles.frostlord", i, 700);
                    }
                }
                if (event.getSlot() == 11) {
                    if (player.hasPermission("craftlobby.particles.flamerings")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        fr.activateFlame(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§a§lFlameRings");
                        Shop.open(player, "FlameRings", "craftlobby.particles.flamerings", i, 1000);
                    }
                }
                if (event.getSlot() == 12) {
                    if (player.hasPermission("craftlobby.particles.snowclouds")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        ss.activateSnowCloud(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§a§lSnowClouds");
                        Shop.open(player, "SnowClouds", "craftlobby.particles.snowclouds", i, 600);
                    }
                }
                if (event.getSlot() == 13) {
                    if (player.hasPermission("craftlobby.particles.rainclouds")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        rc.activateRainCloud(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§a§lRainClouds");
                        Shop.open(player, "RainClouds", "craftlobby.particles.rainclouds", i, 600);
                    }
                }
                if (event.getSlot() == 14) {
                    if (player.hasPermission("craftlobby.particles.bloodhelix")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        bh.activateHelix(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§a§lBloodhelix");
                        Shop.open(player, "Bloodhelix", "craftlobby.particles.bloodhelix", i, 2000);
                    }
                }
                if (event.getSlot() == 15) {
                    if (player.hasPermission("craftlobby.particles.greensparks")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        gs.activateGreenSparks(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.EMERALD, (byte) 0, "§a§lGreenSparks");
                        Shop.open(player, "GreenSparks", "craftlobby.particles.greensparks", i, 700);
                    }
                }
                if (event.getSlot() == 16) {
                    if (player.hasPermission("craftlobby.particles.endersignal")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        es.activateSignal(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.EYE_OF_ENDER, (byte) 0, "§a§lEnderSignal");
                        Shop.open(player, "EnderSignal", "craftlobby.particles.endersignal", i, 1500);
                    }
                }
                if (event.getSlot() == 19) {
                    if (player.hasPermission("craftlobby.particles.enchanted")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        e.activateEnchanted(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.BOOK, (byte) 0, "§a§lEnchanted");
                        Shop.open(player, "Enchanted", "craftlobby.particles.enchanted", i, 1200);
                    }
                }
                if (event.getSlot() == 20) {
                    if (player.hasPermission("craftlobby.particles.love")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        l.activateLove(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.RED_ROSE, (byte) 0, "§a§lLove");
                        Shop.open(player, "Love", "craftlobby.particles.love", i, 500);
                    }
                }
                if (event.getSlot() == 21) {
                    if (player.hasPermission("craftlobby.particles.notes")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        n.activateNotes(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.JUKEBOX, (byte) 0, "§a§lNotes");
                        Shop.open(player, "Notes", "craftlobby.particles.notes", i, 500);
                    }
                }
                if (event.getSlot() == 22) {
                    if (player.hasPermission("craftlobby.particles.clouds")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        c.activateClouds(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.QUARTZ, (byte) 0, "§a§lClouds");
                        Shop.open(player, "Clouds", "craftlobby.particles.clouds", i, 500);
                    }
                }
                if (event.getSlot() == 23) {
                    if (player.hasPermission("craftlobby.particles.coloreddust")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        cd.activateDust(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.WOOL, (byte) 0, "§a§lColoredDust");
                        Shop.open(player, "ColoredDust", "craftlobby.particles.coloreddust", i, 700);
                    }
                }
                if (event.getSlot() == 24) {
                    if (player.hasPermission("craftlobby.particles.lavapop")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        lp.activateDust(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§a§lLavaPop");
                        Shop.open(player, "LavaPop", "craftlobby.particles.lavapop", i, 500);
                    }
                }
                if (event.getSlot() == 25) {
                    if (player.hasPermission("craftlobby.particles.portal")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        p.activatePortal(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.OBSIDIAN, (byte) 0, "§a§lPortal");
                        Shop.open(player, "Portal", "craftlobby.particles.portal", i, 500);
                    }
                }
                if (event.getSlot() == 28) {
                    if (player.hasPermission("craftlobby.particles.spell")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        sp.activateSpell(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.POTION, (byte) 0, "§a§lSpell");
                        Shop.open(player, "Spell", "craftlobby.particles.spell", i, 600);
                    }
                }
                if (event.getSlot() == 29) {
                    if (player.hasPermission("craftlobby.particles.frozenwalk")
                            || player.hasPermission("craftlobby.vip.particles")) {
                        deactivateParticles(player);
                        fw.activateFrozen(player);
                        player.closeInventory();
                    } else {
                        ItemStack i = ItemFactory.create(Material.SNOW_BLOCK, (byte) 0, "§a§lFrozenWalk");
                        Shop.open(player, "FrozenWalk", "craftlobby.particles.frozenwalk", i, 300);
                    }
                }
                if (event.getSlot() == 30) {
                    if (player.hasPermission("craftlobby.particles.lilly")
                            || player.hasPermission("craftlobby.vip.particles")) {
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
                    if (player.hasPermission("craftlobby.particles.candycane")
                            || player.hasPermission("craftlobby.vip.particles")) {
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
            if ((event.getSlot() == 19) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("§aWeb"))) {
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
            if ((event.getSlot() == 21) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Discord"))) {
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
            if ((event.getSlot() == 23) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Facebook"))) {
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
            if ((event.getSlot() == 25) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Twitter"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na nas Twitter ucet:");
                player.sendMessage("§fhttps://twitter.com/craftmania_cz");
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Deprecated
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


    /**
     Teleportuje hrace na server podle sekce

     @param player Player
     @param section Výběr sekce podle configu v Bungeecordu

     **/
    public void sendToServer(Player player, String section) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(section);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }

    public void deactivateParticles(Player player) {
        try {
            if (GreenSparks.greenPlayers.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(GreenSparks.greenPlayers.get(player.getName()));
                GreenSparks.greenPlayers.remove(player.getName());
                player.closeInventory();
            }
            if (BloodHelix.bh.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(BloodHelix.bh.get(player.getName()));
                BloodHelix.bh.remove(player.getName());
                player.closeInventory();
            }
            if (RainCloud.rc.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(RainCloud.rc.get(player.getName()));
                RainCloud.rc.remove(player.getName());
                player.closeInventory();
            }
            if (FrostLord.fl.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(FrostLord.fl.get(player.getName()));
                FrostLord.fl.remove(player.getName());
                player.closeInventory();
            }
            if (FlameRings.fr.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(FlameRings.fr.get(player.getName()));
                FlameRings.fr.remove(player.getName());
                player.closeInventory();
            }
            if (SnowCloud.sc.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(SnowCloud.sc.get(player.getName()));
                SnowCloud.sc.remove(player.getName());
                player.closeInventory();
            }
            if (EnderSignal.es.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(EnderSignal.es.get(player.getName()));
                EnderSignal.es.remove(player.getName());
                player.closeInventory();
            }
            if (Enchanted.e.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Enchanted.e.get(player.getName()));
                Enchanted.e.remove(player.getName());
                player.closeInventory();
            }
            if (Love.l.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Love.l.get(player.getName()));
                Love.l.remove(player.getName());
                player.closeInventory();
            }
            if (Notes.no.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Notes.no.get(player.getName()));
                Notes.no.remove(player.getName());
                player.closeInventory();
            }
            if (Clouds.c.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Clouds.c.get(player.getName()));
                Clouds.c.remove(player.getName());
                player.closeInventory();
            }
            if (ColoredDust.cd.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(ColoredDust.cd.get(player.getName()));
                ColoredDust.cd.remove(player.getName());
                player.closeInventory();
            }
            if (LavaPop.lp.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(LavaPop.lp.get(player.getName()));
                LavaPop.lp.remove(player.getName());
                player.closeInventory();
            }
            if (Portal.port.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Portal.port.get(player.getName()));
                Portal.port.remove(player.getName());
                player.closeInventory();
            }
            if (MobSpell.ms.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(MobSpell.ms.get(player.getName()));
                MobSpell.ms.remove(player.getName());
                player.closeInventory();
            }
            if (FrozenWalk.fw.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(FrozenWalk.fw.get(player.getName()));
                FrozenWalk.fw.remove(player.getName());
                player.closeInventory();
            }
            if (Lily.li.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(Lily.li.get(player.getName()));
                Lily.li.remove(player.getName());
                player.closeInventory();
            }
            if (SantaHat.sh.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(SantaHat.sh.get(player.getName()));
                SantaHat.sh.remove(player.getName());
                player.closeInventory();
            }
            if (CandyCane.cd.containsKey(player.getName())) {
                Bukkit.getScheduler().cancelTask(CandyCane.cd.get(player.getName()));
                CandyCane.cd.remove(player.getName());
                player.closeInventory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
