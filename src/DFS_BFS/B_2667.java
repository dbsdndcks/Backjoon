package DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B_2667 {

    static int[][] complex;
    static int countDanji;
    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //지도 크기 입력
        int N = Integer.parseInt(br.readLine());

        //지도 초기화
        complex = new int[N][N];
        //visit 초기화

        //지도 입력
        String[] line = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                complex[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        //돌면서 dfs;
        ArrayList<Integer> countList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (complex[i][j] == 1) {
                    countDanji = 0;
                    dfs(i, j);
                    countList.add(countDanji);
                }
            }
        }

        //출력
        bw.write(countList.size()+"\n");
        Collections.sort(countList);

        for (int i = 0; i < countList.size(); i++) {
            bw.write(countList.get(i) +"\n");
        }

        //bw,br 종료
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int i, int j) {
        complex[i][j] = 0;
        countDanji++;
        for (int k = 0; k < 4; k++) {
            int newX = i + x[k];
            int newY = j + y[k];
            // 유효성 검사: 범위를 벗어나지 않고 값이 1인지 확인
            if (newX >= 0 && newX < complex.length && newY >= 0 && newY < complex[0].length && complex[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }
    }

}
