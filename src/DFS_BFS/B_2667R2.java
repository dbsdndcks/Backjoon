package DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class B_2667R2 {

    static boolean[][] visited;
    static boolean[][] complex;
    static int countPerDanji;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //지도 크기 입력
        int N = Integer.parseInt(br.readLine());

        //초기화
        visited = new boolean[N + 10][N + 10];
        complex = new boolean[N + 10][N + 10];

        //지도(complex) 초기값 설정
        for (int i = 1; i <= N; i++) {
            //한줄씩 입력
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (str.charAt(j-1) == '1') {
                    complex[i][j] = true;
                }
            }
        }
        br.close();

        ArrayList<Integer> danji = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (complex[i][j] && !visited[i][j]) {
                    countPerDanji = 0;
                    dfs(i, j);
                    danji.add(countPerDanji);
                }
            }
        }

        System.out.println(danji.size());
        Collections.sort(danji);
        for (int i = 0; i < danji.size(); i++) {
            System.out.println(danji.get(i));
        }
    }

    //dfs 구현
    static void dfs(int x, int y) {
        visited[x][y] = true;
        countPerDanji++;

        for (int i = 0; i < 4; i++) {
            int positionX = dirX[i] + x;
            int positionY = dirY[i] + y;
            if (!visited[positionX][positionY] && complex[positionX][positionY]) {
                dfs(positionX, positionY);
            }
        }
    }
}
