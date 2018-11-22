package cz.wake.lobby.listeners;

import cz.craftmania.craftcore.spigot.events.time.DayChangeEvent;
import cz.craftmania.craftcore.spigot.events.time.MonthChangeEvent;
import cz.craftmania.craftcore.spigot.events.time.WeekChangeEvent;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TimedResetListener implements Listener {

    @EventHandler
    public void onWeekChange(WeekChangeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("server-utils.reset-week-votes", false)) {
            Log.info("Zahajeni restartu tydennich hlasu!");
            Main.getInstance().getSQL().resetWeekVotes();
            Log.success("Reset hlasu byl dokoncen.");
        }
    }


    @EventHandler
    public void onDayChange(DayChangeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("server-utils.reset-daily-rewards", false)) {
            Log.info("Zahajeni resetu dennich odmen!");
            Main.getInstance().getSQL().resetDailyReward();
            Log.success("Reset dennich odmen byl dokoncen.");
        }
    }

    @EventHandler
    public void onMonthChange(MonthChangeEvent e) {
        if (Main.getInstance().getConfig().getBoolean("server-utils.reset-monthly-rewards", false)) {
            Log.info("Zahajeni resetu mesicnich odmen pro VIP!");
            Main.getInstance().getSQL().resetMonthlyReward();
            Log.success("Reset mesicnich odmen byl dokoncen.");
        }
    }
}
