package 정렬;

import java.util.Scanner;

public class 소트인사이드_1427 {
    // 내림차순 정렬
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            a[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i=0; i<str.length()-1; i++){
            int max = i;    // 최대 인덱스
            for(int j=i+1; j<str.length(); j++){
                if(a[max] < a[j])
                    max = j;
            }
            if(a[i] < a[max]){
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
    }
}
