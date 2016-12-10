package cz.wake.lobby.settings;

import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
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

        ItemStack zpet = ItemFactory.create(Material.ARROW,(byte)0,"§eZpet");

        inv.setItem(10, fly);
        inv.setItem(11, player);
        inv.setItem(12, pets);
        inv.setItem(13, part);
        inv.setItem(14, gadgets);
        inv.setItem(15, speed);
        inv.setItem(16, novinky);

        inv.setItem(19, enabled);
        inv.setItem(20, disabled);
        inv.setItem(21, disabled);
        inv.setItem(22, enabled);
        inv.setItem(23, enabled);
        inv.setItem(24, disabled);
        inv.setItem(25, enabled);

        inv.setItem(40, zpet);

        p.openInventory(inv);

    }
}
