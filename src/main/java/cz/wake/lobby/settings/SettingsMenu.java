package cz.wake.lobby.settings;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class SettingsMenu implements Listener {

    public static ArrayList<Player> hiden = new ArrayList<>();

    public void openSettingsMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 45, "Osobni nastaveni");

        ItemStack player = ItemFactory.create(Material.WATCH,(byte)0,"§e§lViditelnost hracu","§7Nastavuje zobrazeni","§7hracu na lobby.");
        ItemStack pets = ItemFactory.create(Material.BONE, (byte)0, "§e§lViditelnost pets", "§7Nastavuje zobrazeni", "§7pets na lobby.");
        ItemStack part = ItemFactory.create(Material.REDSTONE, (byte)0,"§e§lParticles", "§7Viditelnost efektu");
        ItemStack fly = ItemFactory.create(Material.ELYTRA, (byte)0, "§e§lFly", "§7Nastavuje FLY na lobby serverech.", "§7Fly dostanes pri kazdem",
                "§7vstupu na lobby","","§cVyzaduje MiniGames VIP!");
        ItemStack gadgets = ItemFactory.create(Material.PISTON_BASE, (byte)0, "§e§lGadgets", "§7Nastavuje zda na tebe", "§7budou fungovat gadgets lobby.");
        ItemStack speed = ItemFactory.create(Material.GOLD_BOOTS, (byte)0, "§e§lSpeed", "§7Povoluje rychlost chozeni", "§7na lobby.");
        ItemStack novinky = ItemFactory.create(Material.MAP,(byte)0, "§e§lReklama", "§7Nastavuje zobrazovani reklamy", "§7na VIP na MiniGames.","", "§cVyzaduje MiniGames VIP!");

        ItemStack enabled = ItemFactory.create(Material.STAINED_GLASS_PANE,(byte)5,"§a§lZapnuto");
        ItemStack disabled = ItemFactory.create(Material.STAINED_GLASS_PANE,(byte)14,"§c§lVypnuto");
        ItemStack nedostupne = ItemFactory.create(Material.BARRIER, (byte)0, "§c§lNedostupne");

        ItemStack zpet = ItemFactory.create(Material.ARROW,(byte)0,"§eZpet");

        inv.setItem(10, fly);
        inv.setItem(11, player);
        inv.setItem(12, pets);
        inv.setItem(13, part);
        inv.setItem(14, gadgets);
        inv.setItem(15, speed);
        inv.setItem(16, novinky);

        inv.setItem(19, nedostupne);
        inv.setItem(20, nedostupne);
        inv.setItem(21, nedostupne);
        inv.setItem(22, nedostupne);
        inv.setItem(23, nedostupne);
        inv.setItem(24, nedostupne);
        inv.setItem(25, nedostupne);

        inv.setItem(40, zpet);

        p.openInventory(inv);
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Osobni nastaveni")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if(e.getSlot() == 40){
                Main.getInstance().getMenu().openMenu(p);
            }
        }
    }
}
