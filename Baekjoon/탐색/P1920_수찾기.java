package 탐색;

import java.io.*;
import java.util.*;

public class P1920_수찾기 {
    static int[] a;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());
            Find(target, 0, n - 1);   //수 있는지 확인
        }
    }

    static void Find(int target, int start, int end){
        if(start > end){
            System.out.println("0");
            return;
        }
        int mid = (start + end)/2;
        if(a[mid] == target){
            System.out.println("1");
        }
        else if(a[mid] > target)
            Find(target, start, mid - 1);
        else
            Find(target, mid + 1, end);
    }
}
