package cz.wake.lobby.commands.servers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.craftmania.craftlibs.utils.ChatInfo;
import cz.wake.lobby.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("bedwars")
@Description("Teleportuje tě na server Bedwars lobby")
public class BedwarsCommand extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        try {
            ChatInfo.INFO.send(player,"Teleportuji tě na server §fBedwars Legacy 2015");
            Main.getInstance().sendToServer(player, "blobby");
        } catch (Exception e) {
            e.printStackTrace();
            ChatInfo.DANGER.send(player,"Teleport na server Bedwars Legacy 2015 se nezdařil!");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}