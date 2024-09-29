import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] divisor = new int[count];
        for (int i = 0; i < count; i++) {
           divisor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(divisor);

        int min = divisor[0];
        int max = divisor[divisor.length - 1];

        System.out.println(min*max);
    }
}