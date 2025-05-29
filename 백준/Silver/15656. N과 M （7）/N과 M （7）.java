import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static List<Integer> selected = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0);
        System.out.print(sb);
    }
    
    static void dfs(int depth) {
      if(depth == M){
        for(int i = 0 ; i < M ; i++){
          //System.out.print(selected.get(i) + " ");
            sb.append(selected.get(i)).append(" ");
        }
        sb.append("\n");
        //System.out.println();
        return;
      }
      
      for(int i = 0 ; i < N ; i++){
          selected.add(arr[i]);
          dfs(depth+1);
          selected.remove(selected.size() - 1);
      }
    }
}
