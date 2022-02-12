package cz.wake.lobby.seasons.christmas;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.crafteconomy.api.EconomyAPI;
import cz.craftmania.craftlibs.utils.ChatInfo;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.SkullHeads;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class Kalendar implements Listener {

    public void openKalendar(final Player player) {

        if (Main.getInstance().getSQL().getPlayerProfileDataIntNoUUID(player, "played_time") < 180) {
            ChatInfo.DANGER.send(player, "Aby jsi si mohl vybrat odměnu, musíš mít odehrané aspoň 3 hodiny na serveru! :)");
            return;
        }

        Inventory inv = Bukkit.createInventory(null, 54, "Kalendar");

        inv.setItem(2, canOpen(player, 1, CalenderTimes.DAY_1.get()));
        inv.setItem(40, canOpen(player, 2, CalenderTimes.DAY_2.get()));
        inv.setItem(28, canOpen(player, 3, CalenderTimes.DAY_3.get()));
        inv.setItem(9, canOpen(player, 4, CalenderTimes.DAY_4.get()));
        inv.setItem(50, canOpen(player, 5, CalenderTimes.DAY_5.get()));
        inv.setItem(33, canOpen(player, 6, CalenderTimes.DAY_6.get()));
        inv.setItem(15, canOpen(player, 7, CalenderTimes.DAY_7.get()));
        inv.setItem(46, canOpen(player, 8, CalenderTimes.DAY_8.get()));
        inv.setItem(36, canOpen(player, 9, CalenderTimes.DAY_9.get()));
        inv.setItem(8, canOpen(player, 10, CalenderTimes.DAY_10.get()));
        inv.setItem(26, canOpen(player, 11, CalenderTimes.DAY_11.get()));
        inv.setItem(52, canOpen(player, 12, CalenderTimes.DAY_12.get()));
        inv.setItem(5, canOpen(player, 13, CalenderTimes.DAY_13.get()));
        inv.setItem(12, canOpen(player, 14, CalenderTimes.DAY_14.get()));
        inv.setItem(20, canOpen(player, 15, CalenderTimes.DAY_15.get()));
        inv.setItem(44, canOpen(player, 16, CalenderTimes.DAY_16.get()));
        inv.setItem(30, canOpen(player, 17, CalenderTimes.DAY_17.get()));
        inv.setItem(23, canOpen(player, 18, CalenderTimes.DAY_18.get()));
        inv.setItem(18, canOpen(player, 19, CalenderTimes.DAY_19.get()));
        inv.setItem(42, canOpen(player, 20, CalenderTimes.DAY_20.get()));
        inv.setItem(48, canOpen(player, 21, CalenderTimes.DAY_21.get()));
        inv.setItem(22, canOpen(player, 22, CalenderTimes.DAY_22.get()));
        inv.setItem(25, canOpen(player, 23, CalenderTimes.DAY_23.get()));
        inv.setItem(38, canOpen(player, 24, CalenderTimes.DAY_24.get()));
        inv.setItem(0, canOpen(player,25, CalenderTimes.DAY_25.get()));
        inv.setItem(6, canOpen(player, 26, CalenderTimes.DAY_26.get()));
        inv.setItem(16, canOpen(player, 27, CalenderTimes.DAY_27.get()));
        inv.setItem(31, canOpen(player, 28, CalenderTimes.DAY_28.get()));
        inv.setItem(43, canOpen(player, 29, CalenderTimes.DAY_29.get()));
        inv.setItem(35, canOpen(player, 30, CalenderTimes.DAY_30.get()));
        inv.setItem(47, canOpen(player, 31, CalenderTimes.DAY_31.get()));

        inv.setItem(1, glass());
        inv.setItem(3, glass());
        inv.setItem(4, glass());
        inv.setItem(7, glass());
        inv.setItem(10, glass());
        inv.setItem(11, glass());
        inv.setItem(13, glass());
        inv.setItem(14, glass());
        inv.setItem(17, glass());
        inv.setItem(19, glass());
        inv.setItem(21, glass());
        inv.setItem(24, glass());
        inv.setItem(27, glass());
        inv.setItem(29, glass());
        inv.setItem(32, glass());
        inv.setItem(34, glass());
        inv.setItem(37, glass());
        inv.setItem(39, glass());
        inv.setItem(41, glass());
        inv.setItem(45, glass());
        inv.setItem(49, glass());
        inv.setItem(51, glass());
        inv.setItem(53, glass());

        player.openInventory(inv);
    }

    private ItemStack glass() {
        return new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c ").build();
    }

    private ItemStack canOpen(final Player player, final int day, final long time) {
        if (System.currentTimeMillis() > time) { // Kontrola zda muze otevrit tento den
            if (Main.getInstance().getSQL().checkDay(player, day) == 0) { // Kontrola zda uz otevrel
                ItemStack i = ranomHead("§e§l" + day + ". den");
                ItemMeta iM = i.getItemMeta();
                ArrayList<String> iMLore = new ArrayList();
                iMLore.add("§aKliknutim si vyberes odmenu!");
                iM.setLore(iMLore);
                i.setItemMeta(iM);
                i.setAmount(day);
                return i;
            } else {
                ItemStack i = new ItemBuilder(Material.BARREL).setName("§c§l" + day + ". den").build();
                ItemMeta iM = i.getItemMeta();
                ArrayList<String> iMLore = new ArrayList();
                iMLore.add("§7Jiz jsi otevrel tuto moznost!");
                iM.setLore(iMLore);
                i.setItemMeta(iM);
                i.setAmount(day);
                return i;
            }
        } else {
            ItemStack i = new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c§l" + day + ". den").build();
            i.setAmount(day);
            return i;
        }
    }

    private ItemStack ranomHead(String name) {
        int sance = randRange(1, 100);
        if ((sance >= 1) && (sance <= 10)) { // Indigo
            return SkullHeads.createHead(name, "ce936179-5016-4926-8889-2c1705ef70d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmYyZDE4OTVmZmY0YjFiYjkxMTZjOGE5ZTIyOTU5N2Y2OWYzZWVlODgxMjI3NzZlNWY5NzMzNTdlNmIifX19");
        } else if ((sance >= 11) && (sance <= 20)) { // Light Blue
            return SkullHeads.createHead(name, "54a219b4-9a5f-45ed-80ff-8766d501588b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODRlMWM0MmYxMTM4M2I5ZGM4ZTY3ZjI4NDZmYTMxMWIxNjMyMGYyYzJlYzdlMTc1NTM4ZGJmZjFkZDk0YmI3In19fQ==");
        } else if ((sance >= 21) && (sance <= 30)) { // Grape
            return SkullHeads.createHead(name, "e174cc81-8646-4c48-afeb-d5fac7d24e16", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU3YjJlZTY1NmQ3Yjg2NWMzZmFkZDViMTQyOGMzNThkNDc2M2Y0MTc4YWM1OTlkNjA0ODY5YTE5ZDcifX19");
        } else if ((sance >= 31) && (sance <= 40)) { // Black
            return SkullHeads.createHead(name, "ee53f881-8b67-4604-bfb9-a43a6966eae2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM3MTJiMTk3MWM1ZjQyZWVmZjgwNTUxMTc5MjIwYzA4YjgyMTNlYWNiZTZiYzE5ZDIzOGMxM2Y4NmUyYzAifX19");
        } else if ((sance >= 41) && (sance <= 50)) { // Green
            return SkullHeads.createHead(name, "1ff80fcf-030e-447f-8b8d-b439963389b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY1YjUyYmRiMjU1NmZkN2Q0NmM1Yzg0OGEzOGM4YjhlZjE1M2FmZTdkNTZkYjE3NzZkOTliNTMzYmQwIn19fQ==");
        } else if ((sance >= 51) && (sance <= 60)) { // Gold
            return SkullHeads.createHead(name, "91df0725-c04d-4776-b9e7-01dad0ea6d5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NjUyYmZkYjdhZGRlMTI4ZTdlYWNjNTBkMTZlYjlmNDg3YTMyMDliMzA0ZGUzYjk2OTdjZWJmMTMzMjNiIn19fQ==");
        } else if ((sance >= 61) && (sance <= 70)) { // Red
            return SkullHeads.createHead(name, "dd7514ca-c10f-4389-9c14-78d2feae91b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjczYTIxMTQxMzZiOGVlNDkyNmNhYTUxNzg1NDE0MDM2YTJiNzZlNGYxNjY4Y2I4OWQ5OTcxNmM0MjEifX19");
        } else if ((sance >= 71) && (sance <= 80)) { // Gray
            return SkullHeads.createHead(name, "d08a119e-2aeb-48be-b14c-b3aa6b73af60", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWMzODIxZDRmNjFiMTdmODJmMGQ3YThlNTMxMjYwOGZmNTBlZGUyOWIxYjRkYzg5ODQ3YmU5NDI3ZDM2In19fQ==");
        } else if ((sance >= 81) && (sance <= 90)) { // Pink
            return SkullHeads.createHead(name, "c04fdca4-1221-49b2-b29d-f6622478dbbc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTBjNzVhMDViMzQ0ZWEwNDM4NjM5NzRjMTgwYmE4MTdhZWE2ODY3OGNiZWE1ZTRiYTM5NWY3NGQ0ODAzZDFkIn19fQ==");
        } else if ((sance >= 91) && (sance <= 100)) { // Dark Orange
            return SkullHeads.createHead(name, "13e135fb-348f-4c6a-99e3-e6e3aa385e73", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTI4ZTY5MmQ4NmUyMjQ0OTc5MTVhMzk1ODNkYmUzOGVkZmZkMzljYmJhNDU3Y2M5NWE3YWMzZWEyNWQ0NDUifX19");
        }
        return null;
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals("Kalendar")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            if (event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (event.getCurrentItem().isSimilar(glass())) {
                return;
            }
            if (event.getSlot() == 2) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_1.get()) { // 1.Den
                    if (Main.getInstance().getSQL().checkDay(player, 1) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 1);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 100 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 100);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 40) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_2.get()) { // 2.Den
                    if (Main.getInstance().getSQL().checkDay(player, 2) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 2);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Frontman Mask");
                        setPermission(player, "craftmanager.hats.frontman_mask");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 28) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_3.get()) { // 3.Den
                    if (Main.getInstance().getSQL().checkDay(player, 3) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 3);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Možný nákup -> Items - Baseball Bat");
                        ChatInfo.INFO.send(player, "Pro získání odměny zajdi na vybraný server a v §event/cshop {c}v sekci sezoní odměny si zakup Baseball Bat za SeasonPoints.");
                        EconomyAPI.SEASON_POINTS.give(player, 1);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 9) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_4.get()) { // 4.Den
                    if (Main.getInstance().getSQL().checkDay(player, 4) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 4);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Snowman");
                        setPermission(player, "craftmanager.disguise.snowman");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 50) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_5.get()) { // 5.den
                    if (Main.getInstance().getSQL().checkDay(player, 5) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 5);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Vánoční čepice");
                        setPermission(player, "craftmanager.hats.santa_hat");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 33) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_6.get()) { // 6.den
                    if (Main.getInstance().getSQL().checkDay(player, 6) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 6);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Chicken");
                        setPermission(player, "craftmanager.disguise.chicken");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 15) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_7.get()) { // 7.den
                    if (Main.getInstance().getSQL().checkDay(player, 7) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 7);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 100 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 100);
                        player.closeInventory();
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 46) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_8.get()) { // 8.den
                    if (Main.getInstance().getSQL().checkDay(player, 8) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 8);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Strider");
                        setPermission(player, "craftmanager.disguise.strider");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 36) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_9.get()) { // 9.den
                    if (Main.getInstance().getSQL().checkDay(player, 9) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 9);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 250 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 250);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 8) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_10.get()) { // 10.den
                    if (Main.getInstance().getSQL().checkDay(player, 10) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 10);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Dear Hat");
                        setPermission(player, "craftmanager.hats.dear_hat");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 26) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_11.get()) { // 11.den
                    if (Main.getInstance().getSQL().checkDay(player, 11) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 11);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Fox");
                        setPermission(player, "craftmanager.disguise.fox");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 52) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_12.get()) { // 12.den
                    if (Main.getInstance().getSQL().checkDay(player, 12) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 12);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Cow");
                        setPermission(player, "craftmanager.disguise.cow");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 5) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_13.get()) { // 13.den
                    if (Main.getInstance().getSQL().checkDay(player, 13) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 13);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 1 CraftToken");
                        EconomyAPI.CRAFT_TOKENS.give(player, 1);
                        player.closeInventory();
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 12) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_14.get()) { // 14.den
                    if (Main.getInstance().getSQL().checkDay(player, 14) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 14);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Goat");
                        setPermission(player, "craftmanager.disguise.goat");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 20) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_15.get()) { // 15.den
                    if (Main.getInstance().getSQL().checkDay(player, 15) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 15);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 100 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 100);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 44) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_16.get()) { // 16.den
                    if (Main.getInstance().getSQL().checkDay(player, 16) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 16);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Možný nákup -> Items - Ginger Pickaxe");
                        ChatInfo.INFO.send(player, "Pro získání odměny zajdi na vybraný server a v §event/cshop {c}v sekci sezoní odměny si zakup Ginger Pickaxe za SeasonPoints.");
                        EconomyAPI.SEASON_POINTS.give(player, 1);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 30) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_17.get()) { // 17.den
                    if (Main.getInstance().getSQL().checkDay(player, 17) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 17);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 250 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 250);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 23) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_18.get()) { // 18.den
                    if (Main.getInstance().getSQL().checkDay(player, 18) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 18);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Morph - Magma Slime");
                        setPermission(player, "craftmanager.disguise.magma_slime");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 18) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_19.get()) { // 19.den
                    if (Main.getInstance().getSQL().checkDay(player, 19) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 19);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Snowman Hat");
                        setPermission(player, "craftmanager.hats.snowman_hat");
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 42) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_20.get()) { // 20.den
                    if (Main.getInstance().getSQL().checkDay(player, 20) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 20);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 250 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 250);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 48) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_21.get()) { // 21.den
                    if (Main.getInstance().getSQL().checkDay(player, 21) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 21);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 250 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 250);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 22) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_22.get()) { // 22.den
                    if (Main.getInstance().getSQL().checkDay(player, 22) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 22);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 250 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 250);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 25) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_23.get()) { // 23.den
                    if (Main.getInstance().getSQL().checkDay(player, 23) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 23);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 500 CraftCoins");
                        EconomyAPI.CRAFT_COINS.give(player, 500);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
            if (event.getSlot() == 38) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_24.get()) { // 24.den
                    if (Main.getInstance().getSQL().checkDay(player, 24) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(player, 24);
                        ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Možný nákup -> Items - Frost Bow");
                        ChatInfo.INFO.send(player, "Pro získání odměny zajdi na vybraný server a v §event/cshop {c}v sekci sezoní odměny si zakup Frost Bow za SeasonPoints.");
                        EconomyAPI.SEASON_POINTS.give(player, 1);
                        player.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                        player.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                    player.closeInventory();
                    return;
                }
            }
        }
        if (event.getSlot() == 0) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_25.get()) { // 25.den
                if (Main.getInstance().getSQL().checkDay(player, 25) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 25);
                    if (player.hasPermission("group.gold") || player.hasPermission("group.diamond") || player.hasPermission("group.emerald") || player.hasPermission("group.obsidian")) {
                        ChatInfo.INFO.send(player, "Jelikož již vlastníš nějaké VIP vyšší, nemůžeme ti aktivovat Gold VIP.");
                        ChatInfo.INFO.send(player, "Naopak jsi dostal 2 CraftTokeny a 1.000 CraftCoins!");
                        EconomyAPI.CRAFT_COINS.give(player, 1000);
                        EconomyAPI.CRAFT_TOKENS.give(player, 2);
                        player.closeInventory();
                        return;
                    }
                    ChatInfo.INFO.send(player, "Byl ti aktivován speciální dárek: Global Gold VIP na 7 dní!");
                    setGlobalGold(player);
                    ChatInfo.SUCCESS.send(player, "Global Gold VIP [7 dní] bylo aktivováno.");
                    return;
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 6) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_26.get()) { // 26.den
                if (Main.getInstance().getSQL().checkDay(player, 26) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 26);
                    ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Možný nákup -> Items - Frost Sword");
                    ChatInfo.INFO.send(player, "Pro získání odměny zajdi na vybraný server a v §event/cshop {c}v sekci sezoní odměny si zakup Frost Sword za SeasonPoints.");
                    EconomyAPI.SEASON_POINTS.give(player, 1);
                    player.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 16) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_27.get()) { // 27.den
                if (Main.getInstance().getSQL().checkDay(player, 27) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 27);
                    ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Silvester Glasses 2021 Edition");
                    setPermission(player, "craftmanager.hats.silvester_glasses_2021");
                    player.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 31) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_28.get()) { // 28.den
                if (Main.getInstance().getSQL().checkDay(player, 28) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 28);
                    ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 1 CraftToken");
                    EconomyAPI.CRAFT_TOKENS.give(player, 1);
                    player.closeInventory();
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 43) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_29.get()) { // 29.den
                if (Main.getInstance().getSQL().checkDay(player, 29) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 29);
                    ChatInfo.SUCCESS.send(player, "Získal(a) jsi: 500 CraftCoins");
                    EconomyAPI.CRAFT_COINS.give(player, 500);
                    player.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 35) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_30.get()) { // 30.den
                if (Main.getInstance().getSQL().checkDay(player, 30) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(player, 30);
                    ChatInfo.SUCCESS.send(player, "Získal(a) jsi: Cosmetics - Silvester Party Hat 2021 Edition");
                    setPermission(player, "craftmanager.hats.silvester_party_hat_2021");
                    player.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }

        if (event.getSlot() == 47) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_31.get()) { // 31.den
                if (Main.getInstance().getSQL().checkDay(player, 31) == 0) {
                    player.sendMessage("");
                    player.sendMessage("§b§lPoděkování za rok 2021:");
                    player.sendMessage("§7Dnes je poslední den tohoto roku, pro všechny");
                    player.sendMessage("§7to byl nepochybně těžký rok, stejně tak i pro nás.");
                    player.sendMessage("§7Chtěli bychom ti poděkovat, že tu stále jsi a hraješ u nás");
                    player.sendMessage("§7i přes to, že tento rok toho moc nového nebylo.");
                    player.sendMessage("§7Příští rok to určitě zlepšíme, tak at je ten další rok lepší.");
                    player.sendMessage("§eDěkujeme <3");
                    player.sendMessage("");
                } else {
                    ChatInfo.DANGER.send(player, "Tuto odměnu jsi si již vybral(a).");
                    player.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(player, "Na výběr této odměny je příliš brzo.");
                player.closeInventory();
                return;
            }
        }
    }

    private void setPermission(Player p, String permission){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + permission + " true");
    }

    private void setGlobalGold(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent addtemp gold 7d");
    }

}
