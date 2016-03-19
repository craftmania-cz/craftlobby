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

public class GadgetsItemsMenu{
	
	
	public void openInventory(Player p){
		
		Inventory gadgetsInv = Bukkit.createInventory(null, 54, "Gadgets");
		
		if(p.hasPermission("craftlobby.gadgets.teleportstick")){
			ItemStack wizardGun = new ItemStack(Material.STICK);
			ItemMeta wgMeta = wizardGun.getItemMeta();
			wgMeta.setDisplayName("§e§lTeleportStick");
			ArrayList<String> wgLore = new ArrayList<String>();
			wgLore.add(ChatColor.GRAY + "Teleportuj se jako Enderman!");
			wgMeta.setLore(wgLore);
			wizardGun.setItemMeta(wgMeta);
			gadgetsInv.setItem(0, wizardGun);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lTeleportStick");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(0, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.funcannon")){
			ItemStack funcannon = new ItemStack(Material.GOLD_HOE);
			ItemMeta fcMeta = funcannon.getItemMeta();
			fcMeta.setDisplayName("§e§lFunCannon");
			ArrayList<String> fcLore = new ArrayList<String>();
			fcLore.add(ChatColor.GRAY + "Kliknutim vystrelis hromadu efektu!");
			fcMeta.setLore(fcLore);
			funcannon.setItemMeta(fcMeta);
			gadgetsInv.setItem(1, funcannon);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lFunCannon");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(1, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.colorbomb")){
			ItemStack colorbomb = new ItemStack(Material.WOOL);
			ItemMeta cbMeta = colorbomb.getItemMeta();
			cbMeta.setDisplayName("§e§lColorBomb");
			ArrayList<String> cbLore = new ArrayList<String>();
			cbLore.add(ChatColor.GRAY + "Vsude jenom vlna...");
			cbMeta.setLore(cbLore);
			colorbomb.setItemMeta(cbMeta);
			gadgetsInv.setItem(2, colorbomb);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lColorBomb");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(2, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.cookiefountain")){
			ItemStack cookie = new ItemStack(Material.COOKIE);
			ItemMeta cooMeta = cookie.getItemMeta();
			cooMeta.setDisplayName("§e§lCookieFountain");
			ArrayList<String> cooLore = new ArrayList<String>();
			cooLore.add(ChatColor.GRAY + "Susenky vsude!");
			cooMeta.setLore(cooLore);
			cookie.setItemMeta(cooMeta);
			gadgetsInv.setItem(3, cookie);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lCookieFountain");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(3, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.chikenator")){
			ItemStack chickenator = new ItemStack(Material.COOKED_CHICKEN);
			ItemMeta chMeta = chickenator.getItemMeta();
			chMeta.setDisplayName("§e§lChickenator");
			ArrayList<String> chLore = new ArrayList<String>();
			chLore.add(ChatColor.GRAY + "Bouchajici kure!");
			chMeta.setLore(chLore);
			chickenator.setItemMeta(chMeta);
			gadgetsInv.setItem(4, chickenator);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lChickenator");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(4, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.pee")){
			ItemStack peee = new ItemStack(Material.INK_SACK,1,(short)11);
			ItemMeta peeMeta = peee.getItemMeta();
			peeMeta.setDisplayName("§e§lPee");
			ArrayList<String> peeLore = new ArrayList<String>();
			peeLore.add(ChatColor.GRAY + "Pocurej nam lobby,");
			peeLore.add(ChatColor.GRAY + "ale ne zase moc :P");
			peeMeta.setLore(peeLore);
			peee.setItemMeta(peeMeta);
			gadgetsInv.setItem(5, peee);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lPee");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(5, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.pigfly")){
			ItemStack pig = new ItemStack(Material.SADDLE);
			ItemMeta pigMeta = pig.getItemMeta();
			pigMeta.setDisplayName("§e§lPigFly");
			ArrayList<String> pigLore = new ArrayList<String>();
			pigLore.add(ChatColor.GRAY + "Litajici prase... :O");
			pigMeta.setLore(pigLore);
			pig.setItemMeta(pigMeta);
			gadgetsInv.setItem(6, pig);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lPigFly");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(6, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.firework")){
			ItemStack firework = new ItemStack(Material.FIREWORK);
			ItemMeta fireworkMeta = firework.getItemMeta();
			fireworkMeta.setDisplayName("§e§lFirework");
			ArrayList<String> fireworkLore = new ArrayList<String>();
			fireworkLore.add(ChatColor.GRAY + "Ohnostroj jako na Silvestra!");
			fireworkMeta.setLore(fireworkLore);
			firework.setItemMeta(fireworkMeta);
			gadgetsInv.setItem(7, firework);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lFirework");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(7, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.poopbomb")){
			ItemStack poop = new ItemStack(Material.MELON_SEEDS);
			ItemMeta poMeta = poop.getItemMeta();
			poMeta.setDisplayName("§e§lPoopBomb");
			ArrayList<String> poLore = new ArrayList<String>();
			poLore.add(ChatColor.GRAY + "Bobiky vsude :O");
			poMeta.setLore(poLore);
			poop.setItemMeta(poMeta);
			gadgetsInv.setItem(8, poop);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lPoopBomb");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(8, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.tnt")){
			ItemStack tnt = new ItemStack(Material.TNT);
			ItemMeta tntMeta = tnt.getItemMeta();
			tntMeta.setDisplayName("§e§lTNT");
			ArrayList<String> tntLore = new ArrayList<String>();
			tntLore.add(ChatColor.GRAY + "Staci vyhodit a uvidis");
			tntLore.add(ChatColor.GRAY + "bordel. Majgat");
			tntMeta.setLore(tntLore);
			tnt.setItemMeta(tntMeta);
			gadgetsInv.setItem(9, tnt);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lTNT");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(9, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.slimehat")){
			ItemStack slimeHat = new ItemStack(Material.SLIME_BALL);
			ItemMeta sliMeta = slimeHat.getItemMeta();
			sliMeta.setDisplayName("§e§lSlimeHat");
			ArrayList<String> sliLore = new ArrayList<String>();
			sliLore.add(ChatColor.GRAY + "3x Slime na hlave? OK!");
			sliMeta.setLore(sliLore);
			slimeHat.setItemMeta(sliMeta);
			gadgetsInv.setItem(10, slimeHat);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSlimeHat");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(10, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.withercatapult")){
			ItemStack wither = new ItemStack(Material.COAL);
			ItemMeta wMeta = wither.getItemMeta();
			wMeta.setDisplayName("§e§lWitherCatapult");
			ArrayList<String> wLore = new ArrayList<String>();
			wLore.add(ChatColor.GRAY + "To bude rev :D");
			wMeta.setLore(wLore);
			wither.setItemMeta(wMeta);
			gadgetsInv.setItem(11, wither);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lWitherCatapult");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(11, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.discoball")){
			ItemStack disco = new ItemStack(Material.STAINED_GLASS,1,(byte)11);
			ItemMeta dMeta = disco.getItemMeta();
			dMeta.setDisplayName("§e§lDiscoBall");
			ArrayList<String> dLore = new ArrayList<String>();
			dLore.add(ChatColor.GRAY + "A jedeme! :D");
			dMeta.setLore(dLore);
			disco.setItemMeta(dMeta);
			gadgetsInv.setItem(12, disco);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lDiscoBall");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(12, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.blizzardblaster")){
			ItemStack blizzard = new ItemStack(Material.PACKED_ICE);
			ItemMeta bMeta = blizzard.getItemMeta();
			bMeta.setDisplayName("§e§lBlizzardBlaster");
			ArrayList<String> bLore = new ArrayList<String>();
			bLore.add(ChatColor.GRAY + "Epicky led vsude kolem tebe!");
			bMeta.setLore(bLore);
			blizzard.setItemMeta(bMeta);
			gadgetsInv.setItem(13, blizzard);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lBlizzardBlaster");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(13, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.ghosts")){
			ItemStack ghosts = new ItemStack(Material.FEATHER);
			ItemMeta ghMeta = ghosts.getItemMeta();
			ghMeta.setDisplayName("§e§lGhosts");
			ArrayList<String> ghLore = new ArrayList<String>();
			ghLore.add(ChatColor.GRAY + "Duchove jsou vsude, tak bacha na ne!");
			ghMeta.setLore(ghLore);
			ghosts.setItemMeta(ghMeta);
			gadgetsInv.setItem(14, ghosts);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lGhosts");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(14, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.tsunami")){
			ItemStack tsunami = new ItemStack(Material.WATER_BUCKET);
			ItemMeta tsMeta = tsunami.getItemMeta();
			tsMeta.setDisplayName("§e§lTsunami");
			ArrayList<String> tsLore = new ArrayList<String>();
			tsLore.add("§7Odsun vsechny jako tsunami.");
			tsMeta.setLore(tsLore);
			tsunami.setItemMeta(tsMeta);
			gadgetsInv.setItem(15, tsunami);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lTsunami");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(15, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.batblaster")){
			ItemStack batblaster = new ItemStack(Material.IRON_BARDING);
			ItemMeta baMeta = batblaster.getItemMeta();
			baMeta.setDisplayName("§e§lBatBlaster");
			ArrayList<String> baLore = new ArrayList<String>();
			baLore.add(ChatColor.GRAY + "Netopyri vsude okolo tebe!");
			baLore.add(ChatColor.GRAY + "Posli je na nekoho!");
			baMeta.setLore(baLore);
			batblaster.setItemMeta(baMeta);
			gadgetsInv.setItem(16, batblaster);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lBatBlaster");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(16, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.tntfountain")){
			ItemStack fountain = new ItemStack(Material.CLAY_BALL);
			ItemMeta ft = fountain.getItemMeta();
			ft.setDisplayName("§e§lTNT Fountain");
			ArrayList<String> fLore = new ArrayList<String>();
			fLore.add(ChatColor.GRAY + "Vsude budou litat TNT,");
			fLore.add(ChatColor.GRAY + "tak bacha na hlavu!");
			ft.setLore(fLore);
			fountain.setItemMeta(ft);
			gadgetsInv.setItem(17, fountain);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lTNT Fountain");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(17, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.trampoline")){
			ItemStack trampoline = new ItemStack(Material.HOPPER);
			ItemMeta tMeta = trampoline.getItemMeta();
			tMeta.setDisplayName("§e§lTrampoline");
			ArrayList<String> tLore = new ArrayList<String>();
			tLore.add(ChatColor.GRAY + "Trampolina, zaskakej si!");
			tMeta.setLore(tLore);
			trampoline.setItemMeta(tMeta);
			gadgetsInv.setItem(18, trampoline);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lTrampoline");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(18, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.explosivesheep")){
			ItemStack exsheep = new ItemStack(Material.SHEARS);
			ItemMeta exMeta = exsheep.getItemMeta();
			exMeta.setDisplayName("§e§lExplosiveSheep");
			ArrayList<String> exLore = new ArrayList<String>();
			exLore.add(ChatColor.GRAY + "Vybuchujici ovecka, utec.");
			exMeta.setLore(exLore);
			exsheep.setItemMeta(exMeta);
			gadgetsInv.setItem(19, exsheep);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lExplosiveSheep");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(19, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.smashdown")){
			ItemStack smash = new ItemStack(Material.FIREWORK_CHARGE);
			ItemMeta sMeta = smash.getItemMeta();
			sMeta.setDisplayName("§e§lSmashDown");
			ArrayList<String> sLore = new ArrayList<String>();
			sLore.add(ChatColor.GRAY + "Odstrel vsechny z tveho okoli.");
			sMeta.setLore(sLore);
			smash.setItemMeta(sMeta);
			gadgetsInv.setItem(20, smash);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lSmashDown");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(20, noPerm);
		}
		if(p.hasPermission("craftlobby.gadgets.flowerpopper")){
			ItemStack flowerpop = new ItemStack(Material.RED_ROSE);
			ItemMeta fMeta = flowerpop.getItemMeta();
			fMeta.setDisplayName("§e§lFlowerPopper");
			ArrayList<String> fmLore = new ArrayList<String>();
			fmLore.add(ChatColor.GRAY + "Ten pocit, kdyz ti z hlavy");
			fmLore.add(ChatColor.GRAY + "strili kytky.");
			fMeta.setLore(fmLore);
			flowerpop.setItemMeta(fMeta);
			gadgetsInv.setItem(21, flowerpop);
		} else {
			ItemStack noPerm = new ItemStack(Material.INK_SACK,1,(byte)8);
			ItemMeta noPermMeta = noPerm.getItemMeta();
			noPermMeta.setDisplayName("§c§lFlowerPopper");
			ArrayList<String> noPermLore = new ArrayList<String>();
			noPermLore.add(ChatColor.GRAY + "Gadget lze ziskat v CraftBoxu!");
			noPermMeta.setLore(noPermLore);
			noPerm.setItemMeta(noPermMeta);
			gadgetsInv.setItem(21, noPerm);
		}
		
		ItemStack mobgun = new ItemStack(Material.BLAZE_ROD);
		ItemMeta mobgunMeta = mobgun.getItemMeta();
		mobgunMeta.setDisplayName(ChatColor.GREEN + "MobGun");
		ArrayList<String> mbLore = new ArrayList<String>();
		mbLore.add(ChatColor.GRAY + "Pravym kliknutim vystrelis");
		mbLore.add(ChatColor.GRAY + "vybraneho moba. Levym kliknutim");
		mbLore.add(ChatColor.GRAY + "zmenis moba.");
		mobgunMeta.setLore(mbLore);
		mobgun.setItemMeta(mobgunMeta);
		
		ItemStack gravity = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta gMeta = gravity.getItemMeta();
		gMeta.setDisplayName(ChatColor.GREEN + "AntiGravity");
		ArrayList<String> gLore = new ArrayList<String>();
		gLore.add(ChatColor.GRAY + "Zrus gravitaci okolo sebe...");
		gMeta.setLore(gLore);
		gravity.setItemMeta(gMeta);
		
		ItemStack blackhole = new ItemStack(Material.STAINED_CLAY,1,(byte)15);
		ItemMeta bhMeta = blackhole.getItemMeta();
		bhMeta.setDisplayName(ChatColor.RED + "BlackHole");
		ArrayList<String> bhLore = new ArrayList<String>();
		bhLore.add(ChatColor.GRAY + "Cerna dira je velka a tajna!");
		bhLore.add(ChatColor.GRAY + "Kliknutim objevis co je v ni.");
		bhMeta.setLore(bhLore);
		blackhole.setItemMeta(bhMeta);
		
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
		shopLore.add(ChatColor.GRAY + "Aktualni stav: " + ChatColor.GOLD + Main.getInstance().getAPI().getCraftCoins(p.getUniqueId()) + " CC");
		shopItemMeta.setLore(shopLore);
		shopItem.setItemMeta(shopItemMeta);
		
		gadgetsInv.setItem(49, shopItem);
		gadgetsInv.setItem(40, deaktivace);
		gadgetsInv.setItem(39, zpet);
		
		
		/*
		gadgetsInv.setItem(1, mobgun);
		gadgetsInv.setItem(3, paintgun);
		gadgetsInv.setItem(9, gravity);
		gadgetsInv.setItem(10, smash);
		gadgetsInv.setItem(11, trampoline);
		gadgetsInv.setItem(15, exsheep);
		gadgetsInv.setItem(17, flowerpop);
		gadgetsInv.setItem(18, pearl);
		gadgetsInv.setItem(19, blackhole); */
		
		p.openInventory(gadgetsInv);
	}

}
