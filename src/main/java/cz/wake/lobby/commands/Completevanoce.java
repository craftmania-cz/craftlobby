package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Completevanoce implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((command.getName().equalsIgnoreCase("completevanoce"))) {
            if (sender.hasPermission("craftlobby.admin") && sender.isOp()) {
                if (args.length == 0) {
                    sender.sendMessage("§cNapoveda: /completevanoce nick");
                    return false;
                } else {
                    String name = args[0];
                    try {
                        Player p = Bukkit.getPlayer(name);
                        Main.getInstance().fetchData().completeVanoce(p);
                        sender.sendMessage("§ePridan §f" + name + " §ena seznam.");
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
