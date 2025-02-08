package Backtracking;

import java.io.*;
import java.util.StringTokenizer;
public class B_15650 {

    static int N,M;

    public static void dfs(int depth) {
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N,M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
    }


}
