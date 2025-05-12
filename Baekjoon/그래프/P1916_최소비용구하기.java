package 그래프;

import java.util.*;
import java.io.*;
import java.util.stream.StreamSupport;

public class P1916_최소비용구하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node>[] arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        int[] bus = new int[n + 1];
        Arrays.fill(bus, Integer.MAX_VALUE);    //최소 버스 비용 구해야 하기 때문에 우선 전부 무한으로 넣기
        boolean[] visited = new boolean[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(e, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //다익스트라 시작
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(start, 0));
        bus[start] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll().city;
            if(visited[now])
                continue;
            visited[now] = true;
            for(Node node: arr[now]){
                int nextC = node.city;
                if(bus[nextC] > bus[now] + node.coin){
                    bus[nextC] = bus[now] + node.coin;
                    queue.add(new Node(nextC, bus[nextC]));
                }
            }
        }
        System.out.println(bus[end]);
    }
    static class Node implements Comparable<Node>{
        int city;
        int coin;
        Node(int city, int coin){
            this.city = city;
            this.coin = coin;
        }

        @Override
        public int compareTo(Node o) {
            return this.coin - o.coin;
        }
    }
}
