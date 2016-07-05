package cz.wake.plugins.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Lobby {

    public void openMenu(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 9, "Prehled lobby serveru");

        ItemStack ohub = new ItemStack(Material.IRON_BLOCK);
        ItemMeta meta = ohub.getItemMeta();
        meta.setDisplayName("§aOHUB");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§cVarovani: Kope do WHUBU!");
        lore.add("");
        lore.add("§7Kliknutim se pripojis.");
        meta.setLore(lore);
        ohub.setItemMeta(meta);
        inv.setItem(0, ohub);

        ItemStack lobby1 = new ItemStack(Material.IRON_BLOCK);
        ItemMeta l1Meta = lobby1.getItemMeta();
        l1Meta.setDisplayName("§aLobby-1");
        ArrayList<String> l1Lore = new ArrayList<String>();
        l1Lore.add("");
        l1Lore.add("§7Kliknutim se pripojis.");
        l1Meta.setLore(l1Lore);
        lobby1.setItemMeta(l1Meta);
        inv.setItem(1, lobby1);

        ItemStack lobby2 = new ItemStack(Material.IRON_BLOCK);
        ItemMeta l2Meta = lobby2.getItemMeta();
        l2Meta.setDisplayName("§aLobby-2");
        ArrayList<String> l2Lore = new ArrayList<String>();
        l2Lore.add("");
        l2Lore.add("§7Kliknutim se pripojis.");
        l2Meta.setLore(l2Lore);
        lobby2.setItemMeta(l2Meta);
        inv.setItem(2, lobby2);

        ItemStack lobby3 = new ItemStack(Material.IRON_BLOCK);
        ItemMeta l3Meta = lobby3.getItemMeta();
        l3Meta.setDisplayName("§aLobby-3");
        ArrayList<String> l3Lore = new ArrayList<String>();
        l3Lore.add("");
        l3Lore.add("§7Kliknutim se pripojis.");
        l3Meta.setLore(l3Lore);
        lobby3.setItemMeta(l3Meta);
        inv.setItem(3, lobby3);

        ItemStack lobby4 = new ItemStack(Material.IRON_BLOCK);
        ItemMeta l4Meta = lobby4.getItemMeta();
        l4Meta.setDisplayName("§aLobby-4");
        ArrayList<String> l4Lore = new ArrayList<String>();
        l4Lore.add("");
        l4Lore.add("§7Kliknutim se pripojis.");
        l4Meta.setLore(l4Lore);
        lobby4.setItemMeta(l4Meta);
        inv.setItem(4, lobby4);

        ItemStack blobby = new ItemStack(Material.IRON_BLOCK);
        ItemMeta bMeta = blobby.getItemMeta();
        bMeta.setDisplayName("§aB-Lobby");
        ArrayList<String> bLore = new ArrayList<String>();
        bLore.add("");
        bLore.add("§7Kliknutim se pripojis.");
        bMeta.setLore(bLore);
        blobby.setItemMeta(bMeta);
        inv.setItem(5, blobby);

        ItemStack dlobby = new ItemStack(Material.IRON_BLOCK);
        ItemMeta dMeta = dlobby.getItemMeta();
        dMeta.setDisplayName("§aD-Lobby");
        ArrayList<String> dLore = new ArrayList<String>();
        dLore.add("");
        dLore.add("§7Kliknutim se pripojis.");
        dMeta.setLore(dLore);
        dlobby.setItemMeta(dMeta);
        inv.setItem(6, dlobby);

        ItemStack slobby = new ItemStack(Material.IRON_BLOCK);
        ItemMeta sMeta = slobby.getItemMeta();
        sMeta.setDisplayName("§aS-Lobby");
        ArrayList<String> sLore = new ArrayList<String>();
        sLore.add("");
        sLore.add("§7Kliknutim se pripojis.");
        sMeta.setLore(sLore);
        slobby.setItemMeta(sMeta);
        inv.setItem(7, slobby);

        p.openInventory(inv);
    }

}
