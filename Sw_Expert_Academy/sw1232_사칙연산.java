package today;

import java.util.Scanner;

public class sw1232 {
	static class Node {
		public String op;
		public int num;
		public int leftchild;
		public int rightchild;

		public Node(String op, int num, int left, int right) {
			this.op = op;
			this.num = num;
			this.leftchild = left;
			this.rightchild = right;
		}
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			sc.nextLine();
			Node arr[] = new Node[num + 1];
			for (int i = 1; i < arr.length; i++) {
				String[] temp = sc.nextLine().split(" ");

				if (temp[1].equals("+") || temp[1].equals("-") || temp[1].equals("*") || temp[1].equals("/")) {
					arr[i] = new Node(temp[1], 0, Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
					
				} else {
					arr[i] = new Node("", Integer.parseInt(temp[1]), 0, 0);
				}
				
			}

			for (int i = arr.length - 1; i >= 1; i--) {

				if (arr[i].op.equals("+") || arr[i].op.equals("-") || arr[i].op.equals("*") || arr[i].op.equals("/")) {
					switch (arr[i].op) {
					case "+":
						arr[i].num = arr[arr[i].leftchild].num + arr[arr[i].rightchild].num;
						break;
					case "-":
						arr[i].num = arr[arr[i].leftchild].num - arr[arr[i].rightchild].num;
						break;
					case "*":
						arr[i].num = arr[arr[i].leftchild].num * arr[arr[i].rightchild].num;
						break;
					case "/":
						arr[i].num = arr[arr[i].leftchild].num / arr[arr[i].rightchild].num;
						break;

					}
				}
			}
			System.out.println(arr[1].num);

		}

	}

}
