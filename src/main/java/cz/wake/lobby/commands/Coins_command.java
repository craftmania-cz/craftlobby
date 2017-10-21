package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Coins_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("craftcoins"))) {
            if (Sender.hasPermission("craftlobby.craftcoins") && Sender.isOp()) {
                if (ArrayOfString.length == 0) {
                    Sender.sendMessage("§cNapoveda: /craftcoins nick castka");
                    return false;
                } else {
                    String name = ArrayOfString[0];
                    String castka = ArrayOfString[1];
                    int sum = Integer.valueOf(castka);
                    try {
                        Main.getInstance().fetchData().addCoins(Bukkit.getPlayer(name),sum);
                        Sender.sendMessage("§eNa ucet §f" + name + " §ebylo pridano §a" + sum + " CC");
                        Bukkit.getPlayer(name).sendMessage("§eBylo ti pridano " + castka + " CC");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
