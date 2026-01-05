package Backtracking;

import java.io.*;
import java.util.*;

public class B_9095 {

    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            count = 0;
            dfs(0, num);
            System.out.println(count);
        }

    }

    private static void dfs(int sum ,int target) {
        if (sum == target) {
            count++;
            return;
        }

        if (sum > target) {
            return;
        }

        dfs(sum + 1, target);
        dfs(sum + 2, target);
        dfs(sum + 3, target);
    }
}
