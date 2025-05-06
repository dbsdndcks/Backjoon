package Backtracking;

import java.util.Scanner;

public class B_15652 {

    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(" ");

            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            //System.out.printf("%d < arr[%d] -1 = %d\n", i,depth, arr[depth] -1);
            if (depth != 0 && i < arr[depth-1] - 1) {
                continue;
            }
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
