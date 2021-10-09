package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj16932_모양만들기 {

	static int N, M, idx, cnt, total, max;
	static int[][] board;
	static boolean[][] check;
	static ArrayList<Integer> savecnt;
	static ArrayList<Integer> dircheck;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		board = new int[N][M];
		check = new boolean[N][M];
		idx = 1;
		total = 0;
		max = 0;
		savecnt = new ArrayList<Integer>();
		dircheck = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && !check[i][j]) {
					cnt = 1;
					bfs(i, j);
					savecnt.add(cnt);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					findmax(i, j);
				}
			}
		}
		System.out.println(max + 1);

	}

	public static void findmax(int x, int y) {
		dircheck = new ArrayList<Integer>();
		total = 0;
		for (int i = 0; i < dx.length; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];

			if (isNotWall(newx, newy) && board[newx][newy] != 0 && !dircheck.contains(board[newx][newy])) {
				dircheck.add(board[newx][newy]);
				total += savecnt.get(board[newx][newy] - 1);
			}
		}
		max = Integer.max(max, total);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			check[temp[0]][temp[1]] = true;
			board[temp[0]][temp[1]] = idx;
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1) {
					board[newx][newy] = idx;
					check[newx][newy] = true;
					q.add(new int[] { newx, newy });
					cnt++;
				}
			}
		}
		idx++;
	}

	public static boolean isNotWall(int x, int y) {

		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}

}
