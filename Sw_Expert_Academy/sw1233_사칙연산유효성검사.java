package today;

import java.util.Scanner;

public class sw1233 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(sc.nextLine());
			
			int result = 1;
			for (int i = 1; i < num+1; i++) {
				String[] temp = sc.nextLine().split(" ");

				if (i > num / 2) {
					if (temp[1].equals("+") || temp[1].equals("-") || temp[1].equals("*") || temp[1].equals("/")) {
						result = 0;
					}
				} else {
					if (temp[1].equals("+") || temp[1].equals("-") || temp[1].equals("*") || temp[1].equals("/")) {

					} else {
						result = 0;
					}

				}
			}
			System.out.println("#"+test_case+" "+result);

		}
	}

}
