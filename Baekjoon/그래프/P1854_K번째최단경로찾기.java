package 그래프;

import java.util.*;
import java.io.*;

public class P1854_K번째최단경로찾기 {
    static int n, m, k;
    static ArrayList<Node>[] arr;
    static ArrayList<Integer>[] dist;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        dist = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            dist[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e,value));
        }

        //경로 탐색 시작
        dijkstra(1,0);
        for(int i=1; i<=n; i++){
            if(dist[i].size() < k){
                bw.write("-1\n");
            } else{
                bw.write(dist[i].get(k - 1) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static void dijkstra(int c, int v){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(c,v));
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(dist[now.city].size() < k){
                dist[now.city].add(now.value);
                for(Node n: arr[now.city]){
                    if(dist[n.city].size() < k){
                        queue.add(new Node(n.city, n.value + now.value));
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int city;
        int value;
        Node(int city, int value){
            this.city = city;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) { return this.value - o.value; }
    }
}
