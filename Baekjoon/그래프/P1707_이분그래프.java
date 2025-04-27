package 그래프;

import java.util.*;
import java.io.*;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static int v;
    static boolean result = true;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        for(int m=0; m<k; m++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[v + 1];
            for(int i=1; i<=v; i++){
                arr[i] = new ArrayList<>();
            }
            visited = new int[v + 1];
            result = true;
            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                arr[s].add(f);
                arr[f].add(s);
            }
            //방문하지 않은 경우 계속 탐색
            for(int i=1; i<=v; i++){
                if(visited[i] == 0)
                    BFS(i);
            }
            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1; //1,2로 색 구분
        while(!queue.isEmpty()){
            int now = queue.poll();
            int nowColor = visited[now];
            for(int s: arr[now]){
                //아직 방문하지 않은 경우
                if(visited[s] == 0){
                    queue.add(s);
                    if(nowColor == 1) visited[s] = 2;
                    else if(nowColor == 2) visited[s] = 1;
                }
                else if(visited[s] == nowColor)
                    result = false;
            }
        }
    }
}
