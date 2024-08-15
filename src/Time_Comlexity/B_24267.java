package Time_Comlexity;

import java.io.*;

public class B_24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long result = ((long) N *(N-1)*(N-2))/6;
        br.close();

        bw.write(result + "\n" + 3);
        bw.flush();
        bw.close();
    }
}
