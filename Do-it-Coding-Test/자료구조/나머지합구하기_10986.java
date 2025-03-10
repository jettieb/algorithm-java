package 자료구조;

import java.io.*;
import java.util.*;

public class 나머지합구하기_10986 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long s[] = new long[n];
        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        // 합 배열의 모든 값에 % 연산 수행 후 같은 수의 개수 카운트
        long c[] = new long[m];
        long ans = 0;
        for(int i=0; i<n; i++){
            int remainder = (int) (s[i] % m);
            if (remainder == 0) ans ++;  //0부터 시작 할 경우 s%m이 0이면 바로 count 되기 때문.
            c[remainder] ++;
        }
        // 경우의 수 체크
        for(int i=0; i<m; i++){
            if(c[i] > 1){
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수
                ans += (c[i] * (c[i] - 1) / 2);
            }
        }
        System.out.println(ans);
    }
}
