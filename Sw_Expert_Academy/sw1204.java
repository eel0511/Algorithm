package today;

import java.util.Arrays;
import java.util.Scanner;

public class sw1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= 10; test_case++) {

			int num = sc.nextInt();

			int[] building = new int[num];
			for (int i = 0; i < num; i++) {
				building[i]=sc.nextInt();
			}
			cnt = 0;
			for (int i = 2; i < num - 2; i++) {

				int b1 = building[i - 2];
				int b2 = building[i - 1];
				int b3 = building[i];
				int b4 = building[i + 1];
				int b5 = building[i + 2];

				int[] temparr = { b1, b2, b3, b4, b5 };
				Arrays.sort(temparr);
				if (temparr[4] == b3) {
					cnt += b3 - temparr[3];
				}
			}
			System.out.println("#" + test_case + " " + cnt);

		}
	}

}
