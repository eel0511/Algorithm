package today;

import java.util.*;

public class boj1707_이분그래프 {
	static ArrayList<Integer>[] board;
	static int N, E;
	static int[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();

		for (int t = 0; t < testcase; t++) {
			N = sc.nextInt();
			E = sc.nextInt();
			board = (ArrayList<Integer>[]) new ArrayList[N + 1];
			check = new int[N + 1];

			boolean result = false;

			for (int i = 1; i <= N; i++) {
				board[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();

				board[num1].add(num2);
				board[num2].add(num1);
			}

			for (int i = 1; i <= N; i++) {
				// 아직 check 안한 부분 검사
				if (check[i] == 0) {
					result = dfs(i, 1);
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j : board[i]) {
					if (check[i] == check[j]) {
						result = false;
					}
				}
			}

			System.out.println(result == true ? "YES" : "NO");
		}

	}

	public static boolean dfs(int start, int cnt) {
		check[start] = cnt;

		for (int i : board[start]) {
			if (check[i] == 0) {
				if (dfs(i, 3 - cnt) == false) {
					return false;
				}
			}

		}

		return true;
	}
}