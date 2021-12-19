package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10775_공항 {
    static int G,P;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
        int ans = 0;
        for (int i = 0; i < P; i++) {
            int temp = Integer.parseInt(br.readLine());
            int emptyGate = find(temp);
            if(emptyGate==0) break;
            ans++;
            union(emptyGate,emptyGate-1);
        }
        System.out.println(ans);
        
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x!=y){
            parent[x]=y;
        }
    }
}
