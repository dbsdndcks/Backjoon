package DFS_BFS;

import java.io.*;
import java.util.*;

public class B_1182 {

    static int count = 0;
    static int[] arr;
    static int N;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(count);
    }

    private static void dfs(int index, int sum, int cnt) {
        if (index == N) {
            if (sum == S && cnt > 0) {
                count++;
            }
            return;
        }
        int currentSum = sum + arr[index];
        dfs(index + 1, currentSum, cnt+1);
        dfs(index+1, sum, cnt);
    }
}
