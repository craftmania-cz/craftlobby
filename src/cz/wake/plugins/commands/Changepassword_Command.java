package cz.wake.plugins.commands;

import cz.wake.plugins.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class Changepassword_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if(Main.getInstance().getConfig().getBoolean("auth-zmenahesla")){
                if ((Command.getName().equalsIgnoreCase("changepassword")) || (Command.getName().equalsIgnoreCase("zmenahesla"))) {
                    if (ArrayOfString.length == 0) {
                        sendToServer(player, "hubzmena");
                        return true;
                    }
                }
            } else {
                player.sendMessage("§cNepouzivej tento prikaz! Mas originalku!");
            }
        }
        return false;
    }

    private void sendToServer(Player player, String target) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }
}
