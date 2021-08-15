package today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18405_경쟁적전염 {

	static int N, K, S, X, Y;
	static int[][] board;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp);

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];

		for (int i = 0; i < board.length; i++) {
			temp = br.readLine();
			st = new StringTokenizer(temp);
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		temp = br.readLine();
		st = new StringTokenizer(temp);
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		for (int i = 0; i < S; i++) {
			for (int j = 0; j < K; j++) {
				if (!flag) {
					bfs(j + 1);
					if (board[X - 1][Y - 1] != 0) {
						flag = true;
					}
				}
			}
		}
		System.out.println(board[X - 1][Y - 1]);

	}

	public static void bfs(int start) {

		Queue<int[]> q = new LinkedList<>();
		//큐에 start position인거 다집어넣고 한번에 돌림
		//그래야 전체적으로 한번돌아감
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == start) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && board[newx][newy] == 0) {
					board[newx][newy] = start;
				}
			}
		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}
}
