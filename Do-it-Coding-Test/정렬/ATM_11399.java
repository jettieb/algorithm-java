package 정렬;

import java.util.*;

public class ATM_11399 {
    //삽입정렬 오름차순으로 풀기
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] s = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        //삽입 정렬
        for(int i=1; i<n; i++){
            int insert_point = i;
            int insert_value = a[i];
            // 정렬된 것들 중 맨 뒤에서부터 확인
            for(int j=i-1; j>=0; j--){
               if(a[j] > a[i]){
                   insert_point = j + 1;
                   break;
               }
               if(j==0)
                   insert_point =0;
            }

            //insert_point를 기준으로 전부 한 칸씩 이동
            for(int j=i; j>insert_point; j--){
                a[j] = a[j-1];
            }
            a[insert_point] = insert_value;
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += a[i] * (i+1);
        }
        System.out.println(sum);
    }
}
