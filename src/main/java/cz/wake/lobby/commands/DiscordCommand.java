package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("discord")
@Description("Pošle ti odkaz na náš Discord server")
public class DiscordCommand extends BaseCommand {

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }

    @Default
    public void sendDiscordLink(CommandSender sender) {
        if(sender instanceof Player) {
            sender.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
            sender.sendMessage("");
            sender.sendMessage("§bOdkaz na náš Discord server:");
            sender.sendMessage("§ehttps://discord.gg/craftmania");
            sender.sendMessage("");
            sender.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
        }
    }
}