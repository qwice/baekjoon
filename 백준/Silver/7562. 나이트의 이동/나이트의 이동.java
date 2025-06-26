import java.io.*;
import java.util.*;

public class Main {
    static int I;
    static int[][] map;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
          I = Integer.parseInt(br.readLine());
          map = new int[I][I];
          Deque<Point> q = new ArrayDeque<>();
          
          StringTokenizer st = new StringTokenizer(br.readLine());
          int sx = Integer.parseInt(st.nextToken());
          int sy = Integer.parseInt(st.nextToken());
          
          st = new StringTokenizer(br.readLine());
          int ex = Integer.parseInt(st.nextToken());
          int ey = Integer.parseInt(st.nextToken());
          
          if (sx == ex && sy == ey) {
            System.out.println(0);
            continue;
          }
          
          Point start = new Point(sx, sy);
          q.push(start);
          map[sx][sy] = 1;
          
          while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0 ; i < 8 ; i++){
              int nx = cur.x + dx[i];
              int ny = cur.y + dy[i];
              
              if(nx >= 0 && ny >= 0 && nx < I && ny < I && map[nx][ny] == 0){
                if (nx == ex && ny == ey) {
                  System.out.println(map[cur.x][cur.y]);
                  q.clear();
                  break;
                }
                map[nx][ny] = map[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));
              }
            }
          }
        }
    }
}
