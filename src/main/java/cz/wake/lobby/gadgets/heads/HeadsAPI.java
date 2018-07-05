package cz.wake.lobby.gadgets.heads;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HeadsAPI implements Listener {

    MessagesListener ms = new MessagesListener();

    public void openMainHeadsMenu(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 36, "Heads");

        ItemStack basicHeads = ItemFactory.createHead("§c§lZakladni headky", "c659cdd4-e436-4977-a6a7-d5518ebecfbb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19");
        ItemMeta bhMeta = basicHeads.getItemMeta();
        ArrayList<String> bhLore = new ArrayList();
        bhLore.add("");
        bhLore.add("§7Seznam zakladnich headek.");
        bhLore.add("");
        bhLore.add(counHeadsString(p));
        bhLore.add("§ePro zobrazeni klikni!");
        bhMeta.setLore(bhLore);
        basicHeads.setItemMeta(bhMeta);

        ItemStack winterHeads = ItemFactory.createHead("§c§lVanocni headky", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
        ItemMeta bh2Meta = winterHeads.getItemMeta();
        ArrayList<String> bh2Lore = new ArrayList();
        bh2Lore.add("");
        bh2Lore.add("§7Seznam zakladnich headek.");
        bh2Lore.add("");
        bh2Lore.add(counChristmasHeadsString(p));
        bh2Lore.add("§ePro zobrazeni klikni!");
        bh2Meta.setLore(bh2Lore);
        winterHeads.setItemMeta(bh2Meta);

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet");

        inv.setItem(11, basicHeads);
        inv.setItem(15, winterHeads);
        inv.setItem(31, zpet);

        p.openInventory(inv);
    }

    private void openHeads(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "Basic Heads (1 z 2)");

        if (p.hasPermission("craftlobby.heads.strawberryjam")) {
            inv.setItem(0, createHead("Strawberry Jam", "adc3ea73-5b42-4fea-a237-4a72b52dd72b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ=="));
        } else {
            inv.setItem(0, noPerm("Strawberry Jam"));
        }
        if (p.hasPermission("craftlobby.heads.chocolate")) {
            inv.setItem(1, createHead("Chocolate", "eaa47b1d-cb57-48c8-af33-cf4fd9872341", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE5Zjk0OGQxNzcxOGFkYWNlNWRkNmUwNTBjNTg2MjI5NjUzZmVmNjQ1ZDcxMTNhYjk0ZDE3YjYzOWNjNDY2In19fQ=="));
        } else {
            inv.setItem(1, noPerm("Chocolate"));
        }
        if (p.hasPermission("craftlobby.heads.whitechocolate")) {
            inv.setItem(2, createHead("White Chocolate", "91f8d9e9-0514-4319-902f-f2662f4df272", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWVkNTUyNjBkY2NjOGRhNTkzMzhjNzVlNDFkNTQ0YTJlMWU3ZGJlZjMxYTY5ZmU0MmMwMWIzMjk4YmYyZCJ9fX0="));
        } else {
            inv.setItem(2, noPerm("White Chocolate"));
        }
        if (p.hasPermission("craftlobby.heads.hamburger")) {
            inv.setItem(3, createHead("Hamburger", "d1375075-c727-40ad-bcce-7e4277099e30", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19"));
        } else {
            inv.setItem(3, noPerm("Hamburger"));
        }
        if (p.hasPermission("craftlobby.heads.lemon")) {
            inv.setItem(4, createHead("Lemon", "09d10b7a-f525-412c-bedf-b2fe7c8bfc70", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3ZmQ1NmNhMTU5Nzg3NzkzMjRkZjUxOTM1NGI2NjM5YThkOWJjMTE5MmM3YzNkZTkyNWEzMjliYWVmNmMifX19"));
        } else {
            inv.setItem(4, noPerm("Lemon"));
        }
        if (p.hasPermission("craftlobby.heads.donut")) {
            inv.setItem(5, createHead("Donut", "b48503a4-6dec-438c-a3bc-6b5da7fb1fde", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM3YzliODJiMTg2NjU2ZTlmNjM2M2EyYTFjNmE0YjViOTNjZmE5ZWY0ZGFkNmYxNmI5NGViYjVlMzYyNjc4In19fQ=="));
        } else {
            inv.setItem(5, noPerm("Donut"));
        }
        if (p.hasPermission("craftlobby.heads.computer")) {
            inv.setItem(6, createHead("Computer", "81c080fd-022b-477c-9f24-f637324d4c4c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlNTJhZThjOThhYzE5ZmQwNzYzN2E0NjlmZmEyNTZhYjBiM2IxMGVjZTYyNDMxODYxODhiYTM4ZGYxNTQifX19"));
        } else {
            inv.setItem(6, noPerm("Computer"));
        }
        if (p.hasPermission("craftlobby.heads.monitor")) {
            inv.setItem(7, createHead("Monitor", "5a929f7f-1a74-4d25-860d-40ff532acfbe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2ZjcyYzE2YjFlOWZlNmUwOTllNzZiNWY3YTg4NGZiNzgyY2ZjYzU4OGM5NWM0ZTM4M2RjNTI3ZDFiODQifX19"));
        } else {
            inv.setItem(7, noPerm("Monitor"));
        }
        if (p.hasPermission("craftlobby.heads.policesiren")) {
            inv.setItem(8, createHead("Police Siren", "e8297346-5aca-4ae8-b2a3-e341b6d0921f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWFmYTU4NjMxNjA5NzkxZmZlMjVmM2E4NzlkZmJmZmVhMTE1MWY4N2JmZjYyYzU0MjNlZDYxMzZlZTAifX19"));
        } else {
            inv.setItem(8, noPerm("Police Siren"));
        }
        if (p.hasPermission("craftlobby.heads.texture")) {
            inv.setItem(9, createHead("MissingTexture", "5d43c6dd-ca01-466c-9614-764449140917", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19"));
        } else {
            inv.setItem(9, noPerm("MissingTexture"));
        }
        if (p.hasPermission("craftlobby.heads.spacehelmet")) {
            inv.setItem(10, createHead("Space Helmet", "822833e6-c3ec-457e-aeef-1fac97799e5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAyZTIyZjY1MDNjMzYzZGY2OWJmOWU5NDQ4ZmU4OWQyZjA1YmFlMzA1MzRiOGJiMTlkMjY4ZjA5ODliOTYifX19"));
        } else {
            inv.setItem(10, noPerm("Space Helmet"));
        }
        if (p.hasPermission("craftlobby.heads.youtube")) {
            inv.setItem(11, createHead("YouTube", "4ec6d571-4553-4a75-a4ae-6e104bcc76f0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0="));
        } else {
            inv.setItem(11, noPerm("YouTube"));
        }
        if (p.hasPermission("craftlobby.heads.mailbox")) {
            inv.setItem(12, createHead("Mailbox", "4113ced7-576b-4c03-8a92-0937d5966ea1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFjYmJjYTU2NzM3MmE5YjJiMzZjOGY2ODE1NDg1MWJkYTVlZTFkNTNlMmJjMjA4YTExNTJkOWExOGQyY2IifX19"));
        } else {
            inv.setItem(12, noPerm("Mailbox"));
        }
        if (p.hasPermission("craftlobby.heads.scared")) {
            inv.setItem(13, createHead("Scared", "2cd3dbb5-6136-4127-9e14-89c328660871", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM2ZTI2YzQ0NjU5ZTgxNDhlZDU4YWE3OWU0ZDYwZGI1OTVmNDI2NDQyMTE2ZjgxYjU0MTVjMjQ0NmVkOCJ9fX0="));
        } else {
            inv.setItem(13, noPerm("Scared"));
        }
        if (p.hasPermission("craftlobby.heads.embarrased")) {
            inv.setItem(14, createHead("Embarrased", "80e16b56-8d8c-4ea0-b3b2-dd69c7bd56cf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjcyMGRmOTExYzA1MjM3NzA2NTQwOGRiNzhhMjVjNjc4Zjc5MWViOTQ0YzA2MzkzNWFlODZkYmU1MWM3MWIifX19"));
        } else {
            inv.setItem(14, noPerm("Embarrased"));
        }
        if (p.hasPermission("craftlobby.heads.kissy")) {
            inv.setItem(15, createHead("Kissy", "c7360c40-1b10-4a11-8322-697962372596", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ1YmQxOGEyYWFmNDY5ZmFkNzJlNTJjZGU2Y2ZiMDJiZmJhYTViZmVkMmE4MTUxMjc3Zjc3OWViY2RjZWMxIn19fQ=="));
        } else {
            inv.setItem(15, noPerm("Kissy"));
        }
        if (p.hasPermission("craftlobby.heads.cool")) {
            inv.setItem(16, createHead("Cool", "bcefcc41-e997-4845-ae08-7b8a1a2d51b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19"));
        } else {
            inv.setItem(16, noPerm("Cool"));
        }
        if (p.hasPermission("craftlobby.heads.suprised")) {
            inv.setItem(17, createHead("Suprised", "1a61537c-52d6-429d-9314-8420d631b494", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMyYjliOWFlNjIyYmQ2OGFkZmY3MTgwZjgyMDZlYzQ0OTRhYmJmYTEzMGU5NGE1ODRlYzY5MmU4OTg0YWIyIn19fQ=="));
        } else {
            inv.setItem(17, noPerm("Suprised"));
        }
        if (p.hasPermission("craftlobby.heads.crying")) {
            inv.setItem(18, createHead("Crying", "b03562f3-2a20-4257-bb62-e040f552c297", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWYxYjg3NWRlNDljNTg3ZTNiNDAyM2NlMjRkNDcyZmYyNzU4M2ExZjA1NGYzN2U3M2ExMTU0YjViNTQ5OCJ9fX0="));
        } else {
            inv.setItem(18, noPerm("Crying"));
        }
        if (p.hasPermission("craftlobby.heads.grin")) {
            inv.setItem(19, createHead("Grin", "988770c2-3a2d-41c3-a753-b13fa383e823", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA1OWQ1OWViNGU1OWMzMWVlY2Y5ZWNlMmY5Y2YzOTM0ZTQ1YzBlYzQ3NmZjODZiZmFlZjhlYTkxM2VhNzEwIn19fQ=="));
        } else {
            inv.setItem(19, noPerm("Grin"));
        }
        if (p.hasPermission("craftlobby.heads.derp")) {
            inv.setItem(20, createHead("Derp", "58c6ac60-cbce-4ecb-981b-e79a87ad2bb6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JhYWJlNzI0ZWFlNTljNWQxM2Y0NDJjN2RjNWQyYjFjNmI3MGMyZjgzMzY0YTQ4OGNlNTk3M2FlODBiNGMzIn19fQ=="));
        } else {
            inv.setItem(20, noPerm("Derp"));
        }
        if (p.hasPermission("craftlobby.heads.mustache")) {
            inv.setItem(21, createHead("Mustache", "0d7d6e4d-fb18-491b-a7b6-dbf45d923811", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYzNmYyNzI0YWE2YWE0ZGU3YWM0NmMxOWYzYzg0NWZiMTQ4NDdhNTE4YzhmN2UwM2Q3OTJjODJlZmZiMSJ9fX0="));
        } else {
            inv.setItem(21, noPerm("Mustache"));
        }
        if (p.hasPermission("craftlobby.heads.smile")) {
            inv.setItem(22, createHead("Smile", "0beedb99-f64e-4a26-93f3-8f3af84050aa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZmYWNjZjE3ODc5YjE3ODkxZmM1ZWY2NjQ3MmNjMDY2YTg1YmZhMzFiNmQ3ODZjMzJhZmVlNDc5NjA2OGQifX19"));
        } else {
            inv.setItem(22, noPerm("Smile"));
        }
        if (p.hasPermission("craftlobby.heads.dead")) {
            inv.setItem(23, createHead("Dead", "275a74fe-e3e4-4aff-86a2-68e3fb9720d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ=="));
        } else {
            inv.setItem(23, noPerm("Dead"));
        }
        if (p.hasPermission("craftlobby.heads.skull")) {
            inv.setItem(24, createHead("Skull", "c659cdd4-e436-4977-a6a7-d5518ebecfbb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19"));
        } else {
            inv.setItem(24, noPerm("Skull"));
        }
        if (p.hasPermission("craftlobby.heads.evilbunny")) {
            inv.setItem(25, createHead("EvilBunny", "e4f254ad-1413-4853-8736-10c7aa53fbaf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q0ZmRhZDVhNjEwNGFhNTQ5ZDFlNzZkNzNhM2M2ZmUzYzY3MjRiZjA5ZjdmZmNjMDJmMzNmOWVkZTdmYWRlIn19fQ=="));
        } else {
            inv.setItem(25, noPerm("EvilBunny"));
        }
        if (p.hasPermission("craftlobby.heads.scaryclown")) {
            inv.setItem(26, createHead("ScaryClown", "d1956517-9a4d-421d-8647-2d940dc64518", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZkYmMxZGViYzU3NDM4YTVkZTRiYTkxNTE1MTM4MmFiYzNkOGYxMzE4ZTJhMzVlNzhkZmIzMGYwNGJjNDY3In19fQ=="));
        } else {
            inv.setItem(26, noPerm("ScaryClown"));
        }
        if (p.hasPermission("craftlobby.heads.frankensteinsmonster")) {
            inv.setItem(27, createHead("FrankensteinsMonster", "aec7b0b6-7bf8-46a6-b873-feb3d6277af8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjYmUwNjFiNDQ1Yjg4Y2IyZGY1OWFjY2M4ZDJjMWMxMjExOGZlMGIyMTI3ZTZlNzU4MTM1NTBhZGFjNjdjZiJ9fX0="));
        } else {
            inv.setItem(27, noPerm("FrankensteinsMonster"));
        }
        if (p.hasPermission("craftlobby.heads.elephant")) {
            inv.setItem(28, createHead("Elephant", "9a58e25a-cf47-447d-b13c-3ea36eccfa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA3MWE3NmY2NjlkYjVlZDZkMzJiNDhiYjJkYmE1NWQ1MzE3ZDdmNDUyMjVjYjMyNjdlYzQzNWNmYTUxNCJ9fX0="));
        } else {
            inv.setItem(28, noPerm("Elephant"));
        }
        if (p.hasPermission("craftlobby.heads.werewolf")) {
            inv.setItem(29, createHead("WereWolf", "fdc7eb2a-0bec-408d-8f16-f8494d3960d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFjOTkzNGNkZDU1YTllNjMzNTk2MmE4Nzc2MjYwZDc5MTYxNTA4MTM0ODNlOTU2YzI4NjFiMTFhOGEyNjdmNyJ9fX0="));
        } else {
            inv.setItem(29, noPerm("WereWolf"));
        }
        if (p.hasPermission("craftlobby.heads.guardian")) {
            inv.setItem(30, createHead("Guardian", "2e9c0a67-92b3-4949-9be1-faf12318ee88", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ=="));
        } else {
            inv.setItem(30, noPerm("Guardian"));
        }
        if (p.hasPermission("craftlobby.heads.walrus")) {
            inv.setItem(31, createHead("Walrus", "a185ff1a-f32e-47e0-be61-5a612f130f33", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ=="));
        } else {
            inv.setItem(31, noPerm("Walrus"));
        }
        if (p.hasPermission("craftlobby.heads.batman")) {
            inv.setItem(32, createHead("Batman", "af20c020-6810-4abe-8437-97d3bff52bec", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ=="));
        } else {
            inv.setItem(32, noPerm("Batman"));
        }
        if (p.hasPermission("craftlobby.heads.ghost")) {
            inv.setItem(33, createHead("Ghost", "31152fb2-cb1e-45c3-86dd-b23f7a20a6f8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkMjE4MzY0MDIxOGFiMzMwYWM1NmQyYWFiN2UyOWE5NzkwYTU0NWY2OTE2MTllMzg1NzhlYTRhNjlhZTBiNiJ9fX0="));
        } else {
            inv.setItem(33, noPerm("Ghost"));
        }
        if (p.hasPermission("craftlobby.heads.skeletonminer")) {
            inv.setItem(34, createHead("SkeletonMiner", "fc0cbbe8-e2e2-4118-99a4-e4f811e75511", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM3ZjhmOTVjMTI1NzU3Y2JmNzY3YTExZjUyYTRlNjY5MWNlMThhMjU5NzhjNjhjZmEzOTEwMzYwZmUifX19"));
        } else {
            inv.setItem(34, noPerm("SkeletonMiner"));
        }
        if (p.hasPermission("craftlobby.heads.devil")) {
            inv.setItem(35, createHead("Devil", "c3c88c33-f305-4c10-9303-ce658b2fbde7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRhMzkyNjllZjQ1ZjgyNWVjNjFiYjRmOGFhMDliZDNjZjA3OTk2ZmI2ZmFjMzM4YTZlOTFkNjY5OWFlNDI1In19fQ=="));
        } else {
            inv.setItem(35, noPerm("Devil"));
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
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getSQL().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        inv.setItem(49, shopItem);
        inv.setItem(40, deaktivace);
        inv.setItem(41, dalsi);
        inv.setItem(39, zpet);

        p.openInventory(inv);
    }

    private void openHeads2(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "Basic Heads (2 z 2)");

        if (p.hasPermission("craftlobby.heads.helloweenpumpkin")) {
            inv.setItem(0, createHead("HelloweenPumpkin", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ=="));
        } else {
            inv.setItem(0, noPerm("HelloweenPumpkin"));
        }
        if (p.hasPermission("craftlobby.heads.mummy")) {
            inv.setItem(1, createHead("Mummy", "8f7c0c5b-720f-4944-8481-b0f7931f303f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U5MWU5NTgyMmZlOThjYzVhNTY1OGU4MjRiMWI4Y2YxNGQ0ZGU5MmYwZTFhZjI0ODE1MzcyNDM1YzllYWI2In19fQ=="));
        } else {
            inv.setItem(1, noPerm("Mummy"));
        }
        if (p.hasPermission("craftlobby.heads.herobrine")) {
            inv.setItem(2, createHead("Herobrine", "d0b15454-36fa-43e4-a247-f882bb9fe288", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThiN2NhM2M3ZDMxNGE2MWFiZWQ4ZmMxOGQ3OTdmYzMwYjZlZmM4NDQ1NDI1YzRlMjUwOTk3ZTUyZTZjYiJ9fX0="));
        } else {
            inv.setItem(2, noPerm("Herobrine"));
        }
        if (p.hasPermission("craftlobby.heads.a")) {
            inv.setItem(3, createHead("A", "d9e6ae1b-8e1d-4ae7-8f5b-b581b1771d40", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MGRhMjk0NGExNzdkZDA4MjY4ZmJlYzA0ZTQwODEyZDFkOTI5NjUwYmU2NjUyOWIxZWU1ZTFlN2VjYSJ9fX0="));
        } else {
            inv.setItem(3, noPerm("A"));
        }
        if (p.hasPermission("craftlobby.heads.b")) {
            inv.setItem(4, createHead("B", "a389402c-129b-4de2-8877-7912a1afe881", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA0MWY1ZTg2OTgzZDM2ZWFlYzRlMTY3YjJiYmI1YTM3Mjc2MDdjZGU4OGY3NTU1Y2ExYjUyMmEwMzliYiJ9fX0="));
        } else {
            inv.setItem(4, noPerm("B"));
        }
        if (p.hasPermission("craftlobby.heads.c")) {
            inv.setItem(5, createHead("C", "5aafc18c-4341-4d65-bbfe-062706ffb067", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDk0NTk5NmM4YWU5MWUzNzYxOTZkNGRjNjc2ZmVjMzFmZWFjNzkwYTJmMTk1YjI5ODFhNzAzY2ExZDE2Y2I2In19fQ=="));
        } else {
            inv.setItem(5, noPerm("C"));
        }
        if (p.hasPermission("craftlobby.heads.d")) {
            inv.setItem(6, createHead("D", "2bb28566-da08-4b69-963f-da9561f1d0a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY0MTE1MGY0ODFlODQ5MmY3MTI4Yzk0ODk5NjI1NGQyZDkxZmM5MGY1YThmZjRkOGFjNWMzOWE2YTg4YSJ9fX0="));
        } else {
            inv.setItem(6, noPerm("D"));
        }
        if (p.hasPermission("craftlobby.heads.e")) {
            inv.setItem(7, createHead("E", "72c35d01-c507-4efc-9184-63c32cdf4687", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGIyNTE0ODdmZjhlZWYyZWJjN2E1N2RhYjZlM2Q5ZjFkYjdmYzkyNmRkYzY2ZmVhMTRhZmUzZGZmMTVhNDUifX19"));
        } else {
            inv.setItem(7, noPerm("E"));
        }
        if (p.hasPermission("craftlobby.heads.f")) {
            inv.setItem(8, createHead("F", "b46b2241-5546-48db-a457-a2dbad23db27", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U0MzM2NTZiNDQzNjY4ZWQwM2RhYzhjNDQyNzIyYTJhNDEyMjFiZThiYjQ4ZTIzYjM1YmQ4YzJlNTlmNjMifX19"));
        } else {
            inv.setItem(8, noPerm("F"));
        }
        if (p.hasPermission("craftlobby.heads.g")) {
            inv.setItem(9, createHead("G", "4b0845df-5f9a-47ab-8ab7-044f810017fd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk1ODYzYjczNjM3NjA1ZmVhY2JiMTczYjc3ZDVlMTU1ZTY1MjA0Yzc4ZDVjNzkxMWY3MzhmMjhkZWI2MCJ9fX0="));
        } else {
            inv.setItem(9, noPerm("G"));
        }
        if (p.hasPermission("craftlobby.heads.h")) {
            inv.setItem(10, createHead("H", "ea507bde-e39a-4e8c-b6a7-35fffed066c6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2MxZDM1OGQ5MjcwNzQyODljYzI2YmZmNWIxMjQwNzQ2ZjlmNGYwY2M0NmY5NDJmNTk4MWM2NTk1ZjcyZGQifX19"));
        } else {
            inv.setItem(10, noPerm("H"));
        }
        if (p.hasPermission("craftlobby.heads.i")) {
            inv.setItem(11, createHead("I", "84143d3c-f198-461d-aecc-40741d5494fe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYyMjk1ODY1YmRhNGU0Nzk3OWQzNmI4YTg4N2E3NWExM2IwMzRlNjk4OGY3ODY3MGI2NGExZTY0NDJjIn19fQ=="));
        } else {
            inv.setItem(11, noPerm("I"));
        }
        if (p.hasPermission("craftlobby.heads.j")) {
            inv.setItem(12, createHead("J", "3814608a-d3e2-49ce-9ebf-fe4c25efd882", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NDYyYjU1ZDdmNTgyMzY4MGFkMTNmMmFkYmQ3ZDFlZDQ2YmE1MTAxMDE3ZWQ0YjM3YWVlZWI3NzVkIn19fQ=="));
        } else {
            inv.setItem(12, noPerm("J"));
        }
        if (p.hasPermission("craftlobby.heads.k")) {
            inv.setItem(13, createHead("K", "519c18a7-f30d-4f03-8975-9655f2360347", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzczMzI1YTkzNWMwNjdiNmVmMjI3MzY3ZjYyY2E0YmY0OWY2N2FkYjlmNmRhMzIwOTFlMmQzMmM1ZGRlMzI4In19fQ=="));
        } else {
            inv.setItem(13, noPerm("K"));
        }
        if (p.hasPermission("craftlobby.heads.l")) {
            inv.setItem(14, createHead("L", "c5d1650f-c193-4f67-be23-7eae09a66e1c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVhMWUzMzI4YzU3MWFhNDk1ZDljNWY0OTQ4MTVjY2ExNzZjM2FjYjE4NGZlYjVhN2I5Yzk2Y2U4ZTUyZmNlIn19fQ=="));
        } else {
            inv.setItem(14, noPerm("L"));
        }
        if (p.hasPermission("craftlobby.heads.m")) {
            inv.setItem(15, createHead("M", "d6a7ebad-3f25-4d4c-9bf0-36b069dc38ca", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ2N2JmNmJlOTVlNWM4ZTlkMDE5NzdhMmYwYzQ4N2VkNWIwZGU1Yzg3OTYzYTJlYjE1NDExYzQ0MmZiMmIifX19"));
        } else {
            inv.setItem(15, noPerm("M"));
        }
        if (p.hasPermission("craftlobby.heads.n")) {
            inv.setItem(16, createHead("N", "d621ae4e-f103-4b78-a180-c756b76b45b4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIzZTQzNGQ2Mzk1ZmU3ZTYzNDkyNDMxYmRlZTU3ODJiZDVlZTViYzhjYWI3NTU5NDY3YmRkMWY5M2I5MjVhIn19fQ=="));
        } else {
            inv.setItem(16, noPerm("N"));
        }
        if (p.hasPermission("craftlobby.heads.o")) {
            inv.setItem(17, createHead("O", "425da042-932b-483d-9252-b7783871b66e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0NDU0NjZiZGM1YWQ1YmNlYTgyMjM5YzRlMWI1MTBmNmVhNTI2MmQ4MmQ4YTk2ZDcyOTFjMzQyZmI4OSJ9fX0="));
        } else {
            inv.setItem(17, noPerm("O"));
        }
        if (p.hasPermission("craftlobby.heads.p")) {
            inv.setItem(18, createHead("P", "ebfde078-cc98-48f1-ac64-608c8545cc28", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkZTYwMWRlZTNmZmVjYTRkNTQ1OTVmODQ0MjAxZDBlZDIwOTFhY2VjNDU0OGM2OTZiYjE2YThhMTU4ZjYifX19"));
        } else {
            inv.setItem(18, noPerm("P"));
        }
        if (p.hasPermission("craftlobby.heads.q")) {
            inv.setItem(19, createHead("Q", "5f94a01f-2bf4-497b-90fb-188e38055ca9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjZjYTc2OWJkZTI1ZDRjYzQxZTE5ZTQyYWRjMzVhYjRjMTU1N2I3NmFmMjMyNjQ5YWNjOTk2N2ZmMTk4ZjEzIn19fQ=="));
        } else {
            inv.setItem(19, noPerm("Q"));
        }
        if (p.hasPermission("craftlobby.heads.r")) {
            inv.setItem(20, createHead("R", "ff745ee1-3463-473e-9e5d-db5b3f9e56a1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdhMTg4ODA1MTYyY2E1ZGQ0ZjQ2NDljNjYxZDNmNmQyM2M0MjY2MmFlZjAxNjQ1YjFhOTdmNzhiM2YxMzIxOSJ9fX0="));
        } else {
            inv.setItem(20, noPerm("R"));
        }
        if (p.hasPermission("craftlobby.heads.s")) {
            inv.setItem(21, createHead("S", "7fdd4eda-abdb-4019-aa25-9c23b69f0012", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkMDlkZmQ5ZjVkZTYyNDMyMzNlMGUzMzI1YjZjMzQ3OTMzNWU3Y2NmMTNmMjQ0OGQ0ZTFmN2ZjNGEwZGYifX19"));
        } else {
            inv.setItem(21, noPerm("S"));
        }
        if (p.hasPermission("craftlobby.heads.t")) {
            inv.setItem(22, createHead("T", "28408552-4d4a-4830-a90e-8d2d98f84dcc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRjNzU2MTliOTFkMjQxZjY3ODM1MGFkOTIzN2MxMzRjNWUwOGQ4N2Q2ODYwNzQxZWRlMzA2YTRlZjkxIn19fQ=="));
        } else {
            inv.setItem(22, noPerm("T"));
        }
        if (p.hasPermission("craftlobby.heads.u")) {
            inv.setItem(23, createHead("U", "0b7ee6c6-f3ae-43a2-b19b-0c9df57a752d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTlmNmQyYzZkNTI4NWY4ODJhZTU1ZDFlOTFiOGY5ZWZkZmM5YjM3NzIwOGJmNGM4M2Y4OGRkMTU2NDE1ZSJ9fX0="));
        } else {
            inv.setItem(23, noPerm("U"));
        }
        if (p.hasPermission("craftlobby.heads.v")) {
            inv.setItem(24, createHead("V", "4a7d6a90-977e-4708-976b-c52d27ecaa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNlMjdhMTUzNjM1ZjgzNTIzN2Q4NWM2YmY3NGY1YjFmMmU2MzhjNDhmZWU4YzgzMDM4ZDA1NThkNDFkYTcifX19"));
        } else {
            inv.setItem(24, noPerm("V"));
        }
        if (p.hasPermission("craftlobby.heads.w")) {
            inv.setItem(25, createHead("W", "eacab58c-56fb-46d9-97f6-c1c2cab2cf9e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVkY2Y0ZmZjYjUzYjU2ZDQyYmFhYzlkMGRmYjExOGUzNDM0NjIzMjc0NDJkZDliMjlkNDlmNTBhN2QzOGIifX19"));
        } else {
            inv.setItem(25, noPerm("W"));
        }
        if (p.hasPermission("craftlobby.heads.x")) {
            inv.setItem(26, createHead("X", "1f5d7b63-569e-4d96-b7fb-ef437ef39850", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM2MThmZjEyMTc2NDBiZWM1YjUyNWZhMmE4ZTY3MWM3NWQyYTdkN2NiMmRkYzMxZDc5ZDlkODk1ZWFiMSJ9fX0="));
        } else {
            inv.setItem(26, noPerm("X"));
        }
        if (p.hasPermission("craftlobby.heads.y")) {
            inv.setItem(27, createHead("Y", "fd3e1792-dd5e-497a-b2af-c24a22ca75e0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDljMWQyOWEzOGJjZjExM2I3ZThjMzRlMTQ4YTc5ZjlmZTQxZWRmNDFhYThiMWRlODczYmIxZDQzM2IzODYxIn19fQ=="));
        } else {
            inv.setItem(27, noPerm("Y"));
        }
        if (p.hasPermission("craftlobby.heads.z")) {
            inv.setItem(28, createHead("Z", "34b483d5-b7b7-4a33-b8c1-bb725969bd4a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjkyOTU3MzQxOTVkMmM3ZmEzODliOTg3NTdlOTY4NmNlNjQzN2MxNmM1OGJkZjJiNGNkNTM4Mzg5YjU5MTIifX19"));
        } else {
            inv.setItem(28, noPerm("Z"));
        }
        if (p.hasPermission("craftlobby.heads.mrwakecz")) {
            inv.setItem(29, createHead("MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0="));
        } else {
            inv.setItem(29, noPerm("MrWakeCZ"));
        }

        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet na predchozi stranku");
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
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getSQL().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        inv.setItem(49, shopItem);
        inv.setItem(40, deaktivace);
        //inv.setItem(41, dalsi);
        inv.setItem(39, zpet);

        p.openInventory(inv);
    }

    private void openChristmasHeads(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "Vanocni Heads (1 z 1)");

        if (p.hasPermission("craftlobby.heads.vanocni.santa")) {
            inv.setItem(0, createHead("Santa", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0="));
        } else {
            inv.setItem(0, noPermW("Santa"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.piratesanta")) {
            inv.setItem(1, createHead("PirateSanta", "0eac3133-65c6-44a4-44ee-db7dfd74208d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzc5NTMzNGVmZDkyYWFmMzhkZjk2ZTg2YTYzNjFmYTc3NmUwNTJhOTBlNjIyYTUyZWQ5ZjMxZDY3OWU1OTUifX19"));
        } else {
            inv.setItem(1, noPermW("PirateSanta"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.commandblock")) {
            inv.setItem(2, createHead("CommandBlock", "5bbf064c-4cd7-4e37-b7f3-44f53b588f53", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjBlZDg3NmFiYzRhZWIyMThkYzUxZTZlY2E0NGNjZjUxY2YwYmQ2NmM2ZDc1Y2JiYjBkYjlhZDNkNmYwOTMifX19"));
        } else {
            inv.setItem(2, noPermW("CommandBlock"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.elfboy")) {
            inv.setItem(3, createHead("ElfBoy", "367ea5a0-cf6f-4993-9c7e-9f3466bf30ef", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmNlNjg1YmVhOGY2ZDk2NmU1MzNlMmFmNWJhYTU1NzdlMWE5OGY2Y2FkMTFiOGYwZjdmMjAxYmJlZjZlODIyIn19fQ=="));
        } else {
            inv.setItem(3, noPermW("ElfBoy"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.elfgirl")) {
            inv.setItem(4, createHead("ElfGirl", "e13aa36e-7804-4f00-a9c0-668f24ffb0a7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTg5YTRjMWE3YzgxZjM3NjVmNWE1ZTJjOTJlNGQ0OGVkOTczMGRhYzE4NzhkZmY0MWExOTFkNzhhMTY5ZDg5In19fQ=="));
        } else {
            inv.setItem(4, noPermW("ElfGirl"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.sob")) {
            inv.setItem(5, createHead("Sob", "5ddb61e0-4e65-4097-8026-489261d7d278", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQ5MjdjZTViYTIyYWQxZTc1N2Q2YTMzM2UyNzViMzZkYTFhODQzNmZjZWYwNzczNDBhYjUzZTNmYiJ9fX0="));
        } else {
            inv.setItem(5, noPermW("Sob"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowman")) {
            inv.setItem(6, createHead("Snowman", "2d141b1e-86d1-48e9-964c-5d9db8655e04", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThlMzM0ZTRiZWUwNDI2NDc1OWE3NjZiYzE5NTVjZmFmM2Y1NjIwMTQyOGZhZmVjOGQ0YmYxYmIzNmFlNiJ9fX0="));
        } else {
            inv.setItem(6, noPermW("Snowman"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowglobe")) {
            inv.setItem(7, createHead("Snowglobe", "be6b6cbc-223a-4c98-b205-b00b7c545579", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRkNjYzMTM2Y2FmYTExODA2ZmRiY2E2YjU5NmFmZDg1MTY2YjRlYzAyMTQyYzhkNWFjODk0MWQ4OWFiNyJ9fX0="));
        } else {
            inv.setItem(7, noPermW("Snowglobe"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowglobe2")) {
            inv.setItem(8, createHead("Snowglobe2", "2a2b9900-73a3-44d9-957f-47ba7f54497b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2MTU2ZDdmMjEzMjY2OWMzNjdhYjg5NTIzYzJlMWI5ODY2ZTQwYjJiODkxMzkzNzQ0NjU3ZjFjMzU1In19fQ=="));
        } else {
            inv.setItem(8, noPermW("Snowglobe2"));
        }
        if (p.hasPermission("craftloby.heads.vanocni.blackpresent")) {
            inv.setItem(9, createHead("BlackPresent", "ee53f881-8b67-4604-bfb9-a43a6966eae2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM3MTJiMTk3MWM1ZjQyZWVmZjgwNTUxMTc5MjIwYzA4YjgyMTNlYWNiZTZiYzE5ZDIzOGMxM2Y4NmUyYzAifX19"));
        } else {
            inv.setItem(9, noPermW("BlackPresent"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.bluepresent")) {
            inv.setItem(10, createHead("BluePresent", "9e7cfed7-6eab-419e-ade9-dcdd59c3949d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyZTk0NTFjZGIxOTZiNzgxOTVhOGYwYTRiOWMxYzBhMDRmNTgyNzg4NzkyN2I2YTgyYWFkMzljYWIyZjQzMCJ9fX0="));
        } else {
            inv.setItem(10, noPermW("BluePresent"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.greenpresent")) {
            inv.setItem(11, createHead("GreenPresent", "434b9c7c-d287-4d61-b4c3-7be1da79b9e5", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTcxNWY1MzdmZTdhZjZmNWFhNmViOThhZDY5MDJjMTNkMDVmYjM2YzE2YjMxMWVkODMyYjA5YjU5ODgyOCJ9fX0="));
        } else {
            inv.setItem(11, noPermW("GreenPresent"));
        }
        if (p.hasPermission("craftlobby.heads.vanocni.goldpresent")) {
            inv.setItem(12, createHead("GoldPresent", "d8b36e98-b8ee-4cdc-ac57-f4ef5a6e74b1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0Y2RlMTZhNDAxNGRlMGE3NjUxZjYwNjdmMTI2OTViYjVmZWQ2ZmVhZWMxZTk0MTNjYTQyNzFlN2M4MTkifX19"));
        } else {
            inv.setItem(12, noPermW("GoldPresent"));
        }

        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet na predchozi stranku");
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
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getSQL().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        inv.setItem(49, shopItem);
        inv.setItem(40, deaktivace);
        //inv.setItem(41, dalsi);
        inv.setItem(39, zpet);

        p.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Heads")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 11) {
                openHeads(p);
            }
            if (e.getSlot() == 15) {
                openChristmasHeads(p);
            }
            if (e.getSlot() == 31) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
        }
        if (e.getInventory().getTitle().equals("Basic Heads (1 z 2)")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 39) {
                openMainHeadsMenu(p);
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.getInventory().setHelmet(null);
                p.closeInventory();
            }
            if (e.getSlot() == 41) {
                openHeads2(p);
            }
            if (e.getSlot() == 0) {
                setupHead(p, "craftlobby.heads.strawberryjam", "Strawberry Jam", "adc3ea73-5b42-4fea-a237-4a72b52dd72b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzBiOGI1ODg5ZWUxYzYzODhkYzZjMmM1ZGJkNzBiNjk4NGFlZmU1NDMxOWEwOTVlNjRkYjc2MzgwOTdiODIxIn19fQ==");
            }
            if (e.getSlot() == 1) {
                setupHead(p, "craftlobby.heads.chocolate", "Chocolate", "eaa47b1d-cb57-48c8-af33-cf4fd9872341", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODE5Zjk0OGQxNzcxOGFkYWNlNWRkNmUwNTBjNTg2MjI5NjUzZmVmNjQ1ZDcxMTNhYjk0ZDE3YjYzOWNjNDY2In19fQ==");
            }
            if (e.getSlot() == 2) {
                setupHead(p, "craftlobby.heads.whitechocolate", "White Chocolate", "91f8d9e9-0514-4319-902f-f2662f4df272", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWVkNTUyNjBkY2NjOGRhNTkzMzhjNzVlNDFkNTQ0YTJlMWU3ZGJlZjMxYTY5ZmU0MmMwMWIzMjk4YmYyZCJ9fX0=");
            }
            if (e.getSlot() == 3) {
                setupHead(p, "craftlobby.heads.hamburger", "Hamburger", "d1375075-c727-40ad-bcce-7e4277099e30", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZlZjFjMjVmNTE2ZjJlN2Q2Zjc2Njc0MjBlMzNhZGNmM2NkZjkzOGNiMzdmOWE0MWE4YjM1ODY5ZjU2OWIifX19");
            }
            if (e.getSlot() == 4) {
                setupHead(p, "craftlobby.heads.lemon", "Lemon", "09d10b7a-f525-412c-bedf-b2fe7c8bfc70", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTU3ZmQ1NmNhMTU5Nzg3NzkzMjRkZjUxOTM1NGI2NjM5YThkOWJjMTE5MmM3YzNkZTkyNWEzMjliYWVmNmMifX19");
            }
            if (e.getSlot() == 5) {
                setupHead(p, "craftlobby.heads.donut", "Donut", "b48503a4-6dec-438c-a3bc-6b5da7fb1fde", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM3YzliODJiMTg2NjU2ZTlmNjM2M2EyYTFjNmE0YjViOTNjZmE5ZWY0ZGFkNmYxNmI5NGViYjVlMzYyNjc4In19fQ==");
            }
            if (e.getSlot() == 6) {
                setupHead(p, "craftlobby.heads.computer", "Computer", "81c080fd-022b-477c-9f24-f637324d4c4c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFlNTJhZThjOThhYzE5ZmQwNzYzN2E0NjlmZmEyNTZhYjBiM2IxMGVjZTYyNDMxODYxODhiYTM4ZGYxNTQifX19");
            }
            if (e.getSlot() == 7) {
                setupHead(p, "craftlobby.heads.monitor", "Monitor", "5a929f7f-1a74-4d25-860d-40ff532acfbe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2ZjcyYzE2YjFlOWZlNmUwOTllNzZiNWY3YTg4NGZiNzgyY2ZjYzU4OGM5NWM0ZTM4M2RjNTI3ZDFiODQifX19");
            }
            if (e.getSlot() == 8) {
                setupHead(p, "craftlobby.heads.policesiren", "Police Siren", "e8297346-5aca-4ae8-b2a3-e341b6d0921f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2EzNWFmYTU4NjMxNjA5NzkxZmZlMjVmM2E4NzlkZmJmZmVhMTE1MWY4N2JmZjYyYzU0MjNlZDYxMzZlZTAifX19");
            }
            if (e.getSlot() == 9) {
                setupHead(p, "craftlobby.heads.texture", "MissingTexture", "5d43c6dd-ca01-466c-9614-764449140917", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19");
            }
            if (e.getSlot() == 10) {
                setupHead(p, "craftlobby.heads.spacehelmet", "Space Helmet", "822833e6-c3ec-457e-aeef-1fac97799e5f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzAyZTIyZjY1MDNjMzYzZGY2OWJmOWU5NDQ4ZmU4OWQyZjA1YmFlMzA1MzRiOGJiMTlkMjY4ZjA5ODliOTYifX19");
            }
            if (e.getSlot() == 11) {
                setupHead(p, "craftlobby.heads.youtube", "YouTube", "4ec6d571-4553-4a75-a4ae-6e104bcc76f0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0=");
            }
            if (e.getSlot() == 12) {
                setupHead(p, "craftlobby.heads.mailbox", "Mailbox", "4113ced7-576b-4c03-8a92-0937d5966ea1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFjYmJjYTU2NzM3MmE5YjJiMzZjOGY2ODE1NDg1MWJkYTVlZTFkNTNlMmJjMjA4YTExNTJkOWExOGQyY2IifX19");
            }
            if (e.getSlot() == 13) {
                setupHead(p, "craftlobby.heads.scared", "Scared", "2cd3dbb5-6136-4127-9e14-89c328660871", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjM2ZTI2YzQ0NjU5ZTgxNDhlZDU4YWE3OWU0ZDYwZGI1OTVmNDI2NDQyMTE2ZjgxYjU0MTVjMjQ0NmVkOCJ9fX0=");
            }
            if (e.getSlot() == 14) {
                setupHead(p, "craftlobby.heads.embarrased", "Embarrased", "80e16b56-8d8c-4ea0-b3b2-dd69c7bd56cf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjcyMGRmOTExYzA1MjM3NzA2NTQwOGRiNzhhMjVjNjc4Zjc5MWViOTQ0YzA2MzkzNWFlODZkYmU1MWM3MWIifX19");
            }
            if (e.getSlot() == 15) {
                setupHead(p, "craftlobby.heads.kissy", "Kissy", "c7360c40-1b10-4a11-8322-697962372596", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQ1YmQxOGEyYWFmNDY5ZmFkNzJlNTJjZGU2Y2ZiMDJiZmJhYTViZmVkMmE4MTUxMjc3Zjc3OWViY2RjZWMxIn19fQ==");
            }
            if (e.getSlot() == 16) {
                setupHead(p, "craftlobby.heads.cool", "Cool", "bcefcc41-e997-4845-ae08-7b8a1a2d51b6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4ZjRjZWY5NDlmMzJlMzNlYzVhZTg0NWY5YzU2OTgzY2JlMTMzNzVhNGRlYzQ2ZTViYmZiN2RjYjYifX19");
            }
            if (e.getSlot() == 17) {
                setupHead(p, "craftlobby.heads.suprised", "Suprised", "1a61537c-52d6-429d-9314-8420d631b494", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmMyYjliOWFlNjIyYmQ2OGFkZmY3MTgwZjgyMDZlYzQ0OTRhYmJmYTEzMGU5NGE1ODRlYzY5MmU4OTg0YWIyIn19fQ==");
            }
            if (e.getSlot() == 18) {
                setupHead(p, "craftlobby.heads.crying", "Crying", "b03562f3-2a20-4257-bb62-e040f552c297", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWYxYjg3NWRlNDljNTg3ZTNiNDAyM2NlMjRkNDcyZmYyNzU4M2ExZjA1NGYzN2U3M2ExMTU0YjViNTQ5OCJ9fX0=");
            }
            if (e.getSlot() == 19) {
                setupHead(p, "craftlobby.heads.grin", "Grin", "988770c2-3a2d-41c3-a753-b13fa383e823", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTA1OWQ1OWViNGU1OWMzMWVlY2Y5ZWNlMmY5Y2YzOTM0ZTQ1YzBlYzQ3NmZjODZiZmFlZjhlYTkxM2VhNzEwIn19fQ==");
            }
            if (e.getSlot() == 20) {
                setupHead(p, "craftlobby.heads.derp", "Derp", "58c6ac60-cbce-4ecb-981b-e79a87ad2bb6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2JhYWJlNzI0ZWFlNTljNWQxM2Y0NDJjN2RjNWQyYjFjNmI3MGMyZjgzMzY0YTQ4OGNlNTk3M2FlODBiNGMzIn19fQ==");
            }
            if (e.getSlot() == 21) {
                setupHead(p, "craftlobby.heads.mustache", "Mustache", "0d7d6e4d-fb18-491b-a7b6-dbf45d923811", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYzNmYyNzI0YWE2YWE0ZGU3YWM0NmMxOWYzYzg0NWZiMTQ4NDdhNTE4YzhmN2UwM2Q3OTJjODJlZmZiMSJ9fX0=");
            }
            if (e.getSlot() == 22) {
                setupHead(p, "craftlobby.heads.smile", "Smile", "0beedb99-f64e-4a26-93f3-8f3af84050aa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZmYWNjZjE3ODc5YjE3ODkxZmM1ZWY2NjQ3MmNjMDY2YTg1YmZhMzFiNmQ3ODZjMzJhZmVlNDc5NjA2OGQifX19");
            }
            if (e.getSlot() == 23) {
                setupHead(p, "craftlobby.heads.dead", "Dead", "275a74fe-e3e4-4aff-86a2-68e3fb9720d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM3MWU0ZTFjZjZhMWEzNmZkYWUyNzEzN2ZkOWI4NzQ4ZTYxNjkyOTk5MjVmOWFmMmJlMzAxZTU0Mjk4YzczIn19fQ==");
            }
            if (e.getSlot() == 24) {
                setupHead(p, "craftlobby.heads.skull", "Skull", "c659cdd4-e436-4977-a6a7-d5518ebecfbb", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19");
            }
            if (e.getSlot() == 25) {
                setupHead(p, "craftlobby.heads.evilbunny", "EvilBunny", "e4f254ad-1413-4853-8736-10c7aa53fbaf", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q0ZmRhZDVhNjEwNGFhNTQ5ZDFlNzZkNzNhM2M2ZmUzYzY3MjRiZjA5ZjdmZmNjMDJmMzNmOWVkZTdmYWRlIn19fQ==");
            }
            if (e.getSlot() == 26) {
                setupHead(p, "craftlobby.heads.scaryclown", "ScaryClown", "d1956517-9a4d-421d-8647-2d940dc64518", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODZkYmMxZGViYzU3NDM4YTVkZTRiYTkxNTE1MTM4MmFiYzNkOGYxMzE4ZTJhMzVlNzhkZmIzMGYwNGJjNDY3In19fQ==");
            }
            if (e.getSlot() == 27) {
                setupHead(p, "craftlobby.heads.frankensteinsmonster", "FrankensteinsMonster", "aec7b0b6-7bf8-46a6-b873-feb3d6277af8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjYmUwNjFiNDQ1Yjg4Y2IyZGY1OWFjY2M4ZDJjMWMxMjExOGZlMGIyMTI3ZTZlNzU4MTM1NTBhZGFjNjdjZiJ9fX0=");
            }
            if (e.getSlot() == 28) {
                setupHead(p, "craftlobby.heads.elephant", "Elephant", "9a58e25a-cf47-447d-b13c-3ea36eccfa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA3MWE3NmY2NjlkYjVlZDZkMzJiNDhiYjJkYmE1NWQ1MzE3ZDdmNDUyMjVjYjMyNjdlYzQzNWNmYTUxNCJ9fX0=");
            }
            if (e.getSlot() == 29) {
                setupHead(p, "craftlobby.heads.werewolf", "WereWolf", "fdc7eb2a-0bec-408d-8f16-f8494d3960d7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFjOTkzNGNkZDU1YTllNjMzNTk2MmE4Nzc2MjYwZDc5MTYxNTA4MTM0ODNlOTU2YzI4NjFiMTFhOGEyNjdmNyJ9fX0=");
            }
            if (e.getSlot() == 30) {
                setupHead(p, "craftlobby.heads.guardian", "Guardian", "2e9c0a67-92b3-4949-9be1-faf12318ee88", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTMyYzI0NTI0YzgyYWIzYjNlNTdjMjA1MmM1MzNmMTNkZDhjMGJlYjhiZGQwNjM2OWJiMjU1NGRhODZjMTIzIn19fQ==");
            }
            if (e.getSlot() == 31) {
                setupHead(p, "craftlobby.heads.walrus", "Walrus", "a185ff1a-f32e-47e0-be61-5a612f130f33", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdiYWVkYWY5YWQ5NTQ3NGViMWJlNTg5MjQ0NDVkZmM3N2JiZGMyNTJjYzFjODE2NDRjZjcxNTRjNDQxIn19fQ==");
            }
            if (e.getSlot() == 32) {
                setupHead(p, "craftlobby.heads.batman", "Batman", "af20c020-6810-4abe-8437-97d3bff52bec", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjI1NmY3MTczNWVmNDU4NTgxYzlkYWNmMzk0MTg1ZWVkOWIzM2NiNmVjNWNkNTk0YTU3MTUzYThiNTY2NTYwIn19fQ==");
            }
            if (e.getSlot() == 33) {
                setupHead(p, "craftlobby.heads.ghost", "Ghost", "31152fb2-cb1e-45c3-86dd-b23f7a20a6f8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjhkMjE4MzY0MDIxOGFiMzMwYWM1NmQyYWFiN2UyOWE5NzkwYTU0NWY2OTE2MTllMzg1NzhlYTRhNjlhZTBiNiJ9fX0=");
            }
            if (e.getSlot() == 34) {
                setupHead(p, "craftlobby.heads.skeletonminer", "SkeletonMiner", "fc0cbbe8-e2e2-4118-99a4-e4f811e75511", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM3ZjhmOTVjMTI1NzU3Y2JmNzY3YTExZjUyYTRlNjY5MWNlMThhMjU5NzhjNjhjZmEzOTEwMzYwZmUifX19");
            }
            if (e.getSlot() == 35) {
                setupHead(p, "craftlobby.heads.devil", "Devil", "c3c88c33-f305-4c10-9303-ce658b2fbde7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRhMzkyNjllZjQ1ZjgyNWVjNjFiYjRmOGFhMDliZDNjZjA3OTk2ZmI2ZmFjMzM4YTZlOTFkNjY5OWFlNDI1In19fQ==");
            }
        }
        if (e.getInventory().getTitle().equals("Basic Heads (2 z 2)")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.getInventory().setHelmet(null);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                openHeads(p);
            }
            if (e.getSlot() == 0) {
                setupHead(p, "craftlobby.heads.helloweenpumpkin", "HelloweenPumpkin", "87f9057b-abd3-45b9-8457-b8507a67ac55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM2NTcwZjEyNDI5OTJmNmViYTIzZWU1ODI1OThjMzllM2U3NDUzODMyNzNkZWVmOGIzOTc3NTgzZmUzY2Y1In19fQ==");
            }
            if (e.getSlot() == 1) {
                setupHead(p, "craftlobby.heads.mummy", "Mummy", "8f7c0c5b-720f-4944-8481-b0f7931f303f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2U5MWU5NTgyMmZlOThjYzVhNTY1OGU4MjRiMWI4Y2YxNGQ0ZGU5MmYwZTFhZjI0ODE1MzcyNDM1YzllYWI2In19fQ==");
            }
            if (e.getSlot() == 2) {
                setupHead(p, "craftlobby.heads.herobrine", "Herobrine", "d0b15454-36fa-43e4-a247-f882bb9fe288", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThiN2NhM2M3ZDMxNGE2MWFiZWQ4ZmMxOGQ3OTdmYzMwYjZlZmM4NDQ1NDI1YzRlMjUwOTk3ZTUyZTZjYiJ9fX0=");
            }
            if (e.getSlot() == 3) {
                setupHead(p, "craftlobby.heads.a", "A", "d9e6ae1b-8e1d-4ae7-8f5b-b581b1771d40", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MGRhMjk0NGExNzdkZDA4MjY4ZmJlYzA0ZTQwODEyZDFkOTI5NjUwYmU2NjUyOWIxZWU1ZTFlN2VjYSJ9fX0=");
            }
            if (e.getSlot() == 4) {
                setupHead(p, "craftlobby.heads.b", "B", "a389402c-129b-4de2-8877-7912a1afe881", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA0MWY1ZTg2OTgzZDM2ZWFlYzRlMTY3YjJiYmI1YTM3Mjc2MDdjZGU4OGY3NTU1Y2ExYjUyMmEwMzliYiJ9fX0=");
            }
            if (e.getSlot() == 5) {
                setupHead(p, "craftlobby.heads.c", "C", "5aafc18c-4341-4d65-bbfe-062706ffb067", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDk0NTk5NmM4YWU5MWUzNzYxOTZkNGRjNjc2ZmVjMzFmZWFjNzkwYTJmMTk1YjI5ODFhNzAzY2ExZDE2Y2I2In19fQ==");
            }
            if (e.getSlot() == 6) {
                setupHead(p, "craftlobby.heads.d", "D", "2bb28566-da08-4b69-963f-da9561f1d0a8", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTY0MTE1MGY0ODFlODQ5MmY3MTI4Yzk0ODk5NjI1NGQyZDkxZmM5MGY1YThmZjRkOGFjNWMzOWE2YTg4YSJ9fX0=");
            }
            if (e.getSlot() == 7) {
                setupHead(p, "craftlobby.heads.e", "E", "72c35d01-c507-4efc-9184-63c32cdf4687", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGIyNTE0ODdmZjhlZWYyZWJjN2E1N2RhYjZlM2Q5ZjFkYjdmYzkyNmRkYzY2ZmVhMTRhZmUzZGZmMTVhNDUifX19");
            }
            if (e.getSlot() == 8) {
                setupHead(p, "craftlobby.heads.f", "F", "b46b2241-5546-48db-a457-a2dbad23db27", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U0MzM2NTZiNDQzNjY4ZWQwM2RhYzhjNDQyNzIyYTJhNDEyMjFiZThiYjQ4ZTIzYjM1YmQ4YzJlNTlmNjMifX19");
            }
            if (e.getSlot() == 9) {
                setupHead(p, "craftlobby.heads.g", "G", "4b0845df-5f9a-47ab-8ab7-044f810017fd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTk1ODYzYjczNjM3NjA1ZmVhY2JiMTczYjc3ZDVlMTU1ZTY1MjA0Yzc4ZDVjNzkxMWY3MzhmMjhkZWI2MCJ9fX0=");
            }
            if (e.getSlot() == 10) {
                setupHead(p, "craftlobby.heads.h", "H", "ea507bde-e39a-4e8c-b6a7-35fffed066c6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2MxZDM1OGQ5MjcwNzQyODljYzI2YmZmNWIxMjQwNzQ2ZjlmNGYwY2M0NmY5NDJmNTk4MWM2NTk1ZjcyZGQifX19");
            }
            if (e.getSlot() == 11) {
                setupHead(p, "craftlobby.heads.i", "I", "84143d3c-f198-461d-aecc-40741d5494fe", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGYyMjk1ODY1YmRhNGU0Nzk3OWQzNmI4YTg4N2E3NWExM2IwMzRlNjk4OGY3ODY3MGI2NGExZTY0NDJjIn19fQ==");
            }
            if (e.getSlot() == 12) {
                setupHead(p, "craftlobby.heads.j", "J", "3814608a-d3e2-49ce-9ebf-fe4c25efd882", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTM0NDYyYjU1ZDdmNTgyMzY4MGFkMTNmMmFkYmQ3ZDFlZDQ2YmE1MTAxMDE3ZWQ0YjM3YWVlZWI3NzVkIn19fQ==");
            }
            if (e.getSlot() == 13) {
                setupHead(p, "craftlobby.heads.k", "K", "519c18a7-f30d-4f03-8975-9655f2360347", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzczMzI1YTkzNWMwNjdiNmVmMjI3MzY3ZjYyY2E0YmY0OWY2N2FkYjlmNmRhMzIwOTFlMmQzMmM1ZGRlMzI4In19fQ==");
            }
            if (e.getSlot() == 14) {
                setupHead(p, "craftlobby.heads.l", "L", "c5d1650f-c193-4f67-be23-7eae09a66e1c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVhMWUzMzI4YzU3MWFhNDk1ZDljNWY0OTQ4MTVjY2ExNzZjM2FjYjE4NGZlYjVhN2I5Yzk2Y2U4ZTUyZmNlIn19fQ==");
            }
            if (e.getSlot() == 15) {
                setupHead(p, "craftlobby.heads.m", "M", "d6a7ebad-3f25-4d4c-9bf0-36b069dc38ca", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQ2N2JmNmJlOTVlNWM4ZTlkMDE5NzdhMmYwYzQ4N2VkNWIwZGU1Yzg3OTYzYTJlYjE1NDExYzQ0MmZiMmIifX19");
            }
            if (e.getSlot() == 16) {
                setupHead(p, "craftlobby.heads.n", "N", "d621ae4e-f103-4b78-a180-c756b76b45b4", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODIzZTQzNGQ2Mzk1ZmU3ZTYzNDkyNDMxYmRlZTU3ODJiZDVlZTViYzhjYWI3NTU5NDY3YmRkMWY5M2I5MjVhIn19fQ==");
            }
            if (e.getSlot() == 17) {
                setupHead(p, "craftlobby.heads.o", "O", "425da042-932b-483d-9252-b7783871b66e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0NDU0NjZiZGM1YWQ1YmNlYTgyMjM5YzRlMWI1MTBmNmVhNTI2MmQ4MmQ4YTk2ZDcyOTFjMzQyZmI4OSJ9fX0=");
            }
            if (e.getSlot() == 18) {
                setupHead(p, "craftlobby.heads.p", "P", "ebfde078-cc98-48f1-ac64-608c8545cc28", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkZTYwMWRlZTNmZmVjYTRkNTQ1OTVmODQ0MjAxZDBlZDIwOTFhY2VjNDU0OGM2OTZiYjE2YThhMTU4ZjYifX19");
            }
            if (e.getSlot() == 19) {
                setupHead(p, "craftlobby.heads.q", "Q", "5f94a01f-2bf4-497b-90fb-188e38055ca9", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjZjYTc2OWJkZTI1ZDRjYzQxZTE5ZTQyYWRjMzVhYjRjMTU1N2I3NmFmMjMyNjQ5YWNjOTk2N2ZmMTk4ZjEzIn19fQ==");
            }
            if (e.getSlot() == 20) {
                setupHead(p, "craftlobby.heads.r", "R", "ff745ee1-3463-473e-9e5d-db5b3f9e56a1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdhMTg4ODA1MTYyY2E1ZGQ0ZjQ2NDljNjYxZDNmNmQyM2M0MjY2MmFlZjAxNjQ1YjFhOTdmNzhiM2YxMzIxOSJ9fX0=");
            }
            if (e.getSlot() == 21) {
                setupHead(p, "craftlobby.heads.s", "S", "7fdd4eda-abdb-4019-aa25-9c23b69f0012", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkMDlkZmQ5ZjVkZTYyNDMyMzNlMGUzMzI1YjZjMzQ3OTMzNWU3Y2NmMTNmMjQ0OGQ0ZTFmN2ZjNGEwZGYifX19");
            }
            if (e.getSlot() == 22) {
                setupHead(p, "craftlobby.heads.t", "T", "28408552-4d4a-4830-a90e-8d2d98f84dcc", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRjNzU2MTliOTFkMjQxZjY3ODM1MGFkOTIzN2MxMzRjNWUwOGQ4N2Q2ODYwNzQxZWRlMzA2YTRlZjkxIn19fQ==");
            }
            if (e.getSlot() == 23) {
                setupHead(p, "craftlobby.heads.u", "U", "0b7ee6c6-f3ae-43a2-b19b-0c9df57a752d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTlmNmQyYzZkNTI4NWY4ODJhZTU1ZDFlOTFiOGY5ZWZkZmM5YjM3NzIwOGJmNGM4M2Y4OGRkMTU2NDE1ZSJ9fX0=");
            }
            if (e.getSlot() == 24) {
                setupHead(p, "craftlobby.heads.v", "V", "4a7d6a90-977e-4708-976b-c52d27ecaa31", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNlMjdhMTUzNjM1ZjgzNTIzN2Q4NWM2YmY3NGY1YjFmMmU2MzhjNDhmZWU4YzgzMDM4ZDA1NThkNDFkYTcifX19");
            }
            if (e.getSlot() == 25) {
                setupHead(p, "craftlobby.heads.w", "W", "eacab58c-56fb-46d9-97f6-c1c2cab2cf9e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWVkY2Y0ZmZjYjUzYjU2ZDQyYmFhYzlkMGRmYjExOGUzNDM0NjIzMjc0NDJkZDliMjlkNDlmNTBhN2QzOGIifX19");
            }
            if (e.getSlot() == 26) {
                setupHead(p, "craftlobby.heads.x", "X", "1f5d7b63-569e-4d96-b7fb-ef437ef39850", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODM2MThmZjEyMTc2NDBiZWM1YjUyNWZhMmE4ZTY3MWM3NWQyYTdkN2NiMmRkYzMxZDc5ZDlkODk1ZWFiMSJ9fX0=");
            }
            if (e.getSlot() == 27) {
                setupHead(p, "craftlobby.heads.y", "Y", "fd3e1792-dd5e-497a-b2af-c24a22ca75e0", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDljMWQyOWEzOGJjZjExM2I3ZThjMzRlMTQ4YTc5ZjlmZTQxZWRmNDFhYThiMWRlODczYmIxZDQzM2IzODYxIn19fQ==");
            }
            if (e.getSlot() == 28) {
                setupHead(p, "craftlobby.heads.z", "Z", "34b483d5-b7b7-4a33-b8c1-bb725969bd4a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjkyOTU3MzQxOTVkMmM3ZmEzODliOTg3NTdlOTY4NmNlNjQzN2MxNmM1OGJkZjJiNGNkNTM4Mzg5YjU5MTIifX19");
            }
            if (e.getSlot() == 29) {
                setupHead(p, "craftlobby.heads.mrwakecz", "MrWakeCZ", "43d05dab-2dbc-418b-9e6f-dc73ab916dbc", "eyJ0aW1lc3RhbXAiOjE0NTQ3MTIwOTIzMjksInByb2ZpbGVJZCI6IjQzZDA1ZGFiMmRiYzQxOGI5ZTZmZGM3M2FiOTE2ZGJjIiwicHJvZmlsZU5hbWUiOiJNcldha2VDWiIsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS84YzQ5ODM2MDliYjY2ZTBmNDY3ZmEzYmYyNmQ5NzBkOWI1OWYyODdjZDhiYTk0MWU4ZWE4NTliZTgwNmM5MCJ9fX0=");
            }
        }
        if (e.getInventory().getTitle().equals("Vanocni Heads (1 z 1)")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.getInventory().setHelmet(null);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                openMainHeadsMenu(p);
            }
            if (e.getSlot() == 0) {
                setupHead(p, "craftlobby.heads.vanocni.santa", "Santa", "fd9c8a5c-cd32-4902-a55e-b48e18cc4ce6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2JjYmIzZTRhMzhhYzJhMDVmNjk1NWNkMmM5ODk1YWQ5ZjI4NGM2ZTgyZTc1NWM5NGM1NDljNWJkYzg1MyJ9fX0=");
            }
            if (e.getSlot() == 1) {
                setupHead(p, "craftlobby.heads.vanocni.piratesanta", "PirateSanta", "0eac3133-65c6-44a4-44ee-db7dfd74208d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzc5NTMzNGVmZDkyYWFmMzhkZjk2ZTg2YTYzNjFmYTc3NmUwNTJhOTBlNjIyYTUyZWQ5ZjMxZDY3OWU1OTUifX19");
            }
            if (e.getSlot() == 2) {
                setupHead(p, "craftlobby.heads.vanocni.commandblock", "CommandBlock", "5bbf064c-4cd7-4e37-b7f3-44f53b588f53", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjBlZDg3NmFiYzRhZWIyMThkYzUxZTZlY2E0NGNjZjUxY2YwYmQ2NmM2ZDc1Y2JiYjBkYjlhZDNkNmYwOTMifX19");
            }
            if (e.getSlot() == 3) {
                setupHead(p, "craftlobby.heads.vanocni.elfboy", "ElfBoy", "367ea5a0-cf6f-4993-9c7e-9f3466bf30ef", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmNlNjg1YmVhOGY2ZDk2NmU1MzNlMmFmNWJhYTU1NzdlMWE5OGY2Y2FkMTFiOGYwZjdmMjAxYmJlZjZlODIyIn19fQ==");
            }
            if (e.getSlot() == 4) {
                setupHead(p, "craftlobby.heads.vanocni.elfgirl", "ElfGirl", "e13aa36e-7804-4f00-a9c0-668f24ffb0a7", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTg5YTRjMWE3YzgxZjM3NjVmNWE1ZTJjOTJlNGQ0OGVkOTczMGRhYzE4NzhkZmY0MWExOTFkNzhhMTY5ZDg5In19fQ==");
            }
            if (e.getSlot() == 5) {
                setupHead(p, "craftlobby.heads.vanocni.sob", "Sob", "5ddb61e0-4e65-4097-8026-489261d7d278", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQ5MjdjZTViYTIyYWQxZTc1N2Q2YTMzM2UyNzViMzZkYTFhODQzNmZjZWYwNzczNDBhYjUzZTNmYiJ9fX0=");
            }
            if (e.getSlot() == 6) {
                setupHead(p, "craftlobby.heads.vanocni.snowman", "Snowman", "2d141b1e-86d1-48e9-964c-5d9db8655e04", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOThlMzM0ZTRiZWUwNDI2NDc1OWE3NjZiYzE5NTVjZmFmM2Y1NjIwMTQyOGZhZmVjOGQ0YmYxYmIzNmFlNiJ9fX0=");
            }
            if (e.getSlot() == 7) {
                setupHead(p, "craftlobby.heads.vanocni.snowglobe", "Snowglobe", "be6b6cbc-223a-4c98-b205-b00b7c545579", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRkNjYzMTM2Y2FmYTExODA2ZmRiY2E2YjU5NmFmZDg1MTY2YjRlYzAyMTQyYzhkNWFjODk0MWQ4OWFiNyJ9fX0=");
            }
            if (e.getSlot() == 8) {
                setupHead(p, "craftlobby.heads.vanocni.snowglobe2", "Snowglobe2", "2a2b9900-73a3-44d9-957f-47ba7f54497b", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2MTU2ZDdmMjEzMjY2OWMzNjdhYjg5NTIzYzJlMWI5ODY2ZTQwYjJiODkxMzkzNzQ0NjU3ZjFjMzU1In19fQ==");
            }
            if (e.getSlot() == 9) {
                setupHead(p, "craftloby.heads.vanocni.blackpresent", "BlackPresent", "ee53f881-8b67-4604-bfb9-a43a6966eae2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWM3MTJiMTk3MWM1ZjQyZWVmZjgwNTUxMTc5MjIwYzA4YjgyMTNlYWNiZTZiYzE5ZDIzOGMxM2Y4NmUyYzAifX19");
            }
            if (e.getSlot() == 10) {
                setupHead(p, "craftlobby.heads.vanocni.bluepresent", "BluePresent", "9e7cfed7-6eab-419e-ade9-dcdd59c3949d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyZTk0NTFjZGIxOTZiNzgxOTVhOGYwYTRiOWMxYzBhMDRmNTgyNzg4NzkyN2I2YTgyYWFkMzljYWIyZjQzMCJ9fX0=");
            }
            if (e.getSlot() == 11) {
                setupHead(p, "craftlobby.heads.vanocni.greenpresent", "GreenPresent", "434b9c7c-d287-4d61-b4c3-7be1da79b9e5", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTcxNWY1MzdmZTdhZjZmNWFhNmViOThhZDY5MDJjMTNkMDVmYjM2YzE2YjMxMWVkODMyYjA5YjU5ODgyOCJ9fX0=");
            }
            if (e.getSlot() == 12) {
                setupHead(p, "craftlobby.heads.vanocni.goldpresent", "GoldPresent", "d8b36e98-b8ee-4cdc-ac57-f4ef5a6e74b1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0Y2RlMTZhNDAxNGRlMGE3NjUxZjYwNjdmMTI2OTViYjVmZWQ2ZmVhZWMxZTk0MTNjYTQyNzFlN2M4MTkifX19");
            }
        }
    }

    private ItemStack createHead(String name, String uuid, String value) {
        ItemStack skull = ItemFactory.createHead("§e" + name, uuid, value);
        ItemMeta sMeta = skull.getItemMeta();
        ArrayList<String> sLore = new ArrayList<String>();
        sLore.add("§7Ziskano z CraftBoxu.");
        sMeta.setLore(sLore);
        skull.setItemMeta(sMeta);
        return skull;
    }

    private ItemStack noPerm(String name) {
        ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta noPermMeta = noPerm.getItemMeta();
        noPermMeta.setDisplayName("§c" + name);
        ArrayList<String> noPermLore = new ArrayList<String>();
        noPermLore.add("§7Vybranou headku lze ziskat v CraftBoxu!");
        noPermMeta.setLore(noPermLore);
        noPerm.setItemMeta(noPermMeta);
        return noPerm;
    }

    private ItemStack noPermW(String name) {
        ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
        ItemMeta noPermMeta = noPerm.getItemMeta();
        noPermMeta.setDisplayName("§c" + name);
        ArrayList<String> noPermLore = new ArrayList<String>();
        noPermLore.add("§7Vybranou headku lze ziskat ve Vanocnim kalendari 2016!");
        noPermMeta.setLore(noPermLore);
        noPerm.setItemMeta(noPermMeta);
        return noPerm;
    }

    private void setupHead(final Player p, String permiss, String name, String uuid, String value) {
        if (p.hasPermission(permiss)) {
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 15.0F, 15.0F);
            ItemStack skull = ItemFactory.createHead(name, uuid, value);
            p.getInventory().setHelmet(skull);
            p.sendMessage("§7Nasadil sis na hlavu §a" + name + " Head.");
            p.closeInventory();
        } else {
            ms.messageNoPerm(p, name);
        }
    }

    public String counHeadsString(final Player p) {
        int heads = countHeads(p);
        int sum = 66;
        int prc = (heads * 100 / sum);

        return "§7Odemknuto: §f" + heads + "/" + sum + " §8(" + prc + "%)";
    }

    public String counChristmasHeadsString(final Player p) {
        int heads = countChristmasHeads(p);
        int sum = 13;
        int prc = (heads * 100 / sum);

        return "§7Odemknuto: §f" + heads + "/" + sum + " §8(" + prc + "%)";
    }

    private int countChristmasHeads(final Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.heads.vanocni.santa")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.piratesanta")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.commandblock")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.elfboy")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.elfgirl")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.sob")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowman")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowglobe")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.snowglobe2")) {
            c++;
        }
        if (p.hasPermission("craftloby.heads.vanocni.blackpresent")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.bluepresent")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.greenpresent")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.vanocni.goldpresent")) {
            c++;
        }
        return c;
    }

    private int countHeads(final Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.heads.strawberryjam")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.chocolate")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.whitechocolate")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.hamburger")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.lemon")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.donut")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.computer")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.monitor")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.policesiren")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.texture")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.spacehelmet")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.youtube")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.mailbox")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.scared")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.embarrased")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.kissy")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.cool")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.suprised")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.crying")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.grin")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.derp")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.mustache")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.smile")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.dead")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.skull")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.evilbunny")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.scaryclown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.frankensteinsmonster")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.elephant")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.werewolf")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.guardian")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.walrus")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.batman")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.ghost")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.skeletonminer")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.devil")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.helloweenpumpkin")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.mummy")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.herobrine")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.a")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.b")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.c")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.d")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.e")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.f")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.g")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.h")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.i")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.j")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.k")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.l")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.m")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.n")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.o")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.p")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.q")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.r")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.s")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.t")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.u")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.v")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.w")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.x")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.y")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.z")) {
            c++;
        }
        if (p.hasPermission("craftlobby.heads.mrwakecz")) {
            c++;
        }
        return c;
    }

}
