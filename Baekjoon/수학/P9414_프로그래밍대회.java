package 수학;

import java.util.*;
import java.io.*;

public class P9414_프로그래밍대회 {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            while(true){
                int s = Integer.parseInt(br.readLine());
                if(s == 0)
                    break;
                else
                    arr.add(s);
            }
            Collections.sort(arr, Collections.reverseOrder());
            long money = 0;
            int t = 1;
            boolean expens = false;
            for(int m: arr){
                if(money + Math.pow(m, t) <= 5000000){
                    money += 2 * Math.pow(m,t);
                    t++;
                }
                else
                    expens = true;
            }
            if(expens)
                bw.write("Too expensive\n");
            else
                bw.write(money + "\n");
        }
        bw.flush();
        bw.close();
    }
}
