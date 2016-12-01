package cz.wake.lobby.vanoce;

import cz.wake.lobby.API.TitleAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
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

        Inventory inv = Bukkit.createInventory(null, 54, "Kalendar");

        inv.setItem(2, canOpen(p, 1, 1480546800000L)); //Den 1.
        inv.setItem(40, canOpen(p, 2, 1480633200000L)); // Den 2.
        inv.setItem(28, canOpen(p, 3, 1480719600000L)); // Den 3.
        inv.setItem(9, canOpen(p, 4, 1480806000000L)); // Den 4
        inv.setItem(50, canOpen(p, 5, 1480892400000L)); // Den 5.
        inv.setItem(33, canOpen(p, 6, 1480978800000L));
        inv.setItem(15, canOpen(p, 7, 1481065200000L));
        inv.setItem(46, canOpen(p, 8, 1481151600000L));
        inv.setItem(36, canOpen(p, 9, 1481238000000L));
        inv.setItem(8, canOpen(p, 10, 1481324400000L));
        inv.setItem(26, canOpen(p, 11, 1481410800000L));
        inv.setItem(52, canOpen(p, 12, 1481497200000L));
        inv.setItem(5, canOpen(p, 13, 1481583600000L));
        inv.setItem(12, canOpen(p, 14, 1481670000000L));
        inv.setItem(20, canOpen(p, 15, 1481756400000L));
        inv.setItem(44, canOpen(p, 16, 1481842800000L));
        inv.setItem(30, canOpen(p, 17, 1481929200000L));
        inv.setItem(23, canOpen(p, 18, 1482015600000L));
        inv.setItem(18, canOpen(p, 19, 1482102000000L));
        inv.setItem(42, canOpen(p, 20, 1482188400000L));
        inv.setItem(48, canOpen(p, 21, 1482274800000L));
        inv.setItem(22, canOpen(p, 22, 1482361200000L));
        inv.setItem(25, canOpen(p, 23, 1482447600000L));
        inv.setItem(38, canOpen(p, 24, 1482534000000L));

        inv.setItem(0, glass());
        inv.setItem(1, glass());
        inv.setItem(3, glass());
        inv.setItem(4, glass());
        inv.setItem(6, glass());
        inv.setItem(7, glass());
        inv.setItem(10, glass());
        inv.setItem(11, glass());
        inv.setItem(13, glass());
        inv.setItem(14, glass());
        inv.setItem(16, glass());
        inv.setItem(17, glass());
        inv.setItem(19, glass());
        inv.setItem(21, glass());
        inv.setItem(24, glass());
        inv.setItem(27, glass());
        inv.setItem(29, glass());
        inv.setItem(31, glass());
        inv.setItem(32, glass());
        inv.setItem(34, glass());
        inv.setItem(35, glass());
        inv.setItem(37, glass());
        inv.setItem(39, glass());
        inv.setItem(41, glass());
        inv.setItem(43, glass());
        inv.setItem(45, glass());
        inv.setItem(47, glass());
        inv.setItem(49, glass());
        inv.setItem(51, glass());
        inv.setItem(53, glass());

        p.openInventory(inv);
    }

    private ItemStack glass() {
        return ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 13, " ");
    }

    private ItemStack canOpen(final Player p, final int day, final long time) {
        if (System.currentTimeMillis() > time) { // Kontrola zda muze otevrit tento den
            if (Main.getInstance().fetchData().checkDay(p, day) == 0) { // Kontrola zda uz otevrel
                ItemStack i = ranomHead("§e§l" + day + ". den");
                ItemMeta iM = i.getItemMeta();
                ArrayList<String> iMLore = new ArrayList();
                iMLore.add("§aKliknutim si vyberes odmenu!");
                iM.setLore(iMLore);
                i.setItemMeta(iM);
                i.setAmount(day);
                return i;
            } else {
                ItemStack i = ItemFactory.create(Material.BARRIER, (byte) 0, "§c§l" + day + ". den");
                ItemMeta iM = i.getItemMeta();
                ArrayList<String> iMLore = new ArrayList();
                iMLore.add("§7Jiz jsi otevrel tuto moznost!");
                iM.setLore(iMLore);
                i.setItemMeta(iM);
                i.setAmount(day);
                return i;
            }
        } else {
            ItemStack i = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 14, "§c§l" + day + ". den", "§7Jeste je brzo!");
            i.setAmount(day);
            return i;
        }
    }

    private ItemStack ranomHead(String name) {
        int sance = randRange(1, 100);
        if ((sance >= 1) && (sance <= 10)) { // Indigo
            return ItemFactory.createHead(name, "ce936179-5016-4926-8889-2c1705ef70d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmYyZDE4OTVmZmY0YjFiYjkxMTZjOGE5ZTIyOTU5N2Y2OWYzZWVlODgxMjI3NzZlNWY5NzMzNTdlNmIifX19");
        } else if ((sance >= 11) && (sance <= 20)) { // Light Blue
            return ItemFactory.createHead(name, "54a219b4-9a5f-45ed-80ff-8766d501588b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODRlMWM0MmYxMTM4M2I5ZGM4ZTY3ZjI4NDZmYTMxMWIxNjMyMGYyYzJlYzdlMTc1NTM4ZGJmZjFkZDk0YmI3In19fQ==");
        } else if ((sance >= 21) && (sance <= 30)) { // Grape
            return ItemFactory.createHead(name, "e174cc81-8646-4c48-afeb-d5fac7d24e16", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU3YjJlZTY1NmQ3Yjg2NWMzZmFkZDViMTQyOGMzNThkNDc2M2Y0MTc4YWM1OTlkNjA0ODY5YTE5ZDcifX19");
        } else if ((sance >= 31) && (sance <= 40)) { // Black
            return ItemFactory.createHead(name, "ee53f881-8b67-4604-bfb9-a43a6966eae2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM3MTJiMTk3MWM1ZjQyZWVmZjgwNTUxMTc5MjIwYzA4YjgyMTNlYWNiZTZiYzE5ZDIzOGMxM2Y4NmUyYzAifX19");
        } else if ((sance >= 41) && (sance <= 50)) { // Green
            return ItemFactory.createHead(name, "1ff80fcf-030e-447f-8b8d-b439963389b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY1YjUyYmRiMjU1NmZkN2Q0NmM1Yzg0OGEzOGM4YjhlZjE1M2FmZTdkNTZkYjE3NzZkOTliNTMzYmQwIn19fQ==");
        } else if ((sance >= 51) && (sance <= 60)) { // Gold
            return ItemFactory.createHead(name, "91df0725-c04d-4776-b9e7-01dad0ea6d5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NjUyYmZkYjdhZGRlMTI4ZTdlYWNjNTBkMTZlYjlmNDg3YTMyMDliMzA0ZGUzYjk2OTdjZWJmMTMzMjNiIn19fQ==");
        } else if ((sance >= 61) && (sance <= 70)) { // Red
            return ItemFactory.createHead(name, "dd7514ca-c10f-4389-9c14-78d2feae91b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjczYTIxMTQxMzZiOGVlNDkyNmNhYTUxNzg1NDE0MDM2YTJiNzZlNGYxNjY4Y2I4OWQ5OTcxNmM0MjEifX19");
        } else if ((sance >= 71) && (sance <= 80)) { // Gray
            return ItemFactory.createHead(name, "d08a119e-2aeb-48be-b14c-b3aa6b73af60", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWMzODIxZDRmNjFiMTdmODJmMGQ3YThlNTMxMjYwOGZmNTBlZGUyOWIxYjRkYzg5ODQ3YmU5NDI3ZDM2In19fQ==");
        } else if ((sance >= 81) && (sance <= 90)) { // Pink
            return ItemFactory.createHead(name, "c04fdca4-1221-49b2-b29d-f6622478dbbc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTBjNzVhMDViMzQ0ZWEwNDM4NjM5NzRjMTgwYmE4MTdhZWE2ODY3OGNiZWE1ZTRiYTM5NWY3NGQ0ODAzZDFkIn19fQ==");
        } else if ((sance >= 91) && (sance <= 100)) { // Dark Orange
            return ItemFactory.createHead(name, "13e135fb-348f-4c6a-99e3-e6e3aa385e73", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTI4ZTY5MmQ4NmUyMjQ0OTc5MTVhMzk1ODNkYmUzOGVkZmZkMzljYmJhNDU3Y2M5NWE3YWMzZWEyNWQ0NDUifX19");
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
        if (e.getInventory().getTitle().equals("Kalendar")) {
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
                if (System.currentTimeMillis() >= 1480546800000L) { // 1.Den
                    if (Main.getInstance().fetchData().checkDay(p, 1) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 1);
                        p.sendMessage("§eZiskal jsi: §bFunCannon Ice Gagdet!");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bFunCannon Ice Gagdet");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.gadgets.funcannon.ender");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 40) {
                if (System.currentTimeMillis() >= 1480633200000L) { // 2.Den
                    if (Main.getInstance().fetchData().checkDay(p, 2) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 2);
                        p.sendMessage("§eZiskal jsi: §bSanta Heads + 100CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Heads + 100CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.santa");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.piratesanta");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 100");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 28) {
                if (System.currentTimeMillis() >= 1480719600000L) { // 3.Den
                    if (Main.getInstance().fetchData().checkDay(p, 3) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 3);
                        p.sendMessage("§eZiskal jsi: §bSanta Cloak + 100CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Cloak + 100CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.cloaks.santa");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 100");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 9) {
                if (System.currentTimeMillis() >= 1480806000000L) { // 4.Den
                    if (Main.getInstance().fetchData().checkDay(p, 4) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 4);
                        p.sendMessage("§eZiskal jsi: §b1000CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§b1000CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 1000");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 50) {
                if (System.currentTimeMillis() >= 1480892400000L) { // 5.den
                    // Event!
                    return;
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 33) {
                if (System.currentTimeMillis() >= 1480978800000L) { // 6.den
                    if (Main.getInstance().fetchData().checkDay(p, 6) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 6);
                        p.sendMessage("§eZiskal jsi: §bElfBoy & ElfGirl Heads");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bElfBoy & ElfGirl Heads");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.elfboy");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.elfgirl");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 15) {
                if (System.currentTimeMillis() >= 1481065200000L) { // 7.den
                    if (Main.getInstance().fetchData().checkDay(p, 7) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 7);
                        p.sendMessage("§eZiskal jsi: §bSnowman Pet");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSnowman Pet");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.snowman");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 46) {
                if (System.currentTimeMillis() >= 1481151600000L) { // 8.den
                    if (Main.getInstance().fetchData().checkDay(p, 8) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 8);
                        p.sendMessage("§eZiskal jsi: §bSnowglobe Heads + 200CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSnowglobe Heads + 200CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.snowglobe");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.snowglobe2");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 200");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 36) {
                if (System.currentTimeMillis() >= 1481238000000L) { // 9.den
                    if (Main.getInstance().fetchData().checkDay(p, 9) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 9);
                        p.sendMessage("§eZiskal jsi: §bPresent Heads + 200CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bPresent Heads + 200CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftloby.heads.vanocni.blackpresent");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.bluepresent");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.greenpresent");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.goldpresent");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 200");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 8) {
                if (System.currentTimeMillis() >= 1481324400000L) { // 10.den
                    // Event
                    return;
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 26) {
                if (System.currentTimeMillis() >= 1481410800000L) { // 11.den
                    if (Main.getInstance().fetchData().checkDay(p, 11) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 11);
                        p.sendMessage("§eZiskal jsi: §bFire Trail Gadget");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bFire Trail Gadget");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.gadgets.firetrail");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 52) {
                if (System.currentTimeMillis() >= 1481497200000L) { // 12.den
                    if (Main.getInstance().fetchData().checkDay(p, 12) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 12);
                        p.sendMessage("§eZiskal jsi: §bHorse White Pet");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bHorse White Pet");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.horse.white");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.horse.white.baby");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 5) {
                if (System.currentTimeMillis() >= 1481583600000L) { // 13.den
                    if (Main.getInstance().fetchData().checkDay(p, 13) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 13);
                        p.sendMessage("§eZiskal jsi: §b200CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§b200CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 200");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 12) {
                if (System.currentTimeMillis() >= 1481670000000L) { // 14.den
                    if (Main.getInstance().fetchData().checkDay(p, 14) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 14);
                        p.sendMessage("§eZiskal jsi: §bAngel Cloak");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bAngel Cloak");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.cloaks.angel");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 20) {
                if (System.currentTimeMillis() >= 1481756400000L) { // 15.den
                    // Event
                    return;
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 44) {
                if (System.currentTimeMillis() >= 1481842800000L) { // 16.den
                    if (Main.getInstance().fetchData().checkDay(p, 16) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 16);
                        p.sendMessage("§eZiskal jsi: §bSanta Hat Particles");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Hat Particles");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.particles.santahat");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 30) {
                if (System.currentTimeMillis() >= 1481929200000L) { // 17.den
                    if (Main.getInstance().fetchData().checkDay(p, 17) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 17);
                        p.sendMessage("§eZiskal jsi: §bCreeper Pet");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bCreeper Pet");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.creeper");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 23) {
                if (System.currentTimeMillis() >= 1482015600000L) { // 18.den
                    if (Main.getInstance().fetchData().checkDay(p, 18) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 18);
                        p.sendMessage("§eZiskal jsi: §bCandy Cane Particles");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bCandy Cane Particles");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.particles.candycane");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 18) {
                if (System.currentTimeMillis() >= 1482102000000L) { // 19.den
                    if (Main.getInstance().fetchData().checkDay(p, 19) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 19);
                        p.sendMessage("§eZiskal jsi: §bPolar Bear Pet");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bPolar Bear Pet");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.polarbear");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 42) {
                if (System.currentTimeMillis() >= 1482188400000L) { // 20.den
                    // Event
                    return;
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 48) {
                if (System.currentTimeMillis() >= 1482274800000L) { // 21.den
                    if (Main.getInstance().fetchData().checkDay(p, 21) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 21);
                        p.sendMessage("§eZiskal jsi: §bSob + CommandBlock + Snowman Head");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSob + CommandBlock + Snowman Head");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.sob");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.snowman");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.heads.vanocni.commandblock");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 22) {
                if (System.currentTimeMillis() >= 1482274800000L) { // 22.den
                    if (Main.getInstance().fetchData().checkDay(p, 22) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 22);
                        p.sendMessage("§eZiskal jsi: §bDiamondFountain Gadget");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bDiamondFountain Gadget");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.gadgets.diamondfountain");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 25) {
                if (System.currentTimeMillis() >= 1482447600000L) { // 23.den
                    if (Main.getInstance().fetchData().checkDay(p, 23) == 0) {
                        Main.getInstance().fetchData().addCalendarDay(p, 23);
                        p.sendMessage("§eZiskal jsi: §b500CC");
                        TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§b500CC");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 500");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 38) {
                if (System.currentTimeMillis() >= 1482534000000L) {
                    // Event
                    return;
                } else {
                    p.sendMessage("§cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
        }
    }

}
