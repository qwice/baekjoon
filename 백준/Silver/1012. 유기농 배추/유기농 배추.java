import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[][] map;
    static int n, m;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> size = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < T ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          m = Integer.parseInt(st.nextToken());
          n = Integer.parseInt(st.nextToken());
          int k = Integer.parseInt(st.nextToken());
          
          map = new int[n][m];
          visited = new boolean[n][m];
          
          for(int j = 0 ; j < k ; j++){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
          }
          
          int idx = 0;
          
          for(int j = 0 ; j < n ; j++){
            for(int p = 0 ; p < m ; p++){
              if(map[j][p] == 1 && !visited[j][p]){
                bfs(j, p);
                idx++;
              }
            }
          }
          
          System.out.println(idx);
        }
    }
    
    static void bfs(int x, int y){
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{x, y});
      visited[x][y] = true;
      
      while(!q.isEmpty()){
        int[] cur = q.poll();
        
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = cur[0] + dx[dir];
          int ny = cur[1] + dy[dir];
          
          if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !visited[nx][ny]){
            q.add(new int[]{nx, ny});
            visited[nx][ny] = true;
          }
        }
      }
    }
}