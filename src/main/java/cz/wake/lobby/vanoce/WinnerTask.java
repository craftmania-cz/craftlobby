package cz.wake.lobby.vanoce;

import cz.wake.lobby.API.CustomEntityFirework;
import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WinnerTask implements Runnable {

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
                        fireworTask();
                    }
                }, 100L);
                run = false;
            }
        }
    }

    private void broadcast(String text) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("");
            p.sendMessage(text);
            p.sendMessage("");
        }
    }

    public void fireworTask(){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1529.0, 26.0, -1251.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.YELLOW).withFade(Color.BLUE).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 20L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1536.0, 26.0, -1244.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.RED).withFade(Color.MAROON).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 40L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1544.0, 26.0, -1244.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.GREEN).withFade(Color.LIME).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 60L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1551.0, 26.0, -1251.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.PURPLE).withFade(Color.BLACK).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 80L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1551.0, 26.0, -1260.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.AQUA).withFade(Color.BLUE).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 100L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1544.0, 26.0, -1266.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.WHITE).withFade(Color.GRAY).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 120L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1536.0, 26.0, -1266.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.FUCHSIA).withFade(Color.WHITE).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 140L);
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Location loc = new Location(Bukkit.getWorld("omain"), 1529.0, 26.0, -1260.0);
                CustomEntityFirework.spawn(loc, FireworkEffect.builder().withColor(Color.ORANGE).withFade(Color.YELLOW).with(FireworkEffect.Type.BALL_LARGE).trail(true).build());
            }
        }, 160L);
    }
}
