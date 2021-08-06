package today;

import java.util.Scanner;

public class sw1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			System.out.println("#" + T + " " + pow(num1, num2));

		}
	}

	public static int pow(int num1, int num2) {

		if (num2 == 1) {
			return num1;
		}
		return num1 * pow(num1, num2 - 1);
	}

}
