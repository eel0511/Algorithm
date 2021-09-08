package today3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj20440_니가싫어 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] save = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			save[i][0] = Integer.parseInt(temp[0]);
			save[i][1] = Integer.parseInt(temp[1]);
		}
		Arrays.sort(save, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub

				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> q = new PriorityQueue<>();
		int cnt = 0;
		int start = save[0][0];
		int end = save[0][1];
		for (int i = 0; i < save.length; i++) {
			while (!q.isEmpty() && q.peek() < save[i][0]) {
				q.poll();
			}
			if (!q.isEmpty() && q.peek() == save[i][0]) {
				if (q.peek() == end) {
					end = save[i][1];
				}
				q.poll();
			}

			q.add(save[i][1]);

			if (q.size() > cnt) {
				cnt = q.size();
				start = save[i][0];
				end = q.peek();
			}
		}
		System.out.println(cnt);
		System.out.println(start+" "+end);
	}

}
