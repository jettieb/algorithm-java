package 탐색;

import java.util.*;
import java.io.*;

public class P2178_미로탐색 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static boolean[][] visited;
    static int n,m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                arr[i][j] = chars[j] - '0'; //char을 int로 바꾸기
            }
        }
        BFS(0,0);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void BFS(int i, int j){
        visited[i][j] = true;
        Queue<int []> queue = new LinkedList();
        queue.add(new int[] {i, j});    //x,y 좌표 저장
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && x<n && y>=0 && y<m){
                    if(!visited[x][y] && arr[x][y] != 0){
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
