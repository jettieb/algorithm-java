package 그래프;

import java.io.*;
import java.util.*;

public class P1948_임계경로 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<node>[] arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        ArrayList<node>[] arrReverse = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arrReverse[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];    //차수
        int[] time = new int[n + 1];    //도시별 걸린 최대 시간
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new node(e,v));
            arrReverse[e].add(new node(s,v));
            indegree[e]++;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 위상정렬 시작
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(node i: arr[now]){
                time[i.city] = Math.max(time[i.city], time[now] + i.value);
                indegree[i.city] --;
                if(indegree[i.city] == 0)
                    queue.add(i.city);
            }
        }
        System.out.println(time[end]);  //최대 시간
        //몇개의 도로를 거쳐야 하는지 역 위상정렬 시작
        int result = 0;
        boolean[] visited = new boolean[n + 1];
        queue.add(end);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(node i: arrReverse[now]){
                if(time[i.city] + i.value == time[now]){
                    if(!visited[i.city])
                        queue.add(i.city);
                    result ++;
                    visited[i.city] = true;
                }
            }
        }
        System.out.println(result);
    }
}
class node{
    int city;
    int value;
    node(int city, int value){
        this.city = city;
        this.value = value;
    }
}
