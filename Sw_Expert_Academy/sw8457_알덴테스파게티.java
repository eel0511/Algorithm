package today;

import java.util.HashSet;
import java.util.Scanner;

public class sw8457_알덴테스파게티 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int E = sc.nextInt();
			int[] clock = new int[N];
			for (int i = 0; i < clock.length; i++) {
				clock[i] = sc.nextInt();
			}
			HashSet<Integer> set = new HashSet<>();

			for (int i = B - E; i <= B + E; i++) {
				for (int j = 0; j < clock.length; j++) {
					if (i % clock[j] == 0) {
						set.add(j);
					}
				}
			}
			System.out.println("#"+t+" "+set.size());
		}
	}

}
