package cz.wake.lobby.manager;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ATChecker implements Runnable {

    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers()){
            if(Main.getInstance().at_list.contains(p)){
                Main.getInstance().fetchData().updateAtPlayerTime(p);
            }
        }
    }
}
