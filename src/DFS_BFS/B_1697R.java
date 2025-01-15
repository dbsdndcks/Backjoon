package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697R {

    static int[] arr = new int[100001];

    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.println(result);
    }

    private static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        arr[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                return arr[now]-1;
            }
            if (now - 1 >= 0 && arr[now - 1] == 0) {
                arr[now - 1] = arr[now] + 1;
                q.offer(now - 1);
            }
            if (now + 1 <= 100000 && arr[now + 1] == 0) {
                arr[now + 1] = arr[now] + 1;
                q.offer(now + 1);
            }
            if (now * 2 <= 100000 && arr[now * 2] == 0) {
                arr[now * 2] = arr[now] + 1;
                q.offer(now * 2);
            }
        }
        return -1;
    }
}
