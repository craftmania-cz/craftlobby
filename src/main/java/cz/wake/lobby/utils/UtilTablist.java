package cz.wake.lobby.utils;

import org.bukkit.entity.Player;

public class UtilTablist {

    public static void setupPrefixInTab(final Player p){
        if(p.hasPermission("craftlobby.prefix.majitel")){
            p.setPlayerListName("§3§lMAJITEL §b" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.hladmin")){
            p.setPlayerListName("§c§lHL.ADMIN §7" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.admin")){
            p.setPlayerListName("§c§lADMIN §7" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.builder")){
            p.setPlayerListName("§5§lBUILDER §7" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.helper")){
            p.setPlayerListName("§2§lHELPER §7" + p.getName());
        } else if (p.hasPermission("craftlobby.prefix.vip")){
            p.setPlayerListName("§a§lVIP §7");
        } else {
            p.setPlayerListName("§7" + p.getName());
        }
    }
}
