package Combinatorics;

import java.util.Scanner;

public class B_24723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 2;
        for (int i = 0; i < N; i++) {
            count += (int) Math.pow(2,i);
        }
        count--;
        System.out.println(count);
    }
}
