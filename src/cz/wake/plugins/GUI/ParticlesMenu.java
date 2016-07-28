package cz.wake.plugins.GUI;

import cz.wake.plugins.Main;
import cz.wake.plugins.particles.*;
import cz.wake.plugins.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ParticlesMenu {

    GreenSparks gs = new GreenSparks();

    public void openParticles(Player p) {

        Inventory pInv = Bukkit.createInventory(null, 54, "Particles");

        if (p.hasPermission("craftlobby.particles.greensparks")) {
            if (GreenSparks.greenPlayers.containsKey(p.getName())) {
                ItemStack sparks = new ItemStack(Material.EMERALD);
                sparks = ItemFactory.addGlow(sparks);
                ItemMeta sMeta = sparks.getItemMeta();
                sMeta.setDisplayName("§a§lGreenSparks");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes kruhovy");
                lore.add("§7Villager Happy efekt.");
                lore.add("");
                lore.add("§cAktivovano");
                sMeta.setLore(lore);
                sparks.setItemMeta(sMeta);
                pInv.setItem(15, sparks);
            } else {
                ItemStack sparks = new ItemStack(Material.EMERALD);
                ItemMeta sMeta = sparks.getItemMeta();
                sMeta.setDisplayName("§a§lGreenSparks");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes kruhovy");
                lore.add("§7Villager Happy efekt.");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                sMeta.setLore(lore);
                sparks.setItemMeta(sMeta);
                pInv.setItem(15, sparks);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lGreenSparks");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(15, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.frostlord")) {
            if (FrostLord.fl.containsKey(p.getName())) {
                ItemStack frost = new ItemStack(Material.ICE);
                frost = ItemFactory.addGlow(frost);
                ItemMeta fMeta = frost.getItemMeta();
                fMeta.setDisplayName("§a§lFrostLord");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes snezny");
                lore.add("§7efekt pro opravdove borce!");
                lore.add("");
                lore.add("§cAktivovano");
                fMeta.setLore(lore);
                frost.setItemMeta(fMeta);
                pInv.setItem(10, frost);
            } else {
                ItemStack frost = new ItemStack(Material.ICE);
                ItemMeta fMeta = frost.getItemMeta();
                fMeta.setDisplayName("§a§lFrostLord");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes snezny");
                lore.add("§7efekt pro opravdove borce!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                fMeta.setLore(lore);
                frost.setItemMeta(fMeta);
                pInv.setItem(10, frost);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lFrostLord");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(10, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.flamerings")) {
            if (FlameRings.fr.containsKey(p.getName())) {
                ItemStack flames = new ItemStack(Material.BLAZE_POWDER);
                flames = ItemFactory.addGlow(flames);
                ItemMeta flMeta = flames.getItemMeta();
                flMeta.setDisplayName("§a§lFlameRings");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes ohnivy");
                lore.add("§7efekt pro opravdove borce!");
                lore.add("");
                lore.add("§cAktivovano");
                flMeta.setLore(lore);
                flames.setItemMeta(flMeta);
                pInv.setItem(11, flames);
            } else {
                ItemStack flames = new ItemStack(Material.BLAZE_POWDER);
                ItemMeta flMeta = flames.getItemMeta();
                flMeta.setDisplayName("§a§lFlameRings");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes ohnivy");
                lore.add("§7efekt pro opravdove borce!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                flMeta.setLore(lore);
                flames.setItemMeta(flMeta);
                pInv.setItem(11, flames);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lFlameRings");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(11, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.snowclouds")) {
            if (SnowCloud.sc.containsKey(p.getName())) {
                ItemStack snowcloud = new ItemStack(Material.SNOW_BALL);
                snowcloud = ItemFactory.addGlow(snowcloud);
                ItemMeta snowMeta = snowcloud.getItemMeta();
                snowMeta.setDisplayName("§a§lSnowClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes snezne");
                lore.add("§7mracky nad hlavu, tak bacha");
                lore.add("§7at te nezasnezi!");
                lore.add("");
                lore.add("§cAktivovano");
                snowMeta.setLore(lore);
                snowcloud.setItemMeta(snowMeta);
                pInv.setItem(12, snowcloud);
            } else {
                ItemStack snowcloud = new ItemStack(Material.SNOW_BALL);
                ItemMeta snowMeta = snowcloud.getItemMeta();
                snowMeta.setDisplayName("§a§lSnowClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes snezne");
                lore.add("§7mracky nad hlavu, tak bacha");
                lore.add("§7at te nezasnezi!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                snowMeta.setLore(lore);
                snowcloud.setItemMeta(snowMeta);
                pInv.setItem(12, snowcloud);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lSnowClouds");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(12, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.rainclouds")) {
            if (RainCloud.rc.containsKey(p.getName())) {
                ItemStack raincloud = new ItemStack(Material.WATER_BUCKET);
                raincloud = ItemFactory.addGlow(raincloud);
                ItemMeta rMeta = raincloud.getItemMeta();
                rMeta.setDisplayName("§a§lRainClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes bourku a");
                lore.add("§7mracky nad hlavu, tak bacha");
                lore.add("§7ne blesky!");
                lore.add("");
                lore.add("§cAktivovano");
                rMeta.setLore(lore);
                raincloud.setItemMeta(rMeta);
                pInv.setItem(13, raincloud);
            } else {
                ItemStack raincloud = new ItemStack(Material.WATER_BUCKET);
                ItemMeta rMeta = raincloud.getItemMeta();
                rMeta.setDisplayName("§a§lRainClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes bourku a");
                lore.add("§7mracky nad hlavu, tak bacha");
                lore.add("§7ne blesky!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                rMeta.setLore(lore);
                raincloud.setItemMeta(rMeta);
                pInv.setItem(13, raincloud);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lRainClouds");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(13, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.bloodhelix")) {
            if (BloodHelix.bh.containsKey(p.getName())) {
                ItemStack helix = new ItemStack(Material.REDSTONE);
                helix = ItemFactory.addGlow(helix);
                ItemMeta hMeta = helix.getItemMeta();
                hMeta.setDisplayName("§a§lBloodHelix");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes jeden z");
                lore.add("§7nejlepsich efektu na lobby!");
                lore.add("");
                lore.add("§cAktivovano");
                hMeta.setLore(lore);
                helix.setItemMeta(hMeta);
                pInv.setItem(14, helix);
            } else {
                ItemStack helix = new ItemStack(Material.REDSTONE);
                ItemMeta hMeta = helix.getItemMeta();
                hMeta.setDisplayName("§a§lBloodHelix");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes jeden z");
                lore.add("§7nejlepsich efektu na lobby!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                hMeta.setLore(lore);
                helix.setItemMeta(hMeta);
                pInv.setItem(14, helix);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lBloodHelix");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(14, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.endersignal")) {
            if (EnderSignal.es.containsKey(p.getName())) {
                ItemStack steps = new ItemStack(Material.EYE_OF_ENDER);
                steps = ItemFactory.addGlow(steps);
                ItemMeta stepsMeta = steps.getItemMeta();
                stepsMeta.setDisplayName("§a§lEnderSignal");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt z Endu,");
                lore.add("§7tak pozor aby to nebyl tvuj end!");
                lore.add("");
                lore.add("§cAktivovano");
                stepsMeta.setLore(lore);
                steps.setItemMeta(stepsMeta);
                pInv.setItem(16, steps);
            } else {
                ItemStack steps = new ItemStack(Material.EYE_OF_ENDER);
                ItemMeta stepsMeta = steps.getItemMeta();
                stepsMeta.setDisplayName("§a§lEnderSignal");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt z Endu,");
                lore.add("§7tak pozor aby to nebyl tvuj end!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                stepsMeta.setLore(lore);
                steps.setItemMeta(stepsMeta);
                pInv.setItem(16, steps);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lEnderSignal");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(16, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.enchanted")) {
            if (Enchanted.e.containsKey(p.getName())) {
                ItemStack enchanted = new ItemStack(Material.BOOK);
                enchanted = ItemFactory.addGlow(enchanted);
                ItemMeta eMeta = enchanted.getItemMeta();
                eMeta.setDisplayName("§a§lEnchanted");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt Enchanted,");
                lore.add("§7ne opravdu to nejsou vedomosti,");
                lore.add("§7pouze pismenka.");
                lore.add("");
                lore.add("§cAktivovano");
                eMeta.setLore(lore);
                enchanted.setItemMeta(eMeta);
                pInv.setItem(19, enchanted);
            } else {
                ItemStack enchanted = new ItemStack(Material.BOOK);
                ItemMeta eMeta = enchanted.getItemMeta();
                eMeta.setDisplayName("§a§lEnchanted");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt Enchanted,");
                lore.add("§7ne opravdu to nejsou vedomosti,");
                lore.add("§7pouze pismenka.");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                eMeta.setLore(lore);
                enchanted.setItemMeta(eMeta);
                pInv.setItem(19, enchanted);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lEnchanted");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(19, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.love")) {
            if (Love.l.containsKey(p.getName())) {
                ItemStack love = new ItemStack(Material.RED_ROSE);
                love = ItemFactory.addGlow(love);
                ItemMeta lMeta = love.getItemMeta();
                lMeta.setDisplayName("§a§lLove");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt se srdicky,");
                lore.add("§7tak bacha na lasku a seznamky.");
                lore.add("");
                lore.add("§cAktivovano");
                lMeta.setLore(lore);
                love.setItemMeta(lMeta);
                pInv.setItem(20, love);
            } else {
                ItemStack love = new ItemStack(Material.RED_ROSE);
                ItemMeta lMeta = love.getItemMeta();
                lMeta.setDisplayName("§a§lLove");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim zapnes efekt se srdicky,");
                lore.add("§7tak bacha na lasku a seznamky.");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                lMeta.setLore(lore);
                love.setItemMeta(lMeta);
                pInv.setItem(20, love);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lLove");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(20, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.notes")) {
            if (Notes.no.containsKey(p.getName())) {
                ItemStack notes = new ItemStack(Material.JUKEBOX);
                notes = ItemFactory.addGlow(notes);
                ItemMeta nMeta = notes.getItemMeta();
                nMeta.setDisplayName("§a§lNotes");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s notami,");
                lore.add("§7budes vypadat jako opravdovy zpevak!");
                lore.add("");
                lore.add("§cAktivovano");
                nMeta.setLore(lore);
                notes.setItemMeta(nMeta);
                pInv.setItem(21, notes);
            } else {
                ItemStack notes = new ItemStack(Material.JUKEBOX);
                ItemMeta nMeta = notes.getItemMeta();
                nMeta.setDisplayName("§a§lNotes");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s notami,");
                lore.add("§7budes vypadat jako opravdovy zpevak!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                nMeta.setLore(lore);
                notes.setItemMeta(nMeta);
                pInv.setItem(21, notes);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lNotes");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(21, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.clouds")) {
            if (Clouds.c.containsKey(p.getName())) {
                ItemStack clouds = new ItemStack(Material.QUARTZ);
                clouds = ItemFactory.addGlow(clouds);
                ItemMeta cMeta = clouds.getItemMeta();
                cMeta.setDisplayName("§a§lClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s mraky,");
                lore.add("§7snad se neztratis.");
                lore.add("");
                lore.add("§cAktivovano");
                cMeta.setLore(lore);
                clouds.setItemMeta(cMeta);
                pInv.setItem(22, clouds);
            } else {
                ItemStack clouds = new ItemStack(Material.QUARTZ);
                ItemMeta cMeta = clouds.getItemMeta();
                cMeta.setDisplayName("§a§lClouds");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s mraky,");
                lore.add("§7snad se neztratis.");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                cMeta.setLore(lore);
                clouds.setItemMeta(cMeta);
                pInv.setItem(22, clouds);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lClouds");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(22, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.coloreddust")) {
            if (ColoredDust.cd.containsKey(p.getName())) {
                ItemStack dust = new ItemStack(Material.WOOL, 1, (byte) 9);
                dust = ItemFactory.addGlow(dust);
                ItemMeta dMeta = dust.getItemMeta();
                dMeta.setDisplayName("§a§lColoredDust");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s barvami,");
                lore.add("§7skoro jako duha!");
                lore.add("");
                lore.add("§cAktivovano");
                dMeta.setLore(lore);
                dust.setItemMeta(dMeta);
                pInv.setItem(23, dust);
            } else {
                ItemStack dust = new ItemStack(Material.WOOL, 1, (byte) 9);
                ItemMeta dMeta = dust.getItemMeta();
                dMeta.setDisplayName("§a§lColoredDust");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s barvami,");
                lore.add("§7skoro jako duha!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                dMeta.setLore(lore);
                dust.setItemMeta(dMeta);
                pInv.setItem(23, dust);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lColoredDust");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(23, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.lavapop")) {
            if (LavaPop.lp.containsKey(p.getName())) {
                ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
                lava = ItemFactory.addGlow(lava);
                ItemMeta laMeta = lava.getItemMeta();
                laMeta.setDisplayName("§a§lLavaPop");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s lavou,");
                lore.add("§7hlavne do ni neskoc, kdo by tu pak hral?!");
                lore.add("");
                lore.add("§cAktivovano");
                laMeta.setLore(lore);
                lava.setItemMeta(laMeta);
                pInv.setItem(24, lava);
            } else {
                ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
                ItemMeta laMeta = lava.getItemMeta();
                laMeta.setDisplayName("§a§lLavaPop");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s lavou,");
                lore.add("§7hlavne do ni neskoc, kdo by tu pak hral?!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                laMeta.setLore(lore);
                lava.setItemMeta(laMeta);
                pInv.setItem(24, lava);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lLavaPop");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(24, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.portal")) {
            if (Portal.port.containsKey(p.getName())) {
                ItemStack portal = new ItemStack(Material.OBSIDIAN);
                portal = ItemFactory.addGlow(portal);
                ItemMeta pMeta = portal.getItemMeta();
                pMeta.setDisplayName("§a§lPortal");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s portalem,");
                lore.add("§7no portal to nevytvori ale ani to nevadi!");
                lore.add("");
                lore.add("§cAktivovano");
                pMeta.setLore(lore);
                portal.setItemMeta(pMeta);
                pInv.setItem(25, portal);
            } else {
                ItemStack portal = new ItemStack(Material.OBSIDIAN);
                ItemMeta pMeta = portal.getItemMeta();
                pMeta.setDisplayName("§a§lPortal");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt s portalem,");
                lore.add("§7no portal to nevytvori ale ani to nevadi!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                pMeta.setLore(lore);
                portal.setItemMeta(pMeta);
                pInv.setItem(25, portal);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lPortal");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(25, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.spell")) {
            if (MobSpell.ms.containsKey(p.getName())) {
                ItemStack spell = new ItemStack(Material.POTION);
                spell = ItemFactory.addGlow(spell);
                ItemMeta spMeta = spell.getItemMeta();
                spMeta.setDisplayName("§a§lSpell");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7ktery nevime jak pojmenovat!");
                lore.add("");
                lore.add("§cAktivovano");
                spMeta.setLore(lore);
                spell.setItemMeta(spMeta);
                pInv.setItem(28, spell);
            } else {
                ItemStack spell = new ItemStack(Material.POTION);
                ItemMeta spMeta = spell.getItemMeta();
                spMeta.setDisplayName("§a§lSpell");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7ktery nevime jak pojmenovat!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                spMeta.setLore(lore);
                spell.setItemMeta(spMeta);
                pInv.setItem(28, spell);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lSpell");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(28, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.frozenwalk")) {
            if (FrozenWalk.fw.containsKey(p.getName())) {
                ItemStack walker = new ItemStack(Material.SNOW_BLOCK);
                walker = ItemFactory.addGlow(walker);
                ItemMeta walkerMeta = walker.getItemMeta();
                walkerMeta.setDisplayName("§a§lFrozenWalk");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7a pokud budes chodit bude pod");
                lore.add("§7tebou padat snih!");
                lore.add("");
                lore.add("§cAktivovano");
                walkerMeta.setLore(lore);
                walker.setItemMeta(walkerMeta);
                pInv.setItem(29, walker);
            } else {
                ItemStack walker = new ItemStack(Material.SNOW_BLOCK);
                ItemMeta walkerMeta = walker.getItemMeta();
                walkerMeta.setDisplayName("§a§lFrozenWalk");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7a pokud budes chodit bude pod");
                lore.add("§7tebou padat snih!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                walkerMeta.setLore(lore);
                walker.setItemMeta(walkerMeta);
                pInv.setItem(29, walker);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lFrozenWalk");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(29, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.lilly")) {
            if (Lily.li.containsKey(p.getName())) {
                ItemStack lilly = new ItemStack(Material.WATER_LILY);
                lilly = ItemFactory.addGlow(lilly);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lLilly");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7co vypada krute!");
                lore.add("");
                lore.add("§cAktivovano");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(30, lilly);
            } else {
                ItemStack lilly = new ItemStack(Material.WATER_LILY);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lLilly");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Kliknutim aktivujes efekt,");
                lore.add("§7co vypada krute!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(30, lilly);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lLilly");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(30, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.santahat")) {
            if (SantaHat.sh.containsKey(p.getName())) {
                ItemStack lilly = new ItemStack(Material.INK_SACK, 1, (byte) 1);
                lilly = ItemFactory.addGlow(lilly);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lSantaHat");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Ziskano hranim o Vanocich na");
                lore.add("§7CraftManii.");
                lore.add("");
                lore.add("§cAktivovano");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(31, lilly);
            } else {
                ItemStack lilly = new ItemStack(Material.INK_SACK, 1, (byte) 1);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lSantaHat");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Ziskano hranim o Vanocich na");
                lore.add("§7CraftManii.");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(31, lilly);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lSantaHat");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(31, noPerm);
        }
        if (p.hasPermission("craftlobby.particles.candycane")) {
            if (CandyCane.cd.containsKey(p.getName())) {
                ItemStack lilly = new ItemStack(Material.INK_SACK, 1, (byte) 2);
                lilly = ItemFactory.addGlow(lilly);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lCandyCane");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Efekt drticich se bombonku!");
                lore.add("");
                lore.add("§cAktivovano");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(32, lilly);
            } else {
                ItemStack lilly = new ItemStack(Material.INK_SACK, 1, (byte) 2);
                ItemMeta liMeta = lilly.getItemMeta();
                liMeta.setDisplayName("§a§lCandyCane");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("");
                lore.add("§7Efekt drticich se bombonku!");
                lore.add("");
                lore.add("§eKliknutim aktivujes!");
                liMeta.setLore(lore);
                lilly.setItemMeta(liMeta);
                pInv.setItem(32, lilly);
            }
        } else {
            ItemStack noPerm = new ItemStack(Material.INK_SACK, 1, (byte) 8);
            ItemMeta noPermMeta = noPerm.getItemMeta();
            noPermMeta.setDisplayName("§c§lCandyCane");
            ArrayList<String> noPermLore = new ArrayList<String>();
            noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
            noPermMeta.setLore(noPermLore);
            noPerm.setItemMeta(noPermMeta);
            pInv.setItem(32, noPerm);
        }
        ItemStack zpet = new ItemStack(Material.ARROW);
        ItemMeta zpetMeta = zpet.getItemMeta();
        zpetMeta.setDisplayName(ChatColor.RED + "Zpet do menu");
        zpet.setItemMeta(zpetMeta);

        ItemStack deaktivace = new ItemStack(Material.BARRIER);
        ItemMeta deaktivaceMeta = deaktivace.getItemMeta();
        deaktivaceMeta.setDisplayName(ChatColor.RED + "✖ Deaktivace ✖");
        ArrayList<String> deaktivaceLore = new ArrayList<String>();
        deaktivaceLore.add(ChatColor.GRAY + "Kliknutim deaktivujes gadget.");
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


        pInv.setItem(49, shopItem);
        pInv.setItem(40, deaktivace);
        pInv.setItem(39, zpet);

        p.openInventory(pInv);
    }

}
