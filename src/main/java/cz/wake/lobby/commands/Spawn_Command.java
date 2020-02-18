package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn_Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            if (Command.getName().equalsIgnoreCase("spawn")) {
                Player player = (Player) Sender;
                player.sendMessage("§eTeleportuji tě na spawn lobby serveru!");
                    /*
                    * Jestli v configu bude auto-get na FALSE tak si to získá data z "location-info"
                    */
                if (Main.getInstance().getConfig().getBoolean("spawn-command.auto-get")) {
                        //tp hráče z getSpawnLocation()
                    player.teleport(player.getLocation().getWorld().getSpawnLocation());
                    if (Main.getInstance().debug || Main.getInstance().getConfig().getBoolean("debug")) {
                        player.sendMessage("§2[DEBUG] §7- §fSpawn lokace hráče je: §8" + player.getLocation().getWorld().getSpawnLocation());
                    }
                } else {
                    Location spawnLocation = new Location(
                            Bukkit.getWorld(Main.getInstance().getConfig().getString("spawn-command.location.world-name")),
                            Main.getInstance().getConfig().getDouble("spawn-command.location.x"),
                            Main.getInstance().getConfig().getDouble("spawn-command.location.y"),
                            Main.getInstance().getConfig().getDouble("spawn-command.location.z"),
                            (float) Main.getInstance().getConfig().getDouble("spawn-command.location.yaw"),
                            (float) Main.getInstance().getConfig().getDouble("spawn-command.location.pitch")
                            );
                    //tp hráče z configu
                    player.teleport(spawnLocation);
                    if (Main.getInstance().debug || Main.getInstance().getConfig().getBoolean("debug")) {
                        player.sendMessage("§2[DEBUG] §7- §fSpawn lokace configu je: §8" + spawnLocation);
                    }
                }
            }
        }
        return true;
    }

}
