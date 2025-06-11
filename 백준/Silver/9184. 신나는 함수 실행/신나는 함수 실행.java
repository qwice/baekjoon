import java.util.Scanner;

public class Main {
    static int[][][] dp = new int[21][21][21]; // a, b, c가 20까지이므로 21x21x21 크기의 dp 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DP 배열 초기화
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    dp[i][j][k] = -1; // 초기 값은 -1로 설정
                }
            }
        }

        while (true) {
            // 입력 받기
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // w(a, b, c) 계산 및 출력
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    // w(a, b, c) 함수
    static int w(int a, int b, int c) {
        // 기저 조건
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        
        // 경계 조건
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 이미 계산된 값이 있으면 그 값을 반환
        if (dp[a][b][c] != -1) {
            return dp[a][b][c];
        }

        // 일반 조건
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return dp[a][b][c];
    }
}
