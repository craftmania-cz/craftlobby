package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Seen_Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(sender instanceof Player) {
            if(Main.getInstance().getSQL().sawLatestNews((Player) sender)) {
                sender.sendMessage("§eNovinka jiz byla prectena, takze ji nemuzes precist znova.");
            } else {
                Main.getInstance().getSQL().seeLatestNews((Player) sender);
                sender.sendMessage("§eNovinka byla prectena.");
            }
        }
        return false;
    }
}
