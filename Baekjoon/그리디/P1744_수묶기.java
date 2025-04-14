package 그리디;

import java.util.*;
import java.io.*;

public class P1744_수묶기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());  //내림차순
        PriorityQueue<Integer> negativePq = new PriorityQueue<>();
        int sum = 0;
        boolean zero = false;
        for(int i=0; i<n; i++){
            int data = Integer.parseInt(br.readLine());
            if(data > 1) positivePq.add(data);
            else if(data == 1) sum += 1;
            else if(data == 0) zero = true;
            else if(data < 0) negativePq.add(data);
        }
        //양수처리
        while(positivePq.size() > 1){
            sum += positivePq.remove() * positivePq.remove();
        }
        if(positivePq.size() == 1)
            sum += positivePq.remove();
        //음수처리
        while(negativePq.size() > 1){
            sum += negativePq.remove() * negativePq.remove();
        }
        if(negativePq.size() == 1 && !zero){ //0값도 없는데 음수값 남아있는 경우
            sum += negativePq.remove();
        }
        System.out.println(sum);
    }
}
