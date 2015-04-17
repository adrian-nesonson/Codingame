import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	public static HashMap<String,String> initMap(Scanner in, int size) {
		HashMap<String,String> map = new HashMap<String,String>();
        
		for (int i = 0; i < size; i++) {
            String extension = in.next(); 
            String mimeType = in.next(); 
            in.nextLine();
            map.put(extension.toLowerCase(),mimeType);
        }
		return map;
	}

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        
        HashMap<String,String> map = initMap(in,N);        
		
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            String[] res = FNAME.split("\\.");
            if( res.length > 0) {
                String mapRes = map.get(res[(res.length-1)].toLowerCase());
                if ( mapRes != null && res.length > 1 && FNAME.charAt(FNAME.length()-1)!='.'){
                     System.out.println(mapRes);
                } else {
                     System.out.println("UNKNOWN");
                }
            }else{
                System.out.println("UNKNOWN");
            }
            
        }
    }
}