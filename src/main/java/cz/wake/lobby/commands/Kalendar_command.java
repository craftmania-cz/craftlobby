package cz.wake.lobby.commands;

import cz.wake.lobby.vanoce.EventParkour;
import cz.wake.lobby.vanoce.Kalendar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kalendar_command implements CommandExecutor {

    Kalendar k = new Kalendar();
    EventParkour e = new EventParkour();

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("kalendar"))) {
            if(Sender instanceof Player){
                //k.openKalendar(((Player) Sender).getPlayer());
                e.sendToParkourEvent((Player)Sender);
                return true;
            } else {
                Sender.sendMessage("No tak asi tady tezko :D");
                return false;
            }
        }
        return false;
    }
}
