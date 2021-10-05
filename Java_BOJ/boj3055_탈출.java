package today3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj3055_탈출 {
	static int R, C, cnt;
	static String[][] board;
	static boolean check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Queue<int[]> q1;
	static Queue<int[]> q2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		cnt = 0;
		check = true;
		board = new String[R][C];
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < C; j++) {
				board[i][j] = temp[j];
				if (board[i][j].equals("S")) {
					q1.add(new int[] { i, j });
				}
				if (board[i][j].equals("*")) {
					q2.add(new int[] { i, j });
				}
			}
		}

		bfs();
		if (check) {
			System.out.println(cnt);
		}

	}

	public static void bfs() {
		while (true) {
			cnt++;
			int size2 = q2.size();
			for (int k = 0; k < size2; k++) {
				int[] temp = q2.poll();
				for (int i = 0; i < dx.length; i++) {
					int newx = temp[0] + dx[i];
					int newy = temp[1] + dy[i];
					if (isNotWall(newx, newy) && board[newx][newy].equals(".")) {
						board[newx][newy] = "*";
						q2.add(new int[] { newx, newy });
					}
				}
			}
			if (q1.size() == 0) {
				System.out.println("KAKTUS");
				check = false;
				return;
			}

			int size1 = q1.size();
			for (int k = 0; k < size1; k++) {
				int[] temp = q1.poll();
				for (int i = 0; i < dx.length; i++) {
					int newx = temp[0] + dx[i];
					int newy = temp[1] + dy[i];
					if (isNotWall(newx, newy) && board[newx][newy].equals("D")) {
						return;
					}
					if (isNotWall(newx, newy) && board[newx][newy].equals(".")) {
						board[newx][newy] = "S";
						q1.add(new int[] { newx, newy });
					}
				}
			}
		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < R && y >= 0 && y < C)
			return true;
		return false;
	}

}
