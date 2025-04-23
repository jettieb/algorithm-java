package 탐색;

import java.io.*;
import java.util.*;

public class P1389_케빈베이컨의6단계법칙 {
    static ArrayList<Integer>[] arr;
    static int[] kevin;
    static int n,m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        kevin = new int[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        //각 사람들의 kevin값 배열에 저장
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                kevin[i] += BFS(i, j);
            }
        }
        //가장 작은 번호 찾기
        int min = kevin[1];
        int num = 1;
        for(int i=2; i<=n; i++){
            if(kevin[i] < min){
                min = kevin[i];
                num = i;
            }
        }
        System.out.println(num);
    }

    //s에서 시작해서 e까지 가는 최단거리
    private static int BFS(int s, int e){
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        dist[s] = 1;
        visited[s] = true;
        Queue<Integer> queue = new LinkedList();
        queue.add(s);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if (now == e)
                break;
            for(int i: arr[now]){
                if(!visited[i]){
                    queue.add(i);
                    dist[i] = dist[now] + 1;
                    visited[i] = true;
                }
            }
        }
        return dist[e];
    }
}
