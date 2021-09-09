package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502_연구소 {

	static int[][] board;
	static int[][] vboard;
	static int N, M, result;
	static ArrayList<int[]> save;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		vboard = new int[N][M];
		int zero = 0;
		save = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					save.add(new int[] { i, j });
			}
		}
		result = 0;
		dfs(0);
		System.out.println(result);

	}

	public static void dfs(int cnt) {
		if (cnt == 3) {
			int total = bfs();
			result = Integer.max(result, total);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					dfs(cnt + 1);
					board[i][j] = 0;
				}
			}
		}
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				vboard[i][j] = board[i][j];
			}
		}
		for (int[] i : save) {
			q.add(new int[] { i[0], i[1] });
		}

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];
				if (isNotWall(newx, newy) && vboard[newx][newy] == 0) {
					q.add(new int[] { newx, newy });
					vboard[newx][newy] = 2;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (vboard[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}

}
