package 그래프;

import java.util.*;
import java.io.*;

/**
 * <체크할 점>
 *     1. 사이클이 end까지 영향을 미치는가?
 *     2. 사이클을 겁나게 돌아야지만 end까지 영향을 미치는가??? -> 이것때문에 계속 틀렸다
 *     3. 사이클이 여러개 존재할 수 있음 주의
 *     */

public class P1219_오민식의고민 {
    static int n, m, start, end;
    static long[] cMoney, distance;
    static Edge[] edges;    //연결 간선 정보(s,e,v)
    static ArrayList<Integer>[] arr;    //연결리스트
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cMoney = new long[n];
        edges = new Edge[m];
        distance = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE);
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s,e,v);
            arr[s].add(e);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cMoney[i] = Long.parseLong(st.nextToken());
        }

        boolean infinite = solve();
        if(!infinite){
            if(distance[end] == Long.MIN_VALUE)
                System.out.println("gg");
            else
                System.out.println(distance[end]);
        }
        else
            System.out.println("Gee");
    }
    static private boolean solve(){
        distance[start] = cMoney[start];    //출발값 초기화
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != Long.MIN_VALUE
                        && distance[edge.end] < distance[edge.start] + cMoney[edge.end] - edge.value){
                    distance[edge.end] = distance[edge.start] + cMoney[edge.end] - edge.value;
                }
            }
        }

        //사이클 확인 - BFS
        Queue<Edge> changeE = new LinkedList<>();    //사이클이 생기는 Edge 리스트
        for(int j=0; j<m; j++){
            Edge edge = edges[j];
            if(distance[edge.start] != Long.MIN_VALUE
                    && distance[edge.end] < distance[edge.start] + cMoney[edge.end] - edge.value){
                changeE.add(edge);
            }
        }
        //Edge 리스트 개수 만큼 BFS 실행
        while(!changeE.isEmpty()){
            Edge nowEdge = changeE.poll();
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(nowEdge.end);
            while(!queue.isEmpty()){
                int now = queue.poll();
                if(now == end)
                    return true;    //무한이면 true
                visited[now] = true;
                for(int i: arr[now]){
                    if(!visited[i])
                        queue.add(i);
                }
            }
        }
        return false;
    }
    static class Edge{
        int start, end;
        long value;
        public Edge(int s, int e, long v){
            this.start = s;
            this.end = e;
            this.value = v;
        }
    }
}
