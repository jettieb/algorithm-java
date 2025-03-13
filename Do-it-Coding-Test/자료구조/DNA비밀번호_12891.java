package 자료구조;

import java.util.*;
import java.io.*;

public class DNA비밀번호_12891 {
    static int checkArr[];  //비밀번호 체크 배열 (문제 제공)
    static int myArr[]; //현재 상태 개수 저장용 배열
    static int checkSecret; // 맞는 개수 4개인지 확인용

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int answer = 0;
        char a[] = new char[s];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        a = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) checkSecret++;
        }
        //초기 슬라이딩 처리
        for(int i=0; i<p; i++){
            Add(a[i]);
        }
        if(checkSecret == 4) answer ++;

        //슬라이딩 처리
        for(int i=p; i<s; i++){
            int j = i - p;
            Remove(a[j]);
            Add(a[i]);
            if(checkSecret == 4) answer ++;
        }
        System.out.println(answer);
        bf.close();
    }

    //새로 들어온 문자열 처리
    private static void Add(char c){
        switch (c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    //나가는 문자열 처리
    private static void Remove(char c){
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
