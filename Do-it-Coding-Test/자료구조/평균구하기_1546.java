package 자료구조;

import java.util.Scanner;

public class 평균구하기_1546 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;
        for(int i=0; i<n; i++){
            if(a[i] > max) max = a[i];
            sum += a[i];
        }

        //정답 식 한번에 계산
        System.out.println(sum * 100.0 / max / n);
    }
}
