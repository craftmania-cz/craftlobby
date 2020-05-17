package cz.wake.lobby.seasons.christmas;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("kalendar")
@Description("Otevře vánoční kalendář")
public class Kalendar_command extends BaseCommand {
    Kalendar k = new Kalendar();

    @Default
    public void defaultCommand(CommandSender sender) {
            if(sender instanceof Player){
                k.openKalendar(((Player) sender).getPlayer());
            } else {
                sender.sendMessage("No tak asi tady tezko :D");
            }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
