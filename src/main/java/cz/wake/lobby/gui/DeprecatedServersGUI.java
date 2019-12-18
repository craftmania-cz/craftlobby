package cz.wake.lobby.gui;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.SkullHeads;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DeprecatedServersGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        // Horni radek
        contents.set(0,0, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(),e -> {}));
        contents.set(0,1, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,2, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,3, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,5, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,6, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,7, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(0,8, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));

        contents.set(0, 4, ClickableItem.of(SkullHeads.createHead(
                "§a§lVyber serveru",
                "2b7ae64b-f11f-c08a-c3a5-d60bf51f0a91",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGUyYzE4YWIzNTk0OWJmOWY5ZTdkNmE2OWI4ODVjY2Q4Y2MyZWZiOTQ3NTk0NmQ3ZDNmYjVjM2ZlZjYxIn19fQ==",
                "§c§lStaré servery", "§7Staré servery na starých verzích.", "§7Zde najdeš server, které dřív byly", "§7označovány jako hlavní a nyní jsou", "§7ve stavu, kdy již mají novou verzi.", "", "§eNa těchto serverech nedoporučujeme hrát", "§ejelikož může dojít k brzskému smazání."), e -> {}));

        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.WOODEN_AXE).setName("§c§lCreative §e[1.12]").hideAllFlags().setLore("§7Starý Creative na 1.12", "§7vše jak bylo a navždy bude!", "", "§b▸ Kliknutim te portnu").build(), e -> {
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative2");
        }));

        // Dolni radek
        contents.set(5,0, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,1, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,2, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,3, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,4, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,5, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,6, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,7, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
        contents.set(5,8, ClickableItem.of(new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build(), e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
