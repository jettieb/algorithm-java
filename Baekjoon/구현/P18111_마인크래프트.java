package 구현;

import java.util.*;
import java.io.*;

public class P18111_마인크래프트 {
    static int n,m,b;
    static int[][] ground;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        ground = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = -1;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, ground[i][j]);
                max = Math.max(max, ground[i][j]);
            }
        }
        solve(min, max);
    }
    private static void solve(int min, int max){
        int groundMax = -1;
        int minTime = Integer.MAX_VALUE;
        //min부터 max까지 돌아가면서 나올 수 있는 최대땅, 시간 저장
        for(int t=min; t<=max; t++){
            int minus = 0;  //땅 제거 수
            int plus = 0;   //땅 추가 수
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(ground[i][j] > t) minus += ground[i][j] - t;
                    else plus += t - ground[i][j];
                }
            }
            //가능한 경우라면
            if(plus - b <= minus){
                int time = plus + minus * 2;
                if(time <= minTime){
                    minTime = time;
                    groundMax = t;
                }
            }
        }
        System.out.println(minTime + " " + groundMax);
    }
}
