package 자료구조;

import java.io.*;
import java.util.*;

public class 구간합구하기_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());   // 한 줄 받아온 후 쪼갬.
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        // 전체 합 배열
        long[] s = new long[n + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++){
            s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 구간 합 구하기
        for(int q=0; q<m; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i-1]);
        }
    }
}
