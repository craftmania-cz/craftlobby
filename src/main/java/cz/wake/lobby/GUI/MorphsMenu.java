package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class MorphsMenu implements Listener {


    public void openMorphsMenu(Player p) {

        //undiguise do eventu na quit

        Inventory mpMenu = Bukkit.createInventory(null, 54, "Morphs");

        ItemStack villagerskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta vsMeta = (SkullMeta) villagerskull.getItemMeta();
        vsMeta.setOwner("MHF_Villager");
        vsMeta.setDisplayName(ChatColor.AQUA + "Villager");
        ArrayList<String> vsLore = new ArrayList<String>();
        vsLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "budes stastny Villager.");
        vsLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "budes nastvany Villager.");
        vsMeta.setLore(vsLore);
        villagerskull.setItemMeta(vsMeta);

        ItemStack pigskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta pMeta = (SkullMeta) pigskull.getItemMeta();
        pMeta.setOwner("MHF_Pig");
        pMeta.setDisplayName(ChatColor.AQUA + "Pig");
        ArrayList<String> pLore = new ArrayList<String>();
        pLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "hodis sunku.");
        pLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "zachrochtas.");
        pMeta.setLore(pLore);
        pigskull.setItemMeta(pMeta);

        ItemStack cowskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta cMeta = (SkullMeta) cowskull.getItemMeta();
        cMeta.setOwner("MHF_Cow");
        cMeta.setDisplayName(ChatColor.AQUA + "Cow");
        ArrayList<String> cLore = new ArrayList<String>();
        cLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "hodis mleko.");
        cLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "udelas MOOoooo.");
        cMeta.setLore(cLore);
        cowskull.setItemMeta(cMeta);

        ItemStack chickenskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta chickMeta = (SkullMeta) chickenskull.getItemMeta();
        chickMeta.setOwner("MHF_Chicken");
        chickMeta.setDisplayName(ChatColor.AQUA + "Chicken");
        ArrayList<String> chickLore = new ArrayList<String>();
        chickLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "hodis vejce.");
        chickLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "udelas chickchick.");
        chickMeta.setLore(chickLore);
        chickenskull.setItemMeta(chickMeta);

        ItemStack sheepskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta sheepMeta = (SkullMeta) sheepskull.getItemMeta();
        sheepMeta.setOwner("MHF_Sheep");
        sheepMeta.setDisplayName(ChatColor.AQUA + "Sheep");
        ArrayList<String> sheepLore = new ArrayList<String>();
        sheepLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "hodis vlnu.");
        sheepLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "udelas MeEeEeee");
        sheepMeta.setLore(sheepLore);
        sheepskull.setItemMeta(sheepMeta);

        ItemStack wolfskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta wolfMeta = (SkullMeta) wolfskull.getItemMeta();
        wolfMeta.setOwner("MHF_Wolf");
        wolfMeta.setDisplayName(ChatColor.AQUA + "Wolf");
        ArrayList<String> wolfLore = new ArrayList<String>();
        wolfLore.add(ChatColor.YELLOW + "Levym kliknutim " + ChatColor.GRAY + "hodis shnile maso.");
        wolfLore.add(ChatColor.YELLOW + "Pravym kliknutim " + ChatColor.GRAY + "udelas HafHaf");
        wolfMeta.setLore(wolfLore);
        wolfskull.setItemMeta(wolfMeta);

        ItemStack creeperskull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta creeperMeta = (SkullMeta) creeperskull.getItemMeta();
        creeperMeta.setOwner("MHF_Creeper");
        creeperMeta.setDisplayName(ChatColor.AQUA + "Creeper");
        ArrayList<String> creeperLore = new ArrayList<String>();
        creeperLore.add(ChatColor.YELLOW + "Drzenim shiftu " + ChatColor.GRAY + "explodujes.");
        creeperMeta.setLore(creeperLore);
        creeperskull.setItemMeta(creeperMeta);


        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
        zpet.setItemMeta(zpetMeta);

        ItemStack deaktivace = new ItemStack(Material.BARRIER);
        ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
        deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Deaktivovat ✖");
        ArrayList<String> deaktivaceLore = new ArrayList<String>();
        deaktivaceLore.add(ChatColor.GRAY + "Kliknutim vypnes aktualni premenu.");
        deaktivaceMeta.setLore(deaktivaceLore);
        deaktivace.setItemMeta(deaktivaceMeta);

        ItemStack shopItem = new ItemStack(Material.CHEST, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
        ArrayList<String> shopLore = new ArrayList<String>();
        shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby");
        shopLore.add(ChatColor.GRAY + "daji se ziskat z CraftBoxu nebo na");
        shopLore.add(ChatColor.GRAY + "specialnich eventech.");
        shopLore.add("");
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        mpMenu.setItem(49, shopItem);
        mpMenu.setItem(40, deaktivace);
        mpMenu.setItem(39, zpet);

        mpMenu.setItem(10, villagerskull);
        mpMenu.setItem(11, pigskull);
        mpMenu.setItem(12, chickenskull);
        mpMenu.setItem(13, cowskull);
        mpMenu.setItem(14, sheepskull);
        mpMenu.setItem(15, wolfskull);
        mpMenu.setItem(16, creeperskull);

        p.openInventory(mpMenu);

    }

}
