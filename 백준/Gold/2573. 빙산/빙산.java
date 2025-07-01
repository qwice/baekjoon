import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < M ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        int year = 0;
        while(true) {
          int size = 0;
          visited = new boolean[N][M];
          
          for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
              if(map[i][j] > 0 && !visited[i][j]) {
                visited[i][j] = true;
                dfs(i,j);
                size++;
              }
            }
          }
          
          if(size >= 2) {
            System.out.print(year);
            return;
          }
          
          if(size == 0){
            System.out.print(0);
            return;
          }
          
          melt();
          year++;
        }
    }
    
    static void dfs(int i, int j){
      for(int dir = 0 ; dir < 4 ; dir++) {
        int nx = i + dx[dir];
        int ny = j + dy[dir];
        
        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if(map[nx][ny] > 0 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          dfs(nx,ny);
        }
      }
    }
    
    static void melt() {
      int[][] temp = new int[N][M];
      
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M ; j++){
          int sea = 0;
          if(map[i][j] > 0) {
            for(int dir = 0 ; dir < 4 ; dir++){
              int nx = i + dx[dir];
              int ny = j + dy[dir];
              if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
              if(map[nx][ny] == 0) sea++;
            }
          }
          
          temp[i][j] = Math.max(0, map[i][j] - sea);
        }
      }
      
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M ; j++){
          map[i][j] = temp[i][j];
        }
      }
    }
}
