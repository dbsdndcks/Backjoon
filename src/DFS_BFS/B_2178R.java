package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178R {

    static boolean[][] visited;
    static int[][] miro;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = { 0,0,-1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        visited = new boolean[N][M];
        miro = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                miro[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(0, 0);
        System.out.println(miro[N-1][M-1]);
    }
    static void bfs(int x, int y) {
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nowX = now[0] + dirX[i];
                int nowY = now[1] + dirY[i];

                if (nowX < 0 || nowY < 0 || nowX >= N || nowY >= M) {
                    continue;
                }
                if (visited[nowX][nowY] || miro[nowX][nowY] != 1) {
                    continue;
                }
                visited[nowX][nowY] = true;
                queue.offer(new int[]{nowX, nowY});
                miro[nowX][nowY] = miro[now[0]][now[1]] + 1;
            }
        }
    }
}
