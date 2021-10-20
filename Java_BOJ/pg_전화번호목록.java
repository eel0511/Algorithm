package today4;

import java.util.HashMap;

public class pg_전화번호목록 {

	public static void main(String[] args) {

		System.out.println(solution(new String[] {"119","974915","156165","1199996565"}));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j < phone_book[i].length(); j++) {
				if (map.containsKey(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}

		return answer;
	}

}
