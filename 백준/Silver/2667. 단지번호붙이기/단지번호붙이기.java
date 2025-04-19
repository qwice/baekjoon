import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[][] map;
    static int n;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> size = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i = 0 ; i < n ; i++){
          String s = br.readLine();
          for(int j = 0 ; j < n ; j++){
            map[i][j] = s.charAt(j) - '0';
          }
        }
        
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < n ; j++){
            if(map[i][j] == 1 && !visited[i][j]){
              bfs(i, j);
            }
          }
        }
        
        Collections.sort(size);
        System.out.println(size.size());
        for(int i = 0 ; i < size.size() ; i++){
          System.out.println(size.get(i));
        }
    }
    
    static void bfs(int x, int y){
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{x, y});
      visited[x][y] = true;
      int count = 0;
      
      while(!q.isEmpty()){
        int[] cur = q.poll();
        count++;
        
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = cur[0] + dx[dir];
          int ny = cur[1] + dy[dir];
          
          if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1 && !visited[nx][ny]){
            q.add(new int[]{nx, ny});
            visited[nx][ny] = true;
          }
        }
      }
      
      size.add(count);
    }
}