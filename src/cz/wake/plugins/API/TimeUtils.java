package cz.wake.plugins.API;

public class TimeUtils {
	
	public static String formatTime(String format, int time, boolean addPadding)
	  {
	    int days = 0;
	    int hours = 0;
	    int minutes = 0;
	    if ((format.contains("%d")) && (time >= 1440))
	    {
	      days = getDifference(time, 1440);
	      time -= 1440 * days;
	    }
	    if ((format.contains("%h")) && (time >= 60))
	    {
	      hours = getDifference(time, 60);
	      time -= 60 * hours;
	    }
	    minutes = time;
	    
	    format = format.replace("%d", asString(days, addPadding));
	    format = format.replace("%h", asString(hours, addPadding));
	    format = format.replace("%m", asString(minutes, addPadding));
	    return format;
	  }
	  
	  private static String asString(int time, boolean addPadding)
	  {
	    if ((time < 10) && (addPadding)) {
	      return "0" + time;
	    }
	    return Integer.valueOf(time).toString();
	  }
	  
	  private static int getDifference(int time, int secDiff)
	  {
	    int newTime = time / secDiff;
	    return newTime;
	  }

}
