package 정렬;

import java.io.*;
import java.util.*;

public class K번째수_11004 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a, 0, n-1, k - 1);
        System.out.println(a[k - 1]);
    }

    public static void quickSort(int[] a, int start, int end, int k){
        if(start < end){
            int pivot = partition(a,start, end);
            if(pivot == k)
                return;
            else if(pivot > k)
                //왼쪽부분만 실행
                quickSort(a, start, pivot-1, k);
            else
                //오른쪽만 실행
                quickSort(a, pivot + 1, end, k);
        }
    }

    //배열 재배치 후 pivot 위치 return
    public static int partition(int[] a, int start, int end){
        if(start + 1 == end){
            if(a[start] > a[end])
                swap(a, start, end);
            return end;
        }
        int middle = (start + end) /2;
        int pivot = a[middle];
        swap(a, start, middle);
        int low = start + 1;
        int high = end;
        while(low <= high){
            //low 오른쪽 이동
            while(a[low] < pivot && low <= end)
                low ++;
            //high 왼쪽 이동
            while(a[high] > pivot && high >= start)
                high --;
            //low와 high 값 swap
            if(low <= high)
                swap(a, low++, high--);
        }
        swap(a, start, high);    //pivot 다시 중앙으로 위치
        return high;    //pivot 위치
    }

    public static void swap(int[]a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
