import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static Shark[][] map;
    
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
  
    static class Shark{
      int r, c, s, d, z;
      Shark(int r, int c, int s, int d, int z){
        this.r = r; this.c = c; this.s = s; this.d = d; this.z = z;
      }
    }
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      map = new Shark[R+1][C+1];
      
      for(int i = 0 ; i < M ; i++){
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        map[r][c] = new Shark(r, c, s, d, z);
      }
      
      int result = 0;
      
      for(int i = 1; i <= C ; i++){
        for(int j = 1; j <= R ; j++){
          if(map[j][i] != null){
            result += map[j][i].z;
            map[j][i] = null;
            break;
          }
        }
        
        Shark[][] newMap = new Shark[R+1][C+1];
        for(int j = 1 ; j <= R ; j++){
          for(int t = 1 ; t <= C ; t++){
            if(map[j][t] != null){
              Shark shark = map[j][t];
              int x = shark.r;
              int y = shark.c;
              int s = shark.s;
              int d = shark.d;
              
              if(d == 1 || d == 2) s %= 2*(R-1);
              else s %= 2*(C-1);
              
              for(int k = 0 ; k < s ; k++){
                if(d == 1 && x ==1) d = 2;
                else if(d == 2 && x == R) d = 1;
                else if(d == 3 && y == C) d = 4;
                else if(d == 4 && y == 1) d = 3;
                x += dx[d];
                y += dy[d];
              }
              
              shark.r = x;
              shark.c = y;
              shark.d = d;
              
              if(newMap[x][y] == null || newMap[x][y].z < shark.z){
                newMap[x][y] = shark;
              }
            }
          }
        }
        map = newMap;
      }
      System.out.print(result);
    }
}
