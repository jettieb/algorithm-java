package 탐색;

import java.io.*;
import java.util.*;

public class P2667_단지번호붙이기 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] map;
    static int n;
    static ArrayList<Integer> result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();
        for(int i=0; i<n; i++){
            String st = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.substring(j,j+1));
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    result.add(1);
                    DFS(i,j, result.size() - 1);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void DFS(int i, int j, int house){
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >=0 && y>=0 && x<n && y<n){
                if(!visited[x][y] && map[x][y] == 1){
                    DFS(x,y, house);
                    result.set(house, result.get(house) + 1);
                }
            }
        }
    }
}
