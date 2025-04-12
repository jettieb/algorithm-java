package 탐색;

import java.util.Scanner;

public class 배열에서K번째수찾기_1300 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long min = 1;
        long max = k;   //10^10까지 갈 수 있기 때문에, long으로 지정.
        long mid = 0;
        while(min <= max){
            mid = (min + max) / 2;
            long cnt = 0;   //mid가 몇 번째 수인지 체크.
            for(int i=1; i<=n; i++){
                cnt += Math.min(n, mid/i);
            }
            if(cnt < k){
                min = mid + 1;
            } else{
                max = mid - 1;
            }
        }
        System.out.println(min);
    }
}
