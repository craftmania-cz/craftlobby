package cz.wake.lobby.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Splitter;
import cz.craftmania.craftcore.spigot.builders.items.ItemBuilder;
import cz.craftmania.craftcore.spigot.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.spigot.inventory.builder.content.InventoryProvider;
import cz.craftmania.craftcore.spigot.inventory.builder.content.Pagination;
import cz.craftmania.craftcore.spigot.inventory.builder.content.SlotIterator;
import org.apache.commons.io.IOUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangelogsGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {

        final Pagination pagination = contents.pagination();
        final ArrayList<ClickableItem> items = new ArrayList<>();

        try {
            JSONArray json = readJsonFromUrl("https://changelog-api.craftmania.cz/public/channels/servers");
            for (int i = 0; i < json.length(); i++) {
                JSONObject object = json.getJSONObject(i);

                String name = object.getString("title");
                String version = object.getString("version");
                String releaseDate = object.getString("publishDate");

                JSONArray changes = object.getJSONArray("changes");


                ItemStack item = new ItemBuilder(Material.BOOK).setName("§9" + name + " §7(" + version + ")")
                        .setLore(formatChanges(releaseDate, changes)).build();

                items.add(ClickableItem.of(item, finalItem -> {}));
            }
        } catch (IOException e) {
            //e.printStackTrace(); // Když nic tak nic ne..
        }

        ClickableItem[] c = new ClickableItem[items.size()];
        c = items.toArray(c);
        pagination.setItems(c);
        pagination.setItemsPerPage(45);

        if (items.size() > 0 && !pagination.isLast()) {
            contents.set(5, 7, ClickableItem.of(new ItemBuilder(Material.ARROW).setName("§f§lDalší stránka").build(), e -> {
                contents.inventory().open(player, pagination.next().getPage());
            }));
        }
        if (!pagination.isFirst()) {
            contents.set(5, 1, ClickableItem.of(new ItemBuilder(Material.ARROW).setName("§f§lPředchozí stránka").build(), e -> {
                contents.inventory().open(player, pagination.previous().getPage());
            }));
        }

        SlotIterator slotIterator = contents.newIterator(SlotIterator.Type.HORIZONTAL, 0, 0);
        slotIterator = slotIterator.allowOverride(false);
        pagination.addToIterator(slotIterator);
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
        InputStream is = urlConnection.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = IOUtils.toString(rd);
            return new JSONArray(jsonText);
        } finally {
            is.close();
        }
    }

    private String formateDate(String date) {
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Date d = null;
        try {
            d = input.parse(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return output.format(d);
    }

    private List<String> formatChanges(String releaseDate, JSONArray array) {
        List<String> finalList = new ArrayList<>();
        finalList.add("§eUveřejněno: §f" + formateDate(releaseDate));
        finalList.add("§eZměny:");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            String line = " §8- " + colorChangeType(object.getString("type")) + " §f" + object.getString("text");
            if (line.length() >= 71) {
                for(String text : Splitter.fixedLength(71).split(line)) {
                    finalList.add("§f" + text);
                }
            } else {
                finalList.add(" §8- " + colorChangeType(object.getString("type")) + " §f" + object.getString("text"));
            }
        }
        return finalList;
    }

    private String colorChangeType(String string) {
        if (string.equalsIgnoreCase("added")) {
            return "§a[added]";
        } else if (string.equalsIgnoreCase("removed")) {
            return "§c[removed]";
        } else if (string.equalsIgnoreCase("changed")) {
            return "§3[changed]";
        } else if (string.equalsIgnoreCase("fixed")) {
            return "§6[fixed]";
        } else if (string.equalsIgnoreCase("security")) {
            return "§d[security]";
        } else { // deprecated
            return "§5[" + string + "]";
        }
    }
}
