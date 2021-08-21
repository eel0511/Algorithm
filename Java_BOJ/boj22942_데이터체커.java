package today;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj22942_데이터체커 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		//오름차순 정렬 x 기준으로
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] < o2[0]) {
					return 1;
				} else if (o1[0] > o2[0]) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			q.add(new int[] { sc.nextInt(), sc.nextInt() });
		}
		int[] temp = q.poll();
		while (!q.isEmpty()) {
			int newX = q.peek()[0];
			int newR = q.peek()[1];
			// circlex[i] - circler[i] 기준원의 왼쪽에 circle[j]가 있을경우
			if ((temp[0] - temp[1] > newX + newR) && (temp[0] - temp[1] > newX - newR)) {
				temp = q.poll();
				continue;
			}
			// circle[i] 기준원의 오른쪽에 circle[j]가 있을경우
			if ((temp[0] - temp[1] > newX + newR) && (temp[0] - temp[1] > newX - newR)) {
				temp = q.poll();
				continue;
			}
			// 원이 안에 있을때
			if ((temp[0] - temp[1] < newX - newR) && (temp[0] + temp[1] > newX + newR)) {
				temp = q.poll();
				continue;
			}
			//원이 밖에있을때
			if ((temp[0] - temp[1] > newX - newR) && (temp[0] + temp[1] < newX + newR)) {
				temp = q.poll();
				continue;
			}

			flag = true;
			break;

		}

		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}
