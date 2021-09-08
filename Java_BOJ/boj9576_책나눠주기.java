package today3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj9576_책나눠주기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] student = new int[M][2];
			boolean[] check = new boolean[N + 1];
			for (int i = 0; i < student.length; i++) {
				student[i][0] = sc.nextInt();
				student[i][1] = sc.nextInt();
			}
			Arrays.sort(student, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[1] == o2[1])
						return o1[0] - o2[0];
					return o1[1] - o2[1];
				}
			});
			int cnt = 0;
			for (int i = 0; i < student.length; i++) {
				for (int j = student[i][0]; j <= student[i][1]; j++) {
					if (!check[j]) {
						check[j] = true;
						cnt++;
						break;
					}

				}
			}
			System.out.println(cnt);
		}

	}

}
