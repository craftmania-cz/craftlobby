package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TutorialGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {
        // Horni radek
        contents.set(0,0, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,1, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,2, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,3, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,5, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,6, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,7, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,8, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));

        contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.BEACON).setName("§9§lTutorial & Info").setLore("§7Zde se dozvíš základní informace", "§7k našemu serveru, jak to tady funguje", "§7a co bys měl také znát jako hráč.").build(), e -> {}));

        // Dolni radek
        contents.set(5,0, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,1, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,2, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,3, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,4, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,5, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,6, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,7, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,8, ClickableItem.of(new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));

        contents.set(2, 2, ClickableItem.of(new ItemBuilder(Material.WHEAT).setName("§e§lInfo o serveru").setLore("§7CraftMania se primárně zaměřuje", "§7na Survival servery - Survival, Skyblock, Creative.", "§7Proto jich zde vždy najdeš", "§7od každého typu aspoň jeden!").build(), e -> {}));

        contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.REDSTONE).setName("§6§lŘešení problémů").setLore("§7Oficiální podporu na řešení jakýchkoliv", "§7problémů najdeš u nás na Discordu:", "§ehttps://discord.gg/craftmania", "", "§6Kliknutím zobrazíš odkaz v chatu").build(), e -> {
            player.sendMessage("");
            player.sendMessage("§bOdkaz na náš Discord server");
            player.sendMessage("§ehttps://discord.gg/craftmania");
            player.sendMessage("");
        }));

        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.BOOK).setName("§c§lZměny & Changelogy").setLore("§7Na serveru se stále něco mění", "§7né vše je ale vždy vidět.", "", "§7Proto u nás existuje stránka:", "§bhttps.//changelog.craftmania.cz/","", "§7Kde si můžeš kdykoliv zobrazit seznam", "§7všech posledních změn, které byly na serveru.").build(), e -> {}));

        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.EMERALD).setName("§a§lNákup VIP").setLore("§7Pokud si chceš zakoupit u nás VIP", "§7na kterémkoliv serveru si můžeš", "§7zobrazit odkaz na výhody pomocí", "§7příkazu §f/vip", "", "§7VIP si lze zakoupit na:", "§bhttps://store.craftmania.cz/", "§8Platit lze: SMS, PayPal, PaySafeCard, Kreditní kartou").build(), e -> {}));

        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.AMETHYST_SHARD).setName("§d§lNaše služby").setLore("§7Discord: §fhttps://discord.gg/craftmania", "§7Hlavní web: §fhttps://craftmania.cz", "§7Banlist: §fhttps://banlist.craftmania.cz", "§7Store: §fhttps://store.craftmania.cz", "§7Wiki: §fhttps://wiki.craftmania.cz", "§7Statistiky: §fhttps://stats.craftmania.cz").build(), e -> {}));

        contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.PRISMARINE_SHARD).setName("§b§lPár základních příkazů").setLore("§7Teleport do lobby: §f/lobby", "§7Teleport mezi servery: §f/survival, /skyblock atd.", "§7Friends: §f/friends §7nebo §f/fr §c(dočasně nefunguje)", "§7Spawn: §f/spawn", "§7Nápověda k serveru: §f/help").build(), e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
