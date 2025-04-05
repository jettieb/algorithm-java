package 탐색;

import java.io.*;
import java.util.*;

public class DFS와BFS_1260 {
    static boolean visited[];
    static ArrayList<Integer>[] a;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //정점수
        int m = Integer.parseInt(st.nextToken());   //간선수
        int start = Integer.parseInt(st.nextToken());   //탐색 시작 번호
        a = new ArrayList[n + 1];
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
        //번호가 작은 것 먼저 방문해야함
        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }
        //DFS
        visited = new boolean[n + 1];
        DFS(start);
        System.out.println();
        //BFS
        visited = new boolean[n + 1];
        BFS(start);
    }

    public static void DFS(int node){
        if(visited[node])
            return;
        System.out.print(node + " ");
        visited[node] = true;
        for(int i: a[node]){
            DFS(i);
        }
    }

    public static void BFS(int node){
        //DFS와 다르게 재귀로 구현x. 큐 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for(int i: a[now_node]){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
