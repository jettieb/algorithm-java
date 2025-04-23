package 정수론;

import java.io.*;
import java.util.*;

public class 최대공약수1_1850 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();
        //a가 더 작은 경우 swap
        if(a < b){
            long temp = a;
            a = b;
            b = temp;
        }
        long result = GCD(a,b);
        while(result > 0){
            bw.write("1");
            result --;
        }
        bw.flush();
        bw.close();
    }

    private static long GCD(long a, long b){
        if(b == 0)
            return a;
        else
            return GCD(b, a % b);
    }
}
