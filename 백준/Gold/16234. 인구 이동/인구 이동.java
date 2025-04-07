import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int days = 0;
        
        while(true){
          visited = new boolean[N][N];
          boolean moved = false;
          
          for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
              if(!visited[i][j]){
                if(bfs(i, j)){
                  moved = true;
                }
              }
            }
          }
          
          if(!moved) break;
          
          days++;
        }
        
        System.out.print(days);        
    }
    
    static boolean bfs(int x, int y){
      Queue<int[]> q = new LinkedList<>();
      List<int[]> union = new ArrayList<>();
      q.add(new int[]{x, y});
      union.add(new int[]{x, y});
      visited[x][y] = true;
      
      int sum = map[x][y];
      
      while(!q.isEmpty()){
        int[] cur = q.poll();
        int cx = cur[0];
        int cy = cur[1];
        
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = cx + dx[dir];
          int ny = cy + dy[dir];
          
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(visited[nx][ny]) continue;
          
          int diff = Math.abs(map[nx][ny] - map[cx][cy]);
          if(diff >= L && diff <= R){
            q.add(new int[]{nx, ny});
            union.add(new int[]{nx, ny});
            visited[nx][ny] = true;
            sum += map[nx][ny];
          }
        }
      }
      
      if(union.size() == 1) return false;
        
      int newPop = sum / union.size();
        
      for(int[] arr : union){
        map[arr[0]][arr[1]] = newPop;
      }
      
      return true;
    }
}
