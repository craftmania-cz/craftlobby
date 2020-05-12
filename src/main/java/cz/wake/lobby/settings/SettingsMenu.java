package cz.wake.lobby.settings;

import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.craftmania.craftcore.spigot.inventory.builder.content.Pagination;
import cz.wake.lobby.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static cz.wake.lobby.settings.SettingsMenuOld.formatJoinMessageWithoutColors;

public class SettingsMenu implements InventoryProvider {

    private Pagination pagination;

    @Override
    public void init(Player player, InventoryContents contents) {
        pagination = contents.pagination();
        ClickableItem[] pages = new ClickableItem[2];
        pagination.setItems(pages);
        pagination.setItemsPerPage(1);

        switch (pagination.getPage()) {
            case 0: {
                openPage(player, contents, 0);
                break;
            }
            case 1: {
                openPage(player, contents, 1);
                break;
            }
            default: { //Chyba
                player.sendMessage("§cNastala chyba! Přesouvám tě na první stranu.");
                contents.inventory().open(player, pagination.page(0).getPage());
            }
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {
    }

    // Pages

    private void openPage(Player p, InventoryContents contents, int page) {
        ItemStack enabled = createItem(Material.GREEN_STAINED_GLASS_PANE, "§a§lZapnuto", null);
        ItemStack disabled = createItem(Material.RED_STAINED_GLASS_PANE, "§c§lVypnuto", null);
        ItemStack nedostupne = createItem(Material.BARRIER, "§c§lNedostupné", null);
        ItemStack pouzeLobby = createItem(Material.BARRIER, "§c§lNastavit lze pouze na lobby", null);
        ItemStack zpet = createItem(Material.ARROW, "§eZpět", null);
        ItemStack nextPage = createItem(Material.ARROW, "§eDalší strana", null);
        ItemStack previousPage = createItem(Material.ARROW, "§ePředchozí strana", null);

        switch (page) {
            case 0: {
                ItemStack fly = createItem(Material.ELYTRA, "§e§lFly", Arrays.asList("§7Nastavuje FLY na lobby serverech.", "§7Fly dostanes pri kazdem",
                        "§7vstupu na lobby", "", "§cVyzaduje MiniGames VIP nebo globalni Obsidian VIP!"));
                ItemStack player = createItem(Material.LEGACY_WATCH, "§e§lViditelnost hracu", Arrays.asList("§7Nastavuje zobrazeni", "§7hracu na lobby."));
                ItemStack pets = createItem(Material.BONE, "§e§lViditelnost pets", Arrays.asList("§7Nastavuje zobrazeni", "§7pets na lobby."));
                ItemStack part = createItem(Material.REDSTONE, "§e§lParticles", Arrays.asList("§7Viditelnost efektu", "", "§cDocasne nefunguje na vsechny!"));
                ItemStack gadgets = createItem(Material.PISTON, "§e§lGadgets", Arrays.asList("§7Nastavuje zda na tebe", "§7budou fungovat gadget lobby."));
                ItemStack speed = createItem(Material.GOLDEN_BOOTS, "§e§lSpeed", Arrays.asList("§7Povoluje rychlost chozeni", "§7na lobby."));
                ItemStack novinky = createItem(Material.MAP, "§e§lReklama", Arrays.asList("§7Nastavuje zobrazovani reklamy", "§7na VIP na MiniGames.", "", "§cVyzaduje MiniGames VIP!"));
                ItemStack deathMessages = createItem(Material.BLAZE_POWDER, "§e§lDeath zpravy", Arrays.asList("§7Nastavuje zobrazeni smrti", "§7hracu.", "", "§cFunguje pouze na Survival serverech", "§e§l[*] §eZměny se projeví až po odpojení a připojení!"));
                ItemStack notify = createItem(Material.JUKEBOX, "§e§lOznameni o oznaceni", Arrays.asList("§7Pokud te nekdo oznaci", "§7v chatu, server te", "§7upozorni cinknutim."));

                //Předchozí / Zpět / Další
                contents.set(4, 4, ClickableItem.of(zpet, e -> {
                    //TODO: Profile menu
                    contents.inventory().close(p);
                }));
                contents.set(4, 5, ClickableItem.of(nextPage, e -> {
                    //TODO: Profile menu
                    contents.inventory().open(p, pagination.next().getPage());
                }));

                //Nastavení
                contents.set(1, 0, ClickableItem.empty(fly));
                contents.set(1, 1, ClickableItem.empty(player));
                contents.set(1, 2, ClickableItem.empty(pets));
                contents.set(1, 3, ClickableItem.empty(part));
                contents.set(1, 4, ClickableItem.empty(gadgets));
                contents.set(1, 5, ClickableItem.empty(speed));
                contents.set(1, 6, ClickableItem.empty(novinky));
                contents.set(1, 7, ClickableItem.empty(deathMessages));
                contents.set(1, 8, ClickableItem.empty(notify)); //TODO: Kliknutí a výběr zvuku

                //Akce po kliknutí na nastavení
                contents.set(2, 0, ClickableItem.of((getSetting(p, "lobby_fly") == 1 ? enabled : disabled), e -> { //Fly
                    if (p.hasPermission("craftlobby.vip.fly")) {
                        if (contents.get(2, 0).get().getItem() == enabled) {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_fly", 0);
                            p.setAllowFlight(false);
                            p.setFlying(false);
                            p.sendMessage("§c§l[!] §cFly na lobby bylo deaktivovano!");
                        } else {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_fly", 1);
                            p.setAllowFlight(true);
                            p.setFlying(true);
                            p.sendMessage("§e§l[*] §eFly na lobby bylo aktivovano!");
                        }
                    } else {
                        p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal VIP");
                    }
                    contents.inventory().close(p);
                }));
                // Obrácené hodnoty? FIXME
                contents.set(2, 1, ClickableItem.of((getSetting(p, "lobby_players") == 1 ? disabled : enabled), e -> { //Viditelnost hráčů na lobby
                    if (contents.get(2, 1).get().getItem() == disabled) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_players", 0);
                        p.sendMessage("§e§l[*] §eZobrazování hráčů zapnuto!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_players", 1);
                        p.sendMessage("§c§l[!] §cZobrazovani hracu vypnuto!");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 2, ClickableItem.empty(nedostupne)); //Pets
                contents.set(2, 3, ClickableItem.of((getSetting(p, "lobby_particles") == 1 ? enabled : disabled), e -> { //Viditelnost particlů na lobby
                    if (contents.get(2, 3).get().getItem() == enabled) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_particles", 0);
                        p.sendMessage("§c§l[!] §cZobrazovani efektu vypnuto!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_particles", 1);
                        p.sendMessage("§e§l[*] §eZobrazovani efektu zapnuto!");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 4, ClickableItem.of((getSetting(p, "lobby_gadgets") == 1 ? enabled : disabled), e -> { //Působení gadgetů na hráče
                    if (contents.get(2, 4).get().getItem() == enabled) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_gadgets", 0);
                        p.sendMessage("§c§l[!] §cGadgety jiz na tebe nebudou reagovat!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_gadgets", 1);
                        p.sendMessage("§e§l[*] §eGadgety nyni na tebe budou reagovat!");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 5, ClickableItem.of((getSetting(p, "lobby_speed") == 1 ? enabled : disabled), e -> { //Rychlost na lobby
                    if (contents.get(2, 5).get().getItem() == enabled) {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_speed", 0);
                        p.sendMessage("§c§l[!] §cRychlost byla nastavena na zakladni!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "lobby_speed", 1);
                        p.sendMessage("§e§l[*] §eRychlost byla nastavena na 2x rychlejsi!");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 6, ClickableItem.empty(nedostupne)); //Novinky
                contents.set(2, 7, ClickableItem.of((getSetting(p, "death_messages") == 1 ? enabled : disabled), e -> { //Deathzprávy
                    if (contents.get(2, 7).get().getItem() == enabled) {
                        Main.getInstance().getSQL().updateSettings(p, "death_messages", 0);
                        p.sendMessage("§c§l[!] §cZablokovano zobrazovani zprav o smrti!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "death_messages", 1);
                        p.sendMessage("§e§l[*] §eNyni uvidis v chatu zpravy o smrti hracu!");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 8, ClickableItem.of((getSetting(p, "mention_notify") == 1 ? enabled : disabled), e -> { //Mention notify
                    if (contents.get(2, 8).get().getItem() == enabled) {
                        Main.getInstance().getSQL().updateSettings(p, "mention_notify", 0);
                        p.sendMessage("§c§l[!] §cNyni ti oznaceni nebude cinkat!");
                    } else {
                        Main.getInstance().getSQL().updateSettings(p, "mention_notify", 1);
                        p.sendMessage("§e§l[*] §eZapnul jsi cinkani pri oznaceni v chatu!");
                    }
                    contents.inventory().close(p);
                }));
                break;
            }
            case 1: {
                //Předchozí / Zpět / Další
                contents.set(4, 3, ClickableItem.of(previousPage, e -> {
                    //TODO: Profile menu
                    contents.inventory().open(p, pagination.previous().getPage());
                }));
                contents.set(4, 4, ClickableItem.of(zpet, e -> {
                    //TODO: Profile menu
                    contents.inventory().close(p);
                }));

                ItemStack joinMessage = createItem(Material.BOOK, "§e§lZprava pri pripojeni", Arrays.asList("§7Pokud se pripojis", "§7ostatni o tom budou vedet.",
                        "", "§bVybrana zprava:", "§f" + formatJoinMessageWithoutColors(Main.getInstance().getSQL().getSettings(p, "lobby_joinbroadcast_message"), p),
                        "§7", "§eKliknutim si vyberes zpravu"));
                ItemStack joinSound = createItem(Material.NOTE_BLOCK, "§e§lZvuk pri pripojeni", Arrays.asList("§7Pokud se pripojis", "§7zazni zvuk.",
                        "§7Vybrany zvuk: " + Main.getInstance().getSQL().getSettingsString(p, "lobby_joinbroadcast_sound")
                                .replace("ENTITY_EXPERIENCE_ORB_PICKUP", "EXP ORB PICKUP")
                                .replace("BLOCK_ANVIL_FALL", "ANVIL FALL")
                                .replace("BLOCK_GLASS_BREAK", "GLASS BREAK")
                                .replace("ENTITY_ITEM_PICKUP", "ITEM PICKUP")
                                .replace("ENTITY_ZOMBIE_HURT", "ZOMBIE HURT")
                        , "", "§eKliknutim si vyberes zvuk"));

                //Nastaveni
                contents.set(1, 0, ClickableItem.of(joinMessage, e -> {
                    contents.inventory().close(p);
                    SmartInventory.builder().size(3, 9).title("Profile settings - Join message").provider(new SettingsMenuSelectionLobbyMessage()).build().open(p);
                }));
                contents.set(1, 1, ClickableItem.of(joinSound, e -> {
                    contents.inventory().close(p);
                    SmartInventory.builder().size(3, 9).title("Profile settings - Join sound").provider(new SettingsMenuSelectionLobbySound()).build().open(p);
                }));

                //Akce po kliknuti na nastaveni
                contents.set(2, 0, ClickableItem.of((getSetting(p, "lobby_joinbroadcast_enabled") == 1 ? enabled : disabled), e -> { //Zpráva po připojení
                    if (p.hasPermission("craftlobby.vip.joinbroadcast-message")) {
                        if (contents.get(2, 0).get().getItem() == enabled) {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_enabled", 0);
                            p.sendMessage("§c§l[!] §cZprava pri pripojeni byla deaktivovana!");
                        } else {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_enabled", 1);
                            p.sendMessage("§e§l[*] §eZprava pri pripojeni byla aktivovana!");
                        }
                    } else {
                        p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                    }
                    contents.inventory().close(p);
                }));
                contents.set(2, 1, ClickableItem.of((getSetting(p, "lobby_joinbroadcast_sound_enabled") == 1 ? enabled : disabled), e -> {
                    if (p.hasPermission("craftlobby.vip.joinbroadcast-change-sound")) {
                        if (contents.get(2, 1).get().getItem() == enabled) {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound_enabled", 0);
                            p.sendMessage("§c§l[!] §cZvuk pri pripojeni byl deaktivovan!");
                        } else {
                            Main.getInstance().getSQL().updateSettings(p, "lobby_joinbroadcast_sound_enabled", 1);
                            p.sendMessage("§e§l[*] §eZvuk pri pripojeni byl aktivovan!");
                        }
                    } else {
                        p.sendMessage("§c§l[!] §cK pouziti teto funkce potrebujes §fGlobal Emerald VIP");
                    }
                    contents.inventory().close(p);
                }));
                break;
            }
        }
    }

    // Utils
    private ItemStack createItem(Material material, String itemName, List<String> itemLore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(itemName);
        meta.setLore(itemLore);
        item.setItemMeta(meta);
        return item;
    }

    private int getSetting(Player p, String setting) {
        return Main.getInstance().getSQL().getSettings(p, setting);
    }

}
