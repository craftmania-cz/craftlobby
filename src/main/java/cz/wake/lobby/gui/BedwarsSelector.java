package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BedwarsSelector implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        contents.set(1, 1, ClickableItem.of(new ItemBuilder(Material.GRAY_BED)
                .setName("§eBedWars #1")
                .setLore("§8Mapa: §fMoon", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw1")));

        contents.set(1, 2, ClickableItem.of(new ItemBuilder(Material.GRAY_BED)
                .setName("§eBedWars #2")
                .setLore("§8Mapa: §fMoon", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw2")));

        contents.set(1, 3, ClickableItem.of(new ItemBuilder(Material.GRAY_BED)
                .setName("§eBedWars #3")
                .setLore("§8Mapa: §fMoon", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw3")));

        contents.set(1, 5, ClickableItem.of(new ItemBuilder(Material.YELLOW_BED)
                .setName("§eBedWars #4")
                .setLore("§8Mapa: §fSahara", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw4")));

        contents.set(1, 6, ClickableItem.of(new ItemBuilder(Material.YELLOW_BED)
                .setName("§eBedWars #5")
                .setLore("§8Mapa: §fSahara", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw5")));

        contents.set(1, 7, ClickableItem.of(new ItemBuilder(Material.YELLOW_BED)
                .setName("§eBedWars #6")
                .setLore("§8Mapa: §fSahara", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw6")));

        contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.RED_BED)
                .setName("§eBedWars #7")
                .setLore("§8Mapa: §fMushrooms", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw7")));

        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.RED_BED)
                .setName("§eBedWars #8")
                .setLore("§8Mapa: §fMushrooms", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw8")));

        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.RED_BED)
                .setName("§eBedWars #9")
                .setLore("§8Mapa: §fMushrooms", "§8Limit hráčů: 16", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "bw9")));
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        InventoryProvider.super.update(player, contents);
    }
}
