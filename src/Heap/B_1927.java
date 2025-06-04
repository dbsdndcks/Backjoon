package Heap;

import java.util.*;

public class B_1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < X; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                q.offer(num);
            }
        }
    }
}
