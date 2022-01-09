package cz.wake.lobby.gui;

import cz.craftmania.craftcore.builders.items.ItemBuilder;
import cz.craftmania.craftcore.inventory.builder.ClickableItem;
import cz.craftmania.craftcore.inventory.builder.content.InventoryContents;
import cz.craftmania.craftcore.inventory.builder.content.InventoryProvider;
import cz.craftmania.crafteconomy.api.CraftCoinsAPI;
import cz.craftmania.crafteconomy.api.CraftTokensAPI;
import cz.wake.lobby.Main;
import cz.wake.lobby.utils.SkullHeads;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GoldenPigGUI implements InventoryProvider {

    @Override
    public void init(Player p, InventoryContents contents) {
        // Item UI Menu
        contents.set(4, 8, ClickableItem.empty(new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setCustomModelData(100003).setName("§f").hideAllFlags().build()));

        // About
        contents.set(0, 1, ClickableItem.of(new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(p)
                .setName(ChatColor.of("#face4b") + "§lGoldenPig")
                .setLore(ChatColor.of("#ded86a") + "Aktuální streak: " + ChatColor.of("#38ff49") + streak(p), "", "§7Denní odměna:", "§71. den " + ChatColor.of("#ded86a") + "10 CC", "§72. den " + ChatColor.of("#ded86a") + "20 CC", "§73. den " + ChatColor.of("#ded86a") + "30 CC", "§74. den " + ChatColor.of("#ded86a") + "40 CC", "§75. den " + ChatColor.of("#ded86a") + "50 CC", "§76. den " + ChatColor.of("#ded86a") + "60 CC", "§77. den " + ChatColor.of("#ded86a") + "10 CC", "§7Po 7. dni se vracíš zpátky na 1.", "", ChatColor.of("#ded86a") + "Každý 30. den + 1 CraftToken")
                .hideAllFlags()
                .build(), e -> {
        }));

        // Rewards

        // Daily
        if (claimed(p, "daily")) {
            contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lDenní odměna")
                    .setLore("§7Každý den si můžeš vyzvednout odměnu!", "§cDnes ji máš vyzdenutou,", "§cpřijď si pro ni zase zítra!", "", "§7Dnešní den je " + ChatColor.of("#38ff49") + streak(p) + "§7. v řadě!", ChatColor.of("#ded86a") + "Získal jsi: " + rewardFromDay(dayStreak(p) - 1) + " CC" + dailyCraftTokenMessage(p))
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            contents.set(0, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100014)
                    .setName(ChatColor.of("#face4b") + "§lDenní odměna")
                    .setLore("§7Každý den si můžeš vyzvednout odměnu!", "", "§7Dnešní den je " + ChatColor.of("#38ff49") + (streak(p) + 1) + "§7. v řadě!", ChatColor.of("#ded86a") + "Dostaneš: " + rewardFromDay(dayStreak(p)) + " CC" + dailyCraftTokenMessage(p))
                    .hideAllFlags()
                    .build(), (clickEvent) -> {
                claim(p, "daily", "Vyzvednul jsi si denní odměnu!");
            }));
        }

        // VIP
        if (p.hasPermission("craftlobby.vip.odmena")) {
            if (claimed(p, "monthly_vip")) {
                contents.set(0, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lVIP odměna")
                        .setLore("§7VIP si může každý měsíc vyzvednout odměnu!", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: " + monthlyVipCoins(p) + " CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                contents.set(0, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100004)
                        .setName(ChatColor.of("#face4b") + "§lVIP odměna")
                        .setLore("§7VIP si může každý měsíc vyzvednout odměnu!", "", ChatColor.of("#ded86a") + "Dostaneš: " + monthlyVipCoins(p) + " CC")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "monthly_vip", "Vyzvednul jsi si VIP odměnu!");
                    CraftCoinsAPI.giveCoins(p, monthlyVipCoins(p));
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
        if (claimed(p, "extra")) {
            contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001) // Nepřenastavuj, zobrazuje se jako fajfka, že odmĚna je vyzvednuta
                    .setName(ChatColor.of("#face4b") + "§lExtra odměna")
                    .setLore("§7Extra odměna s extra nádechem!", "§cTuto odměnu jsi si již vyzvedl,", "§cpočkej si na další!", "", ChatColor.of("#ded86a") + "Získal jsi: Něco EXTRA") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            contents.set(0, 6, ClickableItem.of(new ItemBuilder(Material.PAPER).setCustomModelData(100026) // Nastavení itemu, který bude symbolem extra odměny
                    .setName(ChatColor.of("#face4b") + "§lExtra odměna")
                    .setLore("§7Extra odměna s extra nádechem!", "", ChatColor.of("#ded86a") + "Dostaneš: Něco EXTRA") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), (clickEvent) -> {
                claim(p, "extra", "Vyzvednul jsi si Extra odměnu!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set craftmanager.extra.reward"); // Příkaz, který se vykoná pro udělení odměny
            }));
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
        if (claimed(p, "playtime_1d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                    .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 100 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(p) >= 24) {
                contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                        .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "playtime_1d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(p, 100);
                }));
            } else {
                contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný den")
                        .setLore("§7Odměna za odehraných", "§724 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // týden
        if (claimed(p, "playtime_7d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                    .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 200 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(p) >= 168) {
                contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                        .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 168h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "playtime_7d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(p, 200);
                }));
            } else {
                contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný týden")
                        .setLore("§7Odměna za odehraných", "§7168 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 168h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // 2 týdny
        if (claimed(p, "playtime_14d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                    .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 300 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(p) >= 336) {
                contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                        .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 300 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "playtime_14d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(p, 300);
                }));
            } else {
                contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehrané 2 týdny")
                        .setLore("§7Odměna za odehraných", "§7336 hodin na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 300 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // měsíc
        if (claimed(p, "playtime_30d")) { // Pokud je odměna vyvzednuta
            contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                    .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 400 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(p) >= 720) {
                contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                        .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 336h", "", ChatColor.of("#ded86a") + "Dostaneš: 400 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "playtime_30d", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(p, 400);
                }));
            } else {
                contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný měsíc")
                        .setLore("§7Odměna za odehraných", "§7720 hodin (30 dní) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 720h", "", ChatColor.of("#ded86a") + "Dostaneš: 400 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }

        // půlroku
        if (claimed(p, "playtime_halfyear")) { // Pokud je odměna vyvzednuta
            contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                    .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                    .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "§cTuto odměnu jsi si již vyzvedl!", "", ChatColor.of("#ded86a") + "Získal jsi: 500 CC") // Popis extra odměny (teď to je velice náhodné)
                    .hideAllFlags()
                    .build(), e -> {
            }));
        } else {
            if (getPlaytime(p) >= 4380) {
                contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.PAPER) // Dočasné zobrazení odměny za playtime
                        .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                        .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 4380h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "playtime_halfyear", "Vyzvednul jsi si odměnu za odehraný čas!");
                    CraftCoinsAPI.giveCoins(p, 500);
                }));
            } else {
                contents.set(2, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lOdehraný půlrok")
                        .setLore("§7Odměna za odehraných", "§74380 hodin (182,5 dne) na serveru.", "", "§7Odehráno: " + ChatColor.of("#38ff49") + getPlaytime(p) + "h z 4380h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC") // Odměny za odehraný čás úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }
        }


        // Discord
        // Ikonka kategorie
        ItemStack discord = SkullHeads.createHead(
                ChatColor.of("#face4b") + "§lDiscord",
                "de431cd1-ae1d-49f6-9339-a96daeacc32b",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19",
                ChatColor.of("#face4b") + "§lDiscord",
                "§7Podívej se doprava na odměny,", "§7které můžeš získat za aktivity", "§7spojené s Discordem.");
        ItemStack needToConnect = new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                .setName(ChatColor.of("#face4b") + "§lZamčená Discord odměna")
                .setLore("§cPro zobrazení této odměny", "§csi musíš nejprve propojit", "§cDiscord s Minecraftem." + ChatColor.of("#ded86a") + "/link")
                .hideAllFlags()
                .build();
        contents.set(3, 1, ClickableItem.empty(discord));

        // Propojení check
        if (Main.getInstance().getSQL().isConnectedToDiscord(p)) {
            //Propojení odměna
            if (claimed(p, "discord_connect")) {
                contents.set(3, 3, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lDiscord propojení")
                        .setLore("§7Odměna za to, že sis propojil", "§7Discord s Minecraftem.", "", ChatColor.of("#ded86a") + "Získal jsi: " + "500 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                contents.set(3, 3, ClickableItem.of(new ItemBuilder(Material.PAPER)
                        .setName(ChatColor.of("#face4b") + "§lDiscord propojení")
                        .setLore("§7Odměna za to, že sis propojil", "§7Discord s Minecraftem.", "", ChatColor.of("#ded86a") + "Dostaneš: " + "500 CC")
                        .hideAllFlags()
                        .build(), (clickEvent) -> {
                    claim(p, "discord_connect", "Dostáváš odměnu za popojení Discordu!");
                    CraftCoinsAPI.giveCoins(p, 500);
                }));
            }

            // Booster odměna
            if (Main.getInstance().getSQL().isDiscordBooster(p)) {
                if (claimed(p, "discord_booster")) {
                    contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                            .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                            .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Získal jsi: já nevím co")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                } else {
                    contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                            .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Dostaneš: já nevím co")
                            .hideAllFlags()
                            .build(), (clickEvent) -> {
                        claim(p, "discord_booster", "Dostáváš odměnu za boostování Discordu!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set craftmanager.discordbooster.reward"); // Příkaz, který se vykoná pro udělení odměny
                    }));
                }
            } else {
                contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                        .setName(ChatColor.of("#face4b") + "§lDiscord booster")
                        .setLore("§7Odměna za to, že boostíš", "§7náš Discord server.", "", ChatColor.of("#ded86a") + "Dostaneš: já nevím co") // Odměny za boostení úplně tak jako netuším no
                        .hideAllFlags()
                        .build(), e -> {
                }));
            }

            // Měsíční Discord volání
            //1h
            if (claimed(p, "discord_voice_activity_1h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 100 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(p) >= 1) {
                    contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 1h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(p, "discord_voice_activity_1h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        CraftCoinsAPI.giveCoins(p, 100);
                    }));
                } else {
                    contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíční provolaná hodina")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 1h", "", ChatColor.of("#ded86a") + "Dostaneš: 100 CC")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                }
            }
            //10h
            if (claimed(p, "discord_voice_activity_10h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 200 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(p) >= 10) {
                    contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 10h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(p, "discord_voice_activity_10h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        CraftCoinsAPI.giveCoins(p, 200);
                    }));
                } else {
                    contents.set(3, 6, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaných 10 hodin")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 10h", "", ChatColor.of("#ded86a") + "Dostaneš: 200 CC")
                            .hideAllFlags()
                            .build(), e -> {
                    }));
                }
            }
            //24h
            if (claimed(p, "discord_voice_activity_24h")) { // Pokud je odměna vyvzednuta
                contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100001)
                        .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                        .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "§cTy už ji máš tento měsíc vyzvednutou,", "§cpočkej si na příšťí!", "", ChatColor.of("#ded86a") + "Získal jsi: 500 CC")
                        .hideAllFlags()
                        .build(), e -> {
                }));
            } else {
                if (getDiscordVoiceActivityTime(p) >= 24) {
                    contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.PAPER)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC")
                            .hideAllFlags()
                            .build(), e -> {
                        claim(p, "discord_voice_activity_24h", "Vyzvednul jsi si odměnu za provolaný čas!");
                        CraftCoinsAPI.giveCoins(p, 500);
                    }));
                } else {
                    contents.set(3, 7, ClickableItem.of(new ItemBuilder(Material.IRON_NUGGET).setCustomModelData(100008)
                            .setName(ChatColor.of("#face4b") + "§lMěsíčně provolaný den")
                            .setLore("§7Odměnu za provolaný čas", "§7si můžeš vyzvednout každý měsíc.", "", "§7Provoláno: " + ChatColor.of("#38ff49") + getDiscordVoiceActivityTime(p) + "h z 24h", "", ChatColor.of("#ded86a") + "Dostaneš: 500 CC")
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
    public void update(Player p, InventoryContents contents) {
    }

    private int rewardFromDay(int day) {
        switch (day) {
            case 0:
                return 10;
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            case 4:
                return 50;
            case 5:
                return 60;
            case 6:
            case -1:
                return 100;
            default: // Nemělo by nastat
                return 0;
        }
    }

    private int streak(Player p) {
        return Main.getInstance().getSQL().getPlayerProfileDataIntNoUUID(p, "lobby_bonus_streak");
    }

    // Ziskání denního streaku (1-7. den)
    private int dayStreak(Player p) {
        int rawStreak = Main.getInstance().getSQL().getPlayerProfileDataInt(p, "lobby_bonus_streak");
        while (rawStreak > 6) {
            rawStreak = rawStreak - 7;
        }
        return rawStreak;
    }

    private boolean dailyCraftToken(Player p) {
        if (claimed(p, "daily")) {
            return streak(p) % 30 == 0;
        } else {
            return (streak(p) + 1) % 30 == 0;
        }

    }

    private String dailyCraftTokenMessage(Player p) {
        if (dailyCraftToken(p)) {
            return " + 1 CT";
        } else {
            return "";
        }
    }

    // VIP odměny
    private int monthlyVipCoins(Player p) {
        if (p.hasPermission("craftlobby.vip.odmena.obsidian")) {
            return 2000;
        } else if (p.hasPermission("craftlobby.vip.odmena.emerald")) {
            return 1500;
        } else if (p.hasPermission("craftlobby.vip.odmena.diamond")) {
            return 1000;
        } else {
            return 500;
        }
    }

    // Hodinový playtime
    private int getPlaytime(Player p) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(p, "played_time") / 60;
    }

    // Hodinová měsíční Discord voice aktivita
    private int getDiscordVoiceActivityTime(Player p) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(p, "month_discord_voice_activity") / 3600;
    }

    // Claimed
    private boolean claimed(Player p, String type) {
        return Main.getInstance().getSQL().getPlayerProfileDataInt(p, "lobby_bonus_claimed_" + type) == 1;
    }

    private void claim(Player p, String type, String message) {
        if (type == "daily") {
            CraftCoinsAPI.giveCoins(p, rewardFromDay(dayStreak(p)));
            if (dailyCraftToken(p)) {
                CraftTokensAPI.giveTokens(p, 1);
            }
            Main.getInstance().getSQL().increaseBonusStreak(p);
        }
        Main.getInstance().getSQL().bonusClaim(p, type);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 13.0F, 1.0F);
        p.sendTitle(ChatColor.of("#face4b") + "GoldenPig", ChatColor.of("#ded86a") + message, 5, 40, 5);
    }
}
