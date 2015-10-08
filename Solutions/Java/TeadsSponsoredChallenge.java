import java.lang.Integer;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

	static int startId;
	static ArrayList<Integer> nodeList = new ArrayList<>();

	public static HashMap<Integer, Node> initMap(Scanner in, int n) {
		HashMap<Integer, Node> nodeMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int xi = in.nextInt(); // the ID of a person which is adjacent to yi
			int yi = in.nextInt(); // the ID of a person which is adjacent to xi
			startId = xi;
			Node nx;
			Node ny;
			if (nodeMap.get(xi) == null) {
				nx = new Node(xi);
				nodeList.add(xi);
			} else {
				nx = nodeMap.get(xi);
			}
			if (nodeMap.get(yi) == null) {
				ny = new Node(yi);
				nodeList.add(yi);
			} else {
				ny = nodeMap.get(yi);
			}
			if (!nx.connectedTo.contains(ny)) nx.connectedTo.add(ny);
			if (!ny.connectedTo.contains(nx)) ny.connectedTo.add(nx);
			nodeMap.put(xi, nx);
			nodeMap.put(yi, ny);
		}
		return nodeMap;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Node> nodeMap;
		int n = in.nextInt(); // the number of adjacency relations
		nodeMap = initMap(in, n);
		int res = 0;
		Node tempNode;
		Node neighbourNode;
		int i = 1;
		while (nodeList.size() > 2) {

			Iterator<Integer> it = nodeList.iterator();
			while (it.hasNext()) {
				tempNode = nodeMap.get(it.next());
				if (tempNode.connectedTo.size() == 1) {
					if (tempNode.modifId < i) {
						neighbourNode = tempNode.connectedTo.get(0);
						neighbourNode.connectedTo.remove(tempNode);
						neighbourNode.modifId = i;
						it.remove();
					}
				}
			}

			res++;
			i++;
		}
		if (nodeList.size() > 1) res++;
		System.out.println(res); // The minimal amount of steps required to completely propagate the advertisement
	}

	static class Node {
		public ArrayList<Node> connectedTo = new ArrayList<Node>();
		public int modifId = 0;
		private int id;

		public Node(int i) {
			id = i;
		}
	}
}
