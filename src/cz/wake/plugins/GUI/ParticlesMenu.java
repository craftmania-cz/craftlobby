package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.API.Glow;
import cz.wake.plugins.particles.GreenSparks;

public class ParticlesMenu implements Listener{
	
	GreenSparks gs = new GreenSparks();
	
	public void openParticles(Player p){
		
		Inventory pInv = Bukkit.createInventory(null, 54, "Particles");
		
		if(p.hasPermission("craftlobby.particles.greensparks")){
			if(gs.greenSparksPlayers.contains(p)){
				ItemStack sparks = new ItemStack(Material.EMERALD);
				ItemMeta sMeta = sparks.getItemMeta();
				sMeta.setDisplayName(ChatColor.GREEN + "GreenSparks");
				Glow glow = new Glow(70);
				sMeta.addEnchant(glow, 1, true);
				sparks.setItemMeta(sMeta);
				pInv.setItem(15, sparks);
			} else {
				ItemStack sparks = new ItemStack(Material.EMERALD);
				ItemMeta sMeta = sparks.getItemMeta();
				sMeta.setDisplayName(ChatColor.GREEN + "GreenSparks");
				sparks.setItemMeta(sMeta);
				pInv.setItem(15, sparks);
			}
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "GreenSparks");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(15, noPerm);
		}
		
		ItemStack frost = new ItemStack(Material.ICE);
		ItemMeta fMeta = frost.getItemMeta();
		fMeta.setDisplayName(ChatColor.GREEN + "FrostLord");
		frost.setItemMeta(fMeta);
		
		ItemStack flames = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta flMeta = flames.getItemMeta();
		flMeta.setDisplayName(ChatColor.GREEN + "FlameRings");
		flames.setItemMeta(flMeta);
		
		ItemStack snowcloud = new ItemStack(Material.SNOW_BALL);
		ItemMeta snowMeta = snowcloud.getItemMeta();
		snowMeta.setDisplayName(ChatColor.GREEN + "SnowClouds");
		snowcloud.setItemMeta(snowMeta);
		
		ItemStack raincloud = new ItemStack(Material.WATER_BUCKET);
		ItemMeta rMeta = raincloud.getItemMeta();
		rMeta.setDisplayName(ChatColor.GREEN + "RainClouds");
		raincloud.setItemMeta(rMeta);
		
		ItemStack helix = new ItemStack(Material.REDSTONE);
		ItemMeta hMeta = helix.getItemMeta();
		hMeta.setDisplayName(ChatColor.GREEN + "BloodHelix");
		helix.setItemMeta(hMeta);
		
		ItemStack steps = new ItemStack(Material.ENDER_PORTAL_FRAME);
		ItemMeta stepsMeta = steps.getItemMeta();
		stepsMeta.setDisplayName(ChatColor.GREEN + "EnderSignal");
		steps.setItemMeta(stepsMeta);
		
		ItemStack enchanted = new ItemStack(Material.BOOK);
		ItemMeta eMeta = enchanted.getItemMeta();
		eMeta.setDisplayName(ChatColor.GREEN + "Enchanted");
		enchanted.setItemMeta(eMeta);
		
		ItemStack love = new ItemStack(Material.RED_ROSE);
		ItemMeta lMeta = love.getItemMeta();
		lMeta.setDisplayName(ChatColor.GREEN + "Love");
		love.setItemMeta(lMeta);
		
		ItemStack notes = new ItemStack(Material.JUKEBOX);
		ItemMeta nMeta = notes.getItemMeta();
		nMeta.setDisplayName(ChatColor.GREEN + "Notes");
		notes.setItemMeta(nMeta);
		
		ItemStack clouds = new ItemStack(Material.QUARTZ);
		ItemMeta cMeta = clouds.getItemMeta();
		cMeta.setDisplayName(ChatColor.GREEN + "Clouds");
		clouds.setItemMeta(cMeta);
		
		ItemStack dust = new ItemStack(Material.WOOL,1,(byte)9);
		ItemMeta dMeta = dust.getItemMeta();
		dMeta.setDisplayName(ChatColor.GREEN + "ColoredDust");
		dust.setItemMeta(dMeta);
		
		ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta laMeta = lava.getItemMeta();
		laMeta.setDisplayName(ChatColor.GREEN + "LavaPop");
		lava.setItemMeta(laMeta);
		
		ItemStack portal = new ItemStack(Material.ENDER_PEARL);
		ItemMeta pMeta = portal.getItemMeta();
		pMeta.setDisplayName(ChatColor.GREEN + "Portal");
		portal.setItemMeta(pMeta);
		
		ItemStack spell = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta spMeta = spell.getItemMeta();
		spMeta.setDisplayName(ChatColor.GREEN + "Spell");
		spell.setItemMeta(spMeta);
		
		ItemStack walker = new ItemStack(Material.SNOW_BLOCK);
		ItemMeta walkerMeta = walker.getItemMeta();
		walkerMeta.setDisplayName(ChatColor.GREEN + "FrozenWalk");
		walker.setItemMeta(walkerMeta);
		
		ItemStack lilly = new ItemStack(Material.WATER_LILY);
		ItemMeta liMeta = lilly.getItemMeta();
		liMeta.setDisplayName(ChatColor.GREEN + "Lilly");
		lilly.setItemMeta(liMeta);
		
		ItemStack wings = new ItemStack(Material.SUGAR_CANE);
		ItemMeta wMeta = wings.getItemMeta();
		wMeta.setDisplayName(ChatColor.GREEN + "Wings");
		wings.setItemMeta(wMeta);
		
		ItemStack hero = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta heMeta = hero.getItemMeta();
		heMeta.setDisplayName(ChatColor.GREEN + "SuperHero");
		hero.setItemMeta(heMeta);
		
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
		
		ItemStack shopItem = new ItemStack(Material.CHEST,1);
		ItemMeta shopItemMeta = shopItem.getItemMeta();
		shopItemMeta.setDisplayName(ChatColor.GREEN + "Shop");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Kliknutim si otevres shop");
		shopLore.add(ChatColor.GRAY + "kde si muzes nakoupit za CC");
		shopLore.add(ChatColor.GRAY + "nove hats, gadgets, trails atd.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.YELLOW + "0 CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		pInv.setItem(10, frost);
		pInv.setItem(11, flames);
		pInv.setItem(12, snowcloud);
		pInv.setItem(13, raincloud);
		pInv.setItem(14, helix);
		pInv.setItem(16, steps);
		
		pInv.setItem(19, enchanted);
		pInv.setItem(20, love);
		pInv.setItem(21, notes);
		pInv.setItem(22, clouds);
		pInv.setItem(23, dust);
		pInv.setItem(24, lava);
		pInv.setItem(25, portal);
		
		pInv.setItem(28, spell);
		pInv.setItem(29, walker);
		pInv.setItem(30, lilly);
		pInv.setItem(31, hero);
		pInv.setItem(32, wings);
		
		pInv.setItem(49, shopItem);
		pInv.setItem(40, deaktivace);
		pInv.setItem(39, zpet);
		
		p.openInventory(pInv);
	}

}
