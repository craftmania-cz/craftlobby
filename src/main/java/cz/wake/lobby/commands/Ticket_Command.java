package cz.wake.lobby.commands;

import cz.wake.lobby.vanoce.TicketSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ticket_Command implements CommandExecutor {

    TicketSystem t = new TicketSystem();

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("ticket"))) {
            if(Sender instanceof Player){
                t.openTicketMenu(((Player) Sender).getPlayer());
                return true;
            } else {
                Sender.sendMessage("No tak asi tady tezko :D");
                return false;
            }
        }
        return false;
    }
}
