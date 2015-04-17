import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt(); // the length of the road before the gap.
        in.nextLine();
        int G = in.nextInt(); // the length of the gap.
        in.nextLine();
        int L = in.nextInt(); // the length of the landing platform.
        in.nextLine();

        // game loop
        while (true) {
            int S = in.nextInt(); // the motorbike's speed.
            in.nextLine();
            int X = in.nextInt(); // the position on the road of the motorbike.
            in.nextLine();
            			
             // A single line containing one of 4 keywords: SPEED, SLOW, JUMP, WAIT.
            if (X >= R+G){
                System.out.println("SLOW");
            } else if (X+S >= R+G && X <  R+G){
                System.out.println("JUMP");
            } else {
                if ( S > (G+1)) {
                    System.out.println("SLOW");
                } else if ( S == (G+1)) {
                    System.out.println("WAIT");
                } else {
                    System.out.println("SPEED");
                }
            }
        }
    }
}