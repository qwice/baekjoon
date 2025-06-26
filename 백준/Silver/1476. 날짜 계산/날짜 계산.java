import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(E == 1 && S == 1 && M == 1){
          System.out.print(1);
          return;
        }
        int x = 1;
        int y = 1;
        int z = 1;
        int result = 1;
        
        while(true) {
          x++;
          y++;
          z++;
          result++;
          x = x > 15 ? 1 : x;
          y = y > 28 ? 1 : y;
          z = z > 19 ? 1 : z;
          
          if(x == E && y == S && z == M) {
            System.out.print(result);
            return;
          }
        }
        
    }
}
