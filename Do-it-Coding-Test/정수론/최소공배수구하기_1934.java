package 정수론;

import java.io.*;
import java.util.*;

public class 최소공배수구하기_1934 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a * b / GCD(a,b));
        }
    }

    private static int GCD(int a, int b){
        if(b==0)
            return a;  //나머지가 0일 때 까지 진행
        else
            return GCD(b, a % b);
    }
}
