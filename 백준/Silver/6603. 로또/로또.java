import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static int[] mA;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
          StringTokenizer st = new StringTokenizer(br.readLine());
          k = Integer.parseInt(st.nextToken());
          if(k == 0) return;
          
          arr = new int[k];
          mA = new int[6];
          
          for(int i = 0 ; i < k ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
          }
          
          makeLotto(0, 0);
          System.out.println();
        }
    }
    
    static void makeLotto(int count, int idx){
      if(count == 6){
        for(int i = 0 ; i < 6 ; i++){
          System.out.print(mA[i] + " ");
        }
        System.out.println();
        return;
      }
      
      for(int i = idx ; i < k ; i++){
        mA[count] = arr[i];
        makeLotto(count+1, i+1);
      }
    }
}
