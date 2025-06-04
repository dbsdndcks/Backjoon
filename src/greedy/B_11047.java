package greedy;

import java.util.Scanner;

public class B_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;
        int balance = N;
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            if (money[i] > K) {
                continue;
            }
            count += K / money[i];
            K = K % money[i];
        }

        System.out.println(count);
    }
}
