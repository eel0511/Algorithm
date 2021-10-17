package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj21278_호석이두마리치킨 {

	static int N, M, cnt, minplace1, minplace2;
	static int[][] board;
	static boolean[] check;
	static int[] place = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		board = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		cnt = Integer.MAX_VALUE;

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(board[i], 1000001);
			board[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			temp = br.readLine().split(" ");
			int c1 = Integer.parseInt(temp[0]);
			int c2 = Integer.parseInt(temp[1]);
			board[c1][c2] = 1;
			board[c2][c1] = 1;
		}
		floyd();
		sol(1, 0);
		System.out.println(minplace1 + " " + minplace2 + " " + cnt);

	}

	public static void sol(int start, int depth) {
		if (depth == 2) {
			int sum = 0;
			for (int i = 1; i < board.length; i++) {
				if (!check[i]) {
					int mmin = Integer.MAX_VALUE;
					for (int j = 0; j < 2; j++) {
						mmin = Integer.min(board[i][place[j]], mmin);
					}
					sum += mmin * 2;
				}
			}
			if (cnt > sum) {
				minplace1 = place[0];
				minplace2 = place[1];
				cnt = sum;
			}
			return;
		}
		for (int i = start; i < board.length; i++) {
			if (!check[i]) {
				check[i] = true;
				place[depth] = i;
				sol(i, depth + 1);
				check[i] = false;
			}
		}

	}

	public static void floyd() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				for (int k = 1; k < N + 1; k++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
		}
	}
}
