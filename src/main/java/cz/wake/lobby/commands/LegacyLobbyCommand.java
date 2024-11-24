package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.craftmania.craftcore.inventory.builder.SmartInventory;
import cz.craftmania.craftlibs.utils.ChatInfo;
import cz.wake.lobby.Main;
import cz.wake.lobby.gui.OldLobbyGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("oldlobby")
@Description("Starý lobby? OH YES!")
public class LegacyLobbyCommand extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        try {
            SmartInventory.builder().size(3, 9).title("Legacy Lobby").provider(new OldLobbyGUI()).build().open(player);
        } catch (Exception e) {
            e.printStackTrace();
            ChatInfo.DANGER.send(player,"Nepodařilo se otevřít menu? Lol...");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
