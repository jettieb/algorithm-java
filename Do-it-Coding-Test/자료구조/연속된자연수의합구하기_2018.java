package 자료구조;

import java.util.*;

public class 연속된자연수의합구하기_2018 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1; // n이 15인 경우 15만 뽑는 경우의 수 위해 미리 초기화
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;
        while(end_idx != n){
            if(sum == n){
                count ++;
                end_idx++;
                sum += end_idx;
            } else if(sum > n){
                sum -= start_idx;
                start_idx ++;
            } else{
                end_idx ++;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }
}
