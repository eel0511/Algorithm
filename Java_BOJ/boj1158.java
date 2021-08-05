package today;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int temp = 0;
		int i = 1;

		Queue<Integer> qu = new LinkedList<>();
		for (int k = 0; k < N; k++) {
			qu.add(k + 1);
		}
		Queue<Integer> result = new LinkedList<>();
		String st = "<";
		while (!qu.isEmpty()) {
			if (i == K) {
				i = 1;
				result.add(qu.poll());
				continue;
			}
			qu.add(qu.poll());
			i++;
		}

		while (result.size() != 1) {
			st+=result.poll()+", ";
		}
		st+=result.poll()+">";
		System.out.println(st);
	}

}
