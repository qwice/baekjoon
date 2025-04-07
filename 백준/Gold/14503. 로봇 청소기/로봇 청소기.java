import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] cleaned;
    
    static int count = 0;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        cleaned = new boolean[N][M];
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < M ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        cleanRoom(r, c, d);
        
        System.out.print(count);
    }
    
    static void cleanRoom(int x, int y, int dir){
      while(true){
        if(!cleaned[x][y]){
          cleaned[x][y] = true;
          count++;
        }
        
        boolean moved = false;
        
        for(int i = 0 ; i < 4 ; i++){
          dir = (dir + 3) % 4;
          int nx = x + dx[dir];
          int ny = y + dy[dir];
          
          if(isIn(nx, ny) && map[nx][ny] == 0 && !cleaned[nx][ny]){
            x = nx;
            y = ny;
            moved = true;
            break;
          }
        }
        
        if(!moved){
          int backDir = (dir + 2) % 4;
          int bx = x + dx[backDir];
          int by = y + dy[backDir];
          
          if(isIn(bx, by) && map[bx][by] != 1){
            x = bx;
            y = by;
          } else {
            return;
          }
        }
      }
    }
    
    static boolean isIn(int x, int y){
      return x >=0 && y >= 0 && x < N && y < M;
    }
}
