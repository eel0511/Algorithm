package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573_빙산 {

	static int[][] board;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int result = 0;
		while (true) {
			cnt = 0;
			init();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] != 0 && !check[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			if (cnt == 1) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (board[i][j] != 0 && check[i][j]) {
							melt(i, j);
						}
					}
				}
				result++;
			//다같이녹을때 0출력해주는거 안해줘서 계속틀림;;
			} else if(cnt==0){
				System.out.println(0);
				break;
			}else {
				System.out.println(result);
				break;
			}
		}
	}

	public static void melt(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 0 && board[x][y] > 0) {
				board[x][y]--;
			}
		}
	}

	public static void pr(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];
				if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] != 0) {
					q.add(new int[] { newx, newy });
					check[newx][newy] = true;

				}
			}
		}
	}

	public static void init() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				check[i][j] = false;
			}
		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}

}
