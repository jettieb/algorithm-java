package 그래프;

import java.io.*;
import java.util.*;

public class P1325_효율적인해킹 {
    static ArrayList<Integer>[] graph;
    static int[] cnt;
    static boolean[] visited;
    static int n,m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        cnt = new int[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        for(int i=1; i<=n; i++){
            visited = new boolean[n + 1];
            //BFS
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int k: graph[now]){
                    if(!visited[k]){
                        visited[k] = true;
                        cnt[k] ++;
                        queue.add(k);
                    }
                }
            }
        }
        int max = cnt[1];
        for(int i=2; i<=n; i++) {
            max = Math.max(max, cnt[i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=n; i++){
            if(max == cnt[i]){
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
