package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2178_미로탐색 {

	static int N;
	static int M;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		check = new boolean[N][M];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			String[] st = sc.next().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st[j]);
			}
		}
		bfs(0, 0);
		System.out.println(board[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		while (!q.isEmpty()) {
			int temp[] = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];
				if (isNotWall(newx, newy) && board[newx][newy] == 1 && !check[newx][newy]) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;
					board[newx][newy] += board[temp[0]][temp[1]];
				}
			}

		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;

	}

}
