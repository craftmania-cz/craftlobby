package cz.wake.lobby.manager;

import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.characters.Bonusy;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

public class RewardsManager implements Listener {

    public void openRewardManager(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 45, "Odmeny pro hrace");

        if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_denniodmena") == 0) {
            ItemStack weekOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lDenni odmena", "§81x za 24 hodin", "",
                    "§7Odmena pro kazdeho na serveru", "§7kazdy den!", "", "§eDostanes: §650 CC", "", "§aKliknutim vyberes odmenu!");
            inv.setItem(20, weekOdmena);
        } else {
            ItemStack weekOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§b§lDenni odmena", "§81x za 24 hodin", "",
                    "§7Odmenu sis jiz vybral.", "§7Prijd zase zitra.", "", "§eDostanes: §650 CC", "", "§cDalsi vyber kazdych 24h");
            inv.setItem(20, weekOdmena);
        }
        if (p.hasPermission("craftlobby.vip.odmena")) {
            if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_vipodmena") == 0) {
                if(p.hasPermission("craftlobby.vip.odmena.obsidian")) {
                    ItemStack vipOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lVIP Bonus", "§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §9Obsidian!", "", "§eDostanes: §64000 CC", "", "§aKliknutim vyberes odmenu!");
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
                    ItemStack vipOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lVIP Bonus", "§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §aEmerald!", "", "§eDostanes: §63000 CC", "", "§aKliknutim vyberes odmenu!");
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
                    ItemStack vipOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lVIP Bonus", "§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §bDiamond!", "", "§eDostanes: §62000 CC", "", "§aKliknutim vyberes odmenu!");
                    inv.setItem(21, vipOdmena);
                } else {
                    ItemStack vipOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lVIP Bonus", "§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §6Gold!", "", "§eDostanes: §61000 CC", "", "§aKliknutim vyberes odmenu!");
                    inv.setItem(21, vipOdmena);
                }
            } else {
                ItemStack vipOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§b§lVIP Bonus", "§81x kazdy mesic", "",
                        "§7Odmenu sis jiz vybral,", "§eDostanes: §62000 CC", "", "§cDalsi vyber je mozny az pristi mesic.");
                inv.setItem(21, vipOdmena);
            }
        } else {
            ItemStack vipOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§c§lVIP Bonus", "§81x kazdy mesic", "",
                    "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni VIP!", "", "§eDostanes: §61000-4000 CC", "§eDostanes: §61-4 CT", "", "§cNemas zakoupene VIP!");
            inv.setItem(21, vipOdmena);
        }

        ItemStack vipGadgets = ItemFactory.create(Material.BARRIER, (byte) 0, "§c§lMVIP Gadgets", "§7Planovano...");
        ItemStack fbLike = ItemFactory.create(Material.BARRIER, (byte) 0, "§c§lLike na nasi FB Page", "§7Planovano...");
        ItemStack discord = ItemFactory.create(Material.BARRIER, (byte) 0, "§c§lPripojeni na Discord", "§7Planovano...");


        inv.setItem(22, vipGadgets);
        inv.setItem(23, fbLike);
        inv.setItem(24, discord);

        p.openInventory(inv);
    }

    // TODO: Pridat do craftcore
    private static String getDurationBreakdown(long millis) {
        StringBuilder sb = new StringBuilder(64);
        if (millis < 0) {
            sb.append("..."); // Pokud je jiz za terminem noveho vyberu...
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        if (days >= 1) {
            sb.append(days);
            sb.append(" dni ");
        }
        if (hours >= 1) {
            sb.append(hours);
            sb.append("h ");
        }
        sb.append(minutes);
        sb.append("m ");
        sb.append(seconds);
        sb.append("s");

        return (sb.toString());
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Odmeny pro hrace")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 20) {
                if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_denniodmena") == 0) {
                    p.sendMessage("§eVybral jsi si denni odmenu §650 CC");
                    Main.getInstance().getSQL().updateRewardRecord(p, "lobby_denniodmena");
                    //Main.getInstance().setData().addCoins(p, 50);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 50");
                    Bonusy b = new Bonusy();
                    b.playEffect(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTuto odmenu jsi si jiz vybral!");
                }
            }
            if (e.getSlot() == 21) {
                if (p.hasPermission("craftlobby.vip.odmena")) {
                    if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_vipodmena") == 0) {
                        if(p.hasPermission("craftlobby.vip.odmena.obsidian")) {
                            p.sendMessage("§eVybral jsi si VIP bonus §64000 CC §ea §64 CT");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vipodmena");
                            CraftCoinsAPI.giveCoins(p, 4000);
                            CraftTokensAPI.giveTokens(p, 4);
                        } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
                            p.sendMessage("§eVybral jsi si VIP bonus §63000 CC §ea §62 CT");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vipodmena");
                            CraftCoinsAPI.giveCoins(p, 3000);
                            CraftTokensAPI.giveTokens(p, 2);
                        } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
                            p.sendMessage("§eVybral jsi si VIP bonus §62000 CC §ea §62 CT");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vipodmena");
                            CraftCoinsAPI.giveCoins(p, 2000);
                            CraftTokensAPI.giveTokens(p, 2);
                        } else {
                            p.sendMessage("§eVybral jsi si VIP bonus §62000 CC §ea §61 CT");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vipodmena");
                            CraftCoinsAPI.giveCoins(p, 2000);
                            CraftTokensAPI.giveTokens(p, 1);
                        }
                        Bonusy b = new Bonusy();
                        b.playEffect(p);
                        p.closeInventory();
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral!");
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny musis mit zakoupene globalni VIP!");
                }
            }
        }
    }
}
