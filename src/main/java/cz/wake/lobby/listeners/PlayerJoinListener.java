package cz.wake.lobby.listeners;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.wake.lobby.Main;
import cz.wake.lobby.gui.ChangelogsGUI;
import cz.wake.lobby.utils.SkullHeads;
import cz.wake.lobby.utils.UtilTablist;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PlayerJoinListener implements Listener {

    public static HashMap<Integer, String> joinMessages = new HashMap<Integer, String>(){{
        put(1, "{player} se pripojil na lobby");
        put(2, "Pozor! {player} prave pristal na lobby");
        put(3, "Tri! Dva! Jedna! {player} je tu!");
        put(4, "{player} je tu! Podrzte mi pivo.");
        put(5, "{player} prave prisel. Party zacala!");
        put(6, "{player} je tu a ma s sebou pizzu!");
        put(7, "{player} vas prisel znicit!");
    }};

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent e) {

        final Player p = e.getPlayer();

        //Deaktivace Join zprav
        e.setJoinMessage(null);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.updateInventory();

        p.teleport(new Location(
                Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn-command.location.world-name")),
                Main.getInstance().getConfig().getDouble("spawn-command.location.x"),
                Main.getInstance().getConfig().getDouble("spawn-command.location.y"),
                Main.getInstance().getConfig().getDouble("spawn-command.location.z"),
                (float) Main.getInstance().getConfig().getDouble("spawn-command.location.yaw"),
                (float) Main.getInstance().getConfig().getDouble("spawn-command.location.pitch")
        ));

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

        // Prefix v tablistu
        if (Main.getInstance().getConfig().getBoolean("tablist-prefixes", false)) {
            UtilTablist.setupDefaultTablist(p);
        }

        // Setting setttings :D
        setupPlayerOnJoin(p);

        //AT
        if (Main.getInstance().getSQL().isAT(p)) {
            Main.getInstance().at_list.add(p);
            Main.getInstance().getSQL().updateAtLastActive(p, System.currentTimeMillis());
        }

        // News
        if(Main.getInstance().getSQL().isLatestNewsEnabled()) {
            String message = Main.getInstance().getSQL().getLatestNews();
            if(message != null) {
                if(!Main.getInstance().getSQL().sawLatestNews(p)) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            e.getPlayer().sendMessage("§7§m---------§7[§b§l Máš nepřečtené oznámení §7]§m---------\n");
                            e.getPlayer().sendMessage("§f");
                            e.getPlayer().sendMessage("§b" + message);
                            e.getPlayer().sendMessage("§f");
                            e.getPlayer().sendMessage("§7§o"+"Pro potvrzeni zadej prikaz /precteno");
                            e.getPlayer().sendMessage("§f");
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 20L);
                }
            }
        }

        if (Main.getInstance().getIdServer().equalsIgnoreCase("main")) {

            // Registrace vanocniho kalendare
            if (Main.getInstance().isChristmas()) {
                Main.getInstance().getSQL().addCalendarDefaultValue(p);
            }

            // Update Nicku v player_profile (pokud si hrac zmeni nick)
            //TODO: Prdelat jednotne s 1 requestem pri zjisteni (v1.8)
            String name = Main.getInstance().getSQL().getNameInCcomunity(p.getUniqueId().toString()); // Ziskani nicku podle UUID
            if (name != null) { // Kdyz existuje, kdyz ne null
                if (!name.equals(p.getName())) { // Pokud se nick neshoduje
                    Main.getInstance().getSQL().updateCcominutyForceNick(p); // Update nicku
                    System.out.println("[CraftLobby] Update nicku v SQL pro: " + p.getName());
                }
            }

            // Update nicku v ATS
            if (Main.getInstance().at_list.contains(p)) {
                String nameInDB = Main.getInstance().getSQL().getNameInATS(p.getUniqueId().toString());
                if (nameInDB != null) {
                    if (!nameInDB.equals(p.getName())) {
                        Main.getInstance().getSQL().updateNickInATS(p);
                        System.out.println("[CraftLobby] Update ATS nicku v SQL pro: " + p.getName());
                    }
                }
            }
        }

        // Oznameni o pripojeni pro GVIP
        if ((p.hasPermission("craftlobby.vip.joinbroadcast-message"))
                && Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_enabled") == 1) {
            if (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_message") == 0) {
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 1);
            }

            String joinMessage = formatJoinMessage(Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_message"), p);
            Bukkit.getOnlinePlayers().forEach(onlinePlayer -> {
                onlinePlayer.sendMessage(joinMessage);
                if ((p.hasPermission("craftlobby.vip.joinbroadcast-change-sound") && (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_sound_enabled") == 1))) {
                    onlinePlayer.getWorld().playSound(onlinePlayer.getLocation(),
                            Sound.valueOf(Main.getInstance().getSQL().getSettingsString(p, "lobby_joinbroadcast_sound")), 0.999F, 0.999F);
                }
            });
        }
    }

    private static void setupDefaultItems(final Player p) {

        ItemStack compass = new ItemBuilder(Material.COMPASS).setName("§bVyber serveru §7(Klikni pravym)").build();

        ItemStack playerProfile = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(p).setName("§aProfil §7(Klikni pravym)").build();

        ItemStack hider = new ItemBuilder(Material.LIME_DYE).setName("§7Hráči: §a§lVIDITELNÍ").build();

        ItemStack web = SkullHeads.createHead(
                "§aWeb",
                "c424243d-0421-4774-8aeb-2ddea957ed57",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5MzZkNGYwZDFiOTNmZWY3NzViMWZiZDE5MjgxYjcwYzZmODg0NzViYjVhNDFiZjM3MmMxMmYxZjhhMjIifX19",
                "§a§lWeb", "§7Odkaz na náš web:", "§fhttps://craftmania.cz", "", "§eKliknutím zobrazíš odkaz v chatu");

        ItemStack discord = SkullHeads.createHead(
                "§9§lDiscord",
                "de431cd1-ae1d-49f6-9339-a96daeacc32b",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19",
                "§9§lDiscord",
                "§7Odkaz na náš Discord server:", "§fhttps://discord.gg/craftmania", "", "§eKliknutím zobrazíš odkaz v chatu");

        ItemStack instagram = SkullHeads.createHead(
                "§d§lInstagram",
                "5e469ecf-80a4-40ae-8d9d-7c12bd2d3a3f",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjViM2YyY2ZhMDczOWM0ZTgyODMxNmYzOWY5MGIwNWJjMWY0ZWQyN2IxZTM1ODg4NTExZjU1OGQ0Njc1In19fQ==",
                "§d§lInstagram",
                "§7Odkaz na náš Instagram:", "§fhttps://www.instagram.com/craftmania.cz/", "", "§eKliknutím zobrazíš odkaz v chatu");

        p.getInventory().setItem(0, compass);
        p.getInventory().setItem(2, playerProfile);
        p.getInventory().setItem(6, hider);

        p.getInventory().setItem(20, web);
        p.getInventory().setItem(22, discord);
        p.getInventory().setItem(24, instagram);
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

        //TODO: Fix
        /*// Nastaveni skryti hracu
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
        }*/

        // Lobby speed
        if (Main.getInstance().getSQL().getSettings(p, "lobby_speed") == 1) {
            p.setWalkSpeed(0.3F);
        } else {
            p.setWalkSpeed(0.2F);
        }
    }

    public static String formatJoinMessage(Integer i, Player p) {
        String entry = joinMessages.get(i);
        String message;
        message = "§7" + entry;
        message = message.replace("{player}", "§e§l" + p.getName() + "§7");
        return message;
    }
}
