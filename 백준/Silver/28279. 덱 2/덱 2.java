
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> deque = new LinkedList<>();

    static void offerFirst(int num) {
        deque.offerFirst(num);
    }

    static void offerLast(int num) {
        deque.offerLast(num);
    }

    static void pollFirst() {
        Integer result = deque.pollFirst();
        System.out.println((result==null)? -1 : result);
    }

    static void pollLast() {
        Integer result = deque.pollLast();
        System.out.println((result==null)? -1 : result);
    }

    static void size() {
        System.out.println(deque.size());
    }

    static void isEmpty() {
        System.out.println((deque.isEmpty() ? 1 : 0));
    }

    static void peekFirst() {
        Integer result = deque.peekFirst();
        System.out.println((result==null)? -1 : result);
    }

    static void peekLast() {
        Integer result = deque.peekLast();
        System.out.println((result==null)? -1 : result);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "1": offerFirst(Integer.parseInt(st.nextToken()));break;
                case "2": offerLast(Integer.parseInt(st.nextToken()));break;
                case "3": pollFirst();break;
                case "4": pollLast();break;
                case "5": size();break;
                case "6": isEmpty();break;
                case "7": peekFirst();break;
                case "8": peekLast();break;
            }
            N--;
        }
    }
}
