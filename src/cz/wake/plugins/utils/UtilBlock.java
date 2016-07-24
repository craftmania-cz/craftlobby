package cz.wake.plugins.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import cz.wake.plugins.Main;

public class UtilBlock
{
  public static HashSet<Byte> blockPassSet = new HashSet();
  public static Map<Location, String> blocksToRestore = new HashMap();
  
  public static boolean solid(Block block)
  {
    if (block == null) {
      return false;
    }
    return solid(block.getTypeId());
  }
  
  public static boolean solid(int block)
  {
    return solid((byte)block);
  }
  
  public static boolean solid(byte block)
  {
    if (blockPassSet.isEmpty())
    {
      blockPassSet.add(Byte.valueOf((byte)0));
      blockPassSet.add(Byte.valueOf((byte)6));
      blockPassSet.add(Byte.valueOf((byte)8));
      blockPassSet.add(Byte.valueOf((byte)9));
      blockPassSet.add(Byte.valueOf((byte)10));
      blockPassSet.add(Byte.valueOf((byte)11));
      blockPassSet.add(Byte.valueOf((byte)26));
      blockPassSet.add(Byte.valueOf((byte)27));
      blockPassSet.add(Byte.valueOf((byte)28));
      blockPassSet.add(Byte.valueOf((byte)30));
      blockPassSet.add(Byte.valueOf((byte)31));
      blockPassSet.add(Byte.valueOf((byte)32));
      blockPassSet.add(Byte.valueOf((byte)37));
      blockPassSet.add(Byte.valueOf((byte)38));
      blockPassSet.add(Byte.valueOf((byte)39));
      blockPassSet.add(Byte.valueOf((byte)40));
      blockPassSet.add(Byte.valueOf((byte)50));
      blockPassSet.add(Byte.valueOf((byte)51));
      blockPassSet.add(Byte.valueOf((byte)55));
      blockPassSet.add(Byte.valueOf((byte)59));
      blockPassSet.add(Byte.valueOf((byte)63));
      blockPassSet.add(Byte.valueOf((byte)64));
      blockPassSet.add(Byte.valueOf((byte)65));
      blockPassSet.add(Byte.valueOf((byte)66));
      blockPassSet.add(Byte.valueOf((byte)68));
      blockPassSet.add(Byte.valueOf((byte)69));
      blockPassSet.add(Byte.valueOf((byte)70));
      blockPassSet.add(Byte.valueOf((byte)71));
      blockPassSet.add(Byte.valueOf((byte)72));
      blockPassSet.add(Byte.valueOf((byte)75));
      blockPassSet.add(Byte.valueOf((byte)76));
      blockPassSet.add(Byte.valueOf((byte)77));
      blockPassSet.add(Byte.valueOf((byte)78));
      blockPassSet.add(Byte.valueOf((byte)83));
      blockPassSet.add(Byte.valueOf((byte)90));
      blockPassSet.add(Byte.valueOf((byte)92));
      blockPassSet.add(Byte.valueOf((byte)93));
      blockPassSet.add(Byte.valueOf((byte)94));
      blockPassSet.add(Byte.valueOf((byte)96));
      blockPassSet.add(Byte.valueOf((byte)101));
      blockPassSet.add(Byte.valueOf((byte)102));
      blockPassSet.add(Byte.valueOf((byte)104));
      blockPassSet.add(Byte.valueOf((byte)105));
      blockPassSet.add(Byte.valueOf((byte)106));
      blockPassSet.add(Byte.valueOf((byte)107));
      blockPassSet.add(Byte.valueOf((byte)111));
      blockPassSet.add(Byte.valueOf((byte)115));
      blockPassSet.add(Byte.valueOf((byte)116));
      blockPassSet.add(Byte.valueOf((byte)117));
      blockPassSet.add(Byte.valueOf((byte)118));
      blockPassSet.add(Byte.valueOf((byte)119));
      blockPassSet.add(Byte.valueOf((byte)120));
      blockPassSet.add(Byte.valueOf((byte)-85));
    }
    return !blockPassSet.contains(Byte.valueOf(block));
  }
  
  public static HashSet<Byte> blockAirFoliageSet = new HashSet();
  
  public static boolean airFoliage(Block block)
  {
    if (block == null) {
      return false;
    }
    return airFoliage(block.getTypeId());
  }
  
  public static boolean airFoliage(int block)
  {
    return airFoliage((byte)block);
  }
  
  public static boolean airFoliage(byte block)
  {
    if (blockAirFoliageSet.isEmpty())
    {
      blockAirFoliageSet.add(Byte.valueOf((byte)0));
      blockAirFoliageSet.add(Byte.valueOf((byte)6));
      blockAirFoliageSet.add(Byte.valueOf((byte)31));
      blockAirFoliageSet.add(Byte.valueOf((byte)32));
      blockAirFoliageSet.add(Byte.valueOf((byte)37));
      blockAirFoliageSet.add(Byte.valueOf((byte)38));
      blockAirFoliageSet.add(Byte.valueOf((byte)39));
      blockAirFoliageSet.add(Byte.valueOf((byte)40));
      blockAirFoliageSet.add(Byte.valueOf((byte)51));
      blockAirFoliageSet.add(Byte.valueOf((byte)59));
      blockAirFoliageSet.add(Byte.valueOf((byte)104));
      blockAirFoliageSet.add(Byte.valueOf((byte)105));
      blockAirFoliageSet.add(Byte.valueOf((byte)115));
      blockAirFoliageSet.add(Byte.valueOf((byte)-115));
      blockAirFoliageSet.add(Byte.valueOf((byte)-114));
    }
    return blockAirFoliageSet.contains(Byte.valueOf(block));
  }
  
  public static HashSet<Byte> fullSolid = new HashSet();
  
  public static boolean fullSolid(Block block)
  {
    if (block == null) {
      return false;
    }
    return fullSolid(block.getTypeId());
  }
  
  public static boolean fullSolid(int block)
  {
    return fullSolid((byte)block);
  }
  
  public static boolean fullSolid(byte block)
  {
    if (fullSolid.isEmpty())
    {
      fullSolid.add(Byte.valueOf((byte)1));
      fullSolid.add(Byte.valueOf((byte)2));
      fullSolid.add(Byte.valueOf((byte)3));
      fullSolid.add(Byte.valueOf((byte)4));
      fullSolid.add(Byte.valueOf((byte)5));
      fullSolid.add(Byte.valueOf((byte)7));
      fullSolid.add(Byte.valueOf((byte)12));
      fullSolid.add(Byte.valueOf((byte)13));
      fullSolid.add(Byte.valueOf((byte)14));
      fullSolid.add(Byte.valueOf((byte)15));
      fullSolid.add(Byte.valueOf((byte)16));
      fullSolid.add(Byte.valueOf((byte)17));
      fullSolid.add(Byte.valueOf((byte)18));
      fullSolid.add(Byte.valueOf((byte)19));
      fullSolid.add(Byte.valueOf((byte)20));
      fullSolid.add(Byte.valueOf((byte)21));
      fullSolid.add(Byte.valueOf((byte)22));
      fullSolid.add(Byte.valueOf((byte)23));
      fullSolid.add(Byte.valueOf((byte)24));
      fullSolid.add(Byte.valueOf((byte)25));
      fullSolid.add(Byte.valueOf((byte)29));
      fullSolid.add(Byte.valueOf((byte)33));
      fullSolid.add(Byte.valueOf((byte)35));
      fullSolid.add(Byte.valueOf((byte)41));
      fullSolid.add(Byte.valueOf((byte)42));
      fullSolid.add(Byte.valueOf((byte)43));
      fullSolid.add(Byte.valueOf((byte)44));
      fullSolid.add(Byte.valueOf((byte)45));
      fullSolid.add(Byte.valueOf((byte)46));
      fullSolid.add(Byte.valueOf((byte)47));
      fullSolid.add(Byte.valueOf((byte)48));
      fullSolid.add(Byte.valueOf((byte)49));
      fullSolid.add(Byte.valueOf((byte)56));
      fullSolid.add(Byte.valueOf((byte)57));
      fullSolid.add(Byte.valueOf((byte)58));
      fullSolid.add(Byte.valueOf((byte)60));
      fullSolid.add(Byte.valueOf((byte)61));
      fullSolid.add(Byte.valueOf((byte)62));
      fullSolid.add(Byte.valueOf((byte)73));
      fullSolid.add(Byte.valueOf((byte)74));
      fullSolid.add(Byte.valueOf((byte)79));
      fullSolid.add(Byte.valueOf((byte)80));
      fullSolid.add(Byte.valueOf((byte)82));
      fullSolid.add(Byte.valueOf((byte)84));
      fullSolid.add(Byte.valueOf((byte)86));
      fullSolid.add(Byte.valueOf((byte)87));
      fullSolid.add(Byte.valueOf((byte)88));
      fullSolid.add(Byte.valueOf((byte)89));
      fullSolid.add(Byte.valueOf((byte)91));
      fullSolid.add(Byte.valueOf((byte)95));
      fullSolid.add(Byte.valueOf((byte)97));
      fullSolid.add(Byte.valueOf((byte)98));
      fullSolid.add(Byte.valueOf((byte)99));
      fullSolid.add(Byte.valueOf((byte)100));
      fullSolid.add(Byte.valueOf((byte)103));
      fullSolid.add(Byte.valueOf((byte)110));
      fullSolid.add(Byte.valueOf((byte)112));
      fullSolid.add(Byte.valueOf((byte)121));
      fullSolid.add(Byte.valueOf((byte)123));
      fullSolid.add(Byte.valueOf((byte)124));
      fullSolid.add(Byte.valueOf((byte)125));
      fullSolid.add(Byte.valueOf((byte)126));
      fullSolid.add(Byte.valueOf((byte)-97));
      fullSolid.add(Byte.valueOf((byte)-94));
      fullSolid.add(Byte.valueOf((byte)-84));
      fullSolid.add(Byte.valueOf((byte)-127));
      fullSolid.add(Byte.valueOf((byte)-123));
      fullSolid.add(Byte.valueOf((byte)-119));
      fullSolid.add(Byte.valueOf((byte)-118));
      fullSolid.add(Byte.valueOf((byte)-104));
      fullSolid.add(Byte.valueOf((byte)-103));
      fullSolid.add(Byte.valueOf((byte)-101));
      fullSolid.add(Byte.valueOf((byte)-98));
    }
    return fullSolid.contains(Byte.valueOf(block));
  }
  
  public static HashSet<Byte> blockUseSet = new HashSet();
  
  public static boolean usable(Block block)
  {
    if (block == null) {
      return false;
    }
    return usable(block.getTypeId());
  }
  
  public static boolean usable(int block)
  {
    return usable((byte)block);
  }
  
  public static boolean usable(byte block)
  {
    if (blockUseSet.isEmpty())
    {
      blockUseSet.add(Byte.valueOf((byte)23));
      blockUseSet.add(Byte.valueOf((byte)26));
      blockUseSet.add(Byte.valueOf((byte)33));
      blockUseSet.add(Byte.valueOf((byte)47));
      blockUseSet.add(Byte.valueOf((byte)54));
      blockUseSet.add(Byte.valueOf((byte)58));
      blockUseSet.add(Byte.valueOf((byte)61));
      blockUseSet.add(Byte.valueOf((byte)62));
      blockUseSet.add(Byte.valueOf((byte)64));
      blockUseSet.add(Byte.valueOf((byte)69));
      blockUseSet.add(Byte.valueOf((byte)71));
      blockUseSet.add(Byte.valueOf((byte)77));
      blockUseSet.add(Byte.valueOf((byte)93));
      blockUseSet.add(Byte.valueOf((byte)94));
      blockUseSet.add(Byte.valueOf((byte)96));
      blockUseSet.add(Byte.valueOf((byte)107));
      blockUseSet.add(Byte.valueOf((byte)116));
      blockUseSet.add(Byte.valueOf((byte)117));
      blockUseSet.add(Byte.valueOf((byte)-126));
      blockUseSet.add(Byte.valueOf((byte)-111));
      blockUseSet.add(Byte.valueOf((byte)-110));
      blockUseSet.add(Byte.valueOf((byte)-102));
      blockUseSet.add(Byte.valueOf((byte)-98));
    }
    return blockUseSet.contains(Byte.valueOf(block));
  }
  
  public static HashMap<Block, Double> getInRadius(Location loc, double radius)
  {
    HashMap<Block, Double> blockList = new HashMap();
    int iR = (int)radius + 1;
    for (int x = -iR; x <= iR; x++) {
      for (int z = -iR; z <= iR; z++)
      {
        Block curBlock = loc.getWorld().getBlockAt((int)(loc.getX() + x), (int)loc.getY(), (int)(loc.getZ() + z));
        double offset = UtilMath.offset(loc, curBlock.getLocation().add(0.5D, 0.5D, 0.5D));
        if (offset <= radius) {
          blockList.put(curBlock, Double.valueOf(1.0D - offset / radius));
        }
      }
    }
    return blockList;
  }
  
  public static HashMap<Block, Double> getInRadius(Location loc, double dR, double heightLimit)
  {
    HashMap<Block, Double> blockList = new HashMap();
    int iR = (int)dR + 1;
    for (int x = -iR; x <= iR; x++) {
      for (int z = -iR; z <= iR; z++) {
        for (int y = -iR; y <= iR; y++) {
          if (Math.abs(y) <= heightLimit)
          {
            Block curBlock = loc.getWorld().getBlockAt((int)(loc.getX() + x), (int)(loc.getY() + y), (int)(loc.getZ() + z));
            
            double offset = UtilMath.offset(loc, curBlock.getLocation().add(0.5D, 0.5D, 0.5D));
            if (offset <= dR) {
              blockList.put(curBlock, Double.valueOf(1.0D - offset / dR));
            }
          }
        }
      }
    }
    return blockList;
  }
  
  public static HashMap<Block, Double> getInRadius(Block block, double dR)
  {
    HashMap<Block, Double> blockList = new HashMap();
    int iR = (int)dR + 1;
    for (int x = -iR; x <= iR; x++) {
      for (int z = -iR; z <= iR; z++) {
        for (int y = -iR; y <= iR; y++)
        {
          Block curBlock = block.getRelative(x, y, z);
          
          double offset = UtilMath.offset(block.getLocation(), curBlock.getLocation());
          if (offset <= dR) {
            blockList.put(curBlock, Double.valueOf(1.0D - offset / dR));
          }
        }
      }
    }
    return blockList;
  }
  
  public static boolean isBlock(ItemStack item)
  {
    if (item == null) {
      return false;
    }
    return (item.getTypeId() > 0) && (item.getTypeId() < 256);
  }
  
  public static Block getHighest(World world, int x, int z)
  {
    return getHighest(world, x, z, null);
  }
  
  public static Block getHighest(World world, int x, int z, HashSet<Material> ignore)
  {
    Block block = world.getHighestBlockAt(x, z);
    while ((airFoliage(block)) || 
      (block.getType() == Material.LEAVES) || (
      (ignore != null) && (ignore.contains(block.getType())))) {
      block = block.getRelative(BlockFace.DOWN);
    }
    return block.getRelative(BlockFace.UP);
  }
  
  public static ArrayList<Block> getSurrounding(Block block, boolean diagonals)
  {
    ArrayList<Block> blocks = new ArrayList();
    if (diagonals)
    {
      for (int x = -1; x <= 1; x++) {
        for (int y = -1; y <= 1; y++) {
          for (int z = -1; z <= 1; z++) {
            if ((x != 0) || (y != 0) || (z != 0)) {
              blocks.add(block.getRelative(x, y, z));
            }
          }
        }
      }
    }
    else
    {
      blocks.add(block.getRelative(BlockFace.UP));
      blocks.add(block.getRelative(BlockFace.DOWN));
      blocks.add(block.getRelative(BlockFace.NORTH));
      blocks.add(block.getRelative(BlockFace.SOUTH));
      blocks.add(block.getRelative(BlockFace.EAST));
      blocks.add(block.getRelative(BlockFace.WEST));
    }
    return blocks;
  }
  
  public static boolean isVisible(Block block)
  {
    for (Block other : getSurrounding(block, false)) {
      if (!other.getType().isOccluding()) {
        return true;
      }
    }
    return false;
  }
  
  public static List<Block> getBlocksInRadius(Location location, int radius, boolean hollow) {
      List<Block> blocks = new ArrayList<>();

      int bX = location.getBlockX();
      int bY = location.getBlockY();
      int bZ = location.getBlockZ();

      for (int x = bX - radius; x <= bX + radius; x++) {
          for (int y = bY - radius; y <= bY + radius; y++) {
              for (int z = bZ - radius; z <= bZ + radius; z++) {

                  double distance = ((bX - x) * (bX - x) + (bY - y) * (bY - y) + (bZ - z) * (bZ - z));

                  if (distance < radius * radius
                          && !(hollow && distance < ((radius - 1) * (radius - 1)))) {
                      Location l = new Location(location.getWorld(), x, y, z);
                      blocks.add(l.getBlock());
                  }
              }

          }
      }

      return blocks;
  }
  
  public static void setToRestore(final Block b, Material newType, byte newData, int tickDelay) {
      if (blocksToRestore.containsKey(b.getLocation())) return;
      Block bUp = b.getRelative(BlockFace.UP);
      if (b.getType() != Material.AIR
              && b.getType() != Material.SIGN_POST
              && b.getType() != Material.CHEST
              && b.getType() != Material.STONE_PLATE
              && b.getType() != Material.WOOD_PLATE
              && b.getType() != Material.WALL_SIGN
              && b.getType() != Material.WALL_BANNER
              && b.getType() != Material.STANDING_BANNER
              && b.getType() != Material.CROPS
              && b.getType() != Material.LONG_GRASS
              && b.getType() != Material.SAPLING
              && b.getType() != Material.DEAD_BUSH
              && b.getType() != Material.RED_ROSE
              && b.getType() != Material.RED_MUSHROOM
              && b.getType() != Material.BROWN_MUSHROOM
              && b.getType() != Material.TORCH
              && b.getType() != Material.LADDER
              && b.getType() != Material.VINE
              && b.getType() != Material.DOUBLE_PLANT
              && b.getType() != Material.PORTAL
              && b.getType() != Material.CACTUS
              && b.getType() != Material.WATER
              && b.getType() != Material.STATIONARY_WATER
              && b.getType() != Material.LAVA
              && b.getType() != Material.STATIONARY_LAVA
              && b.getType() != Material.PORTAL
              && b.getType() != Material.ENDER_PORTAL
              && b.getType() != Material.SOIL
              && net.minecraft.server.v1_9_R2.Block.getByCombinedId(b.getTypeId()).getMaterial().isSolid()
              && bUp.getType() != Material.CROPS
              && bUp.getType() != Material.GRASS
              && bUp.getType() != Material.LONG_GRASS
              && bUp.getType() != Material.SAPLING
              && bUp.getType() != Material.DEAD_BUSH
              && bUp.getType() != Material.RED_ROSE
              && bUp.getType() != Material.RED_MUSHROOM
              && bUp.getType() != Material.BROWN_MUSHROOM
              && bUp.getType() != Material.TORCH
              && bUp.getType() != Material.LADDER
              && bUp.getType() != Material.VINE
              && bUp.getType() != Material.DOUBLE_PLANT
              && bUp.getType() != Material.CACTUS
              && bUp.getType() != Material.WATER_LILY
              && b.getType().getId() != 43
              && b.getType().getId() != 44) {
          if (!blocksToRestore.containsKey(b.getLocation())) {
              blocksToRestore.put(b.getLocation(), b.getType().toString() + "," + b.getData());
              b.setType(newType);
              b.setData(newData);
              Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                  @Override
                  public void run() {
                      restoreBlockAt(b.getLocation());

                  }
              }, tickDelay);

          }

      }
  }
  
  public static void restoreBlockAt(Location loc) {
      if (!blocksToRestore.containsKey(loc)) return;
      Block b = loc.getBlock();
      String s = blocksToRestore.get(loc);
      Material m = Material.valueOf(s.split(",")[0]);
      byte d = Byte.valueOf(s.split(",")[1]);
      b.setType(m);
      b.setData(d);
      blocksToRestore.remove(loc);
  }
}
