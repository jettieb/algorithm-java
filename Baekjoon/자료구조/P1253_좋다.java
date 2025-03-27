package 자료구조;

import java.io.*;
import java.util.*;

public class P1253_좋다 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] a = new Long[n];
        for(int i=0; i<n; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);

        int result = 0;
        for(int k=0; k<n; k++){
            int i=0;
            int j=n-1;
            while(i != j){
                if(a[i] + a[j] == a[k]){
                    //i와 j가 k와 달라야함!!
                    if(i!=k && j!=k){
                        result ++;
                        break;
                    }
                    else if(i==k) i++;
                    else j--;
                }
                else if(a[i] + a[j] > a[k])
                    j--;
                else
                    i++;
            }
        }
        System.out.println(result);
    }
}
