package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.wake.lobby.gui.TutorialGUI;
import cz.wake.lobby.manager.RewardsManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("daily")
@Description("xxxxx...")
public class DailyRewardCommand extends BaseCommand {

    private RewardsManager rewardsManager = new RewardsManager();

    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        rewardsManager.openRewardManager(player);

    }
}
