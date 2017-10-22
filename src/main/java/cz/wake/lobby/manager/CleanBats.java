package cz.wake.lobby.manager;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class CleanBats implements Runnable {

    @Override
    public void run() {
        World w = Bukkit.getWorld("omain");
        if(w.getLivingEntities().size() >= 100){
            for (Entity e : w.getEntities()){
                if(e.getType() == EntityType.BAT){
                    e.remove();
                }
            }
        }
    }
}
