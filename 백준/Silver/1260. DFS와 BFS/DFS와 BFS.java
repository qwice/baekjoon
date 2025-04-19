import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n+1];
        
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < m ; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          graph[a].add(b);
          graph[b].add(a);
        }
        
        for(int i = 1; i <= n ; i++){
          Collections.sort(graph[i]);
        }
        
        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");
        
        visited = new boolean[n+1];
        bfs(v);
        
        System.out.print(sb);
    }
    
    static void dfs(int v){
      visited[v] = true;
      sb.append(v).append(" ");
      
      for(int next : graph[v]){
        if(!visited[next]){
          dfs(next);
        }
      }
    }
    
    static void bfs(int v){
      visited[v] = true;
      Queue<Integer> q = new LinkedList<>();
      q.offer(v);
      
      while(!q.isEmpty()){
        int curr = q.poll();
        sb.append(curr).append(" ");
        
        for(int next : graph[curr]){
          if(!visited[next]){
            q.offer(next);
            visited[next] = true;
          }
        }
      }
      
    }
}