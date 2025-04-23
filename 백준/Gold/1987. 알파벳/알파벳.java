import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static Set<Character> set = new HashSet<>();
    
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int ans = 0;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        visited = new boolean[r][c];
        
        for(int i = 0 ; i < r ; i++){
          String s = br.readLine();
          for(int j = 0 ; j < c ; j++){
            map[i][j] = s.charAt(j);
          }
        }
        
        visited[0][0] = true;
        set.add(map[0][0]);
        dfs(0, 0);
        
        System.out.print(ans);
    }
    
    static void dfs(int x, int y){
      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx >= 0 && ny >= 0 && nx < r && ny < c && !set.contains(map[nx][ny]) && !visited[nx][ny]){
          visited[nx][ny] = true;
          set.add(map[nx][ny]);
          dfs(nx, ny);
          visited[nx][ny] = false;
          set.remove(map[nx][ny]);
        }
      }
      
      ans = Math.max(ans, set.size());
    }
}
