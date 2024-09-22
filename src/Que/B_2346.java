package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<int[]> queue = new ArrayDeque<>();

        int[] ballon = new int[N];
        for (int i = 0; i < N; i++) {
            ballon[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            queue.offer(new int[]{(i+1),ballon[i]});
        }

        while (!queue.isEmpty()) {
            int idx = queue.peek()[0];
            int num = queue.peek()[1];

            sb.append(idx + " ");
            if (num > 0) {
                queue.remove();
                if(queue.isEmpty())break;

                while (num-1 > 0) {
                    queue.offerLast(queue.pollFirst());
                    num--;
                }
            }else if (num < 0){
                queue.remove();
                if(queue.isEmpty())break;

                while (num < 0) {
                    queue.offerFirst(queue.pollLast());
                    num++;
                }
            }

        }
        System.out.println(sb);
    }
}
