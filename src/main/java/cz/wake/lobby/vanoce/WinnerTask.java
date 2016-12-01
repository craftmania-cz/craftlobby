package cz.wake.lobby.vanoce;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class WinnerTask implements Runnable {

    // Pridaz oznamenu pri joinu
    public boolean run = true;

    @Override
    public void run() {
        if (run) {
            long time_to_end = Main.getInstance().fetchData().endTicketing();
            String game = Main.getInstance().fetchData().getTicketProgramPerDay("dnes");
            if (time_to_end < System.currentTimeMillis()) {
                // Vyhlaseni vyherce pokud cas prekrocil konec
                broadcast("§b[Server] §eProbehne losovani o vitezi hry: §6" + game);
                String winner = Main.getInstance().fetchData().getFinalTodayWinner();
                Main.getInstance().fetchData().addPlayerToWinnersTable(winner, game);
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        broadcast("§b[Server] §eVitezem hry §6" + game + " §eje §c" + winner);
                    }
                }, 60L);
                run = false;
            }
        }
    }

    private void broadcast(String text) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(text);
        }
    }
}
