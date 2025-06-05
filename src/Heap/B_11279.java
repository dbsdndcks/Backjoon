package Heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B_11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < X; i++) {
            int num = sc.nextInt();
            num = -num;
            if (num == 0) {
                if (!q.isEmpty()) {
                    System.out.println(-q.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                q.offer(num);
            }
        }
    }
}
