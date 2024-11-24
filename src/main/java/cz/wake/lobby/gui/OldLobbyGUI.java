package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class OldLobbyGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        contents.set(1, 2, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS)
                .setName("§bStaré lobby: 2015")
                .setLore("§8Nakoukni do starého lobby", "§8a projdi se po lobby, co definovalo", "§8tehdejší dobu CraftManie!", "", "§cUpozornění! Lobby není plně funkční, jsou zde bugy!", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "legacy_lobby_1")));


        contents.set(1, 6, ClickableItem.of(new ItemBuilder(Material.GREEN_STAINED_GLASS)
                .setName("§aStaré lobby: 2017")
                .setLore("§8Další z řady lobby serverů CraftManie,", "§8tentokrát ale na opuštěném ostrově.", "", "§cUpozornění! Lobby není plně funkční, jsou zde bugy!", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "legacy_lobby_2")));
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        InventoryProvider.super.update(player, contents);
    }
}
