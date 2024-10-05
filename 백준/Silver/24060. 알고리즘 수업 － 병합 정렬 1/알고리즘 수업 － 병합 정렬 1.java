import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int K = 0;
    static int result = -1; // 초기값을 -1로 설정
    static boolean found = false;

    private static void merge_sort(int[] arr, int left, int right) {
        if (left < right && !found) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right && !found) {
            if (arr[i] <= arr[j]) {
                temp[k - left] = arr[i++];
            } else {
                temp[k - left] = arr[j++];
            }
            if (++count == K) {
                result = temp[k - left];
                found = true;
                return; // 바로 종료
            }
            k++;
        }

        while (i <= mid && !found) {
            temp[k - left] = arr[i++];
            if (++count == K) {
                result = temp[k - left];
                found = true;
                return; // 바로 종료
            }
            k++;
        }

        while (j <= right && !found) {
            temp[k - left] = arr[j++];
            if (++count == K) {
                result = temp[k - left];
                found = true;
                return; // 바로 종료
            }
            k++;
        }

        for (int l = left; l <= right; l++) {
            arr[l] = temp[l - left];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);

        System.out.println(result == -1 ? -1 : result);
    }
}