package 탐색;

import java.io.*;
import java.util.*;

public class 연결요소의개수구하기_11724 {
    static ArrayList<Integer>[] a;  //인접리스트
    static boolean visited[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {   //인접 리스트 초기화
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //양방향으로 에지 추가
            a[s].add(e);
            a[e].add(s);
        }
        int count = 0;
        //방문하지 않은 노드가 없을 때 까지 계속 반복
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
    }

    public static void DFS(int edge){
        if(visited[edge]){
            return;
        }
        visited[edge] = true;
        //연결되어있는 노드 모두 탐색
        for(int i: a[edge]){
            if(visited[edge] == false)
                DFS(i);
        }
    }
}
