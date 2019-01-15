package cz.wake.lobby.utils.mobs;

import cz.wake.lobby.utils.wrapper.WrapperEntityHuman;
import cz.wake.lobby.utils.wrapper.WrapperEntityInsentient;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftCow;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Cow;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import java.lang.reflect.Field;

public class RideableCow extends EntityCow implements EntityBase {

    public RideableCow(World world) {
        super(world);
    }


    @Override
    public void a(float sideMot, float forMot, float f2) {
        EntityHuman passenger = null;
        if (!bF().isEmpty()) {
            passenger = (EntityHuman) bF().get(0);
        }
        ride(sideMot, forMot, passenger, this);
    }

    @Override
    public void g_(float sideMot, float forMot) {
        super.g(sideMot, forMot);
    }

    public org.bukkit.entity.Entity getEntity() {
        return getBukkitEntity();
    }

    @Override
    public float getSpeed() {
        return 1;
    }

    @Override
    public boolean canFly() {
        return false;
    }

    public static Cow spawn(Location location) {
        World mcWorld = ((CraftWorld) location.getWorld()).getHandle();

        RideableCow customEntity = new RideableCow(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());

        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);

        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);

        customEntity.setCustomName("");
        customEntity.setCustomNameVisible(false);

        return (CraftCow) customEntity.getBukkitEntity();
    }

    static void ride(float sideMot, float forMot, EntityHuman passenger, EntityInsentient entity) {
        if (!(entity instanceof EntityBase)) {
            throw new IllegalArgumentException("The entity field should implements EntityBase");
        }

        EntityBase entityBase = (EntityBase) entity;

        WrapperEntityInsentient wEntity = new WrapperEntityInsentient(entity);
        WrapperEntityHuman wPassenger = new WrapperEntityHuman(passenger);

        if (passenger != null) {
            entity.lastYaw = entity.yaw = passenger.yaw % 360f;
            entity.pitch = (passenger.pitch * 0.5F) % 360f;

            wEntity.setRenderYawOffset(entity.yaw);
            wEntity.setRotationYawHead(entity.yaw);

            sideMot = wPassenger.getMoveStrafing() * 0.25f;
            forMot = wPassenger.getMoveForward() * 0.5f;

            if (forMot <= 0.0F) {
                forMot *= 0.25F;
            }

            System.out.println("Prd?");

            wEntity.setJumping(wPassenger.isJumping());

            if (wPassenger.isJumping() && (entity.onGround || entityBase.canFly())) {
                entity.motY = 0.4D;

                float f2 = MathHelper.sin(entity.yaw * 0.017453292f);
                float f3 = MathHelper.cos(entity.yaw * 0.017453292f);
                entity.motX += (double) (-0.4f * f2);
                entity.motZ += (double) (0.4f * f3);
            }

            wEntity.setStepHeight(1.0f);
            wEntity.setJumpMovementFactor(wEntity.getMoveSpeed() * 0.1f);

            wEntity.setRotationYawHead(entity.yaw);

            wEntity.setMoveSpeed(0.35f * entityBase.getSpeed());
            entityBase.g_(sideMot, forMot);


            wEntity.setPrevLimbSwingAmount(wEntity.getLimbSwingAmount());

            double dx = entity.locX - entity.lastX;
            double dz = entity.locZ - entity.lastZ;

            float f4 = MathHelper.sqrt(dx * dx + dz * dz) * 4;

            if (f4 > 1)
                f4 = 1;

            wEntity.setLimbSwingAmount(wEntity.getLimbSwingAmount() + (f4 - wEntity.getLimbSwingAmount()) * 0.4f);
            wEntity.setLimbSwing(wEntity.getLimbSwing() + wEntity.getLimbSwingAmount());
        } else {
            wEntity.setStepHeight(0.5f);
            wEntity.setJumpMovementFactor(0.02f);

            entityBase.g_(sideMot, forMot);
        }
    }
}
