package cz.wake.plugins.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;

public class UtilServer {

	public static Server getServer(){
		return Bukkit.getServer();
	}
	
	public static int getPlayers(){
		return getServer().getOnlinePlayers().size();
	}
}
