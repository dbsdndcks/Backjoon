package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1697 {

    static int[] walk = {-1, 1};
    static int tp = 2;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        int nowNum;
        while (nowNum != K) {
            nowNum = q.poll();

            if (nowNum * tp != K) {
                for (int i = 0; i < 2; i++) {
                    if (nowNum + walk[i] == K) {
                        count++;
                        nowNum++;
                    }
                }//for
            }//if

            if (nowNum * tp == K) {
                count++;
                nowNum *= tp;
            }


        }// while

        System.out.println(count);


    }
}
