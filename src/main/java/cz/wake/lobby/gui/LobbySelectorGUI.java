package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LobbySelectorGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        contents.fillRow(0,  ClickableItem.of(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.fillRow(5,  ClickableItem.of(new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));

        contents.set(2, 2, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #1").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby");
        }));
        contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #2").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby2");
        }));
        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #3").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby3");
        }));
        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§a§lLobby #4").hideAllFlags().setLore("§bKlikni pro připojení!").build(), e -> {
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "lobby"); // HUH?
        }));
        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.BARRIER).setName("§4§lPremium Lobby #1").hideAllFlags().setLore("§cNedostupné").build(), e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
