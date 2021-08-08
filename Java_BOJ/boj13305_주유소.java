package today;

import java.util.Scanner;

public class boj13305_주유소 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] road = new long[N - 1];
		long[] price = new long[N];
		long sum = 0;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < road.length; i++) {
			road[i] = sc.nextInt();
		}
		for (int i = 0; i < price.length; i++) {
			price[i] = sc.nextInt();
		}

		min = price[0];
		for (int i = 0; i < price.length; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			sum += road[i] * min;
		}

		System.out.println(sum);
	}

}
