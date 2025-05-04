package Backtracking;

import java.util.Scanner;

public class B_15651 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];

        dfs( 0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i+1;
            dfs(depth + 1);
        }
    }
}
