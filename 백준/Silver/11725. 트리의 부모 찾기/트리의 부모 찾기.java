import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static boolean[] visited;
    static int[] parent;
    static List<Integer>[] tree;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];
        
        for(int i = 1; i <= n ; i++){
          tree[i] = new ArrayList<>();
        }
        
        for(int i = 1 ; i < n ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          
          tree[a].add(b);
          tree[b].add(a);
        }
        
        dfs(1);
        
        for(int i = 2; i <= n ; i++){
          System.out.println(parent[i]);
        }
    }
    
    static void dfs(int v){
      visited[v] = true;
      
      for(int next : tree[v]){
        if(!visited[next]){
          parent[next] = v;
          dfs(next);
        }
      }
    }
    
}