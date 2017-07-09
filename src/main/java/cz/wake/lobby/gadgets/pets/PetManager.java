package cz.wake.lobby.gadgets.pets;

import cz.wake.lobby.Main;
import net.minecraft.server.v1_11_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetManager implements Listener {

    public static Map<Player, CraftEntity> pet = new HashMap();

    private Main plugin;

    public PetManager(Main plugin) {
        this.plugin = plugin;
    }

    public static void PetFollow(final Player player, final org.bukkit.entity.Entity pet, final double speed, final double distance) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if ((!pet.isValid() || (!player.isOnline()))) {
                    this.cancel();
                }
                net.minecraft.server.v1_11_R1.Entity pett = ((CraftEntity) pet).getHandle();
                ((EntityInsentient) pett).getNavigation().a(2);
                Object petf = ((CraftEntity) pet).getHandle();
                Location targetLocation = player.getLocation();
                PathEntity path;
                path = ((EntityInsentient) petf).getNavigation().a(targetLocation.getX() + distance, targetLocation.getY(), targetLocation.getZ() + distance);
                if (path != null) {
                    ((EntityInsentient) petf).getNavigation().a(path, 1.0D);
                    ((EntityInsentient) petf).getNavigation().a(2.0D);
                }
                if (player.getWorld().getName().equalsIgnoreCase(pet.getWorld().getName())) {
                    if (!player.isOnline()) {
                        pet.remove();
                    } else {
                        int distance = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
                        if (distance > 10 && !pet.isDead() && player.isOnGround()) {
                            pet.teleport(player.getLocation());
                        }
                    }
                } else {
                    if (!player.isOnline()) {
                        pet.remove();
                    } else {
                        pet.teleport(player);
                    }
                }
                if (player.isOnline()) {
                    int distance = (int) Bukkit.getPlayer(player.getName()).getLocation().distance(pet.getLocation());
                    if (distance > 10 && !pet.isDead() && player.isOnGround()) {
                        pet.teleport(player.getLocation());
                    }
                }
                AttributeInstance attributes = ((EntityInsentient) ((CraftEntity) pet).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
                attributes.setValue(speed);
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 20L);
    }

    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent e) {
        Entity localEntity = e.getEntity();
        if (!(localEntity instanceof Enderman)) {
            return;
        }
        if (localEntity.hasMetadata("Pet")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PetRemoveOnLeave(PlayerQuitEvent e) {
        Player localPlayer = e.getPlayer();
        for (Entity localEntity : localPlayer.getWorld().getEntities()) {
            if (localEntity == pet.get(localPlayer)) {
                pet.remove(localEntity);
                localEntity.remove();
            }
        }
    }

    @EventHandler
    public void PetRemoveOnLeave(PlayerKickEvent e) {
        Player localPlayer = e.getPlayer();
        for (Entity localEntity : localPlayer.getWorld().getEntities()) {
            if (localEntity == pet.get(localPlayer)) {
                pet.remove(localEntity);
                localEntity.remove();
            }
        }
    }

    @EventHandler
    public void MobOnFire(EntityCombustEvent e) {
        Entity localEntity = e.getEntity();
        if ((!(localEntity instanceof Skeleton)) && (!(localEntity instanceof Zombie))) {
            return;
        }
        if (localEntity.hasMetadata("Pet")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTarget(EntityTargetEvent e) {
        Entity entity = e.getEntity();

        if(!(e.getTarget() instanceof Player)){
            e.setCancelled(true);
        }

        if(entity instanceof Evoker){
            if(PetManager.pet.containsKey((Player)e.getTarget())){
                e.setCancelled(true);
            }
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        LivingEntity mob = (LivingEntity) e.getRightClicked();

        if (mob.getType() == EntityType.ENDERMITE) {
            player.sendMessage("§cNa tohoto moba nelze nasednou!");
            return;
        }
        //Easter Egg
        if (mob.getType() == EntityType.PLAYER) {
            if(player.isSneaking()){
                if(PetManager.pet.containsKey(player)){
                    Entity ent = PetManager.pet.get(player);
                    if(ent instanceof Evoker){
                        ((Evoker)ent).setTarget(mob);
                        player.sendMessage("§eEvoker ted bude minutu utocit na §f" + mob.getName());
                        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new BukkitRunnable() {
                            @Override
                            public void run() {
                                ((Evoker)ent).setTarget(null);
                            }
                        }, 1200L);
                    }
                }
            }
            return;
        }
        if (mob.getType() == EntityType.PRIMED_TNT) {
            return;
        }
        if (mob.getType() == EntityType.WITHER_SKULL) {
            return;
        }
        if (mob.getType() == EntityType.VEX) {
            return;
        }
        if (mob.getType() == EntityType.WITHER) {
            player.sendMessage("§cNa tohoto moba nelze nasednou!");
            return;
        }
        if (mob.getType() == EntityType.BAT) {
            return;
        }
        if ((mob.getName().contains(player.getName()))) {
            mob.setPassenger(player);

            PacketPlayOutMount packet = new PacketPlayOutMount(((CraftPlayer) player).getHandle());
            for (Player p : player.getWorld().getPlayers()) {
                ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
            }
        } else {
            if(mob instanceof Horse){
                e.setCancelled(true);
                player.sendMessage("§cTento mob neni tvuj!");
                return;
            }
            player.sendMessage("§cTento mob neni tvuj!");
        }
    }

    public static void forceRemovePet(Player p) {
        for (Entity localEntity : p.getWorld().getEntities()) {
            if (localEntity == pet.get(p)) {
                pet.remove(localEntity);
                localEntity.remove();
            }
        }
        if (CowNormal.cp.contains(p.getName())) {
            CowNormal.cp.remove(p.getName());
        }
        if (PigNormal.pn.contains(p.getName())) {
            PigNormal.pn.remove(p.getName());
        }
        if (CatNormal.cb.contains(p.getName())) {
            CatNormal.cb.remove(p.getName());
        }
        if (ChickenNormal.cn.contains(p.getName())) {
            ChickenNormal.cn.remove(p.getName());
        }
        if (EndermiteNormal.en.contains(p.getName())) {
            EndermiteNormal.en.remove(p.getName());
        }
        if (SilverfishNormal.sn.contains(p.getName())) {
            SilverfishNormal.sn.remove(p.getName());
        }
        if (WolfNormal.wn.contains(p.getName())) {
            WolfNormal.wn.remove(p.getName());
        }
        if (RabbitNormal.rb.contains(p.getName())) {
            RabbitNormal.rb.remove(p.getName());
        }
        if (ZombieNormal.zn.contains(p.getName())) {
            ZombieNormal.zn.remove(p.getName());
        }
        if (HorseNormal.hb.contains(p.getName())) {
            HorseNormal.hb.remove(p.getName());
        }
        if (SheepNormal.sb.contains(p.getName())) {
            SheepNormal.sb.remove(p.getName());
        }
        if (MushroomNormal.cp.contains(p.getName())) {
            MushroomNormal.cp.remove(p.getName());
        }
        if (SlimeNormal.pn.contains(p.getName())) {
            SlimeNormal.pn.remove(p.getName());
        }
        if (SpiderNormal.pn.contains(p.getName())) {
            SpiderNormal.pn.remove(p.getName());
        }
        if (CaveSpiderNormal.cn.contains(p.getName())) {
            CaveSpiderNormal.cn.remove(p.getName());
        }
        if (IronGolemNormal.cn.contains(p.getName())) {
            IronGolemNormal.cn.remove(p.getName());
        }
        if (WitchNormal.cn.contains(p.getName())) {
            WitchNormal.cn.remove(p.getName());
        }
        if (EndermanNormal.cn.contains(p.getName())) {
            EndermanNormal.cn.remove(p.getName());
        }
        if (BlazeNormal.cn.contains(p.getName())) {
            BlazeNormal.cn.remove(p.getName());
        }
        if (BatNormal.en.contains(p.getName())) {
            BatNormal.en.remove(p.getName());
        }
        if (VilagerNormal.cn.contains(p.getName())) {
            VilagerNormal.cn.remove(p.getName());
        }
        if (CreeperNormal.cn.contains(p.getName())) {
            CreeperNormal.cn.remove(p.getName());
        }
        if (EndermiteNormal.en.contains(p.getName())) {
            EndermiteNormal.en.remove(p.getName());
        }
        if (VindicatorNormal.cn.contains(p.getName())) {
            VindicatorNormal.cn.remove(p.getName());
        }
        if (EvokerNormal.cn.contains(p.getName())) {
            EvokerNormal.cn.remove(p.getName());
        }
    }
}
