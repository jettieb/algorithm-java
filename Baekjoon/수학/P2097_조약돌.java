package 수학;

import java.util.Scanner;

public class P2097_조약돌 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n==1 || n==2){
            System.out.println(4);
        } else{
            int a = (int) Math.sqrt(n);
            System.out.println("a = " + a);
            int b = (int) Math.ceil((double) n / a);
            System.out.println("b = " + b);
            System.out.println(2 * (a + b - 2));
        }
    }
}
