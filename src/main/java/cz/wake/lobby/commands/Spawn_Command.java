package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("spawn")
@Description("Teleportuje tě na spawn")
public class Spawn_Command extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
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

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
