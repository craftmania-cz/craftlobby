package cz.wake.lobby.seasons.christmas;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
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

    //TODO: Questy
    //TODO: Kocka hazejici rybu, sheep s oveckou, netopyr, parrot jako pet*, wake jako moprh, dog s dogem, kure kadici vejce

    public void openKalendar(final Player p) {

        if (Main.getInstance().getSQL().getPlayerProfileDataIntNoUUID(p, "played_time") < 180) {
            p.sendMessage("§c§l[!] §cAby jsi si mohl vybrat odmenu, musis mit odehrane aspon 3 hodiny na serveru! :)");
            return;
        }

        Inventory inv = Bukkit.createInventory(null, 54, "Kalendar");

        inv.setItem(2, canOpen(p, 1, 1512082800000L)); //Den 1.
        inv.setItem(40, canOpen(p, 2, 1512169200000L)); // Den 2.
        inv.setItem(28, canOpen(p, 3, 1512255600000L)); // Den 3.
        inv.setItem(9, canOpen(p, 4, 1512342000000L)); // Den 4
        inv.setItem(50, canOpen(p, 5, 1512428400000L)); // Den 5.
        inv.setItem(33, canOpen(p, 6, 1512514800000L));
        inv.setItem(15, canOpen(p, 7, 1512601200000L));
        inv.setItem(46, canOpen(p, 8, 1512687600000L));
        inv.setItem(36, canOpen(p, 9, 1512774000000L));
        inv.setItem(8, canOpen(p, 10, 1512860400000L));
        inv.setItem(26, canOpen(p, 11, 1512946800000L));
        inv.setItem(52, canOpen(p, 12, 1513033200000L));
        inv.setItem(5, canOpen(p, 13, 1513033200000L));
        inv.setItem(12, canOpen(p, 14, 1513206000000L));
        inv.setItem(20, canOpen(p, 15, 1513292400000L));
        inv.setItem(44, canOpen(p, 16, 1513378800000L));
        inv.setItem(30, canOpen(p, 17, 1513465200000L));
        inv.setItem(23, canOpen(p, 18, 1513551600000L));
        inv.setItem(18, canOpen(p, 19, 1513638000000L));
        inv.setItem(42, canOpen(p, 20, 1513724400000L));
        inv.setItem(48, canOpen(p, 21, 1513810800000L));
        inv.setItem(22, canOpen(p, 22, 1513897200000L));
        inv.setItem(25, canOpen(p, 23, 1513983600000L));
        inv.setItem(38, canOpen(p, 24, 1514070000000L));

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
                System.out.println("this?");
                if (System.currentTimeMillis() >= 1543618800000L) { // 1.Den
                    System.out.println("this 2?");
                    if (Main.getInstance().getSQL().checkDay(p, 1) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 1);
                        p.sendMessage("§eZiskal jsi: §bEnderman Pet + 100 CC");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bEnderman Pet + 100 CC");
                        setPermission(p,"craftlobby.pets.enderman");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 40) {
                if (System.currentTimeMillis() >= 1543705200000L) { // 2.Den
                    if (Main.getInstance().getSQL().checkDay(p, 2) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 2);
                        p.sendMessage("§eZiskal jsi: §bSanta Heads + 150 CC");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Heads + 100CC");
                        setPermission(p, "craftlobby.heads.vanocni.piratesanta");
                        setPermission(p, "craftlobby.heads.vanocni.santa");
                        CraftCoinsAPI.giveCoins(p, 150);
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 28) {
                if (System.currentTimeMillis() >= 1543791600000L) { // 3.Den
                    if (Main.getInstance().getSQL().checkDay(p, 3) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 3);
                        p.sendMessage("§eZiskal jsi: §bSanta Cloak + 200 CC");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Cloak + 200 CC");
                        setPermission(p, "craftlobby.cloaks.santa");
                        CraftCoinsAPI.giveCoins(p, 200);
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 9) {
                if (System.currentTimeMillis() >= 1543878000000L) { // 4.Den
                    if (Main.getInstance().getSQL().checkDay(p, 4) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 4);
                        CraftCoinsAPI.giveCoins(p, 100);
                        setPermission(p, "craftlobby.morphs.snowman");
                        p.sendMessage("§eZiskal jsi: §b100 CC");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSnowman Morph + 100 CC");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 50) {
                if (System.currentTimeMillis() >= 1543964400000L) { // 5.den
                    if (Main.getInstance().getSQL().checkDay(p, 5) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 5);
                        p.sendMessage("§eZiskal jsi: §bElfBoy & ElfGirl Heads");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bElfBoy & ElfGirl Heads");
                        setPermission(p, "craftlobby.heads.vanocni.elfboy");
                        setPermission(p, "craftlobby.heads.vanocni.elfgirl");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 33) {
                if (System.currentTimeMillis() >= 1544050800000L) { // 6.den
                    if (Main.getInstance().getSQL().checkDay(p, 6) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 6);
                        p.sendMessage("§eZiskal jsi: §bSnowman Pet");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSnowman Pet + 100 CC");
                        setPermission(p,"craftlobby.pets.snowman");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 15) {
                if (System.currentTimeMillis() >= 1544137200000L) { // 7.den
                    if (Main.getInstance().getSQL().checkDay(p, 7) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 7);
                        p.sendMessage("§eZiskal jsi: §bChicken Morph + 150 CC + 1 CT");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bChicken Morph + 150 CC + 1 CT");
                        CraftCoinsAPI.giveCoins(p, 150);
                        CraftTokensAPI.giveTokens(p, 1);
                        setPermission(p, "craftlobby.morphs.chicken");
                        p.closeInventory();
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 46) {
                if (System.currentTimeMillis() >= 1544223600000L) { // 8.den
                    if (Main.getInstance().getSQL().checkDay(p, 8) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 8);
                        p.sendMessage("§eZiskal jsi: §bSnowglobe Heads");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSnowglobe Heads");
                        setPermission(p, "craftlobby.heads.vanocni.snowglobe");
                        setPermission(p, "craftlobby.heads.vanocni.snowglobe2");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 36) {
                if (System.currentTimeMillis() >= 1544310000000L) { // 9.den
                    if (Main.getInstance().getSQL().checkDay(p, 9) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 9);
                        p.sendMessage("§eZiskal jsi: §bPresent Heads + 200 CC");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bPresent Heads + 200 CC");
                        CraftCoinsAPI.giveCoins(p, 200);
                        setPermission(p, "craftloby.heads.vanocni.blackpresent");
                        setPermission(p, "craftlobby.heads.vanocni.bluepresent");
                        setPermission(p, "craftlobby.heads.vanocni.greenpresent");
                        setPermission(p, "craftlobby.heads.vanocni.goldpresent");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 8) {
                if (System.currentTimeMillis() >= 1544396400000L) { // 10.den
                    if (Main.getInstance().getSQL().checkDay(p, 10) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 10);
                        p.sendMessage("§eZiskal jsi: §bBlood Helix Particles");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bBlood Helix Particles");
                        setPermission(p, "craftlobby.particles.bloodhelix");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 26) {
                if (System.currentTimeMillis() >= 1544482800000L) { // 11.den
                    if (Main.getInstance().getSQL().checkDay(p, 11) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 11);
                        p.sendMessage("§eZiskal jsi: §bHorse White Pet");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bHorse White Pet");
                        setPermission(p, "craftlobby.pets.horse.white");
                        setPermission(p, "craftlobby.pets.horse.white.baby");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 52) {
                if (System.currentTimeMillis() >= 1544569200000L) { // 12.den
                    if (Main.getInstance().getSQL().checkDay(p, 12) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 12);
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bIronGolem Morph + 200 CC");
                        CraftCoinsAPI.giveCoins(p, 200);
                        setPermission(p, "craftlobby.morphs.irongolem");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 5) {
                if (System.currentTimeMillis() >= 1544655600000L) { // 13.den
                    if (Main.getInstance().getSQL().checkDay(p, 13) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 13);
                        p.sendMessage("§eZiskal jsi: §bAngel Cloak");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bAngel Cloak");
                        setPermission(p, "craftlobby.cloaks.angel");
                        p.closeInventory();
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 12) {
                if (System.currentTimeMillis() >= 1544742000000L) { // 14.den
                    if (Main.getInstance().getSQL().checkDay(p, 14) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 14);
                        p.sendMessage("§eZiskal jsi: §bVsechny Bannery v Gagdets");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bVsechny Bannery");
                        setPermission(p, "craftlobby.banner.*");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 20) {
                if (System.currentTimeMillis() >= 1544828400000L) { // 15.den
                    if (Main.getInstance().getSQL().checkDay(p, 15) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 15);
                        p.sendMessage("§eZiskal jsi: §bAntiGravity Gadget");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bAntiGravity Gadget + 100 CC");
                        setPermission(p, "craftlobby.gadget.antigravity");
                        CraftCoinsAPI.giveCoins(p, 100);
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 44) {
                if (System.currentTimeMillis() >= 1544914800000L) { // 16.den
                    if (Main.getInstance().getSQL().checkDay(p, 16) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 16);
                        p.sendMessage("§eZiskal jsi: §bSanta Hat Particles");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSanta Hat Particles");
                        setPermission(p, "craftlobby.particles.santahat");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 30) {
                if (System.currentTimeMillis() >= 1545001200000L) { // 17.den
                    if (Main.getInstance().getSQL().checkDay(p, 17) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 17);
                        p.sendMessage("§eZiskal jsi: §6Evoker + Vex Pets");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§6Evoker + Vex Pets");
                        setPermission(p, "craftlobby.pets.evoker");
                        setPermission(p, "craftlobby.pets.vex");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 23) {
                if (System.currentTimeMillis() >= 1545087600000L) { // 18.den
                    if (Main.getInstance().getSQL().checkDay(p, 18) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 18);
                        p.sendMessage("§eZiskal jsi: §bCandy Cane Particles");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bCandy Cane Particles");
                        setPermission(p, "craftlobby.particles.candycane");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 18) {
                if (System.currentTimeMillis() >= 1545174000000L) { // 19.den
                    if (Main.getInstance().getSQL().checkDay(p, 19) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 19);
                        p.sendMessage("§eZiskal jsi: §bPolar Bear Pet");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bPolar Bear Pet");
                        setPermission(p, "craftlobby.pets.polarbear");
                        setPermission(p, "craftlobby.pets.polarbear.baby");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 42) {
                if (System.currentTimeMillis() >= 1545260400000L) { // 20.den
                    if (Main.getInstance().getSQL().checkDay(p, 20) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 20);
                        p.sendMessage("§eZiskal jsi: §bDevil Cloak");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bDevil Cloak");
                        setPermission(p, "craftlobby.cloaks.devil");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 48) {
                if (System.currentTimeMillis() >= 1545346800000L) { // 21.den
                    if (Main.getInstance().getSQL().checkDay(p, 21) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 21);
                        p.sendMessage("§eZiskal jsi: §bSob + CommandBlock + Snowman Head");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bSob + CommandBlock + Snowman Head");
                        setPermission(p, "craftlobby.heads.vanocni.sob");
                        setPermission(p, "craftlobby.heads.vanocni.snowman");
                        setPermission(p, "craftlobby.heads.vanocni.commandblock");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 22) {
                if (System.currentTimeMillis() >= 1545433200000L) { // 22.den
                    if (Main.getInstance().getSQL().checkDay(p, 22) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 22);
                        p.sendMessage("§eZiskal jsi: §cLlama Pets");
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§cLlama Pets");
                        setPermission(p, "craftlobby.pets.llama.*");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 25) {
                if (System.currentTimeMillis() >= 1545519600000L) { // 23.den
                    if (Main.getInstance().getSQL().checkDay(p, 23) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 23);
                        p.sendMessage("§e§l[*] §eZiskal jsi: §b500CC + Vsechny Heads!");
                        CraftCoinsAPI.giveCoins(p, 500);
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§b500 CC");
                        setPermission(p, "craftlobby.heads.*");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
            if (e.getSlot() == 38) {
                if (System.currentTimeMillis() >= 1545606000000L) { // 24.den
                    if (Main.getInstance().getSQL().checkDay(p, 24) == 0) {
                        Main.getInstance().getSQL().addCalendarDay(p, 24);
                        p.sendMessage("§e§l[*] §eZiskal jsi: §b3000CC + hoodne Pets!");
                        CraftTokensAPI.giveTokens(p, 1);
                        CraftCoinsAPI.giveCoins(p, 3000);
                        //TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", "§bHoodne Pets + 3 000 CC + 1 CT!");
                        setPermission(p, "craftlobby.pets.slime.*");
                        setPermission(p, "craftlobby.pets.slime");
                        setPermission(p, "craftlobby.pets.zombie.*");
                        setPermission(p, "craftlobby.pets.zombie");
                        setPermission(p, "craftlobby.pets.cat.*");
                        setPermission(p, "craftlobby.pets.villager.*");
                        p.closeInventory();
                        return;
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral/a!");
                        p.closeInventory();
                        return;
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny je prilis brzo!");
                    p.closeInventory();
                    return;
                }
            }
        }
    }

    private void setPermission(Player p, String permission){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + permission + " true");
    }

}
