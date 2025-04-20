import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static boolean[][] visited;
    static char[][] map;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        int idx1 = 0, idx2 = 0;
        
        for(int i = 0 ; i < n ; i++){
          String s = br.readLine();
          for(int j = 0 ; j < n ; j++){
            map[i][j] = s.charAt(j);
          }
        }
        
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < n ; j++){
            if(!visited[i][j]){
              visited[i][j] = true;
              dfs(i, j, 0);
              idx1++;
            }
          }
        }
        
        for(int i = 0 ; i < n ; i++){
          Arrays.fill(visited[i], false);
        }
        
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < n ; j++){
            if(!visited[i][j] && (map[i][j] == 'R' || map[i][j] == 'G')){
              visited[i][j] = true;
              dfs(i, j, 1);
              idx2++;
            }
            else if(!visited[i][j]){
              visited[i][j] = true;
              dfs(i, j, 0);
              idx2++;
            }
          }
        }
        
        System.out.print(idx1 + " " + idx2);
    }
    
    static void dfs(int x, int y, int idx){
      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(idx == 0 && nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && map[x][y] == map[nx][ny]){
          visited[nx][ny] = true;
          dfs(nx, ny, idx);
        }
        else if(idx == 1 && nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && (map[nx][ny] == 'R' || map[nx][ny] == 'G')){
          visited[nx][ny] = true;
          dfs(nx, ny, idx);
        }
      }
    }
}