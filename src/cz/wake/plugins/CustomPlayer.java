package cz.wake.plugins;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class CustomPlayer {
	
	public static UUID uuid;
	
	public CustomPlayer(UUID uuid){
		this.uuid = uuid;
	}
	
	public static Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

	
	
	

}
