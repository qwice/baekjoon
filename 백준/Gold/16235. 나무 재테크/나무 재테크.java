import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] nutri, A;
    static Deque<Integer>[][] trees;
    
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        nutri = new int[N][N];
        trees = new ArrayDeque[N][N];
        
        for(int i = 0 ; i < N ; i++){
          st = new StringTokenizer(br.readLine());
          for(int j = 0 ; j < N ; j++){
            A[i][j] = Integer.parseInt(st.nextToken());
            nutri[i][j] = 5;
            trees[i][j] = new ArrayDeque<>();
          }
        }
        
        for(int i = 0 ; i < M ; i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken()) - 1;
          int y = Integer.parseInt(st.nextToken()) - 1;
          int age = Integer.parseInt(st.nextToken());
          trees[x][y].add(age);
        }
        
        for(int i = 0 ; i < K ; i++){
          SAS();
          F();
          W();
        }
        
        int count = 0;
        
        for(int i = 0 ; i < N ; i++){
          for(int j = 0 ; j < N ; j++){
            count += trees[i][j].size();
          }
        }
        
        System.out.print(count);
    }
    
    static void SAS(){
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
          int dead = 0;
          
          List<Integer> sort = new ArrayList<>(trees[i][j]);
          Collections.sort(sort);
          trees[i][j].clear();
          
          for(int age : sort){
            if(nutri[i][j] >= age){
              nutri[i][j] -= age;
              trees[i][j].add(age+1);
            } else {
              dead += age / 2;
            }
          }
          
          nutri[i][j] += dead;
        }
      }
    }
    
    static void F(){
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
          for(int age : trees[i][j]){
            if(age % 5 == 0){
              for(int dir = 0 ; dir < 8 ; dir++){
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                  trees[nx][ny].addFirst(1);
                }
              }
            }
          }
        }
      }
    }
    
    static void W(){
      for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
          nutri[i][j] += A[i][j];
        }
      }
    }
}
