package cz.wake.lobby.gadgets.cloaks;

import cz.wake.lobby.Main;
import cz.wake.lobby.listeners.MessagesListener;
import cz.wake.lobby.manager.Shop;
import cz.wake.lobby.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CloaksAPI implements Listener {

    private AngleCloak angel = new AngleCloak();
    private SantaCloak santa = new SantaCloak();
    private DevilCloak devil = new DevilCloak();
    private MessagesListener ml = new MessagesListener();
    private RankCape cape = new RankCape();
    private TurnajCape tc = new TurnajCape();

    public void openCloaks(Player p) {

        Inventory cloakMenu = Bukkit.createInventory(null, 54, "Cloaks");

        if (p.hasPermission("craftlobby.cloaks.santa")) {
            if (SantaCloak.santaCloaks.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§a§lSanta Cloak", "", "§7S timto budes vypadat jako", "§7opravdovy santa.", "", "§cAktivovano!");
                i = ItemFactory.addGlow(i);
                cloakMenu.setItem(10, i);
            } else {
                ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§a§lSanta Cloak", "", "§7S timto budes vypadat jako", "§7opravdovy santa.", "", "§eKliknutim aktivujes!");
                cloakMenu.setItem(10, i);
            }
        } else {
            cloakMenu.setItem(10, nakup("Santa", 700));
        }
        if (p.hasPermission("craftlobby.cloaks.angel")) {
            if (AngleCloak.angelCloaks.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BREAD, (byte) 0, "§a§lAngel Cloak", "", "§7Jako ten pravy andel,", "§7budes vypadat.", "", "§cAktivovano!");
                i = ItemFactory.addGlow(i);
                cloakMenu.setItem(11, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BREAD, (byte) 0, "§a§lAngel Cloak", "", "§7Jako ten pravy andel,", "§7budes vypadat.", "", "§eKliknutim aktivujes!");
                cloakMenu.setItem(11, i);
            }
        } else {
            cloakMenu.setItem(11, nakup("Angel", 800));
        }
        if (p.hasPermission("craftlobby.cloaks.devil")) {
            if (DevilCloak.devilCloaks.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§a§lDevil Cloak", "", "§7Kdyz existuje Andel,", "§7musi i dabel.", "", "§cAktivovano!");
                i = ItemFactory.addGlow(i);
                cloakMenu.setItem(12, i);
            } else {
                ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§a§lDevil Cloak", "", "§7Kdyz existuje Andel,", "§7musi i dabel.", "", "§eKliknutim aktivujes!");
                cloakMenu.setItem(12, i);
            }
        } else {
            cloakMenu.setItem(12, nakup("Devil", 900));
        }
        if (p.hasPermission("craftlobby.cape.majitel")
                || p.hasPermission("craftlobby.cape.admin")
                || p.hasPermission("craftlobby.cape.builder")
                || p.hasPermission("craftlobby.cape.helper")
                || p.hasPermission("craftlobby.cape.vip")
                || p.hasPermission("craftlobby.cape.spirit")) {
            if (RankCape.heroCloaks.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§a§lRank Cape", "", "§7Od VIP ziskas unikatni Cape", "§7se kterou ukazes kdo jsi!", "", "§cAktivovano!");
                i = ItemFactory.addGlow(i);
                cloakMenu.setItem(14, i);
            } else {
                ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§a§lRank Cape", "", "§7Od VIP ziskas unikatni Cape", "§7se kterou ukazes kdo jsi!", "", "§eKliknutim aktivujes!");
                cloakMenu.setItem(14, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lRank Cape", "§7Tato se da ziskat zakoupenim §aMiniGames VIP");
            cloakMenu.setItem(14, i);
        }
        if (p.hasPermission("craftlobby.cape.gigaturnaj2016")) {
            if (TurnajCape.turnajCloaks.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.GOLD_INGOT, (byte) 0, "§6§lGiGa Turnaj Cape", "", "§7Cape pro vsechny zucastnene", "§7na GiGa turnaji 2016", "", "§cAktivovano!");
                i = ItemFactory.addGlow(i);
                cloakMenu.setItem(15, i);
            } else {
                ItemStack i = ItemFactory.create(Material.GOLD_INGOT, (byte) 0, "§6§lGiGa Turnaj Cape", "", "§7Cape pro vsechny zucastnene", "§7na GiGa turnaji 2016", "", "§eKliknutim aktivujes!");
                cloakMenu.setItem(15, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§lGiGa Turnaj Cape", "§7Tuto Cape dostali hraci, kteri se ucastnili GiGaturnaje 2016");
            cloakMenu.setItem(15, i);
        }

        //Zpet do menu
        ItemStack zpet = ItemFactory.create(Material.ARROW, (byte) 0, "§cZpet do Gadgets menu");

        //Deaktivace
        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§c Vypnout cloak ✖", "§7Kliknutim vypnes cloak.");

        //Shop
        ItemStack shopItem = ItemFactory.create(Material.CHEST, (byte) 0, "§a§lGadgets",
                "§7Gadgety jsou doplnky do lobby",
                "§7daji se ziskat z CraftBoxu nebo na",
                "§7specialnich eventech.",
                "",
                "§7Aktualni stav: §6" + Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");

        cloakMenu.setItem(49, shopItem);
        cloakMenu.setItem(40, deaktivace);
        cloakMenu.setItem(39, zpet);

        p.openInventory(cloakMenu);
    }

    @EventHandler
    private void onClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("Cloaks")) {
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 40) {
                deactivateCloaks(p);
                p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 15.0F, 15.0F);
                p.closeInventory();
            }
            if (e.getSlot() == 39) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 49) {
                Main.getInstance().getMainGadgetsMenu().openGadgetsMenu(p);
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("craftlobby.cloaks.santa")) {
                    deactivateCloaks(p);
                    this.santa.activateSanta(p);
                    p.closeInventory();
                } else {
                    ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§a§lSanta Cloak", "", "§7S timto budes vypadat jako", "§7opravdovy santa.");
                    Shop.open(p, "Santa", "craftlobby.cloaks.santa", i, 700);
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("craftlobby.cloaks.angel")) {
                    deactivateCloaks(p);
                    this.angel.activate(p);
                    p.closeInventory();
                } else {
                    ItemStack i = ItemFactory.create(Material.BREAD, (byte) 0, "§a§lAngel Cloak", "", "§7Jako ten pravy andel,", "§7budes vypadat.");
                    Shop.open(p, "Angel", "craftlobby.cloaks.angel", i, 800);
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("craftlobby.cloaks.devil")) {
                    deactivateCloaks(p);
                    this.devil.activate(p);
                    p.closeInventory();
                } else {
                    ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§a§lDevil Cloak", "", "§7Kdyz existuje Andel,", "§7musi i dabel.");
                    Shop.open(p, "Devil", "craftlobby.cloaks.devil", i, 900);
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("craftlobby.cape.majitel")
                        || p.hasPermission("craftlobby.cape.admin")
                        || p.hasPermission("craftlobby.cape.builder")
                        || p.hasPermission("craftlobby.cape.helper")
                        || p.hasPermission("craftlobby.cape.vip")
                        || p.hasPermission("craftlobby.cape.spirit")) {
                    deactivateCloaks(p);
                    this.cape.activate(p);
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "Rank Cape");
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("craftlobby.cape.gigaturnaj2016")) {
                    deactivateCloaks(p);
                    this.tc.activate(p);
                    p.closeInventory();
                } else {
                    this.ml.messageNoPerm(p, "GiGa Turnaj Cape");
                }
            }
        }
    }

    public void deactivateCloaks(Player p) {
        if (SantaCloak.santaCloaks.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) SantaCloak.santaCloaks.get(p.getName())).intValue());
            SantaCloak.santaCloaks.remove(p.getName());
            p.getInventory().setArmorContents(null);
            p.closeInventory();
        }
        if (AngleCloak.angelCloaks.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) AngleCloak.angelCloaks.get(p.getName())).intValue());
            AngleCloak.angelCloaks.remove(p.getName());
            p.getInventory().setArmorContents(null);
            p.closeInventory();
        }
        if (RankCape.heroCloaks.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) RankCape.heroCloaks.get(p.getName())).intValue());
            RankCape.heroCloaks.remove(p.getName());
            p.getInventory().setArmorContents(null);
            p.closeInventory();
        }
        if (TurnajCape.turnajCloaks.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) TurnajCape.turnajCloaks.get(p.getName())).intValue());
            TurnajCape.turnajCloaks.remove(p.getName());
            p.getInventory().setArmorContents(null);
            p.closeInventory();
        }
        if (DevilCloak.devilCloaks.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) DevilCloak.devilCloaks.get(p.getName())).intValue());
            DevilCloak.devilCloaks.remove(p.getName());
            p.getInventory().setArmorContents(null);
            p.closeInventory();
        }
    }

    private ItemStack nakup(final String name, final int price) {
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§c§l" + name, "§7Lze zakoupit za §e" + price + " CC.");
        return i;
    }

}
