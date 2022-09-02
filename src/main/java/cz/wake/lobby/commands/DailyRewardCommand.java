package cz.wake.lobby.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import cz.craftmania.craftcore.inventory.builder.SmartInventory;
import cz.wake.lobby.gui.GoldenPigGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("daily|goldenpig")
@Description("Zobrazí GoldenPig menu")
public class DailyRewardCommand extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player player)) return;
        SmartInventory.builder().size(5, 9).title(":offset_-18::golden_pig:").provider(new GoldenPigGUI()).build().open(player);

    }
}
