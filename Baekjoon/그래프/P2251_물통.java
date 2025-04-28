package 그래프;

import java.util.*;
import java.io.*;

public class P2251_물통 {
    /**
     * 6가지 이동 케이스를 표현하기 위한 배열! dx, dy처럼 */
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    /**
     * a,b만 가지고 visited 여부 2차원 배열로 검사하기 */
    static boolean[][] visited; //a,b의 무게만 있으면 c 자동 고정.
    static boolean[] ans;
    static int[] abc = new int[3];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            abc[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[abc[0] + 1][abc[1] + 1];
        ans = new boolean[abc[2] + 1];
        BFS(new int[] {0,0,abc[2]});
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<=abc[2]; i++){
            if(ans[i] == true)
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
    private static void BFS(int[] Water){
        visited[Water[0]][Water[1]] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(Water);
        ans[Water[2]] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<6; i++){
                int s = Sender[i];
                int r = Receiver[i];
                int[] newABC = now.clone();
                //s가 0인 경우
                if(now[s] != 0){
                    //r에 다 차지 않는 경우
                    if((abc[r] - now[r]) / now[s] == 0){
                        newABC[r] = abc[r];
                        newABC[s] = now[s] - (abc[r] - now[r]);
                    }
                    //r에 다 차는 경우
                    else{
                        newABC[r] += now[s];
                        newABC[s] = 0;
                    }
                }
                if(!visited[newABC[0]][newABC[1]]){
                    //a가 비어있는 경우 ans 배열에 넣기
                    if(newABC[0] == 0)
                        ans[newABC[2]] = true;
                    visited[newABC[0]][newABC[1]] = true;
                    queue.add(newABC);
                }
            }
        }
    }
}
