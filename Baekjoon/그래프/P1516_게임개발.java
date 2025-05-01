package 그래프;

import java.io.*;
import java.util.*;

//위상정렬
public class P1516_게임개발 {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        ArrayList<Integer>[] arrReverse = new ArrayList[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
            arrReverse[i] = new ArrayList<>();
        }
        int[] time = new int[n + 1];
        int[] indegree = new int[n + 1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while(next != -1){
                arr[next].add(i);
                arrReverse[i].add(next);
                indegree[i]++;
                next = Integer.parseInt(st.nextToken());
            }
        }
        //위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i: arr[now]){
                indegree[i]--;
                //아직 방문하지 않았는데 본인 차례인 경우
                if(indegree[i] == 0){
                    if(arrReverse[i].size() > 1){
                        int maxTime = 0;
                        for(int j: arrReverse[i]){
                            if(maxTime < time[j])
                                maxTime = time[j];
                        }
                        time[i] += maxTime;
                    }
                    else{
                        time[i] += time[now];
                    }
                    queue.add(i);
                }
            }
        }
        //print
        for(int i=1; i<=n; i++){
            bw.write(time[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
