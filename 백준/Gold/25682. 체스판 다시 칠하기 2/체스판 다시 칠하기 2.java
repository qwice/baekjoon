import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N+1][M+1];
        int[][] wrongW = new int[N+1][M+1];
        int[][] wrongB = new int[N+1][M+1];
        
        for(int i = 1; i <= N ; i++){
          String row = br.readLine();
          for(int j = 1; j <= M ; j++){
            board[i][j] = row.charAt(j-1);
            
            boolean isWhite = (i + j) % 2 == 0;
            
            wrongW[i][j] = wrongW[i-1][j] + wrongW[i][j-1] - wrongW[i-1][j-1];
            wrongB[i][j] = wrongB[i-1][j] + wrongB[i][j-1] - wrongB[i-1][j-1];
            
            if(isWhite){
              if(board[i][j] != 'W') wrongW[i][j]++;
              if(board[i][j] != 'B') wrongB[i][j]++;
            } else {
              if(board[i][j] != 'B') wrongW[i][j]++;
              if(board[i][j] != 'W') wrongB[i][j]++;
            }
          }
        }
        
        int minPaint = Integer.MAX_VALUE;
        
        for(int i = K ; i <= N ; i++){
          for(int j = K ; j <= M ; j++){
            int paintW = wrongW[i][j] - wrongW[i - K][j] - wrongW[i][j - K] + wrongW[i -K][j - K];
            int paintB = wrongB[i][j] - wrongB[i - K][j] - wrongB[i][j - K] + wrongB[i -K][j - K];
            
            minPaint = Math.min(minPaint, Math.min(paintW, paintB));
          }
        }
        
        System.out.print(minPaint);
    }
}
