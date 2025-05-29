import java.io.*;
import java.util.*;

public class Main {
  
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> selected = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0, 0);
    }
    
    static void dfs(int depth, int index) {
      if(depth == M){
        for(int i = 0 ; i < M ; i++){
          System.out.print(selected.get(i) + " ");
        }
        System.out.println();
        return;
      }
      
      for(int i = index ; i < N ; i++){
        if(!visited[i]) {
          visited[i] = true;
          selected.add(arr[i]);
          dfs(depth+1, i + 1);
          selected.remove(selected.size() - 1);
          visited[i] = false;
        }
      }
    }
}
