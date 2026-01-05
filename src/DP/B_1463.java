package DP;

import java.io.*;
import java.util.*;

public class B_1463 {

    static int[][][] arr = new int[100][100][100];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                return;
            }
            int result = w(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d\n", a,b,c,result);
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }
        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1)
                + w(a, b - 1, c - 1)
                - w(a, b - 1, c);
        }else{
            arr[a][b][c] = w(a - 1, b, c)
                + w(a - 1, b - 1, c)
                + w(a - 1, b, c - 1)
                - w(a - 1, b - 1, c - 1);
        }

        return arr[a][b][c];
    }
}
/*
    static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (a < b && b < c) {
            return w(a, b, c - 1)
                + w(a, b - 1, c - 1)
                - w(a, b - 1, c);
        }
        return w(a - 1, b, c)
            + w(a - 1, b - 1, c)
            + w(a - 1, b, c - 1)
            - w(a - 1, b - 1, c - 1);
    }
 */
