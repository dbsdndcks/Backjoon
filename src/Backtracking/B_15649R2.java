package Backtracking;

import java.util.Scanner;

public class B_15649R2 {

    static int N,M;
    static int[]arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        N = Integer.parseInt(s.split(" ")[0]);
        M = Integer.parseInt(s.split(" ")[1]);
        arr = new int[M];
        visit = new boolean[N];

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
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
