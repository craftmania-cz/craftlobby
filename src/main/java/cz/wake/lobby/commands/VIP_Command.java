package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("vip")
@Description("Zobrazí výhody VIP")
public class VIP_Command extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender, String args) {
        if (!(sender instanceof Player)) return;
        //vip.openVIPMenu(player);
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
