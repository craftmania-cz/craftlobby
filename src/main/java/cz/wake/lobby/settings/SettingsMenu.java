package cz.wake.lobby.settings;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsMenu implements Listener {

    public static ArrayList<Player> hiden = new ArrayList<>();
    public static ArrayList<Player> particles = new ArrayList<>();
    public static ArrayList<Player> gadgets = new ArrayList<>();
    public static ArrayList<Player> activeGadgets = new ArrayList<>();
    public static HashMap<Integer, String> joinMessages = new HashMap<Integer, String>(){{
        put(1, "{player} se pripojil na lobby");
        put(2, "Pozor! {player} prave pristal na lobby");
        put(3, "Tri! Dva! Jedna! {player} je tu!");
        put(4, "{player} je tu! Podrzte mi pivo.");
        put(5, "{player} prave prisel. Party zacala!");
        put(6, "{player} je tu a ma s sebou pizzu!");
        put(7, "{player} vas prisel znicit!");
    }};

    public void openSettingsMenu(final Player p, final int page) {
        ItemStack enabled = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 5, "§a§lZapnuto");
        ItemStack disabled = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 14, "§c§lVypnuto");
        ItemStack nedostupne = ItemFactory.create(Material.BARRIER, (byte) 0, "§c§lNedostupne");
        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§eZpet");
        ItemStack nextPage = ItemFactory.create(Material.ARROW, (byte) 0, "§eDalsi strana");
        ItemStack previousPage = ItemFactory.create(Material.ARROW, (byte) 0, "§ePredchozi strana");

        if (page == 1) {
            Inventory inv = Bukkit.createInventory(null, 45, "Osobni nastaveni (Strana 1/2)");

            ItemStack player = ItemFactory.create(Material.WATCH, (byte) 0, "§e§lViditelnost hracu", "§7Nastavuje zobrazeni", "§7hracu na lobby.");
            ItemStack pets = ItemFactory.create(Material.BONE, (byte) 0, "§e§lViditelnost pets", "§7Nastavuje zobrazeni", "§7pets na lobby.");
            ItemStack part = ItemFactory.create(Material.REDSTONE, (byte) 0, "§e§lParticles", "§7Viditelnost efektu", "", "§cDocasne nefunguje na vsechny!");
            ItemStack fly = ItemFactory.create(Material.ELYTRA, (byte) 0, "§e§lFly", "§7Nastavuje FLY na lobby serverech.", "§7Fly dostanes pri kazdem",
                    "§7vstupu na lobby", "", "§cVyzaduje MiniGames VIP nebo globalni Obsidian VIP!");
            ItemStack gadgets = ItemFactory.create(Material.PISTON_BASE, (byte) 0, "§e§lGadgets", "§7Nastavuje zda na tebe", "§7budou fungovat gadget lobby.");
            ItemStack speed = ItemFactory.create(Material.GOLD_BOOTS, (byte) 0, "§e§lSpeed", "§7Povoluje rychlost chozeni", "§7na lobby.");
            ItemStack novinky = ItemFactory.create(Material.MAP, (byte) 0, "§e§lReklama", "§7Nastavuje zobrazovani reklamy", "§7na VIP na MiniGames.", "", "§cVyzaduje MiniGames VIP!");
            ItemStack deathMessages = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§e§lDeath zpravy", "§7Nastavuje zobrazeni smrti", "§7hracu.", "", "§cFunguje pouze na Survival serverech");
            ItemStack notify = ItemFactory.create(Material.JUKEBOX, (byte) 0, "§e§lOznameni o oznaceni", "§7Pokud te nekdo oznaci", "§7v chatu, server te", "§7upozorni cinknutim.");

            inv.setItem(9, fly);
            inv.setItem(10, player);
            inv.setItem(11, pets);
            inv.setItem(12, part);
            inv.setItem(13, gadgets);
            inv.setItem(14, speed);
            inv.setItem(15, novinky);
            inv.setItem(16, deathMessages);
            inv.setItem(17, notify);
            inv.setItem(44, nextPage);

            if (Main.getInstance().getSQL().getSettings(p, "lobby_fly") == 1) {
                inv.setItem(18, enabled);
            } else {
                inv.setItem(18, disabled);
            }
            if (Main.getInstance().getSQL().getSettings(p, "lobby_players") == 1) {
                inv.setItem(19, disabled);
            } else {
                inv.setItem(19, enabled);
            }
            inv.setItem(20, nedostupne); //Pets
            if (Main.getInstance().getSQL().getSettings(p, "lobby_particles") == 1) {
                inv.setItem(21, enabled);
            } else {
                inv.setItem(21, disabled);
            }
            if (Main.getInstance().getSQL().getSettings(p, "lobby_gadgets") == 1) {
                inv.setItem(22, enabled);
            } else {
                inv.setItem(22, disabled);
            }
            if (Main.getInstance().getSQL().getSettings(p, "lobby_speed") == 1) {
                inv.setItem(23, enabled);
            } else {
                inv.setItem(23, disabled);
            }
            inv.setItem(24, nedostupne); //Novinky
            if (Main.getInstance().getSQL().getSettings(p, "death_messages") == 1) {
                inv.setItem(25, enabled);
            } else {
                inv.setItem(25, disabled);
            }
            inv.setItem(26, nedostupne); //Notify

            inv.setItem(40, zpet);

            p.openInventory(inv);
        } else if (page == 2) {
            Inventory inv = Bukkit.createInventory(null, 45, "Osobni nastaveni (Strana 2/2)");

            ItemStack joinMessage = ItemFactory.create(Material.BOOK, (byte) 0, "§e§lZprava pri pripojeni", "§7Pokud se pripojis", "§7ostatni o tom budou vedet.",
                    "", "§bVybrana zprava:", "§f" + formatJoinMessageWithoutColors(Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_message"), p),
                    "§7", "§eKliknutim si vyberes zpravu");
            ItemStack joinSound = ItemFactory.create(Material.NOTE_BLOCK, (byte) 0, "§e§lZvuk pri pripojeni", "§7Pokud se pripojis", "§7zazni zvuk.",
                    "§7Vybrany zvuk: " + Main.getInstance().getSQL().getSettingsString(p, "lobby_joinbroadcast_sound")
                            .replace("ENTITY_EXPERIENCE_ORB_PICKUP", "EXP ORB PICKUP")
                            .replace("BLOCK_ANVIL_FALL", "ANVIL FALL")
                            .replace("BLOCK_GLASS_BREAK", "GLASS BREAK")
                            .replace("ENTITY_ITEM_PICKUP", "ITEM PICKUP")
                            .replace("ENTITY_ZOMBIE_HURT", "ZOMBIE HURT")
                    , "", "§eKliknutim si vyberes zvuk");

            inv.setItem(9, joinMessage);
            inv.setItem(10, joinSound);

            inv.setItem(36, previousPage);
            inv.setItem(40, zpet);

            if (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_enabled") == 1) {
                inv.setItem(18, enabled);
            } else {
                inv.setItem(18, disabled);
            }

            if (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_sound_enabled") == 1) {
                inv.setItem(19, enabled);
            } else {
                inv.setItem(19, disabled);
            }

            p.openInventory(inv);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().startsWith("Osobni nastaveni (Strana 1/2")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                Main.getInstance().getMenu().openMenu(p);
            }
            if (e.getSlot() == 18) {
                if (p.hasPermission("craftlobby.vip.fly")) {
                    if (Main.getInstance().getSQL().getSettings(p, "lobby_fly") == 1) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_fly", 0);
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("§c§l[!] §cFly na lobby bylo deaktivovano!");
                        p.closeInventory();
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_fly", 1);
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage("§e§l[*] §eFly na lobby bylo aktivovano!");
                        p.closeInventory();
                    }
                } else {
                    p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal VIP");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 19) {
                if (Main.getInstance().getSQL().getSettings(p, "lobby_players") == 1) {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_players", 0);
                    SettingsMenu.hiden.remove(p);
                    for (Player p2 : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(p2);
                    }
                    p.sendMessage("§e§l[*] §eZobrazovani hracu zapnuto!");
                    p.closeInventory();
                } else {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_players", 1);
                    SettingsMenu.hiden.add(p);
                    for (Player p2 : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer(p2);
                    }
                    p.sendMessage("§c§l[!] §cZobrazovani hracu vypnuto!");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 21) {
                if (Main.getInstance().getSQL().getSettings(p, "lobby_particles") == 1) {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_particles", 0);
                    SettingsMenu.particles.remove(p);
                    p.sendMessage("§c§l[!] §cZobrazovani efektu vypnuto!");
                    p.closeInventory();
                } else {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_particles", 1);
                    SettingsMenu.particles.add(p);
                    p.sendMessage("§e§l[*] §eZobrazovani efektu zapnuto!");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 22) {
                if (Main.getInstance().getSQL().getSettings(p, "lobby_gadgets") == 1) {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_gadgets", 0);
                    SettingsMenu.gadgets.remove(p);
                    p.sendMessage("§c§l[!] §cGadgety jiz na tebe nebudou reagovat!");
                    p.closeInventory();
                } else {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_gadgets", 1);
                    SettingsMenu.gadgets.add(p);
                    p.sendMessage("§e§l[*] §eGadgety nyni na tebe budou reagovat!");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 23) {
                if (Main.getInstance().getSQL().getSettings(p, "lobby_speed") == 1) {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_speed", 0);
                    p.setWalkSpeed(0.2F);
                    p.sendMessage("§c§l[!] §cRychlost byla nastavena na zakladni!");
                    p.closeInventory();
                } else {
                    Main.getInstance().getSQL().updateSettings(p, "lobby_speed", 1);
                    p.setWalkSpeed(0.3F);
                    p.sendMessage("§e§l[*] §eRychlost byla nastavena na 2x rychlejsi!");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 25) {
                if (Main.getInstance().getSQL().getSettings(p, "death_messages") == 1) {
                    Main.getInstance().getSQL().updateSettings(p, "death_messages", 0);
                    p.sendMessage("§c§l[!] §cZablokovano zobrazovani zprav o smrti!");
                    p.closeInventory();
                } else {
                    Main.getInstance().getSQL().updateSettings(p, "death_messages", 1);
                    p.sendMessage("§e§l[*] §eNyni uvidis v chatu zpravy o smrti hracu!");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 44) {
                openSettingsMenu(p, 2);
            }
        }

        if (e.getInventory().getTitle().equals("Osobni nastaveni (Strana 2/2)")) {
            if (e.getSlot() == 18) {
                if (p.hasPermission("craftlobby.vip.joinbroadcast-message")) {
                    if (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_enabled") == 1) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_enabled", 0);
                        p.sendMessage("§c§l[!] §cZprava pri pripojeni byla deaktivovana!");
                        p.closeInventory();
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_enabled", 1);
                        p.sendMessage("§e§l[*] §eZprava pri pripojeni byla aktivovana!");
                        p.closeInventory();
                    }
                } else {
                    p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 19) {
                if (p.hasPermission("craftlobby.vip.joinbroadcast-change-sound")) {
                    if (Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_sound_enabled") == 1) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound_enabled", 0);
                        p.sendMessage("§c§l[!] §cZvuk pri pripojeni byl deaktivovan!");
                        p.closeInventory();
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound_enabled", 1);
                        p.sendMessage("§e§l[*] §eZvuk pri pripojeni byl aktivovan!");
                        p.closeInventory();
                    }
                } else {
                    p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 9) {
                if (p.hasPermission("craftlobby.vip.joinbroadcast-message")) {
                    openJoinMessagesMenu(p);
                } else {
                    p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                }
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.vip.joinbroadcast-change-sound")) {
                    openSoundsMenu(p);
                } else {
                    p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                }
            }
            if (e.getSlot() == 36) {
                openSettingsMenu(p, 1);
            }
        }
        if (e.getInventory().getTitle().equals("Nastaveni zpravy")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 10) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(1, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 1);
                return;
            }
            if (e.getSlot() == 11) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(2, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 2);
                return;
            }
            if (e.getSlot() == 12) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(3, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 3);
                return;
            }
            if (e.getSlot() == 13) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(1, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 4);
                return;
            }
            if (e.getSlot() == 14) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(5, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 5);
                return;
            }
            if (e.getSlot() == 15) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(6, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 6);
                return;
            }
            if (e.getSlot() == 16) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZprava pri pripojeni nastavena na §e'" + formatJoinMessageWithoutColors(7, p) + "'.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_message", 7);
                return;
            }
        }
        if (e.getInventory().getTitle().equals("Nastaveni zvuku")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 11) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZvuk oznacovani byl nastaven na §2§lEXP ORB PICKUP§e.");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound", "ENTITY_EXPERIENCE_ORB_PICKUP");
                return;
            }
            if (e.getSlot() == 12) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZvuk oznacovani byl nastaven na §2§lANVIL FALL§e.");
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound", "BLOCK_ANVIL_FALL");
                return;
            }
            if (e.getSlot() == 13) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZvuk oznacovani byl nastaven na §2§lGLASS BREAK§e.");
                p.playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound", "BLOCK_GLASS_BREAK");
                return;
            }
            if (e.getSlot() == 14) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZvuk oznacovani byl nastaven na §2§lITEM PICKUP§e.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound", "ENTITY_ITEM_PICKUP");
                return;
            }
            if (e.getSlot() == 15) {
                p.closeInventory();
                p.sendMessage("§e§l[*] §eZvuk oznacovani byl nastaven na §2§lZOMBIE HURT§e.");
                p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_HURT, 1.0f, 1.0f);
                Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound", "ENTITY_ZOMBIE_HURT");
                return;
            }
        }
    }

    public void removePlayer(final Player p) {
        if (gadgets.contains(p)) {
            gadgets.remove(p);
        }
        if (particles.contains(p)) {
            particles.remove(p);
        }
        if (hiden.contains(p)) {
            hiden.remove(p);
        }
    }

    private void openJoinMessagesMenu(final Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "Nastaveni zpravy");
        ItemStack jedna = ItemFactory.createHead("Prvni zprava", "00684a88-5cc8-4713-9e91-7b1906e67580",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzFiYzJiY2ZiMmJkMzc1OWU2YjFlODZmYzdhNzk1ODVlMTEyN2RkMzU3ZmMyMDI4OTNmOWRlMjQxYmM5ZTUzMCJ9fX0=",
        "§bVolba 1", "§7Text zpravy:", formatJoinMessageWithoutColors(1, p), "", "§aK nastaveni klikni");

        ItemStack dva = ItemFactory.createHead("Druha zprava", "f7218833-aceb-4d3e-a1bc-a334be09c375",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNkOWVlZWU4ODM0Njg4ODFkODM4NDhhNDZiZjMwMTI0ODVjMjNmNzU3NTNiOGZiZTg0ODczNDE0MTk4NDcifX19",
                "§bVolba 2", "§7Text zpravy:", formatJoinMessageWithoutColors(2, p), "", "§aK nastaveni klikni");

        ItemStack tri = ItemFactory.createHead("§e§lTRETI ZPRAVA", "870c6ce6-78b5-4e09-8745-bd96d616e516",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWQ0ZWFlMTM5MzM4NjBhNmRmNWU4ZTk1NTY5M2I5NWE4YzNiMTVjMzZiOGI1ODc1MzJhYzA5OTZiYzM3ZTUifX19",
                "§bVolba 3", "§7Text zpravy:", formatJoinMessageWithoutColors(3, p), "", "§aK nastaveni klikni");

        ItemStack styri = ItemFactory.createHead("§e§lCTVRTA ZPRAVA", "d531b607-3d92-4760-b19f-b64d51da0fa5",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJlNzhmYjIyNDI0MjMyZGMyN2I4MWZiY2I0N2ZkMjRjMWFjZjc2MDk4NzUzZjJkOWMyODU5ODI4N2RiNSJ9fX0=",
                "§bVolba 4", "§7Text zpravy:", formatJoinMessageWithoutColors(4, p), "", "§aK nastaveni klikni");

        ItemStack pet = ItemFactory.createHead("§e§lPATA ZPRAVA", "4aaa0af9-ffde-4f5a-ad06-112dffbade0c",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ1N2UzYmM4OGE2NTczMGUzMWExNGUzZjQxZTAzOGE1ZWNmMDg5MWE2YzI0MzY0M2I4ZTU0NzZhZTIifX19",
                "§bVolba 5", "§7Text zpravy:", formatJoinMessageWithoutColors(5, p), "", "§aK nastaveni klikni");

        ItemStack sest = ItemFactory.createHead("§e§lSESTA ZPRAVA", "58a05887-3473-4c87-8506-2acf877d7ff1",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzM0YjM2ZGU3ZDY3OWI4YmJjNzI1NDk5YWRhZWYyNGRjNTE4ZjVhZTIzZTcxNjk4MWUxZGNjNmIyNzIwYWIifX19=",
                "§bVolba 6", "§7Text zpravy:", formatJoinMessageWithoutColors(6, p), "", "§aK nastaveni klikni");

        ItemStack sedm = ItemFactory.createHead("§e§lSEDMA ZPRAVA", "23378bd2-28e5-4d7e-8d39-621b732e1f49",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRiNmViMjVkMWZhYWJlMzBjZjQ0NGRjNjMzYjU4MzI0NzVlMzgwOTZiN2UyNDAyYTNlYzQ3NmRkN2I5In19fQ==",
                "§bVolba 7", "§7Text zpravy:", formatJoinMessageWithoutColors(7, p), "", "§aK nastaveni klikni");

        inv.setItem(10, jedna);
        inv.setItem(11, dva);
        inv.setItem(12, tri);
        inv.setItem(13, styri);
        inv.setItem(14, pet);
        inv.setItem(15, sest);
        inv.setItem(16, sedm);

        p.openInventory(inv);
    }

    private void openSoundsMenu(final Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "Nastaveni zvuku");

        ItemStack experience = ItemFactory.create(Material.EXP_BOTTLE, (byte) 0, "§e§lEXP ORB PICKUP", "§f", "§7Tento zvuk slysis, kdyz", "§7seberes EXP orb.");
        inv.setItem(11, experience); // ENTITY_EXPERIENCE_ORB_PICKUP

        ItemStack anvil = ItemFactory.create(Material.ANVIL, (byte) 0, "§e§lANVIL FALL", "§f", "§7Tento zvuk slysis, kdyz", "§7kdyz anvilka dopadne na zem.");
        inv.setItem(12, anvil); // BLOCK_ANVIL_FALL

        ItemStack glass = ItemFactory.create(Material.GLASS, (byte) 0, "§e§lGLASS BREAK", "§f", "§7Tento zvuk slysis, kdyz", "§7rozbijes sklo.");
        inv.setItem(13, glass); // BLOCK_GLASS_BREAK

        ItemStack itempickup = ItemFactory.create(Material.IRON_PICKAXE, (byte) 0, "§e§lITEM PICKUP", "§f", "§7Tento zvuk slysis, kdyz", "§7seberes nejaky item.");
        inv.setItem(14, itempickup); // ENTITY_ITEM_PICKUP

        ItemStack zombie = ItemFactory.create(Material.ROTTEN_FLESH, (byte) 0, "§e§lZOMBIE HURT", "§f", "§7Tento zvuk slysis, kdyz", "§7ublizis zombie.");
        inv.setItem(15, zombie); // ENTITY_ZOMBIE_HURT

        p.openInventory(inv);
    }

    public static String formatJoinMessage(Integer i, Player p) {
        String entry = joinMessages.get(i);
        String message;
        message = "§7" + entry;
        message = message.replace("{player}", "§e§l" + p.getName() + "§7");
        return message;
    }

    public static String formatJoinMessageWithoutColors(Integer i, Player p) {
        String entry = joinMessages.get(i);
        String message;
        message = entry.replace("{player}", ChatColor.YELLOW + "" + ChatColor.BOLD + p.getName() + ChatColor.GRAY);
        return ChatColor.GRAY + message;
    }

}
