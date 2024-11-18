package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2606 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    static int startComputer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int computerCount = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());

        visited = new boolean[computerCount + 1];
        for (int i = 0; i <= computerCount; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= network; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            graph.get(one).add(two);
            graph.get(two).add(one);
        }

        dfs(startComputer);

        bw.write(count-1 + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int computer : graph.get(node)) {
            if (!visited[computer]) {
                dfs(computer);
            }
        }
    }
}
