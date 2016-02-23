package cz.wake.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cz.wake.plugins.GUI.StatisticsMG;

public class Stats_Command implements CommandExecutor{
	
	StatisticsMG minigamesMenu = new StatisticsMG();

	@Override
	public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
		if(Sender instanceof Player){
			Player player = (Player)Sender;
			if((Command.getName().equalsIgnoreCase("stats"))){
				if(ArrayOfString.length == 0){
					minigamesMenu.openMinigamesMenu(player);
					return true;
				} else {
					if(((Player) Sender).getPlayer().hasPermission("craftlobby.stats.vip")){
						OfflinePlayer offPlayer = Bukkit.getServer().getOfflinePlayer(ArrayOfString[0].toString());
						minigamesMenu.openOfflineStats(player, offPlayer);
						return true;
					} else {
						player.sendMessage("§cK pristupu statistikam ostatnich hracu musis vlastnit MiniGames VIP.");
						return false;
					}
				}
				
			}
			return false;
		}
		return false;
	}
	
	

}
