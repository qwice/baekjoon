import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[][] map;
    static int[][] cnt;
    static int n, m;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cnt = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
          String s = br.readLine();
          for(int j = 0 ; j < m ;j++){
            map[i][j] = s.charAt(j) - '0';
          }
        }
        cnt[0][0] = 1;
        bfs(0, 0);
        System.out.print(cnt[n-1][m-1]);
    }
    
    static void bfs(int x, int y){
      visited[x][y] = true;
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{x, y});
      
      while(!q.isEmpty()){
        int[] p = q.poll();
        
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = p[0] + dx[dir];
          int ny = p[1] + dy[dir];
          
          if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0){
            q.add(new int[]{nx, ny});
            visited[nx][ny] = true;
            cnt[nx][ny] = cnt[p[0]][p[1]] + 1;
          }
        }
      }
    }
}