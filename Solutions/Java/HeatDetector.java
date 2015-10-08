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
		int W = in.nextInt(); // width of the building.
		int H = in.nextInt(); // height of the building.
		in.nextLine();
		int N = in.nextInt(); // maximum number of turns before game over.
		in.nextLine();
		int X0 = in.nextInt();
		int Y0 = in.nextInt();
		in.nextLine();

		int nextX = X0;
		int nextY = Y0;

		int minH = 0;
		int minW = 0;
		int maxH = H;
		int maxW = W;

		// game loop
		while (true) {
			String BOMB_DIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
			in.nextLine();

			System.err.println(BOMB_DIR);

			int ratio = 50;
			int divratio = 100;

			if (H > 80 && H < 1000) {
				ratio = 2;
				divratio = 3;
			}
			if (BOMB_DIR.contains("U")) {

				maxH = nextY;
				nextY -= ratio * (nextY - minH) / divratio;
				if (nextY == maxH) {
					nextY--;
				}

			}
			if (BOMB_DIR.contains("D")) {

				minH = nextY;
				nextY += ratio * (maxH - nextY) / divratio;
				if (nextY == minH) {
					nextY++;
				}

			}
			if (BOMB_DIR.contains("L")) {

				maxW = nextX;
				nextX -= ratio * (nextX - minW) / divratio;
				if (nextX == maxW) {
					nextX--;
				}

			}
			if (BOMB_DIR.contains("R")) {

				minW = nextX;
				nextX += ratio * (maxW - nextX) / divratio;
				if (nextX == minW) {
					nextX++;
				}

			}

			if (nextX == W) {
				nextX--;
			}
			if (nextY == H) {
				nextY--;
			}
			System.err.println(minW + " : " + minH);
			System.err.println(maxW + " : " + maxH);

			// Write an action u{sing System.out.println()
			// To debug: System.err.println("Debug messages...");

			System.out.println(nextX + " " + nextY); // the location of the next window Batman should jump to.
		}
	}
}
