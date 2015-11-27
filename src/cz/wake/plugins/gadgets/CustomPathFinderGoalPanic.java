package cz.wake.plugins.gadgets;

import net.minecraft.server.v1_8_R3.EntityCreature;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.PathfinderGoal;
import net.minecraft.server.v1_8_R3.RandomPositionGenerator;
import net.minecraft.server.v1_8_R3.Vec3D;

public class CustomPathFinderGoalPanic extends PathfinderGoal{
	
	private EntityCreature b;
	  protected double a;
	  private double c;
	  private double d;
	  private double e;
	  
	  public CustomPathFinderGoalPanic(EntityCreature entitycreature, double d0)
	  {
	    this.b = entitycreature;
	    this.a = d0;
	    a(1);
	  }
	  
	  public boolean a()
	  {
	    Vec3D vec3d = RandomPositionGenerator.a(this.b, 5, 4);
	    this.c = vec3d.a;
	    this.d = vec3d.b;
	    this.e = vec3d.c;
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
	    return !this.b.getNavigation().m();
	  }

}
