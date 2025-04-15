import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 2; i <= n ; i++){
            if(i >= 2) dp[i] = Math.min(dp[i], dp[i-2] + 1);
            if(i >= 5) dp[i] = Math.min(dp[i], dp[i-5] + 1);
        }
        
        System.out.print(dp[n] == 100001 ? -1 : dp[n]);
    }
}