package today;

import java.util.Scanner;

public class boj9461_파도반수열 {
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		arr = new long[101];
		arr[0] = 0L;
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
	
		for (int i = 0; i < N; i++) {
			System.out.println(pado(sc.nextInt()));
		}

	}

	public static long pado(int num) {
		if (arr[num] == 0) {
			arr[num] = pado(num - 2) + pado(num - 3);
		}
		return arr[num];
	}

}
