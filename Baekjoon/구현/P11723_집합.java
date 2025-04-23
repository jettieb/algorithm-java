package 구현;

import java.util.*;
import java.io.*;

public class P11723_집합 {
    public static void main(String args[]) throws IOException {
        int[] arr = new int[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        for(int j=0; j<m; j++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("all")){
                for(int i=1; i<=20; i++){
                    arr[i] = i;
                }
            }
            else if(s.equals("empty")){
                arr = new int[21];
            }
            else{
                int x = Integer.parseInt(st.nextToken());
                if(s.equals("add")) {
                    arr[x] = x;
                }
                else if(s.equals("remove"))
                    arr[x] = 0;
                else if(s.equals("check")){
                    if(arr[x] == x) bw.write("1\n");
                    else bw.write("0\n");
                }
                else if(s.equals("toggle")){
                    if(arr[x] == x) arr[x] = 0;
                    else arr[x] = x;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
