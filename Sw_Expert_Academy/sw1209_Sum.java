package today;

import java.util.Arrays;
import java.util.Scanner;

public class sw1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] arr = new int[100][100];
			int[] save = new int[202];
			int sum = 0;
			int num = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					save[i] += arr[i][j];
				}
				for (int j = 0; j < 100; j++) {
					save[i + 100] += arr[j][i];
				}
				for (int j = 0; j < 100; j++) {
					if (i == j) {
						save[200] += arr[i][j];
					}
				}
				for (int j = 0; j < 100; j++) {
					if (i + j == 99) {
						save[201] += arr[i][j];
					}

				}
			}
			Arrays.sort(save);
			System.out.println("#"+num+" "+save[201]);
		}

	}
}
