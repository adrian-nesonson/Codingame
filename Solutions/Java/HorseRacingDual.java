import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        ArrayList<Integer> horses = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int Pi = in.nextInt();
            in.nextLine();
            horses.add(new Integer(Pi));
        }
        Collections.sort(horses);
        
        int gap = 1000000000;
        int temp = 0;
        for( int i = 0; i< horses.size()-1;i++ ) {
            temp = horses.get(i+1)-horses.get(i);
            if ( temp < gap) {
                gap = temp;
            }
        }
        System.out.println(gap);
    }
}