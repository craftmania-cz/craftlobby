package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Servers implements Listener {

    public static Random random = new Random();

    public void openServersMenu(Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, "Vyber serveru");

        ItemStack surv = ItemFactory.create(Material.GOLD_PICKAXE, (byte) 0, "§e§lSurvival", "§8Survival, Economy, PVP", "",
                "§7Stary dobry survival, s mnoha", "§7vylepsenim a prikazy.", "", "§b▸ Kliknutim te portnu", getPlayers("survival"));
        inv.setItem(10, surv);

        ItemStack skyb = ItemFactory.create(Material.SAPLING, randomByte((byte) 0, (byte) 5), "§e§lSkyBlock", "§8Survival, Economy, PVP", "",
                "§7Spawnes se na opustenem ostrove", "§7sam a se zakladnimi surovinami.", "§7Postav si svuj ostrov sam", "§7nebo s kamarady.", "", "§b▸ Kliknutim te portnu", getPlayers("skyblock"));
        inv.setItem(11, skyb);

        ItemStack crea1 = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§e§lCreative #1", "§8Creative, pozemky, WorldEdit", "",
                "§7Svet ve kterem muzes prakticky", "§7delat co chces, stavet, budovat", "§7nebo se proste zlepsovat.", "", "§b▸ Kliknutim te portnu", getPlayers("creative"));
        inv.setItem(12, crea1);

        ItemStack crea2 = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§e§lCreative #2", "§8Creative, pozemky, WorldEdit", "",
                "§7Dalsi svet, ve kterem", "§7lze delat prakticky vse.", "", "§b▸ Kliknutim te portnu", getPlayers("creative2"));
        inv.setItem(13, crea2);

        ItemStack pris = ItemFactory.create(Material.IRON_FENCE, (byte) 0, "§e§lPrison", "§8RankUp, Prestige, Mining", "", "§7Svet ve kterem je dulezite",
                "§7se zlepsovat a kopat", "§7jinak budes pozadu.", "", "§b▸ Kliknutim te portnu", getPlayers("prison"));
        inv.setItem(14, pris);

        ItemStack van = ItemFactory.create(Material.EMERALD, (byte) 0, "§e§lVanilla (1.12)", "§8Vanilla, Survival, PVP", "", "§7Otevreny svet ve kterem",
                "§7poznas co to je zit", "§7na vlastni pest.","","§cTento server vyzaduje verzi 1.12", "", "§b▸ Kliknutim te portnu", getPlayers("vanilla"));
        inv.setItem(15, van);

        ItemStack vanillasb = ItemFactory.create(Material.PUMPKIN, (byte)0, "§e§lVanilla Skyblock", "§8Vanilla, Skyblock, RPG", "",
                "§7Toto je vyzva, ktera ti neda!", "§7Dokazes prezit na pustem","§7ostrove a plnit ukoly?", "", "§b▸ Kliknutim te portnu", getPlayers("vanillasb"));
        inv.setItem(16, vanillasb);

        ItemStack bedw = ItemFactory.create(Material.BED, (byte) 0, "§a§lBedWars", "§8Minihra, PVP", "", "§7Ctyri teamy proti sobe", "§7a jeden vitez! Bude to tvuj team?",
                "", "§eMultiplier: §62.0x", "", "§b▸ Kliknutim te portnu");
        bedw = ItemFactory.addGlow(bedw);
        inv.setItem(20, bedw);

        ItemStack sw = ItemFactory.create(Material.BOW, (byte) 0, "§a§lSkyWars", "§8Minihra, PVP", "", "§7Kazdy sam za sebe,", "§7vyhraje pouze ten nejlepsi.", "", "§bSolo: §fKlasicky SkyWars",
                "§aTeam: §fDva hraci spolu? Neni problem!", "§cInsane: §fOP SkyWars s Eventy", "", "§7Multiplier: §81.0x", "", "§b▸ Kliknutim te portnu");
        sw = ItemFactory.addGlow(sw);
        inv.setItem(21, sw);

        ItemStack sg = ItemFactory.create(Material.SKULL_ITEM, (byte)2, "§c?","", "§8Jiz brzy...");
        ItemStack otaznik = ItemFactory.createHead("test", "8f4ab92d-fc8d-4321-87fb-d6f819fe7eab",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNlYzg1YmM4MDYxYmRhM2UxZDQ5Zjc1NDQ2NDllNjVjODI3MmNhNTZmNzJkODM4Y2FmMmNjNDgxNmI2OSJ9fX0=","§c?","§8Jiz brzy...");
        inv.setItem(22, otaznik);

        ItemStack getdown = ItemFactory.create(Material.IRON_BOOTS, (byte)0, "§e§lGetDown §6§lNOVINKA","§8Arcade PVP","", "§7Dostan se co nejniz","§7a ziskej co nejvic coinu,","§7pak vsechny rozskej!","", "§7Multiplier: §81.0x", "", "§b▸ Kliknutim te portnu");
        inv.setItem(24, getdown);

        new BukkitRunnable() {
            int c = 1;

            @Override
            public void run() {
                if (c == 1) {
                    ItemStack i = ItemFactory.create(Material.PAINTING, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§eDrawIt", "§fBuildBattle", "§fSpeedBuilders", "", "§7Multiplier: §81.0x", "", "§b▸ Kliknutim te portnu");
                    inv.setItem(23, i);
                    c++;
                } else if (c == 2) {
                    ItemStack i = ItemFactory.create(Material.WORKBENCH, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§fDrawIt", "§eBuildBattle", "§fSpeedBuilders", "", "§7Multiplier: §81.0x", "", "§b▸ Kliknutim te portnu");
                    inv.setItem(23, i);
                    c++;
                } else if (c == 3) {
                    ItemStack i = ItemFactory.create(Material.PRISMARINE_CRYSTALS, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§fDrawIt", "§fBuildBattle", "§eSpeedBuilders", "", "§7Multiplier: §81.0x", "", "§b▸ Kliknutim te portnu");
                    inv.setItem(23, i);
                    c = 1;
                }
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(), 0, 25);

        ItemStack lobby = ItemFactory.create(Material.BOOKSHELF, (byte) 0, "§c§lLobby", "", "§7Kliknutim zobrazis prehled", "§7vsech lobby na CM.", "", "§c▸ Nedostupne");
        //inv.setItem(18, lobby);

        ItemStack event = ItemFactory.create(Material.FIREWORK, (byte) 0, "§c§lEventy", "", "§7Server urceny pro pro", "§7celoserverove eventy.", "", "§e§nAktualne se zadny event nekona!");
        //inv.setItem(27, event);

        p.openInventory(inv);

    }

    private byte randomByte(byte start, byte end) {
        int cislo = start + random.nextInt(end - start + 1);
        return (byte) cislo;
    }

    private String getPlayers(final String server){
        int pl = Main.getInstance().fetchData().getOnlinePlayers(server);
        if(pl == 0){
            return "§8Nikdo na serveru neni!";
        } else if (pl == 1){
            return "§8Aktualne hraje " + pl + " hrac.";
        } else if (pl >= 2 && pl <= 4){
            return "§8Aktualne hraje " + pl + " hraci.";
        } else {
            return "§8Aktualne hraje " + pl + " hracu.";
        }
    }


}
