package cz.wake.lobby.manager;

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

        if (Main.getInstance().setData().hasActiveReward(p, "lobby_denniodmena") == 0) {
            ItemStack weekOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lDenni odmena", "§81x za 24 hodin", "",
                    "§7Odmena pro kazdeho na serveru", "§7kazdy den!", "", "§eDostanes: §650 CC", "", "§aKliknutim vyberes odmenu!");
            inv.setItem(20, weekOdmena);
        } else {
            ItemStack weekOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§b§lDenni odmena", "§81x za 24 hodin", "",
                    "§7Odmena pro kazdeho na serveru", "§7kazdy den!", "", "§eDostanes: §650 CC", "", dalsiOdmena(4));
            inv.setItem(20, weekOdmena);
        }
        if (p.hasPermission("craftlobby.vip.odmena")) {
            if (Main.getInstance().setData().hasActiveReward(p, "lobby_vipodmena") == 0) {
                ItemStack vipOdmena = ItemFactory.create(Material.STORAGE_MINECART, (byte) 0, "§b§lMVIP Bonus", "§81x kazdy mesic", "",
                        "§7Odmena pro kazdeho,", "§7kdo si zakoupil MVIP!", "", "§eDostanes: §62000 CC", "", "§aKliknutim vyberes odmenu!");
                inv.setItem(21, vipOdmena);
            } else {
                ItemStack vipOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§b§lMVIP Bonus", "§81x kazdy mesic", "",
                        "§7Odmena pro kazdeho,", "§7kdo si zakoupil MVIP!", "", "§eDostanes: §62000 CC", "", dalsiOdmena(5));
                inv.setItem(21, vipOdmena);
            }
        } else {
            ItemStack vipOdmena = ItemFactory.create(Material.MINECART, (byte) 0, "§c§lMVIP Bonus", "§81x kazdy mesic", "",
                    "§7Odmena pro kazdeho,", "§7kdo si zakoupil MVIP!", "", "§eDostanes: §62000 CC", "", "§cNemas zakoupene MVIP!");
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

    private String dalsiOdmena(int id) {
        long next = Main.getInstance().setData().getNextRewardReset(id) - System.currentTimeMillis();
        return "§cDalsi vyber za " + getDurationBreakdown(next);
    }

    public static String getDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
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
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Odmeny pro hrace")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 20) {
                if (Main.getInstance().setData().hasActiveReward(p, "lobby_denniodmena") == 0) {
                    p.sendMessage("§eVybral jsi si denni odmenu §650 CC");
                    Main.getInstance().setData().updateRewardRecord(p, "lobby_denniodmena");
                    Main.getInstance().setData().addCoins(p, 50);
                    Bonusy b = new Bonusy();
                    b.playEffect(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTuto odmenu jsi si jiz vybral!");
                }
            }
            if (e.getSlot() == 21) {
                if (p.hasPermission("craftlobby.vip.odmena")) {
                    if (Main.getInstance().setData().hasActiveReward(p, "lobby_vipodmena") == 0) {
                        p.sendMessage("§eVybral jsi si MVIP bonus §62000 CC");
                        Main.getInstance().setData().updateRewardRecord(p, "lobby_vipodmena");
                        Main.getInstance().setData().addCoins(p, 2000);
                        Bonusy b = new Bonusy();
                        b.playEffect(p);
                        p.closeInventory();
                    } else {
                        p.sendMessage("§cTuto odmenu jsi si jiz vybral!");
                    }
                } else {
                    p.sendMessage("§cNa vyber teto odmeny musis mit zakoupene MVIP!");
                }
            }
        }
    }

    public void runTaskDelete() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (Main.getInstance().setData().getNextRewardReset(4) < System.currentTimeMillis()) {
                    Main.getInstance().setData().resetDailyReward(System.currentTimeMillis() + 82800000); //23h
                    Main.getInstance().setData().resetReward();
                }
            }
        }, 60L, 144000);
    }
}
