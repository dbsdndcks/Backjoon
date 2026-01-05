package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15651R {

    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();  // 추가

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        arr = new int[M];

        dfs(0);

        System.out.print(sb);  // 한 번에 출력

    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');  // StringBuilder에 저장
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }

    }
}
