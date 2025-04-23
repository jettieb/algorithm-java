package 탐색;

import java.io.*;
import java.util.*;

public class P1012_유기농배추 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int a=0; a<t; a++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            //배추 흰 지렁이 개수 체크
            int jirung = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] != 0 && !visited[i][j]){
                        DFS(i,j);
                        jirung ++;
                    }
                }
            }
            System.out.println(jirung);
        }
    }

    private static void DFS(int i, int j){
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=0 && x<m && y>=0 && y<n){
                if(!visited[x][y] && arr[x][y] != 0){
                    DFS(x,y);
                }
            }
        }
    }
}
