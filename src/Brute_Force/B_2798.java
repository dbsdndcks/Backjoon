package Brute_Force;

import java.io.*;
import java.util.StringTokenizer;

public class B_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        //최대값 구하기
        int maxNum = searchMaxNum(arr, N, M);
        //출력
        System.out.println(maxNum);
    }
    //완전순회 메서드
    static int searchMaxNum(int[] arr,int N,int M){
        int maxNum = 0;
        int temp = 0;
        //3개를 고르기에 첫번째 카드는 N-2까지만 순회
        for(int i=0 ; i<N-2 ; i++){

            //두 번째 카드는 첫 번째 카드 다음부터 N-1 까지만 순회
            for(int j=i+1 ; j<N-1 ; j++){

                //세 번째 카드는 두 번째 카드 다음부터 N까지 순회
                for(int k=j+1 ; k<N ; k++){

                    //3개의 카드의 합 변수 temp
                    temp =  arr[i] + arr[j] + arr[k];

                    //M과 세 카드의 합이 같다면 temp return 및 종료
                    if(M == temp){
                        return  temp;
                    }

                    if(temp < M && maxNum < temp){
                        maxNum = temp;
                    }
                }
            }
        }
        return  maxNum;
    }
}
