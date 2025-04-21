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
                /*
                * i * i를 한 경우 int로 계산 후에 long으로 변환하기 때문에, 문제가 생길 수 있음!
                * 따라서 long으로 먼저 형변환 후 계산.
                * */
                long temp = (long)i * i;
                while(temp <= b){
                    if(temp >= a){
                        cnt ++;
                    }
                    /*
                    * i의 최댓값이 10^7이기 때문에, temp *= i를 했을 때 오버플로우가 나서
                    * 이상한 숫자로.. while문에 들어가는 경우가 있을 수 있음.
                    * 이를 방지하기 위해 오버플로우 전에 if 문으로 정지시키기.
                    * */
                    if(temp > b / i) break;
                    temp *= i;
                }
            }
        }
        System.out.println(cnt);
    }
}
