package 자료구조;

import java.util.*;

public class P2164_카드2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            queue.remove();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
