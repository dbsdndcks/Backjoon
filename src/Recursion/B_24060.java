package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_24060 {
    static int count = 0;

    private static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; //배열의 중앙구하기
            merge_sort(arr, left, mid); //전반부 정렬
            merge_sort(arr, mid + 1, right); //후반부 정렬
            merge(arr, left, mid, right); //병합작업
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = right;

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
            arr[index] = temp[index];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr,0,arr.length-1);
        if (count < K) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}