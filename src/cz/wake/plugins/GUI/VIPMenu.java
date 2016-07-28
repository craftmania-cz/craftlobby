package cz.wake.plugins.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VIPMenu {

    public void openVIPMenu(Player p) {

        Inventory vipmenu = Bukkit.createInventory(null, 36, "§lVIP Shop");

        ItemStack sms = new ItemStack(Material.IRON_INGOT);
        ItemMeta sMeta = sms.getItemMeta();
        sMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Nakup pomoci SMS");
        ArrayList<String> sLore = new ArrayList<String>();
        sLore.add(ChatColor.GRAY + "Nakup VIP klasickou metodou.");
        sMeta.setLore(sLore);
        sms.setItemMeta(sMeta);

        ItemStack paypal = new ItemStack(Material.GOLD_INGOT);
        ItemMeta pMeta = paypal.getItemMeta();
        pMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Nakup pomoci PSC/PayPal");
        ArrayList<String> pLore = new ArrayList<String>();
        pLore.add(ChatColor.GRAY + "Nakup pres internet.");
        pMeta.setLore(pLore);
        paypal.setItemMeta(pMeta);

        vipmenu.setItem(11, sms);
        vipmenu.setItem(15, paypal);

        p.openInventory(vipmenu);
    }

    public void openMenuSMS(Player p) {

        Inventory inv = Bukkit.createInventory(null, 27, "§lSMS > Vyber serveru");

        ItemStack surv = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta sMeta = surv.getItemMeta();
        sMeta.setDisplayName("§a§lSurvival VIP");
        ArrayList<String> sLore = new ArrayList<String>();
        sLore.add("§7Kliknutim zvolis server.");
        sMeta.setLore(sLore);
        surv.setItemMeta(sMeta);

        ItemStack sky = new ItemStack(Material.COOKIE);
        ItemMeta skMeta = sky.getItemMeta();
        skMeta.setDisplayName("§a§lSkyblock VIP");
        ArrayList<String> skyLore = new ArrayList<String>();
        skyLore.add("§7Kliknutim zvolis server.");
        skMeta.setLore(skyLore);
        sky.setItemMeta(skMeta);

        ItemStack crea = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta cMeta = crea.getItemMeta();
        cMeta.setDisplayName("§a§lCreative VIP");
        ArrayList<String> cLore = new ArrayList<String>();
        cLore.add("§7Kliknutim zvolis server.");
        cMeta.setLore(cLore);
        crea.setItemMeta(cMeta);

        ItemStack pris = new ItemStack(Material.getMaterial(101));
        ItemMeta pMeta = pris.getItemMeta();
        pMeta.setDisplayName("§a§lPrison dodatky");
        ArrayList<String> pLore = new ArrayList<String>();
        pLore.add("§7Kliknutim zvolis server.");
        pMeta.setLore(pLore);
        pris.setItemMeta(pMeta);

        ItemStack mini = new ItemStack(Material.DIAMOND);
        ItemMeta mMeta = mini.getItemMeta();
        mMeta.setDisplayName("§b§lMiniGames VIP");
        ArrayList<String> mLore = new ArrayList<String>();
        mLore.add("§7Kliknutim zobrazis server.");
        mMeta.setLore(mLore);
        mini.setItemMeta(mMeta);

        ItemStack zpet = new ItemStack(Material.WOOD_DOOR);
        ItemMeta zMeta = zpet.getItemMeta();
        zMeta.setDisplayName("§cZpet na prehled platebnich metod");
        zpet.setItemMeta(zMeta);

        inv.setItem(11, surv);
        inv.setItem(12, sky);
        inv.setItem(13, crea);
        inv.setItem(14, pris);
        inv.setItem(15, mini);
        inv.setItem(26, zpet);

        p.openInventory(inv);
    }

    public void openMinigamesSMS(Player p) {

        Inventory inv = Bukkit.createInventory(null, 27, "§lSMS > MiniGames VIP");

        ItemStack info = new ItemStack(Material.DIAMOND);
        ItemMeta iMeta = info.getItemMeta();
        iMeta.setDisplayName("§b§lVyhody MiniGames VIP");
        ArrayList<String> iLore = new ArrayList<String>();
        iLore.add("");
        iLore.add("§7SkyWars:");
        iLore.add("§e▪ §fPristup ke všem kitum.");
        iLore.add("§7Annihilation:");
        iLore.add("§e▪ §fPristup ke vsem kitum.");
        iLore.add("§7BedWars:");
        iLore.add("§e▪ §fVIP Menu ve Villagerovi");
        iLore.add("§7DrawIt:");
        iLore.add("§e▪ §fPridan cas na kresleni - 75 vterin.");
        iMeta.setLore(iLore);
        info.setItemMeta(iMeta);

        ItemStack t1 = new ItemStack(Material.PAPER);
        ItemMeta it = t1.getItemMeta();
        it.setDisplayName("§b§lVIP §7na §6§l30 dni");
        ArrayList<String> il = new ArrayList<String>();
        il.add("");
        il.add("§cSMS CZ §f-> §c99kc");
        il.add("§fFAKAHEDA Y58473 99 MG §b" + p.getName());
        il.add("§7na cislo: §f90333");
        il.add("");
        il.add("§aSMS SK §f-> §a4e");
        il.add("§fFAKAHEDA Y58473 4 MG §b" + p.getName());
        il.add("§7na cislo: §f8866");
        it.setLore(il);
        t1.setItemMeta(it);

        ItemStack t2 = new ItemStack(Material.PAPER);
        ItemMeta wt = t2.getItemMeta();
        wt.setDisplayName("§b§lVIP §7na §a§lNAVZDY");
        ArrayList<String> wi = new ArrayList<String>();
        wi.add("");
        wi.add("§cSMS CZ §f-> §c249kc");
        wi.add("§fFAKAHEDA Y58473 249 MG §b" + p.getName());
        wi.add("§7na cislo: §f90333");
        wi.add("");
        wi.add("§aSMS SK §f-> §a10e");
        wi.add("§fFAKAHEDA Y58473 10 MG §b" + p.getName());
        wi.add("§7na cislo: §f8866");
        wt.setLore(wi);
        t2.setItemMeta(wt);

        ItemStack nedoslo = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta nMeta = nedoslo.getItemMeta();
        nMeta.setDisplayName("§6§lNedoslo mi VIP");
        ArrayList<String> nLore = new ArrayList<String>();
        nLore.add("§7Kontaktuj nas na:");
        nLore.add("§bhttp://craftmania.cz/forums");
        nMeta.setLore(nLore);
        nedoslo.setItemMeta(nMeta);

        ItemStack zpet = new ItemStack(Material.WOOD_DOOR);
        ItemMeta zMeta = zpet.getItemMeta();
        zMeta.setDisplayName("§cZpet na prehled serveru");
        zpet.setItemMeta(zMeta);

        inv.setItem(0, info);
        inv.setItem(11, t1);
        inv.setItem(15, t2);
        inv.setItem(8, nedoslo);
        inv.setItem(26, zpet);

        p.openInventory(inv);
    }

}
