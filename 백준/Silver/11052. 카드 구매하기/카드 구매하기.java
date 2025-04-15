import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        
        int[] cards = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1 ; i <= n ; i++){
          cards[i] = Integer.parseInt(st.nextToken());
          dp[i] = cards[i];
        }
        
        for(int i = 2 ; i <= n ; i++){
          for(int j = 1; j < i ; j++){
            dp[i] = Math.max(dp[i-j] + cards[j], dp[i]);
          }
        }
        
        System.out.print(dp[n]);
    }
}
