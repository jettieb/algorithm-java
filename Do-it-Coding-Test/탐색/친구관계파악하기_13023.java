package 탐색;

import java.util.*;
import java.io.*;

public class 친구관계파악하기_13023 {
    static ArrayList<Integer>[] a;
    static boolean visited[];
    static boolean arrive;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){ //인접리스트 초기화
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }
        for(int i=0; i<n; i++){
            DFS(i, 1);
            if(arrive)
                break;
        }
        if(arrive) System.out.println("1");
        else System.out.println("0");
    }

    public static void DFS(int now, int depth){
        if(depth == 5){
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i: a[now]){
            if(!visited[i])
                DFS(i, depth + 1);
        }
        visited[now] = false;
    }
}
