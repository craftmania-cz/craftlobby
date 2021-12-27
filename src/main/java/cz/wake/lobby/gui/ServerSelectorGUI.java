package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.craftmania.craftpack.api.Buttons;
import cz.wake.lobby.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Random;

public class ServerSelectorGUI implements InventoryProvider {

    private static Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {

        // Item UI Menu
        contents.set(2, 8, ClickableItem.empty(new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setCustomModelData(100002).setName("§f").hideAllFlags().build()));

        contents.set(0, 1, ClickableItem.of(new ItemBuilder(Material.DIAMOND_PICKAXE)
                .setName(ChatColor.of("#00CDCD") + "§lSurvival §8[1.17]")
                .setLore(ChatColor.of("#7D7D7D") + "Economy, PvP, McMMO", "", "§7Survival server založený na ekonomice,", "§7s shopy a farmami. Né každý ale", "§7může být ten nejbohatší.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "survival")));

        contents.set(0, 2, ClickableItem.of(new ItemBuilder(Material.NAUTILUS_SHELL)
                .setName(ChatColor.of("#3D9140") + "§lSkyblock §8[1.17]")
                .setLore(ChatColor.of("#7D7D7D") + "Economy, PvP, McMMO", "", "§7Dokážeš z prázdného ostrova postavit", "§7něco, co bude mít hodnotu?", "§7Jedině tak přežiješ...", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock")));

        contents.set(0, 3, ClickableItem.of(new ItemBuilder(Material.LAVA_BUCKET)
                .setName(ChatColor.of("#F4A460") + "§lCreative §8[1.17]")
                .setLore(ChatColor.of("#7D7D7D") + "Pozemky, WorldEdit", "", "§7Svět, ve kterém můžeš prakticky", "§7dělat co chceš. Stavět, budovat,", "§7nebo se prostě zlepšovat.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative")));

        contents.set(1, 1, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100014)
                .setName(ChatColor.of("#EEC900") + "§lVanilla: Lands §8[1.18]")
                .setLore(ChatColor.of("#7D7D7D") + "Ochrana chunků, PvP, Bez ekonomiky", "", "§7Prakticky Survival ale bez Ekonomiky.", "§7Dokážeš přežít bez pomoci", "§7a v klasickém světě?", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla")));

        contents.set(1, 2, ClickableItem.of(new ItemBuilder(Material.IRON_BARS)
                .setName(ChatColor.of("#9340c2") + "§lPrison §8[1.16]")
                .setLore(ChatColor.of("#7D7D7D") + "Economy, Mining, Prestiges", "", "§7Prison je zpět a s ním,", "§7i tuna kopání a OP enchanty.", "§7Dokážeš se dostat co nejdál,", "§7a získat tak titul vítěze?", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "prison")));

        contents.set(1, 3, ClickableItem.of(new ItemBuilder(Material.REDSTONE)
                .setName(ChatColor.of("#CD0000") + "§lVanilla: Anarchy §8[1.17]")
                .setLore(ChatColor.of("#7D7D7D") + "Vanilla, žádná ochrana", "", "§7Tento server je určený pro náročné", "§7Vanilla hráče, kteří nechtějí ochrany", "§7a chtějí dělat bordel!", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "anarchy")));

        contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.CAKE)
                .setName(ChatColor.of("#EE30A7") + "§lEvent Server")
                .setLore(ChatColor.of("#7D7D7D") + "§7Server na kterém se konají", "§7eventy pro celý server!", "", "§7Na server se dá dostat pouze", "§7při konání eventu.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení na server")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "event-server")));

        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Buttons.EARTH.getPureItemStack())
                .setName(ChatColor.of("#4876FF") + "§lLobby [1]")
                .setLore("§7Lobby server pro všechny hráče.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby")));

        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Buttons.EARTH.getPureItemStack())
                .setName(ChatColor.of("#4876FF") + "§lLobby [2]")
                .setLore("§7Lobby server pro všechny hráče.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby2")));

        contents.set(2, 7, ClickableItem.of(new ItemBuilder(Buttons.EARTH.getPureItemStack())
                .setName(ChatColor.of("#4876FF") + "§lLobby [3]")
                .setLore("§7Lobby server pro všechny hráče.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().getCraftBalancerManager().bypassConnect(player, "ohub")));

    }

    @Override
    public void update(Player player, InventoryContents contents) {
    }
}
