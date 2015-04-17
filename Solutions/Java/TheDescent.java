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

        // game loop
        while (true) {
            int SX = in.nextInt();
            int SY = in.nextInt();
            in.nextLine();
            
            int maxH = 0;
            int montainID = 0;
            for (int i = 0; i < 8; i++) { // there are 8 mountains
                int MH = in.nextInt(); // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
                in.nextLine();
                if( MH > maxH) {
                    maxH = MH;
                    montainID = i;
                }
            }
            
            if(montainID == SX) {
                System.out.println("FIRE");
            }else{
                System.out.println("HOLD");
            }
        }
    }
}