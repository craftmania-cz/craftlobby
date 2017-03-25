package cz.wake.lobby.manager;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeTask {

    public void initTimeSetter() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                Calendar calendar = GregorianCalendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("Europe/Prague"));
                calendar.setTime(new Date());
                double hour = calendar.get(Calendar.HOUR_OF_DAY) + ((double) calendar.get(Calendar.MINUTE) / 60);
                int time = (int) ((hour - 6) * 1000);
                if (time < 0) time += 24000;
                for (World w : Bukkit.getWorlds()) {
                    if (w != null) {
                        if(!w.getName().equalsIgnoreCase("LobbyEventy")){
                            w.setTime(time + 500); //+ Zimni cas
                        }
                    }
                }
            }

        }, 100L, 600L); // Kazdych 30s zmena casu!
    }

}
