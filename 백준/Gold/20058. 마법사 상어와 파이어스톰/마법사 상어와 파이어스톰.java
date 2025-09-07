import java.util.*;
import java.io.*;

public class Main {
    static int N, Q, size, sum = 0, nowCnt, bigestCnt;
    static int[][] map, nMap, checkedMap;
    static int[] L;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      Q = Integer.parseInt(st.nextToken());
      
      size = (int)Math.pow(2, N);
      map = new int[size][size];
      nMap = new int[size][size];
      checkedMap = new int[size][size];
      visited = new boolean[size][size];
      L = new int[Q];
      
      for(int i = 0 ; i < size ; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < size ; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i = 0 ; i < Q ; i++){
        L[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i = 0 ; i < Q ; i++) {
        for(int j = 0 ; j < size ; j += (int)Math.pow(2, L[i])) {
          for(int k = 0 ; k < size ; k += (int)Math.pow(2,L[i])) {
            rotate(j, k, (int)Math.pow(2, L[i]));
          }
        }
        copy();
        
        for(int j = 0 ; j < size ; j++) {
          for(int k = 0 ; k < size ; k++) {
            if(!count(j, k) && map[j][k] > 0) nMap[j][k] = map[j][k] - 1;
            else nMap[j][k] = map[j][k];
          }
        }
        copy();
      }
      
      for(int j = 0 ; j < size ; j++) {
          for(int k = 0 ; k < size ; k++) {
            sum += map[j][k];
          }
      }
      System.out.println(sum);
      
      
      
      for(int i = 0 ; i < size ; i++){
        for(int j = 0 ; j < size ; j++){
          nowCnt = 0;
          if(!visited[i][j] && map[i][j] > 0) dfs(i,j);
          bigestCnt = Math.max(nowCnt, bigestCnt);
        }
      }
      
      System.out.print(bigestCnt);
    }
    
    static void dfs(int x, int y){
      visited[x][y] = true;
      nowCnt++;

      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
        if(map[nx][ny] > 0 && !visited[nx][ny]) dfs(nx, ny);
      }
    }
    
    static void copy(){
      for(int i = 0 ; i < size ; i++){
        for(int j = 0 ; j < size ; j++){
          map[i][j] = nMap[i][j];
        }
      }
      
      for(int[] l : nMap){
        Arrays.fill(l, 0);
      }
    }
    
    static void rotate(int x, int y, int l){
      int[][] miniMap = new int[l][l];
      int[][] rotateMiniMap = new int[l][l];
      for(int i = x, t = 0 ; i < x + l ; i++, t++){
        for(int j = y, k = 0 ; j < y + l ; j++, k++){
          miniMap[t][k] = map[i][j];
        }
      }
      for(int i = 0 ; i < l ; i++){
        for(int j = 0 ; j < l ; j++){
          rotateMiniMap[j][l-1-i] = miniMap[i][j];
        }
      }
      
      for(int i = x, t = 0 ; i < x + l ; i++, t++){
        for(int j = y, k = 0 ; j < y + l ; j++, k++){
          nMap[i][j] = rotateMiniMap[t][k];
        }
      }
    }
    
    static boolean count(int x, int y) {
      int cnt = 0;
      for(int dir = 0 ; dir < 4 ; dir++){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
        if(map[nx][ny] > 0) cnt++;
      }
      
      if(cnt >= 3) return true;
      return false;
    }
}