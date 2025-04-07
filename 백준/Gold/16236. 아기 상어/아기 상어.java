import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int sharkX, sharkY, sharkS = 2, eat = 0, time = 0;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static class Fish{
      int x, y, dist;
      Fish(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
      }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for(int i = 0 ; i < N ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            if(map[i][j] == 9){
              sharkX = i;
              sharkY = j;
              map[i][j] = 0;
            }
          }
        }
        
        while(true){
          Fish fish = bfs();
          
          if(fish == null) break;
          
          sharkX = fish.x;
          sharkY = fish.y;
          eat++;
          time += fish.dist;
          
          map[sharkX][sharkY] = 0;
          
          if(eat == sharkS){
            sharkS++;
            eat = 0;
          }
        }
        
        System.out.print(time);
    }
    
    static Fish bfs(){
      visited = new boolean[N][N];
      Queue<int[]> q = new LinkedList<>();
      List<Fish> fishL = new ArrayList<>();
      
      q.add(new int[]{sharkX, sharkY, 0});
      visited[sharkX][sharkY] = true;
      
      while(!q.isEmpty()){
        int[] cur = q.poll();
        int x = cur[0], y = cur[1], dist = cur[2];
        
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = x + dx[dir];
          int ny = y + dy[dir];
          
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(visited[nx][ny]) continue;
          
          if(map[nx][ny] <= sharkS){
            visited[nx][ny] = true;
            if(map[nx][ny] > 0 && map[nx][ny] < sharkS){
              fishL.add(new Fish(nx, ny, dist + 1));
            }
            q.add(new int[]{nx, ny, dist + 1});
          }
        }
      }
      
      if(fishL.isEmpty()) return null;
      
      fishL.sort((a, b) -> {
        if (a.dist == b.dist) {
            if (a.x == b.x) {
                return a.y - b.y; // 같은 행이면 열이 작은 순
            }
            return a.x - b.x; // 행이 작은 순
        }
        return a.dist - b.dist; // 거리 짧은 순
      });

      
      return fishL.get(0);
    }
}
