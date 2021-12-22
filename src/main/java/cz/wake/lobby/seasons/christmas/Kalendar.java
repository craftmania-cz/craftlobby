package cz.wake.lobby.seasons.christmas;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
import cz.craftmania.crafteconomy.api.SeasonPointsAPI;
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

    public void openKalendar(final Player p) {

        if (Main.getInstance().getSQL().getPlayerProfileDataIntNoUUID(p, "played_time") < 180) {
            ChatInfo.DANGER.send(p, "Aby jsi si mohl vybrat odměnu, musíš mít odehrané aspoň 3 hodiny na serveru! :)");
            return;
        }

        Inventory inv = Bukkit.createInventory(null, 54, "Kalendar");

        inv.setItem(2, canOpen(p, 1, CalenderTimes.DAY_1.get()));
        inv.setItem(40, canOpen(p, 2, CalenderTimes.DAY_2.get()));
        inv.setItem(28, canOpen(p, 3, CalenderTimes.DAY_3.get()));
        inv.setItem(9, canOpen(p, 4, CalenderTimes.DAY_4.get()));
        inv.setItem(50, canOpen(p, 5, CalenderTimes.DAY_5.get()));
        inv.setItem(33, canOpen(p, 6, CalenderTimes.DAY_6.get()));
        inv.setItem(15, canOpen(p, 7, CalenderTimes.DAY_7.get()));
        inv.setItem(46, canOpen(p, 8, CalenderTimes.DAY_8.get()));
        inv.setItem(36, canOpen(p, 9, CalenderTimes.DAY_9.get()));
        inv.setItem(8, canOpen(p, 10, CalenderTimes.DAY_10.get()));
        inv.setItem(26, canOpen(p, 11, CalenderTimes.DAY_11.get()));
        inv.setItem(52, canOpen(p, 12, CalenderTimes.DAY_12.get()));
        inv.setItem(5, canOpen(p, 13, CalenderTimes.DAY_13.get()));
        inv.setItem(12, canOpen(p, 14, CalenderTimes.DAY_14.get()));
        inv.setItem(20, canOpen(p, 15, CalenderTimes.DAY_15.get()));
        inv.setItem(44, canOpen(p, 16, CalenderTimes.DAY_16.get()));
        inv.setItem(30, canOpen(p, 17, CalenderTimes.DAY_17.get()));
        inv.setItem(23, canOpen(p, 18, CalenderTimes.DAY_18.get()));
        inv.setItem(18, canOpen(p, 19, CalenderTimes.DAY_19.get()));
        inv.setItem(42, canOpen(p, 20, CalenderTimes.DAY_20.get()));
        inv.setItem(48, canOpen(p, 21, CalenderTimes.DAY_21.get()));
        inv.setItem(22, canOpen(p, 22, CalenderTimes.DAY_22.get()));
        inv.setItem(25, canOpen(p, 23, CalenderTimes.DAY_23.get()));
        inv.setItem(38, canOpen(p, 24, CalenderTimes.DAY_24.get()));
        inv.setItem(0, canOpen(p,25, CalenderTimes.DAY_25.get()));
        inv.setItem(6, canOpen(p, 26, CalenderTimes.DAY_26.get()));
        inv.setItem(16, canOpen(p, 27, CalenderTimes.DAY_27.get()));
        inv.setItem(31, canOpen(p, 28, CalenderTimes.DAY_28.get()));
        inv.setItem(43, canOpen(p, 29, CalenderTimes.DAY_29.get()));
        inv.setItem(35, canOpen(p, 30, CalenderTimes.DAY_30.get()));
        inv.setItem(47, canOpen(p, 31, CalenderTimes.DAY_31.get()));

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

        p.openInventory(inv);
    }

    private ItemStack glass() {
        return new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c ").build();
    }

    private ItemStack canOpen(final Player p, final int day, final long time) {
        if (System.currentTimeMillis() > time) { // Kontrola zda muze otevrit tento den
            if (Main.getInstance().getSQL().checkDay(p, day) == 0) { // Kontrola zda uz otevrel
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
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals("Kalendar")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getCurrentItem().isSimilar(glass())) {
                return;
            }
            if (e.getSlot() == 2) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_1.get()) { // 1.Den
                    if (Main.getInstance().getSQL().checkDay(p, 1) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 1);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 100 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 40) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_2.get()) { // 2.Den
                    if (Main.getInstance().getSQL().checkDay(p, 2) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 2);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Frontman Mask");
                        setPermission(p, "craftmanager.hats.frontman_mask");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 28) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_3.get()) { // 3.Den
                    if (Main.getInstance().getSQL().checkDay(p, 3) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 3);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Možný nákup -> Items - Baseball Bat");
                        ChatInfo.INFO.send(p, "Pro získání odměny zajdi na vybraný server a v §e/cshop {c}v sekci sezoní odměny si zakup Baseball Bat za SeasonPoints.");
                        SeasonPointsAPI.giveSeasonPoints(p, 1);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 9) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_4.get()) { // 4.Den
                    if (Main.getInstance().getSQL().checkDay(p, 4) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 4);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Snowman");
                        setPermission(p, "craftmanager.disguise.snowman");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 50) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_5.get()) { // 5.den
                    if (Main.getInstance().getSQL().checkDay(p, 5) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 5);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Vánoční čepice");
                        setPermission(p, "craftmanager.hats.santa_hat");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 33) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_6.get()) { // 6.den
                    if (Main.getInstance().getSQL().checkDay(p, 6) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 6);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Chicken");
                        setPermission(p, "craftmanager.disguise.chicken");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 15) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_7.get()) { // 7.den
                    if (Main.getInstance().getSQL().checkDay(p, 7) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 7);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 100 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 46) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_8.get()) { // 8.den
                    if (Main.getInstance().getSQL().checkDay(p, 8) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 8);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Strider");
                        setPermission(p, "craftmanager.disguise.strider");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 36) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_9.get()) { // 9.den
                    if (Main.getInstance().getSQL().checkDay(p, 9) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 9);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 250 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 250);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 8) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_10.get()) { // 10.den
                    if (Main.getInstance().getSQL().checkDay(p, 10) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 10);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Dear Hat");
                        setPermission(p, "craftmanager.hats.dear_hat");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 26) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_11.get()) { // 11.den
                    if (Main.getInstance().getSQL().checkDay(p, 11) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 11);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Fox");
                        setPermission(p, "craftmanager.disguise.fox");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 52) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_12.get()) { // 12.den
                    if (Main.getInstance().getSQL().checkDay(p, 12) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 12);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Cow");
                        setPermission(p, "craftmanager.disguise.cow");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 5) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_13.get()) { // 13.den
                    if (Main.getInstance().getSQL().checkDay(p, 13) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 13);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 1 CraftToken");
                        CraftTokensAPI.giveTokens(p, 1);
                        p.closeInventory();
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 12) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_14.get()) { // 14.den
                    if (Main.getInstance().getSQL().checkDay(p, 14) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 14);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Goat");
                        setPermission(p, "craftmanager.disguise.goat");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 20) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_15.get()) { // 15.den
                    if (Main.getInstance().getSQL().checkDay(p, 15) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 15);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 100 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 44) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_16.get()) { // 16.den
                    if (Main.getInstance().getSQL().checkDay(p, 16) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 16);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Možný nákup -> Items - Ginger Pickaxe");
                        ChatInfo.INFO.send(p, "Pro získání odměny zajdi na vybraný server a v §e/cshop {c}v sekci sezoní odměny si zakup Ginger Pickaxe za SeasonPoints.");
                        SeasonPointsAPI.giveSeasonPoints(p, 1);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 30) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_17.get()) { // 17.den
                    if (Main.getInstance().getSQL().checkDay(p, 17) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 17);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 250 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 250);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 23) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_18.get()) { // 18.den
                    if (Main.getInstance().getSQL().checkDay(p, 18) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 18);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Morph - Magma Slime");
                        setPermission(p, "craftmanager.disguise.magma_slime");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 18) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_19.get()) { // 19.den
                    if (Main.getInstance().getSQL().checkDay(p, 19) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 19);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Snowman Hat");
                        setPermission(p, "craftmanager.hats.snowman_hat");
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 42) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_20.get()) { // 20.den
                    if (Main.getInstance().getSQL().checkDay(p, 20) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 20);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 250 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 250);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 48) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_21.get()) { // 21.den
                    if (Main.getInstance().getSQL().checkDay(p, 21) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 21);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 250 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 250);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 22) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_22.get()) { // 22.den
                    if (Main.getInstance().getSQL().checkDay(p, 22) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 22);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 250 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 250);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 25) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_23.get()) { // 23.den
                    if (Main.getInstance().getSQL().checkDay(p, 23) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 23);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 500 CraftCoins");
                        CraftCoinsAPI.giveCoins(p, 500);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 38) {
                if (System.currentTimeMillis() >= CalenderTimes.DAY_24.get()) { // 24.den
                    if (Main.getInstance().getSQL().checkDay(p, 24) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 24);
                        ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Možný nákup -> Items - Frost Bow");
                        ChatInfo.INFO.send(p, "Pro získání odměny zajdi na vybraný server a v §e/cshop {c}v sekci sezoní odměny si zakup Frost Bow za SeasonPoints.");
                        SeasonPointsAPI.giveSeasonPoints(p, 1);
                        p.closeInventory();
                        return;
                    } else {
                        ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                        p.closeInventory();
                        return;
                    }
                } else {
                    ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                    p.closeInventory();
                    return;
                }
            }
        }
        if (e.getSlot() == 0) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_25.get()) { // 25.den
                if (Main.getInstance().getSQL().checkDay(p, 25) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 25);
                    if (p.hasPermission("group.gold") || p.hasPermission("group.diamond") || p.hasPermission("group.emerald") || p.hasPermission("group.obsidian")) {
                        ChatInfo.INFO.send(p, "Jelikož již vlastníš nějaké VIP vyšší, nemůžeme ti aktivovat Gold VIP.");
                        ChatInfo.INFO.send(p, "Naopak jsi dostal 2 CraftTokeny a 1.000 CraftCoins!");
                        CraftCoinsAPI.giveCoins(p, 1000);
                        CraftTokensAPI.giveTokens(p, 2);
                        p.closeInventory();
                        return;
                    }
                    ChatInfo.INFO.send(p, "Byl ti aktivován speciální dárek: Global Gold VIP na 7 dní!");
                    setGlobalGold(p);
                    ChatInfo.SUCCESS.send(p, "Global Gold VIP [7 dní] bylo aktivováno.");
                    return;
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 6) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_26.get()) { // 26.den
                if (Main.getInstance().getSQL().checkDay(p, 26) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 26);
                    ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Možný nákup -> Items - Frost Sword");
                    ChatInfo.INFO.send(p, "Pro získání odměny zajdi na vybraný server a v §e/cshop {c}v sekci sezoní odměny si zakup Frost Sword za SeasonPoints.");
                    SeasonPointsAPI.giveSeasonPoints(p, 1);
                    p.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 16) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_27.get()) { // 27.den
                if (Main.getInstance().getSQL().checkDay(p, 27) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 27);
                    ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Silvester Glasses 2021 Edition");
                    setPermission(p, "craftmanager.hats.silvester_glasses_2021");
                    p.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 31) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_28.get()) { // 28.den
                if (Main.getInstance().getSQL().checkDay(p, 28) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 28);
                    ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 1 CraftToken");
                    CraftTokensAPI.giveTokens(p, 1);
                    p.closeInventory();
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 43) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_29.get()) { // 29.den
                if (Main.getInstance().getSQL().checkDay(p, 29) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 29);
                    ChatInfo.SUCCESS.send(p, "Získal(a) jsi: 500 CraftCoins");
                    CraftCoinsAPI.giveCoins(p, 500);
                    p.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 35) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_30.get()) { // 30.den
                if (Main.getInstance().getSQL().checkDay(p, 30) == 0) {
                    Main.getInstance().getSQL().addCalendarDay(p, 30);
                    ChatInfo.SUCCESS.send(p, "Získal(a) jsi: Cosmetics - Silvester Party Hat 2021 Edition");
                    setPermission(p, "craftmanager.hats.silvester_party_hat_2021");
                    p.closeInventory();
                    return;
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }

        if (e.getSlot() == 47) {
            if (System.currentTimeMillis() >= CalenderTimes.DAY_31.get()) { // 31.den
                if (Main.getInstance().getSQL().checkDay(p, 31) == 0) {
                    //TODO: Oznámení
                } else {
                    ChatInfo.DANGER.send(p, "Tuto odměnu jsi si již vybral(a).");
                    p.closeInventory();
                    return;
                }
            } else {
                ChatInfo.INFO.send(p, "Na výběr této odměny je příliš brzo.");
                p.closeInventory();
                return;
            }
        }
    }

    private void setPermission(Player p, String permission){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + permission + " true");
    }

    private void setGlobalGold(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add gold 7d");
    }

}
