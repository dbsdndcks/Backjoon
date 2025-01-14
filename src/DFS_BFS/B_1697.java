package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697 {

    static int[] visited = new int[100001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);

    }

    private static int bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int nowNum = 0;
        visited[node] = 1;

        while (!q.isEmpty()) {
            nowNum = q.poll();

            if (nowNum == K) {
                return visited[nowNum]-1;
            }
            if (nowNum - 1 >= 0 && visited[nowNum-1] == 0) {
                visited[nowNum-1] = visited[nowNum] + 1;
                q.offer(nowNum - 1);
            }
            if (nowNum + 1 <= 100000 && visited[nowNum + 1] == 0) {
                visited[nowNum+1] = visited[nowNum] + 1;
                q.offer(nowNum + 1);
            }
            if (nowNum * 2 <= 100000 && visited[nowNum * 2] == 0) {
                visited[nowNum * 2] = visited[nowNum] + 1;
                q.offer(nowNum * 2);
            }
        }
        return -1;
    }
}
