import java.io.*;
import java.util.*;

public class Main {
    static class Ball{
      int rx, ry, bx, by, depth;
      
      Ball(int rx, int ry, int bx, int by, int depth){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
      }
    }
    
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        for(int i = 0 ; i < N ; i++){
          String line = br.readLine();
          for(int j = 0 ; j < M ; j++){
            board[i][j] = line.charAt(j);
            if(board[i][j] == 'R'){
              rx = i;
              ry = j;
            } else if(board[i][j] == 'B'){
              bx = i;
              by = j;
            }
          }
        }
        
        System.out.print(bfs(rx, ry, bx, by));
    }
    
    static int bfs(int rx, int ry, int bx, int by){
      Queue<Ball> q = new LinkedList<>();
      q.offer(new Ball(rx, ry, bx, by, 0));
      visited[rx][ry][bx][by] = true;
      
      while(!q.isEmpty()){
        Ball cur = q.poll();
        
        if(cur.depth >= 10) return -1;
        
        for(int dir = 0; dir < 4; dir++){
          int[] red = move(cur.rx, cur.ry, dir);
          int[] blue = move(cur.bx, cur.by, dir);
          
          int nrx = red[0], nry = red[1], rc = red[2];
          int nbx = blue[0], nby = blue[1], bc = blue[2];
          
          if(board[nbx][nby] == 'O') continue;
          if(board[nrx][nry] == 'O') return cur.depth + 1; 
          
          if(nrx == nbx && nry == nby){
            if(rc > bc){
              nrx -= dx[dir];
              nry -= dy[dir];
            } else {
              nbx -= dx[dir];
              nby -= dy[dir];
            }
          }
          
          if(!visited[nrx][nry][nbx][nby]){
            visited[nrx][nry][nbx][nby] = true;
            q.offer(new Ball(nrx, nry, nbx, nby, cur.depth + 1));
          }
        }
      }
      return -1;
    }
    
    static int[] move(int x, int y, int dir){
      int cnt = 0;
      while(true){
        if(board[x + dx[dir]][y + dy[dir]] == '#' || board[x][y] == 'O') break;
        x += dx[dir];
        y += dy[dir];
        
        cnt++;
      }
      return new int[]{x, y, cnt};
    }
}
