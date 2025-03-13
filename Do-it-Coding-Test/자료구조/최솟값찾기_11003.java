package 자료구조;

import java.util.*;
import java.io.*;

public class 최솟값찾기_11003 {
    public static void main(String args[]) throws IOException {
        // 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        Deque<Node> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(st.nextToken());
            // 새로 들어오는 값보다 이전의 값이 더 크다면 이전의 노드를 빼준다.
            while(!deque.isEmpty() && deque.getLast().value > now)
                deque.removeLast();
            // 값 추가
            deque.addLast(new Node(i, now));
            // 현재 최솟값의 인덱스가 창문의 너비 값을 벗어나면 삭제.
            if(i - deque.getFirst().index >= l)
                deque.removeFirst();
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
