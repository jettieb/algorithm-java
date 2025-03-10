package 자료구조;

import java.io.*;
import java.util.*;

public class 구간합구하기2_11660 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력 받아온 후 저장
        int a[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 구간 합 구하기
        int d[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                d[i][j] = d[i][j - 1] + d[i - 1][j] - d[i - 1][j - 1] + a[i][j];
            }
        }

        // 결과 print
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = d[x2][y2] - d[x2][y1-1] - d[x1-1][y2] + d[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
