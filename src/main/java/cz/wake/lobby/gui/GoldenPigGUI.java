package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.craftmania.crafteconomy.api.EconomyAPI;
import cz.wake.lobby.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GoldenPigGUI implements InventoryProvider {

    @Override
    public void init(Player player, InventoryContents contents) {
        // About
        contents.set(0, 1, ClickableItem.of(new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(player)
                .setName(ChatColor.of("#face4b") + "§lGoldenPig")
                .setLore(ChatColor.of("#ded86a") + "Aktuální streak: " + ChatColor.of("#38ff49") + streak(player), "", "§7Denní odměna:", "§71. den " + ChatColor.of("#ded86a") + "10 CC", "§72. den " + ChatColor.of("#ded86a") + "20 CC", "§73. den " + ChatColor.of("#ded86a") + "30 CC", "§74. den " + ChatColor.of("#ded86a") + "40 CC", "§75. den " + ChatColor.of("#ded86a") + "50 CC", "§76. den " + ChatColor.of("#ded86a") + "60 CC", "§77. den " + ChatColor.of("#ded86a") + "10 CC", "§7Po 7. dni se vracíš zpátky na 1.", "", ChatColor.of("#ded86a") + "Každý 30. den + 1 CraftToken")
                .hideAllFlags()
                .build(), e -> {
        }));

        // Rewards

        // Daily
        if (claimed(player, "daily")) {
            contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lDenní odměna")
                    .setLore("§7Každý den si můžeš vyzvednout odměnu!", "§cDnes ji máš vyzvednutou,", "§cpřijď si pro ni zase zítra!", "", "§7Dnešní den je " + ChatColor.of("#38ff49") + streak(player) + "§7. v řadě!", ChatColor.of("#ded86a") + "Získal jsi: " + rewardFromDay(dayStreak(player) - 1) + " CC" + dailyCraftTokenMessage(player))
                    .hideAllFlags()
                    .build(), e -> {}
            ));
        } else {
            contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100014)
                    .setName(ChatColor.of("#face4b") + "§lDenní odměna")
                    .setLore("§7Každý den si můžeš vyzvednout odměnu!", "", "§7Dnešní den je " + ChatColor.of("#38ff49") + (streak(player) + 1) + "§7. v řadě!", ChatColor.of("#ded86a") + "Dostaneš: " + rewardFromDay(dayStreak(player)) + " CC" + dailyCraftTokenMessage(player))
                    .hideAllFlags()
                    .build(), (clickEvent) -> {
                claim(player, "daily", "Vyzvednul jsi si denní odměnu!");
            }));
        }

        // VIP
        if (player.hasPermission("craftlobby.vip.odmena")) {
            if (claimed(player, "monthly_vip")) {
                contents.set(0, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lVIP odměna")
                        .setLore("§7VIP si může každý měsíc vyzvednout odměnu!", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: " + monthlyVipCoins(player) + " CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                contents.set(0, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100004)
                        .setName(ChatColor.of("#face4b") + "§lVIP odměna")
                        .setLore("§7VIP si může každý měsíc vyzvednout odměnu!", "", ChatColor.of("#ded86a") + "Dostaneš: " + monthlyVipCoins(player) + " CC")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "monthly_vip", "Vyzvednul jsi si VIP odměnu!");
                    EconomyAPI.CRAFT_COINS.give(player, monthlyVipCoins(player));
                }));
            }
        } else { // Nemá VIP
            contents.set(0, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                    .setName(ChatColor.of("#face4b") + "§lVIP odměna")
                    .setLore("§7VIP si může každý měsíc vyzvednout odměnu!", "§cNemáš zakoupené VIP!", "", ChatColor.of("#ded86a") + "Dostaneš: 500-2000 CC")
                    .hideAllFlags()
                    .build(), e -> {
            }));
        }

        // Extra
        if (claimed(player, "extra")) {
            contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001) // Nepřenastavuj, zobrazuje se jako fajfka, že odmĚna je vyzvednuta
                    .setName(ChatColor.of("#face4b") + "§lExtra odměna")
                    .setLore("§7Extra odměna s extra nádechem!", "§cTuto odměnu jsi si již vyzvedl,", "§cpočkej si na další!", "", ChatColor.of("#ded86a") + "Získal jsi: Něco EXTRA") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            /*contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.PAPER).setCustomModelData(100026) // Nastavení itemu, který bude symbolem extra odměny
                    .setName(ChatColor.of("#face4b") + "§lExtra odměna")
                    .setLore("§7Extra odměna s extra nádechem!", "", ChatColor.of("#ded86a") + "Dostaneš: Něco EXTRA") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), (clickEvent) -> {
                claim(player, "extra", "Vyzvednul jsi si Extra odměnu!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set craftmanager.extra.reward"); // Příkaz, který se vykoná pro udělení odměny
            }));*/
            contents.set(0, 6, ClickableItem.empty(new ItemBuilder(Material.BARRIER)
                    .setName("§c§lExtra odměna")
                    .setLore("§7Aktuálně zde není nic k vyzvednutí.")
                    .hideAllFlags()
                    .build()
            ));
        }
        // Odehraný čas
        // Ikonka kategorie
        contents.set(2, 1, ClickableItem.of(new ItemBuilder(Material.CLOCK)
                .setName(ChatColor.of("#face4b") + "§lOdehraný čas")
                .setLore("§7Podívej se doprava na odměny,", "§7které můžeš získat za", "§7odehraný čas na serveru.")
                .hideAllFlags()
                .build(), e -> {
        }));

        // 1 den
        if (claimed(player, "playtime_1d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                    .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 200 CC")
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(player) >= 24) {
                contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.PAPER) //TODO: Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                        .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "playtime_1d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    EconomyAPI.CRAFT_COINS.give(player, 200);
                }));
            } else {
                contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                        .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // Odehraný čas: týden
        if (claimed(player, "playtime_7d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                    .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 1,000 CC")
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(player) >= 168) {
                contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.PAPER)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                        .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 168h", "", ChatColor.of("#ded86a") + "Dostaneš: 1,000 CC")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "playtime_7d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    EconomyAPI.CRAFT_COINS.give(player, 1000);
                }));
            } else {
                contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                        .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 168h", "", ChatColor.of("#ded86a") + "Dostaneš: 1,000 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // odehraný čas: 2 týdny
        if (claimed(player, "playtime_14d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                    .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 2,500 CC, 1 CT")
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            /*if (getPlaytime(player) >= 336) {
                contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                        .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 2,500 CC, 1 CT")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "playtime_14d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(player, 2500);
                    CraftTokensAPI.giveTokens(player, 1);
                }));
            } else {
                contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                        .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 2,500 CC, 1 CT")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }*/
            contents.set(2, 5, ClickableItem.empty(new ItemBuilder(Material.BARRIER)
                    .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                    .setLore("§7Tuto odměnu dočasně nelze vybrat.")
                    .hideAllFlags()
                    .build()));
        }

        // měsíc
        if (claimed(player, "playtime_30d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                    .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 400 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            //TODO: Leden update cosmetics
            /*if (getPlaytime(player) >= 720) {
                contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                        .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 400 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "playtime_30d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(player, 400);
                }));
            } else {
                contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                        .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 720h", "", ChatColor.of("#ded86a") + "Dostaneš: 400 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }*/
            contents.set(2, 6, ClickableItem.empty(new ItemBuilder(Material.BARRIER)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                    .setLore("§7Tuto odměnu dočasně nelze vybrat.")
                    .hideAllFlags()
                    .build()));
        }

        // půlroku
        if (claimed(player, "playtime_halfyear")) { // Pokud je odměna vyvzednuta
            contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                    .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 500 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            //TODO: Leden update cosmetics
            /*if (getPlaytime(player) >= 4380) {
                contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                        .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 4380h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "playtime_halfyear", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(player, 500);
                }));
            } else {
                contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                        .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(player) + "h z 4380h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }*/
            contents.set(2, 7, ClickableItem.empty(new ItemBuilder(Material.BARRIER)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                    .setLore("§7Tuto odměnu dočasně nelze vybrat.")
                    .hideAllFlags()
                    .build()));
        }


        // Discord
        // Ikonka kategorie
        ItemStack discord = new ItemBuilder(Material.BLUE_ICE).setName(
                ChatColor.of("#face4b") + "§lDiscord")
                //"de431cd1-ae1d-49f6-9339-a96daeacc32b",
                //"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19",
                //ChatColor.of("#face4b") + "§lDiscord",
                .setLore("§7Podívej se doprava na odměny,", "§7které můžeš získat za aktivity", "§7spojené s Discordem.").build();
        ItemStack needToConnect = new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                .setName(ChatColor.of("#face4b") + "§lZamčená Discord odměna")
                .setLore("§cPro zobrazení této odměny", "§csi musíš nejprve propojit", "§cDiscord s Minecraftem." + ChatColor.of("#ded86a") + " /link")
                .hideAllFlags()
                .build();
        contents.set(3, 1, ClickableItem.empty(discord));

        // Propojení check
        if (Main.getInstance().getSQL().isConnectedToDiscord(player)) {
            //Propojení odměna
            if (claimed(player, "discord_connect")) {
                contents.set(3, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lDiscord propojení")
                        .setLore("§7Odměna za to, že sis propojil", "§7Discord s Minecraftem.", "", ChatColor.of("#ded86a") + "Získal jsi: Wumpus Leaf [Čepice]")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                contents.set(3, 3, ClickableItem.of(new ItemBuilder(Material.PAPER)
                        .setName(ChatColor.of("#face4b") + "§lDiscord propojení")
                        .setLore("§7Odměna za to, že sis propojil", "§7Discord s Minecraftem.", "", ChatColor.of("#ded86a") + "Dostaneš: Wumpus Leaf [Čepice]")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(player, "discord_connect", "Čepici si můžeš nasadit na serverech v /cosmetics");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set craftmanager.hats.wumpus_leaf");
                }));
            }

            // Booster odměna
            if (Main.getInstance().getSQL().isDiscordBooster(player)) {
                if (claimed(player, "discord_booster")) {
                    contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                            .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                            .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Získal jsi: Mega Wumpus [Čepice]")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                } else {
                    contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                            .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Dostaneš: Mega Wumpus [Čepice]")
                            .hideAllFlags()
                            .build(), (clickEvent) -> {
                        claim(player, "discord_booster", "Čepici si můžeš nasadit na serverech v /cosmetics!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set craftmanager.hats.wumpus");
                    }));
                }
            } else {
                contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                        .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Dostaneš: Mega Wumpus [Čepice]")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }

            // Měsíční Discord volání
            //1h
            if (claimed(player, "discord_voice_activity_1h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 100 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(player) >= 1) {
                    contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 1h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(player, "discord_voice_activity_1h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        EconomyAPI.CRAFT_COINS.give(player, 100);
                    }));
                } else {
                    contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 1h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                }
            }
            //10h
            if (claimed(player, "discord_voice_activity_10h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 500 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(player) >= 10) {
                    contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 10h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(player, "discord_voice_activity_10h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        EconomyAPI.CRAFT_COINS.give(player, 500);
                    }));
                } else {
                    contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 10h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                }
            }
            //24h
            if (claimed(player, "discord_voice_activity_24h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 1,000 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(player) >= 24) {
                    contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 1,000 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(player, "discord_voice_activity_24h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        EconomyAPI.CRAFT_COINS.give(player, 1000);
                    }));
                } else {
                    contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(player) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 1,000 CC")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                }
            }

        } else {
            contents.set(3, 3, ClickableItem.empty(needToConnect));
            contents.set(3, 4, ClickableItem.empty(needToConnect));
            contents.set(3, 5, ClickableItem.empty(needToConnect));
            contents.set(3, 6, ClickableItem.empty(needToConnect));
            contents.set(3, 7, ClickableItem.empty(needToConnect));
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {
    }

    private int rewardFromDay(int day) {
        return switch (day) {
            case 0 -> 10;
            case 1 -> 20;
            case 2 -> 30;
            case 3 -> 40;
            case 4 -> 50;
            case 5 -> 60;
            case 6, -1 -> 100;
            default -> 0;// Nemělo by nastat
        };
    }

    private int streak(Player player) {
        return Main.getInstance().getSQL().getPlayerProfileDataIntNoUUID(player, "lobby_bonus_streak");
    }

    // Ziskání denního streaku (1-7. den)
    private int dayStreak(Player player) {
        int rawStreak = Main.getInstance().getSQL().getPlayerProfileDataInt(player, "lobby_bonus_streak");
        while (rawStreak > 6) {
            rawStreak = rawStreak - 7;
        }
        return rawStreak;
    }

    private boolean dailyCraftToken(Player player) {
        if (claimed(player, "daily")) {
            return streak(player) % 30 == 0;
        } else {
            return (streak(player) + 1) % 30 == 0;
        }

    }

    private String dailyCraftTokenMessage(Player player) {
        if (dailyCraftToken(player)) {
            return " + 1 CT";
        } else {
            return "";
        }
    }

    // VIP odměny
    private int monthlyVipCoins(Player player) {
        if (player.hasPermission("craftlobby.vip.odmena.obsidian")) {
            return 2000;
        } else if (player.hasPermission("craftlobby.vip.odmena.emerald")) {
            return 1500;
        } else if (player.hasPermission("craftlobby.vip.odmena.diamond")) {
            return 1000;
        } else {
            return 500;
        }
    }

    // Hodinový playtime
    private int getPlaytime(Player player) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(player, "played_time") / 60;
    }

    // Hodinová měsíční Discord voice aktivita
    private int getDiscordVoiceActivityTime(Player player) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(player, "month_discord_voice_activity") / (3600 * 1000);
    }

    // Claimed
    private boolean claimed(Player player, String type) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(player, "lobby_bonus_claimed_" + type) == 1;
    }

    private void claim(Player player, String type, String message) {
        if (type == "daily") {
            EconomyAPI.CRAFT_COINS.give(player, rewardFromDay(dayStreak(player)));
            if (dailyCraftToken(player)) {
                EconomyAPI.CRAFT_TOKENS.give(player, 1);
            }
            Main.getInstance().getSQL().increaseBonusStreak(player);
        }
        Main.getInstance().getSQL().bonusClaim(player, type);
        player.closeInventory();
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 13.0F, 1.0F);
        player.sendTitle(ChatColor.of("#face4b") + "GoldenPig", ChatColor.of("#ded86a") + message, 5, 40, 5);
    }
}
