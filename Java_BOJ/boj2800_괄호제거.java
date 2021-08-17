package today;

import java.util.*;

public class boj2800_괄호제거 {
	static String[] st;
	static Stack<Integer> stack = new Stack<>();
	static HashMap<Integer, Integer> map = new HashMap<>();
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String first = sc.nextLine();
		st = first.split("");

		//String 배열로 입력받은 식에서 괄호만 따로 쌍을 잡아서 map에 넣어줌
		for (int i = 0; i < st.length; i++) {
			if (st[i].equals("(")) {
				stack.push(i);
			} else if (st[i].equals(")")) {
				int temp = stack.pop();
				map.put(temp, i);
			}
		}
		//백트래킹
		dfs(0, "");
		
		//정렬을 위해 set을 List에 담고 정렬 후 출력
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);

		//자기자신 제외
		for (String str : list) {
			if (!str.equals(first)) {
				System.out.println(str);
			}
		}
	}

	public static void dfs(int index, String s) {

		//종료조건
		if (index >= st.length) {
			//중복방지를 위해 set사용
			set.add(s);
			return;
		} else {
			//map에 들어있는 index순서가 오면 괄호 이므로
			if (map.containsKey(index)) {

				//괄호를 지우고 dfs
				st[index] = "";
				st[map.get(index)] = "";
				dfs(index + 1, s + st[index]);

				//괄호를 풀어주고 dfs
				st[index] = "(";
				st[map.get(index)] = ")";

			}
			//지속해서 한칸씩 이동하면서 s에 식을 한칸씩담아나감
			dfs(index + 1, s + st[index]);
		}

	}

}
