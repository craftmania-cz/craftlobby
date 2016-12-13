package cz.wake.lobby.vanoce;

import cz.wake.lobby.API.TitleAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.cloaks.RankCape;
import cz.wake.lobby.listeners.InvClick;
import cz.wake.lobby.listeners.PlayerListener;
import cz.wake.lobby.pets.PetManager;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.UtilBook;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class EventBludiste {

    Location start = new Location(Bukkit.getWorld("LobbyEventy"), -592.5, 99.0, 117.5, 90, 10);
    private static ArrayList<Player> list = new ArrayList<>();
    InvClick ic = new InvClick();

    public void sendToParkourEvent(final Player p){

        p.teleport(start);
        p.getInventory().clear();

        list.add(p);

        //Deaktivace particles
        ic.deactivateParticles(p);

        //Deaktivace cloaks
        Main.getInstance().getCloaksAPI().deactivateCloaks(p);
        RankCape.deactivateCape(p);

        //Deaktivatce mazlíčka
        PetManager.forceRemovePet(p);

        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage("§bEVENT: §cBludiste ");
        p.sendMessage("§7Tvym jedinym ukolem je se dostat na konec!");
        p.sendMessage(" ");
        p.sendMessage(" ");

        TitleAPI.sendFullTitlePlayer(p,10,80,10, "§e§lEvent","§7Bludiste");

        UtilBook.giveBook(p, 4, "§8MrWakeCZ", "§e§lEvent (Bludiste)",
                "§lPopis eventu:\n\n§rTvym jedinym ukolem je se prosplest nasim mega bludistem. " +
                        "Je mozne ze misty najdes nejake pasti, tak se nelekni! Na konci te ceka velka odmena!\n\nZ eventu " +
                        "se odpojis §c/quit");

        for(Player p2 : Bukkit.getOnlinePlayers()){
            p2.hidePlayer(p);
            p.hidePlayer(p2);
        }
    }

    public ArrayList<Player> getList(){
        return list;
    }

    public void endParkour(final Player p){
        p.performCommand("spawn");
        list.remove(p);
        for(Player p2 : Bukkit.getOnlinePlayers()){
            if(!list.contains(p2)){
                p.showPlayer(p2);
            }
        }
        Main.getInstance().fetchData().addCalendarDay(p, 7);

        TitleAPI.sendFullTitlePlayer(p,10,80,10, "§e§lEvent","§aDokoncen!");

        p.sendMessage(" ");
        p.sendMessage(" ");
        p.sendMessage("§bEVENT: §eBludiste (Dokonceno)");
        p.sendMessage("§7Dostal/a jsi vsechny ovecky v Pets! + 2000CC");
        p.sendMessage(" ");
        p.sendMessage(" ");

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "coins give " + p.getName() + " 2000");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add craftlobby.pets.sheep.*");

        PlayerListener.setupDefaultItems(p);
    }

    public void openEventMenu(final Player p){

        Inventory inv = Bukkit.createInventory(null,45,"Potvrdit vstup (Bludiste)");

        ItemStack info = ItemFactory.create(Material.REDSTONE,(byte)0, "§c§lVarovani","","§7Nasledujici event je extremne tezky!",
                "§7Prumerny cas splneni: §c55 minut!","§7Z eventu odejdes pomoci prikazu §a/quit","",
                "§7Za splneni dostanes: §62k CC + vsechny ovecky v Pets","","§eKliknutim vstoupis na Event!");

        ItemStack potvrd = ItemFactory.create(Material.WOOL,(byte)5,"§a§lVstoupit na event");
        ItemStack zamitnout = ItemFactory.create(Material.WOOL, (byte)14, "§c§lNechci na event");

        inv.setItem(13, info);
        inv.setItem(30, potvrd);
        inv.setItem(32, zamitnout);

        p.openInventory(inv);

    }

}
