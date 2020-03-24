package cz.wake.lobby.manager;

import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
import cz.wake.lobby.Main;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class TagsConvertManager implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        this.convertPlayer(player);
    }

    public void convertPlayer(final Player player) {
        if (player.hasPermission("craftlobby.settings.tags-converted")) {
            return;
        }

        User user = null;
        try {
            user = Main.getInstance().getLuckPermsApi().getUserManager().loadUser(player.getUniqueId()).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        AtomicInteger coins = new AtomicInteger();
        AtomicInteger tokens = new AtomicInteger();

        user.getNodes().forEach(node -> {
            if (node.getKey().contains("deluxetags.tag.") || node.getKey().contains("craftchat.tag.")) {

                String extractedTag = node.getKey().replace("deluxetags.tag.", "").replace("craftchat.tag.", "");

                if (Main.getInstance().getConfig().getStringList("coinshop-tags").contains(extractedTag)) {
                    // JE TO COINSHOP TAG
                    coins.addAndGet(700);
                } else {
                    // CUSTOM TAG
                    tokens.addAndGet(1);
                }
            }
        });

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set craftlobby.settings.tags-converted");
        System.out.println("Hráč dostane: " + coins.get() + " CC, " + tokens.get() + " CT");
        CraftCoinsAPI.giveCoins(player, coins.get());
        CraftTokensAPI.giveTokens(player, tokens.get());
    }
}
