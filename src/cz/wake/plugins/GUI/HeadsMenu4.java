package cz.wake.plugins.GUI;

import cz.wake.plugins.Main;
import cz.wake.plugins.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HeadsMenu4 {

    public void openHeadsMenu4(Player p) {

        Inventory hm = Bukkit.createInventory(null, 54, "Heads (4 z 4 stran)");

        if (p.hasPermission("craftlobby.heads.stefanbabiak")) {
            ItemStack skull = ItemFactory.createHead("stefanbabiak", "2db50655-c1eb-4942-a813-acf968712fa9", "eyJ0aW1lc3RhbXAiOjE0NTk0NTI3OTY3NDIsInByb2ZpbGVJZCI6IjJkYjUwNjU1YzFlYjQ5NDJhODEzYWNmOTY4NzEyZmE5IiwicHJvZmlsZU5hbWUiOiJzdGVmYW5iYWJpYWsiLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRmNzhjOTc1ZWJiMjI2YzQwZjA3MmIyZWY0YmMyYmM3MGNiMWM2NGFiOTNiNTk3ZmVjYjNjNjU3OWQ0NzgyNSJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "stefanbabiak");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(0, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "stefanbabiak");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(0, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.shadycz")) {
            ItemStack skull = ItemFactory.createHead("ShadyCZ", "1d9042cf-6c30-4156-b3ac-cbfe4e45d23c", "eyJ0aW1lc3RhbXAiOjE0NTk1MTk2MDI5MDAsInByb2ZpbGVJZCI6IjFkOTA0MmNmNmMzMDQxNTZiM2FjY2JmZTRlNDVkMjNjIiwicHJvZmlsZU5hbWUiOiJTaGFkeUNaIiwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzJiOWY5YjMwMjFlMDVlZDhlYzZkMjVhYzdiNDM5ZDdhYzNlYTJiYjk3OWZkMWM1NWFkNGUxNjM4MWIxNmRlIn19fQ==");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "ShadyCZ");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add(ChatColor.GRAY + "Ziskano z CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(1, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "ShadyCZ");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(1, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.snowman")) {
            ItemStack skull = ItemFactory.createHead("Snowman", "cac3fe21-e50a-413e-a3b4-fda3fd396034", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThlMzM0ZTRiZWUwNDI2NDc1OWE3NjZiYzE5NTVjZmFmM2Y1NjIwMTQyOGZhZmVjOGQ0YmYxYmIzNmFlNiJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Snowman");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(2, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Snowman");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(2, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.snowglobe")) {
            ItemStack skull = ItemFactory.createHead("Snowglobe", "be6b6cbc-223a-4c98-b205-b00b7c545579", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRkNjYzMTM2Y2FmYTExODA2ZmRiY2E2YjU5NmFmZDg1MTY2YjRlYzAyMTQyYzhkNWFjODk0MWQ4OWFiNyJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Snowglobe");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(3, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Snowglobe");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(3, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.present1")) {
            ItemStack skull = ItemFactory.createHead("BluePresent", "9e7cfed7-6eab-419e-ade9-dcdd59c3949d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyZTk0NTFjZGIxOTZiNzgxOTVhOGYwYTRiOWMxYzBhMDRmNTgyNzg4NzkyN2I2YTgyYWFkMzljYWIyZjQzMCJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "BluePresent");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(4, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "BluePresent");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(4, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.present2")) {
            ItemStack skull = ItemFactory.createHead("GoldPresent", "d8b36e98-b8ee-4cdc-ac57-f4ef5a6e74b1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0Y2RlMTZhNDAxNGRlMGE3NjUxZjYwNjdmMTI2OTViYjVmZWQ2ZmVhZWMxZTk0MTNjYTQyNzFlN2M4MTkifX19");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "GoldPresent");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(5, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "GoldPresent");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(5, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.present3")) {
            ItemStack skull = ItemFactory.createHead("GreenPresent", "4fabccc8-0092-49b6-b010-689e521857a0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDA4Y2U3ZGViYTU2YjcyNmE4MzJiNjExMTVjYTE2MzM2MTM1OWMzMDQzNGY3ZDVlM2MzZmFhNmZlNDA1MiJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "GreenPresent");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(6, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "GreenPresent");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(6, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.present4")) {
            ItemStack skull = ItemFactory.createHead("RedPresent", "dca29a3a-76d3-4979-88a2-2da034b99212", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNlZjlhYTE0ZTg4NDc3M2VhYzEzNGE0ZWU4OTcyMDYzZjQ2NmRlNjc4MzYzY2Y3YjFhMjFhODViNyJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "RedPresent");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(7, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "RedPresent");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(7, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.santa")) {
            ItemStack skull = ItemFactory.createHead("Santa", "f4b89f66-750d-4ffb-8002-90a097de4b9b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGExNTkyMzZkNzUxMmJkYjQzMjZhMjRlMTQ1MDIxNjdiNzZiY2Q4NWMwNDE5MzFjMjE5NDIwMWIxN2Y1ZTcifX19");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Santa");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(8, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Santa");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(8, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.santa2")) {
            ItemStack skull = ItemFactory.createHead("Santa", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Santa");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(9, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Santa");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(9, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.elf")) {
            ItemStack skull = ItemFactory.createHead("Elf", "203a3caa-9053-468d-9b82-a5e143e54c74", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3YmU0N2JlNmY0YjI2YjA3OWM3NzU4YjY2Y2E4ODhiOWMzNGVhZWQ3MmU2ZTU4YjEzZDg3ZmZkYTBiMyJ9fX0=");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Elf");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(10, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Elf");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(10, noPerm);
        }
        if (p.hasPermission("craftlobby.heads.elf2")) {
            ItemStack skull = ItemFactory.createHead("Elf", "f879b9f5-ec53-472b-8626-a0b98b6bd153", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmM2ZTc5ZDE3MTc5MDJmNzFkYzU1M2M1MzczZmYyZTE3YmFlNjE5YjM5ZjhkZGJkZDIzMzgzZGQ1NWIzOTYifX19");
            ItemMeta sMeta = skull.getItemMeta();
            sMeta.setDisplayName(ChatColor.GREEN + "Elf #2");
            ArrayList<String> sLore = new ArrayList<String>();
            sLore.add("");
            sLore.add(ChatColor.GRAY + "Ziskano z §cVanocniho CraftBoxu.");
            sMeta.setLore(sLore);
            skull.setItemMeta(sMeta);
            hm.setItem(11, skull);
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Elf #2");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Vybranou headku lze ziskat ve §eVanocnim CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            hm.setItem(11, noPerm);
        }

        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet do Gadgets menu");
        zpet.setItemMeta(zpetMeta);

        ItemStack dalsi = new ItemStack(Material.ARROW);
        ItemMeta dalsiMeta = dalsi.getItemMeta();
        dalsiMeta.setDisplayName(ChatColor.RED + "Dalsi stranka");
        dalsi.setItemMeta(dalsiMeta);

        ItemStack deaktivace = new ItemStack(Material.BARRIER);
        ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
        deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Sundat headku z hlavy ✖");
        ArrayList<String> deaktivaceLore = new ArrayList<String>();
        deaktivaceLore.add(ChatColor.GRAY + "Kliknutim sundas nasazenou headku.");
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

        hm.setItem(49, shopItem);
        hm.setItem(40, deaktivace);
        hm.setItem(39, zpet);

        p.openInventory(hm);
    }

}
