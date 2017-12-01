package cz.wake.lobby.listeners;

import cz.wake.lobby.events.christmas.Kalendar;
import cz.wake.lobby.gui.ArcadeShopGUI;
import cz.wake.lobby.gui.Profil;
import cz.wake.lobby.Main;
import cz.wake.lobby.manager.RewardsManager;
import cz.wake.lobby.settings.SettingsMenu;
import cz.wake.lobby.utils.ItemFactory;
import cz.wake.lobby.utils.MessagesUtils;
import cz.wake.lobby.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class ArmorStandInteract implements Listener {

    private MessagesUtils mu = new MessagesUtils();
    private boolean farmer, child, ludvik, felix, wake, veverka1, veverka2, flafy, delfik = false;
    private ItemStack item = ItemFactory.create(Material.GHAST_TEAR, (byte) 0, "§bTeleport");
    private ArrayList<Player> wait = new ArrayList<>();
    private ArcadeShopGUI arcadeShop = new ArcadeShopGUI();
    private RewardsManager rw = new RewardsManager();
    private Kalendar k = new Kalendar();

    //TODO: Opravit kdyz na serveru nikdo neni = null

    @EventHandler
    public void manipulate(PlayerArmorStandManipulateEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void interact(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (e.getRightClicked() instanceof ArmorStand) {
            Location locationOfAS = ((ArmorStand) e.getRightClicked()).getEyeLocation().add(-.5d, -.5d, -.5d);
            if (e.getRightClicked().hasMetadata("Farmer")) {
                if (!farmer) {
                    mu.sendMessageNearby(locationOfAS, 8d, "§eFarmar: §fJdi pryc! Jinak si nebudu mit za co koupit VIP!");
                    farmer = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            farmer = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Flafy")) {
                if (!flafy) {
                    mu.sendMessageNearby(locationOfAS, 4d, "§eFlafy: §fPokud ti kid bagr nici, usmej se a vem ho tyci!");
                    flafy = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            flafy = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Kalendar")){
                k.openKalendar(p);
            }
            if (e.getRightClicked().hasMetadata("Kubrastig")) {
                if (!delfik) {
                    mu.sendMessageNearby(locationOfAS, 4d, "§eKubrastig: §fZase mam bobek v kytare.");
                    delfik = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            delfik = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Filip6")) {
                if (!delfik) {
                    mu.sendMessageNearby(locationOfAS, 4d, "§eFilip6_CZ: §fBAF!......Lek!");
                    delfik = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            delfik = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Child")) {
                if (!child) {
                    mu.sendMessageNearby(locationOfAS, 4d, "§eOliver: §fTesim se na Jeziska! Dostanu originalku a budu mit AutoLogin!");
                    child = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            child = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Felix") || e.getRightClicked().hasMetadata("Wiliam")) {
                if (!felix & !ludvik) {
                    int sance = randRange(1, 4);
                    if (sance == 1) {
                        felix = true;

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fSlyseli jste to? Na CraftManii maji zase novy lobby!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 10L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fBoze ty jsi debil, vsak v nem sedime!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 45L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fTo mi nikdo nerekl sakra!");
                                felix = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 80L);

                    } else if (sance == 2) {
                        felix = true;

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fDneska je tak krasne, jenom tady ten smradoch vedle me to musi kazit!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 10L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fKomu rikas smradoch!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 50L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fKlid panove, je prokazany, ze ten kdo zadrzuje prdy tak ma napadny na hovno!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 95L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fTo jsi zase sebral kde, te osvitila muza?");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 130L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
                                mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fOmlouvam se panove ale musi to ven! :/");
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, loc3, SettingsMenu.particles);
                                felix = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 160L);

                    } else if (sance == 3) {
                        felix = true;

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fPanove v nedeli odjizdim k mori! To cumite co!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 10L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fCo blbnes, vsak je more vsude kolem nas.");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 40L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fJo to mi nedoslo. To jsem to zase po....");
                                felix = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 80L);

                    } else if (sance == 4) {
                        felix = true;

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fSlyseli jste o tom saskovi MrWakeCZ?");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 10L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fTen co vlastni Haribo Club?");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 40L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eFelix: §fPry to tu chce vsude obsadit s jeho AT!");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fTo nevadi, mame tady Ludvika, ten ho vysmradi! Ze jo?");
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 100L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, loc3, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 130L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, loc3, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 135L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, loc3, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 140L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc3 = new Location(Bukkit.getWorld("omain"), 1459.5, 16.9, -1260.5, 0, 0);
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, loc3, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 145L);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                mu.sendMessageNearby(locationOfAS, 8d, "§eWiliam: §fVsak to rikam, nejdriv vysmradi ale nas!");
                                felix = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 175L);

                    }
                }
            }
            if (e.getRightClicked().hasMetadata("Wake")) {
                if (!wake) {
                    mu.sendMessageNearby(locationOfAS, 3d, "§eWake: §fNekoukej na me nebo ti sezeru Haribo!");
                    wake = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            wake = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 60L);
                }
            }
            if (e.getRightClicked().hasMetadata("Veverka1")) {
                if (!veverka1) {
                    mu.sendMessageNearby(locationOfAS, 3d, "§eVevercak: §fKdo neskace neni veverka! HOP HOP");
                    veverka1 = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            veverka1 = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 80L);
                }
            }
            if (e.getRightClicked().hasMetadata("Veverka2")) {
                if (!veverka2) {
                    mu.sendMessageNearby(locationOfAS, 3d, "§eVeverka: §fVsude samy veverky a Haribo! ._.");
                    veverka2 = true;
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            veverka2 = false;
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 80L);
                }
            }
            if (e.getRightClicked().hasMetadata("Witch1") || e.getRightClicked().hasMetadata("Witch2")
                    || e.getRightClicked().hasMetadata("Witch3")) {
                if (Main.getInstance().getInQuestPlayers().contains(p)) {
                    if (!wait.contains(p)) {
                        if (p.getInventory().contains(item)) {
                            p.sendMessage("§5Carodejnice: §fTeleport jiz mas, tak co chces vic!");
                            wait.add(p);

                            new BukkitRunnable() {

                                @Override
                                public void run() {
                                    wait.remove(p);
                                }
                            }.runTaskLaterAsynchronously(Main.getInstance(), 30L);
                        } else {
                            int sance = randRange(1, 100);
                            if (sance <= 20) {
                                p.getInventory().setItem(9, item);
                                p.sendMessage("§5Carodejnice: §fTady je ten teleport! Jdi uz se nevracej!");
                                wait.add(p);

                                new BukkitRunnable() {

                                    @Override
                                    public void run() {
                                        wait.remove(p);
                                    }
                                }.runTaskLaterAsynchronously(Main.getInstance(), 50L);
                            } else {
                                p.sendMessage("§5Carodejnice: §fCo po me chces? Nic takoveho nemam, zkus to jinde!");
                                wait.add(p);

                                new BukkitRunnable() {

                                    @Override
                                    public void run() {
                                        wait.remove(p);
                                    }
                                }.runTaskLaterAsynchronously(Main.getInstance(), 50L);
                            }
                        }
                    }
                } else {
                    if (wait.contains(p)) {
                        return;
                    }
                    wait.add(p);
                    p.sendMessage("§5Carodejnice: §fABRAKA BUBRA KAMBO DINGO BAAAC");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 2));

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            wait.remove(p);
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 40L);
                }
            }
            if (e.getRightClicked().hasMetadata("OPirate")) {
                if (!Main.getInstance().getPreQuestPlayers().contains(p)
                        && !Main.getInstance().getInQuestPlayers().contains(p)) {

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            p.sendMessage("§eJack: §fCo jsi zac? Co tu chces? Chces mi snad pomoct?");
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 10L);
                    Main.getInstance().getPreQuestPlayers().add(p);

                } else if (Main.getInstance().getPreQuestPlayers().contains(p)) {
                    Main.getInstance().getPreQuestPlayers().remove(p);
                    Main.getInstance().getInQuestPlayers().add(p);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            p.sendMessage("§e" + p.getName() + ": §fJdu ti pomoct! Chci se take dostat na tu lod!");
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 10L);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            p.sendMessage("§eJack: §fTak to jsi hodny! Potrebuji od tebe jednu jednoduchou vec!");
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 40L);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            p.sendMessage("§eJack: §fNa tomto ostrove se nachazi tri carodejnice. " +
                                    "Tvym ukolem je za nimi dojit a jedna z nich vlastni teleport. " +
                                    "Obvykle bydli v baraccich na konci ostrova. Varuji te, mohou lhat!");
                        }
                    }.runTaskLaterAsynchronously(Main.getInstance(), 80L);

                } else if (Main.getInstance().getInQuestPlayers().contains(p)) {
                    if (p.getInventory().contains(item)) {

                        p.getInventory().remove(item);
                        p.sendMessage("§eJack: §fA nasel jsi ho! Dekuji ti, za odmenu se muzet portnout na moji lod!");

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Location loc1 = new Location(Bukkit.getWorld("omain"), 1537.5, 17, -1387.5, -90, 0);
                                Main.getInstance().getInQuestPlayers().remove(p);
                                p.teleport(loc1);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 50L);
                    } else {
                        p.sendMessage("§eJack: §fNic jsi nenasel? Zkus to znova, jedna z nich to urcite ma!");
                    }
                }
            }
            if (e.getRightClicked().hasMetadata("Ludvik")) {
                if (!ludvik & !felix) {
                    int sance = randRange(1, 6);
                    if (sance == 1) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fJdou na me plyny! Promin kamarade ja musim!");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, locationOfAS, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                    } else if (sance == 2) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fDneska je tak hezky, proc nehrajes minihry?!");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                    } else if (sance == 3) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fCitim tlak! Citim vzruseni! Jde to name!!!");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                                mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fSorry musel jsem!");
                                ParticleEffect.SMOKE_LARGE.display(0.2f, 0.0f, 0.2f, 0.0f, 100, locationOfAS, SettingsMenu.particles);
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                    } else if (sance == 4) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fHej ty! Pojd sem! Never tem dvou co kecaji!");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                    } else if (sance == 5) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fHello... It's me!!");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);

                    } else if (sance == 6) {
                        mu.sendMessageNearby(locationOfAS, 8d, "§eLudvik: §fMoje mama mela driv vysavac! Bohuzel si neuvedomila, ze ji chybi trubka. Po 4 letech vysavani, ji to doslo. Tehdy jsem ji videl naposled, nez se zblaznila. :/");
                        ludvik = true;
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                ludvik = false;
                            }
                        }.runTaskLaterAsynchronously(Main.getInstance(), 70L);
                    }

                }
            }
            if (e.getRightClicked().hasMetadata("Bonusy")) {
                rw.openRewardManager(p);
            }
            if (e.getRightClicked().hasMetadata("survival")) {
                sendToServer(p, "survival");
            }
            if (e.getRightClicked().hasMetadata("skyblock")) {
                sendToServer(p, "skyblock");
            }
            if (e.getRightClicked().hasMetadata("creative1")) {
                sendToServer(p, "creative");
            }
            if (e.getRightClicked().hasMetadata("creative2")) {
                sendToServer(p, "creative2");
            }
            if (e.getRightClicked().hasMetadata("prison")) {
                sendToServer(p, "prison");
            }
            if (e.getRightClicked().hasMetadata("vanilla")) {
                sendToServer(p, "vanilla");
            }
            if (e.getRightClicked().hasMetadata("arcade")) {
                sendToServer(p, "dlobby");
            }
            if (e.getRightClicked().hasMetadata("bedwars")) {
                sendToServer(p, "blobby");
            }
            if (e.getRightClicked().hasMetadata("skywars")) {
                sendToServer(p, "slobby");
            }
            if (e.getRightClicked().hasMetadata("skygiants")) {
                sendToServer(p, "globby");
            }
            if (e.getRightClicked().hasMetadata("vanilla-skyblock")) {
                sendToServer(p, "vanillasb");
            }
            if (e.getRightClicked().hasMetadata("getdown")) {
                sendToServer(p, "dlobby");
            }
            if (e.getRightClicked().hasMetadata("arcadeshop")) {
                arcadeShop.openMainGUI(p);
            }
            if (e.getRightClicked().hasMetadata("teambuildbattle")) {
                sendToServer(p, "dlobby");
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            e.setCancelled(true);
        }
    }

    public static int randRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomNum;
    }

    public void sendToServer(Player player, String target) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(target);
        } catch (Exception e) {
            //log.error("", e);
        }
        player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
    }

}
