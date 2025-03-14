package 자료구조;

import java.util.*;
import java.io.*;

public class 오큰수_17298 {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[n];    // 정답 저장 배열
        int idx = 0;    // stack에 들어간 idx
        for(int i=0; i<n; i++){
            // stack에 새로 들어갈 수가 stack top의 수 보다 작은 경우 ans 배열에 저장
            while(!stack.isEmpty() && a[stack.peek()] < a[i])
                ans[stack.pop()] = a[i];
            // stack이 비어있거나 새로 들어갈 수가 top의 수보다 작은 경우 push
            stack.push(i);
        }

        //ans이 비어있는 경우 -1로 print
        for(int i=0; i<n; i++){
            if(ans[i] != 0)
                bw.write(ans[i] + " ");
            else
                bw.write("-1 ");
        }
        bw.flush();
    }
}
