package cz.wake.lobby.vanoce;

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

public class TicketSystem implements Listener {

    public void openTicketMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 45, "Ticket system");

        ItemStack i2 = ItemFactory.createHead("§aPred 1 dnem", "1ff80fcf-030e-447f-8b8d-b439963389b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY1YjUyYmRiMjU1NmZkN2Q0NmM1Yzg0OGEzOGM4YjhlZjE1M2FmZTdkNTZkYjE3NzZkOTliNTMzYmQwIn19fQ==");
        ItemMeta iM = i2.getItemMeta();
        ArrayList<String> iL = new ArrayList<>();
        iL.add("§7" + Main.getInstance().fetchData().getTicketProgramPerDay("vcera"));
        iL.add("§6Vyhral: §f" + Main.getInstance().fetchData().getWinner());
        iM.setLore(iL);
        i2.setItemMeta(iM);

        ItemStack now = ItemFactory.createHead("§eDnes se soutezi o", "91df0725-c04d-4776-b9e7-01dad0ea6d5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NjUyYmZkYjdhZGRlMTI4ZTdlYWNjNTBkMTZlYjlmNDg3YTMyMDliMzA0ZGUzYjk2OTdjZWJmMTMzMjNiIn19fQ==");
        ItemMeta nowM = now.getItemMeta();
        ArrayList<String> nowL = new ArrayList<>();
        nowL.add("§7" + Main.getInstance().fetchData().getTicketProgramPerDay("dnes"));
        nowM.setLore(nowL);
        now.setItemMeta(nowM);

        ItemStack zitra = ItemFactory.createHead("§cZitra se bude soutezit o", "dd7514ca-c10f-4389-9c14-78d2feae91b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjczYTIxMTQxMzZiOGVlNDkyNmNhYTUxNzg1NDE0MDM2YTJiNzZlNGYxNjY4Y2I4OWQ5OTcxNmM0MjEifX19");
        ItemMeta zitraM = zitra.getItemMeta();
        ArrayList<String> zitraL = new ArrayList<>();
        zitraL.add("§7" + Main.getInstance().fetchData().getTicketProgramPerDay("zitra"));
        zitraM.setLore(zitraL);
        zitra.setItemMeta(zitraM);

        int count = Main.getInstance().fetchData().countTickets(p);
        int price = Main.getInstance().fetchData().priceTickets();
        int all = Main.getInstance().fetchData().countAllTickets();

        int prc = (count * 100 / all);

        ItemStack tickets = ItemFactory.create(Material.GOLD_INGOT, (byte)0, "§eDnes pouzite tickety");
        ItemMeta  tM = tickets.getItemMeta();
        ArrayList<String> tL = new ArrayList<>();
        tL.add("§7Pocet ticketu: §f" + count);
        tL.add("§7Celkova cena ticketu: §f" + price * count + " CC");
        tL.add("§7Sance na vyhru: §f" + prc + "%");
        tM.setLore(tL);
        tickets.setItemMeta(tM);

        ItemStack nakup = ItemFactory.create(Material.PAPER, (byte)0, "§bZakoupit 1x ticket");
        ItemMeta nM = nakup.getItemMeta();
        ArrayList<String> nL = new ArrayList<>();
        nL.add("§7Cena za ticket: §f" + price + " CC");
        nL.add("");
        nL.add("§aKliknutim zakoupis ticket (max. 10)!");
        nM.setLore(nL);
        nakup.setItemMeta(nM);

        ItemStack info = ItemFactory.create(Material.COMMAND_REPEATING, (byte)0, "§9Informace",
                "","§7Kazdy den muze 1 hrac vyhrat 1 hru!","§7Do (automatickeho) losovani se zaradis nakupem ticketu.",
                "§7Kazdy den priblizne ve §a20:30 §7server vybere", "§7hrace, ktery vyhraje klic ke hre!",
                "", "§cPokud vyhrajes, bude ti to oznamovano pri pripojovani!",
                "§eVyherce obdrzi klic ve zpravach na webu!");

        inv.setItem(12, i2);
        inv.setItem(13, now);
        inv.setItem(14, zitra);
        inv.setItem(29, info);
        inv.setItem(31, tickets);
        inv.setItem(33, nakup);

        p.openInventory(inv);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e){
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Ticket system")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR){
                return;
            }
            if(e.getSlot() == 33){
                int price = Main.getInstance().fetchData().priceTickets();
                if(Main.getInstance().fetchData().getCraftCoins(p.getUniqueId())
                        >= price){ // Pokud si muze zkoupit ticket
                    if(System.currentTimeMillis() <= Main.getInstance().fetchData().endTicketing()){ // Kontrola jestli neni po konci
                        if(Main.getInstance().fetchData().countTickets(p) < 10){ // Max 10 ticketu
                            Main.getInstance().fetchData().takeCoins(p, price);
                            Main.getInstance().fetchData().addPlayerToTicketGame(p);
                            p.sendMessage("§eZakoupil jsi si ticket za §f" + price + " CC§e!");
                            p.closeInventory();
                        } else {
                            p.sendMessage("§cNelze si zakoupit vic jak 10 ticketu za den!");
                            p.closeInventory();
                        }
                    } else {
                        p.sendMessage("§cJiz byl vyhlasen vyherce dnesni hry! Zkus to zitra!");
                        p.closeInventory();
                    }
                } else {
                    p.sendMessage("§cNemas dostatek coinu k nakupu ticketu!");
                    p.closeInventory();
                }
            }
        }
    }
}
