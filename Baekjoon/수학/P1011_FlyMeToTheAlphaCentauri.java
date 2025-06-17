package 수학;

import java.util.*;
import java.io.*;

public class P1011_FlyMeToTheAlphaCentauri {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            long target = -1 * (Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
            long temp = 0;
            int result = 0;
            int j = 1;
            while(true){
                if(temp + j * 2 <= target){
                    temp += j * 2;
                    result += 2;
                    j ++;
                }
                else if(temp + j <= target){
                    temp += j;
                    result ++;
                }
                else if(temp == target)
                    break;
                else {
                    result++;
                    break;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
