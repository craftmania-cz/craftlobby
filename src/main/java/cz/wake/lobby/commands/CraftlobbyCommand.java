package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import cz.wake.lobby.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;

@CommandAlias("craftlobby|cl")
public class CraftlobbyCommand extends BaseCommand {

    @Subcommand("debug")
    @Description("Změní stav debugu")
    @CommandPermission("craftlobby.admin")
    public void debugCommand(CommandSender sender) {
        if (Main.getInstance().debug) {
            sender.sendMessage("§2[DEBUG] §7- §fByl deaktivován.");
        } else {
            sender.sendMessage("§2[DEBUG] §7- §fByl aktivován.");
        }
        Main.getInstance().debug = !Main.getInstance().debug;
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
