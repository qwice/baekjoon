import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        
        for(int i = 1; i <= 14; i++){
            dp[0][i] = i;
        }
        for(int i = 1 ; i <= 14 ; i++){
            for(int j = 1; j <= 14; j++){
                for(int k = 1; k <=j ; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        
        for(int i = 0 ; i < N ; i++){
            int n = Integer.parseInt(br.readLine());
            int t = Integer.parseInt(br.readLine());
            
            System.out.println(dp[n][t]);
        }
    }
}