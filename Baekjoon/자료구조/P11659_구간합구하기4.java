package 자료구조;

import java.util.*;
import java.io.*;

public class P11659_구간합구하기4 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //전체 합 배열
        long[] a = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            a[i] = a[i-1] + Integer.parseInt(st.nextToken());
        }

        //구간합
        for(int k=0; k<m; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(a[j] - a[i-1]);
        }
    }
}
