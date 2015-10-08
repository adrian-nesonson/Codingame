import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int width = in.nextInt(); // the number of cells on the X axis
		in.nextLine();
		int height = in.nextInt(); // the number of cells on the Y axis
		in.nextLine();
		boolean[][] nodes = new boolean[width][height];
		int k;
		for (int i = 0; i < height; i++) {
			String line = in.nextLine(); // width characters, each either 0 or .
			k = 0;
			for (char c : line.toCharArray()) {
				if (c == '0') {
					nodes[k][i] = true;
				} else {
					nodes[k][i] = false;
				}
				k++;
			}
		}
		int x1, y1, x2, y2, x3, y3, i2, j2;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (nodes[i][j]) {
					x1 = i;
					y1 = j;
					i2 = i + 1;
					j2 = j + 1;
					while (i2 < width && !nodes[i2][j]) i2++;
					if (i2 < width) {
						x2 = i2;
						y2 = j;
					} else {
						x2 = -1;
						y2 = -1;
					}
					while (j2 < height && !nodes[i][j2]) j2++;
					if (j2 < height) {
						x3 = i;
						y3 = j2;
					} else {
						x3 = -1;
						y3 = -1;
					}

					System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3); // Three coordinates: a node, its right neighbor, its bottom neighbor
				}
			}
		}
	}
}
