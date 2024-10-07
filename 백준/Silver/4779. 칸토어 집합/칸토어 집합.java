import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static String[]arr;
    static int left;
    static int right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int N;
        int total; //3 의 N제곱
        String str; //입력받을 숫자의 문자형

        while ((str = br.readLine()) != null){
            sb = new StringBuilder();
            N = Integer.parseInt(str);
            //N이 0이면 하나 출력
            if (N == 0) {
                System.out.println("-");
                continue;
            }

            total = (int) Math.pow(3,N);
            arr = new String[total];
            for (int i = 0; i < total; i++) {
                arr[i] = "-";
            }
            left = 0;
            right = arr.length-1;
            recursion(arr,left,right);
            for (int i = 0; i < total; i++) {
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }

    private static void recursion(String[] arr,int left, int right) {
        int length = right - left + 1;

        // 길이가 1이면 더 이상 재귀할 필요 없음
        if (length == 1) {
            return;
        }

        // 3등분하여 가운데 부분을 공백으로 만듦
        int third = length / 3;
        for (int i = left + third; i < left + 2 * third; i++) {
            arr[i] = " ";
        }

        // 왼쪽과 오른쪽 부분에 대해 재귀 호출
        recursion(arr, left, left + third - 1);  // 왼쪽
        recursion(arr, left + 2 * third, right); // 오른쪽
    }

}