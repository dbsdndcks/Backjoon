import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            que.offer(i+1);
        }

        int size = que.size();
        while (size > 1 ) {
            que.pop();
            int first = que.pop();
            que.offer(first);
            size--;
        }
        System.out.println(que.peek());



    }
}