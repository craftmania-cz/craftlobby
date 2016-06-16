package cz.wake.plugins.utils.mobs;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftRabbit;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_9_R2.Entity;
import net.minecraft.server.v1_9_R2.EntityHuman;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.EntityRabbit;
import net.minecraft.server.v1_9_R2.GenericAttributes;
import net.minecraft.server.v1_9_R2.MathHelper;
import net.minecraft.server.v1_9_R2.World;

public class RideableRabbit extends EntityRabbit{
	
	protected Field FIELD_JUMP = null;
	 
    public RideableRabbit(World world) {
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
        	this.pitch = passenger.pitch * 0.5F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aI = this.yaw;
            f = ((EntityLiving)this.passengers).az * 0.5F;
            f1 = ((EntityLiving)this.passengers).be;
 
            if(f1 <= 0.0F)
            {
                f1 *= 0.25F;
            }
              try {
                if (FIELD_JUMP.getBoolean(this.passengers) && this.onGround) {
                    this.motY += 1F;
                    if (f1 > 0.0F)
                    {
                        float f2 = MathHelper.sin(this.yaw * 3.141593F / 180.0F);
                        float f3 = MathHelper.cos(this.yaw * 3.141593F / 180.0F);
 
                        this.motX += -0.4F * f2 * ((EntityInsentient) this).aA();
                        this.motZ += 0.4F * f3 * ((EntityInsentient) this).bH();
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
                f4 = 1.0F;
            }
 
            this.aB += (f4 - this.aB) * 0.4F; this.aC += this.aB;
        } else {
            this.P = 0.5F; this.aM = 0.02F; super.g(f, f1);
        }
    }
 
    public static Rabbit spawn(Location location)
    {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
 
        RideableRabbit customEntity = new RideableRabbit(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(),location.getZ(), location.getYaw(), location.getPitch());
 
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
 
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
 
        customEntity.setCustomName("");
        customEntity.setCustomNameVisible(false);
 
        return (CraftRabbit) customEntity.getBukkitEntity();
    } */

}
