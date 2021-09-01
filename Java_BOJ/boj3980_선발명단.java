package today2;

import java.util.LinkedList;
import java.util.Scanner;

public class boj3980_선발명단 {
	static int[][] board;
	static boolean[] check;
	static LinkedList<Integer> result;
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		for (int t = 0; t < C; t++) {
			board = new int[11][11];
			check = new boolean[11];
			result = new LinkedList<>();
			max = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			dfs(0);
			System.out.println(max);
		}
	}

	public static void dfs(int start) {
		for (int i = 0; i < result.size(); i++) {
			if (board[i][result.get(i)] == 0)
				return;
		}

		if (result.size() == 11) {
			int sum=0;
			for (int i = 0; i < result.size(); i++) {
				sum+=board[i][result.get(i)];
			}
			max = Integer.max(max, sum);
			return;
		}

		for (int i = 0; i < 11; i++) {
			if (!check[i]) {
				check[i] = true;
				result.add(i);
				dfs(i + 1);
				result.remove(result.indexOf(i));
				check[i] = false;
			}
		}

	}

}
