package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CompleteHalloween implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("completehalloween"))) {
            if (Sender.hasPermission("craftlobby.admin") && Sender.isOp()) {
                if (ArrayOfString.length == 0) {
                    Sender.sendMessage("§cNapoveda: /completehalloween nick");
                    return false;
                } else {
                    String name = ArrayOfString[0];
                    try {
                        Player p = Bukkit.getPlayer(name);
                        Main.getInstance().fetchData().completeHalloween(p);
                        Sender.sendMessage("§ePridan §f" + name + " §ena seznam.");
                        Bukkit.getPlayer(name).sendMessage("§eDokoncil jsi hledani headek! Brzo dostanes na svuj profil specialni badge!");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
