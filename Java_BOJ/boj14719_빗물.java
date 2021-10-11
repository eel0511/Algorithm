package today4;

import java.util.Scanner;

public class boj14719_빗물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[] arr = new int[W];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int total = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int left = 0;
			int right = 0;
			for (int j = 0; j < i; j++) {
				left = Integer.max(left, arr[j]);
			}
			for (int j = i + 1; j < arr.length; j++) {
				right = Integer.max(right, arr[j]);
			}

			int water = Integer.min(left, right) - arr[i];
			total += water >= 0 ? water : 0;

		}
		System.out.println(total);
	}
}
