package today;

import java.util.Scanner;

public class sw12368_24시간 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {

			int first = sc.nextInt();
			int second = sc.nextInt();

			System.out.println("#" + t + " " + (first + second) % 24);
		}

	}

}
