package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = searchConstructor(N);
        System.out.println(result);
    }

    //최소 생성자 구하는 메서드
    static int searchConstructor(int N){
        //1부터 입력받은 N까지 반복
        for(int i=1 ; i<=N ; i++){

            //현재 숫자 i를 문자열로 바꾸기
            String num =  String.valueOf(i);

            //최소 생성자 변수
            int minConstructor = 0;
            //각 자리수의 합 변수
            int digitSum = 0;

            //입력한 숫자의 각자리수를 digitSum변수에 담기
            for(int j=0 ; j<num.length() ;  j++){
                //숫자를 charAt메서드로 나누어 문자0을 빼주면 정수형 숫자로 전환됨
                digitSum += num.charAt(j) - '0';
            }

            //만약  i(현재숫자) + digitSum(각자리수의 합) = N(입력값) 이라면 최소 생성자 설정
            if(digitSum+i == N){
                minConstructor = i;
                return  minConstructor;
            }
        }
        return 0;
    }
}
