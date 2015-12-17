package cz.wake.plugins.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.wake.plugins.Main;
import cz.wake.plugins.particles.GreenSparks;

public class ParticlesMenu{
	
	GreenSparks gs = new GreenSparks();
	
	public void openParticles(Player p){
		
		Inventory pInv = Bukkit.createInventory(null, 54, "Particles");
		
		if(p.hasPermission("craftlobby.particles.greensparks")){
			ItemStack sparks = new ItemStack(Material.EMERALD);
			ItemMeta sMeta = sparks.getItemMeta();
			sMeta.setDisplayName(ChatColor.GREEN + "GreenSparks");
			sparks.setItemMeta(sMeta);
			pInv.setItem(15, sparks);
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
		if(p.hasPermission("craftlobby.particles.frostlord")){
			ItemStack frost = new ItemStack(Material.ICE);
			ItemMeta fMeta = frost.getItemMeta();
			fMeta.setDisplayName(ChatColor.GREEN + "FrostLord");
			frost.setItemMeta(fMeta);
			pInv.setItem(10, frost);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "FrostLord");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.flamerings")){
			ItemStack flames = new ItemStack(Material.BLAZE_POWDER);
			ItemMeta flMeta = flames.getItemMeta();
			flMeta.setDisplayName(ChatColor.GREEN + "FlameRings");
			flames.setItemMeta(flMeta);
			pInv.setItem(11, flames);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "FlameRings");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.snowclouds")){
			ItemStack snowcloud = new ItemStack(Material.SNOW_BALL);
			ItemMeta snowMeta = snowcloud.getItemMeta();
			snowMeta.setDisplayName(ChatColor.GREEN + "SnowClouds");
			snowcloud.setItemMeta(snowMeta);
			pInv.setItem(12, snowcloud);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "SnowClouds");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.rainclouds")){
			ItemStack raincloud = new ItemStack(Material.WATER_BUCKET);
			ItemMeta rMeta = raincloud.getItemMeta();
			rMeta.setDisplayName(ChatColor.GREEN + "RainClouds");
			raincloud.setItemMeta(rMeta);
			pInv.setItem(13, raincloud);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "RainClouds");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.bloodhelix")){
			ItemStack helix = new ItemStack(Material.REDSTONE);
			ItemMeta hMeta = helix.getItemMeta();
			hMeta.setDisplayName(ChatColor.GREEN + "BloodHelix");
			helix.setItemMeta(hMeta);
			pInv.setItem(14, helix);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "BloodHelix");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.endersignal")){
			ItemStack steps = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta stepsMeta = steps.getItemMeta();
			stepsMeta.setDisplayName(ChatColor.GREEN + "EnderSignal");
			steps.setItemMeta(stepsMeta);
			pInv.setItem(16, steps);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "EnderSignal");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.enchanted")){
			ItemStack enchanted = new ItemStack(Material.BOOK);
			ItemMeta eMeta = enchanted.getItemMeta();
			eMeta.setDisplayName(ChatColor.GREEN + "Enchanted");
			enchanted.setItemMeta(eMeta);
			pInv.setItem(19, enchanted);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Enchanted");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.love")){
			ItemStack love = new ItemStack(Material.RED_ROSE);
			ItemMeta lMeta = love.getItemMeta();
			lMeta.setDisplayName(ChatColor.GREEN + "Love");
			love.setItemMeta(lMeta);
			pInv.setItem(20, love);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Love");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.notes")){
			ItemStack notes = new ItemStack(Material.JUKEBOX);
			ItemMeta nMeta = notes.getItemMeta();
			nMeta.setDisplayName(ChatColor.GREEN + "Notes");
			notes.setItemMeta(nMeta);
			pInv.setItem(21, notes);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Notes");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(21, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.clouds")){
			ItemStack clouds = new ItemStack(Material.QUARTZ);
			ItemMeta cMeta = clouds.getItemMeta();
			cMeta.setDisplayName(ChatColor.GREEN + "Clouds");
			clouds.setItemMeta(cMeta);
			pInv.setItem(22, clouds);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Clouds");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(22, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.coloreddust")){
			ItemStack dust = new ItemStack(Material.WOOL,1,(byte)9);
			ItemMeta dMeta = dust.getItemMeta();
			dMeta.setDisplayName(ChatColor.GREEN + "ColoredDust");
			dust.setItemMeta(dMeta);
			pInv.setItem(23, dust);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "ColoredDust");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(23, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.lavapop")){
			ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta laMeta = lava.getItemMeta();
			laMeta.setDisplayName(ChatColor.GREEN + "LavaPop");
			lava.setItemMeta(laMeta);
			pInv.setItem(24, lava);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "LavaPop");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(24, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.portal")){
			ItemStack portal = new ItemStack(Material.ENDER_PEARL);
			ItemMeta pMeta = portal.getItemMeta();
			pMeta.setDisplayName(ChatColor.GREEN + "Portal");
			portal.setItemMeta(pMeta);
			pInv.setItem(25, portal);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Portal");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(25, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.spell")){
			ItemStack spell = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta spMeta = spell.getItemMeta();
			spMeta.setDisplayName(ChatColor.GREEN + "Spell");
			spell.setItemMeta(spMeta);
			pInv.setItem(28, spell);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Spell");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(28, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.frozenwalk")){
			ItemStack walker = new ItemStack(Material.SNOW_BLOCK);
			ItemMeta walkerMeta = walker.getItemMeta();
			walkerMeta.setDisplayName(ChatColor.GREEN + "FrozenWalk");
			walker.setItemMeta(walkerMeta);
			pInv.setItem(29, walker);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "FrozenWalk");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(29, noPerm);
		}
		if(p.hasPermission("craftlobby.particles.lilly")){
			ItemStack lilly = new ItemStack(Material.WATER_LILY);
			ItemMeta liMeta = lilly.getItemMeta();
			liMeta.setDisplayName(ChatColor.GREEN + "Lilly");
			lilly.setItemMeta(liMeta);
			pInv.setItem(30, lilly);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName(ChatColor.RED + "" + ChatColor.UNDERLINE + "Lilly");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Efekt lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			pInv.setItem(30, noPerm);
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
		
		ItemStack shopItem = new ItemStack(Material.CHEST,1);
		ItemMeta shopItemMeta = shopItem.getItemMeta();
		shopItemMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Gadgets");
		ArrayList<String> shopLore = new ArrayList<String>();
		shopLore.add(ChatColor.GRAY + "Gadgety jsou doplnky do lobby");
		shopLore.add(ChatColor.GRAY + "daji se ziskat z CraftBoxu nebo na");
		shopLore.add(ChatColor.GRAY + "specialnich eventech.");
		shopLore.add("");
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);

		
		pInv.setItem(49, shopItem);
		pInv.setItem(40, deaktivace);
		pInv.setItem(39, zpet);
		
		p.openInventory(pInv);
	}

}
