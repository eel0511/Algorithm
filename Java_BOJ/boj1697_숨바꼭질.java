package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697_숨바꼭질 {
	static int[] board;
	static int N;
	static int K;
	static int[] dx = { 1, -1, 2 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		board = new int[100001];

		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}

	}

	public static void bfs(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		board[start] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();
			int newx = 0;
			
			for (int i = 0; i < dx.length; i++) {

				if (i == 2) {
					newx = temp * dx[i];
				} else {
					newx = temp + dx[i];
				}
				if (newx == K) {
					System.out.println(board[temp]);
					return;
				}
				if (newx >= 0 && newx <= 100000 && board[newx] == 0) {
					q.add(newx);
					board[newx] = board[temp] + 1;
				}
				for (int j = 0; j < 20; j++) {
					System.out.print(board[j]+" ");
				}
				System.out.println();
			}
		}
	}
}
