package 정수론;

import java.io.*;

public class 오일러피함수구현하기_11689 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        for(long i=2; i<=Math.sqrt(n); i++){    //제곱근까지만 진행
            if(n % i == 0){
                result -= result / i;
            }
            //이미 2로 진행한 경우, 4에서는 진행되지 않게 하기 위해 n값을 2로 전부 나눠버림
            while(n % i == 0){
                n /= i;
            }
        }
        //n이 마지막 소인수인 경우 소인수분해를 하고도 n이 남아있는 문제 -> 개수 count 해줘야함.
        if(n > 1)
            result -= result / n;
        System.out.println(result);
    }
}
