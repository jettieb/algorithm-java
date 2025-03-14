package 자료구조;

import java.util.*;

public class 스택수열_1874 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int [n];
        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();   // 정답 저장용
        int num = 1;    // 스택에 넣을 수
        boolean result = true;
        for(int i=0; i<n; i++){
            int find = a[i];
            // 찾아야하는 수가 num보다 큰 경우 -> push
            if (find >= num){
                while(find >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            // 찾아야하는 수가 num보다 작은 경우 -> pop (한 번만 진행해야함. 여러 번 pop 불가능. 버려지는 수가 생겨버림.)
            else{
                int k = stack.pop();
                // 스택 가장 위의 수가 만들어야 하는 수열의 수 보다 크면 불가능.
                if(k > find){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else
                    bf.append("-\n");
            }
        }
        if(result)
            System.out.println(bf.toString());
    }
}
