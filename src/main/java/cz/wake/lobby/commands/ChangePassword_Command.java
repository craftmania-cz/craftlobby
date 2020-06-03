package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.lobby.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("changepassword|zmenahesla")
@Description("Poskytne ti možnost změnit si heslo")
public class ChangePassword_Command extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;

        if(Main.getInstance().getSQL().isInDatabase(player.getName(), player.getUniqueId())) {
            player.sendMessage("§cHráč s originálním Minecraftem si nemůže změnit heslo.");
            return;
        }

        try {
            player.sendMessage("§eTeleportuji na server §fwhub-change");
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "whub-change");
        } catch (Exception e) {
            e.printStackTrace();
            player.sendMessage("§cTeleport na server §fwhub-change §cse nezdařil!");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
