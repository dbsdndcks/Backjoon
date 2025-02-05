package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7569 {

    static int[][][] box;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dirX;
    static int[] dirY;
    static int[] dirH;
    static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N,M,H 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        //박스초기화
        box = new int[H][M][N];

        //방향초기화
        dirX = new int[]{-1, 1, 0, 0};
        dirY = new int[]{0, 0, -1, 1};
        dirH = new int[]{-1, 1};

        //박스 값 입력
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //토마토 확인
        //박스 값 입력
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (box[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j});
                    }
                }
            }
        }

        int result = bfs();
        System.out.println(result);

    }

    static int bfs() {
        int day = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                int nowH = now[0];
                int nowX = now[1];
                int nowY = now[2];

                //상하좌우
                for (int j = 0; j < 4; j++) {
                    int nextX = dirX[j] + nowX;
                    int nextY = dirY[j] + nowY;

                    if (0 <= nextX && 0 <= nextY && nextX < M && nextY < N) {
                        if (box[nowH][nextX][nextY] == 0) {
                            box[nowH][nextX][nextY] = 1;
                            q.offer(new int[]{nowH, nextX, nextY});
                        }
                    }
                }

                //위아래
                for (int j = 0; j < 2; j++) {
                    int nextH = dirH[j] + nowH;

                    if (0 <= nextH && nextH < H) {
                        if (box[nextH][nowX][nowY] == 0) {
                            box[nextH][nowX][nowY] = 1;
                            q.offer(new int[]{nextH, nowX, nowY});
                        }
                    }
                }


            }
            day++;
        }

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (box[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }
        return day;
    }
}
