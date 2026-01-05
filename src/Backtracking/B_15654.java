package Backtracking;

import java.io.*;
import java.util.*;

public class B_15654 {

    static int[] numbers;        // 입력받은 N개의 숫자
    static int[] result;         // 선택한 M개의 수열
    static boolean[] visited;    // 숫자 사용 여부
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);  // 사전순 출력을 위한 정렬

        dfs(0);

        System.out.print(sb);  // 한 번에 출력
    }

    private static void dfs(int depth) {
        // 종료 조건: M개를 모두 선택함
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // N개의 숫자 중에서 선택 (순열)
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;           // 선택
                result[depth] = numbers[i];  // 저장
                dfs(depth + 1);              // 다음 depth
                visited[i] = false;          // 백트래킹
            }
        }
    }

}
