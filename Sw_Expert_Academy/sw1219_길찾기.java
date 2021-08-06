package today;

import java.util.Scanner;

public class sw1219 {
	static int check = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int[][] arr = new int[100][100];
			check = 0;

			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;

			}
			find(arr, 0);
			System.out.println("#" + test_case + " " + check);
		}
	}

	public static void find(int[][] arr, int start) {
		int[] temp = new int[100];
		if (start == 99) {
			check = 1;
			return;
		}
		temp[start] = 1;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0 && arr[start][i] == 1) {
				find(arr, i);
			}
		}

	}

}
