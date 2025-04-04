import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] dist = new int[N-1];
        int[] price = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N - 1 ; i++){
          dist[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          price[i] = Integer.parseInt(st.nextToken());
        }
        
        int minPrice = price[0];
        int totalCost = 0;
        
        for(int i = 0 ; i < N - 1 ; i++){
          totalCost += minPrice * dist[i];
          
          if(minPrice > price[i+1]) minPrice = price[i+1];
        }
        
        System.out.print(totalCost);
    }
}
