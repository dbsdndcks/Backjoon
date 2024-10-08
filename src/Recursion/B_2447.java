package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int powNum = (int)Math.pow(3, N);

        String[][] star = new String[powNum][powNum];
        for (int i = 0; i < powNum; i++) {
            for (int j = 0; j < powNum; j++) {
                star[i][j] = "*";
            }
        }

        removeStar(star,0,powNum);

    }

    private static void removeStar(String[][]star) {

    }
}
