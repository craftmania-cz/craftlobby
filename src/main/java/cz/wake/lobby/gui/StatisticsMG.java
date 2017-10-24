package cz.wake.lobby.gui;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class StatisticsMG {

    public void openMinigamesMenu(Player p) {

        Inventory minigamesMenu = Bukkit.createInventory(null, 45, p.getName());

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(p.getName());
        headItemMeta.setDisplayName("§fCelkove statistiky");
        ArrayList<String> hLore = new ArrayList();
        hLore.add("");
        hLore.add("§eCraftCoiny: §7" + Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");
        hLore.add("");
        hLore.add("§ePocet hlasu (tyden): §7" + Main.getInstance().fetchData().getVotesWeek(p.getUniqueId()));
        hLore.add("§ePocet hlasu (mesic): §7" + Main.getInstance().fetchData().getVotesMonth(p.getUniqueId()));
        hLore.add("§ePocet hlasu (celkem): §7" + Main.getInstance().fetchData().getVotesAll(p.getUniqueId()));
        headItemMeta.setLore(hLore);
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        headItem.setItemMeta(headItemMeta);

        ItemStack bedwars = new ItemStack(Material.BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName("§fBedWars");
        ArrayList<String> bedwarsLore = new ArrayList();
        bedwarsLore.add("");
        bedwarsLore.add("§eScore: §7" + Main.getInstance().fetchData().getBedwarsScore(p.getUniqueId()));
        bedwarsLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getBedwarsWins(p.getUniqueId()));
        bedwarsLore.add("§eProhry: §7" + Main.getInstance().fetchData().getBedwarsLoses(p.getUniqueId()));
        bedwarsLore.add("§eZabiti: §7" + Main.getInstance().fetchData().getBedwarsKills(p.getUniqueId()));
        bedwarsLore.add("§eSmrti: §7" + Main.getInstance().fetchData().getBedwarsDeaths(p.getUniqueId()));
        bedwarsLore.add("§eZniceno posteli: §7" + Main.getInstance().fetchData().getBedwarsDestroyed(p.getUniqueId()));
        bedwarsLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getBedwarsPlayed(p.getUniqueId()));
        //bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p.getUniqueId()), false)*/);
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack drawit = new ItemStack(Material.PAINTING);
        ItemMeta drawitMeta = drawit.getItemMeta();
        drawitMeta.setDisplayName("§fDrawIt");
        ArrayList<String> drawitLore = new ArrayList();
        drawitLore.add("");
        drawitLore.add("§eScore: §7" + Main.getInstance().fetchData().getDrawitScore(p.getUniqueId()));
        drawitLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getDrawitWins(p.getUniqueId()));
        drawitLore.add("§eProhry: §7" + Main.getInstance().fetchData().getDrawitLoses(p.getUniqueId()));
        drawitLore.add("§eSpravne uhadnuti: §7" + Main.getInstance().fetchData().getDrawitRightGuess(p.getUniqueId()));
        drawitLore.add("§eSpatne uhadnuti: §7" + Main.getInstance().fetchData().getDrawitWrongGuess(p.getUniqueId()));
        drawitLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getDrawitPlayed(p.getUniqueId()));
        //rawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p.getUniqueId()), false));
        drawitMeta.setLore(drawitLore);
        drawit.setItemMeta(drawitMeta);

        ItemStack anni = new ItemStack(Material.ENDER_STONE);
        ItemMeta anniMeta = anni.getItemMeta();
        anniMeta.setDisplayName("§fAnnihilation");
        ArrayList<String> anniLore = new ArrayList();
        anniLore.add("");
        anniLore.add("§eZabiti: §7" + Main.getInstance().fetchData().getAnniKills(p.getUniqueId()));
        anniLore.add("§eSmrti: §7" + Main.getInstance().fetchData().getAnniDeaths(p.getUniqueId()));
        anniLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getAnniWins(p.getUniqueId()));
        anniLore.add("§eProhry: §7" + Main.getInstance().fetchData().getAnniLosses(p.getUniqueId()));
        anniLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getAnniPlayedGames(p.getUniqueId()));
        anniLore.add("§eZniceno Nexusu: §7" + Main.getInstance().fetchData().getAnniDestroyed(p.getUniqueId()));
        anniLore.add("§eZabito Bossu: §7" + Main.getInstance().fetchData().getAnniKillBoss(p.getUniqueId()));
        anniLore.add("§eVykopano dia: §7" + Main.getInstance().fetchData().getAnniMinedDiamond(p.getUniqueId()));
        anniMeta.setLore(anniLore);
        anni.setItemMeta(anniMeta);

        ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
        ItemMeta bMeta = buildbattle.getItemMeta();
        bMeta.setDisplayName("§fBuildBattle");
        ArrayList<String> bbLore = new ArrayList();
        bbLore.add("");
        bbLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getBuildBattleWins(p.getUniqueId()));
        bbLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getBuildBattlePlayedGames(p.getUniqueId()));
        //bbLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBuildBattleTime(p.getUniqueId()), false));
        bMeta.setLore(bbLore);
        buildbattle.setItemMeta(bMeta);

        ItemStack vanilla = new ItemStack(Material.EMERALD);
        ItemMeta vanMeta = vanilla.getItemMeta();
        vanMeta.setDisplayName("§fVanilla");
        ArrayList<String> vanLore = new ArrayList();
        vanLore.add("§cDocasne nefunguji.");
        vanMeta.setLore(vanLore);
        vanilla.setItemMeta(vanMeta);

        ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta swMeta = skywars.getItemMeta();
        swMeta.setDisplayName("§fSkyWars");
        ArrayList<String> swLore = new ArrayList();
        swLore.add("");
        swLore.add("§eZabiti (S+I): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_kills"));
        swLore.add("§eSmrti (S+I): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_deaths"));
        swLore.add("§eVitezstvi (S+I): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_wins"));
        swLore.add("§eOdehrano her (S+I): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_played"));
        swLore.add("");
        swLore.add("§eZabiti (Team): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_kills"));
        swLore.add("§eSmrti (Team): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_deaths"));
        swLore.add("§eVitezstvi (Team): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_wins"));
        swLore.add("§eOdehrano (Team): §7" + Main.getInstance().fetchData().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_played"));
        swLore.add("§bSkyDust: §7" + Main.getInstance().fetchData().getSkyKeysDust(p.getUniqueId()));
        swLore.add("§810x SkyDust = 1x SkyKeys");
        swMeta.setLore(swLore);
        skywars.setItemMeta(swMeta);

        if (p.hasPermission("craftlobby.stats.vip")) {
            ItemStack info = new ItemStack(Material.ARROW);
            ItemMeta iMeta = info.getItemMeta();
            iMeta.setDisplayName("§aZobrazeni statistik hracu");
            ArrayList<String> iLore = new ArrayList();
            iLore.add("");
            iLore.add("§7Statistiky urciteho hrace zobrazis §b/stats nick");
            iMeta.setLore(iLore);
            info.setItemMeta(iMeta);
            minigamesMenu.setItem(36, info);
        }

        minigamesMenu.setItem(13, headItem);
        minigamesMenu.setItem(20, bedwars);
        minigamesMenu.setItem(21, drawit);
        minigamesMenu.setItem(22, anni);
        minigamesMenu.setItem(23, buildbattle);
        minigamesMenu.setItem(24, skywars);
        minigamesMenu.setItem(31, vanilla);

        p.openInventory(minigamesMenu);
    }

    public void openOfflineStats(Player p, OfflinePlayer op) {

        Inventory minigamesMenu = Bukkit.createInventory(null, 45, op.getName());

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(op.getName());
        headItemMeta.setDisplayName("§fCelkove statistiky");
        ArrayList<String> hLore = new ArrayList();
        hLore.add("");
        hLore.add("§eCraftCoiny: §7" + Main.getInstance().fetchData().getCraftCoins(op.getUniqueId()) + " CC");
        hLore.add("");
        hLore.add("§ePocet hlasu (tyden): §7" + Main.getInstance().fetchData().getVotesWeek(op.getUniqueId()));
        hLore.add("§ePocet hlasu (mesic): §7" + Main.getInstance().fetchData().getVotesMonth(op.getUniqueId()));
        hLore.add("§ePocet hlasu (celkem): §7" + Main.getInstance().fetchData().getVotesAll(op.getUniqueId()));
        headItemMeta.setLore(hLore);
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        headItem.setItemMeta(headItemMeta);

        ItemStack bedwars = new ItemStack(Material.BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName("§fBedWars");
        ArrayList<String> bedwarsLore = new ArrayList();
        bedwarsLore.add("");
        bedwarsLore.add("§eScore: §7" + Main.getInstance().fetchData().getBedwarsScore(op.getUniqueId()));
        bedwarsLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getBedwarsWins(op.getUniqueId()));
        bedwarsLore.add("§eProhry: §7" + Main.getInstance().fetchData().getBedwarsLoses(op.getUniqueId()));
        bedwarsLore.add("§eZabiti: §7" + Main.getInstance().fetchData().getBedwarsKills(op.getUniqueId()));
        bedwarsLore.add("§eSmrti: §7" + Main.getInstance().fetchData().getBedwarsDeaths(op.getUniqueId()));
        bedwarsLore.add("§eZniceno posteli: §7" + Main.getInstance().fetchData().getBedwarsDestroyed(op.getUniqueId()));
        bedwarsLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getBedwarsPlayed(op.getUniqueId()));
        //bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p.getUniqueId()), false)*/);
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack drawit = new ItemStack(Material.PAINTING);
        ItemMeta drawitMeta = drawit.getItemMeta();
        drawitMeta.setDisplayName("§fDrawIt");
        ArrayList<String> drawitLore = new ArrayList();
        drawitLore.add("");
        drawitLore.add("§eScore: §7" + Main.getInstance().fetchData().getDrawitScore(op.getUniqueId()));
        drawitLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getDrawitWins(op.getUniqueId()));
        drawitLore.add("§eProhry: §7" + Main.getInstance().fetchData().getDrawitLoses(op.getUniqueId()));
        drawitLore.add("§eSpravne uhadnuti: §7" + Main.getInstance().fetchData().getDrawitRightGuess(op.getUniqueId()));
        drawitLore.add("§eSpatne uhadnuti: §7" + Main.getInstance().fetchData().getDrawitWrongGuess(op.getUniqueId()));
        drawitLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getDrawitPlayed(op.getUniqueId()));
        //rawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p.getUniqueId()), false));
        drawitMeta.setLore(drawitLore);
        drawit.setItemMeta(drawitMeta);

        ItemStack anni = new ItemStack(Material.ENDER_STONE);
        ItemMeta anniMeta = anni.getItemMeta();
        anniMeta.setDisplayName("§fAnnihilation");
        ArrayList<String> anniLore = new ArrayList();
        anniLore.add("");
        anniLore.add("§eZabiti: §7" + Main.getInstance().fetchData().getAnniKills(op.getUniqueId()));
        anniLore.add("§eSmrti: §7" + Main.getInstance().fetchData().getAnniDeaths(op.getUniqueId()));
        anniLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getAnniWins(op.getUniqueId()));
        anniLore.add("§eProhry: §7" + Main.getInstance().fetchData().getAnniLosses(op.getUniqueId()));
        anniLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getAnniPlayedGames(op.getUniqueId()));
        anniLore.add("§eZniceno Nexusu: §7" + Main.getInstance().fetchData().getAnniDestroyed(op.getUniqueId()));
        anniLore.add("§eZabito Bossu: §7" + Main.getInstance().fetchData().getAnniKillBoss(op.getUniqueId()));
        anniLore.add("§eVykopano dia: §7" + Main.getInstance().fetchData().getAnniMinedDiamond(op.getUniqueId()));
        anniMeta.setLore(anniLore);
        anni.setItemMeta(anniMeta);

        ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
        ItemMeta bMeta = buildbattle.getItemMeta();
        bMeta.setDisplayName("§fBuildBattle");
        ArrayList<String> bbLore = new ArrayList();
        bbLore.add("");
        bbLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getBuildBattleWins(op.getUniqueId()));
        bbLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getBuildBattlePlayedGames(op.getUniqueId()));
        //bbLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBuildBattleTime(p.getUniqueId()), false));
        bMeta.setLore(bbLore);
        buildbattle.setItemMeta(bMeta);

        ItemStack vanilla = new ItemStack(Material.EMERALD);
        ItemMeta vanMeta = vanilla.getItemMeta();
        vanMeta.setDisplayName("§fVanilla");
        ArrayList<String> vanLore = new ArrayList();
        vanLore.add("§cDocasne nefunguji.");
        vanMeta.setLore(vanLore);
        vanilla.setItemMeta(vanMeta);

        ItemStack skywars = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta swMeta = skywars.getItemMeta();
        swMeta.setDisplayName("§fSkyWars");
        ArrayList<String> swLore = new ArrayList();
        swLore.add("");
        swLore.add("§eZabiti: §7" + Main.getInstance().fetchData().getSkyWarsKills(op.getUniqueId()));
        swLore.add("§eSmrti: §7" + Main.getInstance().fetchData().getSkyWarsDeaths(op.getUniqueId()));
        swLore.add("§eVitezstvi: §7" + Main.getInstance().fetchData().getSkyWarsWins(op.getUniqueId()));
        swLore.add("§eOdehrano her: §7" + Main.getInstance().fetchData().getSkyWarsPlayed(op.getUniqueId()));
        swLore.add("");
        swLore.add("§bSkyDust: §7" + Main.getInstance().fetchData().getSkyKeysDust(op.getUniqueId()));
        swLore.add("§810x SkyDust = 1x SkyKeys");
        swMeta.setLore(swLore);
        skywars.setItemMeta(swMeta);

        minigamesMenu.setItem(13, headItem);
        minigamesMenu.setItem(20, bedwars);
        minigamesMenu.setItem(21, drawit);
        minigamesMenu.setItem(22, anni);
        minigamesMenu.setItem(23, buildbattle);
        minigamesMenu.setItem(24, skywars);
        minigamesMenu.setItem(31, vanilla);

        p.openInventory(minigamesMenu);
    }

}
