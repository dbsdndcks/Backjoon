package Brute_Force;

import java.io.*;
import java.util.StringTokenizer;

public class B_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = (c * e - f * b) / (a * e - d * b);
        int y = (c * d - f * a) / (b * d - e * a);

        // 결과 출력
        bw.write(x + " " + y);
        bw.flush();
        bw.close();
    }
}
