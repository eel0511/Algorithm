package today;

import java.util.Scanner;

public class boj1912_연속합 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] board = new int[N];
		int max = 0;
		int[] save = new int[N];
		for (int i = 0; i < save.length; i++) {
			board[i] = sc.nextInt();
		}

		save[0] = board[0];
		max = board[0];

		for (int i = 1; i < N; i++) {
			save[i] = Integer.max(save[i - 1] + board[i], board[i]);
			max = Integer.max(max, save[i]);
		}
		System.out.println(max);
	}
}
