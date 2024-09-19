package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> que = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            que.add(i+1);
        }

        int cnt = N;
        while(cnt > 0){
            for (int i = 0; i < K-1; i++) {
                que.add(que.pollFirst());
            }
            if (cnt == 1) {
                sb.append(que.pollFirst());
            } else {
                sb.append(que.pollFirst()).append(", ");
            }
            cnt--;
        }
        sb.append(">");
        System.out.println(sb);
    }
}
