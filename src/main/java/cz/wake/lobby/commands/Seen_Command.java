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

@CommandAlias("precteno")
@Description("Potvrdíš, že sis přečetl novinku")
public class Seen_Command extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;

        if (Main.getInstance().getSQL().sawLatestNews((Player) sender)) {
            sender.sendMessage("§eNovinka již byla přečtena, takže ji nemůžeš přečíst znovu.");
        } else {
            Main.getInstance().getSQL().seeLatestNews((Player) sender);
            sender.sendMessage("§eNovinka byla přečtena.");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
