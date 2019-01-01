package cz.wake.lobby.commands.servers;

import cz.wake.lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Skyblock_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("skyblock"))) {
                try {
                    player.sendMessage("§eTeleportuji na server §fSkyblock");
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock");
                } catch (Exception e) {
                    e.printStackTrace();
                    player.sendMessage("§cTeleport na server §fSkyblock §cse nezdaril!");
                }
            }
        }
        return false;
    }
}
