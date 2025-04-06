import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> direction = new HashMap<>();
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        int K = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < K ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken()) - 1;
          int y = Integer.parseInt(st.nextToken()) - 1;
          board[x][y] = 1;
        }
        
        int L = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < L ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int time = Integer.parseInt(st.nextToken());
          char dir = st.nextToken().charAt(0);
          direction.put(time, dir);
        }
        
        System.out.print(simul());
    }
    
    static int simul(){
      Deque<Point> snake = new LinkedList<>();
      snake.add(new Point(0,0));
      int time = 0;
      int dir = 0;
      
      boolean[][] visited = new boolean[N][N];
      visited[0][0] = true;
      
      while(true){
        time++;
        
        Point head = snake.peekFirst();
        int nx = head.x + dx[dir];
        int ny = head.y + dy[dir];
        
        if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]){
          break;
        }
        
        if(board[nx][ny] == 1){
          board[nx][ny] = 0;
          snake.addFirst(new Point(nx, ny));
          visited[nx][ny] = true;
        } else{
          snake.addFirst(new Point(nx, ny));
          visited[nx][ny] = true;
          
          Point tail = snake.removeLast();
          visited[tail.x][tail.y] = false;
        }
        
        if(direction.containsKey(time)){
          char c = direction.get(time);
          if(c == 'L') dir = (dir + 3) % 4;
          else dir = (dir + 1) % 4;
        }
      }
      
      return time;
    }
    
    static class Point{
      int x, y;
      
      Point(int x, int y){
        this.x = x;
        this.y = y;
      }
    }
    
}
