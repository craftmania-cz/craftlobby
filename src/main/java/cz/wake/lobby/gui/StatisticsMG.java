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
        hLore.add("§eCraftCoiny: §7" + Main.getInstance().getSQL().getCraftCoins(p.getUniqueId()) + " CC");
        hLore.add("");
        hLore.add("§ePocet hlasu (tyden): §7" + Main.getInstance().getSQL().getVotesWeek(p.getUniqueId()));
        hLore.add("§ePocet hlasu (mesic): §7" + Main.getInstance().getSQL().getVotesMonth(p.getUniqueId()));
        hLore.add("§ePocet hlasu (celkem): §7" + Main.getInstance().getSQL().getVotesAll(p.getUniqueId()));
        headItemMeta.setLore(hLore);
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        headItem.setItemMeta(headItemMeta);

        ItemStack bedwars = new ItemStack(Material.BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName("§fBedWars");
        ArrayList<String> bedwarsLore = new ArrayList();
        bedwarsLore.add("");
        bedwarsLore.add("§eScore: §7" + Main.getInstance().getSQL().getBedwarsScore(p.getUniqueId()));
        bedwarsLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getBedwarsWins(p.getUniqueId()));
        bedwarsLore.add("§eProhry: §7" + Main.getInstance().getSQL().getBedwarsLoses(p.getUniqueId()));
        bedwarsLore.add("§eZabiti: §7" + Main.getInstance().getSQL().getBedwarsKills(p.getUniqueId()));
        bedwarsLore.add("§eSmrti: §7" + Main.getInstance().getSQL().getBedwarsDeaths(p.getUniqueId()));
        bedwarsLore.add("§eZniceno posteli: §7" + Main.getInstance().getSQL().getBedwarsDestroyed(p.getUniqueId()));
        bedwarsLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getBedwarsPlayed(p.getUniqueId()));
        //bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p.getUniqueId()), false)*/);
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack drawit = new ItemStack(Material.PAINTING);
        ItemMeta drawitMeta = drawit.getItemMeta();
        drawitMeta.setDisplayName("§fDrawIt");
        ArrayList<String> drawitLore = new ArrayList();
        drawitLore.add("");
        drawitLore.add("§eScore: §7" + Main.getInstance().getSQL().getDrawitScore(p.getUniqueId()));
        drawitLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getDrawitWins(p.getUniqueId()));
        drawitLore.add("§eProhry: §7" + Main.getInstance().getSQL().getDrawitLoses(p.getUniqueId()));
        drawitLore.add("§eSpravne uhadnuti: §7" + Main.getInstance().getSQL().getDrawitRightGuess(p.getUniqueId()));
        drawitLore.add("§eSpatne uhadnuti: §7" + Main.getInstance().getSQL().getDrawitWrongGuess(p.getUniqueId()));
        drawitLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getDrawitPlayed(p.getUniqueId()));
        //rawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p.getUniqueId()), false));
        drawitMeta.setLore(drawitLore);
        drawit.setItemMeta(drawitMeta);

        ItemStack anni = new ItemStack(Material.ENDER_STONE);
        ItemMeta anniMeta = anni.getItemMeta();
        anniMeta.setDisplayName("§fAnnihilation");
        ArrayList<String> anniLore = new ArrayList();
        anniLore.add("");
        anniLore.add("§eZabiti: §7" + Main.getInstance().getSQL().getAnniKills(p.getUniqueId()));
        anniLore.add("§eSmrti: §7" + Main.getInstance().getSQL().getAnniDeaths(p.getUniqueId()));
        anniLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getAnniWins(p.getUniqueId()));
        anniLore.add("§eProhry: §7" + Main.getInstance().getSQL().getAnniLosses(p.getUniqueId()));
        anniLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getAnniPlayedGames(p.getUniqueId()));
        anniLore.add("§eZniceno Nexusu: §7" + Main.getInstance().getSQL().getAnniDestroyed(p.getUniqueId()));
        anniLore.add("§eZabito Bossu: §7" + Main.getInstance().getSQL().getAnniKillBoss(p.getUniqueId()));
        anniLore.add("§eVykopano dia: §7" + Main.getInstance().getSQL().getAnniMinedDiamond(p.getUniqueId()));
        anniMeta.setLore(anniLore);
        anni.setItemMeta(anniMeta);

        ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
        ItemMeta bMeta = buildbattle.getItemMeta();
        bMeta.setDisplayName("§fBuildBattle");
        ArrayList<String> bbLore = new ArrayList();
        bbLore.add("");
        bbLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getBuildBattleWins(p.getUniqueId()));
        bbLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getBuildBattlePlayedGames(p.getUniqueId()));
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
        swLore.add("§eZabiti (S+I): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_kills"));
        swLore.add("§eSmrti (S+I): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_deaths"));
        swLore.add("§eVitezstvi (S+I): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_wins"));
        swLore.add("§eOdehrano her (S+I): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_played"));
        swLore.add("");
        swLore.add("§eZabiti (Team): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_kills"));
        swLore.add("§eSmrti (Team): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_deaths"));
        swLore.add("§eVitezstvi (Team): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_wins"));
        swLore.add("§eOdehrano (Team): §7" + Main.getInstance().getSQL().getMiniGamesStats(p, "skywars_players", "player_name", "normal_team_played"));
        swLore.add("§bSkyDust: §7" + Main.getInstance().getSQL().getSkyKeysDust(p.getUniqueId()));
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
        hLore.add("§eCraftCoiny: §7" + Main.getInstance().getSQL().getCraftCoins(op.getUniqueId()) + " CC");
        hLore.add("");
        hLore.add("§ePocet hlasu (tyden): §7" + Main.getInstance().getSQL().getVotesWeek(op.getUniqueId()));
        hLore.add("§ePocet hlasu (mesic): §7" + Main.getInstance().getSQL().getVotesMonth(op.getUniqueId()));
        hLore.add("§ePocet hlasu (celkem): §7" + Main.getInstance().getSQL().getVotesAll(op.getUniqueId()));
        headItemMeta.setLore(hLore);
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        headItem.setItemMeta(headItemMeta);

        ItemStack bedwars = new ItemStack(Material.BED);
        ItemMeta bedwarsMeta = bedwars.getItemMeta();
        bedwarsMeta.setDisplayName("§fBedWars");
        ArrayList<String> bedwarsLore = new ArrayList();
        bedwarsLore.add("");
        bedwarsLore.add("§eScore: §7" + Main.getInstance().getSQL().getBedwarsScore(op.getUniqueId()));
        bedwarsLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getBedwarsWins(op.getUniqueId()));
        bedwarsLore.add("§eProhry: §7" + Main.getInstance().getSQL().getBedwarsLoses(op.getUniqueId()));
        bedwarsLore.add("§eZabiti: §7" + Main.getInstance().getSQL().getBedwarsKills(op.getUniqueId()));
        bedwarsLore.add("§eSmrti: §7" + Main.getInstance().getSQL().getBedwarsDeaths(op.getUniqueId()));
        bedwarsLore.add("§eZniceno posteli: §7" + Main.getInstance().getSQL().getBedwarsDestroyed(op.getUniqueId()));
        bedwarsLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getBedwarsPlayed(op.getUniqueId()));
        //bedwarsLore.add(ChatColor.YELLOW + "Odehrany cas: §cPozastaveno" /*ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getBedWarsTime(p.getUniqueId()), false)*/);
        bedwarsMeta.setLore(bedwarsLore);
        bedwars.setItemMeta(bedwarsMeta);

        ItemStack drawit = new ItemStack(Material.PAINTING);
        ItemMeta drawitMeta = drawit.getItemMeta();
        drawitMeta.setDisplayName("§fDrawIt");
        ArrayList<String> drawitLore = new ArrayList();
        drawitLore.add("");
        drawitLore.add("§eScore: §7" + Main.getInstance().getSQL().getDrawitScore(op.getUniqueId()));
        drawitLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getDrawitWins(op.getUniqueId()));
        drawitLore.add("§eProhry: §7" + Main.getInstance().getSQL().getDrawitLoses(op.getUniqueId()));
        drawitLore.add("§eSpravne uhadnuti: §7" + Main.getInstance().getSQL().getDrawitRightGuess(op.getUniqueId()));
        drawitLore.add("§eSpatne uhadnuti: §7" + Main.getInstance().getSQL().getDrawitWrongGuess(op.getUniqueId()));
        drawitLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getDrawitPlayed(op.getUniqueId()));
        //rawitLore.add(ChatColor.YELLOW + "Odehrany cas: " + ChatColor.WHITE + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().getAPI().getDrawItTime(p.getUniqueId()), false));
        drawitMeta.setLore(drawitLore);
        drawit.setItemMeta(drawitMeta);

        ItemStack anni = new ItemStack(Material.ENDER_STONE);
        ItemMeta anniMeta = anni.getItemMeta();
        anniMeta.setDisplayName("§fAnnihilation");
        ArrayList<String> anniLore = new ArrayList();
        anniLore.add("");
        anniLore.add("§eZabiti: §7" + Main.getInstance().getSQL().getAnniKills(op.getUniqueId()));
        anniLore.add("§eSmrti: §7" + Main.getInstance().getSQL().getAnniDeaths(op.getUniqueId()));
        anniLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getAnniWins(op.getUniqueId()));
        anniLore.add("§eProhry: §7" + Main.getInstance().getSQL().getAnniLosses(op.getUniqueId()));
        anniLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getAnniPlayedGames(op.getUniqueId()));
        anniLore.add("§eZniceno Nexusu: §7" + Main.getInstance().getSQL().getAnniDestroyed(op.getUniqueId()));
        anniLore.add("§eZabito Bossu: §7" + Main.getInstance().getSQL().getAnniKillBoss(op.getUniqueId()));
        anniLore.add("§eVykopano dia: §7" + Main.getInstance().getSQL().getAnniMinedDiamond(op.getUniqueId()));
        anniMeta.setLore(anniLore);
        anni.setItemMeta(anniMeta);

        ItemStack buildbattle = new ItemStack(Material.WORKBENCH);
        ItemMeta bMeta = buildbattle.getItemMeta();
        bMeta.setDisplayName("§fBuildBattle");
        ArrayList<String> bbLore = new ArrayList();
        bbLore.add("");
        bbLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getBuildBattleWins(op.getUniqueId()));
        bbLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getBuildBattlePlayedGames(op.getUniqueId()));
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
        swLore.add("§eZabiti: §7" + Main.getInstance().getSQL().getSkyWarsKills(op.getUniqueId()));
        swLore.add("§eSmrti: §7" + Main.getInstance().getSQL().getSkyWarsDeaths(op.getUniqueId()));
        swLore.add("§eVitezstvi: §7" + Main.getInstance().getSQL().getSkyWarsWins(op.getUniqueId()));
        swLore.add("§eOdehrano her: §7" + Main.getInstance().getSQL().getSkyWarsPlayed(op.getUniqueId()));
        swLore.add("");
        swLore.add("§bSkyDust: §7" + Main.getInstance().getSQL().getSkyKeysDust(op.getUniqueId()));
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
