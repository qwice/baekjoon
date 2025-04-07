import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] ladder;
    static int min = 4;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        ladder = new int[H+1][N+1];
        
        for(int i = 0 ; i < M ; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          ladder[a][b] = 1;
          ladder[a][b+1] = 2;
        }
        
        dfs(0, 1, 1);
        
        System.out.print(min == 4 ? -1 : min);
    }
    
    static void dfs(int count, int x, int y){
      if(count >= min) return;
      
      if(check()){
        min = count;
        return;
      }
      
      if(count == 3) return;

      for(int i = x ; i <= H ; i++){
        for(int j = (i == x ? y : 1) ; j < N ; j++){
          if(ladder[i][j] == 0 && ladder[i][j+1] == 0){
            ladder[i][j] = 1;
            ladder[i][j+1] = 2;
            dfs(count + 1, i, j+2);
            ladder[i][j] = 0;
            ladder[i][j+1] = 0;
          }
        }
      }
    }
    
    static boolean check(){
      for(int i = 1 ; i <= N ; i++){
        int pos = i;
        for(int j = 1 ; j <= H ; j++){
          if(ladder[j][pos] == 1) pos++;
          else if(ladder[j][pos] == 2) pos--;
        }
        
        if(pos != i) return false;
      }
      return true;
    }
}
