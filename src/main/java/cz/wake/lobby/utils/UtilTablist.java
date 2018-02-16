package cz.wake.lobby.utils;

import org.bukkit.entity.Player;

public class UtilTablist {

    public static void setupPrefixInTab(final Player p) {
        if (p.hasPermission("craftlobby.prefix.majitel")) {
            p.setPlayerListName("§3§lMAJITEL §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.hladmin")) {
            p.setPlayerListName("§c§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.hlbuilder")) {
            p.setPlayerListName("§1§lHL.BUILDER §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.developer")) {
            p.setPlayerListName("§e§lDEVELOPER §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.eventer")) {
            p.setPlayerListName("§d§lEVENTER §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.adminka")) {
            p.setPlayerListName("§c§lADMINKA §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.admin")) {
            p.setPlayerListName("§c§lADMIN §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.builder")) {
            p.setPlayerListName("§1§lBUILDER §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.helper")) {
            p.setPlayerListName("§2§lHELPER §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.hero")) {
            p.setPlayerListName("§5§lHERO §f" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.vip")) {
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§f" + p.getName());
        }
    }
}
