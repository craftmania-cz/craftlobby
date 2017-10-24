package cz.wake.lobby.commands;

import cz.wake.lobby.gui.StatisticsMG;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stats_Command implements CommandExecutor {

    private StatisticsMG minigamesMenu = new StatisticsMG();

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("stats"))) {
                try {
                    if (ArrayOfString.length == 0) {
                        minigamesMenu.openMinigamesMenu(player);
                        return true;
                    } else {
                        if (((Player) Sender).getPlayer().hasPermission("craftlobby.stats.vip")) {
                            OfflinePlayer offPlayer = Bukkit.getServer().getOfflinePlayer(ArrayOfString[0].toString());
                            minigamesMenu.openOfflineStats(player, offPlayer);
                            return true;
                        } else {
                            player.sendMessage("§cK pristupu statistikam ostatnich hracu musis vlastnit MiniGames VIP.");
                            return false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return false;
        }
        return false;
    }
}
