package cz.wake.lobby.gui;

import cz.wake.lobby.Main;
import cz.wake.lobby.gadgets.heads.HeadsAPI;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class GadgetsMenu implements Listener {

    HeadsAPI hAPI = new HeadsAPI();

    public void openGadgetsMenu(Player p) {

        Inventory gadgetsMenu = Bukkit.createInventory(null, 54, "Hlavni menu");

        ItemStack petsItem = new ItemStack(Material.BONE);
        ItemMeta petsItemMeta = petsItem.getItemMeta();
        petsItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Pets");
        ArrayList<String> petsLore = new ArrayList<String>();
        petsLore.add(ChatColor.GRAY + "Kliknutim zobrazis vyber tech nejlepsich");
        petsLore.add(ChatColor.GRAY + "zviratek na serveru. Vyber si jednoho a ukaz");
        petsLore.add(ChatColor.GRAY + "vsem ktery je ten nej.");
        petsLore.add(ChatColor.GRAY + "");
        petsLore.add(countPets(p));
        petsLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        petsItemMeta.setLore(petsLore);
        petsItem.setItemMeta(petsItemMeta);

        ItemStack gadgetsItem = new ItemStack(Material.PISTON_BASE, 1);
        ItemMeta gadgetsItemMeta = gadgetsItem.getItemMeta();
        gadgetsItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Gadgets");
        ArrayList<String> gadgetsLore = new ArrayList<String>();
        gadgetsLore.add(ChatColor.GRAY + "Kliknutim si vyberes Gadget");
        gadgetsLore.add(ChatColor.GRAY + "se kterymy se muzes vyradit v");
        gadgetsLore.add(ChatColor.GRAY + "nasem lobby.");
        gadgetsLore.add("");
        gadgetsLore.add(countGadgets(p));
        gadgetsLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        gadgetsItemMeta.setLore(gadgetsLore);
        gadgetsItem.setItemMeta(gadgetsItemMeta);

        ItemStack disguisesItem = new ItemStack(Material.SKULL_ITEM, 1);
        SkullMeta disguisesItemMeta = (SkullMeta) disguisesItem.getItemMeta();
        disguisesItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Morphs (BETA)");
        ArrayList<String> disguisesLore = new ArrayList<String>();
        disguisesLore.add(ChatColor.GRAY + "Premen se a nikdo te nepozna!");
        disguisesLore.add("");
        disguisesLore.add(countMorph(p));
        disguisesLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        disguisesItemMeta.setLore(disguisesLore);
        disguisesItem.setItemMeta(disguisesItemMeta);

        ItemStack particlesItem = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta particlesItemMeta = particlesItem.getItemMeta();
        particlesItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Particles");
        ArrayList<String> particlesLore = new ArrayList<String>();
        particlesLore.add(ChatColor.GRAY + "Kliknutim si vyberes efekt, ktery bude");
        particlesLore.add(ChatColor.GRAY + "poletovat kolem tebe!");
        particlesLore.add("");
        particlesLore.add(countParticles(p));
        particlesLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        particlesItemMeta.setLore(particlesLore);
        particlesItem.setItemMeta(particlesItemMeta);

        ItemStack shopItem = new ItemStack(Material.CHEST, 1);
        ItemMeta shopItemMeta = shopItem.getItemMeta();
        shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
        ArrayList<String> shopLore = new ArrayList<String>();
        shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby,");
        shopLore.add(ChatColor.GRAY + "daji se zakoupit na kazdem lobby");
        shopLore.add(ChatColor.GRAY + "za CraftCoiny");
        shopLore.add("");
        shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().fetchData().getCraftCoins(p.getUniqueId()) + " CC");
        shopItemMeta.setLore(shopLore);
        shopItem.setItemMeta(shopItemMeta);

        ItemStack wardrobeItem = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta wardrobeItemMeta = wardrobeItem.getItemMeta();
        wardrobeItemMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Heads");
        ArrayList<String> wardrobeLore = new ArrayList<String>();
        wardrobeLore.add(ChatColor.GRAY + "Nasad si na hlavu headku a bud");
        wardrobeLore.add(ChatColor.GRAY + "boss v nasem lobby!");
        wardrobeLore.add("");
        wardrobeLore.add(hAPI.counHeadsString(p));
        wardrobeLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        wardrobeItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        wardrobeItemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        wardrobeItemMeta.setLore(wardrobeLore);
        wardrobeItem.setItemMeta(wardrobeItemMeta);

        ItemStack cloaks = new ItemStack(Material.ENCHANTMENT_TABLE);
        ItemMeta cMeta = cloaks.getItemMeta();
        cMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Cloaks");
        ArrayList<String> cLore = new ArrayList<String>();
        cLore.add(ChatColor.GRAY + "Efekty, obleky vse v");
        cLore.add(ChatColor.GRAY + "jednom co ti dodaji pravy");
        cLore.add(ChatColor.GRAY + "SWAG!");
        cLore.add("");
        cLore.add(countCloaks(p));
        cLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        cMeta.setLore(cLore);
        cloaks.setItemMeta(cMeta);

        ItemStack suits = ItemFactory.create(Material.DIAMOND_CHESTPLATE, (byte) 0, "§b§lSuits", "", "§7Obleky, ktere zmeni", "§7tvuj pohled na svet!", "", "§c▸ Jiz brzy!");

        gadgetsMenu.setItem(10, wardrobeItem);
        gadgetsMenu.setItem(12, penguin(p));
        gadgetsMenu.setItem(14, suits);
        gadgetsMenu.setItem(16, cloaks);
        gadgetsMenu.setItem(28, petsItem);
        gadgetsMenu.setItem(30, gadgetsItem);
        gadgetsMenu.setItem(32, disguisesItem);
        gadgetsMenu.setItem(34, particlesItem);
        gadgetsMenu.setItem(49, shopItem);

        p.openInventory(gadgetsMenu);

    }

    public String getStatusBox(Player p) {
        long time = System.currentTimeMillis();
        long pTime = Main.getInstance().fetchData().getTimeToBuy(p.getUniqueId());

        if (time > pTime) {
            return "§a§lIHNED";
        } else {
            return "za §b" + TimeUtils.formatTime("%hh %mm", ((pTime - time) / 1000) / 60, false);
        }
    }

    private String countCloaks(Player p) {
        int cloaks = getCoaksCount(p);
        int sum = 3;
        int prc = (cloaks * 100 / sum);

        return "§7Odemknuto: §f" + cloaks + "/" + sum + " §8(" + prc + "%)";
    }

    private String countParticles(Player p) {
        int part = getParticlesCount(p);
        int sum = 19;
        int prc = (part * 100 / sum);

        return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
    }

    private String countPets(Player p) {
        int part = getPetsCount(p);
        int sum = 162;
        int prc = (part * 100 / sum);

        return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
    }

    private String countGadgets(Player p) {
        int part = getGadgetsCount(p);
        int sum = 27;
        int prc = (part * 100 / sum);

        return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
    }

    private String countBanners(Player p) {
        int part = getBannerCount(p);
        int sum = 19;
        int prc = (part * 100 / sum);

        return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
    }

    private String countMorph(Player p) {
        int part = getMorphsCount(p);
        int sum = 3;
        int prc = (part * 100 / sum);

        return "§7Odemknuto: §f" + part + "/" + sum + " §8(" + prc + "%)";
    }

    private int getMorphsCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.morphs.pig")) {
            c++;
        }
        if (p.hasPermission("craftlobby.morphs.villager")) {
            c++;
        }
        if (p.hasPermission("craftlobby.morphs.irongolem")) {
            c++;
        }
        return c;
    }

    private int getBannerCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.banner.tardis")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.duck")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.king")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.creeper")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.rabbit")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.panda")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.assassin")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.dragon")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.slime")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.bumbum")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.zoidberg")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.smile")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.bear")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.grumpy")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.pencil")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.batman")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.twitch")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.penguin")) {
            c++;
        }
        if (p.hasPermission("craftlobby.banner.thunder")) {
            c++;
        }
        return c;
    }

    private int getGadgetsCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.gadgets.teleportstick")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.funcannon")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.colorbomb")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.cookiefountain")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.chikenator")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.pee")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.pigfly")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.firework")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.poopbomb")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.tnt")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.slimehat")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.withercatapult")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.discoball")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.blizzardblaster")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.ghosts")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.tsunami")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.batblaster")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.trampoline")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.explosivesheep")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.flowerpopper")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.funcannon.ender")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.antigravity")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.blackhole")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.diamondfountain")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.rocket")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.parachute")) {
            c++;
        }
        if (p.hasPermission("craftlobby.gadgets.snowball")) {
            c++;
        }
        return c;
    }

    private int getPetsCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.pets.cat.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.red")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.siamese")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.red.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.siamese.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.wild")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cat.wild.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.pig")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.pig.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.chicken")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.chicken.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.wolf")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.wolf.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.slime.small")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.slime.normal")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.slime.big")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.blacksmith")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.blacksmith.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.butcher")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.butcher.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.farmer")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.farmer.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.librarian")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.librarian.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.priest")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.villager.priest.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.blackandwhite")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.blackandwhite.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.brown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.brown.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.saltandpepper")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.saltandpepper.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.killer")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.killer.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.white")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.white.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.gold")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.rabbit.gold")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.husk")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.husk.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.blacksmith")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.butcher")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.farmer")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.librarian")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.zombie.priest")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.white")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.white.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.blue")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.blue.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.brown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.brown.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.cyan")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.cyan.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.green")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.green.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.lightblue")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.lightblue.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.lime")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.lime.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.magenta")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.magenta.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.orange")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.orange.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.pink")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.pink.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.purple")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.purple.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.red")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.red.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.silver")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.silver.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.yellow")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.yellow.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.gray")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.sheep.gray.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.brown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.brown.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.chestnut")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.chestnut.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.creamy")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.creamy.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.darkbrown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.darkbrown.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.gray")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.gray.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.white")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.white.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.donkey")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.mule")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.zombie")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.horse.skeleton")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.creeper")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.creeper.powered")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.skeleton")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.skeleton.wither")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.magmacube.small")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.magmacube.normal")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.magmacube.big")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.polarbear")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.polarbear.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.endermite")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.silverfish")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.wither")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.spider")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cavespider")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.irongolem")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.witch")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.enderman")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.blaze")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.bat")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.snowman")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.guardian")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.guardian.elder")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.mushroom")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.cow.mushroom.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.vindicator")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.white")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.orange")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.magenta")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lightblue")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.yellow")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lime")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.pink")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.gray")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lightgray")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.cyan")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.purple")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.blue")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.brown")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.green")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.red")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.black")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.white.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.orange.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.magenta.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lightblue.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.yellow.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lime.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.pink.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.gray.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.lightgray.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.cyan.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.purple.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.blue.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.brown.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.green.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.red.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.llama.black.baby")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.vex")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.evoker")) {
            c++;
        }
        if (p.hasPermission("craftlobby.pets.vindicator")) {
            c++;
        }
        return c;
    }

    private int getParticlesCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.particles.frostlord")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.flamerings")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.snowclouds")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.rainclouds")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.bloodhelix")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.greensparks")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.endersignal")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.enchanted")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.love")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.notes")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.clouds")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.coloreddust")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.lavapop")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.portal")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.spell")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.frozenwalk")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.lilly")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.santahat")) {
            c++;
        }
        if (p.hasPermission("craftlobby.particles.candycane")) {
            c++;
        }
        return c;
    }

    private int getCoaksCount(Player p) {
        int c = 0;
        if (p.hasPermission("craftlobby.cloaks.santa")) {
            c++;
        }
        if (p.hasPermission("craftlobby.cloaks.angel")) {
            c++;
        }
        if (p.hasPermission("craftlobby.cloaks.hero")) {
            c++;
        }
        return c;
    }

    private ItemStack penguin(Player p) {
        ItemStack b = new ItemStack(Material.BANNER);
        BannerMeta bm = (BannerMeta) b.getItemMeta();
        bm.setBaseColor(DyeColor.BLACK);
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.FLOWER));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL_MIRROR));
        bm.addPattern(new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_BOTTOM));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.RHOMBUS_MIDDLE));
        bm.addPattern(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_TOP));
        bm.addPattern(new Pattern(DyeColor.ORANGE, PatternType.CIRCLE_MIDDLE));
        bm.setDisplayName("§b§lBanners");
        ArrayList<String> mLore = new ArrayList<String>();
        mLore.add(ChatColor.GRAY + "Nasad si na hlavu banner");
        mLore.add(ChatColor.GRAY + "jako nejvetsi borec!");
        mLore.add("");
        mLore.add(countBanners(p));
        mLore.add(ChatColor.YELLOW + "▸ Kliknutim zobrazis vyber");
        bm.setLore(mLore);
        bm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        b.setItemMeta(bm);
        return b;
    }

}
