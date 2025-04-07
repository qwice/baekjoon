import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        for(int i = 0 ; i < N ; i++){
          if(canPass(map[i])) count++;
          int[] col = new int[N];
          for(int j = 0 ; j < N ; j++) col[j] = map[j][i];
          if(canPass(col)) count++;
        }
        
        System.out.print(count);
    }
    static boolean canPass(int[] line){
      boolean[] used = new boolean[N];
      
      for(int i = 0 ; i < N - 1 ; i++){
        int diff = line[i] - line[i+1];
        if(diff == 0) continue;
        else if(diff == 1){
          for(int j = 1; j <= L ; j++){
            int idx = i + j;
            if(idx >= N || line[idx] != line[i+1] || used[idx]){
              return false;
            }
            used[idx] = true;
          }
        }
        
        else if(diff == -1){
          for(int j = 0; j < L ; j++){
            int idx = i - j;
            if(idx < 0 || line[idx] != line[i] || used[idx]){
              return false;
            }
            used[idx] = true;
          }
        }
        
        else return false;
      }
      
      return true;
    }
}
