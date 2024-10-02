package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));
    }

    static int fibonacci(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return result += 1;
        }
        return result = fibonacci(n-1) + fibonacci(n-2);
    }
}
