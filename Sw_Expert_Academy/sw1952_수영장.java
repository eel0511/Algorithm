package today2;

import java.util.Scanner;

public class sw1952_수영장 {

	static int[] ticket;
	static int[] year;
	static int min;
	static int total;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			ticket = new int[4];
			for (int i = 0; i < ticket.length; i++) {
				ticket[i] = sc.nextInt();
			}
			year = new int[12];
			for (int i = 0; i < year.length; i++) {
				year[i] = sc.nextInt();
			}
			total = 0;
			min = ticket[3];
			dfs(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	public static void dfs(int start, int total) {
		if (start == 12) {
			min = Integer.min(min, total);
			return;
		}
		// 가지치기 용으로 넣어봄
		if (total > min)
			return;

		// 없을때는 바로 뒷달로
		if (year[start] == 0) {
			dfs(start + 1, total);
		}
		// 1일권 이용
		if (year[start] > 0) {
			dfs(start + 1, total + (year[start] * ticket[0]));
		}
		// 한달권 이용
		dfs(start + 1, total + ticket[1]);
		// 3달권이용
		if (start < 10) {
			dfs(start + 3, total + ticket[2]);
		}

	}

}
