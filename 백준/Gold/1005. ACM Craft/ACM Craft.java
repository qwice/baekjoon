import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());
          
          st = new StringTokenizer(br.readLine());
          int[] time = new int[N];
          for(int i = 0 ; i < N ; i++) {
            time[i] = Integer.parseInt(st.nextToken());
          }
          
          Map<Integer, List<Integer>> rel = new HashMap<>();
          for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            boolean check = rel.containsKey(b);
            List<Integer> list;
            if(check) {
              list = rel.get(b);
              list.add(a);
            } else {
              list = new ArrayList<>();
              list.add(a);
            }
            rel.put(b,list);
          }
          
          int target = Integer.parseInt(br.readLine());
          boolean[] isEnd = new boolean[N];
          int[] dp = new int[N]; // dp[i] , i번째 건물이 지어지는데 걸리는 시간
          int start = -1;
          for(int i = 0 ; i < N ; i++) {
            if(!rel.containsKey(i)) {
              start = i;
              break;
            }
          }
          
          dp[start] = time[start];
          isEnd[start] = true;
          boolean flag = true;
          
          for(int i = 0 ; i < N ; i++){
            if(!rel.containsKey(i)) {
              dp[i] = time[i];
              isEnd[i] = true;
            }
          }
          
          while(true) {
            // 종료 조건
            for(int i = 0 ; i < N ; i++){
              if(!isEnd[i]) break;
              else if(i == N - 1) flag = false;
            }
            if(!flag || isEnd[target-1]) break;
            
            for(int i = 0 ; i < N ; i++){
              boolean ch = true;
              if(i == start || !rel.containsKey(i)) continue;
              List<Integer> value = rel.get(i);
              int Sv = Integer.MIN_VALUE;
              
              for(int check : value) {
                if(!isEnd[check]) ch = false;
                else Sv = Math.max(Sv, dp[check]);
              }
              
              if(ch) {
                dp[i] = Sv + time[i];
                isEnd[i] = true;
              }
            }
          }
          
          System.out.println(dp[target-1]);
          
        }
    }
}
