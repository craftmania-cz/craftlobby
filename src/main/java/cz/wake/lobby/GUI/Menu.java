package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Menu {

    public void openMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 54, p.getName());

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(p.getName());
        headItemMeta.setDisplayName("§aInformace o tobe");
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ArrayList<String> headLore = new ArrayList<String>();
        headLore.add(ChatColor.GRAY + "");
        headLore.add(ChatColor.GRAY + "Odehrana doba: " + ChatColor.YELLOW + "Nedostupne...");
        headLore.add(ChatColor.GRAY + "CraftCoiny: " + ChatColor.AQUA + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()));
        headItemMeta.setLore(headLore);
        headItem.setItemMeta(headItemMeta);

        ItemStack statistics = new ItemStack(Material.DIAMOND, 1);
        ItemMeta statisticsMeta = statistics.getItemMeta();
        statisticsMeta.setDisplayName("§aStatistiky");
        ArrayList<String> statisticsLore = new ArrayList<String>();
        statisticsLore.add("");
        statisticsLore.add(ChatColor.WHITE + "Klikni pro zobrazeni!");
        statisticsMeta.setLore(statisticsLore);
        statistics.setItemMeta(statisticsMeta);

        ItemStack achievements = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta achievementsMeta = achievements.getItemMeta();
        achievementsMeta.setDisplayName("§aAchievementy");
        ArrayList<String> achievementsLore = new ArrayList<String>();
        achievementsLore.add("");
        achievementsLore.add(ChatColor.GRAY + "Pripravujeme...");
        achievementsMeta.setLore(achievementsLore);
        achievements.setItemMeta(achievementsMeta);

        ItemStack guild = new ItemStack(Material.PAINTING, 1);
        ItemMeta guildMeta = guild.getItemMeta();
        guildMeta.setDisplayName("§aGuilds");
        ArrayList<String> guildLore = new ArrayList<String>();
        guildLore.add("");
        guildLore.add(ChatColor.GRAY + "Pripravujeme...");
        guildMeta.setLore(guildLore);
        guild.setItemMeta(guildMeta);

        ItemStack nastaveni = new ItemStack(Material.REDSTONE_COMPARATOR);
        ItemMeta nMeta = nastaveni.getItemMeta();
        nMeta.setDisplayName("§aNastaveni");
        ArrayList<String> nLore = new ArrayList<String>();
        nLore.add("");
        nLore.add("§7Pripravujeme...");
        nMeta.setLore(nLore);
        nastaveni.setItemMeta(nMeta);

        ItemStack multiplier = new ItemStack(Material.POTION);
        ItemMeta mMeta = multiplier.getItemMeta();
        mMeta.setDisplayName("§aCoins Multiplier");
        ArrayList<String> mLore = new ArrayList<String>();
        mLore.add("");
        mLore.add("§7Pripravujeme...");
        mMeta.setLore(mLore);
        multiplier.setItemMeta(mMeta);

        menu.setItem(13, headItem);
        menu.setItem(10, statistics);
        menu.setItem(16, achievements);
        menu.setItem(33, guild);
        menu.setItem(29, multiplier);
        menu.setItem(31, nastaveni);

        p.openInventory(menu);
    }
}