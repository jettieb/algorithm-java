package 자료구조;

import java.util.*;
import java.io.*;

public class 주몽_1940 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());    // 재료 개수
        int m = Integer.parseInt(bf.readLine());    // 만들어야하는 갑옷 합번호
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int count = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
            if(a[i] + a[j] > m) j--;
            else if(a[j] + a[j] < m) i++;
            else{
                count ++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
