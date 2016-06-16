package cz.wake.plugins.utils.mobs;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftHorse;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.entity.Horse;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_9_R2.Entity;
import net.minecraft.server.v1_9_R2.EntityHorse;
import net.minecraft.server.v1_9_R2.EntityHuman;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.GenericAttributes;
import net.minecraft.server.v1_9_R2.MathHelper;
import net.minecraft.server.v1_9_R2.World;

public class RideableHorse extends EntityHorse{

    protected Field FIELD_JUMP = null;

    public RideableHorse(World world) {
        super(world);

        if (FIELD_JUMP == null) {
            try {
                FIELD_JUMP = EntityLiving.class.getDeclaredField("aY");
                FIELD_JUMP.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
    /*

    @Override
    public void g(float f, float f1) {
        Entity passenger = null;
        if(this.passengers != null && this.passengers instanceof EntityHuman)
        {
            for (Entity ent : this.passengers) {
                passenger = ent;
            }
            this.lastYaw = this.yaw = passenger.yaw;
            this.pitch = passenger.pitch * 1F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aI = this.yaw;
            f = ((EntityLiving)passenger).bd * 2F;
            f1 = ((EntityLiving)passenger).be;

            if(f1 <= 0.0F)
            {
                f1 *= 0.50F;
            }
            try {
                if (FIELD_JUMP.getBoolean(passenger) && this.onGround) {
                    this.motY += 3F;
                    if (f1 > 0.0F)
                    {
                        float f2 = MathHelper.sin(this.yaw * 3.141593F / 180.0F);
                        float f3 = MathHelper.cos(this.yaw * 3.141593F / 180.0F);

                        this.motX += -0.5F * f2 * ((EntityInsentient) this).az;
                        this.motZ += 0.5F * f3 * ((EntityInsentient) this).bf;
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

            this.P = 2F; this.aM = this.yaw * 0.2F; if(!this.world.isClientSide)
        {
            this.k((float)this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue());
            super.g(f, f1);
        }

            this.aa = this.at; double d0 = this.locX - this.lastX; double d1 = this.locZ - this.lastZ; float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
            if(f4 > 1.0F)
            {
                f4 = 0.5F;
            }

            this.aB += (f4 - this.aB) * 0.4F; this.aC += this.aB;
        } else {
            this.P = 1F; this.aM = 0.04F; super.g(f, f1);
        }
    }

    public static Horse spawn(Location location)
    {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();

        RideableHorse customEntity = new RideableHorse(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(),location.getZ(), location.getYaw(), location.getPitch());

        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);

        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);

        customEntity.setCustomName("");
        customEntity.setCustomNameVisible(false);

        return (CraftHorse) customEntity.getBukkitEntity();
    }
*/
}
