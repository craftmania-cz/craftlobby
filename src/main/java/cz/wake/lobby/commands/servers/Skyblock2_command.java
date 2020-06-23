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

@CommandAlias("skyblock2")
@Description("Teleportuje tě na server SkyBlock 1.15")
public class Skyblock2_command extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        try {
            player.sendMessage("§eTeleportuji na server §fSkyblock 1.15");
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock2");
        } catch (Exception e) {
            e.printStackTrace();
            player.sendMessage("§cTeleport na server §fSkyblock 1.15 §cse nezdařil!");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}