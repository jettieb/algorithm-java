package 그리디;

import java.util.*;
import java.io.*;

public class 회의실배정_1931 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] a = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        //끝나는 순서로 정렬
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                if(start[1] == end[1])
                    return start[0] - start[0]; //0 인덱스값을 기준으로 오름차순
                else
                    return start[1] - end[1];
            }
        });
        int cnt = 0;
        int endTime = -1;
        for(int i=0; i<n; i++){
            if(a[i][0] >= endTime){
                cnt++;
                endTime = a[i][1];
            }
        }
        System.out.println(cnt);
    }
}
