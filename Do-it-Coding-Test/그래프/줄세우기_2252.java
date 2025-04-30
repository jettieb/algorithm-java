package 그래프;

import java.util.*;
import java.io.*;

public class 줄세우기_2252 {
    static ArrayList<Integer>[] arr;
    static int[] indegree;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b]++;  //b 앞에 a 있다
            arr[a].add(b);
        }
        //indegree값이 0인 맨 처음 시작지점
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        //BFS
        while (!queue.isEmpty()) {
            int now = queue.poll();
            bw.write(now + " ");
            for(int i: arr[now]){
                indegree[i] --;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
