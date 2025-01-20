package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576 {
    static int[][] box;
    static int N;
    static int M;
    static Queue<tomato> queue = new LinkedList<tomato>();

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    static class tomato {
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        //초기화
        box = new int[N][M];

        //상자 값 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new tomato(i, j, 0));
                }
            }
        }
        bfs();

    }
    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;


            for(int i=0; i<4; i++) {
                int nx = t.x + dirX[i];
                int ny = t.y + dirY[i];

                if(0 <= nx && nx <N && 0<= ny && ny <M) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, day+1));
                    }
                }
            }
        }
        if(checkTomato()){
            System.out.println(day);
        } else{
            System.out.println(-1);
        }

    }
    static boolean checkTomato() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(box[i][j] == 0)
                    return false;
                // 덜 익은 토마토가 있다면
            }
        }
        return true;
    }

}



