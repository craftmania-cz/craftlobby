package cz.wake.lobby.gui;

import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.SkullHeads;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ServerSelectorGUI implements InventoryProvider {

    private static Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {

        ItemStack colorGlass = getRandomGlass();

        // Horni radek
        contents.set(0,0, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,1, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,2, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,3, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,5, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,6, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,7, ClickableItem.of(colorGlass, e -> {}));
        contents.set(0,8, ClickableItem.of(colorGlass, e -> {}));

        contents.set(0, 4, ClickableItem.of(SkullHeads.createHead(
                "§a§lVyber serveru",
                "5a929f7f-1a74-4d25-860d-40ff532acfbe",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2ZjcyYzE2YjFlOWZlNmUwOTllNzZiNWY3YTg4NGZiNzgyY2ZjYzU4OGM5NWM0ZTM4M2RjNTI3ZDFiODQifX19",
                "§e§lVýběr serveru", "§7Zvol si server na kterém", "§7chceš hrát! Možnosti jsou velké!"), e -> {}));

        contents.set(2, 3, ClickableItem.of(
                new ItemBuilder(getRandomCreativeIcon()).setName("§c§lCreative §e[1.16]").hideAllFlags()
                        .setLore("§8Creative, pozemky, WorldEdit", "", "§7Svět, ve kterém můžeš prakticky", "§7dělat co chceš. Stavět, budovat,", "§7nebo se prostě zlepšovat.", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative");
                }));

        contents.set(3, 1, ClickableItem.of(
                new ItemBuilder(Material.EMERALD).setName("§6§lVanilla §e[1.16]").hideAllFlags()
                        .setLore("§8Vanilla, Lands, PVP, Bez ekonomiky", "", "§7Na tomto serveru poznáš,", "§7co to je přežít v divočině!", "§7Žádný příkaz a žádný shop ti nepomůže!", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla");
                }));

        contents.set(2, 1, ClickableItem.of(
                new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§3§lSurvival §e[1.16]").hideAllFlags()
                        .setLore("§8McMMO, Ekonomika, Fly, PVP", "", "§7Nový server, nový styl hraní,", "§7dokážeš se dostat až na žebříček", "§7těch nejlepších hráčů na serveru?", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "survival");
                }));

        contents.set(2, 5, ClickableItem.of(
                new ItemBuilder(Material.CAMPFIRE).setName("§d§lEvent Server").hideAllFlags()
                        .setLore("§7Server na kterém se konají", "§7eventy pro celý server!", "" , "§7Pokud bude nějaký event probíhat", "§7dozvíš se to v chatu!", "", "§c▸ Připojit se jde, pouze pokud je event").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "event-server");
                }));

        contents.set(2, 6, ClickableItem.of(
                new ItemBuilder(Material.RED_DYE).setName("§c§lStaré servery").hideAllFlags()
                        .setLore("§7Staré servery na starých verzích.", "§7Zde najdeš server, které dřív byly", "§7označovány jako hlavní a nyní jsou", "§7ve stavu, kdy již mají novou verzi.", "", "§eNa těchto serverech nedoporučujeme hrát", "§ejelikož může dojít k brzskému smazání.", "", "§b▸ Klikni k zobrazení")
                        .build(), e -> {
                    SmartInventory.builder().size(6, 9).title("Staré servery").provider(new DeprecatedServersGUI()).build().open(player);
                }));

        contents.set(2, 2, ClickableItem.of(
                new ItemBuilder(Material.NAUTILUS_SHELL).setName("§2§lSkyblock §e[1.16]").hideAllFlags()
                        .setLore("§8Survival, Economy, PVP, Ostrovy", "", "§7Nová verze přináší novou výzvu!,", "§7Dokážeš vybudovat ten nejlepší", "§7ostrov na serveru?", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock");
                }));

        contents.set(3, 2, ClickableItem.of(
                new ItemBuilder(Material.IRON_BARS).setName("§9§lPrison §e[1.16]").hideAllFlags()
                        .setLore("§8Economy, Ostrovy, Mining", "", "§7Prison je zpět a s ním,", "§7i tuna kopání a OP enchanty.", "§7Dokážeš se dostat co nejdál,", "§7a získat tak titul vítěze?", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "prison");
                }));

        contents.set(3, 3, ClickableItem.of(
                new ItemBuilder(Material.REDSTONE).setName("§c§lVanilla: Anarchy §e[1.16]").hideAllFlags()
                    .setLore("§8Vanilla, žádná ochrana", "", "§7Tento server je určený pro náročné", "§7Vanilla hráče, kteří nechtějí ochrany", "§7a chtějí dělat bordel!", "", "§b▸ Kliknutim te portnu").build(), e -> {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "anarchy");
                }));

        // Dolni radek
        contents.set(5,0, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,1, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,2, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,3, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,4, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,5, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,6, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,7, ClickableItem.of(colorGlass, e -> {}));
        contents.set(5,8, ClickableItem.of(colorGlass, e -> {}));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    private int random(int start, int end) {
        return start + random.nextInt(end - start + 1);
    }

    private ItemStack getRandomGlass() {
        int number = random(1, 9);
        if (number == 1) {
            return new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 2) {
            return new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 3) {
            return new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 4) {
            return new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 5) {
            return new ItemBuilder(Material.BROWN_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 6) {
            return new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 7) {
            return new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).setName("§c ").build();
        }
        if (number == 8) {
            return new ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE).setName("§c ").build();
        }
        return new ItemBuilder(Material.PURPLE_STAINED_GLASS_PANE).setName("§c ").build();
    }

    private ItemStack getRandomSurvivalIcon() {
        int number = random(1, 4);
        if (number == 1) {
            return new ItemBuilder(Material.IRON_PICKAXE).build();
        }
        if (number == 2) {
            return new ItemBuilder(Material.GOLDEN_PICKAXE).build();
        }
        if (number == 3) {
            return new ItemBuilder(Material.DIAMOND_PICKAXE).build();
        }
        return new ItemBuilder(Material.IRON_PICKAXE).build();
    }

    private ItemStack getRandomSkyblockIcon() {
        int number = random(1, 4);
        if (number == 1) {
            return new ItemBuilder(Material.BIRCH_SAPLING).build();
        }
        if (number == 2) {
            return new ItemBuilder(Material.SPRUCE_SAPLING).build();
        }
        if (number == 3) {
            return new ItemBuilder(Material.JUNGLE_SAPLING).build();
        }
        if (number == 4) {
            return new ItemBuilder(Material.OAK_SAPLING).build();
        }
        return new ItemBuilder(Material.BIRCH_SAPLING).build();
    }

    private ItemStack getRandomCreativeIcon() {
        int number = random(1, 2);
        if (number == 1) {
            return new ItemBuilder(Material.LAVA_BUCKET).build();
        }
        if (number == 2) {
            return new ItemBuilder(Material.WATER_BUCKET).build();
        }
        return new ItemBuilder(Material.BUCKET).build();
    }
}
