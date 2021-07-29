package today;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			int temp = 0;
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			while (true) {
				for (int i = 1; i < 6; i++) {
					temp = queue.poll();
					temp -= i;
					
					if (temp<= 0) {
						queue.add(0);
						break;
					}
					queue.add(temp);
					
						

				}
				if (temp <= 0)
					break;
				
			}
			System.out.print("#"+test_case+" ");
			Iterator<Integer> it = queue.iterator();
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}

	}

}
