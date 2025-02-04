package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576R {

    static int[][] box;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[M][N];

        //박스 값 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //익은 토마토 찾기
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        int day = -1; // 첫날을 0이 아니라 -1로 설정하여 첫 번째 루프에서 0이 되도록 함.

        while (!q.isEmpty()) {
            int size = q.size();
            day++; // 하루 증가

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nowX = now[0] + dirX[j];
                    int nowY = now[1] + dirY[j];

                    if (0 <= nowX && 0 <= nowY && nowX < M && nowY < N) {
                        if (box[nowX][nowY] == 0) {
                            box[nowX][nowY] = 1;
                            q.offer(new int[]{nowX, nowY});
                        }
                    }
                }
            }
        }

        // BFS가 끝난 후, 익지 않은 토마토가 남아 있는지 확인
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 있으면 -1 반환
                }
            }
        }

        return day;
    }

}


