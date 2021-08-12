package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2206_벽부수고이동하기 {

	static int N, M;
	static int[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		cnt = -1;
		bfs(N - 1, M - 1);
		System.out.println(cnt);

	}

	public static void bfs(int endx, int endy) {
		boolean[][][] check = new boolean[N][M][2];

		Queue<int[]> q = new LinkedList<>();

		// (0, 0) ,벽부순횟수, cnt
		q.add(new int[] { 0, 0, 0, 1 });
		check[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			if (temp[0] == endx && temp[1] == endy) {
				cnt = temp[3];
				break;
			}
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && !check[newx][newy][temp[2]] && board[newx][newy] == 0) {
					q.add(new int[] { newx, newy, temp[2], temp[3] + 1 });
					check[newx][newy][temp[2]] = true;

				} else if (isNotWall(newx, newy) && !check[newx][newy][temp[2]] && temp[2] == 0) {
					check[newx][newy][1] = true;
					q.add(new int[] { newx, newy, 1, temp[3] + 1 });
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
