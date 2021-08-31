package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class sw1221_GNS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> map = new HashMap<>();
		map.put("ZRO", 0);
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THR", 3);
		map.put("FOR", 4);
		map.put("FIV", 5);
		map.put("SIX", 6);
		map.put("SVN", 7);
		map.put("EGT", 8);
		map.put("NIN", 9);
		HashMap<Integer,String> map2 =  new HashMap<>();
		map2.put(0, "ZRO");
		map2.put(1, "ONE");
		map2.put(2, "TWO");
		map2.put(3, "THR");
		map2.put(4, "FOR");
		map2.put(5, "FIV");
		map2.put(6, "SIX");
		map2.put(7, "SVN");
		map2.put(8, "EGT");
		map2.put(9, "NIN");
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			br.readLine();
			String[] temp = br.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int i = 0; i < temp.length; i++) {
				list.add(map.get(temp[i]));
			}
			Collections.sort(list);
			System.out.print("#"+t+"\n");
			for (int i : list) {
				System.out.print(map2.get(i)+" ");
			}
			System.out.println();
		}
		
	}

}
