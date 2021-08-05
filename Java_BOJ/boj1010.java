package today;

import java.math.BigInteger;
import java.util.Scanner;

public class boj1010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int west = sc.nextInt();
			int east = sc.nextInt();
			if (west == east) {
				System.out.println(1);
				continue;
			}
			BigInteger sum = BigInteger.ONE;
			BigInteger div = BigInteger.ONE;
			for (int j = east; j > (east - west); j--) {
				sum = sum.multiply(BigInteger.valueOf(j));
			}

			for (int k = west; k > 0; k--) {
				div = div.multiply(BigInteger.valueOf(k));
			}
			System.out.println(sum.divide(div));
		}
	}

}
