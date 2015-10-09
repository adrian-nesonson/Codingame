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
		int R = in.nextInt();
		int L = in.nextInt();

		String init = ""+R;
		String res = ""+init.charAt(0);
		String temp = "";

		char cur;
		int occur;

		int i = 1;
		int j;
		while(i<L) {
			j = 0;
			cur = res.charAt(j);
			occur = 0;
			while (j < res.length()) {
				while (j < res.length() && (res.charAt(j) == cur || res.charAt(j) == ' ')) {
					if (res.charAt(j) != ' ') occur++;
					j++;
				}
				temp += occur + " " + cur + " ";
				if (j < res.length()) cur = res.charAt(j);
				occur = 0;
			}
			res = new String(temp);
			temp = new String();
			i++;
		}
		if (res.length() > 1) res = res.substring(0,res.length() - 1);
		if (init.length() > 1) res = res.substring(0,res.length()-1) + init;

		System.out.println(res);
	}
}
