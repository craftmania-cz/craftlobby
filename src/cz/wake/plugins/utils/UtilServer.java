package cz.wake.plugins.utils;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class UtilServer {

	public static Server getServer(){
		return Bukkit.getServer();
	}
	
	public static int getPlayers(){
		return getServer().getOnlinePlayers().size();
	}
}
