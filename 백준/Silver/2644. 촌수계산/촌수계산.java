import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> parent = new HashMap<>();
    static Map<Integer, List<Integer>> child = new HashMap<>();
    static boolean[] visited;
    static int a, b;
    static int result = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        
        for(int i = 1 ; i <= n ; i++){
          parent.put(i, new ArrayList<>());
          child.put(i, new ArrayList<>());
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        int rel = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < rel ; i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          List<Integer> p = parent.get(x);
          List<Integer> c = child.get(y);
          p.add(y);
          c.add(x);
          parent.put(x, p);
          child.put(y, c);
        }
        
        // for(int i = 1 ; i <= n ; i++){
        //   System.out.println("P : " + i + " " + parent.get(i));
        //   if(parent.get(i).isEmpty()) System.out.println("Pnull");
        //   System.out.println("C : " + i + " " + child.get(i));
        //   if(child.get(i).isEmpty()) System.out.println("Cnull");
        // }
        
        visited[a] = true;
        dfs(a, 0);
        System.out.print(result);
    }
    
    static void dfs(int start, int count) {
      // System.out.println("start : " + start + " count : " + count);
      if(start == b) {
        result = count;
        return;
      }
      
      for(int temp : parent.get(start)) {
        if(!parent.get(temp).isEmpty() && !visited[temp]) {
          visited[temp] = true;
          dfs(temp, count+1);
          visited[temp] = false;
        } else if(!child.get(temp).isEmpty() && !visited[temp]) {
          visited[temp] = true;
          dfs(temp, count+1);
          visited[temp] = false;
        }
      }
      for(int temp : child.get(start)) {
        if(!parent.get(temp).isEmpty() && !visited[temp]) {
          visited[temp] = true;
          dfs(temp, count+1);
          visited[temp] = false;
        } else if(!child.get(temp).isEmpty() && !visited[temp]) {
          visited[temp] = true;
          dfs(temp, count+1);
          visited[temp] = false;
        }
      }
    }
}
