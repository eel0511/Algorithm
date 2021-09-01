package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class sw1258_행렬찾기 {
	static int[][] board;
	static boolean[][] check;
	static int N;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			check = new boolean[N][N];
			int[][] save = new int[N][2];
			for (int i = 0; i < board.length; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int cnt = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (!check[i][j] && board[i][j] != 0) {
						int x = i;
						int y = j;
						while (true) {
							if (y + 1 >= N)
								break;
							if (board[x][y + 1] == 0)
								break;
							y++;
						}
						while (true) {
							if (x + 1 >= N)
								break;
							if (board[x + 1][y] == 0)
								break;
							x++;
						}
						save[cnt][0] = x - i + 1;
						save[cnt++][1] = y - j + 1;
						bfs(i, j);
					}
				}
			}
			Arrays.sort(save, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[0]*o1[1] > o2[0]*o2[1])
						return -1;
					else if (o1[0]*o1[1] > o2[0]*o2[1]) {
						if (o1[1] < o2[1])
							return -1;
					}
					return 1;
				}
			});
			System.out.print("#" + t + " " + cnt + " ");
			for (int i = cnt - 1; i >= 0; i--) {
				System.out.print(save[i][0] + " " + save[i][1] + " ");
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

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

}
