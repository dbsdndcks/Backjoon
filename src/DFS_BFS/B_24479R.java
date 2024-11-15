package DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
public class B_24479R {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[]  visited;
    static int[] result;
    static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int node) {
        visited[node] = true;
        result[node] = order++;
        for (int neighborNode : graph.get(node)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode);
            }
        }
    }
}
