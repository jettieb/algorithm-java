package 그래프;

import java.util.*;
import java.io.*;

/**
 * 음수 가중치를 허용하는 벨만포드 알고리즘 사용
 * 시간을 무한대로 바꿀 수 있는 경우 (음수 무한 순환) -> -1 print
 * */
public class 벨만포드_11657 {
    static int n, m;
    static long[] distance; //정답 배열
    static Edge[] edges;    //도시 연결 정보
    public static void main(String args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge[m + 1];
        distance = new long[n +1];
        Arrays.fill(distance, Integer.MAX_VALUE);   // 최단 거리 배열 초기화
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[m] = new Edge(s,e,t);
        }

        //벨만 포드 알고리즘 실행
        distance[1] = 0;
        for(int i=1; i<n; i++){ // n보다 1개 적은 수만큼 반복
            for(int j=0; j<m; j++){
                Edge edge = edges[j];
                // 최단거리가 있을 때 업데이트
                if(distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        //음수 사이클 확인
        boolean mCycle = false;
        for(int i=0; i<m; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time){
                mCycle = true;
            }
        }
        if(!mCycle){    //음의 사이클이 없을 때
            for(int i=2; i<=n; i++){
                if(distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else{ //음의 사이클이 있을 때
            System.out.println("-1");
        }
    }

    static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
