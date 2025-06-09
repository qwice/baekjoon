import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[N+1][K+1];

        for (int j = 1; j <= K; j++) {
            dp[0][j] = 1;
        }

        for (int n = 1; n <= N; n++) {
            dp[n][1] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                dp[n][k] = (dp[n-1][k] + dp[n][k-1]) % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}
