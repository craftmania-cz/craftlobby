package cz.wake.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VIP_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("vip"))) {
                if (ArrayOfString.length == 0) {
                    //vip.openVIPMenu(player);
                    return true;
                }
            }
        }
        return false;
    }
}
