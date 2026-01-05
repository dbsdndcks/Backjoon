package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14889 {

    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.print(min);
    }

    static void dfs(int index, int count) {
        if (N / 2 == count) {
            calc();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    static void calc() {
        int start_team = 0;
        int link_team = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start_team += (arr[i][j] + arr[j][i]);
                }else if(!visited[i] && !visited[j]){
                    link_team += (arr[i][j] + arr[j][i]);
                }
            }
        }

        // 두 팀의 점수 차이 (절댓값)
        int val = Math.abs(start_team - link_team);

        /*
         * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
         * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
         */
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }
}
