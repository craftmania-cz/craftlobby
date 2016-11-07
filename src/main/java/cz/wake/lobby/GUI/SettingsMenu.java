package cz.wake.lobby.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SettingsMenu implements Listener {

    public void openSettingsMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 54, "Nastaveni");

        ItemStack hider = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta hMeta = hider.getItemMeta();
        hMeta.setDisplayName(ChatColor.YELLOW + "");


    }

}
