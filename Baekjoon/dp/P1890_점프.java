package dp;

import java.util.*;
import java.io.*;

public class P1890_점프 {
    static int n;
    static int[][] board;
    static long[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new long[n][n];
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(dp[n - 1][n - 1]);
    }
    private static void solve(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int jump = board[i][j];
                if(jump == 0)
                    continue;
                if(j + jump < n)
                    dp[i][j + jump] += dp[i][j];
                if(i + jump < n)
                    dp[i + jump][j] += dp[i][j];
            }
        }
    }
}
