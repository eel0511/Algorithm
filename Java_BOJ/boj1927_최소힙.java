package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927_최소힙 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Scanner 사용시 시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (!q.isEmpty() && temp == 0) {
				System.out.println(q.poll());
			} else if (q.isEmpty() && temp == 0) {
				System.out.println("0");
			}else {
				q.add(temp);
			}
		}
	}

}
