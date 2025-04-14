package 그리디;

import java.util.*;
import java.io.*;

public class P1541_잃어버린괄호 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");    //-를 기준으로 나누기
        int ans = 0;
        //+를 기준으로 합 계산 후 정답에 더하기
        for(int i=0; i<str.length; i++){
            String[] plus = str[i].split("\\+"); //+그 자체는 정규식으로 인식하기 때문에, 앞에 \\붙여야함
            int temp = 0;
            for(int j=0; j<plus.length; j++){
                temp += Integer.parseInt(plus[j]);
            }
            if(i==0) ans += temp;
            else ans -= temp;
        }
        System.out.println(ans);
    }
}
