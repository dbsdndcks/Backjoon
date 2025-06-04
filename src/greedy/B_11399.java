package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<Integer> list = new ArrayList<>();
        String time = sc.nextLine();
        String[] split = time.split(" ");
        for (String s : split) {
            int i = Integer.parseInt(s);
            list.add(i);
        }

        Collections.sort(list);

        int total = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                total += list.get(i);
            } else {
                for (int j = 0; j <= i; j++) {
                    total += list.get(j);
                }
            }
        }

        System.out.println(total);
    }
}
