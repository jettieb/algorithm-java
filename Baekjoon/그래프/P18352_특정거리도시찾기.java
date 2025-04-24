package 그래프;

import java.util.*;
import java.io.*;

public class P18352_특정거리도시찾기 {
    static ArrayList<Integer>[] arr;
    static int[] dist;  //최단 거리 저장
    static int k,n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //도시개수
        int m = Integer.parseInt(st.nextToken());   //도로개수
        k = Integer.parseInt(st.nextToken());   //거리정보
        int x = Integer.parseInt(st.nextToken());   //출발도시번호
        arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);  //단방향
        }
        BFS(x);
        String result = "";
        for(int i=1; i<=n; i++){
            if(dist[i] == k) {    //k부터 k는 반드시 0
                result += i + "\n";
            }
        }
        if(result == "")
            result = "-1";
        System.out.println(result);
    }

    private static void BFS(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i: arr[now]){
                if(dist[i] == 0 && i != s){
                    queue.add(i);
                    dist[i] = dist[now] + 1;
                }
            }
        }
    }
}