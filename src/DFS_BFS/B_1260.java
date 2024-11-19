package DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Queue;
import java.util.ArrayList;
import java.io.IOException;
public class B_1260 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[]visited;
    static int dfsResult[];
    static int bfsResult[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dfsResult = new int[N + 1];
        bfsResult = new int[N + 1];
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

        bfs(V);
        dfs(V);

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        for (int i = 1; i <= N; i++) {
            bw.write(dfsResult[i] + " ");
        }
        for (int i = 1; i <= N; i++) {
            bw.write(bfsResult[i] + " ");
        }
    }

    public static void bfs(int node) {
        
    }

    public static void dfs(int node) {

    }

}
