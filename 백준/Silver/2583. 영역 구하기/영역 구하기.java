import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static List<Integer> list = new ArrayList<>();
    
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int ans = 0;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        visited = new boolean[M][N];
        visited2 = new boolean[M][N];
        
        for(int i = 0 ; i < K ; i++){
          st = new StringTokenizer(br.readLine());
          int c1 = Integer.parseInt(st.nextToken()); // 4
          int r1 = M - Integer.parseInt(st.nextToken()) - 1; // 0 > 4
          int c2 = Integer.parseInt(st.nextToken()); // 6
          int r2 = M - Integer.parseInt(st.nextToken()); // 2 > 3
          for(int j = r2; j <= r1 ; j++){
            for(int k = c1 ; k < c2 ; k++){
              map[j][k] = 1;
            }
          }
        }
        
        int count = 0;
        
        for(int i = 0 ; i < M ; i++){
          for(int j = 0 ; j < N ; j++){
            if(map[i][j] == 0 && !visited[i][j]){
              visited[i][j] = true;
              visited2[i][j] = true;
              dfs(i,j);
              count++;
              cnt();
            }
          }
        }
        
        Collections.sort(list);
        System.out.println(count);
        for(int i = 0 ; i < list.size() ; i++){
          System.out.print(list.get(i) + " ");
        }
    }
    
    static void dfs(int x, int y){
      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx >= 0 && ny>= 0 && nx < M && ny < N && !visited[nx][ny] && map[nx][ny] == 0){
          visited[nx][ny] = true;
          visited2[nx][ny] = true;
          dfs(nx, ny);
        }
      }
    }
    
    static void cnt(){
      int count = 0;
      for(int i = 0 ; i < M ; i++){
        for(int j = 0 ; j < N ; j++){
          if(visited2[i][j]) {
            count++;
            visited2[i][j] = false;
          }
        }
      }
      
      list.add(count);
    }
}
