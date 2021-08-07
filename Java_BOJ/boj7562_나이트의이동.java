package today;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7562_나이트의이동 {

	static int T;
	static int L;
	static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[][] board;
	static boolean[][] check;
	static int[] start;
	static int[] end;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {
			L = sc.nextInt();
			board = new int[L][L];
			check = new boolean[L][L];
			start = new int[2];
			end = new int[2];
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();

			bfs(start[0], start[1]);
			
		}
	}

	public static void bfs(int x, int y) {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { x, y });
		check[x][y] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[0] == end[0] && temp[1] == end[1]) {
				System.out.println(board[temp[0]][temp[1]]);
				return;
			}
			for (int i = 0; i < dx.length; i++) {

				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && !check[newx][newy]) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;
					board[newx][newy] = board[temp[0]][temp[1]] + 1;
				}

			}

		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < L && y >= 0 && y < L) {
			return true;
		}
		return false;
	}

}
