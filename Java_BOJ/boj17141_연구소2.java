package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj17141_연구소2 {

	static int N, M, min, wall;
	static int[][] board;
	static int[][] useboard;
	static ArrayList<int[]> viruslist;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[] check;
	static int[] virusx;
	static int[] virusy;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		viruslist = new ArrayList<>();
		board = new int[N][N];
		useboard = new int[N][N];
		virusx = new int[M];
		virusy = new int[M];
		min = 9999;
		wall = 0;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(temp[j]);

				if (num == 1) {
					// 벽 처리
					board[i][j] = -1;
					wall++;
				} else if (num == 2) {
					// 바이러스 위치 리스트
					viruslist.add(new int[] { i, j });
					board[i][j] = 0;
				} else {
					board[i][j] = num;
				}

			}
		}
		check = new boolean[viruslist.size()];
		makeboard();
		findpoint(0,0);
		if (min != 9999) {
			System.out.println(min - 1);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs(int[] virusx, int[] virusy) {
		int cnt = wall;
		int cal = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			q.add(new int[] { virusx[i], virusy[i] });
			useboard[virusx[i]][virusy[i]] += 1;
			cal = Integer.max(cal, useboard[virusx[i]][virusy[i]]);
			cnt++;
		}
		while (!q.isEmpty()) {
			if (cal > min)
				break;
			int len = q.size();
			for (int k = 0; k < len; k++) {

				int[] temp = q.poll();
				for (int i = 0; i < dx.length; i++) {
					int newx = temp[0] + dx[i];
					int newy = temp[1] + dy[i];
					if (isNotWall(newx, newy) && useboard[newx][newy] ==0) {
						useboard[newx][newy] = useboard[temp[0]][temp[1]] + 1;
						
						q.add(new int[] { newx, newy });
						cnt++;
						cal = Integer.max(cal, useboard[newx][newy]);
					}

				}
			}

		}
		if (cnt == N * N) {
			min = Integer.min(min, cal);
		}
	}

	public static void findpoint(int depth,int start) {
		if (depth == M) {
			bfs(virusx, virusy);
//			printboard();
//			for(int i=0;i<M;i++) {
//				System.out.println(virusx[i]+" "+virusy[i]+" "+min);
//			}
//			System.out.println("--------------------");
			makeboard();
			return;
		}
		for (int i = start; i < viruslist.size(); i++) {
			if (!check[i]) {
				check[i] = true;
				virusx[depth] = viruslist.get(i)[0];
				virusy[depth] = viruslist.get(i)[1];
				findpoint(depth + 1,i+1);
				check[i] = false;
			}

		}
	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	public static void printboard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(useboard[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static void makeboard() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, useboard[i], 0, N);
		}
	}
}
