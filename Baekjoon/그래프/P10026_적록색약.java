package 그래프;

import java.util.*;
import java.io.*;

public class P10026_적록색약 {
    static int n;
    static boolean[][] visited;
    static char[][] art;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        art = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            art[i] = br.readLine().toCharArray();
        }
        //적록색약이 아닌 경우
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    BFS(i,j);
                    result ++;
                }
            }
        }
        System.out.println(result);
        //적록색약인 경우
        result = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(art[i][j] == 'G')
                    art[i][j] = 'R';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    BFS(i,j);
                    result ++;
                }
            }
        }
        System.out.println(result);
    }
    private static void BFS(int i, int j){
        Queue<int []> queue = new LinkedList();
        visited[i][j] = true;
        queue.add(new int[] {i,j});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            char nowColor = art[now[0]][now[1]];
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && x<n && y>=0 && y<n){
                    if(!visited[x][y] && art[x][y] == nowColor){
                        visited[x][y] = true;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
