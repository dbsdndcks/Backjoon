package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B_4779 {
    static String[]arr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int total;
        while (true) {
            N = Integer.parseInt(br.readLine());
            total = (int) Math.pow(N);
            arr = new String[total];
            for (int i = 0; i < total; i++) {
                arr[i] = br.readLine();
            }
            recursion(arr);
        }
    }

    private static void recursion(String[] arr) {
        
    }

}

