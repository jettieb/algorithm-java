package 정렬;

import java.io.*;

public class 수정렬하기2_2751 {
    public static int[]a, tmp;
    public static long result;
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n+ 1];
        tmp = new int[n + 1];   //정렬 시 임시로 사용
        for(int i=0; i<=n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(1, n);
        for(int i=1; i<=n; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void merge_sort(int start, int end){
        if(end - start < 1)
            return;
        int middle = start + (end - start) / 2;  //쪼갤 중간지점
        merge_sort(start, middle);
        merge_sort(middle + 1, end);
        //재귀함수 return 해서 나올 때 부터 병합(정렬) 시작
        for(int i=start; i<=end; i++){
            tmp[i] = a[i];  //정렬 전 임시 저장
        }
        int k = start;
        int index1 = start; // 앞 시작점
        int index2 = middle + 1;    //뒷 그룹 시작점
        //두 그룹 병합
        //양쪽 그룹의 index가 가리키는 값을 비교해 더 작은수를 선택해 배열에 저장
        while(index1 <= middle && index2 <= end){
            if(tmp[index1] > tmp[index2]){
                a[k] = tmp[index2++];
                k++;
            } else{
                a[k] = tmp[index1++];
                k++;
            }
        }
        //한쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
        while(index1 <= middle){
            a[k] = tmp[index1++];
            k++;
        }
        while(index2 <= end){
            a[k] = tmp[index2++];
            k++;
        }
    }
}
