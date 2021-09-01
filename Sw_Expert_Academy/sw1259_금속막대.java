package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class sw1259_금속막대 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][2];
			boolean[] check = new boolean[N];
			String[] st = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				board[i][0] = Integer.parseInt(st[2 * i]);
				board[i][1] = Integer.parseInt(st[2 * i + 1]);
			}
			Deque<int[]> q = new LinkedList<>();
			Deque<int[]> q2 = new LinkedList<>();
			q.add(new int[] {board[0][0],board[0][1]});
			q2.add(new int[] {board[0][0],board[0][1]});
			check[0]=true;
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				for (int i = 0; i < N; i++) {
					if(!check[i] && (temp[0] == board[i][1])) {
						check[i]=true;
						q.addFirst(new int[] {board[i][0],board[i][1]});
						q2.addFirst(new int[] {board[i][0],board[i][1]});
						break;
					}
				}
				for (int i = 0; i < N; i++) {
					if(!check[i] && (temp[1] == board[i][0])) {
						check[i]=true;
						q.addLast(new int[] {board[i][0],board[i][1]});
						q2.addLast(new int[] {board[i][0],board[i][1]});
						break;
					}
				}
			}
			System.out.print("#"+t+" ");
			while(!q2.isEmpty()) {
				int[] temp = q2.poll();
				System.out.print(temp[0]+" "+temp[1]+" ");
			}System.out.println();
			
			
		}
	}

}
