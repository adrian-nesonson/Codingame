import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	public static Double srcLongitude;
	public static Double srcLatitude;
	
    public static Double calcDist(Double lonB,Double latB) {
        Double x = (lonB - srcLongitude)*(Math.cos(((srcLatitude+latB)/2)));
        Double y = latB - srcLatitude;
        return (Math.sqrt((x*x)+(y*y))*6371);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);        
        srcLongitude = Double.parseDouble(in.next().replaceAll(",","\\."));
        in.nextLine();
        srcLatitude = Double.parseDouble(in.next().replaceAll(",","\\."));
        in.nextLine();        
        int N = in.nextInt();
        in.nextLine();        
		
        Double minDist = 1000000.0;   
        String res = "";
		
        for (int i = 0; i < N; i++) {
            String defibDesc = in.nextLine();
            String[] split = defibDesc.split(";");
            Double lonB = Double.parseDouble(split[split.length-2].replaceAll(",","\\."));
            Double latB = Double.parseDouble(split[split.length-1].replaceAll(",","\\."));
            
            Double tempDist = calcDist(lonB,latB);
            
            if ( tempDist < minDist ) {
                minDist = tempDist;
                res = split[1];
            }            
        }
        System.out.println(res);
    }
}