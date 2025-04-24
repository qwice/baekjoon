import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }
        
        make(0, 0, 0);
        
        System.out.print(ans);
    }
    
    static void make(int count, int idx, int sum){
      if(count != 0 && sum == S) ans++;
      
      for(int i = idx ; i < N ; i++){
        sum += arr[i];
        make(count+1, i+1, sum);
        sum -= arr[i];
      }
    }
}
