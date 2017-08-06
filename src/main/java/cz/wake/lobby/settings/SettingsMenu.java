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
    public static ArrayList<Player> particles = new ArrayList<>();
    public static ArrayList<Player> gadgets = new ArrayList<>();
    public static ArrayList<Player> activeGadgets = new ArrayList<>();

    public void openSettingsMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null, 45, "Osobni nastaveni");

        ItemStack player = ItemFactory.create(Material.WATCH,(byte)0,"§e§lViditelnost hracu","§7Nastavuje zobrazeni","§7hracu na lobby.");
        ItemStack pets = ItemFactory.create(Material.BONE, (byte)0, "§e§lViditelnost pets", "§7Nastavuje zobrazeni", "§7pets na lobby.");
        ItemStack part = ItemFactory.create(Material.REDSTONE, (byte)0,"§e§lParticles", "§7Viditelnost efektu","","§cDocasne nefunguje na vsechny!");
        ItemStack fly = ItemFactory.create(Material.ELYTRA, (byte)0, "§e§lFly", "§7Nastavuje FLY na lobby serverech.", "§7Fly dostanes pri kazdem",
                "§7vstupu na lobby","","§cVyzaduje MiniGames VIP!");
        ItemStack gadgets = ItemFactory.create(Material.PISTON_BASE, (byte)0, "§e§lGadgets", "§7Nastavuje zda na tebe", "§7budou fungovat gadget lobby.");
        ItemStack speed = ItemFactory.create(Material.GOLD_BOOTS, (byte)0, "§e§lSpeed", "§7Povoluje rychlost chozeni", "§7na lobby.");
        ItemStack novinky = ItemFactory.create(Material.MAP,(byte)0, "§e§lReklama", "§7Nastavuje zobrazovani reklamy", "§7na VIP na MiniGames.","", "§cVyzaduje MiniGames VIP!");
        ItemStack deathMessages = ItemFactory.create(Material.BLAZE_POWDER,(byte)0,"§e§lDeath zpravy","§7Nastavuje zobrazeni smrti", "§7hracu.","","§cFunguje pouze na Survival serverech");
        ItemStack notify = ItemFactory.create(Material.JUKEBOX,(byte)0, "§e§lOznameni o oznaceni","§7Pokud te nekdo oznaci","§7v chatu, server te","§7upozorni cinknutim.");


        ItemStack enabled = ItemFactory.create(Material.STAINED_GLASS_PANE,(byte)5,"§a§lZapnuto");
        ItemStack disabled = ItemFactory.create(Material.STAINED_GLASS_PANE,(byte)14,"§c§lVypnuto");
        ItemStack nedostupne = ItemFactory.create(Material.BARRIER, (byte)0, "§c§lNedostupne");

        ItemStack zpet = ItemFactory.create(Material.ARROW,(byte)0,"§eZpet");

        inv.setItem(9, fly);
        inv.setItem(10, player);
        inv.setItem(11, pets);
        inv.setItem(12, part);
        inv.setItem(13, gadgets);
        inv.setItem(14, speed);
        inv.setItem(15, novinky);
        inv.setItem(16, deathMessages);
        inv.setItem(17, notify);


        if(Main.getInstance().fetchData().getSettings(p, "lobby_fly") == 1){
            inv.setItem(18, enabled);
        } else {
            inv.setItem(18, disabled);
        }
        if(Main.getInstance().fetchData().getSettings(p, "lobby_players") == 1){
            inv.setItem(19, disabled);
        } else {
            inv.setItem(19, enabled);
        }
        inv.setItem(20, nedostupne); //Pets
        if(Main.getInstance().fetchData().getSettings(p, "lobby_particles") == 1){
            inv.setItem(21, enabled);
        } else {
            inv.setItem(21, disabled);
        }
        if(Main.getInstance().fetchData().getSettings(p, "lobby_gadgets") == 1){
            inv.setItem(22, enabled);
        } else {
            inv.setItem(22, disabled);
        }
        if (Main.getInstance().fetchData().getSettings(p, "lobby_speed") == 1){
            inv.setItem(23, enabled);
        } else {
            inv.setItem(23, disabled);
        }
        inv.setItem(24, nedostupne); //Novinky
        if (Main.getInstance().fetchData().getSettings(p, "death_messages") == 1){
            inv.setItem(25, enabled);
        } else {
            inv.setItem(25, disabled);
        }
        inv.setItem(26, nedostupne); //Notify

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
            if(e.getSlot() == 18){
                if(p.hasPermission("craftlobby.vip.fly")){
                    if(Main.getInstance().fetchData().getSettings(p, "lobby_fly") == 1){
                        Main.getInstance().fetchData().updateSettings(p, "lobby_fly", 0);
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage("§cFly na lobby bylo deaktivovano!");
                        p.closeInventory();
                    } else {
                        Main.getInstance().fetchData().updateSettings(p, "lobby_fly", 1);
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage("§aFly na lobby bylo aktivovano!");
                        p.closeInventory();
                    }
                } else {
                    p.sendMessage("§cK pouziti teto funkce potrebujes §fMiniGames VIP");
                    p.closeInventory();
                }
            }
            if(e.getSlot() == 19){
                if(Main.getInstance().fetchData().getSettings(p, "lobby_players") == 1){
                    Main.getInstance().fetchData().updateSettings(p, "lobby_players", 0);
                    SettingsMenu.hiden.remove(p);
                    for(Player p2 : Bukkit.getOnlinePlayers()){
                        p.showPlayer(p2);
                    }
                    p.sendMessage("§aZobrazovani hracu zapnuto!");
                    p.closeInventory();
                } else {
                    Main.getInstance().fetchData().updateSettings(p, "lobby_players", 1);
                    SettingsMenu.hiden.add(p);
                    for(Player p2 : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(p2);
                    }
                    p.sendMessage("§cZobrazovani hracu vypnuto!");
                    p.closeInventory();
                }
            }
            if(e.getSlot() == 21){
                if(Main.getInstance().fetchData().getSettings(p, "lobby_particles") == 1){
                    Main.getInstance().fetchData().updateSettings(p, "lobby_particles", 0);
                    SettingsMenu.particles.remove(p);
                    p.sendMessage("§cZobrazovani efektu vypnuto!");
                    p.closeInventory();
                } else {
                    Main.getInstance().fetchData().updateSettings(p, "lobby_particles", 1);
                    SettingsMenu.particles.add(p);
                    p.sendMessage("§aZobrazovani efektu zapnuto!");
                    p.closeInventory();
                }
            }
            if(e.getSlot() == 22){
                if(Main.getInstance().fetchData().getSettings(p, "lobby_gadgets") == 1){
                    Main.getInstance().fetchData().updateSettings(p, "lobby_gadgets", 0);
                    SettingsMenu.gadgets.remove(p);
                    p.sendMessage("§cGadgety jiz na tebe nebudou reagovat!");
                    p.closeInventory();
                } else {
                    Main.getInstance().fetchData().updateSettings(p, "lobby_gadgets", 1);
                    SettingsMenu.gadgets.add(p);
                    p.sendMessage("§aGadgety nyni na tebe budou reagovat!");
                    p.closeInventory();
                }
            }
            if(e.getSlot() == 23){
                if(Main.getInstance().fetchData().getSettings(p, "lobby_speed") == 1){
                    Main.getInstance().fetchData().updateSettings(p, "lobby_speed", 0);
                    p.setWalkSpeed(0.2F);
                    p.sendMessage("§cRychlost byla nastavena na zakladni!");
                    p.closeInventory();
                } else {
                    Main.getInstance().fetchData().updateSettings(p, "lobby_speed", 1);
                    p.setWalkSpeed(0.3F);
                    p.sendMessage("§aRychlost byla nastavena na 2x rychlejsi!");
                    p.closeInventory();
                }
            }
            if(e.getSlot() == 25){
                if(Main.getInstance().fetchData().getSettings(p, "death_messages") == 1){
                    Main.getInstance().fetchData().updateSettings(p, "death_messages", 0);
                    p.sendMessage("§cZablokovano zobrazovani zprav o smrti!");
                    p.closeInventory();
                } else {
                    Main.getInstance().fetchData().updateSettings(p, "death_messages", 1);
                    p.sendMessage("§aNyni uvidis v chatu zpravy o smrti hracu!");
                    p.closeInventory();
                }
            }

        }
    }

    public void removePlayer(final Player p){
        if(gadgets.contains(p)){
            gadgets.remove(p);
        }
        if (particles.contains(p)){
            particles.remove(p);
        }
        if (hiden.contains(p)){
            hiden.remove(p);
        }
    }
}
