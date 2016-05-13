package cz.wake.plugins.gadgets;

import net.minecraft.server.v1_9_R1.EntityCreature;
import net.minecraft.server.v1_9_R1.EntityLiving;
import net.minecraft.server.v1_9_R1.PathfinderGoal;
import net.minecraft.server.v1_9_R1.RandomPositionGenerator;
import net.minecraft.server.v1_9_R1.Vec3D;

public class CustomPathFinderGoalPanic extends PathfinderGoal{
	
	//Entita
	private EntityCreature b;
	
	//Speed
	protected double a;
	
	//random PosX
	private double c;
	
	//random PosY
	private double d;
	
	//random PosZ
	private double e;
	  
	  public CustomPathFinderGoalPanic(EntityCreature entitycreature, double d0)
	  {
	    this.b = entitycreature;
	    this.a = d0;
	    a(1);
	  }
	  
	  @Override
	  public boolean a()
	  {
	    Vec3D vec3d = RandomPositionGenerator.a(this.b, 5, 4);
	    if (vec3d == null) return false;
	    this.c = vec3d.x;
	    this.d = vec3d.y;
	    this.e = vec3d.z;
	    return true;
	  }
	  
	  public void c()
	  {
	    this.b.getNavigation().a(this.c, this.d, this.e, this.a);
	  }
	  
	  public boolean b()
	  {
	    if (this.b.ticksLived - this.b.hurtTimestamp > 100)
	    {
	      this.b.b((EntityLiving)null);
	      return false;
	    }
	    return !this.b.getNavigation().n();
	  }

}
