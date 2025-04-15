import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        int ans = 0;
        
        Arrays.fill(dp[1], 1);
        
        for(int i = 2 ; i <= n ; i++){
          for(int j = 0 ; j <= 9 ; j++){
            for(int k = 0 ; k <= j ; k++){
              dp[i][j] += dp[i-1][k];
              dp[i][j] %= 10007;
            }
          }
        }
        
        for(int i = 0 ; i <= 9 ; i++){
          ans = (ans + dp[n][i]) % 10007;
        }
        
        System.out.print(ans);
    }
}
