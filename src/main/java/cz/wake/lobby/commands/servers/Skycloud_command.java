package cz.wake.lobby.commands.servers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.lobby.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("skycloud")
@Description("Teleportuje tě na server SkyCloud")
public class Skycloud_command extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        try {
            sender.sendMessage("§eTeleportuji na server §fSkyCloud");
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skycloud");
        } catch (Exception e) {
            e.printStackTrace();
            sender.sendMessage("§cTeleport na server §fSkyCloud §cse nezdařil!");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
