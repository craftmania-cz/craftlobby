package cz.wake.lobby.gui;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.utils.SkullHeads;
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

        contents.set(0, 4, ClickableItem.of(SkullHeads.createHead("info", "082a08df-209f-4593-9f73-b5d8adfe67bf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY0MzlkMmUzMDZiMjI1NTE2YWE5YTZkMDA3YTdlNzVlZGQyZDUwMTVkMTEzYjQyZjQ0YmU2MmE1MTdlNTc0ZiJ9fX0=", "§9§lTutorial & Info", "§7Zde se dozvíš základní informace", "§7k našemu serveru, jak to tady funguje", "§7a co bys měl také znát jako hráč."), e -> {}));

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

        contents.set(2, 2, ClickableItem.of(SkullHeads.createHead(
                "server", "ea66bcbc-6c58-41b6-8f34-3f1f9cc2eb75", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2NhNDVlZjU4MjFhOGIxMDdjYmZiYTdkNjZlOTk3ZmI2YWJlNTUyMWMxNTVjZWUyZjI0YjM0YjNkOTFhNSJ9fX0=",
                "§e§lInfo o serveru", "§7CraftMania se primárně zaměřovala a zaměřuje", "§7na Survival servery - Survival, Skyblock, Creative atd.", "§7Proto jich zde vždy najdeš", "§7od každého typu aspoň jeden!", "", "§7Aktuálně pracujeme na tom,", "§7aby všechny servery byly na §c1.14/1.15", "§7a kdo ví, na čem ještě více. :)"), e -> {}));

        contents.set(2, 3, ClickableItem.of(SkullHeads.createHead(
                "problemy", "b5b0d222-3b12-488b-916f-55a97efb480f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGMyMjhhZWFmOTZmNWUzNmFkMWY3NWI3NThlZDMwNDIxMTc1YmJmMGIwZDJhNjU1NWUzMDY5ZDE0MzQ0OWJkYSJ9fX0=",
                "§6§lŘešení problémů", "§7Pokud budeš mít s něčím problém", "§7můžeš si kdykoliv zobrazit počet", "§7členů AT na serveru pomocí §b/at", "", "§7Popřípadě můžeš zkusit vzdálenou pomoc", "§7s příkazem §a/ghelp [text]", "", "§7A pokud ani to nepomůže,", "§7zkus navštívit náš Discord do §c#mc_problemy"), e -> {}));

        contents.set(2, 4, ClickableItem.of(SkullHeads.createHead(
                "changelogy", "43082b10-4d21-49f2-b21f-1d44d7209e22", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjk4NDRhMWYwYTQwOWUxYmQyMTBlZjgyYmZlNjI5NGE0MzNmMmYzZTIxNWM1ZGVjMDEzYTc3MzBhMjc3MDhmZiJ9fX0=",
                "§c§lZměny & Changelogy", "§7Na serveru se stále něco mění", "§7né vše je ale vždy vidět.", "", "§7Proto u nás existuje stránka:", "§bhttps.//changelog.craftmania.cz/","", "§7Kde si můžeš kdykoliv zobrazit seznam", "§7všech posledních změn, které byly na serveru."), e -> {}));

        contents.set(2, 5, ClickableItem.of(SkullHeads.createHead(
                "vip", "7c10ae35-bc55-465c-a0fc-b2415e900c79", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWM5MDZkNjg4ZTY1ODAyNTY5ZDk3MDViNTc5YmNlNTZlZGM4NmVhNWMzNmJkZDZkNmZjMzU1MTZhNzdkNCJ9fX0=",
                "§a§lNákup VIP", "§7Pokud si chceš zakoupit u nás VIP", "§7je potřeba se obeznámit s zajímavostí.", "§7U nás se VIP dělí na servery zvlášt,",  "§7nebo jako globální VIP.", "", "§cLiší se podle toho také cena a práva!", "", "§7VIP si lze zakoupit na:", "§bhttps://store.craftmania.cz/", "§8Platit lze: SMS, PayPal, PaySafeCard"), e -> {}));

        contents.set(2, 6, ClickableItem.of(SkullHeads.createHead(
                "stranky", "d8941bd0-d9e9-4f1f-af18-65b7b9428c67", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYzNmVhNWIzYmQ3OTRkNTE5ZGZkNWQzYjM1ZWU4ZmU3YjgzNWU3OTgzNGYxYzM5ZWUyYmY3NDk1ZDc4MDBkMyJ9fX0=",
                "§d§lNaše stránky", "§7Hlavní IP: §fmc.craftmania.cz", "§7Hlavní web: §fhttps://craftmania.cz", "§7Banlist: §fhttps://banlist.craftmania.cz", "§7Store: §fhttps://store.craftmania.cz", "§7Wiki: §fhttps://wiki.craftmania.cz", "§7Statistiky: §fhttps://stats.craftmania.cz", "", "§eOdkazy na sociální sítě máš již", "§ev inventáři, stačí na ně kliknout! :)"), e -> {}));

        contents.set(3, 3, ClickableItem.of(SkullHeads.createHead(
                "lobby", "188ad16a-82a0-4497-92eb-371f6414d53c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY1MjQ5ZmQxZDdmZjI5YmFmYzZjMzdlMDNjNmU5NDE1ODU1OGZkNmNlZDdiMjk2ZGEyMDEwNmE2MjFjNTkwNSJ9fX0=",
                "§e§lNové lobby 4.0", "§7Přišlo to a je to tu, CM má opět nové lobby!", "§7Tentokrát je lobby rozmanitější, větší a interaktivnější.", "§7Stačí hledat, na lobby je mnoho secretů a lore!", "", "§7Za hledání budeš také odměněn!"
        ), e -> {}));

        contents.set(3, 5, ClickableItem.of(SkullHeads.createHead(
                "prikazy", "1786c62b-dd50-4fe8-af99-0c4b5c035f03", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFmYjE5NWNjNzVmMzFiNjE5YTA3N2I3ODUzNjUzMjU0YWMxOGYyMjBkYzMyZDE0MTI5ODJmZjQzN2I0ZDU3YSJ9fX0=",
                "§b§lPár základních příkazů", "§7Teleport do lobby: §f/lobby", "§7Teleport mezi servery: §f/survival, /skyblock atd.", "§7Friends: §f/friends §7nebo §f/fr", "§7Spawn: §f/spawn"
        ), e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
