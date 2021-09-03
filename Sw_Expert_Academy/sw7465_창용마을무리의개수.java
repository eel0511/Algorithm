package today2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw7465_창용마을무리의개수 {
	static ArrayList<Integer>[] board;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			board = new ArrayList[N+1];
			check = new boolean[N + 1];
			cnt = 0;
			for (int i = 0; i < board.length; i++) {
				board[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				board[n1].add(n2);
				board[n2].add(n1);
			}
			if (M == 0) {
				cnt = N;
			} else {
				for (int i = 1; i <= N; i++) {
					if (!check[i]) {
						bfs(i);
						cnt++;
					}
				}

			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i < board.length; i++) {
				if (!check[i] && board[temp].contains(i)) {
					q.add(i);
					check[i] = true;
				}
			}
		}
	}

}
