package Map;

import java.util.HashMap;
import java.util.Scanner;

public class B_10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(sc.nextInt(), true);
        }

        int M = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (map.containsKey(sc.nextInt())) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
