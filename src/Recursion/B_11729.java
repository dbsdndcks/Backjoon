package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11729 {
    static int count = 0;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        hanoi(N,1,2,3);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int N, int start, int mid, int to) {
        count++;
        if (N == 1) {
            sb.append(start+" "+to+"\n");
            return;
        }

        hanoi(N-1,start,to,mid);
        sb.append(start+" "+to+"\n");
        hanoi(N-1,mid,start,to);
    }


}
