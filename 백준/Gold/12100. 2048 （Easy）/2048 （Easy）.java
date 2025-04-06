import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        for(int i = 0 ; i < N ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            board[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        dfs(0, board);
        System.out.print(max);
    }
    
    static void dfs(int depth, int[][] board){
      if(depth == 5){
        max = Math.max(max, getMax(board));
        return;
      }
      
      for(int dir = 0 ; dir < 4 ; dir++){
        int[][] newBoard = move(dir, board);
        dfs(depth + 1, newBoard);
      }
    }
    
    static int[][] move(int dir, int[][] board){
      int[][] newBoard = new int[N][N];
      
      for(int i = 0 ; i < N ; i++){
        int[] line = new int[N];
        for(int j = 0 ; j < N ; j++){
          int value = 0;
          if(dir == 0) value = board[j][i];
          else if(dir == 1) value = board[N - 1 - j][i];
          else if(dir == 2) value = board[i][j];
          else value = board[i][N - 1 - j];
          line[j] = value;
        }
        
        int[] merged = merge(line);
        
        for(int j = 0 ; j < N ; j++){
          if(dir == 0) newBoard[j][i] = merged[j];
          else if(dir == 1) newBoard[N - 1 - j][i] = merged[j];
          else if(dir == 2) newBoard[i][j] = merged[j];
          else newBoard[i][N - 1 - j] = merged[j];
        }
      }
      
      return newBoard;
    }
    
    static int[] merge(int[] line){
      List<Integer> list = new LinkedList<>();
      int prev = 0;
      
      for(int i = 0 ; i < N ; i++){
        if(line[i] == 0) continue;
        if(prev == 0) {
          prev = line[i];
        } else {
          if(prev == line[i]){
            list.add(prev * 2);
            prev = 0;
          } else {
            list.add(prev);
            prev = line[i];
          }
        }
      }
      
      if(prev != 0) list.add(prev);
      
      int[] result = new int[N];
      
      for(int i = 0 ; i < list.size() ; i++){
        result[i] = list.get(i);
      }
      
      return result;
    }
    
    static int getMax(int[][] board){
      int MAX = 0;
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
          MAX = Math.max(MAX, board[i][j]);
        }
      }
      
      return MAX;
    }
}
