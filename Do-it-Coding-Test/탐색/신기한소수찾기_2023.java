package 탐색;

import java.io.*;
import java.util.*;

public class 신기한소수찾기_2023 {
    static int n;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu){
        //DFS 마치고 n번째 자리수 도달한 경우
        if(jarisu == n){
            if(isPrime(number))
                System.out.println(number);
            return;
        }
        //뒤의 자리수가 짝수인 경우는 2로 나누어짐.
        for(int i=1; i<10; i = i+2){
            if(isPrime(number * 10 + i))
                DFS(number * 10 + i, jarisu + 1);
        }
    }

    static boolean isPrime(int num){
        for(int i=2; i <= num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;    //소수면 true 반환
    }
}
