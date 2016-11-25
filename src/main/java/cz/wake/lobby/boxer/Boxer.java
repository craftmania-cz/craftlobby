package cz.wake.lobby.boxer;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class Boxer implements Listener {

    private void giveBox(final Player p, int boxes, int sance) {
        if (sance >= 0 && sance <= 70) {
            Bukkit.broadcastMessage("§bCraftBox §8┃ §e" + p.getName() + "§f nasel §aBasic CraftBox");
            Main.getInstance().setData().addCraftBox(p, "Basic_CraftBox", 1);

        } else if (sance > 70) {
            Bukkit.broadcastMessage("§bCraftBox §8┃ §e" + p.getName() + "§f nasel §9Rare CraftBox");
            Main.getInstance().setData().addCraftBox(p, "Rare_CraftBox", 1);
        }
    }

    private static int randRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        if (Main.getInstance().getTPS() > 19) {
            if (randRange(1, 100) <= 10) { //10% sance na ziskani boxu
                if ((Main.getInstance().fetchData().getBoxes(p.getUniqueId()) < 12)
                        && (Main.getInstance().fetchData().getNextboxTime(p.getUniqueId()) < System.currentTimeMillis())) {
                    long dalsiBox = randRange(1800000, 10800000); //30 minut az 3h
                    long cas = System.currentTimeMillis() + dalsiBox;
                    int sance2 = randRange(1, 100); //Sance na druhy boxu
                    Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Main.getInstance().setData().addBoxesWithTime(p, 1, cas);
                            giveBox(p, 1, sance2);
                        }
                    }, 40L);
                }
            }
        }
    }

    //Kazdy 2h kontrola prekroceni
    public void runTaskDelete() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                System.out.println("[Craftboxer] Kontrola resetu boxu.");
                if (Main.getInstance().fetchData().getFullResetTime() < System.currentTimeMillis()) {
                    System.out.println("[Craftboxer] Kontrola potvrzena. Probehne cisteni boxu...");
                    long nextReset = (System.currentTimeMillis() + 604800000);
                    Main.getInstance().setData().resetBoxes();
                    System.out.println("[Craftboxer] Vsechny boxy vyresetovany na 0");
                    Main.getInstance().setData().resetTime(nextReset);
                    System.out.println("[Craftboxer] Probehl reset casu!");
                } else {
                    System.out.println("[Craftboxer] Cas na reset jeste nenastal.");
                }
            }
        }, 60L, 144000);
    }

}
