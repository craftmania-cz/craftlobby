package cz.wake.plugins.utils.mobs;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftSheep;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_9_R2.Entity;
import net.minecraft.server.v1_9_R2.EntityHuman;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.EntitySheep;
import net.minecraft.server.v1_9_R2.GenericAttributes;
import net.minecraft.server.v1_9_R2.MathHelper;
import net.minecraft.server.v1_9_R2.World;

public class RideableSheep extends EntitySheep{
	
	protected Field FIELD_JUMP = null;
	 
    public RideableSheep(World world) {
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

    @Override
    public void g(float f, float f1) {
        Entity passenger = null;
        for (Entity ent : this.passengers) {
            passenger = ent;
        }
        if(passenger != null && passenger instanceof EntityHuman)
        {
            this.lastYaw = this.yaw = passenger.yaw;
            this.pitch = passenger.pitch * 0.5F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aJ = this.yaw;
            f = ((EntityLiving)passenger).be * 0.5F;
            f1 = ((EntityLiving)passenger).bf;

            if(f1 <= 0.0F)
            {
                f1 *= 0.25F;
            }
            Field jump = null;
            try {
                jump = EntityLiving.class.getDeclaredField("bd");
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            }
            jump.setAccessible(true);

            if (jump != null && this.onGround) {
                try {
                    if (jump.getBoolean(passenger)) {
                        double jumpHeight = 0.7D; //vyska skakani!
                        this.motY = jumpHeight;
                    }
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }

            this.P = 1.0F; this.aM = this.yaw * 0.1F; if(!this.world.isClientSide)
        {
            this.k((float)this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).getValue());
            super.g(f, f1);
        }

            this.aD = this.ab; double d0 = this.locX - this.lastX; double d1 = this.locZ - this.lastZ; float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
            if(f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.aC += (f4 - this.aC) * 0.4F; this.aC += this.aC;
        } else {
            this.P = 0.5F; this.aM = 0.02F; super.g(f, f1);
        }

    }
 
    public static Sheep spawn(Location location)
    {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
 
        RideableSheep customEntity = new RideableSheep(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(),location.getZ(), location.getYaw(), location.getPitch());
 
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
 
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
 
        customEntity.setCustomName("");
        customEntity.setCustomNameVisible(false);
 
        return (CraftSheep) customEntity.getBukkitEntity();
    }

}
