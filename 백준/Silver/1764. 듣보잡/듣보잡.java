import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>();
        List<String> unseenUnheard = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                unseenUnheard.add(name);
            }
        }

        Collections.sort(unseenUnheard);

        System.out.println(unseenUnheard.size());
        for (String name : unseenUnheard) {
            System.out.println(name);
        }
    }
}