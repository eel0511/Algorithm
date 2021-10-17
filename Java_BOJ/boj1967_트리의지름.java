package today4;

import java.io.*;
import java.util.*;

public class boj1967_트리의지름 {

	static class Node {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}

	static int N, max, maxindex;
	static ArrayList<Node>[] board;
	static boolean[] check;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new ArrayList[N + 1];
		check = new boolean[N + 1];
		distance = new int[N + 1];
		max = 0;
		for (int i = 0; i < N + 1; i++) {
			board[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < N-1; i++) {
			String[] s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);
			board[start].add(new Node(end,cost));
			board[end].add(new Node(start,cost));
		}
		dfs(1,0);
		check = new boolean[N + 1];
		distance = new int[N + 1];
		dfs(maxindex,0);
		System.out.println(max);
	}

	public static void dfs(int start, int cost) {
		distance[start] = cost;
		check[start]=true;
		if (cost > max) {
			max = cost;
			maxindex = start;
		}
		for (Node node : board[start]) {
			if (!check[node.index]) {
				dfs(node.index, cost + node.cost);
			}
		}

	}
}
