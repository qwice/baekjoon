import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[k+1];
        Arrays.fill(dp, 100001);
        
        dp[0] = 0;
        
        for(int i = 0 ; i < n ; i++){
          arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0 ; i <= k ; i++){
          for(int j = 0 ; j < n ; j++){
            if(i >= arr[j]){
              dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
            }
          }
        }
        
        System.out.print(dp[k] == 100001 ? -1 : dp[k]);
    }
}
