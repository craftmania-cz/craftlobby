package cz.wake.lobby.manager;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
import cz.craftmania.crafteconomy.api.VoteTokensAPI;
import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

//TODO: Rewrite tohoto prehistorického systému
public class RewardsManager implements Listener {

    public void openRewardManager(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 45, "Odmeny pro hrace");

        if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_daily_bonus") == 0) {
            ItemStack weekOdmena = new ItemBuilder(Material.CHEST_MINECART).setName("§b§lDenni odmena").setLore("§81x za 24 hodin", "", "§7Odmena pro kazdeho na serveru", "§7kazdy den!", "", "§eDostanes: §650 CC", "", "§aKliknutim vyberes odmenu!").build();
            inv.setItem(20, weekOdmena);
        } else {
            ItemStack weekOdmena = new ItemBuilder(Material.MINECART).setName("§b§lDenni odmena").setLore("§81x za 24 hodin", "",
                    "§7Odmenu sis jiz vybral.", "§7Prijd zase zitra.", "", "§eDostanes: §630 CC", "", "§cDalsi vyber kazdych 24h").build();
                    inv.setItem(20, weekOdmena);
        }
        if (p.hasPermission("craftlobby.vip.odmena")) {
            if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_vip_bonus") == 0) {
                if (p.hasPermission("craftlobby.vip.odmena.obsidian")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.CHEST_MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §9Obsidian!", "", "§eDostanes: §62000 CC", "", "§aKliknutim vyberes odmenu!").build();
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.CHEST_MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §aEmerald!", "", "§eDostanes: §61500 CC", "", "§aKliknutim vyberes odmenu!").build();
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.CHEST_MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §bDiamond!", "", "§eDostanes: §61000 CC", "", "§aKliknutim vyberes odmenu!").build();
                    inv.setItem(21, vipOdmena);
                } else {
                    ItemStack vipOdmena = new ItemBuilder(Material.CHEST_MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni §6Gold!", "", "§eDostanes: §6500 CC", "", "§aKliknutim vyberes odmenu!").build();
                    inv.setItem(21, vipOdmena);
                }
            } else {
                if (p.hasPermission("craftlobby.vip.odmena.obsidian")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmenu sis jiz vybral,", "§eDostanes: §62000 CC", "", "§cDalsi vyber je mozny az pristi mesic.").build();
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmenu sis jiz vybral,", "§eDostanes: §61500C CC", "", "§cDalsi vyber je mozny az pristi mesic.").build();
                    inv.setItem(21, vipOdmena);
                } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
                    ItemStack vipOdmena = new ItemBuilder(Material.MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmenu sis jiz vybral,", "§eDostanes: §61000C CC", "", "§cDalsi vyber je mozny az pristi mesic.").build();
                    inv.setItem(21, vipOdmena);
                } else {
                    ItemStack vipOdmena = new ItemBuilder(Material.MINECART).setName("§b§lVIP Bonus").setLore("§81x kazdy mesic", "",
                            "§7Odmenu sis jiz vybral,", "§eDostanes: §6500 CC", "", "§cDalsi vyber je mozny az pristi mesic.").build();
                    inv.setItem(21, vipOdmena);
                }
            }
        } else {
            ItemStack vipOdmena = new ItemBuilder(Material.BARRIER).setName("§c§lVIP Bonus").setLore("§81x kazdy mesic", "",
                    "§7Odmena pro kazdeho,", "§7kdo si zakoupil globalni VIP!", "", "§eDostanes: §61000-4000 CC", "", "§cNemas zakoupene VIP!").build();
            inv.setItem(21, vipOdmena);
        }

        if (!p.hasPermission("craftmanager.hats.tiger_head")) {
            ItemStack cosmeticReward = new ItemBuilder(Material.HORSE_SPAWN_EGG).setName("§6§lCosmetic Reward 2021/9").setLore("§7Kliknutím si odemkneš na serverech:", "§8- §fTiger čepici v §a/cosmetics", "", "§eKlikni pro výběr odměny!").build();
            inv.setItem(22, cosmeticReward);
        } else {
            ItemStack vipOdmena = new ItemBuilder(Material.BARRIER).setName("§c§lCosmetic Reward 2021/9").setLore("§7Odměnu jsi si již vybral(a).").build();
            inv.setItem(22, vipOdmena);
        }

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
        if (e.getView().getTitle().equals("Odmeny pro hrace")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 20) {
                if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_daily_bonus") == 0) {
                    p.sendMessage("§e§l[*] §eVybral jsi si denni odmenu §630 CC");
                    Main.getInstance().getSQL().updateRewardRecord(p, "lobby_daily_bonus");
                    CraftCoinsAPI.giveCoins(p, 30);
                    p.closeInventory();
                } else {
                    p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral!");
                }
            }
            if (e.getSlot() == 21) {
                if (p.hasPermission("craftlobby.vip.odmena")) {
                    if (Main.getInstance().getSQL().hasActiveReward(p, "lobby_vip_bonus") == 0) {
                        if(p.hasPermission("craftlobby.vip.odmena.obsidian")) {
                            p.sendMessage("§e§l[*] §eVybral jsi si VIP bonus §62000 CC");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vip_bonus");
                            CraftCoinsAPI.giveCoins(p, 2000);
                        } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
                            p.sendMessage("§e§l[*] §eVybral jsi si VIP bonus §61500 CC");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vip_bonus");
                            CraftCoinsAPI.giveCoins(p, 1500);
                        } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
                            p.sendMessage("§e§l[*] §eVybral jsi si VIP bonus §61000 CC");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vip_bonus");
                            CraftCoinsAPI.giveCoins(p, 1000);
                        } else {
                            p.sendMessage("§e§l[*] §eVybral jsi si VIP bonus §6500 CC");
                            Main.getInstance().getSQL().updateRewardRecord(p, "lobby_vip_bonus");
                            CraftCoinsAPI.giveCoins(p, 500);
                        }
                        p.closeInventory();
                    } else {
                        p.sendMessage("§c§l[!] §cTuto odmenu jsi si jiz vybral!");
                    }
                } else {
                    p.sendMessage("§c§l[!] §cNa vyber teto odmeny musis mit zakoupene globalni VIP!");
                }
            }

            if (e.getSlot() == 22) {
                if (!p.hasPermission("craftmanager.hats.tiger_head")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set craftmanager.hats.tiger_head");
                    p.sendMessage("§e§l[!] §eOdemkl jsi si Cosmetic Odměnu 2021/9!");
                    p.closeInventory();
                } else {
                    p.sendMessage("§c§l[!] §cOdměnu jsi si již vybral(a).");
                }
            }
        }
    }
}
