package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2638_치즈{
	static int N, M;
	static int[][] board;
	static boolean[][] check;
	static ArrayList<int[]> cheese;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		board = new int[N][M];
		check = new boolean[N][M];
		cheese = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st[j]);
				//치즈의 위치 저장
				if (board[i][j] == 1)
					cheese.add(new int[] { i, j });
			}
		}

		int cnt = 0;
		while (cheese.size() != 0) {
			init();
			//외부에 있는 공기인지 판별 외부공기면 2로바꿔줌
			dfs(0, 0);
			//외부공기와 접촉시 치즈가 녹음
			melt();
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(board[i][j]+" ");
//				}
//				System.out.println();
//				
//			}
//			System.out.println();
			cnt++;

		}
		System.out.println(cnt);
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check[i][j] = false;
			}
		}
	}

	public static void dfs(int x, int y) {
		check[x][y] = true;
		board[x][y] = 2;
		for (int i = 0; i < dx.length; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] != 1) {
				dfs(newx, newy);
			}
		}
	}

	public static void melt() {
		for (int t = 0; t < cheese.size(); t++) {
			int[] temp = new int[] { cheese.get(t)[0], cheese.get(t)[1] };
			int cnt = 0;
			for (int i = 0; i < dx.length; i++) {
				int newx = temp[0] + dx[i];
				int newy = temp[1] + dy[i];

				if (isNotWall(newx, newy) && board[newx][newy] == 2) {
					cnt++;
				}
			}
			if (cnt >= 2) {
				board[temp[0]][temp[1]] = 0;
				cheese.remove(t);
				t--;
			}

		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}
}
