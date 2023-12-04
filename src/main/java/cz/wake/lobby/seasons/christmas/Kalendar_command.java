package cz.wake.lobby.seasons.christmas;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.craftmania.craftlibs.utils.ChatInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("kalendar")
@Description("Otevře vánoční kalendář")
public class Kalendar_command extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
            if(sender instanceof Player player){
                ChatInfo.INFO.send(player, "Kalendář lze vybrat pouze na serverech - Survival, Oneblock & Creative");
            } else {
                sender.sendMessage("No tak asi tady tezko :D");
            }
    }
}
