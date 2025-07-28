import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];
    int[][][] dp = new int[N][N][3];
    
    dp[0][1][0] = 1;
    
    for(int i = 0 ; i < N ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < N ; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for(int r = 0 ; r < N ; r++){
      for(int c = 0 ; c < N ; c++){
        if(map[r][c] == 1) continue;
        
        if(c-1 >= 0) {
          dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][2];
        }
        
        if(r-1 >= 0) {
          dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2];
        }
        
        if(r-1 >= 0 && c-1 > 0 && map[r-1][c] != 1 && map[r][c-1] != 1) {
          dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
        }
      }
    }
    
    System.out.print(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
  }
}