import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_000;

        long[][] dp = new long[N + 1][10];

        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1];
                if (j < 9) dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= MOD;
            }
        }

        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[N][j];
            result %= MOD;
        }

        System.out.println(result);
    }
}
