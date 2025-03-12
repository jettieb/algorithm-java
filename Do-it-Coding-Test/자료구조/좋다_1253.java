package 자료구조;

import java.io.*;
import java.util.*;

public class 좋다_1253 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);

        // a배열 양 끝에 i,j 두고 조건 맞춰서 answer 증가
        for(int q=0; q<n; q++){
            long find = a[q];
            int i = 0;
            int j = n-1;
            while(i<j){
                if(a[i] + a[j] > find) j--;
                else if(a[i] + a[j] < find) i++;
                else{
                    //i와 j가 q와 달라야함 주의!
                    if(i!=q && j!=q){
                        result ++;
                        break;
                    }
                    else if(i == q) i++;
                    else j--;
                }
            }
        }
        System.out.println(result);
    }
}
