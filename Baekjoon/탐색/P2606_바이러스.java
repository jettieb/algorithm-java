package 탐색;

import java.io.*;
import java.util.*;

public class P2606_바이러스 {
    static ArrayList<Integer>[] a;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        //인접리스트 초기화
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        DFS(1);
        int result = 0;
        for(int i=2; i<=n; i++){
            if(visited[i])
                result ++;
        }
        System.out.println(result);
    }

    public static void DFS(int edge){
        if(visited[edge]){
            return;
        }
        visited[edge] = true;
        for(int i: a[edge]){
            DFS(i);
        }
    }
}
