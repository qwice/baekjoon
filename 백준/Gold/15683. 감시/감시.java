import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    
    
    // >, <, 아, 위
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][][] dirs = {
      {},
      {{0}, {1}, {2}, {3}},
      {{0,1 }, {2,3}},
      {{0,2}, {1,2}, {1,3}, {0,3}},
      {{0,1,2},{1,2,3},{0,1,3},{0,2,3}},
      {{0,1,2,3}},
    };
    
    static class CCTV{
      int x, y, type;
      CCTV(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
      }
    }
    
    static List<CCTV> cctvs = new ArrayList<>();
    
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
            if(map[i][j] >= 1 && map[i][j] <=5){
              cctvs.add(new CCTV(i,j, map[i][j]));
            }
          }
        }
        
        dfs(0, map);
        System.out.print(min);
    }
    
    static void dfs(int depth, int[][] prevMap){
      if(depth == cctvs.size()){
        min = Math.min(min, countMin(prevMap));
        return;
      }
      
      CCTV cctv = cctvs.get(depth);
      int type = cctv.type;
      
      for(int[] dirSet : dirs[type]){
        int[][] copy = copymap(prevMap);
        for(int dir : dirSet){
          watch(copy, cctv.x, cctv.y, dir);
        }
        dfs(depth + 1, copy);
      }
    }
    
    static void watch(int[][] copy, int x, int y, int dir){
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      
      while(nx >= 0 && ny >= 0 && nx < N && ny < M){
        if(copy[nx][ny] == 0) copy[nx][ny] = -1;
        if(copy[nx][ny] == 6) break;
        nx += dx[dir];
        ny += dy[dir];
      }
    }
    
    static int[][] copymap(int[][] m){
      int[][] copied = new int[N][M];
      
      for(int i = 0 ; i < N ; i++){
        copied[i] = m[i].clone();
      }
      
      return copied;
    }
    
    static int countMin(int[][] m){
      int count = 0;
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < M ; j++){
          if(m[i][j] == 0) count++;
        }
      }
      
      return count;
    }
}
