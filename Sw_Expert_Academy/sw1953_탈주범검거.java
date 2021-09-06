package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sw1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] board;
	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			M = Integer.parseInt(temp[1]);
			R = Integer.parseInt(temp[2]);
			C = Integer.parseInt(temp[3]);
			L = Integer.parseInt(temp[4]);
			board = new int[N][M];
			check = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(temp[j]);
				}
			}
			cnt = 0;
			bfs(R, C);
			System.out.println("#" + t + " " + cnt);
		}
	}

	public static void bfs(int x, int y) {
		int num = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		cnt++;
		// 상하좌우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {
			// 종료조건
			if (++num == L)
				return;
			// 일반적인 bfs를 1회 시행하고 모든것에 대해 bfs 실행 해야하기때문에
			// 큐에 있는만큼 다 돌린다. 그럼 전체경로에 대해 num 회 시행했을때
			// cnt 값으로 갈수있는 장소 갯수를 알수있다.
			int index = q.size();
			for (int s = 0; s < index; s++) {
				int[] temp = q.poll();
				// 현재 파이프 모양
				int pipe = board[temp[0]][temp[1]];
				for (int i = 0; i < dx.length; i++) {
					int newx = temp[0] + dx[i];
					int newy = temp[1] + dy[i];
					if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] != 0) {
						// 다음 파이프 모양
						// 현재파이프모양과 다음파이프 모양을 봐서 갈수있는지 판단함
						int next = board[newx][newy];
						// 상
						if (i == 0) {
							switch (pipe) {
							case 1:
							case 2:
							case 4:
							case 7:
								if (next == 1 || next == 2 || next == 5 || next == 6) {
									q.add(new int[] { newx, newy });
									check[newx][newy] = true;
									cnt++;
								}
								break;
							}
						}
						// 하
						else if (i == 1) {
							switch (pipe) {
							case 1:
							case 2:
							case 5:
							case 6:
								if (next == 1 || next == 2 || next == 4 || next == 7) {
									q.add(new int[] { newx, newy });
									check[newx][newy] = true;
									cnt++;
								}
								break;
							}
						}
						// 좌
						else if (i == 2) {
							switch (pipe) {
							case 1:
							case 3:
							case 6:
							case 7:
								if (next == 1 || next == 3 || next == 4 || next == 5) {
									q.add(new int[] { newx, newy });
									check[newx][newy] = true;
									cnt++;
								}
								break;
							}
						}
						// 우
						else {
							switch (pipe) {
							case 1:
							case 3:
							case 4:
							case 5:
								if (next == 1 || next == 3 || next == 6 || next == 7) {
									q.add(new int[] { newx, newy });
									check[newx][newy] = true;
									cnt++;
								}
								break;
							}
						}

					}
				}
			}

		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}

}
