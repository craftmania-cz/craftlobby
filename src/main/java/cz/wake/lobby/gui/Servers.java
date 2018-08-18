package cz.wake.lobby.gui;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class Servers implements Listener {

    public static Random random = new Random();

    public void openServersMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, "Vyber serveru");

        ItemStack surv = ItemFactory.create(Material.GOLD_PICKAXE, (byte) 0, "§a§lSurvival (1.12)", "§8Survival, Economy, PVP", "",
                "§7Stary dobry survival, s mnoha", "§7vylepsenim a prikazy.", "", "§b▸ Kliknutim te portnu", getPlayers("survival"));
        inv.setItem(10, surv);

        ItemStack skyb = ItemFactory.create(Material.SAPLING, randomByte((byte) 0, (byte) 5), "§b§lSkyBlock (1.12)", "§8Survival, Economy, PVP", "",
                "§7Spawnes se na opustenem ostrove", "§7sam a se zakladnimi surovinami.", "§7Postav si svuj ostrov sam", "§7nebo s kamarady.", "", "§b▸ Kliknutim te portnu", getPlayers("skyblock"));
        inv.setItem(11, skyb);

        ItemStack crea1 = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§e§lCreative (1.12)", "§8Creative, pozemky, WorldEdit", "",
                "§7Svet ve kterem muzes prakticky", "§7delat co chces, stavet, budovat", "§7nebo se proste zlepsovat.", "", "§b▸ Kliknutim te portnu", getPlayers("creative"));
        inv.setItem(12, crea1);

        ItemStack prison = ItemFactory.createHead("§9§lPrison 2.0", "8afde947-d0e5-4507-837c-c1bbec43d7e4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQyNzY0M2IxZWVjZmE3NGVlOTUxZDhkZmVmYjZkOWJjZjU4MjZiZWQyNzM0MjJjZWQ3ZWJlY2YxNzY1YzkifX19");
        ItemMeta prisonMeta = prison.getItemMeta();
        ArrayList<String> prisonLore = new ArrayList<>();
        prisonLore.add("§8RankUP, Prestige, Mining");
        prisonLore.add("");
        prisonLore.add("§7Zcela novy Prison server,");
        prisonLore.add("§7na kterem poznas, co to opravdu");
        prisonLore.add("§7Prison je! Nikdo te totiz");
        prisonLore.add("§7nebude setrit!");
        prisonLore.add("");
        prisonLore.add("§b▸ Kliknutim te portnu");
        prisonLore.add(getPlayers("prison"));
        prisonMeta.setLore(prisonLore);
        prison.setItemMeta(prisonMeta);
        inv.setItem(13, prison);

        ItemStack van = ItemFactory.create(Material.EMERALD, (byte) 0, "§f§lVanilla (1.12)", "§8Vanilla, Survival, PVP", "", "§7Otevreny svet ve kterem",
                "§7poznas co to je zit", "§7na vlastni pest.", "", "§b▸ Kliknutim te portnu", getPlayers("vanilla"));
        inv.setItem(14, van);

        ItemStack vanillasb = ItemFactory.create(Material.PUMPKIN, (byte) 0, "§6§lVanilla Skyblock (1.12)", "§8Vanilla, Skyblock, RPG", "",
                "§7Toto je vyzva, ktera ti neda!", "§7Dokazes prezit na pustem", "§7ostrove a plnit ukoly?", "", "§c▸ Predelava se...");
        inv.setItem(15, vanillasb);

        ItemStack sw = ItemFactory.create(Material.BOW, (byte) 0, "§a§lSkyWars", "§8Minihra, PVP", "", "§7Kazdy sam za sebe,", "§7vyhraje pouze ten nejlepsi.", "", "§bSolo: §fKlasicky SkyWars",
                "§aTeam: §fDva hraci spolu? Neni problem!", "§cInsane: §fOP SkyWars s Eventy", "", "§7Multiplier: §81.0x", "", "§cPredelava se...");
        sw = ItemFactory.addGlow(sw);
        inv.setItem(19, sw);

        ItemStack bedwars2 = ItemFactory.create(Material.BED, (byte)3, "§b§lBedWars", "§8PvP, Teams", "", "§7Zcela nove BedWars, ktere se", "§7ti dostanou totalne pod kuzi", "", "§eStandart: §fKlasicke BedWars", "§cRanked: §fJen ta elita, co umi PVP", "", "§7Mody: §f4x4, pozdeji 1x8, 2x12, 2x2", "", "§cPredelava se...");
        inv.setItem(20, bedwars2);


        ItemStack murder = ItemFactory.createHead("§c§lMurder", "234d66f5-6767-4201-b649-5f60d3a1433b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhhNGUzNDFkOGNkMzRkYTJkNzEwYzJhYTQ4MzQxNDFhMGQzNzczYTgwZWE3OGNlNmNlZmNiYzY2ZmVjYTIifX19");
        ItemMeta murderMeta = murder.getItemMeta();
        ArrayList<String> murderLore = new ArrayList<>();
        murderLore.add("§8Arcade, PVP");
        murderLore.add("");
        murderLore.add("§7Vrazda musi byt vykonana");
        murderLore.add("§7potichu a beze stop.");
        murderLore.add("§7Zvladnes to?");
        murderLore.add("");
        murderLore.add("§cPredelava se...");
        murderMeta.setLore(murderLore);
        murder.setItemMeta(murderMeta);
        inv.setItem(21, murder);


        ItemStack turnaj = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta metaTurnaj = turnaj.getItemMeta();
        metaTurnaj.setDisplayName("§6§lGIGA Turnaj 2017");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c ");
        lore.add("§7Finalni turnaj v roce 2017");
        lore.add("§7pro hrace naseho serveru!");
        lore.add("");
        lore.add("§fPristup na server: " + getPristup(p));
        lore.add("");
        lore.add("§8Pristup dostanou pouze hraci");
        lore.add("§8ktery maji v tu dobu hrat!");
        lore.add("");
        lore.add("§bLevym kliknutim se pripojis!");
        lore.add("§bPravym kliknutim zobrazis odkaz na stream");
        metaTurnaj.setLore(lore);
        turnaj.setItemMeta(metaTurnaj);
        //inv.setItem(30, turnaj);

        p.openInventory(inv);

    }

    /*
        Random generator
     */
    private byte randomByte(byte start, byte end) {
        int cislo = start + random.nextInt(end - start + 1);
        return (byte) cislo;
    }

    /*
        Pouze pro GIGA Turnaj
     */
    private String getPristup(Player p){
        if(Main.getInstance().getSQL().isInWhitelist(p)){
            if(Main.getInstance().getSQL().unlockState().equalsIgnoreCase("1")){
                return "§c§lNE";
            } else {
                return "§a§lANO";
            }
        }
        return "§c§lNE";
    }

    private String getPlayers(final String server) {
        int pl = Main.getInstance().getSQL().getOnlinePlayers(server);
        if (pl == 0) {
            return "§8Nikdo na serveru neni!";
        } else if (pl == 1) {
            return "§8Aktualne hraje " + pl + " hrac.";
        } else if (pl >= 2 && pl <= 4) {
            return "§8Aktualne hraji " + pl + " hraci.";
        } else {
            return "§8Aktualne hraje " + pl + " hracu.";
        }
    }


}
