import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[2][n];
            int[][] dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            if (n > 1) {
                dp[0][1] = dp[1][0] + score[0][1];
                dp[1][1] = dp[0][0] + score[1][1];
            }

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + score[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + score[1][i];
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
        }
    }
}
