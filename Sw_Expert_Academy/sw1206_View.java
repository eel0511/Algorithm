package today;

import java.util.Scanner;

public class sw1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] cnt = new int[101];
			int max = 0;
			int temp = 0;
			int num = sc.nextInt();
			
			for (int i = 0; i < 1000; i++) {
				temp = sc.nextInt();
				cnt[temp]++;
			}
			for (int i = 0; i < 101; i++) {
				if (cnt[i] >= max) {
					max = cnt[i];
				}
				
			}
			int save = 0;
			for (int i = 0; i < 101; i++) {
				if (cnt[i] == max) {
					if (i >= save) {
						save = i;
						
					}

				}
			}
			System.out.println("#" + num + " " + save);
		}

	}
}
