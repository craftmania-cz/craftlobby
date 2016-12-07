package cz.wake.lobby.commands;

import cz.wake.lobby.listeners.PlayerListener;
import cz.wake.lobby.vanoce.EventParkour;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Leave_command implements CommandExecutor {

    EventParkour ep = new EventParkour();

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if ((Command.getName().equalsIgnoreCase("quit"))) {
            if(Sender instanceof Player){
                if(ep.getList().contains((Player)Sender)){
                    ((Player)Sender).performCommand("spawn");
                    ep.getList().remove((Player)Sender);
                    for(Player p2 : Bukkit.getOnlinePlayers()){
                        if(!ep.getList().contains(p2)){
                            ((Player)Sender).showPlayer(p2);
                        }
                    }
                    PlayerListener.setupDefaultItems((Player)Sender);
                    return true;
                }
            }
        }
        return false;
    }
}
