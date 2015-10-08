import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class SkyGraph {
	public ArrayList<SkyNode> nodeList = new ArrayList<SkyNode>();
	public ArrayList<SkyArc> arcList = new ArrayList<SkyArc>();
	public HashMap<Integer, ArrayList<SkyArc>> arcMap = new HashMap<Integer, ArrayList<SkyArc>>();

	SkyGraph() {
	}

	public void linkBoth(SkyNode nodeA, SkyNode nodeB) {
		SkyArc arc = new SkyArc(nodeA.id, nodeB.id);
		arcList.add(arc);

		ArrayList<SkyArc> temp = new ArrayList<SkyArc>();

		if (arcMap.get(nodeA.id) != null) {
			temp.addAll(arcMap.get(nodeA.id));
		}
		temp.add(arc);
		arcMap.put(nodeA.id, new ArrayList<SkyArc>(temp));

		temp.clear();

		if (arcMap.get(nodeB.id) != null) {
			temp.addAll(arcMap.get(nodeB.id));
		}
		temp.add(arc);
		arcMap.put(nodeB.id, new ArrayList<SkyArc>(temp));
	}

	public SkyArc getArc(int nodeAId, int nodeBId) {

		for (SkyArc a : arcList) {
			if ((a.nodeA == nodeAId && a.nodeB == nodeBId) || (a.nodeB == nodeAId && a.nodeA == nodeBId)) {
				return a;
			}
		}
		return null;
	}

//dijkstra method

	public void coloration(int startNode) {

		resetVisited();

		SkyNode tempNode;
		ArrayList<SkyArc> arcTemp = new ArrayList<SkyArc>();

		ArrayList<SkyNode> activeNode = new ArrayList<SkyNode>();
		ArrayList<SkyNode> nextActiveNode = new ArrayList<SkyNode>();

		activeNode.add(nodeList.get(startNode));

		int visitedNodeNumber = nodeList.size();
		int visitedArcNumber = arcList.size();

		while (visitedNodeNumber > 0 && visitedArcNumber > 0) {
			arcTemp.clear();
			for (SkyNode n : activeNode) {
				n.visited = true;

				arcTemp.addAll(arcMap.get(n.id));
				for (SkyArc a : arcTemp) {
					if (!a.visited) {
						if (!a.locked) {
							tempNode = nodeList.get(a.getNeighbour(n.id));
							if (tempNode.visited) {
								if (tempNode.weight > n.weight + 1) {
									tempNode.weight = n.weight + 1;
								}
							} else {
								tempNode.weight = n.weight + 1;
								tempNode.visited = true;
								visitedNodeNumber--;
								nextActiveNode.add(tempNode);
							}
						}
						a.visited = true;
						visitedArcNumber--;
					}
				}
			}
			activeNode.clear();
			activeNode.addAll(nextActiveNode);
			nextActiveNode.clear();
		}

	}


	public ArrayList<Integer> nextMove(int startNode) {

		ArrayList<SkyArc> arcs = arcMap.get(startNode);
		ArrayList<SkyNode> nodes = new ArrayList<>();

		ArrayList<Integer> res = new ArrayList<Integer>();

		for (SkyArc a : arcs) {
			if (!a.locked) {
				nodes.add(nodeList.get(a.getNeighbour(startNode)));
			}
		}
		Collections.sort(nodes);

		for (SkyNode n : nodes) res.add(n.id);

		return res;
	}


	// reset methods
	public void resetVisited() {
		resetNodeVisited();
		resetArcVisited();
	}

	public void resetNodeVisited() {
		for (SkyNode n : nodeList) {
			n.visited = false;
			n.weight = 0;
		}
	}

	public void resetArcVisited() {
		for (SkyArc a : arcList) a.visited = false;
	}
}

class SkyArc {

	public int nodeA;
	public int nodeB;

	boolean visited = false;
	boolean locked = false;

	SkyArc(int nodeA, int nodeB) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public boolean isALinkOf(int nodeId) {
		return (nodeId == nodeA || nodeId == nodeB);
	}

	public int getNeighbour(int nodeId) {
		return (nodeId == nodeA ? nodeB : nodeA);
	}
}

class SkyNode implements Comparable {
	private static int classID = 0;

	public int id;
	public int weight = 0;
	public boolean visited = false;

	public ArrayList<Integer> neighbour = new ArrayList<Integer>();

	SkyNode() {
		this.id = classID;
		classID++;
	}

	@Override
	public int compareTo(Object o) {
		return this.weight - ((SkyNode) o).weight;
	}
}

class Player {

	public static void main(String args[]) {

		String scan = "8 13 2\n" +
				" 6 2\n" +
				" 7 3\n" +
				" 6 3\n" +
				" 5 3\n" +
				" 3 4\n" +
				" 7 1\n" +
				" 2 0\n" +
				" 0 1\n" +
				" 0 3\n" +
				" 1 3\n" +
				" 2 3\n" +
				" 7 4\n" +
				" 6 5\n" +
				" 4\n" +
				" 5\n" +
				" 0\n" +
				" 3\n" +
				" 5\n";

		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // the total number of nodes in the level, including the gateways
		int L = in.nextInt(); // the number of links
		int E = in.nextInt(); // the number of exit gateways
		in.nextLine();

		SkyGraph graph = new SkyGraph();

		ArrayList<SkyNode> gatewayList = new ArrayList<SkyNode>();

		ArrayList<SkyArc> tempArc = new ArrayList<SkyArc>();

		for (int i = 0; i < N; i++) {
			graph.nodeList.add(new SkyNode());
		}

		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
			int N2 = in.nextInt();
			in.nextLine();
			graph.linkBoth(graph.nodeList.get(N1), graph.nodeList.get(N2));
		}
		for (int i = 0; i < E; i++) {
			int EI = in.nextInt(); // the index of a gateway node
			in.nextLine();

			gatewayList.add(graph.nodeList.get(EI));
		}

		int playerPos = 0;
		ArrayList<Integer> nextMove;
		int min_weight;
		boolean endTurn;
		// game loop
		while (true) {
			int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
			in.nextLine();
			endTurn = false;
			graph.coloration(SI);
			Collections.sort(gatewayList);
			min_weight = gatewayList.get(0).weight;

			for (SkyNode n : gatewayList) {
				playerPos = n.id;

				nextMove = graph.nextMove(playerPos);

				// Write an action using System.out.println()
				// To debug: System.err.println("Debug messages...");
				for (Integer i : nextMove) {
					if (!graph.getArc(playerPos, i).locked) {
						System.out.println(playerPos + " " + i); // Example: 0 1 are the indices of the nodes you wish to sever the link between
						graph.getArc(playerPos, i).locked = true;
						endTurn = true;
						break;
					}
				}
				if (endTurn) {
					break;
				}
			}
		}
	}
}
