package 정렬;

import java.util.*;

public class 수정렬하기_2750 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        //정렬
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
