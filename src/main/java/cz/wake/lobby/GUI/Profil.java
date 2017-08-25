package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

    public static HashSet<Player> editor = new HashSet<>();

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
        headLore.add("§7Celkem odehrany cas: §f" + TimeUtils.formatTime("%dd, %hh %mm", Main.getInstance().fetchData().getPlayerProfileDataInt(p, "played_time"),false));
        headItemMeta.setLore(headLore);
        headItem.setItemMeta(headItemMeta);
        menu.setItem(12, headItem);

        ItemStack status = ItemFactory.create(Material.PAPER, (byte)0, "§aTvuj status","§8Status je viditelny na webu","§8v profilech", "", "§f" + Main.getInstance().fetchData().getPlayerProfileDataString(p, "status"), "", "§eLevym kliknutim zmenis", "§ePravym kliknutim smazes");
        menu.setItem(14, status);

        ItemStack soc = ItemFactory.createHead("Test", "4ac1c429-e329-4861-b1d6-c4bde50022d9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGViNDYxMjY5MDQ0NjNmMDdlY2ZjOTcyYWFhMzczNzNhMjIzNTliNWJhMjcxODIxYjY4OWNkNTM2N2Y3NTc2MiJ9fX0=", "§aSocialni site","", "§7Chces vsem poskytnout prime", "§7odkazy na svem profilu?", "", "§bOdkazy se zobrazuji na webu", "§bv profilech.","", "§eKliknutim provedes zmeny");
        menu.setItem(29, soc);

        ItemStack statistiky = ItemFactory.create(Material.BOOK, (byte)0, "§aStatistiky", "", "§7Zobrazi vsechny tve statistiky", "§7ze serveru.", "", "§cPredelava se...");
        menu.setItem(30, statistiky);

        ItemStack multipliers = ItemFactory.create(Material.POTION, (byte)0, "§aMultipliery", "", "§7Chces vydelavat vic?", "§7Zde je to prave misto...", "", "§cPlanovano...");
        menu.setItem(32, multipliers);

        ItemStack levels = ItemFactory.create(Material.BREWING_STAND_ITEM,(byte)0, "§aCraftLevels", "", "§7Ziskavanim levelu", "§7si odemknes nove veci na serveru.", "", "§cPlanovano...");
        menu.setItem(31, levels);

        ItemStack achievements = ItemFactory.create(Material.EMERALD, (byte)0, "§aAchievementy", "", "§7Chces videt, ktery ukoly", "§7jsi splnil a ktere", "§7musis splnit?", "", "§cPlanovano...");
        menu.setItem(33, achievements);

        ItemStack questy = ItemFactory.create(Material.DIAMOND, (byte)0, "§aQuesty","", "§7Nuda? No tak zkus kazdy den", "§7splnit nektery z techto Questu!", "", "§cPlanovano...");
        menu.setItem(39,questy);

        ItemStack villages = ItemFactory.create(Material.DARK_OAK_DOOR_ITEM, (byte)0, "§aVillages", "", "§7Kdo vi.. co to bude?", "", "§cPlanovano...");
        menu.setItem(38, villages);

        if(Main.getInstance().fetchData().isAT(p)){
            ItemStack i = ItemFactory.create(Material.PAINTING, (byte)0, "§aAT Stalker","§7Prehled tve aktivity", "§7na serveru.","","§eKlikni pro zobrazeni");
            menu.setItem(42,i);
        } else {
            ItemStack i = ItemFactory.create(Material.BARRIER, (byte)0, "§cAT Sekce","§7K zobrazeni teto sekce", "§7musis byt v AT.");
            menu.setItem(42,i);
        }

        ItemStack nastaveni = ItemFactory.create(Material.REDSTONE_COMPARATOR, (byte)0, "§aNastaveni uctu","","§7Diky nastaveni si muzes", "§7prispusobit lobby/hry podle sebe.", "", "§eKlikni pro zobrazeni/nastaveni");

        ItemStack multiplier = ItemFactory.create(Material.BARRIER,(byte)0, "§cMultipliers","§8Planovano...");

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

        //menu.setItem(10, statistics);
        //menu.setItem(16, achievements);
        //menu.setItem(28, multiplier);
        menu.setItem(41, nastaveni);
        menu.setItem(40, jazyk);

        p.openInventory(menu);
    }

    public void openLanguageMenu(Player p){

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

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte)0, "§eZpet");
        ItemStack help = ItemFactory.create(Material.BOOK, (byte)0, "§aPomoc s prekladem","§7Chces nam pomoct s prekladem?", "§7Neni nic jednodussiho nez si", "§7pozadat o pristup v nasem","§7projektu na Crowdinu!","","§eKliknutim zobrazis odkaz na projekt");

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
            if(e.getSlot() == 14){
                if(e.isLeftClick()){
                    if(!editor.contains(p)){
                        editor.add(p);
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage("§eNyni napis zpravu, co chces nastavit jako status!");
                        p.sendMessage("");
                    }
                } else if (e.isRightClick()){
                    p.closeInventory();
                    Main.getInstance().fetchData().updateStatus(p, "Tento hrác nemá nastavený status...");
                    p.sendMessage("§eStatus byl vyresetovany na default!");
                }
            }
        }
    }

    //TODO: Dodělat omezení na 100 znaků

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String m = e.getMessage();
        if(editor.contains(p)){
            e.setCancelled(true);
            if(m.equalsIgnoreCase("exit")){
                editor.remove(p);
                p.sendMessage("§cZmena statusu zrusena!");
                return;
            }
            Main.getInstance().fetchData().updateStatus(p, m);
            editor.remove(p);
            p.sendMessage("§eStatus nastaven na: §f" + m);
        }
    }

    private String getDate(long time) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        final String timeString = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(cal.getTime());
        return timeString;
    }

    private String getWebGroup(int id){
        switch (id){
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
                return "§cHl.Admin";
            case 8:
                return "§eSprávce webu";
            case 9:
                return "§bMajitel";
            default:
                return "§fHrac";
        }
    }

}
