package 탐색;

import java.util.*;
import java.io.*;

public class P2805_나무자르기 {
    static long[] tree;
    static int n,m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            tree[i] = Long.parseLong(st.nextToken());
        }
        //이분탐색으로 진행!!
        Arrays.sort(tree);
        long min = 0;
        long max = tree[n - 1];
        long mid = 0;
        while(min <= max){
            mid = (min + max) / 2;
            long cut = remain(mid);
            if(cut == (long) m){
                max = mid;
                break;
            }
            else if(cut > (long) m)
                min = mid + 1;
            else
                max = mid - 1;
        }
        System.out.println(max);
    }
    private static long remain(long mid){
        long cut = 0;
        for(int i=0; i<n; i++){
            if(tree[i] - mid > 0)
                cut += tree[i] - mid;
        }
        return cut;
    }
}
