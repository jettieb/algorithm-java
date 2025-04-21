package 정수론;

import java.util.*;

public class P1747_소수and팰린드롬 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //소수구하기 - 최댓값의 1000000의 정답인 1003002까지
        boolean[] prime = new boolean[1003002];
        for(int i=2; i<Math.sqrt(prime.length) + 1; i++){
            if(prime[i] == false){
                for(int j=i+i; j< prime.length; j+=i){
                    prime[j] = true;
                }
            }
        }
        //n이상의 팰린드롬 찾기 - 1인 경우 예외처리!
        int now = n;
        if(n==1) now ++;
        while(true){
            if(prime[now] == false){
                if(isPalindrome(now)){
                    System.out.println(now);
                    break;
                }
            }
            now ++;
        }
    }

    //팰린드롬 유무 확인 함수
    private static boolean isPalindrome(int target){
        char[] arr = String.valueOf(target).toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            if(arr[start] != arr[end])
                return false;
            start ++;
            end --;
        }
        return true;
    }
}
