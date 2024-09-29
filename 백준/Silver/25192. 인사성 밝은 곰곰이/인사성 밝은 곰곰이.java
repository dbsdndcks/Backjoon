import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> chat = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                chat.clear();  // 새로운 그룹 시작 시 초기화
            } else if (!chat.contains(input)) {
                chat.add(input);  // 존재하지 않는 닉네임이면 추가
                count++;  // 카운트 증가
            }
        }
        System.out.println(count);
    }
}