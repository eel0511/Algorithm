package today;

import java.util.Scanner;

public class boj2505 {
	static int[] arr;
	static int[] temp;
	static int start = 0;
	static int end = 0;
	static int[][] save;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		save = new int[3][2];
		for (int i = 0; i < save.length; i++) {
			save[i][0] = 1;
			save[i][1] = 1;
		}
		arr = new int[N + 1];
		temp = new int[N + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			temp[i] = arr[i];
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != i) {
				start = i;
				end = arr.length - 1;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == i) {
						end = j;
						break;
					}
				}

				cnt++;
				flip(start, end);
				if (cnt < 3) {
					save[cnt][0] = start;
					save[cnt][1] = end;
					if (check()) {
						if (cnt == 1) {

						}
						cnt = 0;
						break;
					}
				}

			}
			if (cnt == 3) {
				break;
			}
		}

		if (cnt == 3) {

			init();
			for (int i = arr.length - 1; i > 1; i--) {
				if (arr[i] != i) {
					start = 1;
					end = i;
					for (int j = i - 1; j > 1; j--) {
						if (arr[j] == i) {
							start = j;
							break;
						}
					}
					flip(start, end);
					cnt++;
					if (cnt < 3) {
						save[cnt][0] = start;
						save[cnt][1] = end;

					}
					if (cnt == 3) {
						break;
					}

				}
			}
		}
		for (int i = 1; i < save.length; i++) {
			System.out.println(save[i][0] + " " + save[i][1]);
		}
	}

	public static void flip(int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void init() {
		start = 0;
		end = 0;
		cnt = 0;
		for (int i = 0; i < save.length; i++) {
			save[i][0] = 1;
			save[i][1] = 1;
		}
		for (int i = 1; i < arr.length; i++) {

			arr[i] = temp[i];
		}

	}

	public static boolean check() {
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] != i) {
				return false;
			}
		}
		return true;
	}

}
