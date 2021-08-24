package today;

import java.util.Scanner;

public class sw12221_구구단2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if (A < 10 && B < 10)
				System.out.println("#"+t+" "+A * B);
			else
				System.out.println("#"+t+" -1");
		}
	}
}
