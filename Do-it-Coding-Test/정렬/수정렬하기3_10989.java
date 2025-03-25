package 정렬;

import java.util.*;
import java.io.*;

public class 수정렬하기3_10989 {
    public static int[] a;
    public static long result;
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(a, 5);
        for(int i=0; i<a.length; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void Radix_Sort(int[]a, int max_size){    //max_size는 최대 자릿수
        int[] output = new int[a.length];
        int jarisu = 1;
        int count = 0;
        while(count != max_size){
            int [] bucket = new int[10];
            // 자리수별 원소 개수 저장
            for(int i=0; i<a.length; i++){
                bucket[a[i] / jarisu % 10] ++;
            }
            //구간 합
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }
            //output 배열에 정렬
            for(int i=a.length - 1; i>=0; i--){
                output[bucket[a[i] / jarisu % 10] - 1] = a[i];
                bucket[a[i] / jarisu % 10] --;
            }
            //output 배열 a 배열로 옮기기
            for(int i=0; i<a.length; i++){
                a[i] = output[i];
            }
            jarisu *= 10;
            count ++;
        }
    }
}
