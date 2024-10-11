package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_11729 {
    static Stack<Integer> firstRod;
    static Stack<Integer> secondRod;
    static Stack<Integer> thirdRod;
    static int N;
    static StringBuilder sb;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        firstRod = new Stack<>();
        secondRod = new Stack<>();
        thirdRod = new Stack<>();
        for (int i = N; i > 0; i--) {
            firstRod.push(i);
        }

        movePlate(firstRod, secondRod, thirdRod);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void movePlate(Stack<Integer> firstRod, Stack<Integer> secondRod, Stack<Integer> thirdRod) {
        //세번째 장대의 크기가 N과 같다면 종료
        if (thirdRod.size() == N) {
            return;
        }
        if (!firstRod.isEmpty()) { //첫번쨰 장대가 비어있지 않을 경우

            //세번째 장대가 비어있다면 값 삽입
            if (thirdRod.isEmpty()) {
                thirdRod.push(firstRod.pop());
                sb.append("1 3").append("\n");
                count++;
                //세번째 장대에 값이 있다면
            } else {
                //첫번째 장대의 맨위의 값이 세번째 장대의 맨위의 값보다 크다면
                if (firstRod.peek() > thirdRod.peek()) {
                    //두번째  장대가 비어있다면 첫번째 장대의 값 삽입
                    if (secondRod.isEmpty()) {
                        secondRod.push(firstRod.pop());
                        sb.append("1 2").append("\n");
                        count++;
                        //두번째 장대에 값이있다면 세번째 장대의 값 삽입
                    } else {
                        secondRod.push(thirdRod.pop());
                        sb.append("3 2").append("\n");
                        count++;
                    }
                }
            }
        } else {  //비어있을경우
            if (secondRod.size() > 1 && !thirdRod.isEmpty()) {
                firstRod.push(secondRod.pop());
                sb.append("2 1").append("\n");
                count++;
            } else if(secondRod.size() == 1 && !thirdRod.isEmpty()){
                firstRod.push(thirdRod.pop());
                sb.append("3 1").append("\n");
                count++;
            }
        }
        movePlate(firstRod, secondRod, thirdRod);

    }

}
