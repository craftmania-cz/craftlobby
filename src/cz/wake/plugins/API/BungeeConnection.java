package cz.wake.plugins.API;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import cz.wake.plugins.Main;

public class BungeeConnection implements PluginMessageListener {
	
	private String serverName;
	private static Map<String, Integer> online = new HashMap<String, Integer>();
	
	public BungeeConnection() {}
	
	public BungeeConnection(Player forPlayer, String serverName) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerCount");
			out.writeUTF(serverName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		forPlayer.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
		this.serverName = serverName;
	}
	
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		if(!channel.equalsIgnoreCase("BungeeCord")) return;
		try {
			DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
			String subChannel = in.readUTF();
			if(subChannel.equalsIgnoreCase("PlayerCount")) {
				String serverName = in.readUTF();
				int count = in.readInt();
				online.put(serverName, count);
			}
		} catch (Exception ex) { //Can't catch an EOFException normally :/
			if(!(ex instanceof EOFException)) ex.printStackTrace();
		}
	}
	
	public int getPlayerCount() {
		return online.containsKey(serverName) ? online.get(serverName) : 0;
	}
}
