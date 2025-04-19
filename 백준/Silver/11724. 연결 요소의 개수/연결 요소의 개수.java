import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static boolean[] visited;
    
    static List<Integer>[] list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 1 ; i <= n ; i++){
          list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < m ; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          
          list[a].add(b);
          list[b].add(a);
        }
        
        for(int i = 1; i <= n ;i++){
          if(!visited[i]) {
            dfs(i);
            cnt++;
          }
        }
        
        System.out.print(cnt);
    }
    
    static void dfs(int v){
      visited[v] = true;
      
      for(int next : list[v]){
        if(!visited[next]) dfs(next);
      }
    }
}