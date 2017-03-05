package cz.wake.lobby.GUI;

import cz.wake.lobby.Main;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Stalker implements Listener {

    public void openStalker(Player p) {

        Inventory menu = Bukkit.createInventory(null, 45, "Stalker");

        ItemStack i = ItemFactory.create(Material.GOLD_PICKAXE, (byte) 0, "§c§lSurvival",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "surv_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "surv_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "surv_pos_aktivita")));
        menu.setItem(11, i);

        ItemStack i2 = ItemFactory.create(Material.SAPLING, (byte) 0, "§c§lSkyblock",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "sky_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "sky_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "sky_pos_aktivita")));
        menu.setItem(12, i2);

        ItemStack i3 = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§c§lCreative",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "sky_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "sky_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "sky_pos_aktivita")));
        menu.setItem(13, i3);

        ItemStack i4 = ItemFactory.create(Material.IRON_BARDING, (byte) 0, "§c§lPrison",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "prison_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "prison_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "prison_pos_aktivita")));
        menu.setItem(14, i4);

        ItemStack i5 = ItemFactory.create(Material.EMERALD, (byte) 0, "§c§lVanilla",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "vanilla_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "vanilla_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "vanilla_pos_aktivita")));
        menu.setItem(15, i5);

        ItemStack i6 = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§c§lMiniGames",
                "§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(p.getName(), "minigames_chat_body"),
                "§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(p.getName(), "minigames_played_time"), false),
                "§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(p.getName(), "minigames_pos_aktivita")));
        menu.setItem(22, i6);

        ItemStack i7 = ItemFactory.create(Material.REDSTONE, (byte) 0, "§c§lPrehled", "§7Prehled vsech lidi v AT", "§7a jejich statistik.");
        menu.setItem(40, i7);

        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§eZpet");
        menu.setItem(39, zpet);

        p.openInventory(menu);
    }

    public void openAdminStalker(Player p) {

        List<String> at = Main.getInstance().fetchData().getAllAdminTeam();

        Inventory menu = Bukkit.createInventory(null, 54, "[A] Stalker");

        System.out.println(at);

        for (int i = 0; i < at.size(); i++) {
            SkullMeta headItemMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
            headItemMeta.setOwner(at.get(i));
            headItemMeta.setDisplayName("§b§l" + at.get(i));
            ItemStack headItem = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            ArrayList<String> headLore = new ArrayList<String>();
            headLore.add("§eSurvival");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "surv_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "surv_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "surv_pos_aktivita")));
            headLore.add("§eSkyblock");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "sky_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "sky_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "sky_pos_aktivita")));
            headLore.add("§eCreative");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "crea_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "crea_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "crea_pos_aktivita")));
            headLore.add("§ePrison");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "prison_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "prison_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "prison_pos_aktivita")));
            headLore.add("§eVanilla");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "vanilla_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "vanilla_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "vanilla_pos_aktivita")));
            headLore.add("§eMiniGames");
            headLore.add("§7Chat body: §f" + Main.getInstance().fetchData().getStalkerStats(at.get(i), "minigames_chat_body"));
            headLore.add("§7Odehrano: §f" + TimeUtils.formatTime("%d dni, %hh %mm", Main.getInstance().fetchData().getStalkerStats(at.get(i), "minigames_played_time"), false));
            headLore.add("§7Posledni aktivita: §f" + getDate(Main.getInstance().fetchData().getStalkerStatsTime(at.get(i), "minigames_pos_aktivita")));
            headItemMeta.setLore(headLore);
            headItem.setItemMeta(headItemMeta);
            menu.setItem(i, headItem);
        }

        p.openInventory(menu);

    }

    private String getDate(long time) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        final String timeString = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(cal.getTime());
        return timeString;
    }
}
