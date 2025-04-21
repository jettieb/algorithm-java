package 정수론;

import java.util.*;

public class 제곱이아닌수찾기_1016 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] arr = new boolean[(int) (max - min + 1)];
        for(long i=2; i<Math.sqrt(max) + 1; i++){
            long pow = i * i;   //제곱수
            long start_idx = ((min - 1) / pow + 1) * pow - min;  //이게 음수가 될 수 있음?
            for(long j=start_idx; j<(long)arr.length; j += pow){
                int idx = (int) j;
                arr[idx] = true;
            }
        }
        //갯수 세기
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(!arr[i]) cnt ++;
        }
        System.out.println(cnt);
    }
}
