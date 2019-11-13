package cz.wake.lobby.gui;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Servers implements Listener {

    public static Random random = new Random();

    public void openServersMenu(Player p) {

        /*Inventory inv = Bukkit.createInventory(null, 36, "Vyber serveru");

        ItemStack surv = ItemFactory.create(Material.GOLD_PICKAXE, (byte) 0, "§a§lSurvival (1.12)", "§8Survival, Economy, PVP", "",
                "§7Stary dobry survival, s mnoha", "§7vylepsenim a prikazy.", "", "§b▸ Kliknutim te portnu", getPlayers("survival", false));
        inv.setItem(10, surv);

        ItemStack skyb = ItemFactory.create(Material.SAPLING, randomByte((byte) 0, (byte) 5), "§b§lSkyBlock (1.12)", "§8Survival, Economy, PVP", "",
                "§7Spawnes se na opustenem ostrove", "§7sam a se zakladnimi surovinami.", "§7Postav si svuj ostrov sam", "§7nebo s kamarady.", "", "§b▸ Kliknutim te portnu", getPlayers("skyblock", false));
        inv.setItem(11, skyb);

        ItemStack crea1 = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§e§lCreative (1.12) §c§l[STARY]", "§8Creative, pozemky, WorldEdit", "",
                "§7Svet, ve kterem muzes prakticky", "§7delat co chces. Stavet, budovat,", "§7nebo se proste zlepsovat.", "", "§c§lNa tomto serveru nedoporucujeme hrat", "§c§laktualne podporovana verze je 1.14.4!", "", "§b▸ Kliknutim te portnu", getPlayers("creative2", false));
        inv.setItem(21, crea1);

        ItemStack creative = ItemFactory.createHead("§5§lCreative (1.14) §e[BETA]", "854b57bd-180c-4eaf-99c3-380109af5501", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDkzMGQ1NjA4ZmE0OWJlMDAzNWMzNGJmMGQ1MjhlNWFiMDBmOTFhOWJkYmQ0MzAwMzljZDQ3NzJkNzNmYjczMCJ9fX0=");
        ItemMeta creativeMeta = creative.getItemMeta();
        ArrayList<String> creativeLore = new ArrayList<>();
        creativeLore.add("§8Creative, pozemky, WorldEdit");
        creativeLore.add("");
        creativeLore.add("§7Nova verze, novy bloky");
        creativeLore.add("§7vse novy! Zvladnes postavit");
        creativeLore.add("§7nejlepsi stavbu a byt tak tim nej?!");
        creativeLore.add("");
        creativeLore.add("§b▸ Kliknutim te portnu");
        creativeLore.add(getPlayers("creative2", false));
        creativeMeta.setLore(creativeLore);
        creative.setItemMeta(creativeMeta);
        inv.setItem(12, creative);

        ItemStack vanilla14 = ItemFactory.createHead("§f§lVanilla (1.14) §e[BETA]", "4ac2d250-1168-48e0-ab06-82993744aad9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTNiMmRkNGY5NWRhYzJlY2U2Y2EwNTVlZDA3NDA5ZTA1ODUwNzk5Njg0YWNlZTVhNmIyODhkMGVmYTFkZTA2OSJ9fX0=");
        ItemMeta vanilla14Meta = vanilla14.getItemMeta();
        ArrayList<String> vanilla14Lore = new ArrayList<>();
        vanilla14Lore.add("§8Vanilla, Území, PVP");
        vanilla14Lore.add("");
        vanilla14Lore.add("§7Nová Vanilla s územím");
        vanilla14Lore.add("§7a bojem o život jako nikdy předtím!");
        vanilla14Lore.add("");
        vanilla14Lore.add("§b▸ Kliknutim te portnu");
        vanilla14Lore.add(getPlayers("vanilla", false));
        vanilla14Meta.setLore(vanilla14Lore);
        vanilla14.setItemMeta(vanilla14Meta);
        inv.setItem(13, vanilla14);

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
        prisonLore.add("§c▸ Predelava se...");
        //prisonLore.add(getPlayers("prison"));
        prisonMeta.setLore(prisonLore);
        prison.setItemMeta(prisonMeta);
        //inv.setItem(15, prison);

        ItemStack halloweenGame = ItemFactory.createHead("§6§lHALLOWEEN MINIGAME 2019", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ==");
        ItemMeta halloweenGameMeta = halloweenGame.getItemMeta();
        ArrayList<String> halloweenGameLore = new ArrayList<>();
        halloweenGameLore.add("§8Special Limited Minigame");
        halloweenGameLore.add("");
        halloweenGameLore.add("§7Soumrak se rok s rokem sešel,");
        halloweenGameLore.add("§7nyní přichází den, kdy okusíš svou krev.");
        halloweenGameLore.add("§7Dokážeš přežít vlny monster a zachránit se tak?");
        halloweenGameLore.add("");
        halloweenGameLore.add("§eV teto minihře se soutěží o ceny! Více info na webu.");
        halloweenGameLore.add("");
        halloweenGameLore.add("§b▸ Levým kliknutim te portnu");
        halloweenGameLore.add("§d▸ Pravým zobrazíš odkaz na leaderboard");
        halloweenGameLore.add(getPlayers("halloween-games", false));
        halloweenGameMeta.setLore(halloweenGameLore);
        halloweenGame.setItemMeta(halloweenGameMeta);
        inv.setItem(15, halloweenGame);

        ItemStack van = ItemFactory.create(Material.EMERALD, (byte) 0, "§f§lVanilla (1.13.2) §c§l[STARY]", "§8Vanilla, Survival, PVP", "", "§7Otevreny svet, ve kterem",
                "§7poznas, co to je zit", "§7na vlastni pest.", "", "§c§lNa tomto serveru nedoporucujeme hrat", "§c§laktualne podporovana verze je 1.14.4!" , "" , "§b▸ Kliknutim te portnu", getPlayers("vanilla2", false));
        inv.setItem(22, van);

        ItemStack vanillasb = ItemFactory.create(Material.PUMPKIN, (byte) 0, "§6§lVanilla Skyblock (1.13.2)", "§8Vanilla, Skyblock, RPG", "",
                "§7Toto je vyzva, ktera ti neda!", "§7Dokazes prezit na pustem", "§7ostrove a plnit ukoly?", "", "§c▸ Predelava se...");
        //inv.setItem(16, vanillasb);

        p.openInventory(inv);
*/
    }

    /*
        Random generator
     */
    private byte randomByte(byte start, byte end) {
        int cislo = start + random.nextInt(end - start + 1);
        return (byte) cislo;
    }

    private String getPlayers(final String server, final boolean section) {
        AtomicInteger players = new AtomicInteger();
        if (section) {
            Main.getInstance().getCraftBalancerManager().getSectionPlayerCount("halloween-games", players::set);
        } else {
            players.set(Main.getInstance().getSQL().getOnlinePlayers(server));
        }
        if (players.get() == 0) {
            return "§8Nikdo na serveru neni!";
        } else if (players.get() == 1) {
            return "§8Aktualne hraje " + players + " hrac.";
        } else if (players.get() >= 2 && players.get() <= 4) {
            return "§8Aktualne hraji " + players + " hraci.";
        } else {
            return "§8Aktualne hraje " + players + " hracu.";
        }
    }


}
