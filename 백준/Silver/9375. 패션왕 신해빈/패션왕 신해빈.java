import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
          int n = Integer.parseInt(br.readLine());
          map = new HashMap<>();
          
          for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + 1);
          }
          
          int count = 1;
          for(String s : map.keySet()){
            count = count * (map.get(s) + 1);
          }
          
          System.out.println(count - 1);
        }
    }
}
