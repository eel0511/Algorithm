package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj11725_트리의부모찾기 {
	static int N;
	static ArrayList<Integer>[] board;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i < board.length; i++) {
			board[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			String[] temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			board[start].add(end);
			board[end].add(start);
		}
		bfs(1);
		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}

	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i : board[temp]) {
				if (parent[i] == 0) {
					parent[i] = temp;
					q.add(i);
				}
			}
		}
	}

}
