package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715_카드정렬하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		int total = 0;
		while (true) {
			if (q.size() == 1) {
				break;
			}
			int sum = q.poll() + q.poll();
			total += sum;
			q.add(sum);
		}
		System.out.println(total);
	}

}
