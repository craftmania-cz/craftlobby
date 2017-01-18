package cz.wake.lobby.listeners;

import cz.wake.lobby.GUI.*;
import cz.wake.lobby.Main;
import cz.wake.lobby.banners.BannerAPI;
import cz.wake.lobby.cloaks.RankCape;
import cz.wake.lobby.heads.HeadsAPI;
import cz.wake.lobby.particles.*;
import cz.wake.lobby.settings.SettingsMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class InvClick implements Listener {

    StatisticsMG statistics = new StatisticsMG();
    Menu profilMenu = new Menu();
    GadgetsMenu gadgetsMenu = new GadgetsMenu();
    ParticlesMenu pMenu = new ParticlesMenu();
    VIPMenu vMenu = new VIPMenu();
    GreenSparks gs = new GreenSparks();
    FrostLord fl = new FrostLord();
    FlameRings fr = new FlameRings();
    SnowCloud ss = new SnowCloud();
    RainCloud rc = new RainCloud();
    BloodHelix bh = new BloodHelix();
    Portal p = new Portal();
    EnderSignal es = new EnderSignal();
    Enchanted e = new Enchanted();
    Love l = new Love();
    Notes n = new Notes();
    Clouds c = new Clouds();
    ColoredDust cd = new ColoredDust();
    LavaPop lp = new LavaPop();
    MobSpell sp = new MobSpell();
    FrozenWalk fw = new FrozenWalk();
    Lily lil = new Lily();
    SantaHat sh = new SantaHat();
    CandyCane cc = new CandyCane();
    Lobby lob = new Lobby();
    BannerAPI bannerAPI = new BannerAPI();
    HeadsAPI hAPI = new HeadsAPI();
    SettingsMenu st = new SettingsMenu();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        //**************************** PROFILE MENU ****************************//
        if (event.getInventory().getTitle().equals(player.getName())) {
            if (event.getSlot() == 10) {
                this.statistics.openMinigamesMenu(player);
            }
            if (event.getSlot() == 31){
                st.openSettingsMenu(player);
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
                this.vMenu.openMenuSMS(player);
            }
            if (event.getSlot() == 15) {
                player.playSound(player.getLocation(), Sound.ENTITY_COW_HURT, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eNakup pomoci Paypal/PSC provedes zde:");
                player.sendMessage("§bhttp://store.craftmania.cz");
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
        }
        //**************************** LOBBY MENU ****************************//
        if (event.getInventory().getTitle().equals("Prehled lobby serveru")) {
            if (event.getCurrentItem().getType() == Material.AIR)
                return;
            if (event.getSlot() == 0) {
                //sendToServer(player, "ohub");
            }
            if (event.getSlot() == 1) {
                sendToServer(player, "mainlobby", "frontend");
            }
            if (event.getSlot() == 2) {
                sendToServer(player, "mainlobby", "frontend");
            }
            if (event.getSlot() == 3) {
                sendToServer(player, "mainlobby", "frontend");
            }
            if (event.getSlot() == 4) {
                sendToServer(player, "mainlobby", "frontend");
            }
            if (event.getSlot() == 5) {
                sendToServer(player, "bedwars", "frontend");
            }
            if (event.getSlot() == 6) {
                sendToServer(player, "arcade", "frontend");
            }
            if (event.getSlot() == 7) {
                sendToServer(player, "skywars", "frontend");
            }
            event.setCancelled(true);
            player.updateInventory();
        }
        //**************************** MINIGAMES STATS ****************************//
        if (event.getInventory().getTitle().equals(player.getName())) {
            if (event.getCurrentItem().getType() == Material.AIR)
                return;
            if (event.getSlot() == 35) {
                this.profilMenu.openMenu(player);
            }
            event.setCancelled(true);
            player.updateInventory();
        }
        //**************************** SERVERS MENU ****************************//
        if (event.getInventory().getTitle().equals("           §0§nVyber serveru")) {
            if (event.getSlot() == 20) {
                sendToServer(player, "survival");
            }
            if (event.getSlot() == 21) {
                sendToServer(player, "skyblock");
            }
            if (event.getSlot() == 22) {
                sendToServer(player, "creative");
            }
            if (event.getSlot() == 23) {
                sendToServer(player, "creative2");
            }
            if (event.getSlot() == 24) {
                sendToServer(player, "prison");
            }
            if (event.getSlot() == 25) {
                sendToServer(player, "vanilla");
            }
            if (event.getSlot() == 31) {
                sendToServer(player, "alobby");
            }
            if (event.getSlot() == 30) {
                sendToServer(player, "slobby");
            }
            if (event.getSlot() == 29) {
                sendToServer(player, "blobby");
            }
            if (event.getSlot() == 32) {
                sendToServer(player, "dlobby");
            }
            if (event.getSlot() == 18) {
                this.lob.openMenu(player);
            }
            if (event.getSlot() == 26) {
                sendToServer(player, "factions");
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
                player.sendMessage("§cAktualne nedostupne do vydani pozdejsiho updatu!");
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
                    //MessagesListener.messageNoPerm(player, "FrostLord");
                }
            }
            if (event.getSlot() == 11) {
                if (player.hasPermission("craftlobby.particles.flamerings")) {
                    deactivateParticles(player);
                    fr.activateFlame(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "FlameRings");
                }
            }
            if (event.getSlot() == 12) {
                if (player.hasPermission("craftlobby.particles.snowclouds")) {
                    deactivateParticles(player);
                    ss.activateSnowCloud(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "SnowClouds");
                }
            }
            if (event.getSlot() == 13) {
                if (player.hasPermission("craftlobby.particles.rainclouds")) {
                    deactivateParticles(player);
                    rc.activateRainCloud(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "RainClouds");
                }
            }
            if (event.getSlot() == 14) {
                if (player.hasPermission("craftlobby.particles.bloodhelix")) {
                    deactivateParticles(player);
                    bh.activateHelix(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "BloodHelix");
                }
            }
            if (event.getSlot() == 15) {
                if (player.hasPermission("craftlobby.particles.greensparks")) {
                    deactivateParticles(player);
                    gs.activateGreenSparks(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "GreenSparks");
                }
            }
            if (event.getSlot() == 16) {
                if (player.hasPermission("craftlobby.particles.endersignal")) {
                    deactivateParticles(player);
                    es.activateSignal(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "EnderSignal");
                }
            }
            if (event.getSlot() == 19) {
                if (player.hasPermission("craftlobby.particles.enchanted")) {
                    deactivateParticles(player);
                    e.activateEnchanted(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Enchanted");
                }
            }
            if (event.getSlot() == 20) {
                if (player.hasPermission("craftlobby.particles.love")) {
                    deactivateParticles(player);
                    l.activateLove(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Love");
                }
            }
            if (event.getSlot() == 21) {
                if (player.hasPermission("craftlobby.particles.notes")) {
                    deactivateParticles(player);
                    n.activateNotes(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Notes");
                }
            }
            if (event.getSlot() == 22) {
                if (player.hasPermission("craftlobby.particles.clouds")) {
                    deactivateParticles(player);
                    c.activateClouds(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Clouds");
                }
            }
            if (event.getSlot() == 23) {
                if (player.hasPermission("craftlobby.particles.coloreddust")) {
                    deactivateParticles(player);
                    cd.activateDust(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "ColoredDust");
                }
            }
            if (event.getSlot() == 24) {
                if (player.hasPermission("craftlobby.particles.lavapop")) {
                    deactivateParticles(player);
                    lp.activateDust(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "LavaPop");
                }
            }
            if (event.getSlot() == 25) {
                if (player.hasPermission("craftlobby.particles.portal")) {
                    deactivateParticles(player);
                    p.activatePortal(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Portal");
                }
            }
            if (event.getSlot() == 28) {
                if (player.hasPermission("craftlobby.particles.spell")) {
                    deactivateParticles(player);
                    sp.activateSpell(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Spell");
                }
            }
            if (event.getSlot() == 29) {
                if (player.hasPermission("craftlobby.particles.frozenwalk")) {
                    deactivateParticles(player);
                    fw.activateFrozen(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "FrozenWalk");
                }
            }
            if (event.getSlot() == 30) {
                if (player.hasPermission("craftlobby.particles.lilly")) {
                    deactivateParticles(player);
                    lil.activateSignal(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "Lilly");
                }
            }
            if (event.getSlot() == 31) {
                if (player.hasPermission("craftlobby.particles.santahat")) {
                    deactivateParticles(player);
                    sh.activateHat(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "SantaHat");
                }
            }
            if (event.getSlot() == 32) {
                if (player.hasPermission("craftlobby.particles.candycane")) {
                    deactivateParticles(player);
                    cc.activate(player);
                    player.closeInventory();
                } else {
                    //MessagesListener.messageNoPerm(player, "CandyCane");
                }
            }
            if (event.getSlot() == 49) {
                this.gadgetsMenu.openGadgetsMenu(player);
            }
            RankCape.deactivateCape(player);
        }
        //**************************** MOUNT MENU ****************************//
        if (event.getInventory().getTitle().equals("Mounts")) {
            if (event.getSlot() == 39) {
                this.gadgetsMenu.openGadgetsMenu(player);
            }
            if (event.getSlot() == 49) {
                this.gadgetsMenu.openGadgetsMenu(player);
            }
        }
        //**************************** MORPHS MENU ****************************//
        if (event.getInventory().getTitle().equals("Morphs")) {
            if (event.getSlot() == 39) {
                this.gadgetsMenu.openGadgetsMenu(player);
            }
            if (event.getSlot() == 40) {
                //DisguiseAPI.undisguiseToAll(player);
                player.sendMessage(ChatColor.GRAY + "Zrusil jsi aktualni premenu.");
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                player.closeInventory();
            }
            if (event.getSlot() == 10) {
                //VillagerMorph.activate(player);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 15.0F, 15.0F);
                player.sendMessage(ChatColor.BLUE + "Aktivoval jsi Villager Morph.");
                player.closeInventory();
            }
            if (event.getSlot() == 11) {
                //PigMorph.activate(player);
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 15.0F, 15.0F);
                player.sendMessage(ChatColor.BLUE + "Aktivoval jsi Pig Morph.");
                player.closeInventory();
            }
            if (event.getSlot() == 49) {
                this.gadgetsMenu.openGadgetsMenu(player);
            }
            event.setCancelled(true);
            player.updateInventory();
        }
        return;
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
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }

    public void deactivateParticles(Player player) {
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
    }

}
