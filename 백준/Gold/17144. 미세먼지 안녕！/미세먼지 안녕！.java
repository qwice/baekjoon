import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[] X;
    static int[][] map;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        X = new int[2];
        
        map = new int[R][C];
        int a = 0;
        
        for(int i = 0 ; i < R ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < C ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            if(map[i][j] == -1){
              X[a] = i;
              a++;
            }
          }
        }
        
        for(int i = 0 ; i < T ; i++){
          diff();
          wind();
        }
        
        int count = 0;
        
        for(int i = 0 ; i < R ; i++){
          for(int j = 0 ; j < C ; j++){
            if(map[i][j] == -1) continue;
            count += map[i][j];
          }
        }
        
        System.out.print(count);
    }
    
    static void diff(){
      int[][] temp = new int[R][C];
      
      for(int i = 0 ; i < R ; i++){
        for(int j = 0 ; j < C ; j++){
          int num = 4;
          if(map[i][j] == -1) continue;
          if(i == 0 || i == R - 1) num--;
          if(j == 0 || j == C - 1) num--;
          if(i == X[0] - 1 || i == X[1] + 1) num--;
          if((i == X[0] || i == X[1]) && j == 1) num--;
          
          int m = map[i][j] / 5;
          
          for(int dir = 0 ; dir < 4 ; dir++){
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            
            if(nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1){
              temp[nx][ny] += m;
              map[i][j] -= m;
            }
          }
        }
      }
      
      for(int i = 0 ; i < R ; i++){
        for(int j = 0 ; j < C ; j++){
          map[i][j] += temp[i][j];
        }
      }
    }
    
    static void wind(){
      int[][] temp = new int[R][C];
      
      for(int i = X[0] - 2 ; i >= 0 ; i--){
       map[i + 1][0] = map[i][0];
      }
      for(int i = 1 ; i < C ; i++){
        map[0][i - 1] = map[0][i];
      }
      for(int i = 1 ; i <= X[0] ; i++){
        map[i - 1][C - 1] = map[i][C - 1];
      }
      for(int i = C - 2 ; i >= 0 ; i--){
        map[X[0]][i + 1] = map[X[0]][i];
      }
      for(int i = X[1] + 2 ; i < R ; i++){
        map[i - 1][0] = map[i][0]; 
      }
      for(int i = 1 ; i < C ; i++){
        map[R - 1][i - 1] = map[R - 1][i];
      }
      for(int i = R - 2; i >= X[1] ; i--){
        map[i + 1][C - 1] = map[i][C - 1];
      }
      for(int i = C - 2 ; i >= 0 ; i--){
        map[X[1]][i + 1] = map[X[1]][i];
      }
      map[X[0]][1] = 0;
      map[X[1]][1] = 0;
    }
}
