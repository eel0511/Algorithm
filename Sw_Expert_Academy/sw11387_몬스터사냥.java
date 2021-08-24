package today;

import java.util.Scanner;

public class sw11387_몬스터사냥 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++) {

			long D = sc.nextInt();
			long L = sc.nextInt();
			long N = sc.nextInt();
			long result = (D * N) + ((D * L * N * (N - 1)) / 200);
			System.out.println("#"+(t+1)+" "+result);
		}

	}
}
