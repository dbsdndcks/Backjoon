package Que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_18258 {

    static int[] que = new int[20000000];
    static int front = 0;
    static int rear = 0;
    static int size = 0;
    static StringBuilder sb = new StringBuilder();
    private static void push(int value) {
        que[rear++] = value;
        size++;
    }

    private static void pop() {
        if (size <= 0) {
            sb.append(-1).append("\n");
        }else{
            sb.append(que[front++]).append("\n");
            size--;
        }
    }

    private static void size() {
        sb.append(size).append("\n");
    }

    private static void empty() {
        if (size <= 0) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static void front() {
        if (size <= 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(que[front]).append("\n");
        }
    }

    private static void back() {
        if (size <= 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(que[rear-1]).append("\n");
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken()));break;
                case "pop": pop();break;
                case "size": size();break;
                case "empty": empty();break;
                case "front": front();break;
                case "back": back();break;
            }
        }
        System.out.println(sb);
    }
}
