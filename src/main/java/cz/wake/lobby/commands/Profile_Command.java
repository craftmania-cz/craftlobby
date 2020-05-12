package cz.wake.lobby.commands;

import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.wake.lobby.settings.SettingsMenu;
import io.github.jorelali.commandapi.api.CommandAPI;
import io.github.jorelali.commandapi.api.arguments.Argument;
import io.github.jorelali.commandapi.api.arguments.DynamicSuggestedStringArgument;
import org.bukkit.entity.Player;

import java.util.LinkedHashMap;

public class Profile_Command {

    public static void register() {

        // Default: /profil
        CommandAPI.getInstance().register("profil", new String[]{"profile", "profilelobby"}, null, (sender, args) -> {
            sender.sendMessage("§c§l[!] §c/profile příkaz bude dostupný v pozdějších updatech! Zatím použij /profile settings pro nastavení.");
        });

        // Defualt: /profil settings
        LinkedHashMap<String, Argument> profileArgs = new LinkedHashMap<>();
        profileArgs.put("settings", new DynamicSuggestedStringArgument(() -> {
            return new String[]{"settings", "nastaveni"};
        }));
        CommandAPI.getInstance().register("profil", new String[]{"profile", "profilelobby"}, profileArgs, (sender, args) -> {
            if (sender instanceof Player) {
                SmartInventory.builder().size(5, 9).title("Profile settings").provider(new SettingsMenu()).build().open((Player) sender);
            }
        });
    }
}
