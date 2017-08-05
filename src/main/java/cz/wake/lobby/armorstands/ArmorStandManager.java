package cz.wake.lobby.armorstands;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.characters.*;
import cz.wake.lobby.armorstands.servers.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class ArmorStandManager {

    public static List<ASInterface> armorstands = new ArrayList<ASInterface>();

    public static void init(){
        if(Main.getInstance().getConfig().getString("server").equalsIgnoreCase("arcade")){
            armorstands.add(new ArcadeShop());
        } else {
            armorstands.add(new Arcade());
            armorstands.add(new BedWars());
            armorstands.add(new Creative1());
            armorstands.add(new Creative2());
            armorstands.add(new VanillaSkyblock());
            armorstands.add(new Prison());
            armorstands.add(new GetDown());
            armorstands.add(new SkyBlock());
            //armorstands.add(new SkyGiants());
            armorstands.add(new SkyWars());
            armorstands.add(new Survival());
            armorstands.add(new Unknown1());
            armorstands.add(new Unknown2());
            armorstands.add(new Unknown3());
            armorstands.add(new Unknown4());
            armorstands.add(new Vanilla());
            armorstands.add(new DJClub());
            armorstands.add(new Drunkers());
            armorstands.add(new Farmer());
            armorstands.add(new ListenerDJ());
            armorstands.add(new Oliver());
            armorstands.add(new Pirate());
            armorstands.add(new Witch());
            armorstands.add(new Bonusy());
        }
    }

    public static void spawn(){
        for(ASInterface i : armorstands){
            i.spawn();
        }
    }

    public void setMetadata(ArmorStand as, String paramString, Object paramObject, Main paramMain) {
        as.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

    public String formatPlayers(final int p) {
        if(p == 0){
            return "§8Nikdo :( ";
        } else if (p == 1){
            return "§7" + p + " §8hrac";
        } else if (p >= 2 && p <= 4){
            return "§7" + p + " §8hraci";
        } else {
            return "§7" + p + " §8hracu";
        }
    }

    public void updatePlayers(){
        for(ASInterface i : armorstands){
            if(i instanceof Survival){
                i.updateArmorStand("survival", Main.getInstance().fetchData().getOnlinePlayers("survival"));
            } else if (i instanceof SkyBlock){
                i.updateArmorStand("skyblock", Main.getInstance().fetchData().getOnlinePlayers("skyblock"));
            } else if (i instanceof Creative1){
                i.updateArmorStand("creative", Main.getInstance().fetchData().getOnlinePlayers("creative"));
            } else if (i instanceof  Creative2){
                i.updateArmorStand("creative2", Main.getInstance().fetchData().getOnlinePlayers("creative2"));
            } else if (i instanceof  Prison){
                i.updateArmorStand("prison", Main.getInstance().fetchData().getOnlinePlayers("prison"));
            } else if (i instanceof VanillaSkyblock){
                i.updateArmorStand("vanillasb", Main.getInstance().fetchData().getOnlinePlayers("vanillasb"));
            } else if (i instanceof Vanilla){
                i.updateArmorStand("vanilla", Main.getInstance().fetchData().getOnlinePlayers("vanilla"));
            } else if (i instanceof BedWars) {
                i.updateArmorStand("bedwars", Main.getInstance().fetchData().getOnlinePlayersSum("stav_bedwars_server"));
            } else if (i instanceof  SkyWars) {
                i.updateArmorStand("skywars", Main.getInstance().fetchData().getOnlinePlayersSum("stav_skywars_server"));
            } else if (i instanceof SkyGiants) {
                //i.updateArmorStand("skygiants", Main.getInstance().fetchData().getOnlinePlayersSum("stav_skygiants_server"));
            } else if (i instanceof GetDown) {
                i.updateArmorStand("getdown", Main.getInstance().fetchData().getOnlinePlayersSum("stav_getdown_server"));
            }
        }
    }
}
