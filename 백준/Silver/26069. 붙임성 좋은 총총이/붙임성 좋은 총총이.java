import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            String firstPerson = st.nextToken();
            String secondPerson = st.nextToken();

            if (firstPerson.equals("ChongChong") || secondPerson.equals("ChongChong")) {
                set.add(firstPerson);
                set.add(secondPerson);
            }
            if (set.contains(firstPerson) || set.contains(secondPerson)) {
                set.add(firstPerson);
                set.add(secondPerson);
            }
            N--;
        }
        System.out.println(set.size());
    }
}