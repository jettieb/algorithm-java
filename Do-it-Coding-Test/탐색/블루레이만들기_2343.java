package 탐색;

import java.util.*;
import java.io.*;

public class 블루레이만들기_2343 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            if(start > a[i]) start = a[i];
            end += a[i];
        }

        while(start > end){
            int mid = (start + end)/2;
            int sum = 0;
            int count = 0;
            for(int i=0; i<n; i++){
                //블루레이 길이에 다 찬 경우
                if(sum + a[i] > mid){
                    count ++;
                    sum = 0;
                }
                sum += a[i];
            }
            //탐색 다 하면 마지막에 남은 거 count 안됨!!
            if(sum != 0){
                count ++;
            }
            //count가 블루레이 개수보다 작거나 같은 경우 크기 줄여도 됨.
            if(count <= m)
                end = mid -1;
            else
                start = mid + 1;
        }
        System.out.println(start);
    }
}
