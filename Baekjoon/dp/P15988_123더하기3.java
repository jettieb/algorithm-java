package dp;

import java.io.*;

public class P15988_123더하기3 {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=1000000; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            bw.write(dp[k] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
