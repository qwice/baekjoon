import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] board = new boolean[101][101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < N ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          int d = Integer.parseInt(st.nextToken());
          int g = Integer.parseInt(st.nextToken());
          dragon(x, y, d, g);
        }
        
        System.out.print(count());
    }
    
    static void dragon(int x, int y, int d, int g){
      List<Integer> list = new ArrayList<>();
      list.add(d);
      
      for(int i = 0 ; i < g ; i++){
        for(int j = list.size() - 1 ; j >=0 ; j--){
          int nd = (list.get(j) + 1) % 4;
          list.add(nd);
        }
      }
      
      board[y][x] = true;
      
      for(int dir : list){
        x += dx[dir];
        y += dy[dir];
        if(x >= 0 && y >= 0 && x < 101 && y < 101){
          board[y][x] = true;
        }
      }
    }
    
    static int count(){
      int c = 0;
      for(int i = 0 ; i < 100 ; i++){
        for(int j = 0 ; j < 100 ; j++){
          if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]) c++;
        }
      }
      return c;
    }
}
