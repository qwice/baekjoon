class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int[][] dp = new int[row][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int r = 1; r < row; r++) {
            for (int c = 0; c < 4; c++) {
                dp[r][c] = land[r][c];
                int max = 0;
                for (int pc = 0; pc < 4; pc++) {
                    if (pc == c) continue;
                    max = Math.max(max, dp[r - 1][pc]);
                }
                dp[r][c] += max;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[row - 1][i]);
        }

        return answer;
    }
}
