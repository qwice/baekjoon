import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<Point> virus = new ArrayList<>();
    static int minT = Integer.MAX_VALUE;
    static int empty = 0;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static class Point{
      int x, y;
      Point(int x, int y){this.x = x; this.y = y;}
    }
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      lab = new int[N][N];
      
      for(int i = 0 ; i < N ; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < N ; j++){
          lab[i][j] = Integer.parseInt(st.nextToken());
          if(lab[i][j] == 2) virus.add(new Point(i, j));
          else if(lab[i][j] == 0) empty++;
        }
      }
      
      if(empty == 0) {
        System.out.print(0);
        return;
      }
      
      combination(new ArrayList<>(), 0);
      
      System.out.print(minT == Integer.MAX_VALUE ? -1 : minT);
    }
    
    static void combination(List<Point> selected, int start){
      if(selected.size() == M){
        bfs(selected);
        return;
      }
      
      for(int i = start ; i < virus.size(); i++){
        selected.add(virus.get(i));
        combination(selected, i+1);
        selected.remove(selected.size()-1);
      }
    }
    
    static void bfs(List<Point> onVir){
      Queue<Point> queue = new LinkedList<>();
      boolean[][] visited = new boolean[N][N];
      int[][] time = new int[N][N];
      
      for(Point p : onVir){
        queue.add(p);
        visited[p.x][p.y] = true;
      }
      
      int infect = 0;
      int maxT = 0;
      
      while(!queue.isEmpty()){
        Point point = queue.poll();
        
        for(int dir = 0 ; dir < 4; dir++){
          int nx = point.x + dx[dir];
          int ny = point.y + dy[dir];
          
          if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(visited[nx][ny] || lab[nx][ny] == 1) continue;
          
          visited[nx][ny] = true;
          
          time[nx][ny] = time[point.x][point.y] + 1;
          
          if(lab[nx][ny] == 0){
            infect++;
            maxT = time[nx][ny];
          }
          queue.add(new Point(nx, ny));
        }
      }
      
      if(infect == empty){
        minT = Math.min(minT, maxT);
      }
    }
}
