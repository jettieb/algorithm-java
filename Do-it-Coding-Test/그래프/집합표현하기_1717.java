package 그래프;

import java.util.*;
import java.io.*;

public class 집합표현하기_1717 {
    static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i=1; i<=n; i++){
            parent[i] = i;  //대표노드 우선 자기자신으로 초기화
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(question == 0)
                union(a,b);
            else{
                if(checkSame(a,b))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    private static int find(int a){ //대표노드 찾기
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]); //경로를 거쳐온 모든 값 대표노드로 변경
    }
    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        return a == b;
    }
}
