import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] plus = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
          num[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0 ; i < n ; i++){
          plus[i] = num[i];
          for(int j = 0 ; j < i ; j++){
            if(num[j] < num[i] && plus[i] < plus[j] + num[i]){
              plus[i] = plus[j] + num[i];
            }
          }
        }
        
        int max = 0;
        for(int i = 0 ; i < n ;i++){
          max = Math.max(max, plus[i]);
        }
        
        System.out.print(max);
    }
}
