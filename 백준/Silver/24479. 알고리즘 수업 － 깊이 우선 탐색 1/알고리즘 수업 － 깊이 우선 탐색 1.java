import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int order = 1; // 방문 순서를 기록하기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 리스트, 배열 초기화
        visited = new boolean[N + 1];
        result = new int[N + 1];

        // 그래프 초기화 (1번 인덱스부터 N번 인덱스까지 사용)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v); // u에서 v로 가는 간선 추가
            graph.get(v).add(u); // v에서 u로 가는 간선 추가
        }

        // 각 정점 인접 리스트 오름차순 정렬
        for (int i = 1; i <= N; i++) { // graph.size() 대신 N 사용
            Collections.sort(graph.get(i));
        }

        // DFS 시작
        dfs(R);

        // 결과 출력
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