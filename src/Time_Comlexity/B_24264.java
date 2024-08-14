package Time_Comlexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_24264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long count = (long) Math.pow(N, 2); // n의 2제곱 -> O(n2) 시간복잡도를 가진다
        System.out.println(count);
        System.out.println(2);
    }
}
