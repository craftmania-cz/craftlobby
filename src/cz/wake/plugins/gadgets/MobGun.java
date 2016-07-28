package cz.wake.plugins.gadgets;

import cz.wake.plugins.API.CustomEntityFirework;
import cz.wake.plugins.Main;
import cz.wake.plugins.listeners.MessagesListener;
import cz.wake.plugins.utils.ParticleEffect;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class MobGun implements Listener {

    private Main plugin;

    public MobGun(Main plugin) {
        this.plugin = plugin;
    }

    private HashMap<Player, Double> _time = new HashMap();
    HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();


    @EventHandler
    public void MobGunInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final Vector dir = p.getLocation().getDirection().multiply(0.6584787554D);
        ItemStack item = e.getItem();
        Action action = e.getAction();

        if (item == null) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getType().equals(Material.BLAZE_ROD)) {
            return;
        }
        if (!item.getItemMeta().getDisplayName().startsWith("§6§lMob Gun §f§l- §b§l")) {
            return;
        }
        String mobName = item.getItemMeta().getDisplayName().replace("§6§lMob Gun §f§l- §b§l", "");
        if (!p.hasPermission("craftlobby.gadget.mobgun")) {
            return;
        }
        e.setCancelled(true);
        if ((action.equals(Action.RIGHT_CLICK_AIR)) ||
                (action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (this._time.containsKey(p)) {
                MessagesListener.messageCooldown(p, String.valueOf(arrondi(((Double) this._time.get(p)).doubleValue(), 1)));
                return;
            }
            this._time.put(p, Double.valueOf(30D + 0.1D));
            this._cdRunnable.put(p, new BukkitRunnable() {
                @Override
                public void run() {
                    MobGun.this._time.put(p, Double.valueOf(((Double) MobGun.this._time.get(p)).doubleValue() - 0.1D));
                    if (((Double) MobGun.this._time.get(p)).doubleValue() < 0.01D) {
                        MobGun.this._time.remove(p);
                        MobGun.this._cdRunnable.remove(p);
                        cancel();
                    }
                }
            });
            ((BukkitRunnable) this._cdRunnable.get(p)).runTaskTimer(this.plugin, 2L, 2L);
            if (mobName.equals("Pig")) {
                final Pig pig = (Pig) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.PIG);
                pig.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                pig.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, pig.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(pig.getLocation());
                        pig.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Villager")) {
                final Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.VILLAGER);
                villager.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                villager.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, villager.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(villager.getLocation());
                        villager.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Ocelot")) {
                final Ocelot ocelot = (Ocelot) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.OCELOT);
                ocelot.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                ocelot.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, ocelot.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(ocelot.getLocation());
                        ocelot.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Cow")) {
                final Cow cow = (Cow) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.COW);
                cow.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                cow.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, cow.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(cow.getLocation());
                        cow.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Creeper")) {
                final Creeper creeper = (Creeper) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.CREEPER);
                creeper.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                creeper.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, creeper.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(creeper.getLocation());
                        creeper.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Spider")) {
                final Spider spider = (Spider) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SPIDER);
                spider.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                spider.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, spider.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(spider.getLocation());
                        spider.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Squid")) {
                final Squid squid = (Squid) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SQUID);
                squid.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                squid.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, squid.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(squid.getLocation());
                        squid.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Chicken")) {
                final Chicken chicken = (Chicken) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.CHICKEN);
                chicken.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                chicken.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, chicken.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(chicken.getLocation());
                        chicken.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Sheep")) {
                final Sheep sheep = (Sheep) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SHEEP);
                sheep.getLocation().setDirection(dir);
                sheep.setCustomName("jeb_");

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                sheep.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, sheep.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(sheep.getLocation());
                        sheep.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Wolf")) {
                final Wolf wolf = (Wolf) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.WOLF);
                wolf.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                wolf.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, wolf.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(wolf.getLocation());
                        wolf.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Slime")) {
                final Slime slime = (Slime) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SLIME);
                slime.getLocation().setDirection(dir);
                slime.setSize(3);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                slime.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, slime.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(slime.getLocation());
                        slime.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Magma Cube")) {
                final MagmaCube magmaCube = (MagmaCube) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.MAGMA_CUBE);
                magmaCube.getLocation().setDirection(dir);
                magmaCube.setSize(2);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                magmaCube.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, magmaCube.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(magmaCube.getLocation());
                        magmaCube.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Horse")) {
                final Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.HORSE);
                horse.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                horse.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, horse.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(horse.getLocation());
                        horse.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Zombie")) {
                final Zombie zombie = (Zombie) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.ZOMBIE);
                zombie.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                zombie.setVelocity(dir);
                                zombie.setFireTicks(0);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, zombie.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(zombie.getLocation());
                        zombie.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Skeleton")) {
                final Skeleton skeleton = (Skeleton) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.SKELETON);
                skeleton.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                skeleton.setVelocity(dir);
                                skeleton.setFireTicks(0);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, skeleton.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(skeleton.getLocation());
                        skeleton.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Mooshroom")) {
                final MushroomCow mushroomCow = (MushroomCow) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.MUSHROOM_COW);
                mushroomCow.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                mushroomCow.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, mushroomCow.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(mushroomCow.getLocation());
                        mushroomCow.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Cave Spider")) {
                final CaveSpider caveSpider = (CaveSpider) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.CAVE_SPIDER);
                caveSpider.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                caveSpider.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, caveSpider.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(caveSpider.getLocation());
                        caveSpider.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Rabbit")) {
                final Rabbit rabbit = (Rabbit) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.RABBIT);
                rabbit.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                rabbit.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, rabbit.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(rabbit.getLocation());
                        rabbit.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            } else if (mobName.equals("Pig Zombie")) {
                final PigZombie pigZombie = (PigZombie) p.getWorld().spawnEntity(p.getLocation().add(0.0D, 2.0D, 0.0D), EntityType.PIG_ZOMBIE);
                pigZombie.getLocation().setDirection(dir);

                final Integer task =

                        Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable() {
                            public void run() {
                                pigZombie.setVelocity(dir);
                                ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.1F, 10, pigZombie.getLocation(), 15.0D);
                            }
                        }, 4L, 4L).getTaskId());

                Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                    public void run() {
                        MobGun.LaunchRandomFirework(pigZombie.getLocation());
                        pigZombie.remove();
                        Bukkit.getScheduler().cancelTask(task.intValue());
                    }
                }, 60L);
            }
        } else if ((action.equals(Action.LEFT_CLICK_AIR)) ||
                (action.equals(Action.LEFT_CLICK_BLOCK))) {
            ItemMeta itemMeta = item.getItemMeta();
            if (mobName.equals("Pig")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lVillager");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Villager")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lOcelot");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Ocelot")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCow");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Cow")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCreeper");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Creeper")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSpider");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Spider")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSquid");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Squid")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lChicken");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Chicken")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSheep");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Sheep")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lWolf");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Wolf")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSlime");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Slime")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lMagma Cube");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Magma Cube")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lHorse");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Horse")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lZombie");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Zombie")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSkeleton");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Skeleton")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lMooshroom");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Mooshroom")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCave Spider");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Cave Spider")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lRabbit");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Rabbit")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lPig Zombie");
                item.setItemMeta(itemMeta);
            } else if (mobName.equals("Pig Zombie")) {
                itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lPig");
                item.setItemMeta(itemMeta);
            }
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        if (((e.getEntity() instanceof Creeper))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        e.setCancelled(true);
    }

    public static double arrondi(double A, int B) {
        return (int) (A * Math.pow(10.0D, B) + 0.5D) / Math.pow(10.0D, B);
    }

    public static void LaunchRandomFirework(Location location) {
        FireworkEffect.Builder builder = FireworkEffect.builder();
        if (RandomUtils.nextInt(3) == 0) {
            builder.withTrail();
        } else if (RandomUtils.nextInt(2) == 0) {
            builder.withFlicker();
        }
        builder.with(FireworkEffect.Type.BALL_LARGE);

        int colorCount = 17;

        builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
        while (RandomUtils.nextInt(colorCount) != 0) {
            builder.withColor(Color.fromRGB(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
            colorCount--;
        }
        FireworkEffect effect = builder.build();
        CustomEntityFirework.spawn(location, effect, new Player[0]);
    }


}
