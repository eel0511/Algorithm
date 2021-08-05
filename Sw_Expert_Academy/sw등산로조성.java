package today;

import java.util.Scanner;

public class sw등산로조성 {
	static int N;
	static int K;
	static int[][] board;
	static boolean[][] visited;
	static int answer = 0;
	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();
		for (int i = 1; i <= test_case; i++) {

			N = sc.nextInt();
			K = sc.nextInt()+1;
			board = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			answer=0;

			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board.length; k++) {
					int savenum = sc.nextInt();
					if (max < savenum) {
						max = savenum;
					}
					board[j][k] = savenum;
				}
			}
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board.length; k++) {
					if (board[j][k] == max) {

						for (int j2 = 0; j2 < board.length; j2++) {
							for (int l = 0; l < board.length; l++) {
								for (int k2 = 0; k2 < K; k2++) {
									board[j2][l] -= k2;
									init();
									dfs(j, k, 1);
									board[j2][l] += k2;
								}
							}
						}

					}

				}
			}
			System.out.println("#"+i+" "+answer);

		}
	}

	public static void dfs(int x, int y, int size) {
		answer = Integer.max(answer, size);
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		visited[x][y] = true;

		for (int i = 0; i < dy.length; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX >= 0 && newX < N && newY >= 0 && newY < N && (board[newX][newY] < board[x][y])
					&& !visited[newX][newY]) {
				visited[newX][newY] = true;
				dfs(newX, newY, size + 1);
				visited[newX][newY] = false;
			}
		}
	}
	private static void init() {
		for(int i = 0 ; i < N ; ++i) {
			for (int j = 0 ; j < N ; ++j) {
				visited[i][j] = false;
			}
		}
	}

}
