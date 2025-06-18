package 구현;

import java.io.*;
import java.util.*;

public class P27964_콰트로치즈피자 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = st.nextToken();
            if(str.endsWith("Cheese") && !arr.contains(str)){
                arr.add(str);
                result ++;
                if(result == 4) break;
            }
        }
        if(result == 4)
            System.out.println("yummy");
        else
            System.out.println("sad");
    }
}
