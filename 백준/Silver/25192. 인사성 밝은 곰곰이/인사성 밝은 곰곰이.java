import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                set.clear();  // 새로운 사람이 입장했으므로 기존 닉네임 초기화
            } else {
                if (!set.contains(input)) { // 처음 등장한 닉네임이면 카운트 증가
                    count++;
                    set.add(input);
                }
            }
        }

        System.out.println(count);
    }
}
