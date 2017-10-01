package cz.wake.lobby.commands;

import cz.wake.lobby.utils.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SBPerms_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("sbperms"))) {
            if (Sender.hasPermission("craftlobby.sbperms")) {
                try {
                    if (ArrayOfString.length == 0) {
                        Sender.sendMessage("§cNapoveda: /sbperms nick pravo nazev");
                        return false;
                    } else {
                        Player p = Bukkit.getPlayer(ArrayOfString[0]); //Hrac musi byt online!
                        String perm = ArrayOfString[1];
                        String nazev = ArrayOfString[2];
                        String finalNazev = nazev.replaceAll("_", " ");
                        if (p.hasPermission(perm)) {
                            p.sendMessage("§eTento doplnek jiz vlastnis! Nalezena vec: §f" + finalNazev);
                            Sender.sendMessage("§eHrac jiz §f" + finalNazev + " §evlastni.");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 50");
                            return true;
                        } else {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set " + perm + " true");
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                if (pl.equals(p)) {
                                    p.sendMessage("§eNasel jsi novy doplnek: §b" + finalNazev);
                                    TitleAPI.sendFullTitlePlayer(p, 10, 70, 10, "§eNasel jsi", finalNazev);
                                } else {
                                    pl.sendMessage("§aSkybox §8┃ §b" + p.getName() + " §enasel ve Skyboxu §6" + finalNazev);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Sender.sendMessage("§cNedostatecna prava na provedeni totoho prikazu!");
                return false;
            }
        }
        return false;
    }
}
