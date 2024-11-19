package DFS_BFS;
import java.io.*;
import java.util.*;

public class B_1260 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static ArrayList<Integer> dfsResult = new ArrayList<>();
    static ArrayList<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!graph.get(i).isEmpty()) {
                Collections.sort(graph.get(i));
            }
        }

        // DFS 탐색
        dfs(V);

        // BFS 탐색
        bfs(V);

        // DFS 결과 출력
        for (int node : dfsResult) {
            bw.write(node + " ");
        }
        bw.newLine();

        // BFS 결과 출력
        for (int node : bfsResult) {
            bw.write(node + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node) {
        dfsVisited[node] = true;
        dfsResult.add(node);

        for (int neighbor : graph.get(node)) {
            if (!dfsVisited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.add(node);

            for (int neighbor : graph.get(node)) {
                if (!bfsVisited[neighbor]) {
                    queue.add(neighbor);
                    bfsVisited[neighbor] = true;
                }
            }
        }
    }
}
