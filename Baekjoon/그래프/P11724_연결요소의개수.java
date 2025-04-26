package 그래프;

import java.util.*;
import java.io.*;

public class P11724_연결요소의개수 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int n;
    static int result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                DFS(i);
                result++;
            }
        }
        System.out.println(result);
    }
    private static void DFS(int i){
        visited[i] = true;
        for(int k: arr[i]){
            if(!visited[k]){
                DFS(k);
            }
        }
    }
}
