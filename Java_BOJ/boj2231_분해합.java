package today;

import java.util.Scanner;

public class boj2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		for (int i = 0; i < N; i++) {
			int temp = i;
			int sum = i;

			while (temp != 0) {
				sum += temp % 10;
				temp /= 10;
			}

			if (sum == N) {
				result = i;
				break;
			}

		}
		System.out.println(result);
	}

}
