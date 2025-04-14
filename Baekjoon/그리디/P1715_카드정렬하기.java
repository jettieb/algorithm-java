package 그리디;

import java.util.*;
import java.io.*;

public class P1715_카드정렬하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        while(pq.size() != 1){
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
