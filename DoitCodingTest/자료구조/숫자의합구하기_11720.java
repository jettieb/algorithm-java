package 자료구조;

import java.util.Scanner;

public class 숫자의합구하기_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //입력값을 String 변수에 저장 후 char[]형 변수로 변환
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();   //String을 char 배열로 변경
        int sum = 0;
        for (int i=0; i<n; i++){
            sum += cNum[i] - '0';   //정수형으로 변환 후 sum에 더하여 누적
        }
        System.out.println(sum);
    }
}