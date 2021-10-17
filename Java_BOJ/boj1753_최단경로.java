//package today4;
//
//import java.io.*;
//import java.util.*;
//
//class Node implements Comparable<Node> {
//	int index, cost;
//
//	public Node(int index, int cost) {
//		this.index = index;
//		this.cost = cost;
//	}
//
//	@Override
//	public int compareTo(Node o) {
//		return cost - o.cost;
//	}
//}
//
//public class boj1753_최단경로 {
//
//	static int V, E;
//	static List<Node>[] board;
//	static int[] distance;
//	static boolean[] check;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String[] s = br.readLine().split(" ");
//		V = Integer.parseInt(s[0]);
//		E = Integer.parseInt(s[1]);
//		board = new ArrayList[V + 1];
//		check = new boolean[V + 1];
//		distance = new int[V + 1];
//		int INF = 10000001;
//		Arrays.fill(distance, INF);
//		for (int i = 0; i < V + 1; i++) {
//			board[i] = new ArrayList<Node>();
//		}
//		int startindex = Integer.parseInt(br.readLine());
//		for (int i = 0; i < E; i++) {
//			s = br.readLine().split(" ");
//			int start = Integer.parseInt(s[0]);
//			int end = Integer.parseInt(s[1]);
//			int cost = Integer.parseInt(s[2]);
//			board[start].add(new Node(end, cost));
//		}
//
//		dijkstra(startindex);
//
//		StringBuilder sb = new StringBuilder();
//		for (int i = 1; i < V + 1; i++) {
//			if (distance[i] != INF) {
//				sb.append(distance[i] + "\n");
//			} else {
//				sb.append("INF\n");
//			}
//		}
//		System.out.println(sb);
//
//	}
//
//	public static void dijkstra(int startindex) {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
//		pq.add(new Node(startindex, 0));
//		distance[startindex] = 0;
//		while (!pq.isEmpty()) {
//			Node temp = pq.poll();
//
//			if (!check[temp.index]) {
//				check[temp.index] = true;
//
//				for (Node node : board[temp.index]) {
//					if (distance[node.index] > distance[temp.index] + node.cost) {
//						distance[node.index] = distance[temp.index] + node.cost;
//						pq.add(new Node(node.index, distance[node.index]));
//					}
//				}
//			}
//		}
//	}
//
//}
