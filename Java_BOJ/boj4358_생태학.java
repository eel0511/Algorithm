package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class boj4358_생태학 {
    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";

        int cnt = 0;
        while ((temp = br.readLine()) != null) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            cnt++;

        }
        Object[] arr = map.keySet().toArray();
        Arrays.sort(arr);
        for (Object o : arr) {
            int value = map.get(o);
            double d = ((double)value / (double)cnt) * 100;
            System.out.println(o + " " + String.format("%.4f", d));
        }
    }
}
