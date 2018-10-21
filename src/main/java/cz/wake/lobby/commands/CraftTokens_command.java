package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CraftTokens_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("oldcrafttokens"))) {
            if (Sender.hasPermission("craftlobby.crafttokens") && Sender.isOp()) {
                if (ArrayOfString.length == 0) {
                    Sender.sendMessage("§cNapoveda: /oldcrafttokens nick castka");
                    return false;
                } else {
                    String name = ArrayOfString[0];
                    String castka = ArrayOfString[1];
                    int sum = Integer.valueOf(castka);
                    try {
                        Main.getInstance().getSQL().addTokens(name, sum);
                        Sender.sendMessage("§eNa ucet §f" + name + " §ebylo pridano §c" + sum + " CT");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
