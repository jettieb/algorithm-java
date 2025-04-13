package 그리디;

import java.io.*;
import java.util.*;

public class 동전개수의최솟값구하기_11047 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine()); //이미 오름차순으로 정렬되어있음.
        }
        int count = 0;  //필요한 동전 개수
        while(k!=0){
            n--;
            if(k >= a[n]){
                count += k / a[n];
                k = k % a[n];
            }
        }
        System.out.println(count);
    }
}
