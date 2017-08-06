package cz.wake.lobby.utils.mobs;

import net.minecraft.server.v1_11_R1.EntityHorse;
import net.minecraft.server.v1_11_R1.EntityHuman;
import net.minecraft.server.v1_11_R1.EntityLiving;
import net.minecraft.server.v1_11_R1.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftHorse;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Horse;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import java.lang.reflect.Field;

public class RideableHorse extends EntityHorse {

    public RideableHorse(World world) {
        super(world);
    }

    @Override
    public void g(float sideMot, float forMot) {
        if (this.passengers != null) {

            if (passengers.isEmpty() || !(passengers.get(0) instanceof EntityHuman)) {
                super.g(sideMot, forMot);
                return;
            }

            EntityLiving passenger = (EntityLiving) this.passengers.get(0);
            this.yaw = passenger.yaw;
            this.lastYaw = this.yaw;
            this.pitch = (passenger.pitch * 0.5F);
            setYawPitch(this.yaw, this.pitch);
            this.aN = this.yaw;
            this.aP = this.aN;

            Float speedmultiplicator = 3F;//Here you can set the speed
            sideMot = passenger.be * speedmultiplicator;
            forMot = passenger.bf * speedmultiplicator;
            if (forMot <= 0.0F) {
                forMot *= 0.25F;// Make backwards slower
            }
            Field jump = null; //Jumping
            try {
                jump = EntityLiving.class.getDeclaredField("bd");
            } catch (NoSuchFieldException | SecurityException e1) {
                e1.printStackTrace();
            }
            jump.setAccessible(true);

            if (jump != null && this.onGround) {     // Wouldn't want it jumping while on the ground would we?
                try {
                    if (jump.getBoolean(passenger)) {
                        double jumpHeight = 0.5D;     //Here you can set the jumpHeight
                        this.motY = jumpHeight;        // Used all the time in NMS for entity jumping
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            super.g(sideMot, forMot);
        }
    }

    public static Horse spawn(Location location) {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();

        RideableHorse customEntity = new RideableHorse(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());

        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);

        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);

        customEntity.setCustomName("");
        customEntity.setCustomNameVisible(false);

        return (CraftHorse) customEntity.getBukkitEntity();
    }
}
