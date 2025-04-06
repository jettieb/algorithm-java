package 탐색;

import java.util.*;
import java.io.*;

public class 트리의지름구하기_1167 {
    static ArrayList<Edge>[] a; //연결 (정점, 거리)
    static boolean[] visited;
    static int[] distance;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        a = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<Edge>();
        }
        visited = new boolean[n + 1 ];
        distance = new int[n + 1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int edge = Integer.parseInt(st.nextToken());
                if(edge == -1)
                    break;
                int value = Integer.parseInt(st.nextToken());
                a[s].add(new Edge(edge, value));
            }
        }
        DFS(1); //임의로 1번 노드에 대해서 DFS 먼저 실행(먼 노드 찾기 위해서)
        int max = 0;    //최대 노드찾기
        for(int i=1; i<=n; i++){
            if(distance[max] < distance[i])
                max = i;
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        DFS(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    static void DFS(int node){
        visited[node] = true;
        for(Edge edge: a[node]){
            if(!visited[edge.e]){   //방문 안한 경우
                distance[edge.e] = distance[node] + edge.value;
                DFS(edge.e);
            }
        }
    }

    static class Edge{
        int e;
        int value;
        public Edge(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
}
