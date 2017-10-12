package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Profil implements Listener {

    private static HashSet<Player> editor = new HashSet<>();
    private static HashSet<Player> fb_editor = new HashSet<>();
    private static HashSet<Player> tw_editor = new HashSet<>();
    private static HashSet<Player> twitch_editor = new HashSet<>();
    private static HashSet<Player> youtube_editor = new HashSet<>();
    private static HashSet<Player> steam_editor = new HashSet<>();
    private static HashSet<Player> web_editor = new HashSet<>();
    private Stalker stalker = new Stalker();
    private SettingsMenu settings = new SettingsMenu();

    public void openMenu(Player p) {

        Inventory menu = Bukkit.createInventory(null, 54, "Profil: " + p.getName());

        SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
        headItemMeta.setOwner(p.getName());
        headItemMeta.setDisplayName("§aInformace o tobe");
        ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ArrayList<String> headLore = new ArrayList<String>();
        headLore.add("");
        headLore.add("§7ID: §f#" + Main.getInstance().fetchData().getPlayerProfileDataString(p, "discriminator"));
        headLore.add("§7Prvni pripojeni: §f" + getDate(Main.getInstance().fetchData().getPlayerProfileDataLong(p, "registred")));
        headLore.add("§7CraftCoins: §f" + Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()));
        headLore.add("§7SkyDust: §f" + Main.getInstance().fetchData().getSkyKeysDust(p.getUniqueId()));
        headLore.add("§7Celkem hlasu: §f" + Main.getInstance().fetchData().getVotesAll(p.getUniqueId()));
        headLore.add("§7Web group: §f" + getWebGroup(Main.getInstance().fetchData().getPlayerProfileDataInt(p, "web_group")));
        headLore.add("§7Celkem odehrany cas: §f" + TimeUtils.formatTime("%dd, %hh %mm", Main.getInstance().fetchData().getPlayerProfileDataInt(p, "played_time"), false));
        headItemMeta.setLore(headLore);
        headItem.setItemMeta(headItemMeta);
        menu.setItem(12, headItem);

        ItemStack status = ItemFactory.create(Material.PAPER, (byte) 0, "§aTvuj status", "§8Status je viditelny na webu", "§8v profilech", "", "§f" + Main.getInstance().fetchData().getPlayerProfileDataString(p, "status"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        menu.setItem(14, status);

        ItemStack soc = ItemFactory.createHead("Test", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=", "§aSocialni site", "", "§7Chces vsem poskytnout prime", "§7odkazy na svem profilu?", "", "§bOdkazy se zobrazuji na webu", "§bv profilech.", "", "§eKliknutim provedes zmeny");
        menu.setItem(29, soc);

        ItemStack statistiky = ItemFactory.create(Material.BOOK, (byte) 0, "§aStatistiky", "", "§7Zobrazi vsechny tve statistiky", "§7ze serveru.", "", "§cPredelava se...");
        menu.setItem(30, statistiky);

        ItemStack multipliers = ItemFactory.create(Material.POTION, (byte) 0, "§aMultipliery", "", "§7Chces vydelavat vic?", "§7Zde je to prave misto...", "", "§cPlanovano...");
        menu.setItem(32, multipliers);

        ItemStack levels = ItemFactory.create(Material.BREWING_STAND_ITEM, (byte) 0, "§aCraftLevels", "", "§7Ziskavanim levelu", "§7si odemknes nove veci na serveru.", "", "§cPlanovano...");
        menu.setItem(31, levels);

        ItemStack achievements = ItemFactory.create(Material.EMERALD, (byte) 0, "§aAchievementy", "", "§7Chces videt, ktery ukoly", "§7jsi splnil a ktere", "§7musis splnit?", "", "§cPlanovano...");
        menu.setItem(33, achievements);

        ItemStack questy = ItemFactory.create(Material.DIAMOND, (byte) 0, "§aQuesty", "", "§7Nuda? No tak zkus kazdy den", "§7splnit nektery z techto Questu!", "", "§cPlanovano...");
        menu.setItem(39, questy);

        ItemStack villages = ItemFactory.create(Material.DARK_OAK_DOOR_ITEM, (byte) 0, "§aVillages", "", "§7Kdo vi.. co to bude?", "", "§cPlanovano...");
        menu.setItem(38, villages);

        if (Main.getInstance().fetchData().isAT(p)) {
            ItemStack i = ItemFactory.create(Material.PAINTING, (byte) 0, "§aAT Stalker", "§7Prehled tve aktivity", "§7na serveru.", "", "§eKlikni pro zobrazeni");
            menu.setItem(42, i);
        } else {
            ItemStack i = ItemFactory.create(Material.BARRIER, (byte) 0, "§cAT Sekce", "§7K zobrazeni teto sekce", "§7musis byt v AT.");
            menu.setItem(42, i);
        }

        ItemStack nastaveni = ItemFactory.create(Material.REDSTONE_COMPARATOR, (byte) 0, "§aNastaveni uctu", "", "§7Diky nastaveni si muzes", "§7prispusobit lobby/hry podle sebe.", "", "§eKlikni pro zobrazeni/nastaveni");

        ItemStack jazyk = ItemFactory.createHead("§aNastaveni jazyka", "0ceac85e-159d-4f9d-a1c2-c8acde792f23", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0=");
        ItemMeta bhMeta = jazyk.getItemMeta();
        ArrayList<String> bhLore = new ArrayList();
        bhLore.add("§7Zmen si jazyk serveru.");
        bhLore.add("");
        bhLore.add("§7Podporovane jazyky:");
        bhLore.add(" §7• §fCestina");
        bhLore.add(" §7• §fSlovencina");
        bhLore.add(" §7• §fEnglish");
        bhLore.add("");
        bhLore.add("§eKliknutim si zmenis jazyk!");
        bhMeta.setLore(bhLore);
        jazyk.setItemMeta(bhMeta);

        menu.setItem(41, nastaveni);
        menu.setItem(40, jazyk);

        p.openInventory(menu);
    }

    private void openSocialMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 45, "Socialni site");

        ItemStack facebook = ItemFactory.createHead("Facebook", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=", "§bFacebook", "", getSocialLinks(p, "soc_facebook"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(10, facebook);

        ItemStack twitter = ItemFactory.createHead("Twitter", "11fce6c7-71ad-464e-98e7-c8e579de4758", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY4NWEwYmU3NDNlOTA2N2RlOTVjZDhjNmQxYmEyMWFiMjFkMzczNzFiM2Q1OTcyMTFiYjc1ZTQzMjc5In19fQ==", "§bTwitter", "", getSocialLinks(p, "soc_twitter"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(12, twitter);

        ItemStack youtube = ItemFactory.createHead("Youtube", "6486882a-2871-4db3-922d-98ebc3166c6b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJmNmMwN2EzMjZkZWY5ODRlNzJmNzcyZWQ2NDU0NDlmNWVjOTZjNmNhMjU2NDk5YjVkMmI4NGE4ZGNlIn19fQ==", "§bYoutube", "", getSocialLinks(p, "soc_ytb"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(14, youtube);

        ItemStack twitch = ItemFactory.createHead("Twitch", "e57c6078-0b1f-4f88-976d-977a5834717f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiZTY1ZjQ0Y2QyMTAxNGM4Y2RkZDAxNThiZjc1MjI3YWRjYjFmZDE3OWY0YzFhY2QxNThjODg4NzFhMTNmIn19fQ==", "§bTwitch", "", getSocialLinks(p, "soc_twitch"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(16, twitch);

        ItemStack web = ItemFactory.createHead("Web", "c424243d-0421-4774-8aeb-2ddea957ed57", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5MzZkNGYwZDFiOTNmZWY3NzViMWZiZDE5MjgxYjcwYzZmODg0NzViYjVhNDFiZjM3MmMxMmYxZjhhMjIifX19", "§bWeb (vlastni URL)", "", getSocialLinks(p, "soc_web"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(20, web);

        ItemStack steam = ItemFactory.createHead("Steam", "73bec8bd-bced-44cc-b3ad-3489b846efc4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRkYjRhZGZhOWJmNDhmZjVkNDE3MDdhZTM0ZWE3OGJkMjM3MTY1OWZjZDhjZDg5MzQ3NDlhZjRjY2U5YiJ9fX0=", "§bSteam", "", getSocialLinks(p, "soc_steam"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        inv.setItem(24, steam);

        ItemStack warn = ItemFactory.createHead("Warning", "76815220-3812-436d-90f8-3264867d7bc0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY0NDZhOGY5Mjg0YzYyY2Y4ZDQ5MWZiZGIzMzhmZDM5ZWJiZWJlMzVlOTU5YzJmYzRmNzg2YzY3NTIyZWZiIn19fQ==", "§cVarovani", "§7Vsechny zde uverejnene", "§7finformace jsou verejne dostupne", "§7na tvem webovem profilu", "§7nebo pomoci §a/profil <nick>");
        inv.setItem(22, warn);

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet");
        inv.setItem(40, zpet);

        p.openInventory(inv);
    }

    private void openLanguageMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 45, "Nastaveni jazyka");

        ItemStack jazyk = ItemFactory.createHead("§aCestina", "9db55454-6114-4bf8-aa27-55419d4890c4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDgxNTJiNzMzNGQ3ZWNmMzM1ZTQ3YTRmMzVkZWZiZDJlYjY5NTdmYzdiZmU5NDIxMjY0MmQ2MmY0NmU2MWUifX19");
        ItemMeta bhMeta = jazyk.getItemMeta();
        ArrayList<String> bhLore = new ArrayList();
        bhLore.add("§7Zmen si jazyk serveru na Cestinu.");
        bhLore.add("");
        bhLore.add("§7Podpora prekladu:");
        bhLore.add(" §7• §fZatim nic");
        bhLore.add("");
        bhLore.add("§cNedostupne!");
        bhMeta.setLore(bhLore);
        jazyk.setItemMeta(bhMeta);

        ItemStack jazyk2 = ItemFactory.createHead("§aSlovencina", "", "");
        ItemMeta bhMeta2 = jazyk2.getItemMeta();
        ArrayList<String> bhLore2 = new ArrayList();
        bhLore2.add("§7Zmen si jazyk serveru na Slovencinu.");
        bhLore2.add("");
        bhLore2.add("§7Podpora prekladu:");
        bhLore2.add(" §7• §fZatim nic");
        bhLore2.add("");
        bhLore2.add("§cNedostupne!");
        bhMeta2.setLore(bhLore2);
        jazyk2.setItemMeta(bhMeta2);

        ItemStack jazyk3 = ItemFactory.createHead("§aEnglish", "3c30484a-76d3-4cfe-88e5-e7599bc9ac4d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNhYzk3NzRkYTEyMTcyNDg1MzJjZTE0N2Y3ODMxZjY3YTEyZmRjY2ExY2YwY2I0YjM4NDhkZTZiYzk0YjQifX19");
        ItemMeta bhMeta3 = jazyk3.getItemMeta();
        ArrayList<String> bhLore3 = new ArrayList();
        bhLore3.add("§7Change your language to English.");
        bhLore3.add("");
        bhLore3.add("§7Currently available:");
        bhLore3.add(" §7• §fNothing");
        bhLore3.add("");
        bhLore3.add("§cNot available!");
        bhMeta3.setLore(bhLore3);
        jazyk3.setItemMeta(bhMeta3);

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§eZpet");
        ItemStack help = ItemFactory.create(Material.BOOK, (byte) 0, "§aPomoc s prekladem", "§7Chces nam pomoct s prekladem?", "§7Neni nic jednodussiho nez si", "§7pozadat o pristup v nasem", "§7projektu na Crowdinu!", "", "§eKliknutim zobrazis odkaz na projekt");

        inv.setItem(11, jazyk);
        inv.setItem(13, jazyk2);
        inv.setItem(15, jazyk3);
        inv.setItem(40, zpet);
        inv.setItem(36, help);

        p.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Profil: " + p.getName())) {
            if (e.getSlot() == 14) {
                if (e.isLeftClick()) {
                    if (!editor.contains(p)) {
                        editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis zpravu, co chces nastavit jako status!");
                        p.sendMessage("§7Editaci zrusis napsanim -> exit");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    p.closeInventory();
                    Main.getInstance().fetchData().updateStatus(p, "Tento hráč nemá nastavený status...");
                    p.sendMessage("§eStatus byl vyresetovany na default!");
                }
            }
            if (e.getSlot() == 29) {
                openSocialMenu(p);
            }
            if (e.getSlot() == 40) {
                openLanguageMenu(p);
            }
            if (e.getSlot() == 41) {
                settings.openSettingsMenu(p);
            }
            if (e.getSlot() == 42) {
                if (Main.getInstance().fetchData().isAT(p)) {
                    stalker.openStalker(p);
                } else {
                    p.sendMessage("§cK pouzivani teto sekce musis byt v AT!");
                }
            }
        }
        if (e.getInventory().getTitle().equals("Nastaveni jazyka")) {
            if (e.getSlot() == 36) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BASS, 13.0F, 1.0F);
                p.sendMessage("");
                p.sendMessage("§d▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                p.sendMessage("");
                p.sendMessage("");
                p.sendMessage("§eOdkaz na nas Crowdin projekt:");
                //p.sendMessage("§bhttps://crowdin.com/project/craftmaniacz");
                p.sendMessage("§cAktualne nedostupny...");
                p.sendMessage("");
                p.sendMessage("§d▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                p.sendMessage("");
                p.closeInventory();
            }
            if (e.getSlot() == 40) {
                openMenu(p);
            }
        }
        if (e.getInventory().getTitle().equals("Stalker")) {
            if (e.getSlot() == 40) {
                stalker.openAdminStalker(p);
            }
            e.setCancelled(true);
            p.updateInventory();
        }
        if (e.getInventory().getTitle().equals("Socialni site")) {
            if (e.getSlot() == 40) {
                openMenu(p);
            }
            if (e.getSlot() == 10) {
                if (e.isLeftClick()) {
                    if (!fb_editor.contains(p)) {
                        fb_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj nick na Faceboku. Pozor na tvar!");
                        p.sendMessage("§8https://www.facebook.com/§cNICK");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_facebook", "0");
                    p.sendMessage("§eTvuj Facebook odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            if (e.getSlot() == 12) {
                if (e.isLeftClick()) {
                    if (!tw_editor.contains(p)) {
                        tw_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj nick na Twitteru. Pozor na tvar!");
                        p.sendMessage("§8https://twitter.com/§cNICK");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_twitter", "0");
                    p.sendMessage("§eTvuj Twitter odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            if (e.getSlot() == 14) {
                if (e.isLeftClick()) {
                    if (!youtube_editor.contains(p)) {
                        youtube_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj nick na Youtube. Pozor na tvar!");
                        p.sendMessage("§8https://www.youtube.com/user/§cNICK");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_ytb", "0");
                    p.sendMessage("§eTvuj Youtube odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            if (e.getSlot() == 16) {
                if (e.isLeftClick()) {
                    if (!twitch_editor.contains(p)) {
                        twitch_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj nick na Twitch. Pozor na tvar!");
                        p.sendMessage("§8https://www.twitch.tv/§cNICK");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_twitch", "0");
                    p.sendMessage("§eTvuj Twitch odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            if (e.getSlot() == 20) {
                if (e.isLeftClick()) {
                    if (!web_editor.contains(p)) {
                        web_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj na jakoukoliv stranku!");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()
                        && e.getCurrentItem().getItemMeta().getDisplayName().equals("§bWeb (vlastni URL)")) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_web", "0");
                    p.sendMessage("§eTvuj Web odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            if (e.getSlot() == 24) {
                if (e.isLeftClick()) {
                    if (!steam_editor.contains(p)) {
                        steam_editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis svuj nick na Steam. Pozor na tvar!");
                        p.sendMessage("§8https://steamcommunity.com/id/§cNICK");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()) {
                    Main.getInstance().fetchData().updateSocLinks(p, "soc_steam", "0");
                    p.sendMessage("§eTvuj Steam odkaz byl smazan!");
                    openSocialMenu(p);
                }
            }
            e.setCancelled(true);
            p.updateInventory();
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();
        if (editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                editor.remove(p);
                p.sendMessage("§cZmena statusu zrusena!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateStatus(p, m);
            editor.remove(p);
            p.sendMessage("§eStatus nastaven na: §f" + m);
        }
        if (fb_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                fb_editor.remove(p);
                p.sendMessage("§cZmena odkazu na Facebook byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_facebook", m);
            fb_editor.remove(p);
            p.sendMessage("§eFacebook link nastaven na: §fhttps://www.facebook.com/§b" + m);
        }
        if (twitch_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                twitch_editor.remove(p);
                p.sendMessage("§cZmena odkazu na Twitch byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_twitch", m);
            twitch_editor.remove(p);
            p.sendMessage("§eTwitch link nastaven na: §fhttps://www.twitch.tv/§b" + m);
        }
        if (youtube_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                youtube_editor.remove(p);
                p.sendMessage("§cZmena odkazu na Youtube byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_ytb", m);
            youtube_editor.remove(p);
            p.sendMessage("§eYoutube link nastaven na: §fhttps://www.youtube.com/user/§b" + m);
        }
        if (tw_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                tw_editor.remove(p);
                p.sendMessage("§cZmena odkazu na Twitter byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_twitter", m);
            tw_editor.remove(p);
            p.sendMessage("§eTwitter link nastaven na: §fhttps://twitter.com/§b" + m);
        }
        if (web_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                web_editor.remove(p);
                p.sendMessage("§cZmena odkazu na svuj web byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_web", m);
            web_editor.remove(p);
            p.sendMessage("§eWeb link nastaven na: §b" + m);
        }
        if (steam_editor.contains(p)) {
            e.setCancelled(true);
            if (m.equalsIgnoreCase("exit")) {
                steam_editor.remove(p);
                p.sendMessage("§cZmena odkazu na Steam byl zrusen!");
                return;
            }
            if (m.length() > 100) {
                p.sendMessage("§cMaximalne jde nastavit 100 znaku! Pokud chces zrusit editaci napis - exit");
                return;
            }
            Main.getInstance().fetchData().updateSocLinks(p, "soc_steam", m);
            steam_editor.remove(p);
            p.sendMessage("§eSteam link nastaven na: §fhttps://steamcommunity.com/id/§b" + m);
        }
    }

    private String getDate(long time) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(cal.getTime());
    }

    private String getWebGroup(int id) {
        switch (id) {
            case 0:
                return "§fHrac";
            case 1:
                return "§5Premium";
            case 2:
                return "§aHelper";
            case 3:
                return "§aHelperka";
            case 4:
                return "§cAdmin";
            case 5:
                return "§cAdminka";
            case 6:
                return "§5Builder";
            case 7:
                return "§eEventer";
            case 8:
                return "&6Moderator";
            case 9:
                return "§cHl.Admin";
            case 10:
                return "§eSprávce webu";
            case 11:
                return "§bMajitel";
            default:
                return "§fHrac";
        }
    }

    private String getSocialLinks(Player p, String table) {
        String data = Main.getInstance().fetchData().getPlayerProfileDataString(p, table);
        if (data.equalsIgnoreCase("0")) {
            return "§8Nenastaveno";
        }
        if (table.equalsIgnoreCase("soc_facebook")) {
            return "§7https://www.facebook.com/§f" + data;
        }
        if (table.equalsIgnoreCase("soc_twitter")) {
            return "§7https://twitter.com/§f" + data;
        }
        if (table.equalsIgnoreCase("soc_ytb")) {
            return "§7https://www.youtube.com/user/§f" + data;
        }
        if (table.equalsIgnoreCase("soc_steam")) {
            return "§7https://steamcommunity.com/id/§f" + data;
        }
        if (table.equalsIgnoreCase("soc_twitch")) {
            return "§7https://www.twitch.tv/§f" + data;
        }
        if (table.equalsIgnoreCase("soc_web")) {
            return "§f" + data;
        }
        return "§fNenastaveno";
    }

}
