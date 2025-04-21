package 정수론;

import java.util.*;

public class P1456_거의소수 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        //루트b까지의 소수 구한 후에 소수 개수 return 하면 됨.
        boolean[] arr = new boolean[(int) Math.sqrt(b) + 1];    //false인 경우 소수
        //배수 거르기
        for(int i=2; i<=Math.sqrt(arr.length); i++){
            if(arr[i] == false) {
                for(int j=i + i; j < arr.length; j += i){
                    arr[j] = true;
                }
            }
        }
        //소수 개수 반환
        int cnt = 0;
        for(int i=2; i<arr.length; i++){
            if(arr[i] == false){
                long temp = (long)i * i;
                while(temp <= b){
                    if(temp >= a){
                        cnt ++;
                    }
                    if(temp > b / i) break;
                    temp *= i;
                }
            }
        }
        System.out.println(cnt);
    }
}
