package Advanced2;

import java.io.*;
import java.util.*;

public class B_2108 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        getArithmeticMean(arr);
        getMedian(arr);
        getMode(arr);
        getRange(arr);

        br.close();
    }

    private static void getArithmeticMean(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println(Math.round((float) result /arr.length));
    }

    private static void getMedian(int[] arr) {
        System.out.println(arr[arr.length/2]);
    }

    private static void getMode (int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        //배열안의 값들을 HashMap에 저장
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }
        //최빈값 횟수 구하기
        int maxCount = Collections.max(countMap.values());

        ArrayList<Integer> arrayList = new ArrayList<>();
        //최빈값 모음을 리스트에 저장
        for (Map.Entry<Integer, Integer> newEntry : countMap.entrySet()) {
            if (newEntry.getValue() == maxCount) {
                arrayList.add(newEntry.getKey());
            }
        }

        //리스트를 작은값 -> 큰값 정렬
        Collections.sort(arrayList);

        if (arrayList.size() > 1) {
            System.out.println(arrayList.get(1));
        } else {
            System.out.println(arrayList.get(0));
        }
    }

    private static void getRange(int[] arr) {
        if (arr.length == 1) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(arr[0] - arr[arr.length-1]));
        }

    }


}
