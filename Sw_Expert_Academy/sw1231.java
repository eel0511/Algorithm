package today;

import java.util.Scanner;

public class sw1231 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			char arr[] = new char[num + 1];
			sc.nextLine();
			for (int i = 1; i < arr.length; i++) {
				String temp = sc.nextLine();
				arr[i] = temp.split(" ")[1].charAt(0);
			}
			System.out.print("#" + test_case + " ");
			inorder(arr, 1, num);
			System.out.println();
		}

	}

	public static void inorder(char[] arr, int node, int num) {
		if (node <= num) {
			inorder(arr, node * 2, num);
			System.out.print(arr[node] + "");
			inorder(arr, node * 2 + 1, num);
		}

	}

}
