package cz.wake.plugins.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cz.wake.plugins.GUI.GadgetsMenu;
import cz.wake.plugins.GUI.HeadsMenu;
import cz.wake.plugins.GUI.Menu;
import cz.wake.plugins.GUI.StatisticsMG;

public class ProfilCMD implements CommandExecutor{
	
	Menu menu = new Menu();
	StatisticsMG minigamesMenu = new StatisticsMG();
	GadgetsMenu gadgetsMenu = new GadgetsMenu();
	HeadsMenu hatsmenu = new HeadsMenu();
	
	public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString){
		if(Sender instanceof Player){
			Player player = (Player)Sender;
			if((Command.getName().equalsIgnoreCase("wlobby")) || (Command.getName().equalsIgnoreCase("wl"))){
				if(ArrayOfString.length == 0){
					player.sendMessage("  ");
					player.sendMessage(ChatColor.YELLOW + "Pouzij nasledujici prikazy:");
					player.sendMessage(ChatColor.AQUA + "/wlobby menu" + ChatColor.GRAY + " - Otevre hlavni menu");
					player.sendMessage(ChatColor.AQUA + "/wlobby minigames" + ChatColor.GRAY + " - Otevre minigames menu");
					player.sendMessage("" );
					return true;
				}
				else if(ArrayOfString[0].equalsIgnoreCase("menu")){
					if(((Player) Sender).getPlayer().hasPermission("craftlobby.beta")){
						this.menu.openMenu(player);
						return true;
					}
				}
				else if(ArrayOfString[0].equalsIgnoreCase("minigames")){
					this.minigamesMenu.openMinigamesMenu(player);
					return true;
				}
				return true;
			}
		}
		return false;
	}
}
