package Brute_Force;

import java.util.Scanner;

public class B_2839 {

    public static int paperBag(int N) {
        // 5kg 봉지를 최대한 많이 사용하여 남은 설탕이 3으로 나누어떨어지는지 확인
        int maxFiveBags = N / 5;

        while (maxFiveBags >= 0) {
            int remainder = N - (5 * maxFiveBags);
            if (remainder % 3 == 0) {
                int threeBags = remainder / 3;
                return maxFiveBags + threeBags;  // 전체 봉지 수를 반환
            }
            maxFiveBags--;
        }

        // 5kg 봉지로 나누고 남은 설탕이 3으로 나누어떨어지지 않는 경우
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(paperBag(N));
    }
}
