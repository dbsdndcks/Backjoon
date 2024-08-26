package Brute_Force;

import java.util.Scanner;

public class B_1436 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int minValue = 666;
        int count = 1;

        while (count != N) {
            minValue++;
            if(String.valueOf(minValue).contains("666")){
                count++;
            }
        }

        System.out.println(minValue);
    }
}
