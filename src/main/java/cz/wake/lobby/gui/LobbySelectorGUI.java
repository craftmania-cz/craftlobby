package cz.wake.lobby.gui;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.bungee.BungeeAPI;
import cz.craftmania.craftcore.spigot.bungee.responses.BungeePlayerAmountResponse;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LobbySelectorGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        contents.fillRow(0,  ClickableItem.of(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.fillRow(5,  ClickableItem.of(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));

        contents.set(2, 2, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #1").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            BungeeAPI.connect(player, "lobby");
        }));
        contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #2").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            BungeeAPI.connect(player, "lobby2");
        }));
        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #3").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            BungeeAPI.connect(player, "lobby3");
        }));
        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #4").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            BungeeAPI.connect(player, "lobby"); // HUH?
        }));
        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.BARRIER).setName("§4§lPremium Lobby #1").hideAllFlags().setLore("§cNedostupné").build(), e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
