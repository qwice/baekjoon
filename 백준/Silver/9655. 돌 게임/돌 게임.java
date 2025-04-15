import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n+1];
        
        dp[1] = true;
        if(n >= 2) dp[2] = false;
        if(n >= 3) dp[3] = true;
        
        for(int i = 4; i <= n ;i++){
          dp[i] = !dp[i-1] || !dp[i-3];
        }
        
        System.out.print(dp[n] ? "SK" : "CY");
    }
}
