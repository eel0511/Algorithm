package today;

import java.util.Scanner;

public class sw11445_무한사전 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int t = 1; t <= testcase; t++) {

			String st1 = sc.next();
			String st2 = sc.next();

			if ((st1 + "a").equals(st2)) {
				System.out.println("#" + t + " N");
			} else {
				System.out.println("#" + t + " Y");
			}
		}
	}
}
