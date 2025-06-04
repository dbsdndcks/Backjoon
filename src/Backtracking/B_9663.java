package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class B_9663 {

    static int N;
    static boolean[][] board;
    static int possibleCount = 0;

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        board = new boolean[N][N];

        chase(0, 0);
    }

    private static void chase(final int row, final int column) {

        board[row][column] = true;
        int left =  (column + 1) - N;
        int right = N - (column + 1);
    }
}
