package 그래프;

import java.util.*;
import java.io.*;

//다익스트라 기본 중 기본
public class 다익스트라_1753 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<Node>[] arr = new ArrayList[V + 1];
        for(int i=1; i<=V; i++){
            arr[i] = new ArrayList<>();
        }
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[u].add(new Node(v,w));
        }
        //다익스트라 시작
        distance[start] = 0;
        //큐에 들어가있는 것 중 현재 저장되어있는 값 중 제일 작은 노드부터
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()){
            int now = queue.poll().vertex;
            if(visited[now])
                continue;
            visited[now] = true;
            for(Node n: arr[now]){
                int next = n.vertex;
                if(distance[now] + n.weight < distance[next]){
                    distance[next] = distance[now] + n.weight;
                    queue.add(new Node(next, distance[next]));
                }
            }
        }
        //출력
        for(int i=1; i<=V; i++){
            if(distance[i] != Integer.MAX_VALUE)
                bw.write(distance[i] + "\n");
            else
                bw.write("INF\n");
        }
        bw.flush();
        bw.close();
    }
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
            //값 음수(this.weight < n.weight) -> this.weight가 작으면 this.weight가 더 우선순위(맨 앞 배치)
        }
    }
}
