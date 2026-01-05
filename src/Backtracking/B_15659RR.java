package Backtracking;

import java.io.*;
import java.util.*;

public class B_15659RR {

    static boolean[] visited;
    static int[] arr;
    static int N; // 1부터 N까지의 자연수
    static int M; // 뽑을 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
