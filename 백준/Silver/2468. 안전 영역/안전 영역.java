import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        int mH = 0;
        
        for(int i = 0 ; i < N ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            mH = Math.max(mH, map[i][j]);
          }
        }
        
        int mC = 0;
        
        for(int i = 0 ; i <= mH ; i++){
          visited = new boolean[N][N];
          int count = 0;
          for(int j = 0 ; j < N; j++){
            for(int k = 0 ; k < N ; k++){
              if(!visited[j][k] && map[j][k] > i){
                visited[j][k] = true;
                dfs(i,j,k);
                count++;
              }
            }
          }
          
          mC = Math.max(mC, count);
        }
        
        System.out.print(mC);
    }
    
    static void dfs(int h, int x, int y){
      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > h && !visited[nx][ny]){
          visited[nx][ny] = true;
          dfs(h, nx, ny);
        }
      }
    }
}
