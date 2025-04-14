package 정수론;

import java.util.*;

public class 소수구하기_1929 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] a = new boolean[n + 1];   //소수면 false
        //n의 제곱근까지만 탐색해도 됨. (배수를 지워야 하기 때문에 2부터 시작)
        for(int i=2; i<=Math.sqrt(n); i++){
            if(a[i] == true) continue;
            //배수 지우기
            for(int j= 2 * i; j<=n; j = j + i){
                a[j] = true;
            }
        }
        //소수만 출력
        for(int i=m; i<=n; i++){
            if(a[i] == false){
                System.out.println(i);
            }
        }
    }
}
