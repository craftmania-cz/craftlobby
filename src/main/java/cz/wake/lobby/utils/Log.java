package cz.wake.lobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Log {

    public static void info(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[CraftLobby] " + ChatColor.WHITE + s);
    }

    public static void danger(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[CraftLobby] " + ChatColor.RED + s);
    }

    public static void warning(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[CraftLobby] " + ChatColor.GOLD + s);
    }

    public static void success(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[CraftLobby] " + ChatColor.GREEN + s);
    }



}
