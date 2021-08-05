package today;

import java.util.Scanner;

public class sw1245 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		for (int test_case = 1; test_case <= num; test_case++) {

			int N = sc.nextInt();
			// [][0] = x좌표 [][1] = 질량
			double[][] ec = new double[N][2];
			double[] result = new double[N];
			double start = 0;
			double end = 0;
			double mid = 0;
			double left = 0;
			double right = 0;

			for (int i = 0; i < N; i++) {
				ec[i][0] = sc.nextDouble();
			}
			for (int i = 0; i < N; i++) {
				ec[i][1] = sc.nextDouble();
			}

			for (int i = 1; i < N; i++) {
				start = ec[i - 1][0];
				end = ec[i][0];
				int cnt = 0;
				while (cnt < 100) {

					mid = (start + end) / 2;
					left = 0;
					right = 0;

					for (int j = 0; j < N; j++) {
						double power = ec[j][1] / Math.pow((mid - ec[j][0]), 2);

						if (ec[j][0] < mid) {
							left += power;
						} else {
							right += power;
						}
					}
					if (left < right) {
						end = mid;
					} else {
						start = mid;
					}
					cnt++;
				}
				result[i] = mid;
			}
			System.out.print("#"+test_case+" ");
			for (int i = 1; i < result.length; i++) {
				System.out.printf("%.10f ",result[i]);
			}
			System.out.println();

		}
	}

}
