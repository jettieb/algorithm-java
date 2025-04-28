package 그래프;

import java.util.*;
import java.io.*;

/**
 * 유니온 파인드
 * */
public class P1976_여행가자 {
    static int[] parent;
    static int[] root;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for(int i=1; i<=n; i++){
            parent[i] = i;  //초기화
        }
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int connect = Integer.parseInt(st.nextToken());
                if(j > i && connect == 1){
                    union(i, j);
                }
            }
        }
        root = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            root[i] = find(Integer.parseInt(st.nextToken()));   //루트 찾아서 바로 저장
        }
        boolean result = true;
        for(int i=0; i<m - 1; i++){
            if(root[i] != root[i + 1]) {
                result = false;
                break;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
    private static void union(int i, int j){
        i = find(i);
        j = find(j);
        parent[j] = i;
    }
    private static int find(int i){
        if(i == parent[i])
            return i;
        else
            return parent[i] = find(parent[i]);
    }
}