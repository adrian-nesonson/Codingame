import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int v = in.nextInt();
        int maxV = v;
        int minV = v;
        ArrayList<Integer> values = new ArrayList<>();
        for(int i=0;i<n;i++) {
            System.err.println(v);
            if (v > maxV) {
                values.add(minV-maxV);
                maxV = v;
                minV = v;
            } else {
                if (minV > v) minV = v;
            }
            if (i < n-1) v = in.nextInt();
        }
        values.add(minV-maxV);
        Collections.sort(values);
        System.out.println(values.get(0));
    }
}
