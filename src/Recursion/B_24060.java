package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24060 {
    static int K,count = 0;
    static int result = -1;
    static int temp[],arr[];


    private static void merge_sort(int[] arr, int left, int right) {
        if(count > K) return;
        if (left < right) {
            int mid = (left + right) / 2; //배열의 중앙구하기s
            merge_sort(arr, left, mid); //전반부 정렬
            merge_sort(arr, mid + 1, right); //후반부 정렬
            merge(arr, left, mid, right); //병합작업
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int index = left; index < k; index++) {
            ++count;
            arr[index] = temp[index];
            if (count == K) {
                result = temp[index];
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temp = new int[A]; //임시 배열
        arr = new int[A]; //정렬 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr,0,arr.length-1);
        System.out.println(result);

    }
}
