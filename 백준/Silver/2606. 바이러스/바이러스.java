import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static List<Integer>[] graph;
    static int n, m;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1; i <= n ; i++){
          graph[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < m ; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          
          graph[a].add(b);
          graph[b].add(a);
        }
        
        visited[1] = true;
        bfs(1);
        
        int cnt = 0;
        
        for(int i = 1 ; i <= n ; i++){
          if(visited[i] == true) cnt++;
        }
        
        System.out.print(cnt - 1);
    }
    
    static void bfs(int v){
      Queue<Integer> q = new LinkedList<>();
      q.add(v);
      
      while(!q.isEmpty()){
        int curr = q.poll();
        
        for(int next : graph[curr]){
          if(!visited[next]){
            visited[next] = true;
            q.add(next);
          }
        }
      }
    }
}