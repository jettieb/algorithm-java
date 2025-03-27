package 자료구조;

import java.util.*;
import java.io.*;

public class P10986_나머지합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        for(int i=1; i<=n; i++){
            a[i] = (a[i-1] + Integer.parseInt(st.nextToken())) % m;
        }
        //같은 개수 카운트
        long[] count = new long[m];
        /*
        * 우와... count는 long인데, result는 long형이 아니여서 틀렸던 것이었음.
        * 형 변환 주의!
        * */
        long result = 0;
        for(int i=0; i<=n; i++){
            count[a[i]]++;
        }
        //결과
        for(int i=0; i<m; i++){
            result += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(result);
    }
}
