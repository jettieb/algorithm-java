package 탐색;

import java.io.*;
import java.util.*;

public class P1697_숨바꼭질 {
    static int n,k;
    static int[] dist;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[200001];  //몇 번째로 들어갔는지 확인위함
        BFS();
        System.out.println(dist[k]);
    }
    private static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == k)
                break;
            int depth = dist[now];
            if(now * 2 <= 200000 && now * 2 >= 0){
                if(dist[now * 2] == 0){
                    queue.add(now * 2);
                    dist[now * 2] = depth + 1;
                }
            }
            if(now + 1 <= 200000 && now + 1 >= 0){
                if(dist[now + 1] == 0){
                    queue.add(now + 1);
                    dist[now + 1] = depth + 1;
                }
            }
            if(now - 1 <= 200000 && now - 1 >= 0){
                if(dist[now - 1] == 0){
                    queue.add(now - 1);
                    dist[now - 1] = depth + 1;
                }
            }
        }
    }
}
