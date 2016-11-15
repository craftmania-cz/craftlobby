package cz.wake.lobby.commands;

import cz.wake.lobby.API.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CBPerms_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("cbperms"))) {
            if (Sender.hasPermission("craftlobby.cbperms")) {
                if (ArrayOfString.length == 0) {
                    Sender.sendMessage("§cNapoveda: /cbperms nick pravo nazev");
                    return false;
                } else {
                    Player p = Bukkit.getPlayer(ArrayOfString[0]); //Hrac musi byt online!
                    String perm = ArrayOfString[1];
                    String nazev = ArrayOfString[2];
                    String finalNazev = nazev.replaceAll("_", " ");
                    if(p.hasPermission(perm)){
                        p.sendMessage("§bCraftBox §8┃ §7Tento gadget jiz vlastnis! Nasel jsi: " + finalNazev);
                        Sender.sendMessage("§eHrac jiz §f" + finalNazev + " §evlastni.");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"coins give " + p.getName() + " 50");
                        return true;
                    } else {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add " + perm);
                        for (Player pl : Bukkit.getOnlinePlayers()){
                            if(pl == p){
                                p.sendMessage("§bCraftBox §8┃ §7Nasel jsi novy gadget: " + finalNazev);
                                TitleAPI.sendFullTitlePlayer(p,10,70,10,"§eNasel jsi",finalNazev);
                            } else {
                                pl.sendMessage("§bCraftBox §8┃ §e" + p.getName() + " §7nasel v CraftBoxu " + finalNazev);
                            }
                        }
                    }
                }
            } else {
                Sender.sendMessage("§cNedostatecna prava na provedeni totoho prikazu!");
                return false;
            }
        }
        return false;
    }
}
