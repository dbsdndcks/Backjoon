package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class B_7562 {

    static int[][] chase;
    static int[] dirX = {-2, -2, 2, 2, -1, 1, -1, 1};
    static int[] dirY = {-1, 1, -1, 1, -2, -2, 2, 2};
    static int chaseLine;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //테스트 케이스 입력
        int testCase = Integer.parseInt(br.readLine());

        //시작
        for (int testCount = 0; testCount < testCase; testCount++) {
            chaseLine = Integer.parseInt(br.readLine());
            chase = new int[chaseLine][chaseLine];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            chase[startX][startY] = 1;

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            bfs(startX,startY);
            System.out.println(chase[endX][endY]-1);
        }
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});

        while (!q.isEmpty()) {
            int[] moveChase = q.poll();
            for (int i = 0; i < 8; i++) {
                int nowX =  moveChase[0] + dirX[i];
                int nowY =  moveChase[1] + dirY[i];
                if (nowX >= 0 && nowY >= 0 && nowX < chaseLine && nowY < chaseLine) {
                    if (chase[nowX][nowY] == 0) {
                        chase[nowX][nowY] = chase[moveChase[0]][moveChase[1]] + 1;
                        q.offer(new int[] {nowX,nowY});
                    }
                }
            }
        }

    }
}
