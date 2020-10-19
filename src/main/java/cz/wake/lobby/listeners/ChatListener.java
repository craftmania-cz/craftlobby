package cz.wake.lobby.listeners;

import cz.craftmania.craftcore.spigot.messages.chat.ChatInfo;
import cz.wake.lobby.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ChatListener implements Listener {

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (Main.getInstance().at_list.contains(p)) {
            if (!this._time.containsKey(p)) {
                this._time.put(p, 60D + 0.1D);
                Main.getInstance().getSQL().updateAtLastActive(p, System.currentTimeMillis());
                Main.getInstance().getSQL().updateAtPoints(p);
                this._cdRunnable.put(p, new BukkitRunnable() {
                    @Override
                    public void run() {
                        ChatListener.this._time.put(p, Double.valueOf(((Double) ChatListener.this._time.get(p)).doubleValue() - 0.1D));
                        if (((Double) ChatListener.this._time.get(p)).doubleValue() < 0.01D) {
                            ChatListener.this._time.remove(p);
                            ChatListener.this._cdRunnable.remove(p);
                            cancel();
                        }
                    }
                });
                ((BukkitRunnable) this._cdRunnable.get(p)).runTaskTimer(Main.getInstance(), 2L, 2L);
            }
        }

        if (Main.rulesAcceptionPending.contains(p.getUniqueId())) {
            ChatInfo.error(p, "Před psaním do chatu musíš potvrdit pravidla!");
            e.setCancelled(true);
        }
    }
}
