package cz.wake.plugins.GUI;

import cz.wake.plugins.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MountMenu implements Listener {

    public void openMount(Player p) {

        Inventory mountMenu = Bukkit.createInventory(null, 54, "Mounts");

        ItemStack mountoffire = new ItemStack(Material.BLAZE_ROD);
        ItemMeta mofMeta = mountoffire.getItemMeta();
        mofMeta.setDisplayName(ChatColor.GREEN + "MountOfFire");
        ArrayList<String> mofLore = new ArrayList<String>();
        mofLore.add(ChatColor.GRAY + "Kliknutim si nasadis na hlavu!");
        mofMeta.setLore(mofLore);
        mountoffire.setItemMeta(mofMeta);
        mountMenu.setItem(10, mountoffire);

        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
        zpet.setItemMeta(zpetMeta);

        ItemStack deaktivace = new ItemStack(Material.BARRIER);
        ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
        deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Sundat blok z hlavy ✖");
        ArrayList<String> deaktivaceLore = new ArrayList<String>();
        deaktivaceLore.add(ChatColor.GRAY + "Kliknutim sundas nasazeny blok.");
        deaktivaceMeta.setLore(deaktivaceLore);
        deaktivace.setItemMeta(deaktivaceMeta);

        ItemStack shopItem = new ItemStack(Material.CHEST, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
        ArrayList<String> shopLore = new ArrayList<String>();
        shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby");
        shopLore.add(ChatColor.GRAY + "daji se ziskat z CraftBoxu nebo na");
        shopLore.add(ChatColor.GRAY + "specialnich eventech.");
        shopLore.add("");
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        mountMenu.setItem(49, shopItem);
        mountMenu.setItem(40, deaktivace);
        mountMenu.setItem(39, zpet);

        p.openInventory(mountMenu);
    }

}
