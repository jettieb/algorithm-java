package 탐색;

import java.util.*;
import java.io.*;

public class P2644_촌수계산 {
    static ArrayList<Integer>[] a;
    static boolean[] visited;
    static int end;
    static int result = -1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];
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
        DFS(start, 0);
        System.out.println(result);
    }

    public static void DFS(int edge, int depth){
        if(visited[edge] || result != -1)
            return;
        if(edge == end){
            result = depth;
            return;
        }
        visited[edge] = true;
        for(int i: a[edge]){
            DFS(i, depth + 1);
        }
    }
}
