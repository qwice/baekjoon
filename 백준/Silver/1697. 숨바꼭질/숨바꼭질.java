import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] time = new int[200000];
        
        q.add(N);
        time[N] = 1;
        
        while(!q.isEmpty()){
          int cur = q.poll();
          if(cur == K) {
            System.out.print(time[cur] - 1);
            return;
          }
          
          int[] next = {cur - 1, cur + 1, cur * 2};
          for(int nx : next){
            if(nx >= 0 && nx < 200000 && time[nx] == 0) {
              time[nx] = time[cur] + 1;
              q.add(nx);
            }
          }
        }
    }
}
