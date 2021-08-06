package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1260 {

	static int N;
	static int M;
	static int V;
	static int[][] board;
	static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		board = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			board[sc.nextInt()][sc.nextInt()] = 1;
		}
		dfs(V);
		System.out.println();
		init();
		bfs(V);

	}

	public static void dfs(int start) {
		check[start] = true;
		System.out.print(start + " ");

		for (int i = 0; i < N + 1; i++) {
			if (!check[i] && (board[start][i] == 1 || board[i][start] == 1)) {
				check[i] = true;
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		System.out.print(start + " ");

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < N + 1; i++) {
				if (!check[i] && (board[temp][i] == 1 || board[i][temp] == 1)) {
					q.add(i);
					check[i] = true;
					System.out.print(i + " ");
				}
			}
		}

	}

	public static void init() {
		for (int i = 0; i < check.length; i++) {
			check[i] = false;
		}
	}

}
