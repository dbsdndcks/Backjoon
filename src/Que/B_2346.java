package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_2346 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer  st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (Integer.parseInt(st.nextToken()));
        }



        for (int i = 0; i < N; i++) {
            deque.offer(new int[]{(i + 1), numbers[i]});
        }

        while (!deque.isEmpty()) {
            int idx = deque.peek()[0]; //풍선 고유 indext
            int num = deque.peek()[1]; //풍선에 적힌 번호


        }

        br.close();
    }
}
