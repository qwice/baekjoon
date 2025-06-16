import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int V;
    static int[] check;
    static boolean flag;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        
        while(K-- > 0){
          StringTokenizer st = new StringTokenizer(br.readLine());
          V = Integer.parseInt(st.nextToken());
          flag = true;
          int E = Integer.parseInt(st.nextToken());
          
          graph = new ArrayList[V+1];
          
          for(int i = 1 ; i <= V ; i++){
            graph[i] = new ArrayList<>();
          }
          
          for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
          }
          
          check = new int[V+1];
          
          for(int i = 1 ; i <= V ; i++){
            if(check[i] == 0) {
              check[i] = 1;
              dfs(i);
            }
          }
          
          System.out.println(flag ? "YES" : "NO");
        }
    }
    
    static void dfs(int start){
      for(int temp : graph[start]){
        if(check[temp] == 0) {
          check[temp] = -check[start];
          dfs(temp);
        } else if(check[temp] == check[start]) {
          flag = false;
          return;
        }
      }
    }
}
