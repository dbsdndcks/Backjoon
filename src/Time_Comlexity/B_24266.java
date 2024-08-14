package Time_Comlexity;

import java.io.*;

public class B_24266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        br.close();

        bw.write(N*N*N + "\n" + 3);
        bw.flush();
        bw.close();
    }
}
