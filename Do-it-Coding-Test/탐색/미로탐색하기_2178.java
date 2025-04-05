package 탐색;

import java.util.*;
import java.io.*;

public class 미로탐색하기_2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] a;   //미로
    static int n,m; //도착지점
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String string = br.readLine();
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(string.substring(j, j+1));
            }
        }
        BFS(0,0);   //(0,0)부터 시작
        System.out.println(a[n-1][m-1]);
    }

    public static void BFS(int i, int j){
        Queue<int []> queue = new LinkedList<>();   //좌표로 저장하기 위해 컬렉션 int []
        queue.add(new int[] {i,j}); //(i,j) 좌표를 배열로 저장
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int depth = a[now[0]][now[1]];
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >=0 && y>=0 && x<n && y<m){
                    if(a[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        a[x][y] = depth + 1;    //값 업데이트
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}