import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numerator = 1;
        int denominator = 1;
        int result = 0;
        for (int i = N; i > N - K; i--) {
            numerator *= i;
        }
        for (int i = K; i > 0; i--) {
            denominator *= i;
        }

        result = numerator/denominator;
        System.out.println(result);

    }
}