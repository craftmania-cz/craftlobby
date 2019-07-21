package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Link_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player p = (Player) sender;

        if (Main.getInstance().getSQL().isConnectedToDiscord(p)) {
            p.sendMessage("§c§l(!) §cTento ucet jiz je propojen s Discord uctem!");
            return true;
        }

        if (Main.getInstance().getSQL().hasConnectionRequest(p)) {
            p.sendMessage("§aTvuj predchazejici kod jeste nevyexpiroval: " + Main.getInstance().getSQL().getConnectionCode(p));
            return true;
        }

        String code = RandomStringUtils.randomAlphabetic(8).toUpperCase();
        Main.getInstance().getSQL().createConnectionRequest(p, code);
        p.sendMessage("§6Zahajil jsi prepojovani s Discord uctem!");
        p.sendMessage("§aZajdi na nas Discord server do #bot_prikazy a zadej prikaz ,link " + code);
        p.sendMessage("§aTvuj kod expiruje za 5 minut.");
        return true;
    }
}
