package cz.wake.lobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OldLobbyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("oldlobby"))) {
                if (Bukkit.getServer().getWorlds().contains(Bukkit.getWorld("OfficialLobby"))) {
                    Location loc = new Location(Bukkit.getWorld("OfficialLobby"), 1249.5, 39.5, 498.5, 90, 0);
                    player.teleport(loc);
                    player.sendMessage("§eDostal jsi se na stare lobby CM, ktere slouzilo na serveru v letech 2015-2016!");
                } else {
                    player.sendMessage("§cTento server bohuzel neni stary original, musis to zkusit na jinem lobby!");
                }

            }
        }
        return false;
    }
}
