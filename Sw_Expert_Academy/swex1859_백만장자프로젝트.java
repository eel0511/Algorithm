package today;

import java.util.Scanner;

public class swex1859_백만장자프로젝트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {

			int N = sc.nextInt();
			int[] save = new int[N];
			long result = 0;
			for (int j = 0; j < N; j++) {
				save[j] = sc.nextInt();
			}
			int max = save[save.length - 1];
			for (int j = save.length - 1; j >= 0; j--) {

				if (save[j] > max) {
					max = save[j];
				}
				result += max - save[j];
				System.out.print(result+" ");

			}
			System.out.println("#" + (i + 1) + " " + result);

		}
	}

}
