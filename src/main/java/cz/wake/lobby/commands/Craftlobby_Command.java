package cz.wake.lobby.commands;

import cz.wake.lobby.Main;
import cz.wake.lobby.manager.LagManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;

public class Craftlobby_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("clobby")) || (Command.getName().equalsIgnoreCase("cl"))) {
                if (ArrayOfString.length == 0) {
                    player.sendMessage("");
                    player.sendMessage(ChatColor.YELLOW + "Pouzij nasledujici prikazy:");
                    player.sendMessage(ChatColor.AQUA + "/clobby debug" + ChatColor.GRAY + " - Aktivuje debug rezim");
                    player.sendMessage("");
                    return true;
                } else if (ArrayOfString[0].equalsIgnoreCase("debug")) {
                    if (((Player) Sender).getPlayer().hasPermission("craftlobby.admin")) {
                        if (Main.getInstance().debug) {
                            Main.getInstance().debug = false;
                            player.sendMessage("§2[DEBUG] §7- §fByl deaktivovan.");
                        } else {
                            Main.getInstance().debug = true;
                            player.sendMessage("§2[DEBUG] §7- §fByl aktivovan.");
                        }
                        return true;
                    }
                    return true;
                } else if (ArrayOfString[0].equalsIgnoreCase("party")) {
                    if (((Player) Sender).getPlayer().hasPermission("craftlobby.admin")) {
                        ItemStack party = new ItemStack(Material.GOLD_INGOT);
                        ItemMeta metaparty = party.getItemMeta();
                        metaparty.setDisplayName(ChatColor.GREEN + "PartyCoins");
                        party.setItemMeta(metaparty);
                        player.getInventory().addItem(new ItemStack[]{party});
                        return true;
                    }
                    return true;
                } else if (ArrayOfString[0].equalsIgnoreCase("tps")) {
                    if (((Player) Sender).getPlayer().hasPermission("craftlobby.admin")) {
                        double TPS = LagManager.getTPS();
                        DecimalFormat TpsFormat = new DecimalFormat("#.###");

                        if (TPS > 20) {
                            Sender.sendMessage("§7Status: " + "§a" + TpsFormat.format(TPS));
                            return true;
                        }
                        if (TPS > 18) {
                            Sender.sendMessage("§7Status: " + "§a" + TpsFormat.format(TPS));
                            return true;
                        }
                        if (TPS > 16) {
                            Sender.sendMessage("§7Status: " + "§6" + TpsFormat.format(TPS));
                            return true;
                        }
                        if (TPS > 10) {
                            Sender.sendMessage("§7Status: " + "§c" + TpsFormat.format(TPS));
                            return true;
                        }
                        if (TPS > 5) {
                            Sender.sendMessage("§7Status: " + "§4" + TpsFormat.format(TPS));
                            return true;
                        }
                        if (TPS > 0) {
                            Sender.sendMessage("§7Status: §c§lServer je kompletne pretizen!");
                            return true;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
