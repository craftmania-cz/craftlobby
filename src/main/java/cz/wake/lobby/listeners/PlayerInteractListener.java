package cz.wake.lobby.listeners;

import cz.craftmania.craftcore.spigot.inventory.builder.SmartInventory;
import cz.wake.lobby.Main;
import cz.wake.lobby.gui.LobbySelectorGUI;
import cz.wake.lobby.gui.ServerSelectorGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PlayerInteractListener implements Listener {

    private HashMap<Player, Double> _time = new HashMap<>();
    private HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        final Player player = e.getPlayer();

        // Profil
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PLAYER_HEAD) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aProfil §7(Klikni pravym)"))) {
            player.sendMessage("§c§l[!] §cTato funkce bude uveřejněná v pozdějším Lobby Content Updatu! :)");
        }

        // Kompas
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bVyber serveru §7(Klikni pravym)"))) {
            SmartInventory.builder().size(6, 9).title("Výběr serveru").provider(new ServerSelectorGUI()).build().open(player);
        }

        // Lobby selector
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eZměna lobby §7(Klikni pravým)"))) {
            SmartInventory.builder().size(6, 9).title("Změna lobby").provider(new LobbySelectorGUI()).build().open(player);
        }

        // Changelogs
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) &&
                (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOOK) && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§9Changelogs §7(Klikni pravým)"))) {
            player.sendMessage("§c§l[!] §cTato funkce bude uveřejněná v pozdějším Lobby Content Updatu! :)");
        }


        // Player hider
        if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
            if (!e.getHand().equals(EquipmentSlot.HAND)) return;
            if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.LIME_DYE && (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §a§lVIDITELNY"))) {
                if (!this._time.containsKey(e.getPlayer())) {
                    this._time.put(e.getPlayer(), 8D + 0.1D);
                    e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BREAK, 2.0F, 2.0F);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        e.getPlayer().hidePlayer(players);
                        ItemStack disable = new ItemStack(Material.RED_DYE);
                        ItemMeta im = disable.getItemMeta();
                        im.setDisplayName("§7Hraci: §c§lNEVIDITELNY");
                        disable.setItemMeta(im);
                        e.getPlayer().getInventory().setItem(6, disable);
                        e.getPlayer().updateInventory();
                    }
                    e.getPlayer().sendMessage(ChatColor.RED + "Vsechny aktualni hrace jsi zneviditelnil.");
                    this._cdRunnable.put(e.getPlayer(), new BukkitRunnable() {
                        @Override
                        public void run() {
                            PlayerInteractListener.this._time.put(e.getPlayer(), PlayerInteractListener.this._time.get(e.getPlayer()) - 0.1D);
                            if (PlayerInteractListener.this._time.get(e.getPlayer()) < 0.01D) {
                                PlayerInteractListener.this._time.remove(e.getPlayer());
                                PlayerInteractListener.this._cdRunnable.remove(e.getPlayer());
                                cancel();
                            }
                        }
                    });
                    this._cdRunnable.get(e.getPlayer()).runTaskTimer(Main.getInstance(), 2L, 2L);
                } else {
                    MessagesListener.messageCooldown(e.getPlayer(), String.valueOf(arrondi(this._time.get(e.getPlayer()), 1)));
                    return;
                }
            } else {
                if ((e.getPlayer().getItemInHand().getType() == Material.RED_DYE && (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Hraci: §c§lNEVIDITELNY")))) {
                    if (!e.getHand().equals(EquipmentSlot.HAND)) return;
                    if (!this._time.containsKey(e.getPlayer())) {
                        this._time.put(e.getPlayer(), 8D + 0.1D);
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_WOOD_BREAK, 2.0F, 2.0F);
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            e.getPlayer().showPlayer(pl);
                            ItemStack enable = new ItemStack(Material.LIME_DYE, 1, (byte) 10);
                            ItemMeta im = enable.getItemMeta();
                            im.setDisplayName("§7Hraci: §a§lVIDITELNY");
                            enable.setItemMeta(im);
                            e.getPlayer().getInventory().setItem(6, enable);
                            e.getPlayer().updateInventory();
                        }
                        e.getPlayer().sendMessage(ChatColor.GREEN + "Vsechny hrace jsi zviditelnil.");
                        this._cdRunnable.put(e.getPlayer(), new BukkitRunnable() {
                            @Override
                            public void run() {
                                PlayerInteractListener.this._time.put(e.getPlayer(), PlayerInteractListener.this._time.get(e.getPlayer()) - 0.1D);
                                if (PlayerInteractListener.this._time.get(e.getPlayer()) < 0.01D) {
                                    PlayerInteractListener.this._time.remove(e.getPlayer());
                                    PlayerInteractListener.this._cdRunnable.remove(e.getPlayer());
                                    cancel();
                                }
                            }
                        });
                        this._cdRunnable.get(e.getPlayer()).runTaskTimer(Main.getInstance(), 2L, 2L);
                    } else {
                        MessagesListener.messageCooldown(e.getPlayer(), String.valueOf(arrondi(this._time.get(e.getPlayer()), 1)));
                        return;
                    }
                }
            }
        }

        // Ochrana na blbosti
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            Block b = e.getClickedBlock();
            if ((b.getType() == Material.BEACON)
                    || (b.getType() == Material.BREWING_STAND)
                    || (b.getType() == Material.ANVIL)
                    || (b.getType() == Material.ENDER_CHEST)
                    || (b.getType() == Material.ACACIA_TRAPDOOR)
                    || (b.getType() == Material.BIRCH_TRAPDOOR)
                    || (b.getType() == Material.DARK_OAK_TRAPDOOR)
                    || (b.getType() == Material.IRON_TRAPDOOR)
                    || (b.getType() == Material.JUNGLE_TRAPDOOR)
                    || (b.getType() == Material.OAK_TRAPDOOR)
                    || (b.getType() == Material.SPRUCE_TRAPDOOR)
                    || (b.getType() == Material.CHEST)
                    || (b.getType() == Material.OAK_FENCE)
                    || (b.getType() == Material.OAK_FENCE_GATE)
                    || (b.getType() == Material.ACACIA_FENCE)
                    || (b.getType() == Material.ACACIA_FENCE_GATE)
                    || (b.getType() == Material.BIRCH_FENCE)
                    || (b.getType() == Material.BIRCH_FENCE_GATE)
                    || (b.getType() == Material.DARK_OAK_FENCE)
                    || (b.getType() == Material.DARK_OAK_FENCE_GATE)
                    || (b.getType() == Material.JUNGLE_FENCE)
                    || (b.getType() == Material.JUNGLE_FENCE_GATE)
                    || (b.getType() == Material.SPRUCE_FENCE)
                    || (b.getType() == Material.SPRUCE_FENCE_GATE)
                    || (b.getType() == Material.NETHER_BRICK_FENCE)
                    || (b.getType() == Material.TRAPPED_CHEST)
                    || (b.getType() == Material.HOPPER)
                    || (b.getType() == Material.ITEM_FRAME)
                    || (b.getType() == Material.PAINTING)
                    || (b.getType() == Material.FLOWER_POT)) {
                if (Main.getInstance().isDebug()) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }

    public static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }
}
