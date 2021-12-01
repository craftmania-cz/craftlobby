package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import cz.craftmania.craftcore.inventory.builder.SmartInventory;
import cz.wake.lobby.gui.TutorialGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("tutorial")
@Description("Tutorial...")
public class TutorialCommand extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        SmartInventory.builder().size(6, 9).title("Tutorial & Info").provider(new TutorialGUI()).build().open(player);
    }
}
