package Time_Comlexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i=N-1 ; i>0 ; i--){
            sum += i;
        }
        System.out.println(sum);
        System.out.println(2);
    }
}
