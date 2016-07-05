package cz.wake.plugins.GUI;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ItemFactory;
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

        Inventory inv = Bukkit.createInventory(null, 54, "           §0§nVyber serveru");

        ItemStack colorful = ItemFactory.create(Material.STAINED_GLASS_PANE, randomByte((byte) 1, (byte) 15), " ");

        inv.setItem(0, colorful);
        inv.setItem(1, colorful);
        inv.setItem(2, colorful);
        inv.setItem(3, colorful);
        inv.setItem(4, colorful);
        inv.setItem(5, colorful);
        inv.setItem(6, colorful);
        inv.setItem(7, colorful);
        inv.setItem(8, colorful);
        inv.setItem(45, colorful);
        inv.setItem(46, colorful);
        inv.setItem(47, colorful);
        inv.setItem(48, colorful);
        inv.setItem(49, colorful);
        inv.setItem(50, colorful);
        inv.setItem(51, colorful);
        inv.setItem(52, colorful);
        inv.setItem(53, colorful);

        ItemStack surv = ItemFactory.create(Material.GOLD_PICKAXE, (byte) 0, "§e§lSurvival", "§8Survival, Economy, PVP", "",
                "§7Stary dobry survival, s mnoha", "§7vylepsenim a prikazy.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(20, surv);

        ItemStack skyb = ItemFactory.create(Material.SAPLING, randomByte((byte) 0, (byte) 5), "§e§lSkyBlock", "§8Survival, Economy, PVP", "",
                "§7Spawnes se na opustenem ostrove", "§7sam a se zakladnimi surovinami.", "§7Postav si svuj ostrov sam", "§7nebo s kamarady.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(21, skyb);

        ItemStack crea1 = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§e§lCreative #1", "§8Creative, pozemky, WorldEdit", "",
                "§7Svet ve kterem muzes prakticky", "§7delat co chces, stavet, budovat", "§7nebo se proste zlepsovat.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(22, crea1);

        ItemStack crea2 = ItemFactory.create(Material.WATER_BUCKET, (byte) 0, "§e§lCreative #2", "§8Creative, pozemky, WorldEdit", "",
                "§7Dalsi svet, ve kterem", "§7lze delat prakticky vse.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(23, crea2);

        ItemStack pris = ItemFactory.create(Material.IRON_FENCE, (byte) 0, "§e§lPrison", "§8RankUp, Prestige, Mining", "", "§7Svet ve kterem je dulezite",
                "§7se zlepsovat a kopat", "§7jinak budes pozadu.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(24, pris);

        ItemStack van = ItemFactory.create(Material.EMERALD, (byte) 0, "§e§lVanilla", "§8Vanilla, Survival, PVP", "", "§7Otevreny svet ve kterem",
                "§7poznas co to je zit", "§7na vlastni pest.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(25, van);

        ItemStack fac = ItemFactory.create(Material.TNT, (byte) 0, "§e§lFactions", "§8Frakce, PVP, souboje", "", "§7Zde nikdy nevis", "§7kdo ti jde po krku.",
                "§7Az to zjistis, bude pozde.", "", "§b▸ Kliknutim te portnu");
        inv.setItem(26, fac);

        ItemStack bedw = ItemFactory.create(Material.BED, (byte) 0, "§a§lBedWars", "§8Minihra, PVP", "", "§7Ctyri teamy proti sobe", "§7a jeden vytez! Bude to tvuj team?",
                "", "§7Multiplier: §63.0x", "", "§b▸ Kliknutim te portnu");
        bedw = ItemFactory.addGlow(bedw);
        inv.setItem(29, bedw);

        ItemStack sw = ItemFactory.create(Material.BOW, (byte) 0, "§a§lSkyWars §8(1.8)", "§8Minihra, PVP", "", "§7Kazdy sam za sebe,", "§7vyhraje pouze ten nejlepsi.", "§8Brzy: TEAM SKYWARS",
                "", "§7Multiplier: 1.0x", "", "§b▸ Kliknutim te portnu");
        inv.setItem(30, sw);

        ItemStack an = ItemFactory.create(Material.ENDER_STONE, (byte) 0, "§a§lAnnihilation", "§8Minihra, Team PVP", "", "§7Hlavnim ukolem je znicit", "§7Nexus jineho teamu. Stihnes to,",
                "§7nez znici oni tebe?", "", "§7Multiplier: §63.0x", "", "§b▸ Kliknutim te portnu");
        an = ItemFactory.addGlow(an);
        inv.setItem(31, an);

        new BukkitRunnable() {
            int c = 1;

            @Override
            public void run() {
                if (c == 1) {
                    ItemStack i = ItemFactory.create(Material.PAINTING, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§eDrawIt", "§fBuildBattle", "§fSpeedBuilders", "", "§7Multiplier: §63.0x", "", "§b▸ Kliknutim te portnu");
                    i = ItemFactory.addGlow(i);
                    inv.setItem(32, i);
                    c++;
                } else if (c == 2) {
                    ItemStack i = ItemFactory.create(Material.WORKBENCH, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§fDrawIt", "§eBuildBattle", "§fSpeedBuilders", "", "§7Multiplier: §63.0x", "", "§b▸ Kliknutim te portnu");
                    i = ItemFactory.addGlow(i);
                    inv.setItem(32, i);
                    c++;
                } else if (c == 3) {
                    ItemStack i = ItemFactory.create(Material.QUARTZ_BLOCK, (byte) 0, "§a§lArcade", "§8Rychle minihry bez PVP", "",
                            "§fDrawIt", "§fBuildBattle", "§eSpeedBuilders", "", "§7Multiplier: §63.0x", "", "§b▸ Kliknutim te portnu");
                    i = ItemFactory.addGlow(i);
                    inv.setItem(32, i);
                    c = 1;
                }
            }
        }.runTaskTimerAsynchronously(Main.getPlugin(), 0, 25);

        ItemStack lobby = ItemFactory.create(Material.BOOKSHELF, (byte) 0, "§c§lLobby", "", "§7Kliknutim zobrazis prehled", "§7vsech lobby na CM.", "", "§b▸ Pro zobrazeni klikni");
        inv.setItem(18, lobby);

        ItemStack event = ItemFactory.create(Material.FIREWORK, (byte) 0, "§c§lEventy", "", "§7Server urceny pro pro", "§7celoserverove eventy.", "", "§e§nAktualne se zadny event nekona!");
        inv.setItem(27, event);

        p.openInventory(inv);

    }

    private byte randomByte(byte start, byte end) {
        int cislo = start + random.nextInt(end - start + 1);
        return (byte) cislo;
    }


}
