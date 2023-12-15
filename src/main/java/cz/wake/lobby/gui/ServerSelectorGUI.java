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

        contents.set(0, 1, ClickableItem.of(new ItemBuilder(Material.DIAMOND_PICKAXE)
                .setName("§f쇮") // Survival: Classic
                .setLore("§8Doporučená verze: §f1.19+", "", "§8• §7Ekonomika & shopy", "§8• §7Residence", "§8• §7PvP Arény §8(v přípravě)", "§8• §7Odměny za práci: Jobs" , "§8• §7Ranked odměny", "§8• §7Questy & challange", "§8• §7Nové recepty a itemy", "§8• §7Nové variace bloků", "§8• §7DynMapa", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "survival2")));

        contents.set(0, 2, ClickableItem.of(new ItemBuilder(Material.HEART_OF_THE_SEA)
                .setName("§f쇯") // OneBlock
                .setLore("§8Doporučená verze: §f1.19+", "", "§8• §7Ekonomika & shopy", "§8• §7Ostrovy s postupným rozšiřováním", "§8• §7PvP Arény §8(v přípravě)", "§8• §7Odměny za práci: Jobs", "§8• §7Ranked odměny", "§8• §7Questy & challange", "§8• §7Nové recepty, itemy a bloky", "§8• §7DynMapa", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "skyblock")));

        contents.set(0, 3, ClickableItem.of(new ItemBuilder(Material.LAVA_BUCKET)
                .setName("§f⼫") // Creative
                .setLore("§8Doporučená verze: §f1.19+", "", "§8• §7Pozemky (plots)", "§8• §7WorldEdit", "§8• §7Libovolné stavění", "§8• §7Custom bloky a itemy", "§8• §7Roleplay systém", "§8• §7DynMapa", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "creative")));

        contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.CAKE)
                .setName("§f⼪") // Event Server
                .setLore("§8Doporučená verze: §f1.19+", "", "§7Server na kterém se konají", "§7eventy pro celý server!", "", "§7Na server se dá dostat pouze", "§7při konání eventu.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "event-server")));

        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Buttons.EARTH.getPureItemStack())
                .setName("§f⼩ [1]") // Lobby
                .setLore("§7Lobby server pro všechny hráče.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "lobby")));

        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Buttons.EARTH.getPureItemStack())
                .setName("§f⼩ [2]") // Lobby
                .setLore("§7Lobby server pro všechny hráče.", "", ChatColor.of("#FFD39B") + "Klikni pro připojení")
                .hideAllFlags()
                .build(), (clickEvent) -> Main.getInstance().sendToServer(player, "lobby2")));

    }

    @Override
    public void update(Player player, InventoryContents contents) {
    }
}
