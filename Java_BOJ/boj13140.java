package today;

import java.util.Scanner;

public class boj13140 {

	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	static int[] temp = new int[7];
	static int[][] save = new int[605000][7];
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
		perm(10, 7);
		for (int i = 0; i < cnt; i++) {
			if (save[i][2] != 0 && save[i][6] != 0) {
				if (((save[i][2] * 10000 + save[i][1] * 1000 + save[i][3] * 100 + save[i][3] * 10 + save[i][4])
						+ (save[i][6] * 10000 + save[i][4] * 1000 + save[i][5] * 100 + save[i][3] * 10
								+ save[i][0])) == answer) {

					System.out.println("  " + save[i][2] + "" + save[i][1] + "" + save[i][3] + "" + save[i][3] + ""
							+ save[i][4] + "");
					System.out.println("+ " + save[i][6] + "" + save[i][4] + "" + save[i][5] + "" + save[i][3] + ""
							+ save[i][0] + "");
					System.out.println("-------");
					System.out.println("  " + answer);
					break;
				}

			}
			if (i == cnt - 1) {
				System.out.println("No Answer");
			}
		}

	}

	public static void perm(int n, int r) {

		if (r == 0) {
			savearr();
		} else {
			for (int i = n - 1; i >= 0; i--) {
				swap(i, n - 1);
				temp[r - 1] = arr[n - 1];
				perm(n - 1, r - 1);
				swap(i, n - 1);
			}

		}
	}

	public static void swap(int num1, int num2) {
		int t = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = t;
	}

	static void savearr() {

		for (int i = 0; i < 7; i++)
			save[cnt][i] = temp[i];
		cnt++;
	}
}
