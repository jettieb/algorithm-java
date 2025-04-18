package 자료구조;

import java.util.*;

public class 절댓값힙_11286 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 > o2 ? 1: -1;
            else
                return first_abs - second_abs;  // 큰 값이 뒤로가도록
        });
        for(int i=0; i<n; i++){
            int request = sc.nextInt();
            if(request == 0){
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }
            else
                queue.add(request);
        }
    }
}
