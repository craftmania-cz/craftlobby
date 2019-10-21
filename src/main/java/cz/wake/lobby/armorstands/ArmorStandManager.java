package cz.wake.lobby.armorstands;

import cz.wake.lobby.Main;
import cz.wake.lobby.armorstands.characters.*;
import cz.wake.lobby.armorstands.events.Matka;
import cz.wake.lobby.armorstands.events.Otec;
import cz.wake.lobby.armorstands.events.Santa;
import cz.wake.lobby.armorstands.servers.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class ArmorStandManager {

    public static List<ASInterface> armorstands = new ArrayList<ASInterface>();

    public static void init() {
        if (Main.getInstance().getIdServer().equalsIgnoreCase("main")) {
            armorstands.add(new Creative());
            armorstands.add(new CreativeOld());
            armorstands.add(new VanillaSkyblock());
            //armorstands.add(new Prison());
            armorstands.add(new SkyBlock());
            armorstands.add(new Survival());
            armorstands.add(new VanillaOld());
            armorstands.add(new Vanilla());
            armorstands.add(new DJClub());
            armorstands.add(new Drunkers());
            armorstands.add(new Farmer());
            armorstands.add(new ListenerDJ());
            armorstands.add(new Oliver());
            armorstands.add(new Pirate());
            armorstands.add(new Witch());
            armorstands.add(new Bonusy());
            if (Main.getInstance().isChristmas()) {
                armorstands.add(new Santa());
                armorstands.add(new Otec());
                armorstands.add(new Matka());
            }
            armorstands.add(new Halloween());
        }
    }

    public static void spawn() {
        for (ASInterface i : armorstands) {
            i.spawn();
        }
    }

    public void setMetadata(ArmorStand as, String paramString, Object paramObject, Main paramMain) {
        as.setMetadata(paramString, new FixedMetadataValue(paramMain, paramObject));
    }

    public String formatPlayers(final int p) {
        if (p == 0) {
            return "§8Nikdo :( ";
        } else if (p == 1) {
            return "§7" + p + " §8hrac";
        } else if (p >= 2 && p <= 4) {
            return "§7" + p + " §8hraci";
        } else {
            return "§7" + p + " §8hracu";
        }
    }

    public void updatePlayers() {
        for (ASInterface i : armorstands) {
            if (i instanceof Survival) {
                i.updateArmorStand("survival", Main.getInstance().getSQL().getOnlinePlayers("survival"));
            } else if (i instanceof SkyBlock) {
                i.updateArmorStand("skyblock", Main.getInstance().getSQL().getOnlinePlayers("skyblock"));
            } else if (i instanceof Creative) {
                i.updateArmorStand("creative", Main.getInstance().getSQL().getOnlinePlayers("creative"));
            } else if (i instanceof CreativeOld) {
                i.updateArmorStand("creative2", Main.getInstance().getSQL().getOnlinePlayers("creative2"));
            } else if (i instanceof Prison) {
                i.updateArmorStand("prison", Main.getInstance().getSQL().getOnlinePlayers("prison"));
            } else if (i instanceof VanillaOld) {
                i.updateArmorStand("vanilla2", Main.getInstance().getSQL().getOnlinePlayers("vanilla2"));
            } else if (i instanceof Vanilla) {
                i.updateArmorStand("vanilla", Main.getInstance().getSQL().getOnlinePlayers("vanilla"));
            } else if (i instanceof Halloween) {
                i.updateArmorStand("", 0);
            }
        }
    }
}
