import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] map = new int[101][101];
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      for(int i = 1 ; i <= 3 ; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 1 ; j <= 3 ; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      int time = 0;
      int row = 3;
      int col = 3;
      
      while(time <= 100){
        if(map[r][c] == k){
          System.out.print(time);
          return;
        }
        
        if(row >= col){
          int maxCol = 0;
          for(int i = 1 ; i <= row ; i++){
            Map<Integer, Integer> m = new HashMap<>();
            for(int j = 1 ; j <= col ; j++){
              if(map[i][j] == 0) continue;
              m.put(map[i][j], m.getOrDefault(map[i][j], 0) + 1);
            }
            
            List<int[]> list = new ArrayList<>();
            for(int key : m.keySet()){
              list.add(new int[]{key, m.get(key)});
            }
            
            list.sort((a,b) -> {
              if(a[1] == b[1]) return a[0] - b[0];
              else return a[1] - b[1];
            });
            
            int idx = 1;
            for(int[] arr : list){
              if(idx > 100) break;
              map[i][idx++] = arr[0];
              if(idx > 100) break;
              map[i][idx++] = arr[1];
            }
            for(int j = idx ; j <= 100 ; j++) map[i][j] = 0;
            maxCol = Math.max(maxCol, idx - 1);
          }
          col = maxCol;
        }
        
        else {
          int maxRow = 0;
          for(int i = 1 ; i <= col ; i++){
            Map<Integer, Integer> m = new HashMap<>();
            for(int j = 1; j <= row ; j++){
              if(map[j][i] == 0) continue;
              m.put(map[j][i], m.getOrDefault(map[j][i], 0) + 1);
            }
            
            List<int[]> list = new ArrayList<>();
            
            for(int key : m.keySet()){
              list.add(new int[]{key, m.get(key)});
            }
            
            list.sort((a,b) -> {
              if(a[1] == b[1]) return a[0] - b[0];
              else return a[1] - b[1];
            });
            
            int idx = 1;
            for(int[] arr : list){
              if(idx > 100) break;
              map[idx++][i] = arr[0];
              if(idx > 100) break;
              map[idx++][i] = arr[1];
            }
            
            for(int j = idx ; j <= 100 ; j++) map[j][i] = 0;
            maxRow = Math.max(maxRow, idx - 1);
          }
          row = maxRow;
        }
        time++;
      }
      
      System.out.print(-1);
    }
}
