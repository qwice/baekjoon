import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> empty = new ArrayList<>();
    static List<Point> virus = new ArrayList<>();
    static int max = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Point{
      int x, y;
      Point(int x, int y){this.x = x; this.y = y;}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < M ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
            if(map[i][j] == 0) empty.add(new Point(i, j));
            else if(map[i][j] == 2) virus.add(new Point(i, j));
          }
        }
        
        combination(0, 0, new Point[3]);
        
        System.out.print(max);
    }
    
    static void combination(int start, int depth, Point[] selected){
      if(depth == 3){
        simulation(selected);
        return;
      }
      
      for(int i = start ; i < empty.size() ; i++){
        selected[depth] = empty.get(i);
        combination(i + 1, depth + 1, selected);
      }
    }
    
    static void simulation(Point[] walls){
      int[][] tempMap = copyMap();
      
      for(Point v : walls){
        tempMap[v.x][v.y] = 1;
      }
      
      Queue<Point> q = new LinkedList<>();
      for(Point v : virus){
        q.add(v);
      }
      
      while(!q.isEmpty()){
        Point cur = q.poll();
        for(int dir = 0 ; dir < 4 ; dir++){
          int nx = cur.x + dx[dir];
          int ny = cur.y + dy[dir];
          if(nx >= 0 && ny >= 0 && nx < N && ny < M){
            if(tempMap[nx][ny] == 0){
              tempMap[nx][ny] = 2;
              q.add(new Point(nx, ny));
            }
          }
        }
      }
      
      int safe = 0;
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M ; j++){
          if(tempMap[i][j] == 0) safe++;
        }
      }
      max = Math.max(safe, max);
    }
    
    static int[][] copyMap(){
      int[][] copied = new int[N][M];
      for(int i = 0 ; i < N ; i++){
        copied[i] = map[i].clone();
      }
      
      return copied;
    }
}
