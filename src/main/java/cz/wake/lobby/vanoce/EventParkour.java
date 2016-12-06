package cz.wake.lobby.vanoce;

import cz.wake.lobby.API.TitleAPI;
import cz.wake.lobby.utils.UtilBook;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class EventParkour {

    Location start = new Location(Bukkit.getWorld("LobbyEventy"), -592.5, 99.0, 117.5, 90, 10);
    private static ArrayList<Player> list = new ArrayList<>();

    public void sendToParkourEvent(final Player p){

        p.teleport(start);
        p.getInventory().clear();

        list.add(p);

        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage("§bEVENT: §cBludiste ");
        p.sendMessage("§7Tvym jedinym ukolem je se dostat na konec!");
        p.sendMessage(" ");
        p.sendMessage(" ");

        TitleAPI.sendFullTitlePlayer(p,10,80,10, "§e§lEvent","§7Bludiste");

        UtilBook.giveBook(p, 4, "§8MrWakeCZ", "§e§lEvent (Bludiste)",
                "§lPopis eventu:\n\nTvym jedinym ukolem je se prosplest nasim mega bludistem. " +
                        "Je mozne ze misty najdes nejake pasti, tak se nelekni! Na konci te ceka velka odmena!");

        for(Player p2 : Bukkit.getOnlinePlayers()){
            p2.hidePlayer(p);
            p.hidePlayer(p2);
        }

    }

    public ArrayList<Player> getList(){
        return list;
    }



}
