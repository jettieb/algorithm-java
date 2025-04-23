package 정수론;

import java.util.*;
import java.io.*;

public class P1033_칵테일 {
    static ArrayList<cNode>[] arr;
    static boolean[] visited;
    static int[] result;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<cNode>();
        }
        visited = new boolean[n];
        result = new int[n];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            arr[a].add(new cNode(b,p,q));
            arr[b].add(new cNode(a,q,p));
        }
        DFS(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    private static int GCD(int p, int q){
        if(q == 0)
            return p;
        else{
            if(p < q){
                int temp = q;
                q = p;
                p = temp;
            }
            return GCD(q, p % q);
        }
    }

    private static void DFS(int node){
        visited[node] = true;
        for(cNode i: arr[node]){
            if(!visited[i.b]){
                //node의 q,p의 최대공약수로 나누기
                int maxGcd = GCD(i.p, i.q);
                int p = i.p / maxGcd;
                int q = i.q / maxGcd;
                if(result[node] == 0) result[node] = 1;
                int a = result[node];
                //기존 a의 값과 p의 값의 최소공배수
                int minGcd = a * p / GCD(a,p);
                int multi = minGcd / a;
                for(int j=0; j<n; j++){
                    result[j] *= multi;
                }
                result[i.b] = minGcd / p * q;
                DFS(i.b);
            }
        }
    }
}

class cNode {
    int b;  //연결지점
    int p;
    int q;
    public cNode(int b, int p, int q){
        this.b = b;
        this.p = p;
        this.q = q;
    }
}
