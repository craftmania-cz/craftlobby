package cz.wake.lobby.utils;

import com.comphenix.protocol.ProtocolLibrary;
import org.bukkit.entity.Player;

import java.util.Random;

public class ProfileUtils {

    public static String createDiscriminator() {
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        if (id.equals("0000") || id.equals("0001") || id.equals("10000")) {
            id = String.format("%04d", random.nextInt(10000));
        }
        return id;
    }

    public static String getVersion(final Player p) {
        int version = ProtocolLibrary.getProtocolManager().getProtocolVersion(p);
        switch (version) {
            case 210:
                return "1.10";
            case 316:
                return "1.11.2";
            case 335:
                return "1.12";
            case 338:
                return "1.12.1";
            default:
                return "0";
        }
    }
}
