import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	public static String[] initRows(Scanner in, int size) {
		String[] rows = new String[size];
        for (int i = 0; i < size; i++) {
            rows[i] = in.nextLine();
        }
		return rows;
	}
	
	public static String[] initAnswer(Scanner in, int size) {
		String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            answer[i] = "";
        }
		return answer;
	}

    public static String formatAnswer(String[] answer, int size) {
        String result="";
        for ( int i = 0;i < size; i++ ) {
                result += answer[i]+"\n";
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        String[] rows = initRows(in,H);
        String[] answer = initAnswer(in,H);
        
        for ( int i = 0;i < T.length(); i++ ) {
            int pos = ((int)(Character.toUpperCase(T.charAt(i))) - 65)*L;            
            if(pos < 0 || pos > rows[0].length() ){ // question mark char
                pos = rows[0].length()-L;
            }			
            for ( int x = 0;x < H; x++ ) {
                answer[x] += rows[x].substring(pos,pos+L);                
            }            
        }
		
        System.out.println(formatAnswer(answer,H));
    }
}