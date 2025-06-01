import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];

    public static boolean isPossible(int channel) {
        if (channel == 0) {
            return !broken[0];
        }

        while (channel > 0) {
            if (broken[channel % 10]) return false;
            channel /= 10;
        }
        return true;
    }

    public static int getLength(int channel) {
        if (channel == 0) return 1;
        return String.valueOf(channel).length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        int answer = Math.abs(N - 100);

        for (int i = 0; i <= 999_999; i++) {
            if (isPossible(i)) {
                int pressCount = getLength(i) + Math.abs(i - N);
                answer = Math.min(answer, pressCount);
            }
        }

        System.out.println(answer);
    }
}
