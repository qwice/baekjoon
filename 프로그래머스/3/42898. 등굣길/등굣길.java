class Solution {
    static int[][] dp;
    static boolean[][] visited;
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles) {
            visited[puddle[1]][puddle[0]] = true;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                if(i == 1 && j == 1) continue;
                if(!visited[i][j]) dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        return dp[n][m];
    }
}