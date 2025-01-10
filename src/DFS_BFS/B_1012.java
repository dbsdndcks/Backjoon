package DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_1012 {

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] cabbage;
    //dfs 메서드
    static void dfs(int x, int y, int M, int N) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = dirX[i] + x;
            int newY = dirY[i] + y;

            if (newX >= 0 && newX < M && newY >= 0 && newY < N &&
                    !visited[newX][newY] && cabbage[newX][newY]) {
                dfs(newX, newY, M, N);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        //테스트케이스 개수만큼 반복
        for (int i = 0; i < T; i++) {

            //가로,세로,배추 위치 개수 입력
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //테스트케이스 마다 초기화
            visited = new boolean[M][N];
            cabbage = new boolean[M][N];

            //배추 위치 값넣기
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); //x좌표 입력
                int y = Integer.parseInt(st.nextToken()); //y좌표 입력

                cabbage[x][y] = true;
            }

            ArrayList<Integer> wormList = new ArrayList<>();
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbage[x][y] && !visited[x][y]) {
                        dfs(x, y, M, N);
                        wormList.add(1);
                    }
                }
            }
            System.out.println(wormList.size());
        }
    }
}
