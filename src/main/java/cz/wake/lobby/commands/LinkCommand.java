package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.lobby.Main;
import org.apache.commons.lang3.RandomStringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("link")
@Description("Spáruje tvůj účet s Discordem")
public class LinkCommand extends BaseCommand {

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player p = (Player) sender;

        if (Main.getInstance().getSQL().isConnectedToDiscord(p)) {
            p.sendMessage("§c§l[!] §cTento účet již je propojen s Discord účtem!");
            return;
        }

        if (Main.getInstance().getSQL().hasConnectionRequest(p)) {
            p.sendMessage("§eTvůj předcházejici kód ještě neexpiroval: " + Main.getInstance().getSQL().getConnectionCode(p));
            return;
        }

        String code = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
        Main.getInstance().getSQL().createConnectionRequest(p, code);
        p.sendMessage("§6Zahájil jsi propojování s Discord účtem!");
        p.sendMessage("§eZajdi na náš Discord server (discord.gg/craftmania) a do #bot_prikazy a zadej příkaz §6/link " + code);
        p.sendMessage("§eNásledně se ti propojí tvůj Minecraft účet s Discord účtem a budeš mit jednodušší přístup ke všem statistikám. Tvůj kód expiruje za 5 minut.");
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
